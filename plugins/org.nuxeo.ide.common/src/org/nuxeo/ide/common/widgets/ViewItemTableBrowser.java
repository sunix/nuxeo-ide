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
package org.nuxeo.ide.common.widgets;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.widgets.Composite;
import org.nuxeo.ide.common.IViewItem;
import org.nuxeo.ide.common.ViewItemProvider;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ViewItemTableBrowser extends TableBrowser {

    public ViewItemTableBrowser(Composite parent) {
        super(parent);
    }

    public ViewItemTableBrowser(Composite parent, int filterStyle,
            int tableStyle) {
        super(parent, filterStyle, tableStyle);
    }

    protected void initTable(TableViewer tv) {
        tv.getTable().setLinesVisible(true);
        ViewItemProvider provider = new ViewItemProvider();
        tv.setLabelProvider(provider);
        tv.setContentProvider(provider);
    }

    @Override
    protected boolean acceptElement(Object object, String filter) {
        return ((IViewItem) object).getLabel().toLowerCase().contains(filter);
    }

}
