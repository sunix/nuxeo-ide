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
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;

import org.apache.xml.serialize.Method;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
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
        write(file, null);
    }

    public void write(File file, String encoding) throws Exception {
        FileOutputStream out = new FileOutputStream(file);
        try {
            write(out, encoding);
        } finally {
            out.close();
        }
    }

    public void write(OutputStream out) throws Exception {
        write(out, null);
    }

    public void write(OutputStream out, String encoding) throws Exception {
        OutputStreamWriter writer = new OutputStreamWriter(out,
                encoding == null ? "UTF-8" : encoding);
        write(writer, encoding);
        writer.flush();
    }

    public void write(Writer writer) throws Exception {
        write(writer, null);
    }

    public void write(Writer writer, String encoding) throws Exception {
        if (encoding == null) {
            encoding = "UTF-8";
        }

        // DOMImplementationLS impl = (DOMImplementationLS)
        // DOMImplementationRegistry.newInstance().getDOMImplementation(
        // "LS");
        // LSSerializer serializer = impl.createLSSerializer();
        // if (serializer.getDomConfig().canSetParameter("format-pretty-print",
        // Boolean.TRUE)) {
        // serializer.getDomConfig().setParameter("format-pretty-print",
        // Boolean.TRUE);
        // }
        // if (serializer.getDomConfig().canSetParameter(
        // "element-content-whitespace", Boolean.FALSE)) {
        // serializer.getDomConfig().setParameter(
        // "element-content-whitespace", Boolean.FALSE);
        // }
        //
        // LSOutput out = impl.createLSOutput();
        //
        // out.setEncoding(encoding);
        // out.setCharacterStream(writer);
        //
        // serializer.write(doc, out);

        // this is the single method I found it formats OK.
        OutputFormat format = new OutputFormat(Method.XML, encoding, true);
        format.setIndent(2);
        XMLSerializer serializer2 = new XMLSerializer(writer, format);
        serializer2.serialize(doc);
        writer.flush();
    }

    public String toXML() throws Exception {
        return toXML(null);
    }

    public String toXML(String encoding) throws Exception {
        StringWriter writer = new StringWriter();
        write(writer, encoding);
        return writer.toString();
    }

}
