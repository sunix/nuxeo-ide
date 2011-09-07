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
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.navigator.CommonNavigator;
import org.nuxeo.ide.common.FormPropertyPage;
import org.nuxeo.ide.common.forms.ActionHandler;
import org.nuxeo.ide.common.forms.Form;
import org.nuxeo.ide.common.forms.FormData;
import org.nuxeo.ide.common.forms.UIObject;
import org.nuxeo.ide.connect.ConnectPlugin;
import org.nuxeo.ide.connect.StudioProjectBinding;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StudioPropertyPage extends FormPropertyPage implements
        IWorkbenchPropertyPage, FormData {

    public StudioPropertyPage() {
        this.data = this;
    }

    @Override
    protected Form createForm() {
        Form form = super.createForm();
        form.addWidgetType(StudioProjectsWidget.class);
        form.addActionHandler("configure", new ActionHandler() {
            @Override
            public void handleAction(Form form, UIObject<?> obj, Object event) {
                PreferenceDialog pref = PreferencesUtil.createPreferenceDialogOn(
                        null, "org.nuxeo.ide.prefs.connect", null, null);
                if (pref != null) {
                    ((Dialog) getContainer()).close();
                    pref.open();
                }
            }
        });
        return form;
    }

    public IProject getProject() {
        return (IProject) getElement().getAdapter(IProject.class);
    }

    @Override
    public void load(Form form) throws Exception {
        StudioProjectsWidget w = (StudioProjectsWidget) form.getWidget("projects");
        w.setInput(ConnectPlugin.getStudioProvider().getProjects());
        IProject project = getProject();
        w.setSelectedProjects(project);
    }

    @Override
    public void store(Form form) throws Exception {
        StudioProjectsWidget w = (StudioProjectsWidget) form.getWidget("projects");
        StudioProjectBinding binding = new StudioProjectBinding(
                w.getSelectedProjectIds());
        binding.bind(getProject());
        // getProject().refreshLocal(IResource.DEPTH_INFINITE,
        // new NullProgressMonitor());
        IViewPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(
                "org.eclipse.ui.navigator.ProjectExplorer");
        if (part instanceof CommonNavigator) {
            ((CommonNavigator) part).getCommonViewer().refresh(getProject());
        }
    }

}
