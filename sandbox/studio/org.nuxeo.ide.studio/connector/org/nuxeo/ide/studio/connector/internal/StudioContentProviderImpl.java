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

import org.eclipse.core.runtime.IPath;
import org.nuxeo.ide.studio.connector.StudioIDEContentProvider;
import org.nuxeo.ide.studio.connector.StudioIDEProject;
import org.nuxeo.ide.studio.data.model.Feature;
import org.nuxeo.ide.studio.internal.preferences.PreferencesStore;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public class StudioContentProviderImpl implements StudioIDEContentProvider {

    protected StudioConnector connector;


    public StudioContentProviderImpl() {
        reset();
    }

    public void reset() {
        connector = new StudioConnector(
                PreferencesStore.INSTANCE.getConnectLocation(),
                PreferencesStore.INSTANCE.getUsername(), PreferencesStore.INSTANCE.getPassword());
    }

    @Override
    public StudioIDEProject getDefaultProject() {
        return null;
    }

    @Override
    public StudioIDEProject getProject(String name) {
        return null;
    }

    @Override
    public StudioIDEProject[] getProjects() {
        try {
            return null;//connector.getProjects();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Feature[] getFeatures(String projectId) {
        try {
            return null;//connector.getFeatures(projectId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public IPath find(String path) {
        return null;
    }

}
