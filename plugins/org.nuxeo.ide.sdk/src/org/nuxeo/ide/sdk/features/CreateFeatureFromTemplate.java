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
package org.nuxeo.ide.sdk.features;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.nuxeo.ide.common.Activator;
import org.nuxeo.ide.common.wizards.ImportProject;
import org.nuxeo.ide.sdk.SDKPlugin;
import org.nuxeo.ide.sdk.templates.TemplateRegistry;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class CreateFeatureFromTemplate extends WorkspaceModifyOperation {

    protected FeatureTemplateContext ctx;

    public CreateFeatureFromTemplate(FeatureTemplateContext ctx) {
        this.ctx = ctx;
    }

    public FeatureTemplateContext getTemplateContext() {
        return ctx;
    }

    protected void postCreate() {
        if (ctx.getProject() != null) {
            IProject project = ctx.getProject().getProject();
            String path = ctx.getResourceToSelect();
            if (path != null) {
                IResource r = project.findMember(new Path(path));
                if (r != null) {
                    ImportProject.selectAndReveal(r);
                    return;
                }
            }
            ImportProject.selectAndReveal(project);
        }
    }

    @Override
    protected void execute(IProgressMonitor monitor) throws CoreException,
            InvocationTargetException, InterruptedException {
        File projectRoot = ctx.getProjectLocation();
        try {
            monitor.beginTask("Creating feature files", 2);
            if (!projectRoot.exists()) {
                throw new IOException(
                        "The target project file doesn't exists: "
                                + projectRoot);
            }
            TemplateRegistry tempReg = SDKPlugin.getDefault().getTemplateManager().getDefaultRegistry();
            if (tempReg != null) {
                tempReg.processFeatureTemplate(ctx.getTemplate(), ctx,
                        projectRoot);
            } else {
                throw new IllegalStateException("NuxeoSDK is not configured!");
            }
            monitor.worked(1);
            ctx.getProject().getProject().refreshLocal(
                    IResource.DEPTH_INFINITE,
                    new SubProgressMonitor(monitor, 1));
            monitor.worked(1);
            monitor.done();
        } catch (CoreException e) {
            throw e;
        } catch (InvocationTargetException e) {
            throw e;
        } catch (InterruptedException e) {
            throw e;
        } catch (Exception e) {
            throw new InvocationTargetException(e);
        }
    }

    public static boolean run(Shell shell, IRunnableContext ctx,
            CreateFeatureFromTemplate op) {
        try {
            ctx.run(true, true, op);
            op.postCreate();
        } catch (InterruptedException e) {
            return false;
        } catch (InvocationTargetException e) {
            // one of the steps resulted in a core exception
            Throwable t = e.getTargetException();
            String message = "Project Creation Error";
            IStatus status;
            if (t instanceof CoreException) {
                status = ((CoreException) t).getStatus();
            } else {
                status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, 1,
                        message, t);
            }
            ErrorDialog.openError(shell, message, null, status);
            return false;
        }
        return true;
    }

}
