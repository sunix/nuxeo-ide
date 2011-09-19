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

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.nuxeo.ide.common.Activator;

/**
 * To run this operation from an wizard call:
 * <code>wizardContainer.run(true, true, importOperation);</code> or
 * <code>ImportProject.run(shell, wizardContainer, importOperation);</code>
 * 
 * See WizardProjectsImportPage
 * 
 * If project to import is already located into eclipse workspace then the
 * project name must be the same as the project file name, otherwise you will
 * have exceptions.
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ImportProject extends WorkspaceModifyOperation {

    protected File projectRoot;

    protected IWorkingSet[] workingSets;

    protected IProject project;

    public ImportProject(File projectRoot) {
        this(projectRoot, null);
    }

    public ImportProject(File projectRoot, IWorkingSet[] workingSets) {
        this.projectRoot = projectRoot;
        this.workingSets = workingSets;
    }

    public void setWorkingSets(IWorkingSet[] workingSets) {
        this.workingSets = workingSets;
    }

    public IWorkingSet[] getWorkingSets() {
        return workingSets;
    }

    public File getProjectRoot() {
        return projectRoot;
    }

    protected IProjectDescription loadDescription(File projectRoot)
            throws CoreException {
        File projectFile = new File(projectRoot,
                IProjectDescription.DESCRIPTION_FILE_NAME);
        return ResourcesPlugin.getWorkspace().loadProjectDescription(
                new Path(projectFile.getAbsolutePath()));
    }

    protected void preCreate(IProgressMonitor monitor) throws Exception {
        // do nothing by default
    }

    protected void postCreate() {
        if (project != null) {
            selectAndReveal(project);
        }
    }

    protected void execute(final IProgressMonitor monitor)
            throws InvocationTargetException, InterruptedException {
        try {
            if (monitor.isCanceled()) {
                throw new OperationCanceledException();
            }
            IProjectDescription description = null;
            // there 4 steps
            monitor.beginTask("Creating Project", 4);
            // step 1 - do pre-processing if any
            try {
                preCreate(new SubProgressMonitor(monitor, 1));
                monitor.worked(1);
                if (monitor.isCanceled()) {
                    throw new OperationCanceledException();
                }
                // step 2 - construct the project description
                description = loadDescription(projectRoot);
            } catch (Exception e) {
                throw new InvocationTargetException(e,
                        "Failed to load project description");
            }
            monitor.worked(1);
            if (monitor.isCanceled()) {
                throw new OperationCanceledException();
            }
            // step 3 - create the project
            project = createExistingProject(description,
                    new SubProgressMonitor(monitor, 1));
            monitor.worked(1);
            if (monitor.isCanceled()) {
                throw new OperationCanceledException();
            }
            // step 4 - add the project to the working sets
            addToWorkingSets(project, workingSets);
            monitor.worked(1);
        } finally {
            monitor.done();
        }
    }

    public static void selectAndReveal(final IResource newResource) {
        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                BasicNewResourceWizard.selectAndReveal(newResource,
                        PlatformUI.getWorkbench().getActiveWorkbenchWindow());
            }
        });
    }

    public IProject createExistingProject(IProjectDescription description,
            IProgressMonitor monitor) throws InvocationTargetException,
            InterruptedException {
        String projectName = description.getName();
        final IWorkspace workspace = ResourcesPlugin.getWorkspace();
        final IProject project = workspace.getRoot().getProject(projectName);
        // import from file system
        try {
            monitor.beginTask("Creating Project", 100);
            project.create(description, new SubProgressMonitor(monitor, 30));
            // do not use background refresh to be able to select the project
            // when refresh is done
            project.open(new SubProgressMonitor(monitor, 70));
        } catch (CoreException e) {
            throw new InvocationTargetException(e);
        } finally {
            monitor.done();
        }

        return project;
    }

    public void addToWorkingSets(IProject project, IWorkingSet[] workingSets) {
        if (workingSets == null || workingSets.length == 0) {
            return;
        }
        if (workingSets.length > 0) {
            PlatformUI.getWorkbench().getWorkingSetManager().addToWorkingSets(
                    project, workingSets);
        }
    }

    public IProject getProject() {
        return project;
    }

    public static boolean isExistingProject(String name) {
        return ResourcesPlugin.getWorkspace().getRoot().getProject(name).exists();
    }

    public static boolean run(Shell shell, IRunnableContext ctx,
            ImportProject op) {
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
