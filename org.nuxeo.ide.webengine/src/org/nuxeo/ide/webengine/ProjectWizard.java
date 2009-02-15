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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jdt.internal.ui.util.ExceptionHandler;
import org.eclipse.jdt.internal.ui.wizards.NewElementWizard;
import org.eclipse.jdt.internal.ui.wizards.NewWizardMessages;
import org.eclipse.jdt.ui.IPackagesViewPart;
import org.eclipse.jdt.ui.actions.ShowInPackageViewAction;
import org.eclipse.jdt.ui.wizards.NewJavaProjectWizardPageOne;
import org.eclipse.jdt.ui.wizards.NewJavaProjectWizardPageTwo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public class ProjectWizard extends NewElementWizard {
    private NewJavaProjectWizardPageOne fFirstPage;
    private NewJavaProjectWizardPageTwo fSecondPage;

    private IConfigurationElement fConfigElement;

    public ProjectWizard() {
        this(null, null);
    }

    public ProjectWizard(NewJavaProjectWizardPageOne pageOne, NewJavaProjectWizardPageTwo pageTwo) {
        setDefaultPageImageDescriptor(JavaPluginImages.DESC_WIZBAN_NEWJPRJ);
        setDialogSettings(JavaPlugin.getDefault().getDialogSettings());
        setWindowTitle("New WebEngine Project");

        fFirstPage= pageOne;
        fSecondPage= pageTwo;
    }

    public void addPages() {
        if (fFirstPage == null)
            fFirstPage= new NewJavaProjectWizardPageOne();
        addPage(fFirstPage);

        if (fSecondPage == null)
            fSecondPage= new ProjectWizardPage2(fFirstPage);
        addPage(fSecondPage);

        fFirstPage.init(getSelection(), getActivePart());
    }

    protected void finishPage(IProgressMonitor monitor) throws InterruptedException, CoreException {
        fSecondPage.performFinish(monitor); // use the full progress monitor
    }

    public boolean performFinish() {
        boolean res= super.performFinish();
        if (res) {
            final IJavaElement newElement= getCreatedElement();

            IWorkingSet[] workingSets= fFirstPage.getWorkingSets();
            if (workingSets.length > 0) {
                PlatformUI.getWorkbench().getWorkingSetManager().addToWorkingSets(newElement, workingSets);
            }

            BasicNewProjectResourceWizard.updatePerspective(fConfigElement);
            selectAndReveal(fSecondPage.getJavaProject().getProject());

            Display.getDefault().asyncExec(new Runnable() {
                public void run() {
                    IWorkbenchPart activePart= getActivePart();
                    if (activePart instanceof IPackagesViewPart) {
                        (new ShowInPackageViewAction(activePart.getSite())).run(newElement);
                    }
                }
            });
        }
        return res;
    }

    private IWorkbenchPart getActivePart() {
        IWorkbenchWindow activeWindow= getWorkbench().getActiveWorkbenchWindow();
        if (activeWindow != null) {
            IWorkbenchPage activePage= activeWindow.getActivePage();
            if (activePage != null) {
                return activePage.getActivePart();
            }
        }
        return null;
    }

    protected void handleFinishException(Shell shell, InvocationTargetException e) {
        String title= NewWizardMessages.JavaProjectWizard_op_error_title;
        String message= NewWizardMessages.JavaProjectWizard_op_error_create_message;
        ExceptionHandler.handle(e, getShell(), title, message);
    }

    /*
     * Stores the configuration element for the wizard.  The config element will be used
     * in <code>performFinish</code> to set the result perspective.
     */
    public void setInitializationData(IConfigurationElement cfig, String propertyName, Object data) {
        fConfigElement= cfig;
    }

    public boolean performCancel() {
        fSecondPage.performCancel();
        return super.performCancel();
    }

    public IJavaElement getCreatedElement() {
        return fSecondPage.getJavaProject();
    }
}
