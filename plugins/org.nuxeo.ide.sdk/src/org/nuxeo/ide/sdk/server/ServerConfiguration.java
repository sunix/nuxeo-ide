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

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ServerConfiguration {

    private final static Preferences getPreferences() {
        return new InstanceScope().getNode(SDKPlugin.PLUGIN_ID).node(
                "ServerConfig");
    }

    public static ServerConfiguration getDefault() throws BackingStoreException {
        Preferences prefs = getPreferences();
        ServerConfiguration config = new ServerConfiguration();
        config.setVmArgs(prefs.get("vm_args", config.getVmArgs()));
        config.setSuspend(prefs.getBoolean("suspend", Boolean.FALSE));
        config.setDebugPort(prefs.get("port", config.getDebugPort()));
        return config;
    }

    public static void setDefault(ServerConfiguration config)
            throws BackingStoreException {
        Preferences prefs = getPreferences();
        prefs.put("vm_args", config.getVmArgs());
        prefs.putBoolean("suspend", config.getSuspend());
        prefs.put("port", config.getDebugPort());
    }

    protected String vmArgs;

    protected boolean suspend;

    protected String debugPort;

    public ServerConfiguration() {
        debugPort = "8000";
        suspend = false;
        vmArgs = "-Xms512m -Xmx1024m -XX:MaxPermSize=512m -Dsun.rmi.dgc.client.gcInterval=3600000 -Dsun.rmi.dgc.server.gcInterval=3600000 -Dfile.encoding=UTF-8";
    }

    public void setVmArgs(String vmArgs) {
        this.vmArgs = vmArgs;
    }

    public String getVmArgs() {
        return vmArgs;
    }

    public void setSuspend(boolean suspend) {
        this.suspend = suspend;
    }

    public boolean getSuspend() {
        return suspend;
    }

    public void setDebugPort(String debugPort) {
        this.debugPort = debugPort;
    }

    public String getDebugPort() {
        return debugPort;
    }

    public String getVmArgs(boolean isDebug) {
        String args = vmArgs.trim();
        if (isDebug) {
            String debugArgs = getDebugVmArgs();
            if (args.length() == 0) {
                args = debugArgs;
            } else {
                args = args + " " + debugArgs;
            }
            return args;
        } else if (args.length() == 0) {
            return null;
        } else {
            return args;
        }
    }

    public String getDebugVmArgs() {
        return "-Xdebug -Xrunjdwp:transport=dt_socket,address=" + debugPort
                + ",server=y,suspend=" + (suspend ? "y" : "n");
    }

}
