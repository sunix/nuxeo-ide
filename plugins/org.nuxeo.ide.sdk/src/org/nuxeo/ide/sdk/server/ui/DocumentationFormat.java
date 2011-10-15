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
package org.nuxeo.ide.sdk.server.ui;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.nuxeo.ide.sdk.model.XmlFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class DocumentationFormat {

    public static String format(String text) {
        if (text == null || text.length() == 0) {
            return "No documentation available";
        }
        try {
            return parse(text).toString();
        } catch (Exception e) {
            return text;
        }
    }

    public static Doc parse(String text) throws Exception {
        StringReader reader = new StringReader("<doc>" + text + "</doc>");
        InputSource is = new InputSource(reader);
        Document doc = XmlFile.factory.newDocumentBuilder().parse(is);
        Element root = doc.getDocumentElement();
        Doc result = new Doc();
        parseElement(root, result);
        return result;
    }

    public static boolean isParagraph(String tag) {
        return "p".equals(tag) || "ul".equals(tag) || "ol".equals(tag)
                || "div".equals(tag);
    }

    private static void parseElement(Element root, Doc doc) throws Exception {
        Node node = root.getFirstChild();
        StringBuilder text = null;
        while (node != null) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                if (text != null) {
                    doc.appendText(text.toString());
                    text = null;
                }
                String tag = node.getNodeName().toLowerCase();
                if ("code".equals(tag)) {
                    String code = dumpElement((Element) node);
                    doc.append(new Code(code));
                } else if (isParagraph(tag)) {
                    doc.append(new Paragraph());
                    parseElement((Element) node, doc);
                } else if ("li".equals(tag)) {
                    doc.appendListItem(((Element) node).getTextContent());
                } else {
                    parseElement((Element) node, doc);
                }
            } else if (node.getNodeType() == Node.TEXT_NODE) {
                if (text == null) {
                    text = new StringBuilder();
                }
                text.append(node.getNodeValue());
            }
            node = node.getNextSibling();
        }
        if (text != null) {
            doc.appendText(text.toString());
            text = null;
        }
    }

    private static String trimLines(String text, String indent) {
        text = text.trim();
        if (text.length() == 0) {
            return "";
        }
        try {
            StringBuilder result = new StringBuilder();
            BufferedReader reader = new BufferedReader(new StringReader(text));
            String line = reader.readLine();
            while (line != null) {
                line = line.trim();
                if (line.length() > 0) {
                    result.append(indent).append(line).append("\n");
                }
                line = reader.readLine();
            }
            return result.toString();
        } catch (Exception e) {
            return text;
        }
    }

    private static String dumpElement(Element parent) {
        StringBuilder result = new StringBuilder();
        dumpElement(parent, "", result);
        return result.toString();
    }

    private static void dumpElement(Element element, String indent,
            StringBuilder result) {
        result.append(indent).append("<").append(element.getNodeName());
        NamedNodeMap attrs = element.getAttributes();
        if (attrs != null && attrs.getLength() > 0) {
            for (int i = 0, len = attrs.getLength(); i < len; i++) {
                result.append(" ").append(attrs.item(i).getNodeName()).append(
                        "=\"").append(attrs.item(i).getNodeValue()).append("\"");
            }
        }
        StringBuilder textContent = new StringBuilder();
        StringBuilder structContent = new StringBuilder();
        Node node = element.getFirstChild();
        while (node != null) {
            int type = node.getNodeType();
            if (type == Node.ELEMENT_NODE) {
                dumpElement((Element) node, indent + "  ", structContent);
            } else if (type == Node.COMMENT_NODE) {
                structContent.append("<!--").append(getCommentContent(node)).append(
                        "-->\n");
            } else if (type == Node.TEXT_NODE) {
                textContent.append(node.getNodeValue());
            }
            node = node.getNextSibling();
        }

        String txt = textContent.toString().trim();
        if (structContent.length() > 0) {
            result.append(">\n");
            result.append(structContent);
            result.append(indent).append("</").append(element.getNodeName()).append(
                    ">\n");
        } else if (txt.length() > 0) {
            result.append(">").append(txt).append("</").append(
                    element.getNodeName()).append(">\n");
        } else {
            result.append("/>\n");
        }
    }

    private static String getCommentContent(Node node) {
        return node.getNodeValue().trim();
    }

    public static class Doc {
        protected List<Segment> segments;

        public Doc() {
            segments = new ArrayList<DocumentationFormat.Segment>();
        }

        public void append(Segment segment) {
            segments.add(segment);
        }

        private Paragraph getLastParagraph() {
            Paragraph para;
            if (segments.isEmpty()) {
                para = new Paragraph();
                segments.add(para);
            } else {
                Segment s = segments.get(segments.size() - 1);
                if (!(s instanceof Paragraph)) {
                    para = new Paragraph();
                    segments.add(para);
                } else {
                    para = (Paragraph) s;
                }
            }
            return para;
        }

        public void appendText(String text) {
            getLastParagraph().appendText(text);
        }

        public void appendListItem(String text) {
            getLastParagraph().appendListItem(text);
        }

        public List<Segment> getSegments() {
            return segments;
        }

        @Override
        public String toString() {
            StringBuilder buf = new StringBuilder();
            for (Segment seg : segments) {
                buf.append(seg.getText()).append("\n");
            }
            return buf.toString().trim();
        }
    }

    public static abstract class Segment {

        protected String tag;

        public Segment(String tag) {
            this.tag = tag;
        }

        public String getTag() {
            return tag;
        }

        public abstract String getText();

    }

    public static class Code extends Segment {

        protected String text;

        public Code(String code) {
            super("code");
            text = code;
        }

        @Override
        public String getText() {
            return text.endsWith("\n") ? text : text + "\n";
        }
    }

    public static class Paragraph extends Segment {

        protected List<Text> list;

        public Paragraph() {
            this("p");
        }

        public Paragraph(String tag) {
            super(tag);
            list = new ArrayList<DocumentationFormat.Text>();
        }

        @Override
        public String getText() {
            StringBuilder buf = new StringBuilder();
            for (Text text : list) {
                if (text.isItem()) {
                    String v = trimLines(text.getText().trim(), "    ");
                    char[] chars = v.toCharArray();
                    chars[2] = '*';
                    buf.append(chars);
                } else {
                    String v = text.getText().trim();
                    if (v.length() == 0) {
                        continue;
                    }
                    v = trimLines(v, "");
                    v = v.replaceAll("[ ]+", " ");
                    buf.append(v);
                }
            }
            return buf.toString();
        }

        public void appendText(String text) {
            if (list.isEmpty()) {
                list.add(new Text(text));
            } else {
                Text entry = list.get(list.size() - 1);
                if (entry.isItem()) {
                    list.add(new Text(text));
                } else {
                    entry.text += text;
                }
            }
        }

        public void appendListItem(String text) {
            list.add(new Text(text, true));
        }

        public List<Text> getList() {
            return list;
        }
    }

    public static class Text {
        protected String text;

        protected boolean isItem;

        public Text(String text) {
            this(text, false);
        }

        public Text(String text, boolean isItem) {
            this.text = text;
            this.isItem = isItem;
        }

        public String getText() {
            return text;
        }

        public boolean isItem() {
            return isItem;
        }
    }

}
