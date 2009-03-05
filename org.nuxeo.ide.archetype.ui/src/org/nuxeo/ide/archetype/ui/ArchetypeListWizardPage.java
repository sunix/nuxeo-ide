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

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.nuxeo.ide.archetype.ui.providers.ArchetypeLabelProvider;
import org.nuxeo.ide.archetype.ui.providers.ArchetypeListContentProvider;
import org.nuxeo.ide.archetype.ui.providers.IArchetypeFileEntry;

/**
 * @author stan
 * 
 */
public abstract class ArchetypeListWizardPage extends WizardPage {

    TableViewer viewer;

    // constants
    private static final int SIZING_TEXT_FIELD_WIDTH = 250;

    public IArchetypeFileEntry tpl;

    protected ArchetypeListWizardPage() {
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
        if (viewer.getSelection() != null) {
            return (((IStructuredSelection) viewer.getSelection()).getFirstElement()) != null;
        }
        return false;
    }

    private final void createArchetypeGroup(Composite parent) {
        // project specification group
        Composite archetypeGroup = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 1;
        archetypeGroup.setLayout(layout);
        archetypeGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        // new project label
        viewer = new TableViewer(parent);
        viewer.setLabelProvider(new ArchetypeLabelProvider());
        viewer.setContentProvider(new ArchetypeListContentProvider());

        viewer.setInput(getArchetypeFileEntry());

        viewer.addSelectionChangedListener(new ISelectionChangedListener() {
            public void selectionChanged(SelectionChangedEvent event) {
                tpl = (IArchetypeFileEntry) ((IStructuredSelection) viewer.getSelection()).getFirstElement();
                setPageComplete(validatePage());
            }
        });

        setPageComplete(false);
    }

    ArchetypeWizardPage page;

    IArchetypeFileEntry oldTpl = null;

    @Override
    public IWizardPage getNextPage() {
        if (tpl == null) {
            return page;
        }
        if (page == null || oldTpl != tpl) {
            try {
                page = new ArchetypeWizardPage(tpl.getInputStream());
                oldTpl = tpl;

                ((NewArchetypeListBasedProjectWizard) getWizard()).setArchetypeWizardPage(page);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return page;
    }

    /**
     * Provide the list of template zip files to be display in the wizard.
     * 
     * @return
     */
    public abstract IArchetypeFileEntry[] getArchetypeFileEntry();

}
