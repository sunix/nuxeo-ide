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

import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ViewPart;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.NuxeoSDK;
import org.nuxeo.ide.sdk.SDKChangedListener;
import org.nuxeo.ide.sdk.comp.ComponentRef;
import org.nuxeo.ide.sdk.comp.ExtensionPointRef;
import org.nuxeo.ide.sdk.comp.ServiceRef;
import org.nuxeo.ide.sdk.server.ui.widgets.ComponentBrowser;
import org.nuxeo.ide.sdk.server.ui.widgets.ExtensionPointBrowser;
import org.nuxeo.ide.sdk.server.ui.widgets.ServiceBrowser;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ComponentView extends ViewPart implements SDKChangedListener {

    protected Form form;

    protected FormToolkit toolkit;

    protected CTabFolder tabs;

    protected ServiceBrowser services;

    protected ComponentBrowser components;

    protected ExtensionPointBrowser xpoints;

    @Override
    public void init(IViewSite site) throws PartInitException {
        super.init(site);
        NuxeoSDK.addSDKChangedListener(this);
        initInputs();
    }

    @Override
    public void handleSDKChanged(NuxeoSDK sdk) {
        initInputs();
    }

    protected void initInputs() {
        if (services != null) {
            services.setDefaultInput();
            components.setDefaultInput();
            xpoints.setDefaultInput();
        }
    }

    @Override
    public void createPartControl(Composite parent) {
        toolkit = new FormToolkit(getSite().getShell().getDisplay());

        form = toolkit.createForm(parent);
        form.getBody().setLayout(new GridLayout());

        form.setText("Browse Nuxeo Components");

        tabs = new CTabFolder(form.getBody(), SWT.TOP | SWT.FLAT | SWT.H_SCROLL
                | SWT.V_SCROLL);

        services = new ServiceBrowser(tabs);
        toolkit.adapt(services);
        CTabItem item = new CTabItem(tabs, SWT.NONE);
        item.setControl(services);
        item.setText("Services");
        components = new ComponentBrowser(tabs);
        toolkit.adapt(components);
        item = new CTabItem(tabs, SWT.NONE);
        item.setControl(components);
        item.setText("Components");
        xpoints = new ExtensionPointBrowser(tabs);
        toolkit.adapt(xpoints);
        item = new CTabItem(tabs, SWT.NONE);
        item.setControl(xpoints);
        item.setText("Extension Points");

        GridData gd = new GridData();
        gd.horizontalAlignment = SWT.FILL;
        gd.grabExcessHorizontalSpace = true;
        gd.verticalAlignment = SWT.FILL;
        gd.grabExcessVerticalSpace = true;
        tabs.setLayoutData(gd);

        toolkit.adapt(tabs);

        tabs.setSelection(0);

        IOpenListener openListener = new IOpenListener() {
            @Override
            public void open(OpenEvent event) {
                if (!event.getSelection().isEmpty()) {
                    openElement(((IStructuredSelection) event.getSelection()).getFirstElement());
                }
            }
        };
        services.getTableViewer().addOpenListener(openListener);
        components.getTableViewer().addOpenListener(openListener);
        xpoints.getTableViewer().addOpenListener(openListener);
        initInputs();
    }

    protected void openElement(Object element) {
        ComponentRef ref = null;
        if (element instanceof ComponentRef) {
            ref = (ComponentRef) element;
        } else if (element instanceof ServiceRef) {
            ServiceRef service = (ServiceRef) element;
            ref = NuxeoSDK.getDefault().getComponentIndex().getComponent(
                    service.getComponent());
        } else if (element instanceof ExtensionPointRef) {
            ExtensionPointRef xpoint = (ExtensionPointRef) element;
            ref = NuxeoSDK.getDefault().getComponentIndex().getComponent(
                    xpoint.getComponent());
        }
        if (ref != null) {
            openEditor(ref);
        } else {
            UI.showError("No component matching this resource was found");
        }
    }

    protected void openEditor(ComponentRef ref) {
        try {
            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(
                    ref, ComponentEditor.class.getName());
        } catch (Exception e) {
            UI.showError("Failed to open component editor", e);
        }
    }

    @Override
    public void setFocus() {
        tabs.setFocus();
        services.getFilterText().setFocus();
        // ((ServiceBrowser)
        // tabs.getSelection().getControl()).getFilter().setFocus();
    }

    @Override
    public void dispose() {
        if (toolkit != null) {
            toolkit.dispose();
            toolkit = null;
        }
        super.dispose();
    }

}
