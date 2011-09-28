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
package org.nuxeo.ide.sdk.server;

import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.SDKInfo;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StopServer extends ProcessRunner {

    protected ServerController ctrl;

    public StopServer(ServerController ctrl) throws Exception {
        super(ctrl.newProcessBuilder("stop", false));
        this.ctrl = ctrl;
    }

    @Override
    protected void started() {
        ctrl.fireServerStopping();
    }

    @Override
    protected void terminated(int status, Throwable e) {
        if (e != null) {
            UI.showError("Failed to stop Nuxeo Server" + e.getMessage(), e);
        } else {
            ctrl.fireServerStopped();
        }
    }

}
