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
package org.nuxeo.ide.sdk.ui.widgets;

import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;
import org.nuxeo.ide.common.forms.BindingContext;
import org.nuxeo.ide.common.forms.model.UIValueObject;
import org.nuxeo.ide.sdk.ui.widgets.ObjectChooser.ValueChangedListener;
import org.w3c.dom.Element;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class ObjectChooserWidget<T extends ObjectChooser<?>> extends
        UIValueObject<T> {

    @Override
    public T bind(Composite parent, Element element, BindingContext ctx) {
        T ctrl = super.bind(parent, element, ctx);
        ctrl.text.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                validate();
            }

            @Override
            public void focusGained(FocusEvent e) {
                validate();
            }
        });
        ctrl.text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                validate();
            }
        });
        ctrl.addValueChangedListener(new ValueChangedListener() {
            @Override
            public void valueChanged(ObjectChooser source, Object oldValue,
                    Object newValue) {
                ObjectChooserWidget.this.validate();
            }
        });
        return ctrl;
    }

    @Override
    public Object getValue() {
        return ctrl.getValue();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    protected void doSetValue(Object value) {
        ((ObjectChooser) ctrl).setValue(value);
    }

    @Override
    public String getValueAsString() {
        return ctrl.getText();
    }

}
