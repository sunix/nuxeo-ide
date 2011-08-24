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
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.nuxeo.ide.common.StringUtils;
import org.nuxeo.ide.common.forms.BindingContext;
import org.nuxeo.ide.common.forms.UIObject;
import org.nuxeo.ide.common.forms.WidgetName;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
@WidgetName("sash")
public class SashWidget extends UIObject<SashForm> {

    @Override
    protected SashForm createControl(Composite parent, Element element,
            BindingContext ctx) {
        boolean isVertical = getBooleanAttribute(element, "vertical", false);
        int style = SWT.NONE;
        if (isVertical) {
            style |= SWT.VERTICAL;
        }
        SashForm sash = (SashForm) new SashForm(parent, style);
        sash.setLayout(new FillLayout());
        return sash;
    }

    @Override
    public SashForm bind(Composite parent, Element element, BindingContext ctx) {
        SashForm sash = super.bind(parent, element, ctx);
        Node child = element.getFirstChild();
        while (child != null) {
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                UIObject<?> obj = ctx.getBinding((Element) child);
                obj.bind(sash, (Element) child, ctx);
            }
            child = child.getNextSibling();
        }
        String weights = getAttribute(element, "weights", null);
        if (weights != null) {
            String[] ar = StringUtils.split(weights, ',', true);
            int[] w = new int[ar.length];
            for (int i = 0; i < w.length; i++) {
                w[i] = Integer.parseInt(ar[i]);
            }
            sash.setWeights(w);
        }
        return sash;
    }

}
