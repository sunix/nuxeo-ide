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
public class BindingManager implements IResourceChangeListener, IStudioListener {

    protected final Map<String, StudioProjectBinding> bindings;

    protected final IBindingListener listener;

    BindingManager(IBindingListener listener) {
        this.bindings = new HashMap<String, StudioProjectBinding>();
        this.listener = listener;
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
            listener.handleNewBinding(binding);
            return binding;
        } catch (Exception e) {
            e.printStackTrace(); // TODO
        }
        return null;
    }

    public synchronized void clearBinding(IProject project) {
        bindings.remove(project.getName());
    }

    public void removeBinding(IProject project) {
        clearBinding(project);
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
                    String[] projectIds = StringUtils.split(v, '.');
                    binding = new StudioProjectBinding(projectIds);
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
        IResource resource = event.getResource();
        int type = event.getType();
        switch (type) {
        case IResourceChangeEvent.PRE_CLOSE:
            if (resource instanceof IProject) {
                clearBinding((IProject) resource);
            }
            break;
        case IResourceChangeEvent.PRE_DELETE:
            if (resource instanceof IProject) {
                removeBinding((IProject) resource);
                return;
            }
            break;
        }
    }

    @Override
    public void handleProjectsUpdate(StudioProvider provider) {
        for (StudioProjectBinding binding : getLiveBindings()) {
            binding.flush();
        }
    }

    public void dispose() {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
        bindings.clear();
    }

}
