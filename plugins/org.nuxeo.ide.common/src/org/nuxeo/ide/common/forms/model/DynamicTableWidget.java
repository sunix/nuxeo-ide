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

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.nuxeo.ide.common.forms.BindingContext;
import org.nuxeo.ide.common.forms.UIObject;
import org.nuxeo.ide.common.forms.WidgetName;
import org.nuxeo.ide.common.forms.widgets.DynamicTable;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
@WidgetName("dynalist")
public class DynamicTableWidget extends UIObject<DynamicTable> {

    @Override
    protected DynamicTable createControl(Composite parent, Element element,
            BindingContext ctx) {
        int width = getIntAttribute(element, "width", SWT.DEFAULT);
        int height = getIntAttribute(element, "height", SWT.DEFAULT);
        DynamicTable table = new DynamicTable(parent, width, height);

        ArrayList<DynamicTable.Item> items = new ArrayList<DynamicTable.Item>();
        Node node = element.getFirstChild();
        while (node != null) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) node;
                String value = getAttribute(child, "value");
                String text = child.getTextContent().trim();
                if (value == null) {
                    value = text;
                }
                items.add(new DynamicTable.Item(text, value));
            }
            node = node.getNextSibling();
        }

        if (!items.isEmpty()) {
            table.setInput(items.toArray(new DynamicTable.Item[items.size()]));
        }

        return table;
    }

}
