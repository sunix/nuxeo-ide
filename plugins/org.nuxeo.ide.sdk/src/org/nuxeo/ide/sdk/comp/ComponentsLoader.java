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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.nuxeo.ide.sdk.model.XmlFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ComponentsLoader {

    public static ServerComponentProvider load(File file) {
        ServerComponentProvider provider = new ServerComponentProvider();
        if (!file.isFile()) {
            return provider;
        }

        try {
            ComponentRegistry reg = new ComponentRegistry();
            HashSet<String> cset = new HashSet<String>();
            HashSet<String> sset = new HashSet<String>();
            HashSet<String> xpset = new HashSet<String>();
            Document doc = XmlFile.factory.newDocumentBuilder().parse(file);
            Element root = doc.getDocumentElement();
            Node node = root.getFirstChild();
            while (node != null) {
                if (node.getNodeType() == Node.ELEMENT_NODE
                        && "component".equals(node.getNodeName())) {
                    loadComponent(reg, (Element) node, cset, sset, xpset);
                }
                node = node.getNextSibling();
            }

            provider.registry = reg;
            provider.components = cset.toArray(new String[cset.size()]);
            provider.services = sset.toArray(new String[sset.size()]);
            provider.xpoints = xpset.toArray(new String[xpset.size()]);

            Arrays.sort(provider.components);
            Arrays.sort(provider.services);
            Arrays.sort(provider.xpoints);

            return provider;
        } catch (Throwable t) {
            SDKPlugin.log(IStatus.ERROR,
                    "Failed to load components from server", t);
            return provider;
        }

    }

    protected static void loadComponent(ComponentRegistry reg, Element element,
            Set<String> cset, Set<String> sset, Set<String> xpset) {
        String name = element.getAttribute("name");
        cset.add(name);
        ComponentModel component = new ComponentModel(name);
        component.bundle = element.getAttribute("bundle");
        component.version = element.getAttribute("version");
        component.impl = element.getAttribute("class");

        Node node = element.getFirstChild();
        while (node != null) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                String tag = node.getNodeName();
                if ("documentation".equals(tag)) {
                    component.documentation = ((Element) node).getTextContent().trim();
                } else if ("services".equals(tag)) {
                    loadServices(reg, component, (Element) node, sset);
                } else if ("extension-points".equals(tag)) {
                    loadExtensionPoints(reg, component, (Element) node, xpset);
                }
            }
            node = node.getNextSibling();
        }

        if (component.services == null) {
            component.services = ComponentModel.EMPTY_SERVICES;
        }
        if (component.xpoints == null) {
            component.xpoints = ComponentModel.EMPTY_XPOINTS;
        }
        reg.getComponentsList().add(component);
    }

    protected static void loadServices(ComponentRegistry reg,
            ComponentModel component, Element element, Set<String> services) {
        Node node = element.getFirstChild();
        ArrayList<ServiceModel> list = new ArrayList<ServiceModel>();
        while (node != null) {
            if (node.getNodeType() == Node.ELEMENT_NODE
                    && "service".equals(node.getNodeName())) {
                String name = ((Element) node).getAttribute("class");
                services.add(name);
                ServiceModel svc = new ServiceModel(component, name);
                list.add(svc);
                reg.getServiceList().add(svc);
            }
            node = node.getNextSibling();
        }
        component.services = list.toArray(new ServiceModel[list.size()]);
    }

    protected static void loadExtensionPoints(ComponentRegistry reg,
            ComponentModel component, Element element, Set<String> xpoints) {
        Node node = element.getFirstChild();
        ArrayList<ExtensionPointModel> list = new ArrayList<ExtensionPointModel>();
        while (node != null) {
            if (node.getNodeType() == Node.ELEMENT_NODE
                    && "extension-point".equals(node.getNodeName())) {
                Element el = (Element) node;
                String name = el.getAttribute("name");
                String documentation = el.getTextContent().trim();
                xpoints.add(name);
                ExtensionPointModel xp = new ExtensionPointModel(component,
                        name, documentation);
                list.add(xp);
                reg.getExtensionPointList().add(xp);
            }
            node = node.getNextSibling();
        }
        component.xpoints = list.toArray(new ExtensionPointModel[list.size()]);
    }

}
