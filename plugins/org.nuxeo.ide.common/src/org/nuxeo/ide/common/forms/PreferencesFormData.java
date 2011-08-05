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
package org.nuxeo.ide.common.forms;

import java.util.Map;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.service.prefs.BackingStoreException;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class PreferencesFormData implements FormData {

    IEclipsePreferences prefs;

    /**
     * Create a preferences form data - using the instance scope (at workspace
     * level)
     * 
     * @param nodeName
     */
    public PreferencesFormData(String nodeName) {
        this(nodeName, true);
    }

    /**
     * if workpsaceScope is true then a per workspace scope will be used
     * otherwise a global (to all workspaces) scope will be used.
     * 
     * @param nodeName
     * @param workspaceScope
     */
    public PreferencesFormData(String nodeName, boolean workspaceScope) {
        this(workspaceScope ? new InstanceScope().getNode(nodeName)
                : new ConfigurationScope().getNode(nodeName));
    }

    public PreferencesFormData(IEclipsePreferences prefs) {
        this.prefs = prefs;
    }

    @Override
    public void load(Form form) throws BackingStoreException {
        for (String key : prefs.keys()) {
            String v = prefs.get(key, null);
            if (v != null) {
                form.setWidgetValue(key, v);
            }
        }
    }

    @Override
    public void store(Form form) throws BackingStoreException {
        Map<String, String> values = form.getValues();
        for (Map.Entry<String, String> entry : values.entrySet()) {
            String v = entry.getValue();
            if (v != null && v.length() > 0) {
                prefs.put(entry.getKey(), entry.getValue());
            }
        }
        prefs.flush();
        prefs.sync();
    }

    public IEclipsePreferences prefs() {
        return prefs;
    }

    public String get(String key) {
        return prefs.get(key, null);
    }

    public void put(String key, String value) {
        prefs.put(key, value);
    }

    public void save() throws BackingStoreException {
        prefs.flush();
        prefs.sync();
    }
}
