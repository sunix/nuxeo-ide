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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.nuxeo.ide.common.IOUtils;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.nuxeo.ide.sdk.features.FeatureTemplateContext;
import org.nuxeo.ide.sdk.model.ExtensionModel;
import org.nuxeo.ide.sdk.templates.cmd.Command;
import org.osgi.framework.Bundle;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class FeatureTemplate extends Template {

    protected ManifestModification[] manifestModifs;

    protected String extensions;

    protected Dependency[] dependencies;

    public FeatureTemplate(String id) {
        super(id);
    }

    public void setManifestModifications(ManifestModification[] mf) {
        this.manifestModifs = mf;
    }

    /**
     * Return null if not manifest modifications are required.
     * 
     * @return
     */
    public ManifestModification[] getManifestModifications() {
        return manifestModifs;
    }

    public void setExtensions(String extensions) {
        this.extensions = extensions;
    }

    /**
     * Return null if no extensions are contributed
     * 
     * @return
     */
    public String getExtensions() {
        return extensions;
    }

    public void setDependencies(Dependency[] dependencies) {
        this.dependencies = dependencies;
    }

    /**
     * Return null if no pom dependencies are added
     * 
     * @return
     */
    public Dependency[] getDependencies() {
        return dependencies;
    }

    @Override
    protected void processCommands(Bundle bundle, TemplateContext ctx, File dir)
            throws Exception {
        super.processCommands(bundle, ctx, dir);
        applyExtensions(bundle, ctx, dir);
        applyManifestModifications(dir);
        applyDependencies(dir);
    }

    protected void applyManifestModifications(File dir) throws IOException {
        if (manifestModifs == null) {
            return;
        }
        File file = Util.getManifest(dir);
        InputStream in = new FileInputStream(file);
        boolean modified = false;
        Manifest mf = new Manifest(in);
        try {
            Attributes attrs = mf.getMainAttributes();
            for (ManifestModification mm : manifestModifs) {
                String v = attrs.getValue(mm.key);
                if (v == null) {
                    attrs.putValue(mm.key, mm.value);
                    modified = true;
                } else if (mm.overwrite) {
                    attrs.putValue(mm.key, mm.value);
                    modified = true;
                } else if (mm.append) { // append
                    if (!v.contains(mm.value)) {
                        attrs.putValue(mm.key, v + ", " + mm.value);
                        modified = true;
                    }
                } // else let it as is
            }
        } finally {
            in.close();
            if (modified) {
                FileOutputStream out = new FileOutputStream(file);
                try {
                    mf.write(out);
                } finally {
                    out.close();
                }
            }
        }
    }

    protected void applyExtensions(Bundle bundle, TemplateContext ctx, File dir)
            throws Exception {
        if (extensions == null) {
            return;
        }
        String className = ctx.getProperty(FeatureTemplateContext.CLASS_NAME);
        if (className == null) {
            return;
        }
        String packageName = ctx.getProperty(FeatureTemplateContext.PACKAGE_NAME);
        if (packageName == null) {
            return;
        }
        TemplateEngine engine = SDKPlugin.getDefault().getTemplateManager().getEngine();
        URL url = bundle.getEntry(extensions);
        if (url != null) {
            String content = IOUtils.read(url);
            content = engine.expandVars(ctx, content);
            new ExtensionModel(packageName + "." + className).setContent(dir,
                    content);
        }
    }

    protected void applyDependencies(File dir) throws IOException {
        // TODO
    }

    static class ManifestModification {
        String key;

        String value;

        boolean overwrite;

        boolean append;
    }

    static class Dependency {
        String groupId;

        String artifactId;

        String version;

        String scope;

        String type;
    }

    public static FeatureTemplate load(TemplateManager manager, Element element)
            throws Exception {
        FeatureTemplate temp = new FeatureTemplate(element.getAttribute("id"));
        Node child = element.getFirstChild();
        temp.src = Util.getAttribute(element, "src");
        List<ManifestModification> manifest = new ArrayList<FeatureTemplate.ManifestModification>();
        List<Dependency> deps = new ArrayList<Dependency>();
        while (child != null) {
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) child;
                String tag = child.getNodeName();
                if ("name".equals(tag)) {
                    temp.name = el.getTextContent().trim();
                } else if ("description".equals(tag)) {
                    temp.description = el.getTextContent().trim();
                } else if ("manifest".equals(tag)) {
                    ManifestModification mf = new ManifestModification();
                    mf.key = el.getAttribute("key");
                    mf.value = el.getAttribute("value");
                    mf.overwrite = Util.getBooleanAttribute(el, "overwrite",
                            false);
                    mf.append = Util.getBooleanAttribute(el, "append", false);
                    manifest.add(mf);
                } else if ("dependency".equals(tag)) {
                    Dependency dep = new Dependency();
                    dep.groupId = el.getAttribute("groupId");
                    dep.artifactId = el.getAttribute("artifactId");
                    dep.scope = Util.getAttribute(el, "scope");
                    dep.type = Util.getAttribute(el, "type");
                    dep.version = Util.getAttribute(el, "version");
                    deps.add(dep);
                } else if ("extension".equals(tag)) {
                    temp.extensions = el.getAttribute("src").trim();
                } else {
                    Command cmd = manager.getCommand(tag);
                    cmd.init(el);
                    temp.commands.add(cmd);
                }
            }
            child = child.getNextSibling();
        }
        if (!manifest.isEmpty()) {
            temp.manifestModifs = manifest.toArray(new ManifestModification[manifest.size()]);
        }
        if (!deps.isEmpty()) {
            temp.dependencies = deps.toArray(new Dependency[deps.size()]);
        }
        return temp;
    }
}
