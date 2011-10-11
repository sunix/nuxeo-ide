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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.nuxeo.ide.sdk.templates.TemplateContext;
import org.nuxeo.ide.sdk.templates.Vars;
import org.w3c.dom.Element;

/**
 * A resource to select after the wizard finished.
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class SelectCommand implements PostCreateCommand {

    protected String path;

    @Override
    public void init(Element element) {
        path = element.getAttribute("path");
    }

    @Override
    public void execute(IProject project, TemplateContext ctx) throws Exception {
        String path = Vars.expand(this.path, ctx);
        if (path != null) {
            IResource r = project.findMember(new Path(path));
            if (r != null) {
                selectAndReveal(r);
                return;
            }
        }
        selectAndReveal(project);
    }

    public static void selectAndReveal(final IResource newResource) {
        selectAndReveal(newResource, true);
    }

    public static void selectAndReveal(final IResource newResource,
            final boolean open) {
        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                BasicNewResourceWizard.selectAndReveal(newResource,
                        PlatformUI.getWorkbench().getActiveWorkbenchWindow());
                if (open && (newResource instanceof IFile)) {
                    try {
                        IDE.openEditor(
                                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),
                                (IFile) newResource);
                        // } else if (r instanceof IContainer) {
                        // // DO nothing.. expand the container in the tree?
                    } catch (Exception e) {
                        // do nothing
                    }
                }
            }
        });
    }
}
