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
package org.nuxeo.ide.sdk.ui.widgets;

import java.util.ArrayList;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ProjectChooser extends ObjectChooser<IJavaProject> {

    protected String nature;

    protected ListenerList listeners = new ListenerList();

    protected IJavaModel model;

    public ProjectChooser(Composite parent) {
        super(parent, "Browse");
    }

    public ProjectChooser(Composite parent, String btnLabel) {
        super(parent, btnLabel);
    }

    public IJavaProject getProject() {
        return getValue();
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getNature() {
        return nature;
    }

    public IJavaModel getJavaModel() {
        if (model == null) {
            model = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot());
        }
        return model;
    }

    @Override
    protected IJavaProject changePressed(IJavaProject project) {
        try {
            return chooseProject(project);
        } catch (CoreException e) {
            e.printStackTrace(); // TODO
        }
        return null;
    }

    protected IJavaProject chooseProject(IJavaProject project)
            throws CoreException {
        IWorkspaceRoot wsRoot = ResourcesPlugin.getWorkspace().getRoot();
        IJavaProject[] prjs = JavaCore.create(wsRoot).getJavaProjects();
        ArrayList<IJavaProject> list = new ArrayList<IJavaProject>();
        for (IJavaProject prj : prjs) {
            if (nature != null && !prj.getProject().isNatureEnabled(nature)) {
                continue;
            } else {
                list.add(prj);
            }
        }
        IJavaElement[] projects = list.toArray(new IJavaProject[list.size()]);

        ElementListSelectionDialog dialog = new ElementListSelectionDialog(
                getShell(), new JavaElementLabelProvider(
                        JavaElementLabelProvider.SHOW_DEFAULT));
        dialog.setIgnoreCase(false);
        dialog.setTitle("Project Selection");
        dialog.setMessage("Choose a Project:");
        dialog.setEmptyListMessage("Cannot find projects to select.");
        dialog.setElements(projects);
        dialog.setHelpAvailable(false);

        if (project != null) {
            dialog.setInitialSelections(new Object[] { project });
        }

        if (dialog.open() == Window.OK) {
            return (IJavaProject) dialog.getFirstResult();
        }
        return null;
    }

    @Override
    public String toString(IJavaProject value) {
        return value != null ? value.getElementName() : "";
    }

    @Override
    public IJavaProject toValue(String text) {
        if (text == null || text.length() == 0) {
            return null;
        }
        return getJavaModel().getJavaProject(text);
    }
}
