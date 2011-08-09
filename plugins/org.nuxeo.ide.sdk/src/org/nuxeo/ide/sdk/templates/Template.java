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
package org.nuxeo.ide.sdk.templates;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.nuxeo.ide.common.IOUtils;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.osgi.framework.Bundle;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class Template implements Comparable<Template> {

    protected String id;

    protected String name;

    protected String description;

    protected String src;

    protected Template(String id) {
        this.id = id;
        this.name = id;
    }

    public String getId() {
        return id;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getSrc() {
        return src;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return src;
    }

    public abstract void process(Bundle bundle, TemplateContext ctx, File dir)
            throws Exception;

    protected void expand(Bundle bundle, TemplateContext ctx, File dir)
            throws Exception {
        copyTo(bundle, dir);
        TemplateEngine engine = SDKPlugin.getDefault().getTemplateManager().getEngine();
        engine.expandVars(ctx, dir);
    }

    protected void copyTo(Bundle bundle, File dir) throws IOException {
        if (src.endsWith(".zip")) {
            URL url = bundle.getEntry(src);
            if (url == null) {
                throw new FileNotFoundException("Template " + name
                        + " not found in bundle " + bundle.getSymbolicName()
                        + " at " + src);
            }
            InputStream in = url.openStream();
            try {
                IOUtils.unzip(in, dir);
            } finally {
                in.close();
            }
        } else {
            File bundleFile = FileLocator.getBundleFile(bundle);
            if (bundleFile.isDirectory()) {
                IOUtils.copyTreeContent(new File(bundleFile, src), dir);
            } else {
                IOUtils.unzip(bundleFile, src, dir);
            }
        }
    }

    @Override
    public int compareTo(Template temp) {
        return name.compareTo(temp.name);
    }

    @Override
    public String toString() {
        return id + " [" + src + "]";
    }

}
