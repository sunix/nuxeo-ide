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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.nuxeo.ide.common.StringUtils;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class BindingManager implements IResourceChangeListener, StudioListener {

    protected Map<String, StudioProjectBinding> bindings;

    BindingManager() {
        bindings = new HashMap<String, StudioProjectBinding>();
        ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
    }

    public StudioProjectBinding setBinding(IProject project,
            String... projectIds) {
        if (projectIds == null || projectIds.length == 0) {
            removeBinding(project);
            return null;
        } else {
            return createBinding(project, projectIds);
        }
    }

    private synchronized StudioProjectBinding createBinding(IProject project,
            String... projectIds) {
        try {
            project.setPersistentProperty(
                    StudioProjectBinding.STUDIO_BINDING_P,
                    StringUtils.join(projectIds, ','));
            StudioProjectBinding binding = new StudioProjectBinding(projectIds);
            bindings.put(project.getName(), binding);
            return binding;
        } catch (Exception e) {
            e.printStackTrace(); // TODO
        }
        return null;
    }

    public synchronized void removeBinding(IProject project) {
        bindings.remove(project.getName());
        try {
            project.setPersistentProperty(
                    StudioProjectBinding.STUDIO_BINDING_P, null);
        } catch (Exception e) {
            e.printStackTrace(); // TODO
        }
    }

    public synchronized StudioProjectBinding getBinding(IProject project) {
        StudioProjectBinding binding = bindings.get(project.getName());
        if (binding == null) {
            try {
                String v = project.getPersistentProperty(StudioProjectBinding.STUDIO_BINDING_P);
                if (v != null) {
                    binding = new StudioProjectBinding(
                            StringUtils.split(v, ','));
                    bindings.put(project.getName(), binding);
                }
            } catch (Exception e) {
                e.printStackTrace(); // TODO
            }
        }
        return binding;
    }

    public synchronized StudioProjectBinding[] getLiveBindings() {
        return bindings.values().toArray(
                new StudioProjectBinding[bindings.size()]);
    }

    @Override
    public void resourceChanged(IResourceChangeEvent event) {
        int type = event.getType();
        if (type == IResourceChangeEvent.PRE_CLOSE
                || type == IResourceChangeEvent.PRE_DELETE) {
            IResource resource = event.getResource();

            if (resource instanceof IProject) {
                removeBinding((IProject) resource);
            }
        }
    }

    @Override
    public void handleProjectsUpdate(StudioProvider provider) {
        StudioProjectBinding[] bindings = getLiveBindings();
        for (StudioProjectBinding binding : bindings) {
            binding.flush();
        }
    }

    public void dispose() {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
        bindings = null;
    }

}
