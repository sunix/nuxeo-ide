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
package org.nuxeo.ide.sdk.userlibs;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class UserLibPreferences {

    protected boolean modified = false;

    public static IEclipsePreferences getPreferencesNode() {
        return new ConfigurationScope().getNode("nuxeo.sdk.userlibs");
    }

    /**
     * file name -> user lib
     */
    protected Map<String, UserLib> userLibs;

    public UserLibPreferences() {
        userLibs = new HashMap<String, UserLib>();
    }

    public boolean isModified() {
        return modified;
    }

    public Map<String, UserLib> getUserLibs() {
        return userLibs;
    }

    public UserLib[] toArray() {
        return userLibs.values().toArray(new UserLib[userLibs.size()]);
    }

    public void addUserLib(UserLib lib) {
        int i = lib.getPath().lastIndexOf('/');
        String name = i == -1 ? lib.getPath() : lib.getPath().substring(i + 1);
        userLibs.put(name, lib);
        modified = true;
    }

    public void putUserLib(String name, UserLib lib) {
        userLibs.put(name, lib);
        modified = true;
    }

    public void removeUserLib(UserLib lib) {
        userLibs.remove(lib.getName());
        modified = true;
    }

    public boolean isEmpty() {
        return userLibs.isEmpty();
    }

    public int size() {
        return userLibs.size();
    }

    public UserLib getUserLib(String name) {
        return userLibs.get(name);
    }

    public static UserLibPreferences load() throws BackingStoreException {
        UserLibPreferences prefs = new UserLibPreferences();
        IEclipsePreferences root = getPreferencesNode();
        for (String name : root.childrenNames()) {
            Preferences node = root.node(name);
            UserLib lib = new UserLib(node.get("path", name));
            lib.setGroupId(node.get("groupId", null));
            lib.setArtifactId(node.get("artifactId", null));
            lib.setVersion(node.get("version", null));
            lib.setClassifier(node.get("classifier", null));
            prefs.userLibs.put(name, lib);
        }
        return prefs;
    }

    public void save() throws BackingStoreException {
        IEclipsePreferences root = getPreferencesNode();
        for (String name : root.childrenNames()) {
            root.node(name).removeNode();
        }
        for (Map.Entry<String, UserLib> entry : userLibs.entrySet()) {
            UserLib lib = entry.getValue();
            Preferences node = root.node(entry.getKey());
            node.put("path", lib.getPath());
            String v = lib.getGroupId();
            if (v != null) {
                node.put("groupId", v);
            }
            v = lib.getArtifactId();
            if (v != null) {
                node.put("artifactId", v);
            }
            v = lib.getVersion();
            if (v != null) {
                node.put("version", v);
            }
            v = lib.getClassifier();
            if (v != null) {
                node.put("classifier", v);
            }
        }
        root.flush();
        root.sync();
    }
}
