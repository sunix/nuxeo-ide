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
package org.nuxeo.ide.sdk.features;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.nuxeo.ide.sdk.model.ExtensionModel;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class FeatureType {

    public static FeatureType fromElement(Object element) {
        try {
            if (element instanceof ICompilationUnit) {
                ICompilationUnit unit = (ICompilationUnit) element;
                IType[] types = unit.getTypes();
                if (types.length == 0) {
                    return null;
                }
                IType type = types[0];
                IFile file = type.getJavaProject().getProject().getFile(
                        ExtensionModel.BASE_PATH + "/"
                                + type.getFullyQualifiedName() + ".xml");
                return new FeatureType(unit, type, file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public final ICompilationUnit unit;

    public final IType type;

    public final IFile file;

    public FeatureType(ICompilationUnit unit, IType type, IFile file) {
        this.unit = unit;
        this.type = type;
        this.file = file;
    }

    public IProject getProject() {
        return file.getProject();
    }

    public String getExtensionPath() {
        return ExtensionModel.getPath(type.getFullyQualifiedName());
    }

    public String getRuntimeExtensionPath() {
        return ExtensionModel.getRuntimePath(type.getFullyQualifiedName());
    }

}
