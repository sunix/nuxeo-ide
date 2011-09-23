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
package org.nuxeo.ide.sdk.templates.cmd;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.nuxeo.ide.sdk.model.Artifact;
import org.nuxeo.ide.sdk.model.PomModel;
import org.nuxeo.ide.sdk.templates.TemplateContext;
import org.osgi.framework.Bundle;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * A resource to select after the wizard finished.
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class DependenciesCommand implements Command {

    protected Set<Artifact> artifacts;

    @Override
    public void init(Element element) {
        artifacts = new HashSet<Artifact>();

        Node node = element.getFirstChild();
        while (node != null) {
            if (node.getNodeType() == Node.ELEMENT_NODE
                    && node.getNodeName().equals("dependency")) {
                artifacts.add(getArtifact((Element) node));
            }
            node = node.getNextSibling();
        }
    }

    protected Artifact getArtifact(Element element) {
        String groupId = element.getAttribute("groupId");
        if (groupId.length() == 0) {
            throw new IllegalArgumentException(
                    "The select command expect the 'groupId' attribute!");
        }
        String artifactId = element.getAttribute("artifactId");
        if (artifactId.length() == 0) {
            throw new IllegalArgumentException(
                    "The select command expect the 'artifactId' attribute!");
        }
        Artifact artifact = new Artifact(groupId, artifactId);
        String version = element.getAttribute("version");
        if (version.length() > 0) {
            artifact.setVersion(version);
        }
        String scope = element.getAttribute("scope");
        if (scope.length() > 0) {
            artifact.setScope(scope);
        }
        return artifact;
    }

    @Override
    public void execute(TemplateContext ctx, Bundle bundle, File projectDir)
            throws Exception {
        if (artifacts.isEmpty()) {
            return;
        }
        File pomFile = new File(projectDir, "pom.xml");
        PomModel pom = new PomModel(pomFile);
        for (Artifact a : pom.getDependencies()) {
            if (artifacts.contains(a)) {
                artifacts.remove(a);
            }
        }
        for (Artifact artifact : artifacts) {
            pom.addDependency(artifact);
        }
        pom.write(pomFile);
    }

}
