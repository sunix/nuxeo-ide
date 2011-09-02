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
package org.nuxeo.ide.connect.studio;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorPart;
import org.nuxeo.ide.common.UI;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class AbstractFileEditor extends EditorPart {

    protected long lastModification = 0;

    protected ActivationListener activationListener;

    @Override
    public void init(IEditorSite site, IEditorInput input)
            throws PartInitException {
        setSite(site);
        setInput(input);
        activationListener = new ActivationListener(
                site.getWorkbenchWindow().getPartService());
    }

    @Override
    protected void setInput(IEditorInput input) {
        super.setInput(input);
        lastModification = ((IFile) input.getAdapter(IFile.class)).getModificationStamp();
    }

    @Override
    protected void setInputWithNotify(IEditorInput input) {
        super.setInputWithNotify(input);
        lastModification = ((IFile) input.getAdapter(IFile.class)).getModificationStamp();
    }

    public long getLastModification() {
        return lastModification;
    }

    @Override
    public void dispose() {
        super.dispose();
        if (activationListener != null) {
            activationListener.dispose();
            activationListener = null;
        }
    }

    protected void close() {
        IWorkbenchPage page = getSite().getPage();
        page.activate(this);
        page.closeEditor(this, false);
    }

    protected long computeModificationStamp(IResource resource) {
        long modificationStamp = resource.getModificationStamp();

        IPath path = resource.getLocation();
        if (path == null)
            return modificationStamp;

        modificationStamp = path.toFile().lastModified();
        return modificationStamp;
    }

    protected void handleActivation() {
        try {
            IFile file = (IFile) getEditorInput().getAdapter(IFile.class);
            if (!file.isSynchronized(IResource.DEPTH_ZERO)) {
                handleInputDesynchronized(file);
            } else if (!file.exists()) {
                handleInputDeleted(file);
            } else if (computeModificationStamp(file) > lastModification) {
                handleInputChanged(file);
            }
        } catch (Exception e) {
            e.printStackTrace(); // TODO
            UI.showError("Failed to check editor input state", e);
        }
    }

    protected void handleInputDesynchronized(IFile file) throws Exception {
        if (Window.OK == UI.showPrompt("The editor input is desynchronized with the file system. Do you want to refresh the editor?")) {
            file.refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor());
        }
    }

    protected void handleInputChanged(IFile file) throws Exception {
        // TODO
    }

    protected void handleInputDeleted(IFile file) throws Exception {
        if (Window.OK == UI.showPrompt("The editor input was removed. Do you want to close the editor?")) {
            close();
        }
    }

    class ActivationListener implements IPartListener, IWindowListener {

        protected IPartService partService;

        public ActivationListener(IPartService partService) {
            this.partService = partService;
            partService.addPartListener(this);
            PlatformUI.getWorkbench().addWindowListener(this);
        }

        public void dispose() {
            PlatformUI.getWorkbench().removeWindowListener(this);
            partService.removePartListener(this);
            partService = null;
        }

        @Override
        public void windowActivated(IWorkbenchWindow window) {
            handleActivation();
        }

        @Override
        public void windowDeactivated(IWorkbenchWindow window) {
        }

        @Override
        public void windowClosed(IWorkbenchWindow window) {
        }

        @Override
        public void windowOpened(IWorkbenchWindow window) {
        }

        @Override
        public void partActivated(IWorkbenchPart part) {
            handleActivation();
        }

        @Override
        public void partBroughtToTop(IWorkbenchPart part) {
        }

        @Override
        public void partClosed(IWorkbenchPart part) {
        }

        @Override
        public void partDeactivated(IWorkbenchPart part) {
        }

        @Override
        public void partOpened(IWorkbenchPart part) {
        }

    }

}
