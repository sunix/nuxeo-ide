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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class DocumentType implements StudioFeature, Comparable<DocumentType> {

    protected String id;

    protected List<String> schemas;

    protected List<String> facets;

    protected String lifeCycle;

    protected String label;

    public DocumentType() {
        facets = new ArrayList<String>();
        schemas = new ArrayList<String>();
    }

    @Override
    public String getType() {
        return "doc";
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
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

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void read(JsonParser jp) throws IOException {
        while (jp.nextToken() != JsonToken.END_OBJECT) {
            String key = jp.getCurrentName();
            jp.nextToken();
            if (key.equals("lifecycle")) {
                setLifeCycle(jp.getText());
            } else if (key.equals("label")) {
                setLabel(jp.getText());
            } else if (key.equals("facets")) {
                readFacets(jp);
            } else if (key.equals("schemas")) {
                readSchemas(jp);
            }
        }
    }

    protected void readFacets(JsonParser jp) throws IOException {
        while (jp.nextToken() != JsonToken.END_ARRAY) {
            addFacet(jp.getText());
        }
    }

    protected void readSchemas(JsonParser jp) throws IOException {
        while (jp.nextToken() != JsonToken.END_ARRAY) {
            addSchema(jp.getText());
        }
    }

	@Override
	public int compareTo(DocumentType o) {
        return id.compareTo(o.id);
	}

}
