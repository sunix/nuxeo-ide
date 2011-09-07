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
package org.nuxeo.ide.connect.studio.content;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.nuxeo.ide.connect.ConnectPlugin;
import org.nuxeo.ide.connect.studio.StudioProject;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StudioEditorInput implements IEditorInput {

    protected StudioProject project;

    public StudioEditorInput(StudioProject project) {
        this.project = project;
    }

    @Override
    public Object getAdapter(Class adapter) {
        if (adapter == StudioProject.class) {
            return project;
        }
        return null;
    }

    public StudioProject getProject() {
        return project;
    }

    @Override
    public boolean exists() {
        return true;
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return ConnectPlugin.getDefault().getImageRegistry().getDescriptor(
                "icons/studio_project.gif");
    }

    @Override
    public String getName() {
        return project.getName();
    }

    @Override
    public IPersistableElement getPersistable() {
        return null;
    }

    @Override
    public String getToolTipText() {
        return project.getId() + " - " + project.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StudioEditorInput) {
            return ((StudioEditorInput) obj).getProject().getId().equals(
                    project.getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return project.getId().hashCode();
    }
}
