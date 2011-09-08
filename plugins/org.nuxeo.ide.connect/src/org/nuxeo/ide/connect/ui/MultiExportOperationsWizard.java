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

import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.connect.OperationModel;
import org.nuxeo.ide.connect.studio.StudioProject;

/**
 * Exports operations to a studio project from multiple projects
 * <p>
 * The first page is used to select the input projects and the target studio
 * project. The second page is showing the collected operations.
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class MultiExportOperationsWizard extends Wizard implements
        IWorkbenchWizard, IPageChangedListener {

    protected IWorkbench workbench;

    public MultiExportOperationsWizard() {
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
    }

    @Override
    public void setContainer(IWizardContainer wizardContainer) {
        if (wizardContainer instanceof WizardDialog) {
            ((WizardDialog) wizardContainer).addPageChangedListener(this);
        }
        super.setContainer(wizardContainer);
    }

    @Override
    public void addPages() {
        addPage(new SelectExportedProjectsPage());
        addPage(new CollectOperationsPage());
    }

    public SelectExportedProjectsPage getSelectExportedProjectsPage() {
        return (SelectExportedProjectsPage) getPage("selectProjects");
    }

    public CollectOperationsPage getCollectOperationsPage() {
        return (CollectOperationsPage) getPage("collectOperations");
    }

    @Override
    public boolean performFinish() {
        try {
            StudioProject studioProject = getSelectExportedProjectsPage().getSelectedStudioProject();
            OperationModel[] ops = getCollectOperationsPage().getSelectedOperations();
            if (ops.length > 0) {
                getContainer().run(false, true,
                        new ExportTask(studioProject.getId(), ops));
            }
        } catch (Exception e) {
            UI.showError("Failed to export operations", e);
            return false;
        }
        return true;
    }

    @Override
    public void pageChanged(PageChangedEvent event) {
        Object obj = event.getSelectedPage();
        if (obj instanceof CollectOperationsPage) {
            ((CollectOperationsPage) obj).setInput(getSelectExportedProjectsPage());
        }
    }

    @Override
    public boolean canFinish() {
        return getContainer().getCurrentPage() instanceof CollectOperationsPage;
    }
}
