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
package org.nuxeo.ide.sdk.templates;

import java.io.File;
import java.util.HashMap;

import org.nuxeo.ide.common.forms.Form;

/**
 * The base class for all template contexts.
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
@SuppressWarnings("serial")
public class TemplateContext extends HashMap<String, Object> {

    protected String template;

    protected File projectLocation;

    public TemplateContext() {
        initDefaults();
    }

    protected void initDefaults() {
        try {
            String user = System.getProperty("user.name");
            put("user", user);
            put("copyright",
                    TemplatePrefs.getCopyrightHeader().replace("${user}", user));
            put("classHeader",
                    TemplatePrefs.getClassHeader().replace("${user}", user));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTemplate() {
        return template;
    }

    public File getProjectLocation() {
        return projectLocation;
    }

    public void setProjectLocation(File projectLocation) {
        this.projectLocation = projectLocation;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getProperty(String key) {
        return (String) get(key);
    }

    public String setProperty(Form form, String key) {
        String v = form.getWidgetValueAsString(key);
        put(key, v);
        return v;
    }

    public String setProperty(Form form, String key, String alias) {
        String v = form.getWidgetValueAsString(key);
        put(key, v);
        put(alias, v);
        return v;
    }

    public String setProperty(Form form, String key, String alias1,
            String alias2) {
        String v = form.getWidgetValueAsString(key);
        put(key, v);
        put(alias1, v);
        put(alias2, v);
        return v;
    }

    public void setPropertyIfNotNull(Form form, String key) {
        String v = form.getWidgetValueAsString(key);
        v = v.trim();
        if (v != null && v.length() > 0) {
            put(key, v);
        }
    }

    public void setPropertyIfNotNull(Form form, String key, String alias) {
        String v = form.getWidgetValueAsString(key);
        v = v.trim();
        if (v != null && v.length() > 0) {
            put(key, v);
            put(alias, v);
        }
    }

}
