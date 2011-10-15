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
import org.nuxeo.ide.common.ViewItemProvider;
import org.nuxeo.ide.sdk.NuxeoSDK;
import org.nuxeo.ide.sdk.SDKChangedListener;
import org.nuxeo.ide.sdk.comp.ComponentEditorInput;
import org.nuxeo.ide.sdk.comp.ComponentModel;
import org.nuxeo.ide.sdk.comp.ComponentRegistry;
import org.nuxeo.ide.sdk.comp.ExtensionPointModel;
import org.nuxeo.ide.sdk.comp.ServiceModel;
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

    protected ComponentRegistry registry;

    @Override
    public void init(IViewSite site) throws PartInitException {
        super.init(site);
        NuxeoSDK.addSDKChangedListener(this);
        initServer();
    }

    @Override
    public void handleSDKChanged(NuxeoSDK sdk) {
        initServer();
    }

    protected void initServer() {
        NuxeoSDK sdk = NuxeoSDK.getDefault();
        if (sdk != null) {
            registry = sdk.getComponentProvider().getComponentRegistry();
        } else {
            registry = new ComponentRegistry();
        }
        initInputs();
    }

    protected void initInputs() {
        if (services != null) {
            services.setInputRegistry(registry);
            components.setInputRegistry(registry);
            xpoints.setInputRegistry(registry);
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
        if (element instanceof ComponentModel) {
            ComponentModel comp = (ComponentModel) element;
            openEditor(comp);
        } else if (element instanceof ServiceModel) {
            ServiceModel service = (ServiceModel) element;
            openEditor(service.getComponent());
        } else if (element instanceof ExtensionPointModel) {
            ExtensionPointModel xpoint = (ExtensionPointModel) element;
            openEditor(xpoint.getComponent());
        }
    }

    protected void openEditor(ComponentModel component) {
        try {
            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(
                    new ComponentEditorInput(component),
                    ComponentEditor.class.getName());
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

    static class MyProvider extends ViewItemProvider {

        @Override
        public Object[] getElements(Object inputElement) {
            if (inputElement instanceof ComponentRegistry) {
                return ((ComponentRegistry) inputElement).getComponents();
            } else if (inputElement != null
                    && inputElement.getClass().isArray()) {
                return (Object[]) inputElement;
            }
            return UI.EMPTY_OBJECTS;
        }

    }
}
