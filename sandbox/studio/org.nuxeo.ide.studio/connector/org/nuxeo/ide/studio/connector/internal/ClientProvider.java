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
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.nuxeo.ide.studio.StudioActivatorHandler;
import org.nuxeo.ide.studio.StudioContentProvider;
import org.nuxeo.ide.studio.StudioFeature;
import org.nuxeo.ide.studio.StudioPlugin;
import org.nuxeo.ide.studio.StudioProject;
import org.nuxeo.ide.studio.internal.jdt.ClasspathContainerUpdater;
import org.nuxeo.ide.studio.preferences.Preferences;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public class ClientProvider implements StudioContentProvider, StudioActivatorHandler {

    protected Connector connector;

    protected Map<String, StudioProject> projects;

    
    public void connect(Preferences prefs) {
        connector = new Connector(prefs.getConnectLocation());
        connector.setPreemptiveBasicAuth(prefs.getUsername(), prefs.getPassword());
    }
    
    public void disconnect() {
        connector.shutdown();
        connector = null;
    }

    public void handleReset() {
        disconnect();
        connect(StudioPlugin.getPreferences());
    }

    public void handleStart() {
        connect(StudioPlugin.getPreferences());
    }

    public void handleStop() {
        disconnect();
    }

    @Override
    public ProjectBean[] getProjects() {
        InputStream input = connector.getProjects();
        return new ProjectsDecoder(input).decode();
    }

    @Override
    public StudioProject getProject(String id) {
        return getProjectsMap().get(id);
    }

    public Map<String, StudioProject> getProjectsMap() {
        ProjectBean[] beans = getProjects();
        Map<String,StudioProject> map = new HashMap<String,StudioProject>();
        for (ProjectBean b:beans) {
            map.put(b.id, b);
        }
        return map;
    }

    @Override
    public StudioFeature[] getFeatures(String projectId) {
        InputStream input = connector.getFeatures(projectId);
        return new FeaturesDecoder(input).decode();
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
