/*
 * (C) Copyright 2006-2013 Nuxeo SAS (http://nuxeo.com/) and contributors.
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
package org.nuxeo.ide.connect.features.test;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.swt.widgets.Composite;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.common.forms.Form;
import org.nuxeo.ide.connect.ConnectPlugin;
import org.nuxeo.ide.connect.StudioProjectBinding;
import org.nuxeo.ide.connect.studio.DocumentType;
import org.nuxeo.ide.sdk.features.FeatureCreationWizard;
import org.nuxeo.ide.sdk.features.FeatureTemplateContext;
import org.nuxeo.ide.sdk.features.FeatureWizardPage;
import org.nuxeo.ide.sdk.ui.widgets.ObjectChooser;
import org.nuxeo.ide.sdk.ui.widgets.ProjectChooser;
import org.nuxeo.ide.sdk.ui.widgets.ProjectChooserWidget;
import org.nuxeo.ide.sdk.ui.widgets.TestPackageChooserWidget;

/**
 * @author <a href="mailto:ldoguin@nuxeo.com">Laurent Doguin</a>
 * 
 */
public class StudioUnitTestWizardPage extends FeatureWizardPage {

	protected String[] projectIds;

    public StudioUnitTestWizardPage() {
        super("createStudioUnitTest1", "Create Unit Test", null);
    }

    @Override
    public Form createForm() {
        Form form = super.createForm();
        form.addWidgetType(TestPackageChooserWidget.class);
        form.addWidgetType(ProjectChooserWidget.class);
        form.addWidgetType(StudioDocTypeWidget.class);
        return form;
    }

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
        ProjectChooser projChooser = (ProjectChooser) form.getWidgetControl("project");
        FeatureCreationWizard wiz = (FeatureCreationWizard) getWizard();
        IJavaProject project = wiz.getSelectedNuxeoProject();
        final StudioDocTypeTable table = (StudioDocTypeTable) form.getWidgetControl("chooseStudioDocType");
        if (project != null) {
            updateTypes(table, project.getProject());
        }
        projChooser.addValueChangedListener(new ObjectChooser.ValueChangedListener<IJavaProject>() {
            @Override
            public void valueChanged(ObjectChooser<IJavaProject> source,
                    IJavaProject oldValue, IJavaProject newValue) {
            	updateTypes(table, newValue.getProject());
            }
        });

    }

    protected void updateTypes(StudioDocTypeTable table, IProject project) {
        if (project == null) {
            table.setInput(new DocumentType[0]);
        } else {
            StudioProjectBinding binding = ConnectPlugin.getStudioProvider().getBinding(
                    project);
            if (binding == null) {
                UI.showWarning("No document types are available since the project you selected is not bound to Nuxeo Studio!");
            } else {
                table.setInput(binding.getTypes());
                projectIds = binding.getProjectIds();
            }
        }
    }

    @Override
    public void update(FeatureTemplateContext ctx) {
        super.update(ctx);
        StudioDocTypeTable widget = (StudioDocTypeTable) form.getWidgetControl("chooseStudioDocType");
        DocumentType[] docTypes = widget.getSelectedDocTypes();
        ctx.put("docTypes", docTypes);      
        ctx.put("projectIds", projectIds);        
    }

}
