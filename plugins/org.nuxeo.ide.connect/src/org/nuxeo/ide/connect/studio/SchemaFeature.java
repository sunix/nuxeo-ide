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
public class SchemaFeature extends StudioFeature {

    protected List<Field> fields;

    protected String prefix;

    public SchemaFeature(String type) {
        super(type);
        fields = new ArrayList<Field>();
    }

    public List<Field> getFields() {
        return fields;
    }

    public void addField(Field field) {
        fields.add(field);
    }

    public String gtPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public static class Field {
        protected String id;

        protected String type;

        protected boolean multivalue;

        protected String componentType;

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setMultivalue(boolean multivalue) {
            this.multivalue = multivalue;
        }

        public boolean isMultivalue() {
            return multivalue;
        }

        public void setComponentType(String componentType) {
            this.componentType = componentType;
        }

        public String getComponentType() {
            return componentType;
        }

        public boolean isList() {
            return "list".equals(type);
        }

        public boolean isBlob() {
            return "blob".equals(type);
        }
    }
}
