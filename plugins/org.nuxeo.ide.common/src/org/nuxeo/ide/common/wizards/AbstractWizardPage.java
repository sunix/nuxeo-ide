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
package org.nuxeo.ide.common.wizards;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.ui.IWorkbench;

/**
 * A page wizard that can only be used with an wizard derived from
 * {@link AbstractWizard}
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public abstract class AbstractWizardPage<T> extends WizardPage {

    public AbstractWizardPage(String pageName) {
        super(pageName);
    }

    public AbstractWizardPage(String pageName, String title,
            ImageDescriptor titleImage) {
        super(pageName, title, titleImage);
    }

    public abstract void update(T ctx);

    @SuppressWarnings("unchecked")
    @Override
    public AbstractWizard<T> getWizard() {
        return (AbstractWizard<T>) super.getWizard();
    }

    public IStructuredSelection getSelection() {
        return getWizard().getSelection();
    }

    public IWorkbench getWorkbench() {
        return getWizard().getWorkbench();
    }

    /**
     * Called every time when this page becomes the current one (when it is
     * displayed in dialog)
     */
    public void enterPage() {
        // do nothing
    }
}
