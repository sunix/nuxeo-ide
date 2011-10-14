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
package org.nuxeo.ide.common;

import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ViewItemProvider extends BaseLabelProvider implements
        ILabelProvider, ITreeContentProvider {

    protected boolean disposed = false;

    @Override
    public final void dispose() {
        if (this.disposed) {
            return;
        }
        try {
            super.dispose();
            doDispose();
        } finally {
            this.disposed = true;
        }
    }

    protected void doDispose() {
        // do nothing
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

    }

    @Override
    public Object[] getElements(Object inputElement) {
        if (inputElement != null && inputElement.getClass().isArray()) {
            return (Object[]) inputElement;
        }
        return UI.EMPTY_OBJECTS;
    }

    @Override
    public Object[] getChildren(Object parentElement) {
        if (parentElement instanceof IViewItem) {
            return ((IViewItem) parentElement).getChildren();
        }
        return UI.EMPTY_OBJECTS;
    }

    @Override
    public Object getParent(Object element) {
        if (element instanceof IViewItem) {
            return ((IViewItem) element).getChildren();
        }
        return null;
    }

    @Override
    public boolean hasChildren(Object element) {
        if (element instanceof IViewItem) {
            return ((IViewItem) element).hasChildren();
        }
        return false;
    }

    @Override
    public Image getImage(Object element) {
        if (element instanceof IViewItem) {
            return ((IViewItem) element).getImage();
        }
        return null;
    }

    @Override
    public String getText(Object element) {
        if (element instanceof IViewItem) {
            return ((IViewItem) element).getLabel();
        }
        return element == null ? "[NULL]" : element.toString();
    }

}
