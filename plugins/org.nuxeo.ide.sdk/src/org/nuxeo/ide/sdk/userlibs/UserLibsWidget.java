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
package org.nuxeo.ide.sdk.userlibs;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.nuxeo.ide.common.forms.BindingContext;
import org.nuxeo.ide.common.forms.UIObject;
import org.nuxeo.ide.common.forms.WidgetName;
import org.w3c.dom.Element;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
@WidgetName("userlibs")
public class UserLibsWidget extends UIObject<Table> {

    protected TableViewer tv;

    public TableViewer getTableViewer() {
        return tv;
    }

    @Override
    protected Table createControl(Composite parent, Element element,
            BindingContext ctx) {
        tv = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        UserLibViewProvider provider = new UserLibViewProvider();
        tv.setContentProvider(provider);
        tv.setLabelProvider(provider);
        return tv.getTable();
    }

    public void addUserLib(UserLib lib) {
        tv.add(lib);
    }
}
