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
 *     ldoguin
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
 * @author <a href="mailto:ldoguin@nuxeo.com">Laurent Doguin</a>
 *
 */
@WidgetName("textboxList")
public class TextBoxListWidget extends UIValueObject<Text> implements HasValue {

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
    public String[] getValue() {
        String v = ctrl.getText();
        if (v.length() == 0) {
            return null;
        }
        String[] stringList = v.toString().split("\\s*,\\s*");
        return stringList;
    }

    @Override
    public String getValueAsString() {
        return ctrl.getText().toString();
    }

    @Override
    public void doSetValue(Object value) {
        if (value != null) {
            ctrl.setText(value.toString());
        }
    }

}