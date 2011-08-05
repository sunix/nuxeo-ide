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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.nuxeo.ide.common.forms.BindingContext;
import org.nuxeo.ide.common.forms.HasValue;
import org.nuxeo.ide.common.forms.WidgetName;
import org.w3c.dom.Element;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
@WidgetName("textbox")
public class TextBoxWidget extends UIValueObject<Text> implements HasValue {

    @Override
    protected Text createControl(Composite parent, Element element,
            BindingContext ctx) {
        boolean readOnly = getBooleanAttribute(element, "readonly", false);
        int style = SWT.SINGLE | SWT.BORDER;
        if (readOnly) {
            style |= SWT.READ_ONLY;
        }
        return new Text(parent, style);
    }

    @Override
    public String getValue() {
        return ctrl.getText();
    }

    @Override
    public void doSetValue(Object value) {
        if (value != null) {
            ctrl.setText(value.toString());
        }
    }

    @Override
    public String getValueAsString() {
        return getValue().toString();
    }

}
