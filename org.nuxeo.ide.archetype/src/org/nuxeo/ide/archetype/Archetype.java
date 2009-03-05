/*
 * (C) Copyright 2006-2008 Nuxeo SAS (http://nuxeo.com/) and contributors.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:
 *     bstefanescu
 *     stan
 */

package org.nuxeo.ide.archetype;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * 
 * An archetype is a kind of template for creating new templates.
 * 
 * In RCP : getAvailableVars, display in the ui, get the map<String key, String
 * value> and pass it to the "doProcess Expand vars to start the replace".
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * @author <a href="mailto:stan@nuxeo.com">Sun Seng David TAN</a>
 * 
 */
public class Archetype {

    // Default buffer settings
    private static final int BUFFER_SIZE = 1024 * 64; // 64K

    private static final int MAX_BUFFER_SIZE = 1024 * 1024; // 64K

    private static final int MIN_BUFFER_SIZE = 1024 * 8; // 64K

    List<ArchetypeVar> archetypeVars = null;

    Element elVars = null;

    Element elRes = null;

    File archive;

    public void doProcess(Map<String, String> values, String outDir)
            throws Exception {

        outDir = expandVars(outDir, values);
        File out = new File(outDir);

        /* Do not exist if the target exist */
        // if (out.exists()) {
        // System.out.println("Target directory already exists: " + out);
        // System.out.println("Please specify as target a directory to be created. Exiting.");
        // System.exit(1);
        // }
        unzip(archive, out);
        new File(out, "archetype.xml").delete();
        if (elRes != null) {
            processResources(elRes, out, values);
        }

    }

    // to
    public List<ArchetypeVar> getAvailableVars(Map<String, String> values) {

        if (archetypeVars == null) {
            archetypeVars = new ArrayList<ArchetypeVar>();

            Node node = elVars.getFirstChild();
            while (node != null) {
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) node;
                    if ("var".equals(el.getNodeName())) {
                        String key = el.getAttribute("name");
                        String label = el.getAttribute("label");
                        if (label == null) {
                            label = key;
                        }
                        String promptStr = el.getAttribute("prompt");
                        boolean prompt = new Boolean(promptStr);
                        String requiredStr = el.getAttribute("required");
                        boolean required = new Boolean(requiredStr);
                        String def = el.getAttribute("default");
                        // see if the default is a variable, and try replacing
                        // by a already added one
                        def = expandVars(def, values);
                        // put vals in a map
                        archetypeVars.add(new ArchetypeVar(label, key, def,
                                prompt, required));

                        // add to vars for default or batch mode ?
                        values.put(key, def);
                    }
                }
                node = node.getNextSibling();
            }

        }
        return archetypeVars;
    }

    /**
     * load file in the Document doc
     * 
     * @param tpl
     * @param out
     * @throws Exception
     */
    public File loadFile(String tpl) throws Exception {
        archive = new File(tpl);

        return archive;
    }

    public Document loadDocFromZip(File archive) throws Exception {
        ZipFile zip = new ZipFile(archive);
        ZipEntry entry = zip.getEntry("archetype.xml");
        if (entry == null) {
            System.err.println("Invalid archetype zip.");
            throw new Exception("Invalid archetype zip.");
        }
        // load archetype definition
        InputStream in = new BufferedInputStream(zip.getInputStream(entry));
        Document doc = load(in);
        zip.close();
        // setting up elVars and elRes
        settingUp(doc);
        return doc;
    }

    protected void settingUp(Document doc) {
        Element root = doc.getDocumentElement();
        Node node = root.getFirstChild();

        while (node != null) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) node;
                if ("vars".equals(el.getNodeName())) {
                    elVars = el;
                } else if ("resources".equals(el.getNodeName())) {
                    elRes = el;
                }
            }
            node = node.getNextSibling();
        }
    }

    protected String expandVars(String expression, Map<?, ?> properties) {
        int p = expression.indexOf("${");
        if (p == -1) {
            return expression; // do not expand if not needed
        }

        char[] buf = expression.toCharArray();
        StringBuilder result = new StringBuilder(buf.length);
        if (p > 0) {
            result.append(expression.substring(0, p));
        }
        StringBuilder varBuf = new StringBuilder();
        boolean dollar = false;
        boolean var = false;
        for (int i = p; i < buf.length; i++) {
            char c = buf[i];
            switch (c) {
            case '$':
                dollar = true;
                break;
            case '{':
                if (dollar) {
                    dollar = false;
                    var = true;
                } else {
                    result.append(c);
                }
                break;
            case '}':
                if (var) {
                    var = false;
                    String varName = varBuf.toString();
                    varBuf.setLength(0);
                    // get the variable value
                    Object varValue = properties.get(varName);
                    if (varValue != null) {
                        result.append(varValue.toString());
                    } else { // let the variable as is
                        result.append("${").append(varName).append('}');
                    }
                } else {
                    result.append(c);
                }
                break;
            default:
                if (var) {
                    varBuf.append(c);
                } else {
                    result.append(c);
                }
                break;
            }
        }
        return result.toString();
    }

    public void processResources(Element root, File dir,
            Map<String, String> vars) throws Exception {
        Node node = root.getFirstChild();
        while (node != null) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) node;
                if ("directory".equals(el.getNodeName())) {
                    String srcName = el.getAttribute("src");
                    if (srcName == null) {
                        throw new IllegalArgumentException(
                                "directory has no src attribute");
                    }
                    String targetName = el.getAttribute("target");
                    if (targetName == null) {
                        throw new IllegalArgumentException(
                                "directory has no target attribute");
                    }
                    srcName = expandVars(srcName, vars);
                    targetName = expandVars(targetName, vars);
                    File src = new File(dir, srcName);
                    File dst = new File(dir, targetName);
                    System.out.println("Renaming " + src + " to " + dst);
                    src.renameTo(dst);
                } else if ("package".equals(el.getNodeName())) {
                    String srcName = el.getAttribute("src");
                    if (srcName == null) {
                        throw new IllegalArgumentException(
                                "package has no src attribute");
                    }
                    String targetName = el.getAttribute("target");
                    if (targetName == null) {
                        throw new IllegalArgumentException(
                                "package has no target attribute");
                    }
                    srcName = expandVars(srcName, vars);
                    targetName = expandVars(targetName, vars);
                    targetName = targetName.replaceAll("\\.", "/");
                    File src = new File(dir, srcName);
                    File dst = new File(dir, targetName);
                    System.out.println("Renaming " + src + " to " + dst);
                    dst.getParentFile().mkdirs();
                    src.renameTo(dst);
                } else if ("template".equals(el.getNodeName())) {
                    String srcName = el.getAttribute("src");
                    if (srcName == null) {
                        throw new IllegalArgumentException(
                                "rename has no src attribute");
                    }
                    File src = new File(dir, srcName);
                    System.out.println("Processing " + src);
                    expandVars(src, vars);
                }
            }
            node = node.getNextSibling();
        }
    }

    private void expandVars(File file, Map<?, ?> vars) throws IOException {

        String content = readFile(file);
        content = expandVars(content, vars);
        writeFile(file, content);
    }

    public static Document load(File file) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(file);
    }

    public static Document load(InputStream in) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(in);
    }

    public static String readFile(File file) throws IOException {
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            return read(in);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public static String read(InputStream in) throws IOException {
        StringBuilder sb = new StringBuilder();
        byte[] buffer = createBuffer(in.available());
        try {
            int read;
            while ((read = in.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, read));
            }
        } finally {
            in.close();
        }
        return sb.toString();
    }

    private static byte[] createBuffer(int preferredSize) {
        if (preferredSize < 1) {
            preferredSize = BUFFER_SIZE;
        }
        if (preferredSize > MAX_BUFFER_SIZE) {
            preferredSize = MAX_BUFFER_SIZE;
        } else if (preferredSize < MIN_BUFFER_SIZE) {
            preferredSize = MIN_BUFFER_SIZE;
        }
        return new byte[preferredSize];
    }

    public static void writeFile(File file, byte[] buf) throws IOException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(buf);
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }

    public static void writeFile(File file, String buf) throws IOException {
        writeFile(file, buf.getBytes());
    }

    public static void unzip(ZipInputStream in, File dir) throws IOException {
        dir.mkdirs();
        ZipEntry entry = in.getNextEntry();
        while (entry != null) {
            // System.out.println("Extracting "+entry.getName());
            File file = new File(dir, entry.getName());
            if (entry.isDirectory()) {
                file.mkdirs();
            } else {
                file.getParentFile().mkdirs();
                copyToFile(in, file);
            }
            entry = in.getNextEntry();
        }
    }

    public static void copyToFile(InputStream in, File file) throws IOException {
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            byte[] buffer = createBuffer(in.available());
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public static void unzip(File zip, File dir) throws IOException {
        ZipInputStream in = null;
        try {
            in = new ZipInputStream(new BufferedInputStream(
                    new FileInputStream(zip)));
            unzip(in, dir);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

}
