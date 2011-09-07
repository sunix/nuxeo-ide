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

import java.util.ArrayList;
import java.util.List;

import org.nuxeo.ide.connect.studio.StudioProject;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class ParentNode<T> extends Node<T> {

    protected List<Node<?>> children = new ArrayList<Node<?>>();

    public ParentNode(StudioProject project) {
        super(project);
    }

    public void add(Node<?> node) {
        children.add(node);
        node.parent = this;
    }

    @Override
    public boolean hasChildren() {
        return !children.isEmpty();
    }

    @Override
    public Node<?>[] getChildren() {
        return children.toArray(new Node<?>[children.size()]);
    }

    @Override
    public boolean isTerminal() {
        return false;
    }

}
