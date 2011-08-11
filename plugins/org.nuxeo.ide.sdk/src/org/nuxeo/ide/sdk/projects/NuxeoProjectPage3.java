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
package org.nuxeo.ide.sdk.projects;

import java.util.Arrays;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.nuxeo.ide.common.wizards.FormWizardPage;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.nuxeo.ide.sdk.templates.ProjectTemplate;
import org.nuxeo.ide.sdk.templates.TemplateRegistry;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class NuxeoProjectPage3 extends FormWizardPage<ProjectTemplateContext> {

    public static final String PROJECT_TEMPLATE = "template";

    protected ProjectTemplate[] templates;

    public NuxeoProjectPage3() {
        super("nuxeoProjectPage3", "Select a template for the project", null);
        TemplateRegistry reg = SDKPlugin.getDefault().getTemplateManager().getDefaultRegistry();
        if (reg != null) {
            templates = reg.getProjectTemplates();
            Arrays.sort(templates);
        }
    }

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
        List list = (List) form.getWidgetControl(PROJECT_TEMPLATE);
        if (templates != null) {
            for (ProjectTemplate temp : templates) {
                list.add(temp.getName());
            }
        }
    }

    public String getTemplate() {
        if (templates == null) {
            return TemplateRegistry.DEFAULT_TEMPLATE;
        }
        List list = (List) form.getWidgetControl(PROJECT_TEMPLATE);
        int i = list.getSelectionIndex();
        return i > -1 ? templates[i].getId()
                : TemplateRegistry.DEFAULT_TEMPLATE;
    }

    @Override
    public void update(ProjectTemplateContext ctx) {
        ctx.setTemplate(getTemplate());
    }

}
