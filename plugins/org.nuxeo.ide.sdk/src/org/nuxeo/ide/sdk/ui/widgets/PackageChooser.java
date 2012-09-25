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
package org.nuxeo.ide.sdk.ui.widgets;

import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.nuxeo.ide.common.UI;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class PackageChooser extends ObjectChooser<IPackageFragment> {

    protected IJavaProject project;

    public PackageChooser(Composite parent) {
        super(parent, "Browse");
    }

    public PackageChooser(Composite parent, String btnLabel) {
        super(parent, btnLabel);
    }

    public void setProject(IJavaProject project) {
        this.project = project;
        setText("");
    }

    public IJavaProject getProject() {
        return project;
    }

    public IPackageFragment getPackageFragment() {
        return getValue();
    }

    @Override
    public String toString(IPackageFragment value) {
        return value == null ? "" : value.getElementName();
    }

    @Override
    public IPackageFragment toValue(String text) {
        if (text == null || text.length() == 0) {
            return null;
        }
        if (project != null) {
            return project.getPackageFragmentRoot("/src/main/java").getPackageFragment(
                    text);
        }
        return null;
    }

    @Override
    protected IPackageFragment changePressed(IPackageFragment pack) {
        return choosePackage(pack);
    }

    public IPackageFragmentRoot getSourceRoot(IJavaProject project) {
        IResource resource = project.getProject().getFolder("src/main/java");
        return project.getPackageFragmentRoot(resource);
    }

    protected IPackageFragment choosePackage(IPackageFragment pack) {
        IPackageFragmentRoot froot = getSourceRoot(project);
        IJavaElement[] packages = null;
        try {
            if (froot != null && froot.exists()) {
                packages = froot.getChildren();
            }
        } catch (JavaModelException e) {
            UI.showError("Cannot find root fragment", e);
        }
        if (packages == null) {
            packages = new IJavaElement[0];
        }

        ElementListSelectionDialog dialog = new ElementListSelectionDialog(
                getShell(), new JavaElementLabelProvider(
                        JavaElementLabelProvider.SHOW_DEFAULT));
        dialog.setIgnoreCase(false);
        dialog.setTitle("Package Selection");
        dialog.setMessage("Choose a Folder:");
        dialog.setEmptyListMessage("Cannot find packages to select.");
        dialog.setElements(packages);
        dialog.setHelpAvailable(false);

        if (pack != null) {
            dialog.setInitialSelections(new Object[] { pack });
        }

        if (dialog.open() == Window.OK) {
            return (IPackageFragment) dialog.getFirstResult();
        }
        return null;
    }

}
