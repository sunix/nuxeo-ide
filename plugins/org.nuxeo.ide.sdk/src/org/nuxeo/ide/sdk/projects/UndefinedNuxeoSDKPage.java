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
package org.nuxeo.ide.sdk.projects;

import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.nuxeo.ide.common.forms.ActionHandler;
import org.nuxeo.ide.common.forms.Form;
import org.nuxeo.ide.common.forms.UIObject;
import org.nuxeo.ide.common.wizards.FormWizardPage;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class UndefinedNuxeoSDKPage extends FormWizardPage<Void> {

    public UndefinedNuxeoSDKPage() {
        super("noNuxeoSDK", "No NuxeoSDK was defined", null);
    }

    @Override
    public boolean isPageComplete() {
        return false;
    }

    @Override
    public void update(Void ctx) {
        // do nothing
    }

    @Override
    public Form createForm() {
        Form form = super.createForm();
        form.addActionHandler("configureSDK", new ActionHandler() {
            @Override
            public void handleAction(Form form, UIObject<?> obj, Object event) {
                PreferenceDialog pref = PreferencesUtil.createPreferenceDialogOn(
                        null, "org.nuxeo.ide.prefs.sdk", null, null);
                if (pref != null) {
                    ((WizardDialog) getWizard().getContainer()).close();
                    pref.open();
                }
            }
        });
        return form;
    }

}
