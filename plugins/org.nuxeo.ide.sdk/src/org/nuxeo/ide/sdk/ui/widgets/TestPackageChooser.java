/*
 * (C) Copyright 2006-2013 Nuxeo SAS (http://nuxeo.com/) and contributors.
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
 *     ldoguin
 */
package org.nuxeo.ide.sdk.ui.widgets;

import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.swt.widgets.Composite;

/**
 * @author <a href="mailto:ldoguin@nuxeo.com">Laurent Doguin</a>
 * 
 */
public class TestPackageChooser extends PackageChooser {

	public TestPackageChooser(Composite parent) {
		super(parent);
	}

	@Override
    public IPackageFragment toValue(String text) {
        if (text == null || text.length() == 0) {
            return null;
        }
        if (project != null) {
            return project.getPackageFragmentRoot("/src/test/java").getPackageFragment(
                    text);
        }
        return null;
    }

    public IPackageFragmentRoot getSourceRoot(IJavaProject project) {
        IResource resource = project.getProject().getFolder("src/test/java");
        return project.getPackageFragmentRoot(resource);
    }

}
