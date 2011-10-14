package org.nuxeo.ide.sdk.ui.widgets;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionStatusDialog;
import org.nuxeo.ide.sdk.server.ui.widgets.ServiceBrowser;

public class ServiceChooserDialog extends SelectionStatusDialog {

    protected ServiceBrowser browser;
        
    @Override
    public int open() {
        setTitle("Service Selection");
        setMessage("select the service you want to use");
        setHelpAvailable(false);
        return super.open();
    }
    /**
     * Create the dialog.
     * @param parentShell
     */
    public ServiceChooserDialog(Shell parentShell) {
        super(parentShell);
    }

    /**
     * Creates the message text widget and sets layout data.
     * @param composite the parent composite of the message area.
     */
    protected Label createMessageArea(Composite composite) {
        Label label = super.createMessageArea(composite);

        GridData data = new GridData();
        data.grabExcessVerticalSpace = false;
        data.grabExcessHorizontalSpace = true;
        data.horizontalAlignment = GridData.FILL;
        data.verticalAlignment = GridData.BEGINNING;
        label.setLayoutData(data);

        return label;
    }

     protected Control createDialogArea(Composite parent) {
        Composite contents = (Composite) super.createDialogArea(parent);

        createMessageArea(contents);

        browser = createBrowser(contents);
        
        return contents;
    }

    protected ServiceBrowser createBrowser(Composite contents) {
        ServiceBrowser myBrowser = new ServiceBrowser(contents);
          GridData data = new GridData();
        data.grabExcessHorizontalSpace = true;
        data.grabExcessVerticalSpace = true;
        data.horizontalAlignment = GridData.FILL;
        data.verticalAlignment = GridData.FILL;
        myBrowser.setLayoutData(data);
        
        myBrowser.setDefaultInput();
        
        return myBrowser;
    }

    @Override
    protected void computeResult() {
        StructuredSelection selection = (StructuredSelection)browser.getTableViewer().getSelection();
        setSelectionResult(selection.toArray());
    }

}
