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
package org.nuxeo.ide.sdk.server.ui;

import java.io.File;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.nuxeo.ide.common.FormPreferencePage;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.common.forms.ActionHandler;
import org.nuxeo.ide.common.forms.Form;
import org.nuxeo.ide.common.forms.UIObject;
import org.nuxeo.ide.sdk.NuxeoSDK;
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
        return selection == null ? null : (SDKInfo) selection.getFirstElement();
    }

    public SDKInfo getCheckedSDK() {
        Object[] objs = ((SDKTableWidget) form.getWidget("sdks")).viewer.getCheckedElements();
        return objs.length > 0 ? (SDKInfo) objs[0] : null;
    }

    @Override
    protected Form createForm() {
        @SuppressWarnings("hiding")
        Form form = new Form();
        form.addWidgetType(SDKTableWidget.class);
        form.addActionHandler("add", new ActionHandler() {
            @Override
            public void handleAction(@SuppressWarnings("hiding") Form form, UIObject<?> obj, Object event) {
                addSDK();
            }
        });
        form.addActionHandler("remove", new ActionHandler() {
            @Override
            public void handleAction(@SuppressWarnings("hiding") Form form, UIObject<?> obj, Object event) {
                removeSDK();
            }
        });
        form.addActionHandler("download", new ActionHandler() {
            @Override
            public void handleAction(@SuppressWarnings("hiding") Form form, UIObject<?> obj, Object event) {
                downloadSDK();
            }
        });
        form.addActionHandler("reload", new ActionHandler() {
            @Override
            public void handleAction(@SuppressWarnings("hiding") Form form, UIObject<?> obj, Object event) {
                reloadSDK();
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
            try {
                SDKInfo sdk = SDKInfo.loadSDK(new File(dir));
                sdkWidget.viewer.add(sdk);
            } catch (Exception e) {
                UI.showError("Not a valid Nuxeo SDK", e);
            }
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

    public void downloadSDK() {
        SDKTableWidget sdkWidget = (SDKTableWidget) form.getWidget("sdks");
        Shell shell = sdkWidget.getControl().getParent().getShell();
        String text = "Would you like to open the Nuxeo SDK download page in you web browser ?\n\nFrom there, you can download the latest SDK and extract it to the location of your choice. Register it to eclipse with the \"Add\" button.\n";
        Dialog dialog = new MessageDialog(shell, "Download SDK", null, text,
                MessageDialog.QUESTION,
                new String[] { "open browser", "cancel" }, 0);
        dialog.open();
        if (dialog.getReturnCode() != Dialog.OK) {
            return;
        }
        Program.launch("http://doc.nuxeo.com/x/b4KE");
    }

    public void reloadSDK() {
        NuxeoSDK.reload();
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

    @Override
    public boolean performOk() {
        BusyIndicator.showWhile(null, new Runnable() {
            @Override
            public void run() {
                SDKPreferencePage.super.performOk();
            }
        });
        return true;
    }
}
