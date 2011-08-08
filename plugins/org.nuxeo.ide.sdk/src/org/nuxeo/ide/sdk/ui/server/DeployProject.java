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
package org.nuxeo.ide.sdk.ui.server;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.nuxeo.ide.sdk.server.ServerController;

/**
 * Fake add nature - used as an example
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class DeployProject implements IObjectActionDelegate {

    protected ISelection selection;

    protected IWorkbenchPart part;

    public DeployProject() {
    }

    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        part = targetPart;
    }

    public void run(IAction action) {
        if (selection instanceof IStructuredSelection) {
            IProject project = (IProject) ((IStructuredSelection) selection).getFirstElement();
            new ServerController(new File("/Users/bstefanescu/tmp/ide")).deploy(
                    project, part.getSite().getShell());
        }
    }

    public void selectionChanged(IAction action, ISelection selection) {
        this.selection = selection;
    }

}
