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
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

/**
 * Acts as a factory of feature of same type.
 * 
 * Subclasses must override the {@link #newFeature()} method.
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StudioFeatureType<T extends StudioFeature> {

    protected static Map<String, StudioFeatureType<?>> types = new HashMap<String, StudioFeatureType<?>>();

    static {
        addType(new DocumentFeatureType());
        addType(new SchemaFeatureType());
    }

    public static Map<String, StudioFeatureType<?>> getTypes() {
        return types;
    }

    public static StudioFeatureType<?> getType(String type) {
        StudioFeatureType<?> ft = types.get(type);
        if (ft == null) {
            ft = new StudioFeatureType<StudioFeature>(type);
            types.put(type, ft); // TODO synchronize
        }

        return ft;
    }

    public static void addType(StudioFeatureType<?> type) {
        types.put(type.getId(), type);
    }

    protected String id; // the type id

    public StudioFeatureType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @SuppressWarnings("unchecked")
    public T newFeature() {
        return (T) new DefaultStudioFeature(getId());
    }

    public T newFeature(JsonParser jp) throws IOException {
        T feature = newFeature();

        while (jp.nextToken() != JsonToken.END_OBJECT) {
            String key = jp.getCurrentName();
            jp.nextValue();
            if (key.equals("id")) {
                feature.setId(jp.getText());
            } else if ("data".equals(key)) {
                readDataField(feature, jp);
            }
        }

        if (feature.getId() == null) {
            throw new IOException(
                    "Invalid feature JSON format. Expecting 'id' attribute");
        }

        return feature;
    }

    public static StudioFeature readFeature(JsonParser jp) throws IOException {
        if (jp.getCurrentToken() != JsonToken.START_OBJECT) {
            throw new IOException(
                    "Invalid JSON feature. Expecting feature object start");
        }

        jp.nextToken(); // skip to type
        if (!"type".equals(jp.getCurrentName())) {
            throw new IOException(
                    "Invalid feature JSON format. Expectinh 'type' at the begining of the object");
        }

        jp.nextToken();
        String type = jp.getText();

        // lookup type
        StudioFeatureType<? extends StudioFeature> ft = getType(type);
        return ft.newFeature(jp);
    }

    protected void readDataField(T feature, JsonParser jp) throws IOException {
        // by default consume the object
        int i = 0;
        while (true) {
            JsonToken token = jp.nextToken();
            if (token == JsonToken.START_OBJECT) {
                i++;
            } else if (token == JsonToken.END_OBJECT) {
                if (i == 0) {
                    return;
                }
                i--;
            }
        }
    }

}
