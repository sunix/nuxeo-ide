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

import java.util.ArrayList;
import java.util.List;

/**
 * @author eugen
 *
 */
public class VirtualGroup extends Group{

    protected List<String> subgroups = new ArrayList<String>();

    public VirtualGroup(String id) {
        super(id, id);
    }

    public List<String> getSubgroups() {
        return subgroups;
    }

    @Override
    public boolean accept(String id) {
        return subgroups.contains(id);
    }

}
