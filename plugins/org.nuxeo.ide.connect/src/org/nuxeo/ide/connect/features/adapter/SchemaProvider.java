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
package org.nuxeo.ide.connect.features.adapter;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.connect.ConnectPlugin;
import org.nuxeo.ide.connect.StudioProjectBinding;
import org.nuxeo.ide.connect.studio.DocumentSchema;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class SchemaProvider extends LabelProvider implements
        IStructuredContentProvider {

    @Override
    public void dispose() {
        // id you are implementing this method be sure to not dispose twice.
        // (dispose will be called twice since the class implements both a
        // content provider and a label provider)
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

    @Override
    public Object[] getElements(Object inputElement) {
        if (inputElement == null) {
            return UI.EMPTY_OBJECTS;
        }
        if (inputElement instanceof StudioProjectBinding) {
            return ((StudioProjectBinding) inputElement).getSchemas();
        } else if (inputElement.getClass().isArray()) {
            return (Object[]) inputElement;
        }
        return UI.EMPTY_OBJECTS;
    }

    @Override
    public Image getImage(Object element) {
        return ConnectPlugin.getDefault().getImageRegistry().get(
                "icons/studio_project.gif");
    }

    @Override
    public String getText(Object element) {
        if (element instanceof DocumentSchema) {
            return ((DocumentSchema) element).getId();
        }
        return super.getText(element);
    }

}
