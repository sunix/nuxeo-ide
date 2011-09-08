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
package org.nuxeo.ide.sdk.features.listener;

import org.nuxeo.ide.common.forms.Form;
import org.nuxeo.ide.common.forms.widgets.DynamicTable;
import org.nuxeo.ide.sdk.features.FeatureTemplateContext;
import org.nuxeo.ide.sdk.features.FeatureWizardPage;
import org.nuxeo.ide.sdk.ui.widgets.PackageChooserWidget;
import org.nuxeo.ide.sdk.ui.widgets.ProjectChooserWidget;

/**
 * @author <a href="mailto:ldoguin@nuxeo.com">Laurent Doguin</a>
 * 
 */
public class ListenerWizardPage extends FeatureWizardPage {

    public ListenerWizardPage() {
        super("createListener1", "Create Listener", null);
    }

    @Override
    public Form createForm() {
        Form form = super.createForm();
        form.addWidgetType(PackageChooserWidget.class);
        form.addWidgetType(ProjectChooserWidget.class);
        return form;
    }

    @Override
    public void update(FeatureTemplateContext ctx) {
        super.update(ctx);
        String className = ctx.getClassName();
        ctx.put("name", className.toLowerCase());
        ctx.put("async", form.getWidgetValue("async"));
        ctx.put("postCommit", form.getWidgetValue("postCommit"));
        DynamicTable table = (DynamicTable) form.getWidgetControl("selectedEvents");
        ctx.put("selectedEvents", table.getSelectedValues());
        ctx.put("order", form.getWidgetValue("order"));
    }

}
