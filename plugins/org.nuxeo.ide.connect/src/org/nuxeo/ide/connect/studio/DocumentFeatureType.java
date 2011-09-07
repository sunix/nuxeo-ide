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

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class DocumentFeatureType extends StudioFeatureType<DocumentType> {

    public DocumentFeatureType() {
        super("doc");
    }

    @Override
    public DocumentType newFeature() {
        return new DocumentType();
    }

    @Override
    protected void readDataField(DocumentType feature, JsonParser jp)
            throws IOException {
        feature.read(jp);
    }

}
