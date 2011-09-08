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
package org.nuxeo.ide.connect.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.common.forms.BindingContext;
import org.nuxeo.ide.common.forms.UIObject;
import org.nuxeo.ide.common.forms.WidgetName;
import org.nuxeo.ide.connect.ConnectPlugin;
import org.nuxeo.ide.connect.StudioProjectBinding;
import org.nuxeo.ide.connect.studio.StudioProject;
import org.w3c.dom.Element;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
@WidgetName("studioProjects")
public class StudioProjectsWidget extends UIObject<Table> {

    protected CheckboxTableViewer tv;

    @Override
    protected Table createControl(Composite parent, Element element,
            BindingContext ctx) {
        tv = CheckboxTableViewer.newCheckList(parent, SWT.H_SCROLL
                | SWT.V_SCROLL | SWT.BORDER);
        StudioProjectsProvider provider = new StudioProjectsProvider();
        tv.setContentProvider(provider);
        tv.setLabelProvider(provider);
        tv.addCheckStateListener(new ICheckStateListener() {
            @Override
            public void checkStateChanged(CheckStateChangedEvent event) {
                if (event.getChecked()) {
                    // TODO validate that all checked projects have the same
                    // target version
                    // Object element = event.getElement();
                    // Object[] ar = tv.getCheckedElements();
                    // for (Object o : ar) {
                    // if (o != element) {
                    // tv.setChecked(o, false);
                    // }
                    // }
                }
            }
        });
        return tv.getTable();
    }

    public void setSelectedProjects(StudioProject[] projects) {
        tv.setCheckedElements(projects);
    }

    public void setSelectedProjects(IProject project) {
        try {
            StudioProjectBinding binding = ConnectPlugin.getStudioProvider().getBinding(
                    project);
            if (binding != null) {
                tv.setCheckedElements(binding.getProjects());
            }
        } catch (Exception e) {
            UI.showError("Failed to query studio project bindings", e);
        }
    }

    public void setInput(Object input) {
        tv.setInput(input);
    }

    public StudioProject[] getSelectedProjects() {
        Object[] ar = tv.getCheckedElements();
        StudioProject[] projects = new StudioProject[ar.length];
        for (int i = 0; i < ar.length; i++) {
            projects[i] = (StudioProject) ar[i];
        }
        return projects;
    }

    public String[] getSelectedProjectIds() {
        Object[] ar = tv.getCheckedElements();
        String[] projects = new String[ar.length];
        for (int i = 0; i < ar.length; i++) {
            projects[i] = ((StudioProject) ar[i]).getId();
        }
        return projects;
    }

    public void setSelectedProject(StudioProject project) {
        tv.setChecked(project, true);
    }

    public CheckboxTableViewer getTableViewer() {
        return tv;
    }

}
