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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ComponentTemplate {

    protected String id;

    protected String name;

    protected String description;

    protected String src;

    protected ManifestModification[] mf;

    protected String[] extensions;

    protected Dependency[] dependencies;

    public ComponentTemplate(String id) {
        this.id = id;
        this.name = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setManifestModifications(ManifestModification[] mf) {
        this.mf = mf;
    }

    /**
     * Return null if not manifest modifications are required.
     * 
     * @return
     */
    public ManifestModification[] getManifestModifications() {
        return mf;
    }

    public void setExtensions(String[] extensions) {
        this.extensions = extensions;
    }

    /**
     * Return null if no extensions are contributed
     * 
     * @return
     */
    public String[] getExtensions() {
        return extensions;
    }

    public void setDependencies(Dependency[] dependencies) {
        this.dependencies = dependencies;
    }

    /**
     * Return null if no pom dependencies are added
     * 
     * @return
     */
    public Dependency[] getDependencies() {
        return dependencies;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return id;
    }

    public void apply(File projectRoot) throws IOException {
        // TODO
    }

    static class ManifestModification {
        String key;

        String value;

        boolean overwrite;

        boolean append;
    }

    static class Dependency {
        String groupId;

        String artifactId;

        String version;

        String scope;

        String type;
    }

    public static ComponentTemplate load(Element element) {
        ComponentTemplate temp = new ComponentTemplate(
                element.getAttribute("id"));
        Node child = element.getFirstChild();
        temp.src = DomUtil.getAttribute(element, "src");
        List<ManifestModification> manifest = new ArrayList<ComponentTemplate.ManifestModification>();
        List<String> extensions = new ArrayList<String>();
        List<Dependency> deps = new ArrayList<Dependency>();
        while (child != null) {
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) child;
                String tag = child.getNodeName();
                if ("name".equals(tag)) {
                    temp.name = el.getTextContent().trim();
                } else if ("description".equals(tag)) {
                    temp.description = el.getTextContent().trim();
                } else if ("manifest".equals(tag)) {
                    ManifestModification mf = new ManifestModification();
                    mf.key = el.getAttribute("key");
                    mf.value = el.getAttribute("value");
                    mf.overwrite = DomUtil.getBooleanAttribute(el, "overwrite",
                            false);
                    mf.append = DomUtil.getBooleanAttribute(el, "append", false);
                    manifest.add(mf);
                } else if ("dependency".equals(tag)) {
                    Dependency dep = new Dependency();
                    dep.groupId = el.getAttribute("groupId");
                    dep.artifactId = el.getAttribute("artifactId");
                    dep.scope = DomUtil.getAttribute(el, "scope");
                    dep.type = DomUtil.getAttribute(el, "type");
                    dep.version = DomUtil.getAttribute(el, "version");
                    deps.add(dep);
                } else if ("extension".equals(tag)) {
                    String src = DomUtil.getAttribute(element, "src");
                    if (src != null) {
                        extensions.add(src);
                    }
                }
            }
            child = child.getNextSibling();
        }
        if (!manifest.isEmpty()) {
            temp.mf = manifest.toArray(new ManifestModification[manifest.size()]);
        }
        if (!extensions.isEmpty()) {
            temp.extensions = extensions.toArray(new String[extensions.size()]);
        }
        if (!deps.isEmpty()) {
            temp.dependencies = deps.toArray(new Dependency[deps.size()]);
        }
        return temp;
    }
}
