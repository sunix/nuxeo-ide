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

import org.nuxeo.ide.sdk.templates.TemplateContext;
import org.nuxeo.ide.sdk.templates.Vars;
import org.osgi.framework.Bundle;
import org.w3c.dom.Element;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class RenameCommand implements Command {

    protected String path;

    protected String to;

    @Override
    public void init(Element element) {
        path = element.getAttribute("path");
        to = element.getAttribute("to");
        if (path.length() == 0 || to.length() == 0) {
            throw new IllegalArgumentException(
                    "The rename command expect the 'path' and 'to' attributes!");
        }
    }

    @Override
    public void execute(TemplateContext ctx, Bundle bundle, File projectDir)
            throws Exception {
        File srcFile = new File(projectDir, Vars.expand(path, ctx));
        File dstFile = new File(projectDir, Vars.expand(to, ctx));
        srcFile.renameTo(dstFile);
    }

}
