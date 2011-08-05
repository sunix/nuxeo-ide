/*
 * (C) Copyright 2011 Nuxeo SA (http://nuxeo.com/) and contributors.
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
 *     eugen
 */
package org.nuxeo.ide.studio.ui.internal.editors;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.nuxeo.ide.studio.ui.internal.tree.Node;

/**
 * @author eugen
 *
 */
public class EditorInput implements IEditorInput{

    Node node;

    public EditorInput(Node node) {
        this.node = node;
    }

    @Override
    public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
        if ( Node.class.isAssignableFrom(adapter)) {
            return node;
        }
        return null;
    }


    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return null;
    }

    @Override
    public String getName() {
        return node.getLabel();
    }

    @Override
    public IPersistableElement getPersistable() {
        return null;
    }

    @Override
    public String getToolTipText() {
        return getName();
    }

    public boolean equals(Object obj) {
        if ( obj instanceof EditorInput) {
            EditorInput input = (EditorInput) obj;
            if ( node != null) {
                return node.equals(input.getAdapter(Node.class));
            }
        }
        return super.equals(obj);
    }


}
