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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.actions.OrganizeImportsAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.nuxeo.ide.sdk.templates.TemplateContext;
import org.nuxeo.ide.sdk.templates.Vars;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class OrganizeImportsCommand implements PostCreateCommand {

    List<String> paths;

    @Override
    public void init(Element element) {
        paths = new ArrayList<String>();
        Node node = element.getFirstChild();
        while (node != null) {
            if (node.getNodeType() == Node.ELEMENT_NODE
                    && "class".equals(node.getNodeName())) {
                paths.add(((Element) node).getAttribute("path"));
            }
            node = node.getNextSibling();
        }
    }

    @Override
    public void execute(IProject project, TemplateContext ctx) throws Exception {
        Object[] elements = null;
        IJavaProject jproject = JavaCore.create(project);
        if (paths.isEmpty()) {
            elements = new Object[] { jproject };
        } else {
            ArrayList<Object> result = new ArrayList<Object>();
            for (String path : paths) {
                path = Vars.expand(path, ctx);
                IResource resource = project.findMember(path);
                if (resource != null && resource.exists()) {
                    result.add(JavaCore.create(resource));
                }
            }
            elements = result.toArray();
        }
        if (elements != null && elements.length > 0) {
            StructuredSelection selection = new StructuredSelection(
                    (Object[]) elements);
            try {
                new OrganizeImportsAction(new FakeSite(selection)).run(selection);
            } catch (Throwable t) {
                SDKPlugin.log(IStatus.ERROR,
                        "Failed to run organize imports comnad", t);
            }
        }
    }

    public static class FakeSite implements IWorkbenchSite, ISelectionProvider {

        protected ISelection selection = StructuredSelection.EMPTY;

        public FakeSite() {
        }

        public FakeSite(ISelection selection) {
            this.selection = selection;
        }

        @SuppressWarnings("rawtypes")
        @Override
        public Object getAdapter(Class adapter) {
            return null;
        }

        @SuppressWarnings("rawtypes")
        @Override
        public Object getService(Class api) {
            return null;
        }

        @SuppressWarnings("rawtypes")
        @Override
        public boolean hasService(Class api) {
            return false;
        }

        @Override
        public IWorkbenchPage getPage() {
            return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        }

        @Override
        public ISelectionProvider getSelectionProvider() {
            return null;
        }

        @Override
        public Shell getShell() {
            return Display.getDefault().getActiveShell();
        }

        @Override
        public IWorkbenchWindow getWorkbenchWindow() {
            return PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        }

        @Override
        public void setSelectionProvider(ISelectionProvider provider) {
            // do nothing
        }

        @Override
        public void addSelectionChangedListener(
                ISelectionChangedListener listener) {
            // do nothing
        }

        @Override
        public void removeSelectionChangedListener(
                ISelectionChangedListener listener) {
            // do nothing
        }

        @Override
        public ISelection getSelection() {
            return selection;
        }

        public void setSelection(ISelection selection) {
            this.selection = selection;
        }

    }
}
