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
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.nuxeo.ide.common.PostModificationTimer;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class TableBrowser extends Composite {

    protected final ViewerFilter[] emptyFilters = new ViewerFilter[0];

    protected Filter filter;

    protected Text filterText;

    protected PostModificationTimer timer;

    protected TableViewer tv;

    public TableBrowser(Composite parent) {
        this(parent, SWT.BORDER | SWT.ICON_SEARCH | SWT.ICON_CANCEL, SWT.BORDER
                | SWT.H_SCROLL | SWT.V_SCROLL);
    }

    public TableBrowser(Composite parent, int filterStyle, int tableStyle) {
        super(parent, SWT.NONE);
        createContent(filterStyle, tableStyle);
    }

    public TableViewer getTableViewer() {
        return tv;
    }

    public Text getFilterText() {
        return filterText;
    }

    protected void createContent(int filterStyle, int tableStyle) {
        setLayout(new GridLayout());
        GridData gd = new GridData();
        gd.horizontalAlignment = SWT.FILL;
        gd.grabExcessHorizontalSpace = true;
        filterText = new Text(this, SWT.SEARCH | filterStyle);
        filterText.setLayoutData(gd);

        tv = createTable(tableStyle);
        initTable(tv);
        filter = new Filter();
        tv.setFilters(new ViewerFilter[] { filter });

        gd = new GridData();
        gd.horizontalAlignment = SWT.FILL;
        gd.verticalAlignment = SWT.FILL;
        gd.grabExcessHorizontalSpace = true;
        gd.grabExcessVerticalSpace = true;
        tv.getTable().setLayoutData(gd);

        timer = new PostModificationTimer() {
            @Override
            public void run() {
                if (tv.getTable().isDisposed()) {
                    return;
                }
                String text = filterText.getText().trim();
                filter.setText(text.length() == 0 ? null : text);
                tv.refresh();
            }
        };

        filterText.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                timer.touch();
            }
        });
        timer.start();
    }

    public void setInput(Object object) {
        tv.setInput(object);
    }

    protected TableViewer createTable(int tableStyle) {
        return new TableViewer(this, tableStyle);
    }

    protected abstract boolean acceptElement(Object object, String filter);

    protected abstract void initTable(TableViewer tv);

    protected class Filter extends ViewerFilter {
        protected String text;

        protected Filter() {
        }

        public void setText(String text) {
            this.text = text != null ? text.toLowerCase() : null;
        }

        public String getText() {
            return text;
        }

        @Override
        public boolean select(Viewer viewer, Object parentElement,
                Object element) {
            if (text == null) {
                return true;
            }
            return acceptElement(element, text);
        }
    }

}
