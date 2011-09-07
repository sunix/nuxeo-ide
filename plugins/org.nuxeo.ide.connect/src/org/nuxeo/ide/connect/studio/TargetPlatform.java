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
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class TargetPlatform {

    protected Map<String, DocumentType> doctypes;

    protected Map<String, DocumentSchema> schemas;

    public TargetPlatform() {
        doctypes = new HashMap<String, DocumentType>();
        schemas = new HashMap<String, DocumentSchema>();
    }

    public Map<String, DocumentType> getDoctypes() {
        return doctypes;
    }

    public Map<String, DocumentSchema> getSchemas() {
        return schemas;
    }

    public void read(JsonParser jp) throws IOException {
        // the start object was read
        while (jp.nextToken() != JsonToken.END_OBJECT) {
            String key = jp.getCurrentName();
            jp.nextToken();
            if (key.equals("doctypes")) {
                readDoctypes(jp);
            } else if (key.equals("schemas")) {
                readSchemas(jp);
            }
        }
    }

    public void readDoctypes(JsonParser jp) throws IOException {
        while (jp.nextToken() != JsonToken.END_OBJECT) {
            String key = jp.getCurrentName();
            jp.nextToken();
            DocumentType doc = new DocumentType();
            doc.setId(key);
            doc.read(jp);
            doctypes.put(key, doc);
        }
    }

    public void readSchemas(JsonParser jp) throws IOException {
        while (jp.nextToken() != JsonToken.END_OBJECT) {
            String key = jp.getCurrentName();
            jp.nextToken();
            DocumentSchema ds = new DocumentSchema();
            ds.setId(key);
            ds.read(jp);
            schemas.put(key, ds);
        }
    }

}
