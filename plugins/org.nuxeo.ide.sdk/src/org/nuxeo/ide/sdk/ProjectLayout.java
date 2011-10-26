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
package org.nuxeo.ide.sdk;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ProjectLayout {

    public static final String MAVEN_MF_PATH = "/src/main/resources/META-INF/MANIFEST.MF";

    public static final String PDE_MF_PATH = "/META-INF/MANIFEST.MF";

    public static IFile getManifest(IProject project) {
        IFile file = project.getFile(MAVEN_MF_PATH);
        if (!file.exists()) {
            IFile pdeMf = project.getFile(PDE_MF_PATH);
            if (pdeMf.exists()) {
                return pdeMf;
            }
        }
        return file;
    }

    public static String getManifestPath(IProject project) {
        IFile file = project.getFile(MAVEN_MF_PATH);
        if (!file.exists()) {
            IFile pdeMf = project.getFile(PDE_MF_PATH);
            if (pdeMf.exists()) {
                return PDE_MF_PATH;
            }
        }
        return MAVEN_MF_PATH;
    }

    public static File getManifest(File project) {
        File file = new File(project, MAVEN_MF_PATH);
        if (!file.isFile()) {
            File pdeMf = new File(project, PDE_MF_PATH);
            if (pdeMf.isFile()) {
                return pdeMf;
            }
        }
        return file;
    }

    public static String getManifestPath(File project) {
        File file = new File(project, MAVEN_MF_PATH);
        if (!file.isFile()) {
            File pdeMf = new File(project, PDE_MF_PATH);
            if (pdeMf.isFile()) {
                return PDE_MF_PATH;
            }
        }
        return MAVEN_MF_PATH;
    }

}
