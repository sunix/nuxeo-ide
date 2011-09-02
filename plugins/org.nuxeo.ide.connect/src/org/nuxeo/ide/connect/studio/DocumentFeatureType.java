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

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class DocumentFeatureType extends StudioFeatureType<DocumentFeature> {

    public DocumentFeatureType() {
        super("doc");
    }

    @Override
    public DocumentFeature newFeature() {
        return new DocumentFeature(getId());
    }

    @Override
    protected void readDataField(DocumentFeature feature, JsonParser jp)
            throws IOException {
        while (jp.nextToken() != JsonToken.END_OBJECT) {
            String key = jp.getCurrentName();
            jp.nextToken();
            if (key.equals("lifecycle")) {
                feature.setLifeCycle(jp.getText());
            } else if (key.equals("facets")) {
                readFacets(feature, jp);
            } else if (key.equals("schemas")) {
                readSchemas(feature, jp);
            }
        }
    }

    protected void readFacets(DocumentFeature feature, JsonParser jp)
            throws IOException {
        while (jp.nextToken() != JsonToken.END_ARRAY) {
            feature.addFacet(jp.getText());
        }
    }

    protected void readSchemas(DocumentFeature feature, JsonParser jp)
            throws IOException {
        while (jp.nextToken() != JsonToken.END_ARRAY) {
            feature.addSchema(jp.getText());
        }
    }

}
