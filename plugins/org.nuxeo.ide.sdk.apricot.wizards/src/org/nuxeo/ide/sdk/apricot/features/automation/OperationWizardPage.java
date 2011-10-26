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
package org.nuxeo.ide.sdk.apricot.features.automation;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.nuxeo.ide.common.forms.Form;
import org.nuxeo.ide.common.forms.model.RadioGroupWidget;
import org.nuxeo.ide.sdk.features.FeatureTemplateContext;
import org.nuxeo.ide.sdk.features.FeatureWizardPage;
import org.nuxeo.ide.sdk.ui.widgets.PackageChooserWidget;
import org.nuxeo.ide.sdk.ui.widgets.ProjectChooserWidget;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class OperationWizardPage extends FeatureWizardPage {

    public OperationWizardPage() {
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
        final Button iterable = (Button) form.getWidgetControl("iterable");
        RadioGroupWidget w = (RadioGroupWidget) form.getWidget("output");
        for (Button btn : w.getRadios()) {
            btn.addSelectionListener(new SelectionListener() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    String id = (String) e.widget.getData("item.id");
                    if ("DocumentModel".equals(id) || "Blob".equals(id)) {
                        iterable.setEnabled(true);
                        iterable.setSelection(true);
                    } else {
                        iterable.setSelection(false);
                        iterable.setEnabled(false);
                    }
                }

                @Override
                public void widgetDefaultSelected(SelectionEvent e) {
                    widgetSelected(e);
                }
            });
        }
    }

    @Override
    public void update(FeatureTemplateContext ctx) {
        super.update(ctx);
        String className = ctx.getClassName();
        String id = form.getWidgetValueAsString("id");
        ctx.put("operationId", id == null || id.length() == 0 ? className : id);
        ctx.put("category", form.getWidgetValueAsString("category"));
        ctx.put("seam", form.getWidgetValue("seam"));
        ctx.put("input", form.getWidgetValueAsString("input"));
        String out = form.getWidgetValueAsString("output");
        ctx.put("output", out);
        Boolean iterable = (Boolean) form.getWidgetValue("iterable");
        if (iterable) {
            ctx.put("iterable", true);
            ctx.put("outputCollector",
                    "DocumentModel".equals(out) ? "DocumentModelCollector.class"
                            : "BlobCollector.class");
        }
    }

}
