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
package org.nuxeo.ide.common.forms.model;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.nuxeo.ide.common.forms.BindingContext;
import org.nuxeo.ide.common.forms.HasText;
import org.nuxeo.ide.common.forms.WidgetName;
import org.w3c.dom.Element;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
@WidgetName("button")
public class ButtonWidget extends UIValueObject<Button> implements HasText {

    public ButtonWidget() {
    }

    @Override
    public void setControl(Button ctrl) {
        super.setControl(ctrl);
        ctrl.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                onAction(e);
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                onAction(e);
            }
        });
    }

    protected void onAction(SelectionEvent e) {
        form.handleAction(getId(), this, e);
    }

    @Override
    public void setText(String text) {
        ctrl.setText(text);
    }

    @Override
    public String getText() {
        return ctrl.getText();
    }

    @Override
    protected Button createControl(Composite parent, Element element,
            BindingContext ctx) {
        return new Button(parent, SWT.NONE);
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public String getValueAsString() {
        return null;
    }

    @Override
    public void doSetValue(Object value) {
    }
}
