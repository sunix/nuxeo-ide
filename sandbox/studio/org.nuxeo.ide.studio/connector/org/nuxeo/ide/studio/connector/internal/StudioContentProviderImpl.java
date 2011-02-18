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
package org.nuxeo.ide.studio.connector.internal;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.nuxeo.ide.studio.StudioActivatorHandler;
import org.nuxeo.ide.studio.StudioContentProvider;
import org.nuxeo.ide.studio.StudioPlugin;
import org.nuxeo.ide.studio.StudioProject;
import org.nuxeo.ide.studio.data.model.Group;
import org.nuxeo.ide.studio.internal.jdt.ClasspathContainerUpdater;
import org.nuxeo.ide.studio.internal.preferences.Preferences;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public class StudioContentProviderImpl implements StudioContentProvider, StudioActivatorHandler {

    protected StudioConnector connector;

    protected Map<String, StudioProject> projects;

    public void reset() {
        Preferences prefs = StudioPlugin.getPreferences();
        connector = new StudioConnector(
                prefs.getConnectLocation(),
                prefs.getUsername(), prefs.getPassword());
    }

    public void handleReset() {
        reset();
    }

    public void handleStart() {
        reset();
    }

    public void handleStop() {
        connector = null;
    }

    @Override
    public StudioProject[] getProjects() {
        if (projects == null) {
            projects = fetchProjects();
        }
        return projects.values().toArray(new StudioProject[projects.size()]);
    }

    public Map<String, StudioProject> fetchProjects() {
        projects = new HashMap<String, StudioProject>();
        String input;
        try {
            input = connector.getProjects();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        JSONArray array = JSONArray.fromObject(input);
        HashMap<String, StudioProject> projects = new HashMap<String, StudioProject>(array.size());
        for (Object o:array) {
            JSONObject encoded = (JSONObject)o;
            ProjectBean b = new ProjectBean(encoded.getString("id"));
            b.setName(encoded.getString("name"));
            b.setTarget(encoded.getString("target"));
            JSONArray types = (JSONArray)encoded.get("types");
            Group[] groups = new Group[types.size()];
            for (int i=0; i<groups.length; i++) {
                JSONObject to = types.getJSONObject(i);
                String id = to.getString("id");
                String name = to.getString("name");
                String label = to.getString("label");
                Group g = new Group(id, label);
                g.setName(name);
                groups[i] = g;
            }
            b.setFeatureTypes(groups);
            projects.put(b.id, b);
        }

        return projects;
    }

    @Override
    public String getEncodedFeatures(String projectId) {
        try {
            return connector.getFeatures(projectId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public File getJar(String name) {
        try {
            return connector.getJar(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void updateJar(String name) {
        new ClasspathContainerUpdater(name, null).refreshWorkspace();
    }

    @Override
    public StudioProject getProject(String id) {
        if (projects == null) {
            projects = fetchProjects();
        }
        return projects.get(id);
    }

}
