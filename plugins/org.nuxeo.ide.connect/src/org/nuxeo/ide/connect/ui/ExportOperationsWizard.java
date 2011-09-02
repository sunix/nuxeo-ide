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
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.connect.OperationModel;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ExportOperationsWizard extends Wizard implements IWorkbenchWizard {

    protected IWorkbench workbench;

    protected IJavaProject project;

    protected String projectId;

    public ExportOperationsWizard(String projectId) {
        this.projectId = projectId;
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
        if (!selection.isEmpty()) {
            IResource resource = (IResource) selection.getFirstElement();
            IProject project = resource.getProject();
            try {
                if (project.isNatureEnabled(JavaCore.NATURE_ID)) {
                    this.project = JavaCore.create(project);
                }
            } catch (Exception e) {
                UI.showError(
                        "Failed to get java project for"
                                + resource.getFullPath(), e);
            }
        }
    }

    public IJavaProject getSelectedProject() {
        return project;
    }

    @Override
    public void addPages() {
        addPage(new CollectOperationsPage());
    }

    @Override
    public boolean performFinish() {
        try {
            OperationModel[] ops = ((CollectOperationsPage) getPage("collectOperations")).getSelectedOperations();
            if (ops.length > 0) {
                getContainer().run(false, true, new ExportTask(projectId, ops));
            }
        } catch (Exception e) {
            UI.showError("Failed to export operations", e);
            return false;
        }
        return true;
    }
}
