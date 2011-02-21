/*******************************************************************************
 * Copyright (c) 2008-2010 Sonatype, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *      Sonatype, Inc. - initial API and implementation
 *******************************************************************************/

package org.nuxeo.ide.studio.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.nuxeo.ide.studio.StudioPlugin;

public class PreferencesPage extends FieldEditorPreferencePage implements
        IWorkbenchPreferencePage {

    public PreferencesPage() {
        super(GRID);
        setPreferenceStore(StudioPlugin.getDefault().getPreferenceStore());
    }

    protected Text passwordText;
    
    @Override
    public void createFieldEditors() {

        addField(new StringFieldEditor(PreferencesConstants.P_CONNECT_LOCATION,
                "Studio Location", getFieldEditorParent()));
        
        addField(new StringFieldEditor(PreferencesConstants.P_USER, "User", getFieldEditorParent()));
        
        StringFieldEditor passwordField = new StringFieldEditor(PreferencesConstants.P_PASSWORD, "Password", getFieldEditorParent());
        passwordText = passwordField.getTextControl(getFieldEditorParent());
        passwordText.setText(StudioPlugin.getPreferences().getPassword());
        passwordText.setEchoChar('*');
    }

    @Override
    protected void initialize() {
        // TODO Auto-generated method stub
        super.initialize();
    }
    @Override
    public boolean performOk() {
        StudioPlugin.getPreferences().setPassword(passwordText.getText());
        return super.performOk();
    }
    
    @Override
    public void init(IWorkbench workbench) {
        ;
    }

}
