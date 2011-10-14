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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IImportDeclaration;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.corext.refactoring.structure.ReferenceFinderUtil;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class DependencyProvider {

    /**
     * Get all dependencies
     * 
     * @param project
     * @return
     * @throws Exception
     */
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

    /**
     * Get all non test dependencies
     * 
     * @param project
     * @return
     * @throws Exception
     */
    public static Set<Dependency> getNonTestDependencies(IJavaProject project)
            throws Exception {
        IPath testPrefix = new Path("src/test");
        Set<Dependency> result = new HashSet<Dependency>();
        for (IPackageFragmentRoot root : project.getPackageFragmentRoots()) {
            if (root.getKind() == IPackageFragmentRoot.K_SOURCE) {
                IResource r = root.getCorrespondingResource();
                if (r != null
                        && !testPrefix.isPrefixOf(r.getProjectRelativePath())) {
                    introspectPackageRoot(root, result);
                }
            }
        }
        return result;
    }

    public static Set<Dependency> getTestDependencies(IJavaProject project)
            throws Exception {
        Set<Dependency> result = new HashSet<Dependency>();
        IResource rootResource = project.getProject().getFolder("src/test/java");
        if (rootResource.exists()) {
            IPackageFragmentRoot root = project.getPackageFragmentRoot(rootResource);
            if (root != null) {
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
        ArrayList<IType> types = new ArrayList<IType>();
        
        // collect unit types deps
        IType[] refTypes = ReferenceFinderUtil.getTypesReferencedIn(new IJavaElement[] { unit }, new NullProgressMonitor());
        types.addAll(Arrays.asList(refTypes));
        
        // add imported types
        for (IImportDeclaration imp:unit.getImports()) {
            String fqn = imp.getElementName();
            IType type = project.findType(fqn);
            if (type != null) {
                types.add(type);
            }
        }
        
        // generate deps
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
