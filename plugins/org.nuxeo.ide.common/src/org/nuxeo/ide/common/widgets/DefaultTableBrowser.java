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

import java.util.Collection;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.nuxeo.ide.common.DefaultLabelProvider;
import org.nuxeo.ide.common.HasLabel;
import org.nuxeo.ide.common.UI;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class DefaultTableBrowser extends TableBrowser {

    public DefaultTableBrowser(Composite parent) {
        super(parent);
    }

    public DefaultTableBrowser(Composite parent, int filterStyle, int tableStyle) {
        super(parent, filterStyle, tableStyle);
    }

    @Override
    protected boolean acceptElement(Object object, String filter) {
        return ((HasLabel) object).getLabel().toLowerCase().contains(filter);
    }

    @Override
    protected void initTable(TableViewer tv) {
        tv.getTable().setLinesVisible(true);
        tv.setLabelProvider(new DefaultLabelProvider());
        tv.setContentProvider(getContentProvider());
    }

    protected IStructuredContentProvider getContentProvider() {
        return new IStructuredContentProvider() {
            @Override
            public Object[] getElements(Object inputElement) {
                if (inputElement != null) {
                    if (inputElement.getClass().isArray()) {
                        return (Object[]) inputElement;
                    } else if (inputElement instanceof Collection) {
                        return ((Collection<?>) inputElement).toArray();
                    }
                }
                return UI.EMPTY_OBJECTS;
            }

            @Override
            public void inputChanged(Viewer viewer, Object oldInput,
                    Object newInput) {
            }

            @Override
            public void dispose() {
            }
        };
    }

}
