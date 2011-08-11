package org.nuxeo.ide.sdk.ui.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.dialogs.NewWizard;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;

/**
 * TODO: example fo how to create a new action that opens a new wizard only with
 * Nuxeo wizards
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class NewNuxeoArtifact implements IWorkbenchWindowActionDelegate {

    /**
     * The wizard dialog width
     */
    private static final int SIZING_WIZARD_WIDTH = 500;

    /**
     * The wizard dialog height
     */
    private static final int SIZING_WIZARD_HEIGHT = 600;

    private IWorkbenchWindow window;

    public NewNuxeoArtifact() {
    }

    /**
     * Selection in the workbench has been changed. We can change the state of
     * the 'real' action here if we want, but this can only happen after the
     * delegate has been created.
     * 
     * @see IWorkbenchWindowActionDelegate#selectionChanged
     */
    public void selectionChanged(IAction action, ISelection selection) {
    }

    /**
     * We can use this method to dispose of any system resources we previously
     * allocated.
     * 
     * @see IWorkbenchWindowActionDelegate#dispose
     */
    public void dispose() {
    }

    /**
     * We will cache window object in order to be able to provide parent shell
     * for the message dialog.
     * 
     * @see IWorkbenchWindowActionDelegate#init
     */
    public void init(IWorkbenchWindow window) {
        this.window = window;
    }

    public void run(IAction action) {
        // Create wizard selection wizard.
        IWorkbench workbench = PlatformUI.getWorkbench();
        NewWizard wizard = new NewWizard();
        // wizard.setProjectsOnly(true);
        wizard.setCategoryId("org.nuxeo.ide.project.newWizards");

        ISelection selection = window.getSelectionService().getSelection();
        IStructuredSelection selectionToPass = StructuredSelection.EMPTY;
        if (selection instanceof IStructuredSelection) {
            selectionToPass = (IStructuredSelection) selection;
        }
        wizard.init(workbench, selectionToPass);
        IDialogSettings workbenchSettings = IDEWorkbenchPlugin.getDefault().getDialogSettings();
        IDialogSettings wizardSettings = workbenchSettings.getSection("NewWizardAction"); //$NON-NLS-1$
        if (wizardSettings == null) {
            wizardSettings = workbenchSettings.addNewSection("NewWizardAction"); //$NON-NLS-1$
        }
        wizard.setDialogSettings(wizardSettings);
        wizard.setForcePreviousAndNextButtons(true);

        // Create wizard dialog.
        Shell parent = window.getShell();
        WizardDialog dialog = new WizardDialog(parent, wizard);
        dialog.create();

        wizard.setWindowTitle("New Nuxeo Artifact");
        dialog.getShell().setSize(
                Math.max(SIZING_WIZARD_WIDTH, dialog.getShell().getSize().x),
                SIZING_WIZARD_HEIGHT);
        // PlatformUI.getWorkbench().getHelpSystem().setHelp(dialog.getShell(),
        // IIDEHelpContextIds.NEW_PROJECT_WIZARD);

        // Open wizard.
        dialog.open();
    }
}