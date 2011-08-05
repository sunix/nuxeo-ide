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

import org.nuxeo.ide.common.wizards.AbstractWizard;
import org.nuxeo.ide.sdk.templates.TemplateRegistry;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class NuxeoProjectWizard extends AbstractWizard<TemplateContext> {

    public NuxeoProjectWizard() {
    }

    public void addPages() {
        addPage(new NuxeoProjectPage1());
        addPage(new NuxeoProjectPage2());
        addPage(new NuxeoProjectPage3());
    }

    public boolean performCancel() {
        return super.performCancel();
    }

    @Override
    protected TemplateContext createExecutionContext() {
        TemplateContext ctx = new TemplateContext();
        // initialize defaults
        ctx.setTemplate(TemplateRegistry.DEFAULT_TEMPLATE);
        ctx.put(Constants.CLASSPATH_CONTAINER, "org.nuxeo.ide.SDK_CONTAINER");
        return ctx;
    }

    @Override
    protected boolean execute(TemplateContext ctx) {
        CreateProjectFromTemplate op = new CreateProjectFromTemplate(ctx);
        return CreateProjectFromTemplate.run(getShell(), getContainer(), op);
    }
}
