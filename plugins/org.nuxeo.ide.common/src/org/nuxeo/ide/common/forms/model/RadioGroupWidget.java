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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.nuxeo.ide.common.forms.BindingContext;
import org.nuxeo.ide.common.forms.WidgetName;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
@WidgetName("radioGroup")
public class RadioGroupWidget extends UIValueObject<Group> {

    protected List<Button> radios;

    public List<Button> getRadios() {
        return radios;
    }

    public Button getRadio(String id) {
        for (Button btn : radios) {
            if (id.equals(btn.getData("item.id"))) {
                return btn;
            }
        }
        return null;
    }

    public boolean isSelected(String id) {
        Button btn = getRadio(id);
        return btn == null ? false : btn.getSelection();
    }

    @Override
    protected Group createControl(Composite parent, Element element,
            BindingContext ctx) {
        Group group = new Group(parent, SWT.NONE);
        boolean vertical = getBooleanAttribute(element, "vertical", false);
        FillLayout layout = new FillLayout(vertical ? SWT.VERTICAL
                : SWT.HORIZONTAL);
        group.setLayout(layout);

        radios = new ArrayList<Button>();

        Node node = element.getFirstChild();
        while (node != null) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) node;
                String id = getAttribute(child, "id");
                boolean selected = getBooleanAttribute(child, "selected", false);
                String text = child.getTextContent().trim();
                if (id == null) {
                    id = text;
                }
                Button btn = new Button(group, SWT.RADIO);
                btn.setText(text);
                btn.setData("item.id", id);
                if (selected) {
                    btn.setSelection(true);
                }
                radios.add(btn);
            }
            node = node.getNextSibling();
        }

        return group;
    }

    @Override
    public Object getValue() {
        for (Button btn : radios) {
            if (btn.getSelection()) {
                return btn.getData("item.id");
            }
        }
        return null;
    }

    @Override
    public String getValueAsString() {
        return (String) getValue();
    }

    @Override
    protected void doSetValue(Object value) {
        if (value == null) {
            return;
        }
        for (Button btn : radios) {
            String id = (String) btn.getData("item.id");
            if (value.equals(id)) {
                btn.setSelection(true);
                return;
            }
        }
    }

}
