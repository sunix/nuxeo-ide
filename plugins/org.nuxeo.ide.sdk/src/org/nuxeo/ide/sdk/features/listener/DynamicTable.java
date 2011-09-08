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
package org.nuxeo.ide.sdk.features.listener;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.nuxeo.ide.common.UI;

/**
 * A table that allows the user to enter new rows using a text box.
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class DynamicTable extends Composite {

    protected Text text;

    protected CheckboxTableViewer tv;

    public DynamicTable(Composite parent) {
        this(parent, SWT.DEFAULT, SWT.DEFAULT);
    }

    public DynamicTable(Composite parent, int widthHint, int heightHint) {
        super(parent, SWT.NONE);
        createContent(widthHint, heightHint);
    }

    protected void createContent(int widthHint, int heightHint) {
        GridLayout layout = new GridLayout(2, false);
        layout.horizontalSpacing = 0;
        layout.verticalSpacing = 0;
        setLayout(layout);

        GridData gd = new GridData();
        gd.horizontalAlignment = SWT.FILL;
        gd.grabExcessHorizontalSpace = true;
        text = new Text(this, SWT.FLAT | SWT.BORDER);
        text.setLayoutData(gd);
        final Button btn = new Button(this, SWT.PUSH | SWT.FLAT);
        btn.setText("Add");
        btn.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(
                ISharedImages.IMG_OBJ_ADD));
        btn.setToolTipText("Add a new entry in the table");
        btn.setEnabled(false);

        tv = CheckboxTableViewer.newCheckList(this, SWT.H_SCROLL | SWT.V_SCROLL
                | SWT.BORDER | SWT.FLAT);
        gd = new GridData();
        gd.horizontalAlignment = SWT.FILL;
        gd.verticalAlignment = SWT.FILL;
        gd.grabExcessHorizontalSpace = true;
        gd.grabExcessVerticalSpace = true;
        gd.horizontalSpan = 2;
        gd.heightHint = heightHint;
        gd.widthHint = widthHint;
        tv.getTable().setLayoutData(gd);
        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.character == SWT.CR) {
                    addTextItem();
                } else {
                    btn.setEnabled((text.getText().trim().length() > 0));
                }
            }
        });

        btn.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                addTextItem();
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                widgetSelected(e);
            }
        });

        Provider provider = new Provider();
        tv.setLabelProvider(provider);
        tv.setContentProvider(provider);
    }

    private void addTextItem() {
        String v = text.getText().trim();
        if (v.length() == 0) {
            return;
        }
        Item item = new Item(v);
        tv.add(item);
        tv.setChecked(item, true);
        tv.reveal(item);
    }

    public CheckboxTableViewer getTableViewer() {
        return tv;
    }

    public void setInput(Item[] items) {
        tv.setInput(items);
    }

    public Item[] getSelectedItems() {
        Object[] ar = tv.getCheckedElements();
        Item[] items = new Item[ar.length];
        System.arraycopy(ar, 0, items, 0, ar.length);
        return items;
    }

    public Object[] getSelectedValues() {
        Object[] ar = tv.getCheckedElements();
        if (ar.length == 0) {
            return UI.EMPTY_OBJECTS;
        }
        Object[] values = new Object[ar.length];
        for (int i = 0; i < ar.length; i++) {
            values[i] = ((Item) ar[i]).getData();
        }
        return values;
    }

    public String[] getSelectedLabels() {
        Object[] ar = tv.getCheckedElements();
        String[] labels = new String[ar.length];
        for (int i = 0; i < ar.length; i++) {
            labels[i] = ((Item) ar[i]).getLabel();
        }
        return labels;
    }

    public void setSelectedItems(Item[] items) {
        tv.setCheckedElements(items);
    }

    public static class Item {
        protected String label;

        protected Object data;

        public Item(String label) {
            this(label, label);
        }

        public Item(String label, String data) {
            this.data = data;
            this.label = label;
        }

        public Object getData() {
            return data;
        }

        public String getLabel() {
            return label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    static class Provider extends LabelProvider implements
            IStructuredContentProvider {

        @Override
        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }

        @Override
        public Object[] getElements(Object inputElement) {
            if (inputElement != null && inputElement.getClass().isArray()) {
                return (Object[]) inputElement;
            }
            return UI.EMPTY_OBJECTS;
        }

    }
}
