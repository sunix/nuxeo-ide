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
package org.nuxeo.ide.common;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.nuxeo.ide.common.forms.ErrorHandler;
import org.nuxeo.ide.common.forms.Form;
import org.nuxeo.ide.common.forms.FormData;
import org.nuxeo.ide.common.forms.UIObject;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class FormPreferencePage extends PreferencePage implements ErrorHandler,
        IWorkbenchPreferencePage {

    protected IWorkbench workbench;

    protected Form form;

    protected FormData data;

    public FormPreferencePage(FormData data) {
        this.data = data;
    }

    public void setFormData(FormData data) {
        this.data = data;
    }

    public FormData getFormData() {
        return data;
    }

    protected URL getFormDescriptor() {
        return getClass().getResource(getClass().getSimpleName() + ".xml");
    }

    protected Form createForm() {
        return new Form();
    }

    protected Map<String, String> loadValues() {
        return new HashMap<String, String>();
    }

    @Override
    protected Control createContents(Composite parent) {
        try {
            form = createForm();
            form.setErrorHandler(this);
            UIObject<?> root = form.load(parent, getFormDescriptor());
            getFormData().load(form);
            Control control = root.getControl();
            Dialog.applyDialogFont(control);
            return control;
        } catch (Exception e) {
            UI.showError("Failed to instantiate preference page", e);
            return null;
        }
    }

    @Override
    public boolean performOk() {
        try {
            getFormData().store(form);
        } catch (Exception e) {
            UI.showError("Failed to store preferences", e);
        }
        return true;
    }

    @Override
    public void showError(UIObject<?> obj, String error) {
        if (!error.equals(getErrorMessage())) {
            setErrorMessage(error);
        }
    }

    @Override
    public void hideError(UIObject<?> obj) {
        setErrorMessage(null);
    }

    @Override
    public void setErrorCount(int count) {
        setValid(count == 0);
    }

    @Override
    public void init(IWorkbench workbench) {
        this.workbench = workbench;
    }

    public IWorkbench getWorkbench() {
        return workbench;
    }

}
