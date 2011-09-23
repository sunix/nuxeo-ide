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

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
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
        final Button removeButton = (Button) form.getWidgetControl("remove");
        final PermissionVisibilityTableWidget itemsTable = (PermissionVisibilityTableWidget) form.getWidget("selectedPermissions");
        addButton.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                PermissionVisibilityItem item = new PermissionVisibilityItem(
                        form.getWidgetValueAsString("permissions").trim(),
                        form.getWidgetValueAsString("order").trim(),
                        (Boolean) form.getWidgetValue("show"));

                itemsTable.addTableItem(item);
                getContainer().updateButtons();
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                widgetSelected(e);
            }
        });

        removeButton.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                IStructuredSelection selection = (IStructuredSelection) itemsTable.tv.getSelection();
                if (!selection.isEmpty()) {
                    itemsTable.tv.remove(selection.toArray());
                    getContainer().updateButtons();
                }
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                widgetSelected(e);
            }
        });

        itemsTable.tv.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                removeButton.setEnabled(!event.getSelection().isEmpty());
            }
        });

        removeButton.setEnabled(false);

        setPageComplete(false);
    }

    @Override
    public boolean isPageComplete() {
        return super.isPageComplete()
                && !((PermissionVisibilityTableWidget) form.getWidget("selectedPermissions")).isEmpty();
    }

    @Override
    public void update(FeatureTemplateContext ctx) {
        IJavaProject project = (IJavaProject) ((ProjectChooserWidget) form.getWidget("project")).getValue();
        ctx.setProject(project);
        ctx.setPackage(((PackageChooserWidget) form.getWidget("package")).getValueAsString());
        ctx.put("docType", form.getWidgetValue("docType"));
        ctx.put("selectedPermissions",
                ((PermissionVisibilityTableWidget) form.getWidget("selectedPermissions")).getPermissionItems());
    }

}
