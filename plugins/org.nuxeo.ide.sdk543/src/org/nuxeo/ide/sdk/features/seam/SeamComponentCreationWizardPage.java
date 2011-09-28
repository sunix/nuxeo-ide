/*
 * (C) Copyright 2006-2011 Nuxeo SAS (http://nuxeo.com/) and contributors.
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
 *     slacoin
 */
package org.nuxeo.ide.sdk.features.seam;

import org.eclipse.jdt.core.IJavaProject;
import org.nuxeo.ide.sdk.features.FeatureTemplateContext;
import org.nuxeo.ide.sdk.features.FeatureWizardPage;
import org.nuxeo.ide.sdk.ui.widgets.PackageChooserWidget;
import org.nuxeo.ide.sdk.ui.widgets.ProjectChooserWidget;

public class SeamComponentCreationWizardPage extends FeatureWizardPage {

    protected final String name;
    
    public SeamComponentCreationWizardPage(String name) {
        super("seam:"+name, "Create SEAM " + name + " Bean Component", null);
        this.name = name;
    }
      
    @Override
    public void update(FeatureTemplateContext ctx) {
        IJavaProject project = (IJavaProject) ((ProjectChooserWidget) form.getWidget("project")).getValue();
        ctx.setProject(project);
        ctx.setPackage(((PackageChooserWidget) form.getWidget("package")).getValueAsString());
        String bean = form.getWidgetValueAsString("component");
        String className = bean+"Bean";
        ctx.setClassName(className);
        ctx.put("class", className);
        ctx.put("bean", bean);
    }
}
