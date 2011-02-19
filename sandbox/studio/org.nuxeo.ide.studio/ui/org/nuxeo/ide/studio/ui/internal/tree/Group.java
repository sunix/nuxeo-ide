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
import static org.nuxeo.ide.studio.ui.internal.tree.Constants.*;


/**
 * @author eugen
 *
 */
public class Group extends Tree{

    protected String name;

    protected boolean global;

    public boolean isGlobal() {
        return global;
    }

    public void setGlobal(boolean global) {
        this.global = global;
    }

    /**
     * @param id
     * @param type
     * @param label
     * @param url
     */
    public Group(String id, String label) {
        super(id, TYPE_GROUP, label, null);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean accept(String id){
        return id.equals(this.id);
    }

    @Override
    public String getIcon() {
        return "icons/type/"+id+".gif";
    }


}
