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

import java.io.File;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class Dependency {

    protected String name;

    protected IType type;

    protected IJavaProject project;

    protected File jar;

    public Dependency(IType type) {
        this.type = type;
        this.name = type.getFullyQualifiedName();
    }

    public String getName() {
        return name;
    }

    public void setJar(File jar) {
        this.jar = jar;
    }

    public void setProject(IJavaProject project) {
        this.project = project;
    }

    public IJavaProject getProject() {
        return project;
    }

    public File getJar() {
        return jar;
    }

    public boolean isBinary() {
        return jar != null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Dependency) {
            Dependency dep = ((Dependency) obj);
            if (dep.name.equals(name)) {
                if (dep.jar != null) {
                    if (jar == null) {
                        return false;
                    } else {
                        return dep.jar.equals(jar);
                    }
                } else if (jar == null) {
                    return project.getPath().equals(dep.project.getPath());
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name + " ["
                + (jar == null ? project.getPath() : jar.getAbsolutePath())
                + "]";
    }

    public String getLocation() {
        return jar == null ? project.getProject().getName() : jar.getName();
    }
}
