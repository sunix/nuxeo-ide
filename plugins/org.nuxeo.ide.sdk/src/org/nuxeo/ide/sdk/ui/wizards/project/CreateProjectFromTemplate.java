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

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.nuxeo.ide.common.wizards.ImportProject;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.nuxeo.ide.sdk.templates.TemplateContext;
import org.nuxeo.ide.sdk.templates.TemplateRegistry;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class CreateProjectFromTemplate extends ImportProject {

    protected TemplateContext ctx;

    public CreateProjectFromTemplate(ProjectTemplateContext ctx) {
        super(ctx.getProjectLocation(), ctx.getWorkingSets());
        this.ctx = ctx;
    }

    public TemplateContext getTemplateContext() {
        return ctx;
    }

    @Override
    protected void preCreate(IProgressMonitor monitor) throws Exception {
        // create project
        monitor.beginTask("Creating project files", 1);
        if (projectRoot.exists()) {
            throw new IOException("The target project file already exists: "
                    + projectRoot);
        }
        TemplateRegistry tempReg = SDKPlugin.getDefault().getTemplateManager().getDefaultRegistry();
        if (tempReg != null) {
            tempReg.processTemplate(ctx.getTemplate(), ctx, projectRoot);
        } else {
            throw new IllegalStateException("NuxeoSDK is not configured!");
        }
        monitor.worked(1);
        monitor.done();
    }

}
