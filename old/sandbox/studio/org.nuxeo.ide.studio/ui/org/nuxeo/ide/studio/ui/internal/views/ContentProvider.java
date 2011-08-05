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
package org.nuxeo.ide.studio.ui.internal.views;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.nuxeo.ide.studio.ui.internal.tree.Tree;

/**
 * @author eugen
 *
 */
public class ContentProvider implements IStructuredContentProvider, ITreeContentProvider {

    @Override
    public void dispose() {

    }
    
    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        
    }

    @Override
    public Object[] getChildren(Object parentElement) {
        if ( parentElement instanceof Tree) {
            Tree tree = (Tree) parentElement;
            return tree.getChildren().toArray();
        }
        return null;
    }

    @Override
    public Object getParent(Object element) {
        return null;
    }

    @Override
    public boolean hasChildren(Object element) {
        if ( element instanceof Tree) {
            Tree tree = (Tree) element;
            return tree.getChildren().size() > 0;
        }
        return false;
    }

    @Override
    public Object[] getElements(Object inputElement) {
        if ( inputElement instanceof Tree) {
            Tree tree = (Tree) inputElement;
            return tree.getChildren().toArray();
        }
        return null;
    }

}
