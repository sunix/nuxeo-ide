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
package org.nuxeo.ide.common.forms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class AbstractFormData implements FormData {

    protected abstract OutputStream getOutputStream(Form form)
            throws IOException;

    protected abstract InputStream getInputStream(Form form) throws IOException;

    protected InputStream getDefaultsInputStream(Form form) throws IOException {
        return form.getClass().getResourceAsStream(
                form.getClass().getSimpleName() + ".properties");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void load(Form form) throws IOException {
        Properties props = new Properties();
        InputStream in = null;
        try {
            in = getInputStream(form);
        } catch (IOException e) {
            try {
                in = getDefaultsInputStream(form);
            } catch (IOException ee) {
                in = null;
            }
        }
        if (in == null) {
            return;
        }
        try {
            props.load(in);
        } finally {
            in.close();
        }
        form.setValues((Map) props);
    }

    @Override
    public void store(Form form) throws IOException {
        Properties props = new Properties();
        for (Map.Entry<String, String> entry : form.getValues().entrySet()) {
            String v = entry.getValue();
            if (v != null) {
                props.put(entry.getKey(), v);
            }
        }
        OutputStream out = getOutputStream(form);
        try {
            props.store(out,
                    "This is a generated file. Modify it on your own risk.");
        } finally {
            out.close();
        }
    }

}
