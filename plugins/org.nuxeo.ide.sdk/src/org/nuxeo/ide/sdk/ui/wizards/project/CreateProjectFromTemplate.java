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
package org.nuxeo.ide.sdk.ui.wizards.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.nuxeo.ide.common.wizards.ImportProject;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.nuxeo.ide.sdk.templates.TemplateRegistry;

import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class CreateProjectFromTemplate extends ImportProject {

    protected TemplateContext ctx;

    public CreateProjectFromTemplate(TemplateContext ctx) {
        super(ctx.getProjectLocation(), ctx.getWorkingSets());
        this.ctx = ctx;
    }

    public TemplateContext getTemplateContext() {
        return ctx;
    }

    @Override
    protected void preCreate(IProgressMonitor monitor) throws Exception {
        // create project
        monitor.beginTask("Creating project files", 2);
        createProjectRoot();
        monitor.worked(1);
        if (monitor.isCanceled()) {
            throw new OperationCanceledException();
        }
        processTemplates(projectRoot);
        monitor.worked(1);
        monitor.done();
    }

    protected void createProjectRoot() throws Exception {
        if (projectRoot.exists()) {
            throw new IOException("The target project file already exists: "
                    + projectRoot);
        }
        TemplateRegistry tempReg = SDKPlugin.getDefault().getTemplateManager().getDefaultRegistry();
        if (tempReg != null) {
            tempReg.copyTemplate(ctx.getTemplate(), projectRoot);
        } else {
            throw new IllegalStateException("NuxeoSDK is not configured!");
        }
        // now we need to rename the src/main/java/rootPackage and
        // src/main/test/java/rootPackage to the real name.
        String rootPackage = ctx.getProperty(Constants.PROJECT_ROOT_PACKAGE);
        rootPackage = rootPackage.replace('.', '/');
        renameRootPackage(new File(projectRoot, "src/main/java"), rootPackage);
        renameRootPackage(new File(projectRoot, "src/test/java"), rootPackage);
    }

    protected boolean renameRootPackage(File srcRoot, String dst) {
        File srcPkg = new File(srcRoot, "rootPackage");
        File dstPkg = new File(srcRoot, dst);
        dstPkg.getParentFile().mkdirs();
        return srcPkg.renameTo(dstPkg);
    }

    protected void processTemplates(File root) throws Exception {
        if (root.isDirectory()) {
            File[] files = root.listFiles();
            if (files != null) {
                for (File file : files) {
                    processTemplates(file);
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
                    processTemplate(name, reader, writer);
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

    protected void processTemplate(String name, Reader reader, Writer writer)
            throws Exception {
        Configuration cfg = new Configuration();
        cfg.setWhitespaceStripping(true);
        cfg.setLocalizedLookup(false);
        cfg.setClassicCompatible(true);
        Template temp = new Template(name, reader, cfg);
        Environment env = temp.createProcessingEnvironment(
                getTemplateContext(), writer);
        env.process();
    }

}
