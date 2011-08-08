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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.common.forms.BindingContext;
import org.nuxeo.ide.common.forms.UIObject;
import org.nuxeo.ide.common.forms.WidgetName;
import org.nuxeo.ide.sdk.SDKInfo;
import org.nuxeo.ide.sdk.SDKRegistry;
import org.nuxeo.ide.sdk.ui.widgets.SDKTableViewerFactory;
import org.w3c.dom.Element;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
@WidgetName("sdks")
public class SDKTableWidget extends UIObject<Table> {

    protected CheckboxTableViewer viewer;

    @Override
    protected Table createControl(Composite parent, Element element,
            BindingContext ctx) {
        viewer = SDKTableViewerFactory.getTable(parent);
        return viewer.getTable();
    }

    public CheckboxTableViewer getViewer() {
        return viewer;
    }

    public void setDefaultSDK(String id) {
        if (id != null) {
            try {
                SDKInfo sdk = SDKRegistry.getSDK(id);
                if (sdk != null) {
                    viewer.setChecked(sdk, true);
                }
            } catch (Exception e) {
                UI.showError("Failed to get SDK", e);
            }
        }
    }

    public SDKInfo getDefaultSDK() {
        Object[] checked = viewer.getCheckedElements();
        return checked.length > 0 ? (SDKInfo) checked[0] : null;
    }

    public List<SDKInfo> getSDKs() {
        ArrayList<SDKInfo> sdks = new ArrayList<SDKInfo>();
        try {
            for (TableItem item : viewer.getTable().getItems()) {
                sdks.add((SDKInfo) item.getData());
            }
        } catch (Exception e) {
            UI.showError("Failed to save SDKs", e);
        }
        return sdks;
    }

}
