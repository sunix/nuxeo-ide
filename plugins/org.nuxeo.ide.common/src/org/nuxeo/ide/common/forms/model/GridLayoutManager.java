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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.nuxeo.ide.common.forms.LayoutManager;
import org.nuxeo.ide.common.forms.UIObject;
import org.w3c.dom.Element;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class GridLayoutManager extends LayoutManager {

    public GridLayoutManager() {
        super("grid");
    }

    @Override
    public Layout getLayout(Element element) {
        int cols = UIObject.getIntAttribute(element, "cols", 1);
        int vspacing = UIObject.getIntAttribute(element, "vspacing", 5);
        int hspacing = UIObject.getIntAttribute(element, "hspacing", 5);
        GridLayout layout = new GridLayout(cols, false);
        layout.horizontalSpacing = hspacing;
        layout.verticalSpacing = vspacing;
        return layout;
    }

    @Override
    public void applyLayout(Control ctrl, Element element) {
        GridData gd = new GridData();
        ctrl.setLayoutData(gd);
        String halign = UIObject.getAttribute(element, "halign");
        String valign = UIObject.getAttribute(element, "valign");
        int colspan = UIObject.getIntAttribute(element, "colspan", 0);
        int rowspan = UIObject.getIntAttribute(element, "rowspan", 0);
        boolean hfill = UIObject.getBooleanAttribute(element, "hfill", false);
        boolean vfill = UIObject.getBooleanAttribute(element, "vfill", false);

        if (hfill) {
            gd.grabExcessHorizontalSpace = true;
            gd.horizontalAlignment = SWT.FILL;
        }
        if (vfill) {
            gd.grabExcessVerticalSpace = true;
            gd.verticalAlignment = SWT.FILL;
        }
        if (valign != null) {
            if ("top".equals(valign)) {
                gd.verticalAlignment = SWT.TOP;
            }
            if ("center".equals(valign)) {
                gd.verticalAlignment = SWT.CENTER;
            }
            if ("bottom".equals(valign)) {
                gd.verticalAlignment = SWT.BOTTOM;
            }
            if ("fill".equals(valign)) {
                gd.verticalAlignment = SWT.FILL;
            }
        }
        if (halign != null) {
            if ("left".equals(halign)) {
                gd.horizontalAlignment = SWT.LEFT;
            }
            if ("center".equals(halign)) {
                gd.horizontalAlignment = SWT.CENTER;
            }
            if ("right".equals(halign)) {
                gd.horizontalAlignment = SWT.RIGHT;
            }
            if ("fill".equals(halign)) {
                gd.verticalAlignment = SWT.FILL;
            }
        }
        if (colspan > 0) {
            gd.horizontalSpan = colspan;
        }
        if (rowspan > 0) {
            gd.verticalSpan = rowspan;
        }

    }

}
