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
package org.nuxeo.ide.sdk.templates.cmd;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.nuxeo.ide.sdk.model.ManifestWriter;
import org.nuxeo.ide.sdk.templates.TemplateContext;
import org.nuxeo.ide.sdk.templates.Vars;
import org.osgi.framework.Bundle;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ManifestCommand implements Command {

    protected List<Modification> modifs;

    @Override
    public void init(Element element) {
        modifs = new ArrayList<ManifestCommand.Modification>();
        Node node = element.getFirstChild();
        while (node != null) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) node;
                String name = child.getNodeName();
                String key = child.getAttribute("key");
                String value = child.getAttribute("value");
                int type = -1;
                if ("append".equals(name)) {
                    type = Modification.APPEND;
                } else if ("replace".equals(name)) {
                    type = Modification.REPLACE;
                } else if ("delete".equals(name)) {
                    type = Modification.DELETE;
                    if (value.length() == 0) {
                        value = null;
                    }
                }
                if (type != -1) {
                    modifs.add(new Modification(type, key, value));
                }
            }
            node = node.getNextSibling();
        }
    }

    @Override
    public void execute(TemplateContext ctx, Bundle bundle, File projectDir)
            throws Exception {
        ManifestWriter writer = ManifestWriter.getWriter(projectDir);
        for (Modification modif : modifs) {
            switch (modif.type) {
            case Modification.APPEND:
                writer.appendEntry(Vars.expand(modif.key, ctx),
                        Vars.expand(modif.value, ctx));
                break;
            case Modification.REPLACE:
                writer.replaceEntry(Vars.expand(modif.key, ctx),
                        Vars.expand(modif.value, ctx));
                break;
            case Modification.DELETE:
                if (modif.value == null) {
                    writer.removeEntry(modif.key);
                } else {
                    writer.removeEntry(Vars.expand(modif.key, ctx),
                            Vars.expand(modif.value, ctx));
                }
                break;
            }
        }
        writer.write(new NullProgressMonitor());
    }

    static class Modification {
        public static final int APPEND = 0;

        public static final int REPLACE = 1;

        public static final int DELETE = 2;

        protected int type;

        protected String key;

        protected String value;

        public Modification(int type, String key, String value) {
            this.type = type;
            this.key = key;
            this.value = value;
        }
    }

}
