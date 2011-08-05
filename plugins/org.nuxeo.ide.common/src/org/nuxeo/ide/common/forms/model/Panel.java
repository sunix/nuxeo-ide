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
import org.eclipse.swt.widgets.Layout;
import org.nuxeo.ide.common.forms.BindingContext;
import org.nuxeo.ide.common.forms.LayoutManager;
import org.nuxeo.ide.common.forms.UIObject;
import org.nuxeo.ide.common.forms.WidgetName;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
@WidgetName("panel")
public class Panel<T extends Composite> extends UIObject<T> {

    @SuppressWarnings("unchecked")
    @Override
    protected T createControl(Composite parent, Element element,
            BindingContext ctx) {
        return (T) new Composite(parent, SWT.NONE);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T bind(Composite parent, Element element, BindingContext ctx) {
        String layoutId = getAttribute(element, "layout", "fill");
        LayoutManager layoutMgr = ctx.findLayoutManager(layoutId);
        if (layoutMgr == null) {
            throw new IllegalArgumentException("No layout manager bound to "
                    + layoutId);
        }
        LayoutManager oldLayout = ctx.getLayout();
        Layout layout = layoutMgr.getLayout(element);
        Composite ctrl = super.bind(parent, element, ctx);
        ctrl.setLayout(layout);
        ctx.setLayout(layoutMgr);
        Node child = element.getFirstChild();
        while (child != null) {
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                UIObject<?> obj = ctx.getBinding((Element) child);
                obj.bind(ctrl, (Element) child, ctx);
            }
            child = child.getNextSibling();
        }
        ctx.setLayout(oldLayout);
        return (T) ctrl;
    }

}
