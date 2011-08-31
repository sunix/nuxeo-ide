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

import org.nuxeo.ide.connect.studio.StudioProject.TypeDescriptor;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class TypeNode extends ParentNode<TypeDescriptor> {

    protected TypeDescriptor td;

    public TypeNode(TypeDescriptor td) {
        this.td = td;
    }

    @Override
    public String getId() {
        return td.id;
    }

    @Override
    public String getLabel() {
        return td.label;
    }

    @Override
    public String getIcon() {
        return "icons/studio/grp/" + td.id + ".gif";
    }

    @Override
    public boolean isTerminal() {
        return td.global ? true : false;
    }

    @Override
    public TypeDescriptor getData() {
        return td;
    }

}
