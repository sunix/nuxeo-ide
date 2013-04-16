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
package org.nuxeo.ide.sdk.deploy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public class ProjectViewProvider extends BaseLabelProvider implements
        ILabelProvider, IStructuredContentProvider {

    protected String[] natures;

    public ProjectViewProvider() {
        this(null);
    }

    public ProjectViewProvider(String[] natures) {
        this.natures = natures;
    }

    protected boolean accept(IProject project) {
        if (natures == null) {
            return true;
        }
        try {
            for (String nature : natures) {
                if (!project.isNatureEnabled(nature)) {
                    return false;
                }
            }
        } catch (Exception e) {
            // do nothing
        }
        return true;
    }

    @Override
    public Object[] getElements(Object inputElement) {
        IProject[] elements = getUnsortedElements(inputElement);
        if (elements == null) {
            return elements;
        }
        Arrays.sort(elements, new Comparator<IProject>() {

            @Override
            public int compare(IProject o1, IProject o2) {
                return o1.getName().compareTo(o2.getName());
            }

        });
        return elements;
    }

    private IProject[] getUnsortedElements(Object inputElement) {
        if (inputElement instanceof Collection) {
            @SuppressWarnings("unchecked")
            Collection<IProject> projects = (Collection<IProject>) inputElement;
            if (natures == null) {
                return projects.toArray(new IProject[projects.size()]);
            } else {
                ArrayList<IProject> result = new ArrayList<IProject>();
                for (IProject project : projects) {
                    if (accept(project)) {
                        result.add(project);
                    }
                }
                return result.toArray(new IProject[result.size()]);
            }
        } else if (inputElement instanceof IWorkspaceRoot) {
            IWorkspaceRoot root = (IWorkspaceRoot) inputElement;
            IProject[] projects = root.getProjects();
            if (natures == null) {
                return projects;
            } else {
                ArrayList<IProject> result = new ArrayList<IProject>();
                for (IProject project : projects) {
                    if (accept(project)) {
                        result.add(project);
                    }
                }
                return result.toArray(new IProject[result.size()]);
            }
        }
        return null;
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

    @Override
    public String getText(Object element) {
        return ((IResource) element).getName();
    }

    @Override
    public Image getImage(Object element) {
        return PlatformUI.getWorkbench().getSharedImages().getImage(
                org.eclipse.ui.ide.IDE.SharedImages.IMG_OBJ_PROJECT);
    }
}
