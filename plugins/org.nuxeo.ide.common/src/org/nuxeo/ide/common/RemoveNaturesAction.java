/*
 * (C) Copyright 2006-2008 Nuxeo SAS (http://nuxeo.com/) and contributors.
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
package org.nuxeo.ide.common;

import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class RemoveNaturesAction implements IObjectActionDelegate {

    protected ISelection selection;

    protected String[] natureIds;

    public RemoveNaturesAction(String... natureIds) {
        if (natureIds == null || natureIds.length == 0) {
            throw new IllegalArgumentException("No Nature ID was given");
        }
        this.natureIds = natureIds;
    }

    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
    }

    public void run(IAction action) {
        removeNatures(selection, natureIds);
    }

    public void selectionChanged(IAction action, ISelection selection) {
        this.selection = selection;
    }

    public void removeNatures(final ISelection selection,
            final String... natureIds) {
        if (selection instanceof IStructuredSelection) {
            try {
                Object[] objs = ((IStructuredSelection) selection).toArray();
                for (Object obj : objs) {
                    if (obj instanceof IProject) {
                        IProject project = (IProject) obj;
                        for (String natureId : natureIds) {
                            if (project.getNature(natureId) != null) {
                                uninstall(project, natureId);
                            }
                        }
                    }
                }
            } catch (CoreException e) {
                UI.showError("Failed to remove nature", e);
            }
        }
    }

    public void uninstall(IProject project, String natureId)
            throws CoreException {
        IProjectDescription description = project.getDescription();
        String[] natures = description.getNatureIds();
        ArrayList<String> newNatures = new ArrayList<String>();
        for (String nature : natures) {
            if (!natureId.equals(nature)) {
                newNatures.add(nature);
            }
        }
        if (newNatures.size() != natures.length) {
            description.setNatureIds(newNatures.toArray(new String[newNatures.size()]));
            project.setDescription(description, null);
        }
    }

}
