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
package org.nuxeo.ide.common.wizards;

import java.net.URL;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.common.forms.ErrorHandler;
import org.nuxeo.ide.common.forms.Form;
import org.nuxeo.ide.common.forms.UIObject;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class FormWizardPage<T> extends AbstractWizardPage<T> implements
        ErrorHandler {

    protected Form form;

    protected FormWizardPage(String pageName) {
        super(pageName);
    }

    protected FormWizardPage(String pageName, String title,
            ImageDescriptor titleImage) {
        super(pageName, title, titleImage);
    }

    protected URL getFormDescriptor() {
        return getClass().getResource(getClass().getSimpleName() + ".xml");
    }

    public Form createForm() {
        return new Form();
    }

    public Form getForm() {
        return form;
    }

    @Override
    public void createControl(Composite parent) {
        form = createForm();
        form.setErrorHandler(this);
        try {
            UIObject<?> root = form.load(parent, getFormDescriptor());
            Control control = root.getControl();
            Dialog.applyDialogFont(control);
            setControl(control);
        } catch (Exception e) {
            UI.showError("Faield to load wizard page", e);
        }
    }

    @Override
    public void showError(UIObject<?> obj, String error) {
        setErrorMessage(error);
    }

    @Override
    public void hideError(UIObject<?> obj) {
        setErrorMessage(null);
    }

    @Override
    public void setErrorCount(int count) {
        setPageComplete(count == 0);
    }
}
