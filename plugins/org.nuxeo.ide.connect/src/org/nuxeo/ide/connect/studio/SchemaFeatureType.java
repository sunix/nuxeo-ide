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
public class SchemaFeatureType extends StudioFeatureType<SchemaFeature> {

    public SchemaFeatureType() {
        super("ds");
    }

    @Override
    public SchemaFeature newFeature() {
        return new SchemaFeature(getId());
    }

    @Override
    protected void readDataField(SchemaFeature feature, JsonParser jp)
            throws IOException {
        while (jp.nextToken() != JsonToken.END_OBJECT) {
            String key = jp.getCurrentName();
            jp.nextToken();
            if (key.equals("prefix")) {
                feature.setPrefix(jp.getText());
            } else if (key.equals("fields")) {
                readFields(feature, jp);
            }
        }
    }

    protected void readFields(SchemaFeature feature, JsonParser jp)
            throws IOException {
        while (jp.nextToken() != JsonToken.END_ARRAY) {
            feature.addField(readField(jp));
        }
    }

    protected SchemaFeature.Field readField(JsonParser jp) throws IOException {
        SchemaFeature.Field field = new SchemaFeature.Field();
        while (jp.nextToken() != JsonToken.END_OBJECT) {
            String key = jp.getCurrentName();
            jp.nextToken();
            if (key.equals("id")) {
                field.setId(jp.getText());
            } else if (key.equals("type")) {
                field.setType(jp.getText());
            } else if (key.equals("componentType")) {
                field.setComponentType(jp.getText());
            } else if (key.equals("multivalue")) {
                field.setMultivalue(jp.getBooleanValue());
            }
        }
        return field;
    }

}
