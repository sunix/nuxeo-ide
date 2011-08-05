package org.nuxeo.ide.sdk.ui;

import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.ui.wizards.IClasspathContainerPage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class SDKClassPathContainerPage extends WizardPage implements
        IClasspathContainerPage {

    public SDKClassPathContainerPage() {
        this("NuxeoSDK", "Nuxeo SDK", null);
    }

    public SDKClassPathContainerPage(String pageName) {
        super(pageName);
    }

    public SDKClassPathContainerPage(String pageName, String title,
            ImageDescriptor titleImage) {
        super(pageName, title, titleImage);
    }

    @Override
    public void createControl(Composite parent) {
        Label label = new Label(parent, SWT.NONE);
        label.setText("TODO");
        setControl(label);
    }

    @Override
    public boolean finish() {
        return false;
    }

    @Override
    public IClasspathEntry getSelection() {
        return null;
    }

    @Override
    public void setSelection(IClasspathEntry containerEntry) {

    }

}
