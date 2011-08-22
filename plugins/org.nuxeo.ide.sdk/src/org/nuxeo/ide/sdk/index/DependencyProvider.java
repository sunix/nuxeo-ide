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
package org.nuxeo.ide.sdk.index;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.internal.corext.refactoring.structure.ReferenceFinderUtil;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class DependencyProvider {

    public static Set<Dependency> getDependencies(IJavaProject project)
            throws Exception {
        Set<Dependency> result = new HashSet<Dependency>();
        for (IPackageFragmentRoot root : project.getPackageFragmentRoots()) {
            if (root.getKind() == IPackageFragmentRoot.K_SOURCE) {
                introspectPackageRoot(root, result);
            }
        }
        return result;
    }

    protected static void introspectPackageRoot(IPackageFragmentRoot root,
            Set<Dependency> result) throws Exception {
        for (Object pkg : root.getChildren()) {
            introspectPackage((IPackageFragment) pkg, result);
        }
    }

    protected static void introspectPackage(IPackageFragment pkg,
            Set<Dependency> result) throws Exception {
        for (ICompilationUnit unit : pkg.getCompilationUnits()) {
            introspectUnit(unit, result);
        }
    }

    protected static final boolean acceptType(String fqn) {
        return !fqn.startsWith("java.");
    }

    protected static void introspectUnit(ICompilationUnit unit,
            Set<Dependency> result) throws Exception {
        IJavaProject project = unit.getJavaProject();
        IType[] types = ReferenceFinderUtil.getTypesReferencedIn(
                new IJavaElement[] { unit }, new NullProgressMonitor());
        for (IType type : types) {
            String path = type.getFullyQualifiedName();
            if (acceptType(path)) {
                Dependency dep = createExternalDependency(project, type);
                if (dep != null) {
                    result.add(dep);
                }
            }
        }
    }

    public static Dependency createExternalDependency(IJavaProject project,
            IType type) {
        ICompilationUnit unit = type.getCompilationUnit();
        Dependency dep = null;
        if (unit == null) {
            dep = new Dependency(type);
            dep.setJar(type.getPath().toFile());
        } else {
            IJavaProject srcProject = unit.getJavaProject();
            if (!srcProject.equals(project)) {
                dep = new Dependency(type);
                dep.setProject(srcProject);
            } // else ignore
        }
        return dep;
    }

}
