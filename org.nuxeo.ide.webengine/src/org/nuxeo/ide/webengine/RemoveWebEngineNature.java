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
package org.nuxeo.ide.webengine;

import org.eclipse.core.resources.IProject;
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
public class RemoveWebEngineNature implements IObjectActionDelegate {

    protected ISelection selection;

    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
    }

    public void run(IAction action) {
        if (selection instanceof IStructuredSelection) {
            try {
                Object[] objs = ((IStructuredSelection)selection).toArray();
                for (Object obj : objs) {
                    if (obj instanceof IProject) {
                        IProject project = (IProject)obj;
                        if (((IProject) obj).getNature(WebEngineNature.ID) != null) {
                            WebEngineNature.uninstall(project);
                        }
                    }
                }
            } catch (CoreException e) {
                e.printStackTrace();
            }
        }
    }

    public void selectionChanged(IAction action, ISelection selection) {
        this.selection = selection;
    }

}
