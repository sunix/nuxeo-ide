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
package org.nuxeo.ide.sdk.ui.wizards.automation;

import java.io.File;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.nuxeo.ide.common.wizards.AbstractWizard;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class OperationWizard extends AbstractWizard<OperationContext> {

    @Override
    public void addPages() {
        addPage(new OperationWizardPage());
    }

    @Override
    protected OperationContext createExecutionContext() {
        OperationContext ctx = new OperationContext();
        ISelection selection = getSelection();
        if (selection instanceof IStructuredSelection) {
            Object obj = ((IStructuredSelection) selection).getFirstElement();
            if (obj instanceof IJavaElement) {
                IJavaProject project = ((IJavaElement) obj).getJavaProject();
                ctx.setProjectLocation(new File(project.getPath().toOSString()));
            }
        }
        return ctx;
    }

    @Override
    protected boolean execute(OperationContext context) {
        return false;
    }

}
