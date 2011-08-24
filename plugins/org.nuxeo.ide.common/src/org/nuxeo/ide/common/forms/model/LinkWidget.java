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
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.nuxeo.ide.common.forms.BindingContext;
import org.nuxeo.ide.common.forms.UIObject;
import org.nuxeo.ide.common.forms.WidgetName;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
@WidgetName("link")
public class LinkWidget extends UIObject<Link> {

    @Override
    protected Link createControl(Composite parent, Element element,
            BindingContext ctx) {
        boolean wrap = getBooleanAttribute(element, "wrap", false);
        int style = SWT.NONE;
        if (wrap) {
            style |= SWT.WRAP;
        }
        Link link = new Link(parent, style);
        link.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event e) {
                if (e.text.startsWith("http:")) {
                    Program.launch(e.text);
                } else {
                    form.handleAction(getId(), LinkWidget.this, e);
                }
            }
        });
        return link;
    }

    @Override
    public Link bind(Composite parent, Element element, BindingContext ctx) {
        Link ctrl = super.bind(parent, element, ctx);
        StringBuilder buf = new StringBuilder();
        Node child = element.getFirstChild();
        while (child != null) {
            int type = child.getNodeType();
            if (type == Node.TEXT_NODE) {
                buf.append(child.getNodeValue());
            } else if (type == Node.ELEMENT_NODE
                    && "A".equals(child.getNodeName().toUpperCase())) {
                buf.append("<A>").append(child.getTextContent()).append("</A>");
            }
            child = child.getNextSibling();
        }
        boolean trim = getBooleanAttribute(element, "trim", true);
        ctrl.setText(trim ? buf.toString().trim() : buf.toString());
        return ctrl;
    }

}
