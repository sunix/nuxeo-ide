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
package org.nuxeo.ide.sdk.comp;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

import org.apache.xml.serialize.Method;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.nuxeo.ide.sdk.model.XmlFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ComponentLoader {

    public ComponentModel loadComponent(File file) throws Exception {
        Document doc = XmlFile.factory.newDocumentBuilder().parse(file);

        Element root = doc.getDocumentElement();
        String name = root.getAttribute("name");
        ComponentModel model = new ComponentModel(name);
        model.version = root.getAttribute("version");
        if (model.version.length() == 0) {
            model.version = "0.0.0";
        }

        ArrayList<ExtensionPointModel> xpoints = new ArrayList<ExtensionPointModel>();
        ArrayList<ExtensionModel> extensions = new ArrayList<ExtensionModel>();

        Node node = root.getFirstChild();
        while (node != null) {
            if (Node.ELEMENT_NODE == node.getNodeType()) {
                Element child = (Element) node;
                String tag = node.getNodeName().toLowerCase();
                if ("implementation".equals(tag)) {
                    model.impl = child.getAttribute("class");
                } else if ("service".equals(tag)) {
                    loadServices(model, child);
                } else if ("extension-point".equals(tag)) {
                    xpoints.add(loadExtensionPoint(model, child));
                } else if ("extension".equals(tag)) {
                    extensions.add(loadExtension(model, child));
                } else if ("documentation".equals(tag)) {
                    model.documentation = getDocumentation(child);
                }
            }
            node = node.getNextSibling();
        }

        model.xpoints = xpoints.toArray(new ExtensionPointModel[xpoints.size()]);
        model.extensions = extensions.toArray(new ExtensionModel[extensions.size()]);

        return model;
    }

    protected void loadServices(ComponentModel component, Element element) {
        ArrayList<ServiceModel> models = new ArrayList<ServiceModel>();
        Node node = element.getFirstChild();
        while (node != null) {
            if (Node.ELEMENT_NODE == node.getNodeType()) {
                Element child = (Element) node;
                String tag = node.getNodeName().toLowerCase();
                if ("provide".equals(tag)) {
                    models.add(new ServiceModel(component,
                            child.getAttribute("interface")));
                }
            }
            node = node.getNextSibling();
        }
        component.services = models.toArray(new ServiceModel[models.size()]);
    }

    protected ExtensionPointModel loadExtensionPoint(ComponentModel component,
            Element elementl) {
        String name = elementl.getAttribute("name");
        String documentation = "";
        ArrayList<String> contribs = new ArrayList<String>();
        Node node = elementl.getFirstChild();
        while (node != null) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) node;
                String tag = node.getNodeName().toLowerCase();
                if ("documentation".equals(tag)) {
                    documentation = getDocumentation(child);
                } else if ("object".equals(tag)) {
                    contribs.add(child.getAttribute("class"));
                }
            }
            node = node.getNextSibling();
        }
        ExtensionPointModel model = new ExtensionPointModel(component, name,
                documentation);
        model.contribs = contribs.toArray(new String[contribs.size()]);
        return model;
    }

    protected ExtensionModel loadExtension(ComponentModel model, Element element) {
        String target = element.getAttribute("target");
        String point = element.getAttribute("point");
        String documentation = "";
        ExtensionPointRef xp = new ExtensionPointRef(point, target);

        Node node = element.getFirstChild();
        while (node != null) {
            if (Node.ELEMENT_NODE == node.getNodeType()) {
                Element child = (Element) node;
                String tag = node.getNodeName().toLowerCase();
                if ("documentation".equals(tag)) {
                    documentation = getDocumentation(child);
                }
            }
            node = node.getNextSibling();
        }

        return new ExtensionModel(xp, documentation);
    }

    public String getDocumentation(Element element) {
        String content = toXML(element).trim();
        int len = "<documentation>".length();
        if (content.startsWith("<documentation>")) {
            content = content.substring(len);
        }
        if (content.endsWith("</documentation>")) {
            content = content.substring(0, content.length() - len - 1);
        }
        return content.trim();
    }

    public String toXML(Element element) {
        try {
            StringWriter writer = new StringWriter();
            writeElement(element, writer);
            return writer.toString();
        } catch (Throwable t) {
            return "";
        }
    }

    protected void writeElement(Element element, Writer writer)
            throws Exception {
        writeElement(element, writer, null);
    }

    protected void writeElement(Element element, Writer writer, String encoding)
            throws Exception {
        if (encoding == null) {
            encoding = "UTF-8";
        }
        // this is the single method I found it formats OK.
        OutputFormat format = new OutputFormat(Method.XML, encoding, true);
        format.setOmitDocumentType(true);
        format.setOmitXMLDeclaration(true);
        format.setIndent(2);
        XMLSerializer serializer = new XMLSerializer(writer, format);
        serializer.serialize(element);
        writer.flush();
    }

}
