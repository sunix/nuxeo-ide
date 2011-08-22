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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class PomModel extends XmlFile {

    public static PomModel getPomModel(IProject project) throws Exception {
        IFile file = project.getFile("pom.xml");
        if (!file.exists()) {
            Document doc = factory.newDocumentBuilder().newDocument();
            Element root = doc.createElement("project");
            doc.appendChild(root);
            Element version = doc.createElement("modelVersion");
            version.setTextContent("4.0.0");
            root.appendChild(version);
            return new PomModel(doc);
        } else {
            return new PomModel(file.getContents(true));
        }
    }

    public PomModel(Document doc) {
        super(doc);
    }

    public PomModel(InputStream in) throws Exception {
        super(in);
    }

    public Element getDependenciesElement() {
        Element dep = getFirstElement("dependencies");
        if (dep == null) {
            dep = (Element) doc.getDocumentElement().appendChild(
                    doc.createElement("dependencies"));
        }
        return dep;
    }

    public Element getParentElement() {
        return getFirstElement("parent");
    }

    public String getGroupId() {
        Element g = getFirstElement("groupId");
        if (g == null) {
            Element pe = getParentElement();
            if (pe != null) {
                g = getFirstElement(pe, "groupId");
                if (g != null) {
                    return g.getTextContent().trim();
                }
            }
        } else {
            return g.getTextContent().trim();
        }
        return null;
    }

    public String getArtifactVersion() {
        Element g = getFirstElement("version");
        if (g == null) {
            Element pe = getParentElement();
            if (pe != null) {
                g = getFirstElement(pe, "version");
                if (g != null) {
                    return g.getTextContent().trim();
                }
            }
        } else {
            return g.getTextContent().trim();
        }
        return null;
    }

    public String getArtifactId() {
        Element e = getFirstElement("artifactId");
        if (e != null) {
            return e.getTextContent().trim();
        }
        return null;
    }

    public List<Artifact> getDependencies() {
        ArrayList<Artifact> artifacts = new ArrayList<Artifact>();
        Element root = getDependenciesElement();
        Node node = root.getFirstChild();
        while (node != null) {
            if (node.getNodeType() == Node.ELEMENT_NODE
                    && node.getNodeName().equals("dependency")) {
                Element dep = (Element) node;
                Artifact artifact = readDependency(dep);
                artifacts.add(artifact);
            }
            node = node.getNextSibling();
        }
        return artifacts;
    }

    protected Artifact readDependency(Element element) {
        String groupId = null;
        String artifactId = null;
        String version = null;
        String scope = null;
        Node node = element.getFirstChild();
        while (node != null) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                String name = node.getNodeName();
                Element el = (Element) node;
                if (name.equals("groupId")) {
                    groupId = el.getTextContent();
                } else if (name.equals("artifactId")) {
                    artifactId = el.getTextContent();
                } else if (name.equals("version")) {
                    version = el.getTextContent();
                } else if (name.equals("scope")) {
                    scope = el.getTextContent();
                }
            }
            node = node.getNextSibling();
        }
        Artifact artifact = new Artifact(groupId, artifactId);
        artifact.setVersion(version);
        artifact.setScope(scope);
        return artifact;
    }

    public void addDependency(Artifact artifact) {
        Element deps = getDependenciesElement();
        Element el = doc.createElement("dependency");
        deps.appendChild(el);
        Element child = doc.createElement("groupId");
        child.setTextContent(artifact.getGroupId());
        el.appendChild(child);
        child = doc.createElement("artifactId");
        child.setTextContent(artifact.getArtifactId());
        el.appendChild(child);
        if (artifact.getVersion() != null) {
            child = doc.createElement("version");
            child.setTextContent(artifact.getVersion());
        }
        if (artifact.getScope() != null) {
            child = doc.createElement("scope");
            child.setTextContent(artifact.getScope());
        }
    }
}
