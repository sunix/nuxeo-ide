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
package org.nuxeo.ide.studio.connector.internal;

import org.nuxeo.ide.studio.StudioFeatureType;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public class FeatureTypeBean implements StudioFeatureType {

    protected String id;
    protected String name;
    protected String label;
    protected boolean isGlobal;

    public FeatureTypeBean(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see org.nuxeo.ide.studio.connector.internal.StudioFeatureType#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see org.nuxeo.ide.studio.connector.internal.StudioFeatureType#getName()
     */
    @Override
    public String getName() {
        return name;
    }

    /* (non-Javadoc)
     * @see org.nuxeo.ide.studio.connector.internal.StudioFeatureType#getLabel()
     */
    @Override
    public String getLabel() {
        return label;
    }

    /* (non-Javadoc)
     * @see org.nuxeo.ide.studio.connector.internal.StudioFeatureType#isGlobal()
     */
    @Override
    public boolean isGlobal() {
        return isGlobal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setGlobal(boolean isGlobal) {
        this.isGlobal = isGlobal;
    }

}
