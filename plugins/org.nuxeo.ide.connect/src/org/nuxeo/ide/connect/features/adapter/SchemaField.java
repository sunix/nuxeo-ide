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
package org.nuxeo.ide.connect.features.adapter;

import java.util.HashMap;
import java.util.Map;

import org.nuxeo.ide.common.StringUtils;
import org.nuxeo.ide.connect.studio.DocumentSchema;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class SchemaField {

    public static final Map<String, String> JAVA_TYPES = new HashMap<String, String>();

    static {
        JAVA_TYPES.put("string", "String");
        JAVA_TYPES.put("integer", "Long");
        JAVA_TYPES.put("date", "Calendar");
        JAVA_TYPES.put("blob", "Blob");
    }

    protected String path;

    protected String type;

    protected boolean multivalue;

    protected String setter;

    protected String getter;

    public SchemaField(DocumentSchema ds, DocumentSchema.Field field) {
        String id = field.getId();
        multivalue = field.isMultivalue();
        path = ds.getPrefix() + ":" + id;
        type = JAVA_TYPES.get(field.getType());
        if (type == null) {
            type = "Object";
        }
        id = id.replace('/', '_');
        // replace '-' with camel case
        String[] ar = StringUtils.split(id, '-');
        if (ar.length > 1) {
            StringBuilder buf = new StringBuilder();
            for (int i = 0; i < ar.length; i++) {
                String a = ar[i];
                if (ar[i].length() == 0) {
                    continue;
                }
                buf.append(Character.toUpperCase(a.charAt(0))).append(
                        a.substring(1));
            }
            id = buf.toString();
        }

        if (multivalue) {
            if (field.hasChildren() || "Blob".equals(type)) {
                type = "List<" + type + ">";
            } else {
                type = type + "[]";
            }
        }

        String name = Character.toUpperCase(id.charAt(0)) + id.substring(1);
        setter = "set".concat(name);
        getter = "get".concat(name);
    }

    public boolean isMultivalue() {
        return multivalue;
    }

    public String getPath() {
        return path;
    }

    public String getType() {
        return type;
    }

    public String getSetter() {
        return setter;
    }

    public String getGetter() {
        return getter;
    }

    public String cast(String value) {
        if ("Blob".equals(type) || type.startsWith("List<")) {
            return "(Serializable)" + value;
        }
        return value;
    }
}
