/*
 * (C) Copyright 2006-2011 Nuxeo SAS (http://nuxeo.com/) and contributors.
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
 *     slacoin
 */
package org.nuxeo.ide.sdk.features.seam;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.nuxeo.ide.sdk.features.CreateFeatureFromTemplate;
import org.nuxeo.ide.sdk.features.FeatureTemplateContext;
import org.nuxeo.ide.sdk.java.ClasspathEditor;

/**
 * 
 * @author matic
 * @since 1.1
 */
public class CreateSeamFeatureFromTemplate extends CreateFeatureFromTemplate {

    public CreateSeamFeatureFromTemplate(FeatureTemplateContext ctx) {
        super(ctx);
    }

    protected void postCreate(IProgressMonitor monitor) throws Exception {
        super.postCreate(monitor);
        IJavaProject java = ctx.getProject();
        IProject project = java.getProject();
        ClasspathEditor editor = new ClasspathEditor(project);
        editor.extendClasspath("seam");
        editor.extendClasspath("i18n");
        editor.flush();
    }

}
