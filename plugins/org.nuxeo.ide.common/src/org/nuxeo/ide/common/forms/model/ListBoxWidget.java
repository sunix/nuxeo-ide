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
import org.eclipse.swt.widgets.List;
import org.nuxeo.ide.common.forms.BindingContext;
import org.nuxeo.ide.common.forms.HasValue;
import org.nuxeo.ide.common.forms.WidgetName;
import org.w3c.dom.Element;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
@WidgetName("listbox")
public class ListBoxWidget extends UIValueObject<List> implements HasValue {

    @Override
    protected List createControl(Composite parent, Element element,
            BindingContext ctx) {
        boolean multi = getBooleanAttribute(element, "multi", false);
        boolean readOnly = getBooleanAttribute(element, "readonly", false);
        int style = SWT.V_SCROLL | SWT.BORDER;
        if (multi) {
            style |= SWT.MULTI;
        }
        if (readOnly) {
            style |= SWT.READ_ONLY;
        }
        List list = new List(parent, style);
        String content = element.getTextContent();
        if (content != null) {
            content = content.trim();
            if (content.length() != 0) {
                if (content.length() > 0) {
                    String[] items = content.split("\\s*,\\s*");
                    for (String item : items) {
                        list.add(item);
                    }
                }
            }
        }
        return list;
    }

    @Override
    public String[] getValue() {
        String[] v = ctrl.getSelection();
        if (v.length == 0) {
            return null;
        }
        return v;
    }

    @Override
    public String getValueAsString() {
        String[] v = ctrl.getSelection();
        if (v.length == 0) {
            return null;
        }
        StringBuilder buf = new StringBuilder();
        buf.append(v[0]);
        for (int i = 1; i < v.length; i++) {
            buf.append(',').append(v[i]);
        }
        return buf.toString();
    }

    @Override
    public void doSetValue(Object value) {
        if (value == null) {
            return;
        }
        if (value.getClass() == String.class) {
            String v = value.toString();
            if (v.length() == 0) {
                return;
            }
            String[] sel = value.toString().split("\\s*,\\s*");
            ctrl.setSelection(sel);
        } else if (value.getClass().isArray()) {
            ctrl.setSelection((String[]) value);
        }
    }

}
