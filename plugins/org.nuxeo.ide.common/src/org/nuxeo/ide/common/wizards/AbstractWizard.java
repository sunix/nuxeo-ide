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
package org.nuxeo.ide.common.wizards;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.nuxeo.ide.common.Activator;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class AbstractWizard<T> extends Wizard implements INewWizard,
        IPageChangedListener {

    protected boolean isWorking = false;

    protected IWorkbench workbench;

    protected IStructuredSelection selection;

    @Override
    public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
        this.workbench = workbench;
        this.selection = currentSelection;
    }

    @Override
    public void setContainer(IWizardContainer wizardContainer) {
        if (wizardContainer instanceof WizardDialog) {
            ((WizardDialog) wizardContainer).addPageChangedListener(this);
        }
        super.setContainer(wizardContainer);
    }

    @Override
    public void dispose() {
        if (getContainer() instanceof WizardDialog) {
            ((WizardDialog) getContainer()).removePageChangedListener(this);
        }
        super.dispose();
    }

    public IStructuredSelection getSelection() {
        return selection;
    }

    public IWorkbench getWorkbench() {
        return workbench;
    }

    protected IWorkbenchPart getActivePart() {
        IWorkbenchWindow activeWindow = getWorkbench().getActiveWorkbenchWindow();
        if (activeWindow != null) {
            IWorkbenchPage activePage = activeWindow.getActivePage();
            if (activePage != null) {
                return activePage.getActivePart();
            }
        }
        return null;
    }

    protected boolean canRunForked() {
        return true;
    }

    protected void selectAndReveal(IResource newResource) {
        BasicNewResourceWizard.selectAndReveal(newResource,
                workbench.getActiveWorkbenchWindow());
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean performFinish() {
        if (isWorking) {
            return false;
        }
        isWorking = true;
        final T ctx = createExecutionContext();

        IWizardPage[] pages = getPages();
        for (IWizardPage page : pages) {
            if (page instanceof AbstractWizardPage) {
                ((AbstractWizardPage<T>) page).update(ctx);
            }
        }
        try {
            return execute(ctx);
        } catch (Exception e) {
            Status status  =new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Templating error", e);
            StatusManager.getManager().handle(status);
            return false;
        } finally {
            isWorking = false;
        }
    }

    protected abstract T createExecutionContext();

    protected abstract boolean execute(T context) throws Exception;

    @Override
    public void pageChanged(PageChangedEvent event) {
        Object obj = event.getSelectedPage();
        if (obj instanceof AbstractWizardPage) {
            ((AbstractWizardPage<?>) obj).enterPage();
        }
    }
}
