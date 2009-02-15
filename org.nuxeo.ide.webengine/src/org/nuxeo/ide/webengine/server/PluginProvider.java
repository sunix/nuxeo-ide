/*
 * (C) Copyright 2006-2008 Nuxeo SAS (http://nuxeo.com/) and contributors.
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
package org.nuxeo.ide.webengine.server;

import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.nuxeo.ide.webengine.Nuxeo;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public class PluginProvider implements IStructuredContentProvider, ILabelProvider  {

    //protected static ImageDescriptor img = ImageDescriptor.createFromURL(Nuxeo.getContext().getBundle().getEntry("/icons/prj.gif"));

    public void dispose() {
        // TODO Auto-generated method stub

    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        // TODO Auto-generated method stub
        //UIPlugin.getDefault().getImageRegistry().get(key)
    }

    public Object[] getElements(Object inputElement) {
        ArrayList<IProject> prjs = new ArrayList<IProject>();
        IWorkspace ws = ResourcesPlugin.getWorkspace();
        for (IProject prj : ws.getRoot().getProjects()) {
            if (prj.isOpen() && Nuxeo.isWebEngineProject(prj)) {
                prjs.add(prj);
            }
        }
        return prjs.toArray(new IProject[prjs.size()]);
    }


    public String getText(Object element) {
        return ((IResource)element).getName();
    }

    public Image getImage(Object element) {
        //return img.createImage();
        return null;
    }

    public void addListener(ILabelProviderListener listener) {
        // TODO Auto-generated method stub

    }

    public boolean isLabelProperty(Object element, String property) {
        // TODO Auto-generated method stub
        return false;
    }

    public void removeListener(ILabelProviderListener listener) {
        // TODO Auto-generated method stub

    }
}
