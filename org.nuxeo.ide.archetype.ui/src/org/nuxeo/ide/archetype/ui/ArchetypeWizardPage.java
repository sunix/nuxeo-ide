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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.nuxeo.ide.archetype.Archetype;
import org.nuxeo.ide.archetype.ArchetypeVar;

/**
 * @author stan
 *
 */
public class ArchetypeWizardPage extends WizardPage {

    // constants
    private static final int SIZING_TEXT_FIELD_WIDTH = 250;

    Archetype archetype;

    Map<String, String> values = new HashMap<String, String>();

    protected ArchetypeWizardPage(String tpl) {
        super("Archetype metadata page");

        archetype = new Archetype();
        // temporary
        // String tpl =
        // "/home/stan/hg/nuxeo2/nxserver/extras/archetype/gwebmodule.zip";

        File zipFile = null;
        try {
            // TODO may be refactor again
            zipFile = archetype.loadFile(tpl);
            archetype.loadDocFromZip(zipFile);

        } catch (Exception e) {
            System.err.println("An error occured while loading template archetype file");
            e.printStackTrace();
        }

        // getArchetype

        // get values from the user

        // set up the default page

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

        if (false) { // testing
            setErrorMessage(null);
            setMessage("test");
            return false;
        }

        return true;
    }

    private final void createArchetypeGroup(Composite parent) {
        // project specification group
        Composite archetypeGroup = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        archetypeGroup.setLayout(layout);
        archetypeGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        List<ArchetypeVar> archetypeVars = archetype.getAvailableVars(values);
        for (ArchetypeVar var : archetypeVars) {
            if (var.isPrompt()) {
                // new project label
                Label textLabel = new Label(archetypeGroup, SWT.NONE);
                textLabel.setText(var.getLabel());
                textLabel.setFont(parent.getFont());

                // new project name entry field
                Text textField = new Text(archetypeGroup, SWT.BORDER);
                GridData data = new GridData(GridData.FILL_HORIZONTAL);
                data.widthHint = SIZING_TEXT_FIELD_WIDTH;
                textField.setLayoutData(data);
                textField.setFont(parent.getFont());

                // set default value
                textField.setText(var.getDefaultValue());

                textField.addListener(SWT.Modify, new ModifyListener(
                        var.getName()));
            }
        }
    }

    class ModifyListener implements Listener {
        String name;

        public ModifyListener(String name) {
            this.name = name;
        }

        public void handleEvent(Event event) {
            values.put(name, ((Text) event.widget).getText());
        }
    };

}
