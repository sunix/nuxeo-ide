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
package org.nuxeo.ide.sdk.ui.widgets;

import java.util.List;

import org.eclipse.jdt.ui.ISharedImages;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.SDKInfo;
import org.nuxeo.ide.sdk.SDKRegistry;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class SDKTableViewerFactory {

    public static CheckboxTableViewer getTable(Composite parent) {
        final CheckboxTableViewer tv = CheckboxTableViewer.newCheckList(parent,
                SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);

        tv.setContentProvider(new SDKContentProvider());

        TableViewerColumn column = new TableViewerColumn(tv, SWT.NONE);
        column.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                return ((SDKInfo) element).getName();
            }

            @Override
            public Image getImage(Object element) {
                return JavaUI.getSharedImages().getImage(
                        ISharedImages.IMG_OBJS_LIBRARY);
            }
        });
        TableColumn col = column.getColumn();
        col.setText("Name");
        col.setWidth(100);
        col.setResizable(true);

        column = new TableViewerColumn(tv, SWT.NONE);
        column.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                return ((SDKInfo) element).getVersion();
            }
        });
        col = column.getColumn();
        col.setText("Version");
        col.setWidth(100);
        col.setResizable(true);

        column = new TableViewerColumn(tv, SWT.NONE);
        column.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                return ((SDKInfo) element).getInstallDirectory().getAbsolutePath();
            }
        });
        col = column.getColumn();
        col.setText("Install Location");
        col.setWidth(350);
        col.setResizable(true);

        tv.getTable().setHeaderVisible(true);
        tv.getTable().setLinesVisible(true);

        tv.setInput(Boolean.TRUE); // dummy input

        tv.addCheckStateListener(new ICheckStateListener() {
            @Override
            public void checkStateChanged(CheckStateChangedEvent event) {
                if (event.getChecked()) {
                    Object target = event.getElement();
                    for (Object alreadyChecked : tv.getCheckedElements()) {
                        if (!target.equals(alreadyChecked)) {
                            tv.setChecked(alreadyChecked, false);
                        }
                    }
                }
            }
        });
        return tv;

    }

    public static class SDKContentProvider implements
            IStructuredContentProvider {
        @Override
        public Object[] getElements(Object inputElement) {
            try {
                List<SDKInfo> sdks = SDKRegistry.getConfiguredSDKs();
                return sdks.toArray(new SDKInfo[sdks.size()]);
            } catch (Exception e) {
                UI.showError("Failed to get configured SDKs", e);
                return null;
            }
        }

        @Override
        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            // do nothing
        }

        @Override
        public void dispose() {
            // do nothing
        }
    }

}
