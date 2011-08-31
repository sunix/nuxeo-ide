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
package org.nuxeo.ide.connect;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.SecurePreferencesFactory;
import org.nuxeo.ide.connect.studio.StudioProject;
import org.osgi.service.prefs.Preferences;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ConnectPreferences {

    public static IEclipsePreferences getPreferencesNode() {
        return new ConfigurationScope().getNode("nuxeo.sdk.connect");
    }

    public static ISecurePreferences getSecurePreferencesNode() {
        return SecurePreferencesFactory.getDefault().node("nuxeo.sdk.connect");
    }

    protected List<StudioProject> projects;

    protected String username;

    protected String password;

    protected String host;

    public ConnectPreferences() {
        projects = new ArrayList<StudioProject>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getHost() {
        return host;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public List<StudioProject> getProjects() {
        return projects;
    }

    public StudioProject[] getProjectsArray() {
        return projects.toArray(new StudioProject[projects.size()]);
    }

    public void addProject(StudioProject project) {
        projects.add(project);
    }

    public void removeProject(StudioProject project) {
        projects.remove(project);
    }

    public void clear() {
        projects.clear();
    }

    public boolean isEmpty() {
        return projects.isEmpty();
    }

    public int size() {
        return projects.size();
    }

    public void save() throws Exception {
        IEclipsePreferences root = getPreferencesNode();
        ISecurePreferences sroot = getSecurePreferencesNode();

        sroot.removeNode();
        sroot = getSecurePreferencesNode();
        for (String key : root.childrenNames()) {
            root.node(key).removeNode();
        }

        if (host != null && host.length() > 0) {
            root.put("host", host);
        } else {
            root.remove("host");
        }
        if (username != null && username.length() > 0) {
            root.put("username", username);
        } else {
            root.remove("username");
        }
        if (password != null && password.length() > 0) {
            sroot.put(username, password, true);
            sroot.flush();
        } else {
            ISecurePreferences parent = sroot.parent();
            sroot.removeNode();
            parent.flush();
        }

        for (StudioProject p : projects) {
            Preferences node = root.node(p.getId());
            node.put("name", p.getName());
            node.put("targetVersion", p.getTargetVersion());
        }

        root.flush();
        root.sync();
    }

    public static ConnectPreferences load() throws Exception {
        IEclipsePreferences root = getPreferencesNode();
        ISecurePreferences sroot = getSecurePreferencesNode();

        ConnectPreferences prefs = new ConnectPreferences();
        prefs.setHost(root.get("host", Connector.DEFAULT_URL));
        prefs.setUsername(root.get("username", null));
        String username = prefs.getUsername();
        if (username != null) {
            prefs.setPassword(sroot.get(username, null));
        }

        for (String key : root.childrenNames()) {
            Preferences node = root.node(key);
            StudioProject p = new StudioProject(key);
            p.setName(node.get("name", key));
            p.setTargetVersion(node.get("targetVersion", null));
            prefs.addProject(p);
        }

        return prefs;
    }
}
