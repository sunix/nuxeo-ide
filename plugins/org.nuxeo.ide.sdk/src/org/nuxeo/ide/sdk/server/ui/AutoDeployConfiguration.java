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
package org.nuxeo.ide.sdk.server.ui;

import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.nuxeo.ide.sdk.ui.NuxeoNature;
import org.nuxeo.ide.sdk.ui.widgets.ProjectSelectionDialog;
import org.osgi.service.prefs.BackingStoreException;

/**
 * Fake add nature - used as an example
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class AutoDeployConfiguration implements IViewActionDelegate {

    public static final String AUTO_KEY = "autodeployProjects";

    protected ISelection selection;

    protected IViewPart view;

    public AutoDeployConfiguration() {
    }

    @Override
    public void run(IAction action) {
        try {
            ProjectSelectionDialog dlg = new ProjectSelectionDialog(
                    view.getSite().getShell(), NuxeoNature.ID);
            Object[] selection = getStoredProjects();
            if (selection != null) {
                dlg.setInitialSelections(selection);
            }
            if (Window.OK == dlg.open()) {
                Object[] result = ((Object[]) dlg.getResult());
                setStoredProjects(result);
            }
        } catch (Exception e) {
            UI.showError("Failed to handle user settings", e);
        }
    }

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
    }

    @Override
    public void init(IViewPart view) {
        this.view = (ServerView) view;
    }

    public static void setStoredProjects(Object[] ar)
            throws BackingStoreException {
        IEclipsePreferences prefs = new InstanceScope().getNode(SDKPlugin.PLUGIN_ID);
        if (ar == null || ar.length == 0) {
            prefs.remove("autodeployProjects");
        } else {
            StringBuilder buf = new StringBuilder();
            for (Object a : ar) {
                IJavaProject p = ((IJavaProject) a);
                if (p.getProject().exists()) {
                    buf.append(p.getProject().getFullPath()).append(',');
                }
            }
            if (buf.length() > 0) {
                buf.setLength(buf.length() - 1);
                prefs.put("autodeployProjects", buf.toString());
            } else {
                prefs.remove("autodeployProjects");
            }
        }
        prefs.flush();
        prefs.sync();
    }

    public static IJavaProject[] getStoredProjects()
            throws BackingStoreException {
        IEclipsePreferences prefs = new InstanceScope().getNode(SDKPlugin.PLUGIN_ID);
        String v = prefs.get("autodeployProjects", null);
        if (v != null) {
            String ar[] = v.split(",");
            ArrayList<IJavaProject> result = new ArrayList<IJavaProject>(
                    ar.length);
            IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
            for (int i = 0; i < ar.length; i++) {
                IProject p = root.getProject(ar[i]);
                if (p.exists()) {
                    result.add(JavaCore.create(p));
                }
            }
            return result.toArray(new IJavaProject[result.size()]);
        }
        return null;
    }

}
