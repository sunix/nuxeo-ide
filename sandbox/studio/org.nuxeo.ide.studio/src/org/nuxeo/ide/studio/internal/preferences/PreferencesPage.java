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

package org.nuxeo.ide.studio.internal.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.nuxeo.ide.studio.StudioPlugin;

public class PreferencesPage extends FieldEditorPreferencePage implements
        IWorkbenchPreferencePage {

    public PreferencesPage() {
        super(GRID);
        setPreferenceStore(StudioPlugin.getDefault().getPreferenceStore());
    }

    @Override
    public void createFieldEditors() {

        addField(new StringFieldEditor(PreferencesConstants.P_CONNECT_LOCATION,
                "http://connect.nuxeo.com/site/studio/ide/xxx", getFieldEditorParent()));
        
        addField(new StringFieldEditor(PreferencesConstants.P_USER, "", getFieldEditorParent()));

    }

    @Override
    public void init(IWorkbench workbench) {
        ;
    }

}
