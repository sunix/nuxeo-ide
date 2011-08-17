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
package org.nuxeo.ide.studio.internal.jdt;

import java.io.File;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.nuxeo.ide.studio.StudioConstants;
import org.nuxeo.ide.studio.StudioContentProvider;
import org.nuxeo.ide.studio.StudioPlugin;
import org.nuxeo.ide.studio.StudioProject;

/**
 * @author <a href="mailto:slacoin@nuxeo.com">Stephane Lacoin</a>
 *
 */
public class ClasspathContainer implements IClasspathContainer {

    protected final IClasspathEntry[] entries;

    protected final IJavaProject ctx;

    protected ClasspathContainer(IJavaProject ctx) {
        this.ctx = ctx;
        this.entries = buildEntries(ctx);
    }

    protected IClasspathEntry[] buildEntries(IJavaProject ctx) {
        IPath path = studioPath(ctx);
        return new IClasspathEntry[] { JavaCore.newLibraryEntry(path, null, null) };
    }


    public IClasspathEntry[] getClasspathEntries() {
        return entries;
    }

    protected static String studioProjectId(IJavaProject ctx) {
        return StudioPlugin.getPreferences().getStudioProjectName(ctx);
    }
    
    protected IPath studioPath(IJavaProject ctx) {
        String prjId = studioProjectId(ctx);
        StudioContentProvider provider = StudioPlugin.getDefault().getProvider();
        File file = provider.getJar(prjId);
        return new Path(file.getAbsolutePath());
    }

    public String getDescription() {
        return "Nuxeo Studio [ " + studioProjectId(ctx) + "]";
    }

    public int getKind() {
        return K_APPLICATION;
    }

    public IPath getPath() {
        return new Path(StudioConstants.CLASSPATH_CONTAINER_ID);
    }

}