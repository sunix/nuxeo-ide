/*
 * (C) Copyright 2006-2010 Nuxeo SAS (http://nuxeo.com/) and contributors.
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
 */
package org.nuxeo.ide.sdk.templates;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.core.runtime.Platform;
import org.nuxeo.ide.sdk.NuxeoSDK;
import org.nuxeo.ide.sdk.templates.cmd.AppendCommand;
import org.nuxeo.ide.sdk.templates.cmd.BinaryResourceCommand;
import org.nuxeo.ide.sdk.templates.cmd.Command;
import org.nuxeo.ide.sdk.templates.cmd.DependenciesCommand;
import org.nuxeo.ide.sdk.templates.cmd.JavaClassCommand;
import org.nuxeo.ide.sdk.templates.cmd.MkdirCommand;
import org.nuxeo.ide.sdk.templates.cmd.OrganizeImportsCommand;
import org.nuxeo.ide.sdk.templates.cmd.RenameCommand;
import org.nuxeo.ide.sdk.templates.cmd.ResourceBundleCommand;
import org.nuxeo.ide.sdk.templates.cmd.ResourceCommand;
import org.nuxeo.ide.sdk.templates.cmd.ResourcePathCommand;
import org.nuxeo.ide.sdk.templates.cmd.SelectCommand;
import org.nuxeo.ide.sdk.templates.cmd.SourcePathCommand;
import org.nuxeo.ide.sdk.templates.cmd.TransformCommand;
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;

/**
 * Manage project templates.
 * 
 * At plugin start it loads project templates contributed by fragments.
 * <p>
 * Binds template registry to the corresponding target version.
 * <p>
 * TODO: track bundles to update the registry as new bundles are installed or
 * existing bundles are removed.
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class TemplateManager {

    public final static String ANY_VERSION = "0.0.0";

    protected Map<String, TemplateRegistry> regs;

    protected TemplateEngine engine;

    protected Map<String, Class<? extends ElementHandler>> commands;

    public TemplateManager() {
        regs = new HashMap<String, TemplateRegistry>();
        engine = new FreemarkerEngine();
        commands = new HashMap<String, Class<? extends ElementHandler>>();
        initCommands();
    }

    protected void initCommands() {
        commands.put("rename", RenameCommand.class);
        commands.put("mkdir", MkdirCommand.class);
        commands.put("transform", TransformCommand.class);
        commands.put("append", AppendCommand.class);
        commands.put("select", SelectCommand.class);
        commands.put("dependencies", DependenciesCommand.class);
        commands.put("source-path", SourcePathCommand.class);
        commands.put("resource-path", ResourcePathCommand.class);
        commands.put("resource", ResourceCommand.class);
        commands.put("binaryResource", BinaryResourceCommand.class);
        commands.put("javaClass", JavaClassCommand.class);
        commands.put("resourceBundle", ResourceBundleCommand.class);
        commands.put("organizeImports", OrganizeImportsCommand.class);
    }

    public void addCommand(String key, Class<? extends Command> type) {
        commands.put(key, type);
    }

    @SuppressWarnings("unchecked")
    public ElementHandler getCommand(String key) throws Exception {
        Class<? extends ElementHandler> type = commands.get(key);
        if (type == null) {
            type = (Class<? extends ElementHandler>) Class.forName(key);
        }
        return type.newInstance();
    }

    public TemplateEngine getEngine() {
        return engine;
    }

    public synchronized void addRegistry(String targetVersion,
            TemplateRegistry registry) {
        regs.put(targetVersion, registry);
    }

    public synchronized TemplateRegistry getRegistry(String targetVersion) {
        TemplateRegistry reg = regs.get(targetVersion);
        if (reg == null) {
            reg = regs.get(ANY_VERSION);
        }
        return reg;
    }

    public TemplateRegistry getDefaultRegistry() {
        NuxeoSDK sdk = NuxeoSDK.getDefault();
        if (sdk == null) {
            return null;
        }
        String v = sdk.getInfo().getVersion();
        if (v == null) {
            v = "0.0.0";
        } else if (v.endsWith("-SNAPSHOT")) {
            v = v.substring(0, v.length() - "-SNAPSHOT".length());
        }
        return getRegistry(v);
    }

    public void loadRegistry(Bundle bundle) {
        synchronized (this) {
            if (!regs.isEmpty()) {
                regs = new HashMap<String, TemplateRegistry>();
            }
        }
        Bundle[] bundles = Platform.getFragments(bundle);
        if (bundles == null) {
            return;
        }
        for (Bundle fragment : bundles) {
            URL url = fragment.getEntry("templates.xml");
            if (url != null) {
                try {
                    TemplateRegistry reg = loadRegistry(fragment, url);
                    regs.put(reg.getVersion(), reg);
                } catch (Exception e) {
                    e.printStackTrace(); // TODO log
                }
            }
        }
    }

    public TemplateRegistry loadRegistry(Bundle bundle, File file)
            throws Exception {
        InputStream in = new FileInputStream(file);
        try {
            return loadRegistry(bundle, in);
        } finally {
            in.close();
        }
    }

    public TemplateRegistry loadRegistry(Bundle bundle, URL url)
            throws Exception {
        InputStream in = url.openStream();
        try {
            return loadRegistry(bundle, in);
        } finally {
            in.close();
        }
    }

    public TemplateRegistry loadRegistry(Bundle bundle, InputStream in)
            throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(in);
        TemplateRegistry reg = TemplateRegistry.load(this,
                document.getDocumentElement());
        reg.bundle = bundle;
        return reg;
    }

}
