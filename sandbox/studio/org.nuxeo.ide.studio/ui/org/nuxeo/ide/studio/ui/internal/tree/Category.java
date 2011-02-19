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
public class Category extends Tree {

    /**
     * @param id
     * @param type
     * @param label
     * @param url
     */
    public Category(String id, String label) {
        super(id, TYPE_CATEGORY, label, null);
    }

}
