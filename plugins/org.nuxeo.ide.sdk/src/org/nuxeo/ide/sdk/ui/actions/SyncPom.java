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
package org.nuxeo.ide.sdk.ui.actions;

import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.dialogs.WizardDataTransferPage;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.index.Dependency;
import org.nuxeo.ide.sdk.index.DependencyProvider;

/**
 * Fake add nature - used as an example
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class SyncPom implements IObjectActionDelegate {

    protected ISelection selection;

    protected IWorkbenchPart part;

    public SyncPom() {
    }

    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        part = targetPart;
    }

    public void run(IAction action) {
        if (selection instanceof IStructuredSelection) {
            Object o = ((IStructuredSelection) selection).getFirstElement();
            if (o instanceof IResource) {
                SyncPomWizard wizard = new SyncPomWizard();
                wizard.init(part.getSite().getWorkbenchWindow().getWorkbench(),
                        (IStructuredSelection) selection);
                WizardDialog dialog = new WizardDialog(
                        part.getSite().getShell(), wizard);
                dialog.create();
                dialog.open();
                // IProject project = ((IResource) o).getProject();
                // IJavaProject jproject = JavaCore.create(project);
                // try {
                // Set<Dependency> result =
                // DependencyProvider.getDependencies(jproject);
                // System.out.println("############# RESULT:");
                // for (Dependency dep : result) {
                // System.out.println(dep);
                // }
                // } catch (Exception e) {
                // e.printStackTrace();
                // UI.showError("Failed to compute dependencies", e);
                // }
            }
        } else {
            UI.showError("No Nuxeo project was selected");
        }
    }

    public void selectionChanged(IAction action, ISelection selection) {
        this.selection = selection;
    }

}
