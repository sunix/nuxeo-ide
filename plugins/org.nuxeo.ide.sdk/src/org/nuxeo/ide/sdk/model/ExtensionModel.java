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
package org.nuxeo.ide.sdk.model;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.nuxeo.ide.common.IOUtils;
import org.nuxeo.ide.sdk.SDKPlugin;

/**
 * Manage writing / deleting of feature extension files. Each feature may have
 * an associated extension file which is identified by the main feature class
 * full name + ".xml" extension.
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ExtensionModel {

    public final static String RUNTIME_BASE_PATH = "OSGI-INF/extensions";

    public final static String RESOURCES_PATH = "src/main/resources/";

    public static final String BASE_PATH = RESOURCES_PATH + RUNTIME_BASE_PATH;

    public final static String OSGI_INF_PATH = RESOURCES_PATH + "OSGI-INF";

    public final static String GADGET_PATH = RESOURCES_PATH + "gadget";

    protected String id;

    public ExtensionModel(String id) {
        this.id = id;
    }

    public String getPath() {
        return getPath(id);
    }

    public static String getPath(String id) {
        return BASE_PATH + "/" + id + ".xml";
    }

    public String getRuntimePath() {
        return getRuntimePath(id);
    }

    public static String getRuntimePath(String id) {
        return RUNTIME_BASE_PATH + "/" + id + ".xml";
    }

    public void rename(IProject project, String newId, IProgressMonitor monitor)
            throws CoreException {
        if (id.equals(newId)) {
            return;
        }
        String content = getContent(project);
        if (content != null) {
            content = content.replace(id, newId);
            IFile file = setContent(project, content, monitor);
            if (file.exists()) {
                IPath path = file.getFullPath();
                path = path.removeLastSegments(1).append(newId + ".xml");
                file.move(path, true, monitor);
                ManifestWriter writer = ManifestWriter.getWriter(project);
                try {
                    writer.removeEntry("Nuxeo-Component", getRuntimePath());
                    writer.appendEntry("Nuxeo-Component", getRuntimePath(newId));
                    writer.write(monitor);
                } catch (CoreException e) {
                    throw e;
                } catch (Exception e) {
                    throw new CoreException(new Status(IStatus.ERROR,
                            SDKPlugin.PLUGIN_ID, "failed to upfdate manifets",
                            e));
                }
            }
        }
    }

    public IFile setContent(IProject project, String content,
            IProgressMonitor monitor) throws CoreException {
        IFile file = project.getFile(getPath());
        ByteArrayInputStream in = null;
        try {
            in = new ByteArrayInputStream(content.getBytes("UTF-8"));
        } catch (IOException e) {
            throw new CoreException(new Status(IStatus.ERROR,
                    SDKPlugin.PLUGIN_ID, "Failed to set file content: " + file,
                    e));
        }
        if (file.exists()) {
            file.setContents(in, true, true, monitor);
        } else {
            createFolder((IFolder) file.getParent(), monitor);
            file.create(in, true, monitor);
        }
        ManifestWriter writer = ManifestWriter.getWriter(project);
        try {
            writer.appendEntry("Nuxeo-Component", getRuntimePath());
            writer.write(monitor);
        } catch (CoreException e) {
            throw e;
        } catch (Exception e) {
            throw new CoreException(new Status(IStatus.ERROR,
                    SDKPlugin.PLUGIN_ID, "failed to upfdate manifets", e));
        }
        return file;
    }

    public void setContent(File projectRoot, String content) throws Exception {
        File file = new File(projectRoot, getPath());
        file.getParentFile().mkdirs();
        IOUtils.writeFile(file, content);
        ManifestWriter writer = ManifestWriter.getWriter(projectRoot);
        writer.appendEntry("Nuxeo-Component", getRuntimePath());
        writer.write(null);
    }

    public String getContent(IProject project) throws CoreException {
        IFile file = project.getFile(getPath());
        if (file.exists()) {
            InputStream in = file.getContents(true);
            try {
                return IOUtils.read(in);
            } catch (IOException e) {
                throw new CoreException(new Status(IStatus.ERROR,
                        SDKPlugin.PLUGIN_ID, "Failed to read extension file: "
                                + file, e));
            }
        }
        return null;
    }

    public String getContent(File projectRoot) throws IOException {
        File file = new File(projectRoot, getPath());
        if (file.isFile()) {
            return IOUtils.readFile(file);
        }
        return null;
    }

    public void delete(IProject project, IProgressMonitor monitor)
            throws CoreException {
        IFile file = project.getFile(getPath());
        if (file.exists()) {
            file.delete(true, monitor);
        }
        ManifestWriter writer = ManifestWriter.getWriter(project);
        try {
            writer.removeEntry("Nuxeo-Component", getRuntimePath());
            writer.write(monitor);
        } catch (CoreException e) {
            throw e;
        } catch (Exception e) {
            throw new CoreException(new Status(IStatus.ERROR,
                    SDKPlugin.PLUGIN_ID, "failed to upfdate manifets", e));
        }
    }

    public void delete(File projectRoot, IProgressMonitor monitor)
            throws Exception {
        new File(projectRoot, getPath()).delete();
        ManifestWriter writer = ManifestWriter.getWriter(projectRoot);
        writer.removeEntry("Nuxeo-Component", getRuntimePath());
        writer.write(null);
    }

    public static void createFolder(IFolder folder, IProgressMonitor monitor)
            throws CoreException {
        if (!folder.exists()) {
            IContainer parent = folder.getParent();
            if (parent instanceof IFolder) {
                createFolder((IFolder) parent, monitor);
            }
            folder.create(true, true, monitor);
        }
    }

}
