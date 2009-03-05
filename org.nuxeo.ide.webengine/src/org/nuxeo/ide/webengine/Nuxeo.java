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
package org.nuxeo.ide.webengine;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class Nuxeo extends AbstractUIPlugin {

    public final static String PLUGIN_ID = "org.nuxeo.ide.webengine";

    protected static BundleContext ctx;

    // The shared instance
    private static Nuxeo plugin;

    public void start(BundleContext context) throws Exception {
        super.start(context);
        ctx = context;
        plugin = this;
    }

    public void stop(BundleContext context) throws Exception {
        plugin = null;
        ctx = null;
        super.stop(context);
    }

    public static Nuxeo getDefault() {
        return plugin;
    }

    public static Image getImage(String path) {
        return getImageDescriptor(path).createImage();
    }

    public static ImageDescriptor getImageDescriptor(String path) {
        URL url = ctx.getBundle().getEntry(path);
        if (url != null) {
            return ImageDescriptor.createFromURL(url);
        }
        return ImageDescriptor.getMissingImageDescriptor();
    }

    public static BundleContext getContext() {
        return ctx;
    }

    public static void log(Throwable e) {
        if (e instanceof InvocationTargetException)
            e = ((InvocationTargetException) e).getTargetException();
        IStatus status = null;
        if (e instanceof CoreException) {
            status = ((CoreException) e).getStatus();
        } else if (e.getMessage() != null) {
            status = new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK,
                    e.getMessage(), e);
        }
        log(status);
    }

    public static void log(IStatus status) {
        if (status != null)
            ResourcesPlugin.getPlugin().getLog().log(status);
    }

    public static boolean isWebEngineProject(IProject project) {
        try {
            return project.hasNature(WebEngineNature.ID);// &&
            // !WorkspaceModelManager.isBinaryProject(project);
        } catch (Exception e) {
            Nuxeo.log(e);
            return false;
        }
    }

}
