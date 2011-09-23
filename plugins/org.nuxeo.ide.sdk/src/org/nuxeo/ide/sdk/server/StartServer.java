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

import java.io.File;

import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.SDKInfo;

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

    public StartServer(ServerController ctrl) {
        super(SDKInfo.newCommandLine(ctrl.root, "start"), new File(ctrl.root,
                "bin"));
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
        } else {
            if (status == 0) {
                ctrl.fireServerStarted();
            } else {
                ctrl.fireServerStopped();
                UI.showError("Failed to start the server: "
                        + getErrorMessage(status));
            }
        }
    }

    private static String getErrorMessage(int status) {
        switch (status) {
        case 0:
            return "OK";
        case 2:
            return "invalid or excess argument(s)";
        case 3:
            return "unimplemented feature";
        case 4:
            return "user has insufficient privilege";
        case 5:
            return "program is not installed";
        case 6:
            return "program is not configured";
        case 7:
            return "program is not running";
        default:
            return "Unknown Error (" + status + ")";
        }
    }
}
