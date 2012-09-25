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
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;
import org.nuxeo.ide.common.UI;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ProjectSelectionDialog extends CheckedTreeSelectionDialog {

    protected String nature;

    public ProjectSelectionDialog(Shell shell, String nature) {
        super(shell, new JavaElementLabelProvider(),
                new ContentProvider(nature));
    }

    @Override
    public int open() {
        setTitle("Project Selection");
        setMessage("Select the projects you want to deploy on the server:");
        setEmptyListMessage("Cannot find projects to select.");
        // setElements(projects);
        setHelpAvailable(false);
        setInput(Boolean.TRUE);
        return super.open();
    }

    @Override
    protected void computeResult() {
        setSelectionResult(getTreeViewer().getCheckedElements());
    }

    static class ContentProvider implements ITreeContentProvider {

        protected String nature;

        public ContentProvider(String nature) {
            this.nature = nature;
        }

        @Override
        public void dispose() {
        }

        @Override
        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }

        @Override
        public Object[] getElements(Object inputElement) {
            try {
                IWorkspaceRoot wsRoot = ResourcesPlugin.getWorkspace().getRoot();
                IJavaProject[] prjs = JavaCore.create(wsRoot).getJavaProjects();
                ArrayList<IJavaProject> list = new ArrayList<IJavaProject>();
                for (IJavaProject prj : prjs) {
                    if (nature != null
                            && !prj.getProject().isNatureEnabled(nature)) {
                        continue;
                    } else {
                        list.add(prj);
                    }
                }
                return list.toArray(new IJavaProject[list.size()]);
            } catch (CoreException e) {
                UI.showError("Cannot fetch elements", e);
                return null;
            }
        }

        @Override
        public Object[] getChildren(Object parentElement) {
            return null;
        }

        @Override
        public Object getParent(Object element) {
            return null;
        }

        @Override
        public boolean hasChildren(Object element) {
            return false;
        }

    }

}
