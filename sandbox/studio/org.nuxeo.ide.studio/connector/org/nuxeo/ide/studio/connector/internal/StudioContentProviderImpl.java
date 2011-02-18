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
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.nuxeo.ide.studio.StudioActivatorHandler;
import org.nuxeo.ide.studio.StudioContentProvider;
import org.nuxeo.ide.studio.StudioPlugin;
import org.nuxeo.ide.studio.StudioProject;
import org.nuxeo.ide.studio.internal.jdt.ClasspathContainerUpdater;
import org.nuxeo.ide.studio.internal.preferences.Preferences;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public class StudioContentProviderImpl implements StudioContentProvider, StudioActivatorHandler {

    protected StudioConnector connector;

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
        String input;
        try {
            input = connector.getProjects();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        JSONArray array = JSONArray.fromObject(input);
        List<StudioProject> projects = new ArrayList<StudioProject>(array.size());
        for (Object o:array) {
            JSONObject encoded = (JSONObject)o;
            ProjectBean b = new ProjectBean(encoded.getString("id"));
            b.setName(encoded.getString("name"));
            b.setTarget(encoded.getString("target"));
            projects.add(b);
        }
        return projects.toArray(new StudioProject[projects.size()]);
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

}
