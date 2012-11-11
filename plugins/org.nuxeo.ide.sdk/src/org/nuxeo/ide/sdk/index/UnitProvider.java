/*
 * (C) Copyright 2006-2012 Nuxeo SAS (http://nuxeo.com/) and contributors.
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
 *     Vladimir Pasquier <vpasquier@nuxeo.com>
 *     bstefanescu
 */
package org.nuxeo.ide.sdk.index;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IImportDeclaration;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.JavaElement;
import org.eclipse.jdt.internal.core.PackageFragment;

/**
 * UnitProvider retrieves all unit classes having given dependencies
 * 
 */
public class UnitProvider {

    protected List<ICompilationUnit> pojoUnits;

    protected List<ICompilationUnit> depUnits;

    /**
     * Examples: org, com...
     */
    protected String parentNameSpace = "";

    public void getUnitsForDep(IProject project, String depName)
            throws Exception {
        IJavaProject jproject = JavaCore.create(project);
        IResource rootResource = project.getProject().getFolder("src/main/java");
        if (rootResource.exists()) {
            IPackageFragmentRoot root = jproject.getPackageFragmentRoot(rootResource);
            if (root != null) {
                introspectPackageRoot(root, depName);
            }
        }
    }

    protected void introspectPackageRoot(IPackageFragmentRoot root,
            String depName) throws Exception {
        depUnits = new ArrayList<ICompilationUnit>();
        pojoUnits = new ArrayList<ICompilationUnit>();
        for (Object pkg : root.getChildren()) {
            if (parentNameSpace.isEmpty()
                    && !((PackageFragment) pkg).getElementName().isEmpty()) {
                parentNameSpace = ((JavaElement) pkg).getElementName();
            }
            for (ICompilationUnit unit : ((IPackageFragment) pkg).getCompilationUnits()) {
                if (isDepUnit(depName, unit)) {
                    depUnits.add(unit);
                    continue;
                }
                pojoUnits.add(unit);
            }
        }
    }

    protected boolean isDepUnit(String depName, ICompilationUnit unit)
            throws JavaModelException {
        for (IImportDeclaration imp : unit.getImports()) {
            if (imp.getElementName().equals(depName)) {
                return true;
            }
        }
        return false;
    }

    public List<ICompilationUnit> getPojoUnits() {
        return pojoUnits;
    }

    public List<ICompilationUnit> getDepUnits() {
        return depUnits;
    }

    public String getParentNameSpace() {
        return parentNameSpace;
    }

}