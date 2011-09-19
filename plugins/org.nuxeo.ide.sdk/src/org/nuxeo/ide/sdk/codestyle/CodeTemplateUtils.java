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
package org.nuxeo.ide.sdk.codestyle;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.internal.corext.template.java.CodeTemplateContextType;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.viewsupport.ProjectTemplateStore;
import org.eclipse.jface.text.templates.Template;

/**
 * See StubUtility class in JDT for the template API.
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class CodeTemplateUtils {

    public static String getCopyrightHeader() throws Exception {
        Template template = getCodeTemplate(
                CodeTemplateContextType.FILECOMMENT_ID, null);
        if (template == null) {
            return null;
        }

        return template.getPattern();
    }

    public static String getAuthorTag() {
        Template template = getCodeTemplate(
                CodeTemplateContextType.TYPECOMMENT_ID, null);
        if (template == null) {
            return null;
        }
        String pattern = template.getPattern();
        Matcher m = Pattern.compile("@author\\s+[^\r\n]+").matcher(pattern);
        if (m.find()) {
            return m.group().trim();
        }
        return null;
    }

    private static Template getCodeTemplate(String id, IJavaProject project) {
        if (project == null)
            return JavaPlugin.getDefault().getCodeTemplateStore().findTemplateById(
                    id);
        ProjectTemplateStore projectStore = new ProjectTemplateStore(
                project.getProject());
        try {
            projectStore.load();
        } catch (IOException e) {
            JavaPlugin.log(e);
        }
        return projectStore.findTemplateById(id);
    }

}
