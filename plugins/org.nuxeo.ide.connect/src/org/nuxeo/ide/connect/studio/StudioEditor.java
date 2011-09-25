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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.nuxeo.ide.connect.studio.content.StudioEditorInput;
import org.nuxeo.ide.connect.studio.content.StudioProjectElement;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class StudioEditor extends EditorPart {

    public static final String ID = StudioEditor.class.getName();

    protected StudioEditorPanel panel;

    @Override
    public void doSave(IProgressMonitor monitor) {

    }

    @Override
    public void doSaveAs() {
    }

    @Override
    public void init(IEditorSite site, IEditorInput input)
            throws PartInitException {
        if (input instanceof StudioEditorInput) {
            setSite(site);
            setInput(input);
            setPartName(input.getName());
        } else {
            throw new PartInitException("Unsupported input: " + input);
        }
    }

    public StudioProject getStudioProject() {
        return ((StudioEditorInput) getEditorInput()).getStudioProject();
    }

    public IProject getTargetProject() {
        return ((StudioEditorInput) getEditorInput()).getTargetProject();
    }

    public StudioProjectElement getStudioElement() {
        return ((StudioEditorInput) getEditorInput()).getElement();
    }

    @Override
    public boolean isDirty() {
        return false;
    }

    @Override
    public boolean isSaveAsAllowed() {
        return false;
    }

    @Override
    public void createPartControl(Composite parent) {
        panel = new StudioEditorPanel(parent);
        panel.setInput(getStudioElement());
    }

    @Override
    public void dispose() {
        super.dispose();
        if (panel != null) {
            panel.dispose();
        }
    }

    @Override
    public void setFocus() {
        if (panel != null) {
            panel.getTreeViewer().getTree().setFocus();
        }
    }

}
