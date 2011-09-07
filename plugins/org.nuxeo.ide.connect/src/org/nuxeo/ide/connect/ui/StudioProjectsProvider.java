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
package org.nuxeo.ide.connect.ui;

import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.nuxeo.ide.common.BundleImageProvider;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.connect.ConnectPlugin;
import org.nuxeo.ide.connect.StudioProjectBinding;
import org.nuxeo.ide.connect.studio.StudioProject;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StudioProjectsProvider extends BaseLabelProvider implements
        ILabelProvider, IStructuredContentProvider {

    protected BundleImageProvider provider;

    public StudioProjectsProvider() {
        provider = new BundleImageProvider(
                ConnectPlugin.getDefault().getBundle());
    }

    @Override
    public void dispose() {
        super.dispose();
        provider.dispose();
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

    }

    @Override
    public Image getImage(Object element) {
        return provider.getImage("icons/studio_project.gif");
    }

    @Override
    public String getText(Object element) {
        return ((StudioProject) element).getName();
    }

    @Override
    public Object[] getElements(Object inputElement) {
        if (inputElement instanceof StudioProjectBinding) {
            try {
                return ((StudioProjectBinding) inputElement).getProjects();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (inputElement.getClass().isArray()) {
            return (Object[]) inputElement;
        }
        return UI.EMPTY_OBJECTS;
    }
}
