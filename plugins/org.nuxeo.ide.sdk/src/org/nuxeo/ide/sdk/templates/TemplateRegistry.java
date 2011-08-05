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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class TemplateRegistry {

    public static final String DEFAULT_TEMPLATE = "Empty Project";

    protected Map<String, Template> templates;

    public TemplateRegistry() {
        this.templates = new HashMap<String, Template>();
    }

    public synchronized void reset() {
        templates.clear();
    }

    public void loadtemplates(Bundle bundle) {
        Bundle[] bundles = Platform.getFragments(bundle);
        if (bundles == null) {
            return;
        }
        for (Bundle fragment : bundles) {
            String value = (String) fragment.getHeaders().get(
                    "Nuxeo-ProjectTemplates");
            if (value != null) {
                String[] ar = value.split("\\s*,\\s*");
                if (ar != null) {
                    for (int i = 0; i < ar.length; i++) {
                        try {
                            Template temp = Template.fromString(fragment, ar[i]);
                            addTemplate(temp);
                        } catch (ParseException e) {
                            // ignore and log
                            System.err.println("Failed to parse template definition:"
                                    + e.getMessage());
                        }
                    }
                }
            }
        }
    }

    public synchronized Template[] getTemplates() {
        return templates.values().toArray(new Template[templates.size()]);
    }

    public synchronized Template getTemplate(String key) {
        if (key == null) {
            key = DEFAULT_TEMPLATE;
        }
        return templates.get(key);
    }

    public synchronized void addTemplate(Template temp) {
        templates.put(temp.getName(), temp);
    }

    public void copyTemplate(String name, File projectRoot) throws IOException {
        // return new File("/Users/bstefanescu/tmp/ide/nx.zip");
        Template temp = getTemplate(name);
        if (temp == null) {
            throw new FileNotFoundException("Template " + name
                    + " was not found");
        }
        temp.copyTo(projectRoot);
    }

}
