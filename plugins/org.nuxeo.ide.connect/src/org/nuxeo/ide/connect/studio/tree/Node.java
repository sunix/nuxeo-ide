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
package org.nuxeo.ide.connect.studio.tree;

import org.nuxeo.ide.connect.studio.StudioProject;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class Node<T> {

    protected StudioProject project;

    protected ParentNode<?> parent;

    protected Node(StudioProject project) {
        this.project = project;
    }

    public ParentNode<?> getParent() {
        return parent;
    }

    public StudioProject getProject() {
        return project;
    }

    public abstract String getId();

    public abstract String getLabel();

    public abstract String getIcon();

    public abstract boolean hasChildren();

    public abstract Node<?>[] getChildren();

    public abstract boolean isTerminal();

    public abstract T getData();

}
