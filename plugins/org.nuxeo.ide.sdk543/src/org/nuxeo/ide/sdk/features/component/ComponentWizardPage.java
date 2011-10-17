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
package org.nuxeo.ide.sdk.features.component;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.nuxeo.ide.common.forms.Form;
import org.nuxeo.ide.sdk.features.FeatureTemplateContext;
import org.nuxeo.ide.sdk.features.FeatureWizardPage;
import org.nuxeo.ide.sdk.ui.widgets.PackageChooserWidget;
import org.nuxeo.ide.sdk.ui.widgets.ProjectChooserWidget;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ComponentWizardPage extends FeatureWizardPage {

    public ComponentWizardPage() {
        super("createOperation1", "Create Operation", null);
    }

    @Override
    public Form createForm() {
        Form form = super.createForm();
        form.addWidgetType(PackageChooserWidget.class);
        form.addWidgetType(ProjectChooserWidget.class);
        return form;
    }

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
    }

    @Override
    public void update(FeatureTemplateContext ctx) {
        super.update(ctx);
        // String className = ctx.getClassName();
        ctx.put("exportAsService",
                ((Button) form.getWidgetControl("exportAsService")).getSelection());
    }

}
