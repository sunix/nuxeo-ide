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

import java.io.File;

import org.eclipse.jdt.core.IJavaProject;
import org.nuxeo.ide.sdk.templates.TemplateContext;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
@SuppressWarnings("serial")
public class FeatureTemplateContext extends TemplateContext {

    public static final String CLASS_NAME = "className";

    public static final String PACKAGE_NAME = "package";

    public static final String PACKAGE_PATH = "packagePath";

    protected IJavaProject project;

    public void setProject(IJavaProject project) {
        this.project = project;
        if (project != null) {
            this.projectLocation = project.getProject().getLocation().toFile();
        }
    }

    public IJavaProject getProject() {
        return project;
    }

    @Override
    public void setProjectLocation(File projectLocation) {
        throw new UnsupportedOperationException(
                "You should call setProject instead.");
    }

    public String getClassName() {
        return (String) get(CLASS_NAME);
    }

    public void setClassName(String className) {
        this.put(CLASS_NAME, className);
    }

    public String getPackage() {
        return (String) get(PACKAGE_NAME);
    }

    public void setPackage(String packageName) {
        this.put(PACKAGE_NAME, packageName);
        if (packageName != null) {
            this.put(PACKAGE_PATH, packageName.replace('.', '/'));
        }
    }

    public String getPackagePath() {
        return (String) get(PACKAGE_PATH);
    }

}
