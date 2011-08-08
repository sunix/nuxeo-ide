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

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.nuxeo.ide.sdk.NuxeoSDK;
import org.osgi.framework.Bundle;

/**
 * Manage project templates.
 * 
 * At plugin start it loads project templates contributed by fragments.
 * <p>
 * Binds template registry to the corresponding target version.
 * <p>
 * TODO: track bundles to update the registry as new bundles are installed or
 * existing bundles are removed.
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class TemplateManager {

    public final static String ANY_VERSION = "0.0.0";

    protected Map<String, TemplateRegistry> regs;

    public TemplateManager() {
        regs = new HashMap<String, TemplateRegistry>();
    }

    public synchronized void addRegistry(String targetVersion,
            TemplateRegistry registry) {
        regs.put(targetVersion, registry);
    }

    public synchronized TemplateRegistry getRegistry(String targetVersion) {
        TemplateRegistry reg = regs.get(targetVersion);
        if (reg == null) {
            reg = regs.get(ANY_VERSION);
        }
        return reg;
    }

    public TemplateRegistry getDefaultRegistry() {
        NuxeoSDK sdk = NuxeoSDK.getDefault();
        if (sdk == null) {
            return null;
        }
        String v = sdk.getInfo().getVersion();
        if (v == null) {
            v = "0.0.0";
        } else if (v.endsWith("-SNAPSHOT")) {
            v = v.substring(0, v.length() - "-SNAPSHOT".length());
        }
        return getRegistry(v);
    }

    public Template getDefaultTemplate(String templateName) {
        TemplateRegistry reg = getDefaultRegistry();
        if (reg != null) {
            reg.getTemplate(templateName);
        }
        return null;
    }

    public void loadTemplates(Bundle bundle) {
        Bundle[] bundles = Platform.getFragments(bundle);
        if (bundles == null) {
            return;
        }
        for (Bundle fragment : bundles) {
            String expr = (String) fragment.getHeaders().get(
                    "Nuxeo-ProjectTemplates");
            if (expr != null) {
                String[] ar = expr.split("\\s*,\\s*");
                if (ar != null) {
                    String v = (String) fragment.getHeaders().get(
                            "Nuxeo-TargetVersion");
                    String[] versions = v == null ? new String[] { "0.0.0" }
                            : v.split("\\s*,\\s*");
                    TemplateRegistry reg = new TemplateRegistry();
                    for (int i = 0; i < ar.length; i++) {
                        try {
                            Template temp = Template.fromString(fragment, ar[i]);
                            reg.addTemplate(temp);
                        } catch (ParseException e) {
                            // ignore and log
                            System.err.println("Failed to parse template definition:"
                                    + e.getMessage());
                        }
                    }
                    synchronized (this) {
                        for (String version : versions) {
                            regs.put(version, reg);
                        }
                    }
                }
            }
        }
    }

}
