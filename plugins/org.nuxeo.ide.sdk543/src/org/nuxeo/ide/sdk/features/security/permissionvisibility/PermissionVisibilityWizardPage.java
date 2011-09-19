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
 *     ldoguin
 */
package org.nuxeo.ide.sdk.features.security.permissionvisibility;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.nuxeo.ide.common.forms.Form;
import org.nuxeo.ide.sdk.features.FeatureTemplateContext;
import org.nuxeo.ide.sdk.features.FeatureWizardPage;
import org.nuxeo.ide.sdk.ui.widgets.PackageChooserWidget;
import org.nuxeo.ide.sdk.ui.widgets.ProjectChooserWidget;

/**
 * @author <a href="mailto:ldoguin@nuxeo.com">Laurent Doguin</a>
 *
 */
public class PermissionVisibilityWizardPage extends FeatureWizardPage {

    public PermissionVisibilityWizardPage() {
        super("permissionVisibility1", "Create Permission Visibility", null);
    }

    @Override
    public Form createForm() {
        Form form = super.createForm();
        form.addWidgetType(PackageChooserWidget.class);
        form.addWidgetType(ProjectChooserWidget.class);
        form.addWidgetType(PermissionVisibilityTableWidget.class);
        return form;
    }

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
        final Button addButton = (Button) form.getWidgetControl("add");
        final PermissionVisibilityTableWidget itemsTable = (PermissionVisibilityTableWidget) form.getWidget("addedPermission");
        addButton.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                PermissionVisibilityItem item = new PermissionVisibilityItem(
                        form.getWidgetValueAsString("selectedPermission").trim(),
                        form.getWidgetValueAsString("order").trim(),
                        (Boolean)form.getWidgetValue("show"));

                itemsTable.addTableItem(item);
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                widgetSelected(e);
            }
        });

    }

    @Override
    public void update(FeatureTemplateContext ctx) {
        super.update(ctx);
        ctx.put("name", form.getWidgetValue("name"));
        ctx.put("selectedPermission", form.getWidgetValue("selectedPermission"));
        ctx.put("customPermission", form.getWidgetValue("customPermission"));
    }

}
