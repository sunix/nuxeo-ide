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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import org.nuxeo.ide.common.IOUtils;

import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class FreemarkerEngine implements TemplateEngine {

    public static final char FILE_VAR_MARKER = '~';

    protected Configuration cfg;

    public FreemarkerEngine() {
        cfg = new Configuration();
        cfg.setWhitespaceStripping(true);
        cfg.setLocalizedLookup(false);
        cfg.setClassicCompatible(true);
    }

    public static String expandFileNameVars(TemplateContext ctx, String name) {
        int i = name.indexOf(FILE_VAR_MARKER);
        if (i == -1) {
            return name;
        }
        StringBuilder buf = new StringBuilder();
        int k = 0;
        do {
            if (i > k) {
                buf.append(name.substring(k, i));
            }
            k = name.indexOf(FILE_VAR_MARKER, i + 1);
            if (k == -1) {
                k = i;
                break;
            }
            String key = name.substring(++i, k);
            String v = ctx.getProperty(key);
            if (v == null) {
                buf.append(FILE_VAR_MARKER).append(key).append(FILE_VAR_MARKER);
            } else {
                buf.append(v);
            }
            i = name.indexOf(FILE_VAR_MARKER, ++k);
        } while (i > -1);
        if (k < name.length()) {
            buf.append(name.substring(k));
        }
        return buf.toString();
    }

    public static File renameFileIfNeeded(TemplateContext ctx, File dir) {
        String name = dir.getName();
        String newName = expandFileNameVars(ctx, name);
        if (newName == name) {
            return dir;
        }
        File dst = new File(dir.getParentFile(), newName);
        dst.getParentFile().mkdirs();
        dir.renameTo(dst);
        return dst;
    }

    @Deprecated
    public void expandVars(TemplateContext ctx, File root) throws Exception {
        // first rename the file is needed
        root = renameFileIfNeeded(ctx, root);
        if (root.isDirectory()) {
            File[] files = root.listFiles();
            if (files != null) {
                for (File file : files) {
                    expandVars(ctx, file);
                }
            }
        } else if (root.isFile()) {
            String name = root.getName();
            if (name.endsWith(".ftl")) {
                String finalName = name.substring(0, name.length() - 4);
                Reader reader = new InputStreamReader(
                        new FileInputStream(root), "UTF-8");
                Writer writer = new OutputStreamWriter(new FileOutputStream(
                        new File(root.getParentFile(), finalName)), "UTF-8");
                try {
                    processTemplate(ctx, name, reader, writer);
                } finally {
                    try {
                        reader.close();
                    } catch (IOException e) {
                    }
                    try {
                        writer.close();
                    } catch (IOException e) {
                    }
                }
                root.delete();
            }
        }
    }

    @Override
    public String expandVars(TemplateContext ctx, String content)
            throws Exception {
        StringWriter writer = new StringWriter();
        processTemplate(ctx, "inline", new StringReader(content), writer);
        return writer.toString();
    }

    @Override
    public void transform(TemplateContext ctx, File src, File dst)
            throws Exception {
        String content = IOUtils.readFile(src);
        content = expandVars(ctx, content);
        if (src != dst) {
            dst.getParentFile().mkdirs();
        }
        IOUtils.writeFile(dst, content);
    }

    protected void processTemplate(TemplateContext ctx, String name,
            Reader reader, Writer writer) throws Exception {
        Template temp = new Template(name, reader, cfg);
        Environment env = temp.createProcessingEnvironment(ctx, writer);
        env.process();
    }

}
