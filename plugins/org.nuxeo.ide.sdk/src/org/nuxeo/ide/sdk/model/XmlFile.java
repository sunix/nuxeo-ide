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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class XmlFile {

    public static final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    public static final TransformerFactory trFactory = TransformerFactory.newInstance();

    protected Document doc;

    protected XmlFile() {

    }

    public XmlFile(String xml) throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream(
                xml.getBytes("UTF-8"));
        this.doc = factory.newDocumentBuilder().parse(in);
    }

    public XmlFile(File file) throws Exception {
        this.doc = factory.newDocumentBuilder().parse(file);
    }

    public XmlFile(Document doc) {
        this.doc = doc;
    }

    public XmlFile(URL url) throws Exception {
        this(url.openStream());
    }

    public XmlFile(InputStream in) throws Exception {
        try {
            this.doc = factory.newDocumentBuilder().parse(in);
        } finally {
            in.close();
        }
    }

    public Element getFirstElement(String name) {
        return getFirstElement(doc.getDocumentElement(), name);
    }

    public Element getFirstElement(Element root, String name) {
        Node node = root.getFirstChild();
        while (node != null) {
            if (node.getNodeType() == Node.ELEMENT_NODE
                    && node.getNodeName().equals(name)) {
                return (Element) node;
            }
            node = node.getNextSibling();
        }
        return null;
    }

    public void write(File file) throws Exception {
        Transformer transformer = trFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        DOMSource src = new DOMSource(doc);
        StreamResult result = new StreamResult(file);
        transformer.transform(src, result);
    }

    public void write(OutputStream out) throws Exception {
        Transformer transformer = trFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        DOMSource src = new DOMSource(doc);
        StreamResult result = new StreamResult(out);
        transformer.transform(src, result);
    }

    public void write(Writer out) throws Exception {
        Transformer transformer = trFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        DOMSource src = new DOMSource(doc);
        StreamResult result = new StreamResult(out);
        transformer.transform(src, result);
    }

    public String toXML() throws Exception {
        StringWriter writer = new StringWriter();
        Transformer transformer = trFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        DOMSource src = new DOMSource(doc);
        StreamResult result = new StreamResult(writer);
        transformer.transform(src, result);
        return writer.toString();
    }

}
