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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.osgi.framework.Bundle;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class TemplateRegistry {

    public static final String DEFAULT_TEMPLATE = "default";

    protected Bundle bundle;

    protected String version;

    protected Map<String, Template> templates;

    TemplateRegistry() {
        this.templates = new HashMap<String, Template>();
    }

    public TemplateRegistry(Bundle bundle) {
        this();
        this.bundle = bundle;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void processTemplate(String id, TemplateContext ctx, File projectRoot)
            throws Exception {
        Template temp = getTemplate(id);
        if (temp == null) {
            throw new FileNotFoundException("Wizard Template " + id
                    + " was not found");
        }
        temp.process(bundle, ctx, projectRoot);
    }

    public void postProcessTemplate(String id, TemplateContext ctx,
            IProject project) throws Exception {
        Template temp = getTemplate(id);
        if (temp == null) {
            throw new FileNotFoundException("Wizard Template " + id
                    + " was not found");
        }
        temp.postProcess(project, ctx);
    }

    public void addTemplate(Template temp) {
        templates.put(temp.getId(), temp);
    }

    public Template[] getTemplates() {
        return templates.values().toArray(new Template[templates.size()]);
    }

    public Template getTemplate(String key) {
        if (key == null) {
            key = DEFAULT_TEMPLATE;
        }
        return templates.get(key);
    }

    protected static TemplateRegistry load(TemplateManager manager,
            Element element) throws Exception {
        TemplateRegistry registry = new TemplateRegistry();
        String version = Util.getAttribute(element, "version", "0.0.0");
        registry.version = version;
        Node child = element.getFirstChild();
        while (child != null) {
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) child;
                String tag = child.getNodeName();
                if ("template".equals(tag)) {
                    registry.addTemplate(Template.load(manager, el));
                }
            }
            child = child.getNextSibling();
        }
        return registry;
    }

}
