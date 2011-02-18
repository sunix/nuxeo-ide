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
package org.nuxeo.ide.studio.data.model;
import org.nuxeo.ide.studio.data.NodeImpl;

/**
 * @author eugen
 *
 */
public class Feature extends NodeImpl{

    /**
     * @param id
     * @param type
     * @param label
     * @param url
     */
    public Feature(String id, String type, String url) {
        super(id, type, id, url);
    }

    @Override
    public String getIcon() {
        return "icons/obj/"+type+".gif";
    }
}
