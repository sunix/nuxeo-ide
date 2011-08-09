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
import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.nuxeo.ide.common.IOUtils;
import org.osgi.framework.Bundle;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ProjectTemplate implements Comparable<ProjectTemplate> {

    protected String id;

    protected String name;

    protected String description;

    protected String src;

    private ProjectTemplate(String id) {
        this.id = id;
        this.name = id;
    }

    public String getId() {
        return id;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getSrc() {
        return src;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return src;
    }

    public void copyTo(Bundle bundle, File dir) throws IOException {
        if (src.endsWith(".zip")) {
            URL url = bundle.getEntry(src);
            if (url == null) {
                throw new FileNotFoundException("Template " + name
                        + " not found in bundle " + bundle.getSymbolicName()
                        + " at " + src);
            }
            InputStream in = url.openStream();
            try {
                IOUtils.unzip(in, dir);
            } finally {
                in.close();
            }
        } else {
            File bundleFile = FileLocator.getBundleFile(bundle);
            if (bundleFile.isDirectory()) {
                IOUtils.copyTree(new File(bundleFile, src), dir);
            } else {
                IOUtils.unzip(bundleFile, src, dir);
            }
        }
    }

    @Override
    public int compareTo(ProjectTemplate temp) {
        return name.compareTo(temp.name);
    }

    @Override
    public String toString() {
        return id + " [" + src + "]";
    }

    public static ProjectTemplate load(Element element) {
        ProjectTemplate temp = new ProjectTemplate(element.getAttribute("id"));
        temp.src = element.getAttribute("src");
        Node child = element.getFirstChild();
        while (child != null) {
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) child;
                String tag = child.getNodeName();
                if ("name".equals(tag)) {
                    temp.name = el.getTextContent().trim();
                } else if ("description".equals(tag)) {
                    temp.description = el.getTextContent().trim();
                }
            }
            child = child.getNextSibling();
        }
        return temp;
    }
}
