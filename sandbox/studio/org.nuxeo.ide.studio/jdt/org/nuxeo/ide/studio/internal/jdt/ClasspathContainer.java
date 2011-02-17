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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.nuxeo.ide.studio.NxStudioConstants;

/**
 * @author <a href="mailto:slacoin@nuxeo.com">Stephane Lacoin</a>
 *
 */
public class ClasspathContainer implements IClasspathContainer {
    
    protected final IJavaProject project;
    
    protected final List<IClasspathEntry> entries =
        new ArrayList<IClasspathEntry>();
    
    protected ClasspathContainer(IJavaProject project) {
        this.project = project;
    }
    
    public IClasspathEntry[] getClasspathEntries() {
        return entries.toArray(new IClasspathEntry[entries.size()]);
    }

    public String getDescription() {
        return "Nuxeo Studio Classpath Container for " + project.getProject().getName();
    }

    public int getKind() {
        return K_APPLICATION;
    }

    public IPath getPath() {
        return new Path(NxStudioConstants.CLASSPATH_CONTAINER_ID);
    }

}
