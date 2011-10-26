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

import org.eclipse.core.resources.IProject;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.nuxeo.ide.sdk.templates.Template;
import org.nuxeo.ide.sdk.templates.TemplateContext;
import org.nuxeo.ide.sdk.templates.TemplateManager;
import org.osgi.framework.Bundle;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class IfCommand implements Command, PostCreateCommand {

    protected List<Command> cmds;

    protected List<PostCreateCommand> postCmds;

    protected String condition;

    @Override
    public void init(Element element) {
        condition = element.getAttribute("isSet");
        if (condition.length() == 0) {
            throw new IllegalArgumentException(
                    "IF command expect a 'isSet' attribute");
        }
        cmds = new ArrayList<Command>();
        postCmds = new ArrayList<PostCreateCommand>();
        TemplateManager manager = SDKPlugin.getDefault().getTemplateManager();
        Node child = element.getFirstChild();
        while (child != null) {
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) child;
                String tag = child.getNodeName();
                try {
                    Template.loadCommand(manager, cmds, postCmds, el, tag);
                } catch (Exception e) {
                    throw new IllegalArgumentException("Cannot load command: "
                            + tag);
                }
            }
            child = child.getNextSibling();
        }
    }

    @Override
    public void execute(IProject project, TemplateContext ctx) throws Exception {
        boolean isSet = ctx.containsKey(condition);
        if (isSet) {
            for (PostCreateCommand cmd : postCmds) {
                cmd.execute(project, ctx);
            }
        }
    }

    @Override
    public void execute(TemplateContext ctx, Bundle bundle, File projectDir)
            throws Exception {
        boolean isSet = ctx.containsKey(condition);
        if (isSet) {
            for (Command cmd : cmds) {
                cmd.execute(ctx, bundle, projectDir);
            }
        }
    }

}
