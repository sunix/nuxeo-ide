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

import org.nuxeo.ide.common.IOUtils;
import org.osgi.framework.Bundle;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ProjectTemplate extends Template {

    public ProjectTemplate(String id) {
        super(id);
    }

    @Override
    public void process(Bundle bundle, TemplateContext ctx, File dir)
            throws Exception {
        // create a temporary directory in the same parent as the final
        // directory
        // (to be sure renameTo will work)
        File tmp = IOUtils.createTempDir(dir.getParentFile());
        try {
            expand(bundle, ctx, tmp);
            tmp.renameTo(dir);
        } finally {
            if (tmp.exists()) {
                IOUtils.deleteTree(tmp);
            }
        }

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
