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
package org.nuxeo.ide.sdk.ui.server;

import java.io.File;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.nuxeo.ide.common.FormPreferencePage;
import org.nuxeo.ide.common.forms.ActionHandler;
import org.nuxeo.ide.common.forms.Form;
import org.nuxeo.ide.common.forms.UIObject;
import org.nuxeo.ide.sdk.SDKInfo;
import org.nuxeo.ide.sdk.SDKRegistry;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class SDKPreferencePage extends FormPreferencePage implements
        IWorkbenchPreferencePage {

    public SDKPreferencePage() {
        super(new SDKFormData());
    }

    public void refresh() {
        ((SDKTableWidget) form.getWidget("sdks")).viewer.setInput(Boolean.TRUE);
    }

    public SDKInfo getSelectedSDK() {
        IStructuredSelection selection = ((IStructuredSelection) ((SDKTableWidget) form.getWidget("sdks")).viewer.getSelection());
        return selection == null ? null
                : (SDKInfo) selection.getFirstElement();
    }

    public SDKInfo getCheckedSDK() {
        Object[] objs = ((SDKTableWidget) form.getWidget("sdks")).viewer.getCheckedElements();
        return objs.length > 0 ? (SDKInfo) objs[0] : null;
    }

    @Override
    protected Form createForm() {
        Form form = new Form();
        form.addWidgetType(SDKTableWidget.class);
        form.addActionHandler("add", new ActionHandler() {
            @Override
            public void handleAction(Form form, UIObject<?> obj, Object event) {
                addSDK();
            }
        });
        form.addActionHandler("remove", new ActionHandler() {
            @Override
            public void handleAction(Form form, UIObject<?> obj, Object event) {
                removeSDK();
            }
        });
        form.addActionHandler("download", new ActionHandler() {
            @Override
            public void handleAction(Form form, UIObject<?> obj, Object event) {
                download();
            }
        });
        form.addActionHandler("reload", new ActionHandler() {
            @Override
            public void handleAction(Form form, UIObject<?> obj, Object event) {
                reload();
            }
        });
        return form;
    }

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
        // add listeners to control button states
        Table table = (Table) form.getWidgetControl("sdks");
        table.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                updateButtonBar();
            }
        });
    }

    public void addSDK() {
        SDKTableWidget sdkWidget = (SDKTableWidget) form.getWidget("sdks");
        DirectoryDialog dlg = new DirectoryDialog(getShell());
        String dir = dlg.open();
        if (dir != null) {
            // TODO NuxeoSDK sdk = NuxeoSDK.loadSDK(new File(dir));
            SDKInfo sdk = new SDKInfo(dir, "1.0.0");
            sdkWidget.viewer.add(sdk);
        }
        updateButtonBar();
    }

    public void removeSDK() {
        SDKTableWidget sdkWidget = (SDKTableWidget) form.getWidget("sdks");
        SDKInfo sdk = getSelectedSDK();
        if (sdk != null) {
            sdkWidget.viewer.remove(sdk);
        }
        updateButtonBar();
    }

    public void download() {
        System.out.println("Download SDK");
    }

    public void reload() {
        System.out.println("Reload SDK");
    }

    protected void updateButtonBar() {
        SDKTableWidget sdkWidget = (SDKTableWidget) form.getWidget("sdks");
        boolean selected = sdkWidget.viewer.getTable().getSelectionCount() > 0;
        form.getWidgetControl("remove").setEnabled(selected);
        form.getWidgetControl("reload").setEnabled(selected);
    }

    @Override
    protected void performDefaults() {
        SDKTableWidget sdkWidget = (SDKTableWidget) form.getWidget("sdks");
        sdkWidget.viewer.setInput(Boolean.TRUE);
        sdkWidget.setDefaultSDK(SDKRegistry.getDefaultSDKId());
    }
}
