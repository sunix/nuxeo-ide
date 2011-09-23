/*
 * (C) Copyright 2006-2011 Nuxeo SAS (http://nuxeo.com/) and contributors.
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
 *     ldoguin
 */
package org.nuxeo.ide.sdk.features.security.permissionvisibility;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.common.forms.BindingContext;
import org.nuxeo.ide.common.forms.UIObject;
import org.nuxeo.ide.common.forms.WidgetName;
import org.w3c.dom.Element;

/**
 * @author <a href="mailto:ldoguin@nuxeo.com">Laurent Doguin</a>
 * 
 */
@WidgetName("permVisibilityTable")
public class PermissionVisibilityTableWidget extends UIObject<Table> implements
        IStructuredContentProvider {

    protected TableViewer tv;

    @Override
    protected Table createControl(Composite parent, Element element,
            BindingContext ctx) {

        tv = new TableViewer(parent, SWT.FULL_SELECTION | SWT.BORDER
                | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
        tv.setColumnProperties(new String[] { "Permission", "Order", "Show" });
        Table table = tv.getTable();

        table.setLinesVisible(true);
        table.setHeaderVisible(true);

        TableColumn permissionColumn = new TableColumn(table, SWT.NONE);
        permissionColumn.setWidth(250);
        permissionColumn.setText("Permission");

        TableColumn orderColumn = new TableColumn(table, SWT.NONE);
        orderColumn.setWidth(50);
        orderColumn.setText("Order");

        TableColumn showColumn = new TableColumn(table, SWT.NONE);
        showColumn.setWidth(100);
        showColumn.setText("Show");

        final CellEditor[] editors = new CellEditor[3];
        editors[0] = new TextCellEditor(table);
        editors[1] = new TextCellEditor(table);
        editors[2] = new ComboBoxCellEditor(table, new String[] { "true",
                "false" });
        tv.setCellEditors(editors);
        tv.setCellModifier(new ICellModifier() {
            @Override
            public void modify(Object element, String property, Object value) {
                PermissionVisibilityItem item = (PermissionVisibilityItem) ((TableItem) element).getData();
                if ("Permission".equals(property)) {
                    item.setPermissionName((String) value);
                } else if ("Order".equals(property)) {
                    try {
                        Integer.parseInt((String) value);
                        item.setOrder((String) value);
                    } catch (Exception e) {
                    }
                } else if ("Show".equals(property)) {
                    item.setShow(((Integer) value).intValue() == 0);
                }
                tv.update(item, null);
            }

            @Override
            public Object getValue(Object element, String property) {
                PermissionVisibilityItem item = (PermissionVisibilityItem) element;
                if ("Permission".equals(property)) {
                    return item.getPermissionName();
                } else if ("Order".equals(property)) {
                    return item.getOrder();
                } else if ("Show".equals(property)) {
                    return item.getShow() ? 0 : 1;
                }
                return null;
            }

            @Override
            public boolean canModify(Object element, String property) {
                return true;
            }
        });

        tv.setLabelProvider(new MyLabelProvider());
        tv.setContentProvider(this);
        tv.setInput(new PermissionVisibilityItem[0]);
        return table;
    }

    public boolean isEmpty() {
        return tv.getTable().getItemCount() <= 0;
    }

    public void addTableItem(PermissionVisibilityItem item) {
        tv.add(item);
    }

    public PermissionVisibilityItem[] getPermissionItems() {
        TableItem[] items = getControl().getItems();
        PermissionVisibilityItem[] result = new PermissionVisibilityItem[items.length];
        for (int i = 0; i < items.length; i++) {
            result[i] = (PermissionVisibilityItem) items[i].getData();
        }
        return result;
    }

    @Override
    public Object[] getElements(Object inputElement) {
        if (inputElement != null && inputElement.getClass().isArray()) {
            return (Object[]) inputElement;
        }
        return UI.EMPTY_OBJECTS;
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

    @Override
    public void dispose() {
    }

    static class MyLabelProvider extends LabelProvider implements
            ITableLabelProvider {
        @Override
        public Image getColumnImage(Object element, int columnIndex) {
            return null;
        }

        @Override
        public String getColumnText(Object element, int columnIndex) {
            if (columnIndex == 0) {
                return ((PermissionVisibilityItem) element).getPermissionName();
            } else if (columnIndex == 1) {
                return ((PermissionVisibilityItem) element).getOrder();
            } else if (columnIndex == 2) {
                return ((PermissionVisibilityItem) element).getShow() ? "true"
                        : "false";
            }
            return "";
        }
    }
}
