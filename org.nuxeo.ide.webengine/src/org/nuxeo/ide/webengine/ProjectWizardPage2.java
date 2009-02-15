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

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.core.ClasspathEntry;
import org.eclipse.jdt.ui.wizards.NewJavaProjectWizardPageOne;
import org.eclipse.jdt.ui.wizards.NewJavaProjectWizardPageTwo;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public class ProjectWizardPage2 extends NewJavaProjectWizardPageTwo {

    public ProjectWizardPage2(NewJavaProjectWizardPageOne one) {
        super (one);
    }

    @Override
    public void configureJavaProject(IProgressMonitor monitor)
            throws CoreException, InterruptedException {
        super.configureJavaProject(monitor);
        WebEngineNature.install(getJavaProject().getProject());
    }

    @Override
    public void init(IJavaProject jproject, IPath defaultOutputLocation,
            IClasspathEntry[] defaultEntries,
            boolean defaultsOverrideExistingClasspath) {
        IPath path = jproject.getResource().getFullPath();
        ArrayList<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
        IClasspathEntry cpe = JavaCore.newSourceEntry(path.append("/src/main/java"));
        entries.add(cpe);
        cpe = JavaCore.newSourceEntry(path.append("/src/main/resources"));
        entries.add(cpe);
        cpe = JavaCore.newSourceEntry(path.append("/src/test/java"));
        entries.add(cpe);
        cpe = JavaCore.newSourceEntry(path.append("/src/test/resources"));
        entries.add(cpe);
        for (IClasspathEntry entry : defaultEntries) {
            if (entry.getEntryKind() != IClasspathEntry.CPE_SOURCE) {
                entries.add(entry);
            }
        }
        super.init(jproject, defaultOutputLocation, entries.toArray(new IClasspathEntry[entries.size()]),
                defaultsOverrideExistingClasspath);
    }

}
