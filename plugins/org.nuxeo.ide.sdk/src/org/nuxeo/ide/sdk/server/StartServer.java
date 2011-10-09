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
import org.nuxeo.ide.sdk.NuxeoSDK;
import org.nuxeo.ide.sdk.deploy.Deployment;
import org.nuxeo.ide.sdk.deploy.DeploymentPreferences;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StartServer extends ProcessRunner {

    public static boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.indexOf("win") >= 0);
    }

    protected ServerController ctrl;

    public StartServer(ServerController ctrl) throws Exception {
        super(ctrl.newProcessBuilder("start", false));
        this.ctrl = ctrl;
    }

    public StartServer(ServerController ctrl, boolean isDebug) throws Exception {
        super(ctrl.newProcessBuilder("start", isDebug));
        this.ctrl = ctrl;
    }

    @Override
    protected void started() {
        ctrl.fireServerStarting();
    }

    @Override
    protected void terminated(int status, Throwable e) {
        if (e != null) {
            UI.showError("Failed to start Nuxeo Server" + e.getMessage(), e);
            return;
        }
        if (status == 0) {
            // hot deploy projects
            try {
                Deployment deployment = DeploymentPreferences.load().getDefault();
                NuxeoSDK.getDefault().reloadDeployment(deployment);
            } catch (Exception de) {
                UI.showError("Cannot hot deploy bundles, please restart", de);
            }
        }
        // notify listeners
        ctrl.fireServerStarted();
    }

}
