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

import org.eclipse.core.resources.IProject;
import org.eclipse.swt.graphics.Image;
import org.nuxeo.ide.connect.ConnectPlugin;
import org.nuxeo.ide.connect.studio.StudioProject;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StudioProjectElement {

    protected StudioBindingElement parent;

    protected StudioProject project;

    public StudioProjectElement(StudioBindingElement parent,
            StudioProject project) {
        this.parent = parent;
        this.project = project;
    }

    public StudioBindingElement getParent() {
        return parent;
    }

    public StudioProject getProject() {
        return project;
    }

    public IProject getTargetProject() {
        return parent.getProject();
    }

    public String getName() {
        return project.getName();
    }

    public Image getImage() {
        return ConnectPlugin.getDefault().getImageRegistry().get(
                "icons/studio_project.gif");
    }
}
