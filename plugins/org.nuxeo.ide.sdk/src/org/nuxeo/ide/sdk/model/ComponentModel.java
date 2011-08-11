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
package org.nuxeo.ide.sdk.model;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ComponentModel extends XmlFile {

    public ComponentModel() throws Exception {
        this.doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElement("component");
        this.doc.appendChild(root);
    }

    public ComponentModel(String xml) throws Exception {
        super(xml);
    }

    public ComponentModel(File file) throws Exception {
        super(file);
    }

    public ComponentModel(Document doc) {
        super(doc);
    }

    public ComponentModel(URL url) throws Exception {
        super(url);
    }

    public ComponentModel(InputStream in) throws Exception {
        super(in);
    }

    public Document doc() {
        return doc;
    }

    public void setName(String name) {
        this.doc.getDocumentElement().setAttribute("name", name);
    }

    public void setVersion(String version) {
        this.doc.getDocumentElement().setAttribute("name", version);
    }

    public String getName() {
        return this.doc.getDocumentElement().getAttribute("name");
    }

    public String getVersion() {
        return this.doc.getDocumentElement().getAttribute("version");
    }

    public List<Element> getExtensions() {
        ArrayList<Element> xts = new ArrayList<Element>();
        Node node = doc.getDocumentElement().getFirstChild();
        while (node != null) {
            if (node.getNodeType() == Node.ELEMENT_NODE
                    && "extension".equals(node.getNodeName())) {
                xts.add((Element) node);
            }
            node = node.getNextSibling();
        }
        return xts;
    }

    /**
     * Copy the extension from the given component to the current one.
     * 
     * @param comp
     */
    public void copyExtensionsTo(ComponentModel comp) {
        Element root = comp.doc.getDocumentElement();
        for (Element el : getExtensions()) {
            Node node = comp.doc.importNode(el, true);
            root.appendChild(node);
        }
    }

    public void moveExtensionsTo(ComponentModel comp) {
        Element root = comp.doc.getDocumentElement();
        for (Element el : getExtensions()) {
            try {
                Node node = comp.doc.adoptNode(el);
                root.appendChild(node);
            } catch (DOMException e) {
                Node node = comp.doc.importNode(el, true);
                root.appendChild(node);
            }
        }
    }

}
