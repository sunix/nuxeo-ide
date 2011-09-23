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

import org.eclipse.ui.IWorkbenchPreferencePage;
import org.nuxeo.ide.common.FormPreferencePage;
import org.nuxeo.ide.common.forms.Form;
import org.nuxeo.ide.common.forms.FormData;
import org.nuxeo.ide.sdk.server.ServerConfiguration;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ServerPreferencePage extends FormPreferencePage implements
        IWorkbenchPreferencePage, FormData {

    public ServerPreferencePage() {
        super(null);
        this.data = this;
    }

    @Override
    public void load(Form form) throws Exception {
        ServerConfiguration config = ServerConfiguration.getDefault();
        refresh(config);
    }

    @Override
    public void store(Form form) throws Exception {
        ServerConfiguration config = ServerConfiguration.getDefault();
        applyValues(config);
        ServerConfiguration.setDefault(config);
    }

    public void setVmArgs(String v) {
        form.setWidgetValue("args", v.trim());
    }

    public String getVmArgs() {
        return form.getWidgetValueAsString("args").trim();
    }

    public void setPort(String v) {
        form.setWidgetValue("port", v.trim());
    }

    public String getPort() {
        return form.getWidgetValueAsString("port").trim();
    }

    public void setSuspend(boolean suspend) {
        form.setWidgetValue("suspend", suspend ? Boolean.TRUE : Boolean.FALSE);
    }

    public boolean getSuspend() {
        return (Boolean) form.getWidgetValue("suspend");
    }

    public void refresh(ServerConfiguration config) {
        setVmArgs(config.getVmArgs());
        setSuspend(config.getSuspend());
        setPort(config.getDebugPort());
    }

    public void applyValues(ServerConfiguration config) {
        config.setVmArgs(getVmArgs());
        config.setDebugPort(getPort());
        config.setSuspend(getSuspend());
    }

    @Override
    protected void performDefaults() {
        refresh(new ServerConfiguration());
    }
}
