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
package org.nuxeo.ide.sdk.projects.webengine;

import org.eclipse.swt.widgets.Composite;
import org.nuxeo.ide.sdk.projects.NuxeoProjectPage1;
import org.nuxeo.ide.sdk.projects.ProjectTemplateContext;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class Page1 extends NuxeoProjectPage1 {

    public Page1() {
        super("we1", "Create WebEngine Project", null);
    }

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
    }

    @Override
    public void update(ProjectTemplateContext ctx) {
        super.update(ctx);
        // let the app name to inherit from root class name
        // this way we have a simpler form
        ctx.setProperty(form, "className", "appName");
        // ctx.setPropertyIfNotNull(form, "appName");
        String rootPath = form.getWidgetValueAsString("rootPath");
        if (!rootPath.startsWith("/")) {
            // a bug in webengine generate a broken link to the module if the
            // rootPath is not starting with /
            rootPath = "/" + rootPath;
        }
        ctx.put("rootPath", rootPath);
        ctx.setPropertyIfNotNull(form, "base");
    }

}
