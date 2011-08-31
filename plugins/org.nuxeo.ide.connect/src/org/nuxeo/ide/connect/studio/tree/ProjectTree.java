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
package org.nuxeo.ide.connect.studio.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nuxeo.ide.connect.studio.StudioFeature;
import org.nuxeo.ide.connect.studio.StudioProject;
import org.nuxeo.ide.connect.studio.StudioProject.TypeDescriptor;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ProjectTree {

    protected StudioProject project;

    // protected Map<IPath, StudioItem> items;

    protected List<Node<?>> roots;

    public ProjectTree(StudioProject project) {
        this.project = project;
        // items = new HashMap<IPath, StudioItem>();
        roots = new ArrayList<Node<?>>();

        buildTree();
    }

    private ParentNode<?> getUnknownGroup(Map<String, ParentNode<?>> groups) {
        ParentNode<?> parent = groups.get("*");
        if (parent == null) {
            parent = new CategoryNode("*", "Unknown");
            roots.add(parent);
            groups.put(parent.getId(), parent);
        }
        return parent;
    }

    public void buildTree() {
        Map<String, ParentNode<?>> groups = new HashMap<String, ParentNode<?>>();
        for (Map.Entry<String, String> entry : project.getCategories().entrySet()) {
            String catId = entry.getKey();
            if (catId.equals("resources")) {
                continue; // ignore resources entry for now
            }
            String catLabel = entry.getValue();
            ParentNode<?> group = new CategoryNode(catId, catLabel);
            roots.add(group);
            groups.put(group.getId(), group);
        }
        for (TypeDescriptor td : project.getTypeDescriptors().values()) {
            ParentNode<?> group = new TypeNode(td);
            if (td.category == null) {
                roots.add(group);
            } else {
                ParentNode<?> parent = groups.get(td.category);
                if (parent == null) {
                    // should not happen
                    parent = getUnknownGroup(groups);
                }
                parent.add(group);
            }
            groups.put(group.getId(), group);
        }
        for (StudioFeature feature : project.getFeatures()) {
            String type = feature.getType();
            ParentNode<?> parent = groups.get(feature.getType());
            if (parent == null) { // should never happens
                parent = getUnknownGroup(groups);
            }
            TypeDescriptor td = project.getTypeDescriptor(type);
            if (td == null || !td.global) {
                parent.add(new FeatureNode(feature));
            }
        }
    }

    public Node<?>[] getRoots() {
        return roots.toArray(new Node[roots.size()]);
    }

}
