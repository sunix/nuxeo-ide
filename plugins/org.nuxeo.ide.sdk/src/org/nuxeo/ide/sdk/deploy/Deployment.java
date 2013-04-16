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
 *     bstefanescu
 *     Vladimir Pasquier <vpasquier@nuxeo.com>
 */
package org.nuxeo.ide.sdk.deploy;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IImportDeclaration;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.nuxeo.ide.common.JarUtils;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.nuxeo.ide.sdk.java.ProjectDeployer;
import org.nuxeo.ide.sdk.userlibs.UserLib;

/**
 * Deployment provides all projects outputs (sources, resources) giving to
 * server the dev.bundle file with project outputs locations
 */
public class Deployment {

    protected String name;

    protected Set<IProject> projects;

    protected Set<String> libs;

    public static final String DEPENDENCY_NAME = "org.jboss.seam.annotations.Name";

    public static final String SOURCE_ELEMENT = "@Name";

    /**
     * Java beans output folder (not seam type)
     */
    public static final String POJO_BIN = "bin/nxsdk-pojo";

    /**
     * Seam beans output folder
     */
    public static final String SEAM_BIN = "bin/nxsdk-beans";

    public Deployment(String name) {
        this.name = name;
        projects = new HashSet<IProject>();
        libs = new HashSet<String>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addProject(IProject project) {
        projects.add(project);
    }

    public void addProjects(IProject[] projects) {
        this.projects.addAll(Arrays.asList(projects));
    }

    public void removeProject(IProject project) {
        projects.remove(project);
    }

    public void clearProjects() {
        projects.clear();
    }

    public IProject[] getProjects() {
        return projects.toArray(new IProject[projects.size()]);
    }

    public void addLibrary(UserLib userLib) {
        libs.add(userLib.getPath());
    }

    public void addLibraries(UserLib[] libs) {
        for (UserLib lib : libs) {
            this.libs.add(lib.getPath());
        }
    }

    public void removeLibrary(UserLib lib) {
        libs.remove(lib.getPath());
    }

    public void clearLibraries() {
        libs.clear();
    }

    public List<String> getProjectNames() {
        ArrayList<String> result = new ArrayList<String>(projects.size());
        for (IProject project : projects) {
            result.add(project.getName());
        }
        return result;
    }

    public Set<String> getLibraryPaths() {
        return libs;
    }

    public UserLib[] getLibraries() {
        UserLib[] result = new UserLib[libs.size()];
        int i = 0;
        for (String path : libs) {
            result[i++] = new UserLib(path);
        }
        return result;
    }

    public String getContentAsString() throws Exception {
        final String crlf = "\n";
        StringBuilder builder = new StringBuilder();
        builder.append("# Projects").append(crlf);
        for (IProject project : projects) {
            ProjectDeployer.copy(JavaCore.create(project), new NullProgressMonitor(), builder);
        }
        builder.append("# User Libraries").append(crlf);
        for (String lib : libs) {
            File file = new File(lib);
            if (file.exists()) {
            	if (JarUtils.isBundle(file)) {
            		builder.append("bundle:").append(lib).append(crlf);
            	} else {
            		builder.append("library:").append(lib).append(crlf);
            	}
            }
        }
        return builder.toString();
    }

    protected IFolder nxdataFolder(IJavaProject project) throws JavaModelException {
        IPath outputPath = project.getOutputLocation().removeFirstSegments(1).removeLastSegments(1).append("nxdata");
        return project.getProject().getFolder(outputPath);
    }

    /**
     * For a given @param depName java unit import, retrieves all unit classes
     * having given dependencies Parse all resources from src/main folder (could
     * be src/main/java, src/main/seam...)
     */
    protected void buildProjectCommands(Set<String> commands, IProject project) throws Exception {
        IJavaProject java = JavaCore.create(project);
        IFolder nxdataFolder = nxdataFolder(java);
        if (nxdataFolder.exists()) {
            nxdataFolder.delete(false, new NullProgressMonitor());
        }
        for (IPackageFragmentRoot root : java.getPackageFragmentRoots()) {
            if (root.getKind() != IPackageFragmentRoot.K_SOURCE) {
                continue;
            }
            if (!"main".equals(root.getCorrespondingResource().getParent().getName())) {
                continue;
            }
            copyPackageRoot(commands, root);
        }
    }

    protected void copyPackageRoot(Set<String> commands, IPackageFragmentRoot root)
            throws Exception {
        for (IJavaElement child : root.getChildren()) {
            switch (child.getElementType()) {
            case IJavaElement.PACKAGE_FRAGMENT:
                copyPackageFragment(commands, root, (IPackageFragment) child);
                break;
            case IJavaElement.COMPILATION_UNIT:
                copyCompilationUnit(commands, root, (ICompilationUnit) child);
                break;
            }
        }
        root.getNonJavaResources();
    }

    protected void copyPackageFragment(Set<String> commands, IPackageFragmentRoot root, IPackageFragment fragment) throws CoreException {
        for (ICompilationUnit unit : fragment.getCompilationUnits()) {
            copyCompilationUnit(commands, root, unit);
        }
    }

    protected String unitOutput(ICompilationUnit unit)
            throws JavaModelException {
        for (IImportDeclaration imp : unit.getImports()) {
            if (imp.getElementName().equals("org.jboss.seam.annotations.Name")
                    && unit.getSource().contains("@Name")) {
                return "seam";
            }
        }
        return "bundle";
    }

    protected void copyCompilationUnit(Set<String> commands, IPackageFragmentRoot root, ICompilationUnit unit) throws JavaModelException, CoreException {
        IJavaProject java = (IJavaProject) root.getParent();
        String type = unitOutput(unit);
        IFolder nxdataFolder = nxdataFolder(java).getFolder(type);
        IProject project = java.getProject();
        IPath outputLocation = java.getOutputLocation();
        IPath path = unit.getPath().removeFirstSegments(
                root.getPath().segmentCount()).removeLastSegments(1);
        path = path.append(org.eclipse.jdt.internal.core.util.Util.getNameWithoutJavaLikeExtension(unit.getElementName())
                + ".class"); //$NON-NLS-1$
        IContainer container = (IContainer) project.getWorkspace().getRoot().findMember(
                outputLocation);
        IResource dotClassMember = container.findMember(path);
        if (dotClassMember == null) {
            SDKPlugin.log(IStatus.ERROR, "Cannot find binary class " + path + " in project " + java.getElementName());
            return;
        }

        IFile outputFile = nxdataFolder.getFile(path);
        mkdirs((IFolder)outputFile.getParent(), new NullProgressMonitor());
        dotClassMember.copy(outputFile.getFullPath(), IResource.HIDDEN|IResource.DERIVED, new NullProgressMonitor());
        commands.add(type +":" + nxdataFolder.getLocation().toOSString());
    }

    protected void mkdirs(IFolder folder, IProgressMonitor monitor) throws CoreException {
        if (folder.exists()) {
            return;
        }
        mkdirs((IFolder)folder.getParent(), monitor);
        folder.create(false, true, monitor);
    }
}
