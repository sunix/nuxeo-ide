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
package org.nuxeo.ide.common.forms;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.w3c.dom.Element;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class LayoutManager {

    protected String id;

    public LayoutManager(String id) {
        this.id = id;
    }

    /**
     * Get the layout id (as used in XML descriptors).
     * 
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Create the layout object for a composite widget
     * 
     * @param element
     * @return
     */
    public abstract Layout getLayout(Element element);

    /**
     * Apply layout data for the given child control of the composite which is
     * using this layout.
     * 
     * @param ctrl
     * @param element
     */
    public abstract void applyLayout(Control ctrl, Element element);

}
