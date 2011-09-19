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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.nuxeo.ide.common.forms.BindingContext;
import org.nuxeo.ide.common.forms.HasValue;
import org.nuxeo.ide.common.forms.UIObject;
import org.nuxeo.ide.common.forms.Validator;
import org.nuxeo.ide.common.forms.WidgetName;
import org.w3c.dom.Element;

/**
 * @author <a href="mailto:ldoguin@nuxeo.com">Laurent Doguin</a>
 *
 */
@WidgetName("permVisibilityTable")
public class PermissionVisibilityTableWidget extends UIObject<Table> implements HasValue {

    private List<PermissionVisibilityItem> items;

    @Override
    protected Table createControl(Composite parent, Element element,
            BindingContext ctx) {
        items = new LinkedList<PermissionVisibilityItem>();

        Table table = new Table(parent, SWT.BORDER | SWT.MULTI);
        table.setLinesVisible(true);
        table.setHeaderVisible(true);

        TableColumn permissionColumn = new TableColumn(table, SWT.NONE);
        permissionColumn.setWidth(200);
        permissionColumn.setText("Permission");

        TableColumn orderColumn = new TableColumn(table, SWT.NONE);
        orderColumn.setWidth(50);
        orderColumn.setText("Order");


        TableColumn showColumn = new TableColumn(table, SWT.NONE);
        showColumn.setWidth(50);
        showColumn.setText("Show");

        TableColumn deleteColumn = new TableColumn(table, SWT.NONE);
        deleteColumn.setWidth(100);
        deleteColumn.setText("Delete");

        return table;
    }

    public void addTableItem(PermissionVisibilityItem item) {
        items.add(item);
        TableItem tb = new TableItem(getControl(), SWT.NONE);
        tb.setText(0, item.getPermissionName());
        tb.setText(1, item.getOrder());
        tb.setText(2, item.getShow().toString());

        TableEditor tEditor = new TableEditor(getControl());
        Button button = new Button(getControl(), SWT.PUSH);
        button.setText("Delete");
        button.computeSize(SWT.DEFAULT, getControl().getItemHeight());

        button.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                items.remove(getControl().getSelectionIndex());
                getControl().remove(getControl().getSelectionIndex());
                getControl().redraw();
            }

        });

        tEditor.grabHorizontal = true;
        tEditor.minimumHeight = button.getSize().y;
        tEditor.minimumWidth = button.getSize().x;
        tEditor.setEditor(button, tb, 3);
    }

    @Override
    public Object getValue() {
        TableItem[] items = getControl().getItems();
        return items;
    }

    @Override
    public String getValueAsString() {
        return getValue().toString();
    }

    @Override
    public void setValue(Object value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setValidators(List<Validator> validators) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Validator> getValidators() {
        // TODO Auto-generated method stub
        return null;
    }
}
