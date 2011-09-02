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
package org.nuxeo.ide.connect.studio;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class DocumentFeature extends StudioFeature {

    protected List<String> schemas;

    protected List<String> facets;

    protected String lifeCycle;

    public DocumentFeature(String type) {
        super(type);
        facets = new ArrayList<String>();
        schemas = new ArrayList<String>();
    }

    public List<String> getSchemas() {
        return schemas;
    }

    public void addSchema(String schema) {
        this.schemas.add(schema);
    }

    public List<String> getFacets() {
        return facets;
    }

    public void addFacet(String facet) {
        facets.add(facet);
    }

    public String getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(String lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

}
