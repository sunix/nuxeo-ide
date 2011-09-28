/*
 * (C) Copyright 2006-2011 Nuxeo SAS (http://nuxeo.com/) and contributors.
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
 *     slacoin
 */
package org.nuxeo.ide.sdk.features.seam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.nuxeo.ide.common.UI;
import org.nuxeo.ide.sdk.features.CreateFeatureFromTemplate;
import org.nuxeo.ide.sdk.features.FeatureTemplateContext;

public class CreateSeamFeatureFromTemplate extends CreateFeatureFromTemplate {

    public CreateSeamFeatureFromTemplate(FeatureTemplateContext ctx) {
        super(ctx);
    }

    protected void postCreate() {
        super.postCreate();
        IJavaProject java = ctx.getProject();
        extendClasspath(java, "seam");
        extendClasspath(java, "i18n");
    }

    protected void extendClasspath(IJavaProject java, String name) {
        IProject project = java.getProject();
        IFolder sourceFolder = project.getFolder("src/main/"+name);
        IPackageFragmentRoot seamRoot = java.getPackageFragmentRoot(sourceFolder);
        if (!seamRoot.isOpen()) {
            // extend project class path
            try {
                List<IClasspathEntry> ocp = Arrays.asList(java.getRawClasspath());
                List<IClasspathEntry> ncp = new ArrayList<IClasspathEntry>(
                        ocp.size() + 1);
                ncp.addAll(ocp);
                IFolder binFolder = project.getFolder("bin/"+name);
                IClasspathEntry nce = JavaCore.newSourceEntry(
                        sourceFolder.getFullPath(), new IPath[0], new IPath[0],
                        binFolder.getFullPath());
                ncp.add(nce);
                java.setRawClasspath(
                        ncp.toArray(new IClasspathEntry[ncp.size()]), null);
            } catch (JavaModelException e) {
                UI.showError("Cannot extend classpath of " + project.getName(),
                        e);
            }
        }
    }

}
