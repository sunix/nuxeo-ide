/*
 * (C) Copyright 2009 Nuxeo SA (http://nuxeo.com/) and contributors.
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
 *     stan
 */
package org.nuxeo.ide.archetype.ui;

import java.io.File;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

/**
 * @author stan
 *
 */
public class ArchetypeChooserWizardPage extends WizardPage {

    // constants
    private static final int SIZING_TEXT_FIELD_WIDTH = 250;

    public String tpl = "";

    protected ArchetypeChooserWizardPage() {
        super("Archetype chooser page");

        setPageComplete(false);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
     * .Composite)
     */
    public void createControl(Composite parent) {
        Composite composite = new Composite(parent, SWT.NULL);
        initializeDialogUnits(parent);

        composite.setLayout(new GridLayout());
        composite.setLayoutData(new GridData(GridData.FILL_BOTH));

        createArchetypeGroup(composite);

        // Scale the button based on the rest of the dialog
        // setButtonLayoutData(locationArea.getBrowseButton());

        setPageComplete(validatePage());
        // Show description on opening
        setErrorMessage(null);
        setMessage(null);
        setControl(composite);
        Dialog.applyDialogFont(composite);

    }

    /**
     * Returns whether this page's controls currently all contain valid values.
     *
     * @return <code>true</code> if all controls are valid, and
     *         <code>false</code> if at least one is invalid
     */
    protected boolean validatePage() {
        setErrorMessage(null);

        if (!(new File(this.tpl)).exists()) {
            // to update the next page, see getNextPage()
            setMessage("Please select a existing template");
            return false;
        }

        return true;
    }

    private final void createArchetypeGroup(Composite parent) {
        // project specification group
        Composite archetypeGroup = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        archetypeGroup.setLayout(layout);
        archetypeGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        // new project label
        Label textLabel = new Label(archetypeGroup, SWT.NONE);
        textLabel.setText("Template location (zip file)");
        textLabel.setFont(parent.getFont());

        // new project name entry field
        final Text textField = new Text(archetypeGroup, SWT.BORDER);
        GridData data = new GridData(GridData.FILL_HORIZONTAL);
        data.widthHint = SIZING_TEXT_FIELD_WIDTH;
        textField.setLayoutData(data);
        textField.setFont(parent.getFont());

        textField.addListener(SWT.Modify, new Listener() {
            public void handleEvent(Event event) {
                tpl = textField.getText();
                setPageComplete(validatePage());
            }
        });

        // set default value
        Button browseButton = new Button(archetypeGroup, SWT.BORDER);
        browseButton.setText("Browse");
        final Composite parentDialog = parent;
        browseButton.addSelectionListener(new SelectionListener() {
            public void widgetDefaultSelected(SelectionEvent e) {
                widgetSelected(e);
            }

            public void widgetSelected(SelectionEvent e) {
                FileDialog filedlg = new FileDialog(parentDialog.getShell());
                filedlg.setFilterExtensions(new String[] { "*.zip" });
                String path = filedlg.open();
                textField.setText(path);
                tpl = path;
                setPageComplete(validatePage());
            }
        });
    }

    ArchetypeWizardPage page;

    String oldTpl = null;

    @Override
    public IWizardPage getNextPage() {
        if (page == null || oldTpl != tpl) {
            try {
                System.err.println("blablabla");
                page = new ArchetypeWizardPage(tpl);
                oldTpl = tpl;
                ((NewProjectWizard) getWizard()).setArchetypeWizardPage(page);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return page;
    }

}
