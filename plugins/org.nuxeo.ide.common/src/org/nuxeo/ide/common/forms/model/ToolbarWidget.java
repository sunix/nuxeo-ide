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
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.nuxeo.ide.common.forms.BindingContext;
import org.nuxeo.ide.common.forms.UIObject;
import org.nuxeo.ide.common.forms.WidgetName;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
@WidgetName("toolbar")
public class ToolbarWidget extends UIObject<ToolBar> {

    @Override
    protected ToolBar createControl(Composite parent, Element element,
            BindingContext ctx) {
        boolean isVertical = getBooleanAttribute(element, "vertical", false);
        int style = SWT.FLAT;
        if (isVertical) {
            style |= SWT.VERTICAL;
        }
        ToolBar tbar = (ToolBar) new ToolBar(parent, style);
        tbar.setLayout(new FillLayout());
        return tbar;
    }

    public ToolItem getItem(String id) {
        for (ToolItem item : getControl().getItems()) {
            if (id.equals(item.getData("item.id"))) {
                return item;
            }
        }
        return null;
    }

    public void onAction(SelectionEvent e) {
        String id = (String) e.widget.getData("item.id");
        if (id != null) {
            form.handleAction(id, this, e);
        }
    }

    @Override
    public ToolBar bind(Composite parent, Element element,
            final BindingContext ctx) {
        ToolBar tbar = super.bind(parent, element, ctx);
        Node child = element.getFirstChild();
        while (child != null) {
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) child;
                int style = SWT.NONE;
                String type = getAttribute(el, "type");
                if (type == null) {
                    style = SWT.PUSH;
                } else if ("separator".equals(type)) {
                    style = SWT.SEPARATOR;
                } else if ("check".equals(type)) {
                    style = SWT.CHECK;
                } else if ("radio".equals(type)) {
                    style = SWT.RADIO;
                } else if ("dropdown".equals(type)) {
                    style = SWT.DROP_DOWN;
                } else {
                    style = SWT.PUSH;
                }
                String id = getAttribute(el, "id");
                String img = getAttribute(el, "img");
                String text = getAttribute(el, "text");
                String tooltip = getAttribute(el, "tooltip");
                el.getTextContent().trim();

                ToolItem item = new ToolItem(tbar, style);
                if (id != null) {
                    item.setData("item.id", id);
                }
                if (img != null) {
                    Image im = form.getImage(img);
                    if (im != null) {
                        item.setImage(im);
                    }
                }
                if (text != null) {
                    item.setText(text);
                }
                if (tooltip != null) {
                    item.setToolTipText(tooltip);
                }
                item.addSelectionListener(new SelectionListener() {
                    @Override
                    public void widgetSelected(SelectionEvent e) {
                        onAction(e);
                    }

                    @Override
                    public void widgetDefaultSelected(SelectionEvent e) {
                        widgetSelected(e);
                    }
                });
            }
            child = child.getNextSibling();
        }
        return tbar;
    }

}
