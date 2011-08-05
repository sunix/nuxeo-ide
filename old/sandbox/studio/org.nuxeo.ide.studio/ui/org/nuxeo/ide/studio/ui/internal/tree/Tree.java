/*
 * (C) Copyright 2011 Nuxeo SA (http://nuxeo.com/) and contributors.
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
 *     eugen
 */
package org.nuxeo.ide.studio.ui.internal.tree;

import java.util.ArrayList;
import java.util.List;


/**
 * @author eugen
 *
 */
public class Tree extends Node {

    /**
     * @param id
     * @param type
     * @param label
     * @param url
     */
    public Tree(String id, String type, String label, String url) {
        super(id, type, label, url);
    }

    List<Node> list = new ArrayList<Node>();

    public List<Node> getChildren() {
        return list;
    }

    public String getIcon() {
        return null;
    }

}
