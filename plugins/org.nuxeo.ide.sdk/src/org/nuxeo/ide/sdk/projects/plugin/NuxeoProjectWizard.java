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
package org.nuxeo.ide.sdk.projects.plugin;

import org.nuxeo.ide.common.wizards.AbstractWizard;
import org.nuxeo.ide.sdk.NuxeoSDK;
import org.nuxeo.ide.sdk.projects.CreateProjectFromTemplate;
import org.nuxeo.ide.sdk.projects.ProjectTemplateContext;
import org.nuxeo.ide.sdk.projects.UndefinedNuxeoSDKPage;
import org.nuxeo.ide.sdk.templates.Constants;
import org.nuxeo.ide.sdk.templates.TemplateRegistry;
import org.nuxeo.ide.sdk.ui.SDKClassPathContainer;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class NuxeoProjectWizard extends AbstractWizard<ProjectTemplateContext> {

    public NuxeoProjectWizard() {
    }

    public void addPages() {
        if (NuxeoSDK.getDefault() != null) {
            addPage(new NuxeoProjectPage1());
            addPage(new NuxeoProjectPage2());
            addPage(new NuxeoProjectPage3());
        } else {
            addPage(new UndefinedNuxeoSDKPage());
        }
    }

    public boolean performCancel() {
        return super.performCancel();
    }

    @Override
    protected ProjectTemplateContext createExecutionContext() {
        ProjectTemplateContext ctx = new ProjectTemplateContext();
        // initialize defaults
        ctx.setTemplate(TemplateRegistry.DEFAULT_TEMPLATE);
        String version = NuxeoSDK.getDefault().getVersion();
        String osgiVersion = version;
        if (version.endsWith("-SNAPSHOT")) {
            osgiVersion = version.substring(0,
                    version.length() - "-SNAPSHOT".length())
                    + ".qualifier";
        }
        ctx.put(Constants.TARGET_VERSION, version);
        ctx.put(Constants.PARENT_VERSION, version);
        ctx.put(Constants.BUNDLE_VERSION, osgiVersion);
        ctx.put(Constants.CLASSPATH_CONTAINER, SDKClassPathContainer.ID);
        return ctx;
    }

    @Override
    protected boolean execute(ProjectTemplateContext ctx) {
        String v = (String) ctx.get(Constants.PROJECT_PACKAGE);
        if (v != null) {
            ctx.put(Constants.PROJECT_PACKAGE_PATH, v.replace('.', '/'));
        }
        CreateProjectFromTemplate op = new CreateProjectFromTemplate(ctx);
        return CreateProjectFromTemplate.run(getShell(), getContainer(), op);
    }
}
