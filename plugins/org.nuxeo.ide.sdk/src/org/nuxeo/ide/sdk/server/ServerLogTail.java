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

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ServerLogTail extends FileTail {

    protected ServerController ctrl;

    public static void removeLogFiles(ServerController ctrl) {
        File log = new File(ctrl.root, "log");
        File[] files = log.listFiles();
        if (files != null) {
            for (File file : files) {
                file.delete();
            }
        }
    }

    static File getLogFile(ServerController ctrl) {
        removeLogFiles(ctrl);
        return new File(ctrl.root, "log/server.log");
    }

    public ServerLogTail(ServerController ctrl) {
        super(getLogFile(ctrl));
        this.ctrl = ctrl;
    }

    @Override
    protected void handleContent(String content) {
        ctrl.fireConsoleText(content);
    }

    @Override
    protected void handleException(Throwable t) {
        ctrl.fireConsoleError(t);
    }
}
