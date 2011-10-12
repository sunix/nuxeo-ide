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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.nuxeo.ide.common.IOUtils;
import org.nuxeo.ide.sdk.SDKPlugin;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class ManifestWriter {

    public static final String PATH = "/src/main/resources/META-INF/MANIFEST.MF";

    protected Manifest mf;

    public static ManifestWriter getWriter(IProject project)
            throws CoreException {
        try {
            ProjectWriter writer = new ProjectWriter();
            writer.mf = writer.load(project);
            return writer;
        } catch (CoreException e) {
            throw e;
        } catch (Exception e) {
            throw new CoreException(new Status(IStatus.ERROR,
                    SDKPlugin.PLUGIN_ID, "Failed to load manifest file", e));
        }
    }

    public static ManifestWriter getWriter(File project) throws Exception {
        FileWriter writer = new FileWriter();
        writer.mf = writer.load(project);
        return writer;
    }

    protected InputStream getContent() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        mf.write(out);
        return new ByteArrayInputStream(out.toByteArray());
    }

    protected abstract Manifest load(Object project) throws Exception;

    public abstract void write(IProgressMonitor monitor) throws Exception;

    public String replaceEntry(String key, String value) throws Exception {
        Attributes attrs = mf.getMainAttributes();
        return attrs.putValue(key, value);
    }

    public String removeEntry(String key) throws Exception {
        Attributes attrs = mf.getMainAttributes();
        return (String) attrs.remove(new Attributes.Name(key));
    }

    public boolean removeEntry(String key, String value) throws Exception {
        Attributes attrs = mf.getMainAttributes();
        String v = attrs.getValue(key);
        if (v != null) {
            String[] ar = v.split("\\s*,\\s*");
            StringBuilder buf = new StringBuilder();
            for (String s : ar) {
                if (!s.equals(value)) {
                    buf.append(',').append(s);
                }
            }
            v = buf.length() > 0 ? buf.substring(1).trim() : "";
            if (v.length() > 0) {
                return attrs.putValue(key, v) != null;
            } else {
                return attrs.remove(new Attributes.Name(key)) != null;
            }
        } else {
            return false;
        }
    }

    public boolean appendEntry(String key, String value) throws Exception {
        Attributes attrs = mf.getMainAttributes();
        String v = attrs.getValue(key);
        if (v != null) {
            v = v.trim();
            if (v.length() == 0) {
                attrs.putValue(key, value);
                return true;
            }
            String[] ar = v.split("\\s*,\\s*");
            for (String s : ar) {
                if (s.equals(value)) {
                    return false;
                }
            }
            attrs.putValue(key, v + "," + value);
        } else {
            attrs.putValue(key, value);
        }
        return true;
    }

    public static class ProjectWriter extends ManifestWriter {

        protected IProject project;

        protected IFile file;

        @Override
        public Manifest load(Object project) throws Exception {
            this.project = (IProject) project;
            this.file = this.project.getFile(PATH);
            if (file.exists()) {
                InputStream in = file.getContents(true);
                try {
                    return new Manifest(in);
                } finally {
                    in.close();
                }
            } else {
                return new Manifest();
            }
        }

        @Override
        public void write(IProgressMonitor monitor) throws Exception {
            InputStream in = getContent();
            try {
                if (file.exists()) {
                    file.setContents(getContent(), true, true, monitor);
                } else {
                    file.create(getContent(), true, monitor);
                }
            } finally {
                in.close();
            }
        }

    }

    public static class FileWriter extends ManifestWriter {

        protected File file;

        @Override
        public Manifest load(Object project) throws Exception {
            File dir = (File) project;
            file = new File(dir, PATH);
            if (file.isFile()) {
                InputStream in = new FileInputStream(file);
                try {
                    return new Manifest(in);
                } finally {
                    in.close();
                }
            } else {
                return new Manifest();
            }
        }

        @Override
        public void write(IProgressMonitor monitor) throws Exception {
            InputStream in = getContent();
            try {
                IOUtils.copyToFile(in, file, true);
            } finally {
                in.close();
            }
        }

    }

}
