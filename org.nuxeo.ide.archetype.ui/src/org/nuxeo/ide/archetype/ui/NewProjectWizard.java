/*
 * (C) Copyright 2009 Nuxeo SA (http://nuxeo.com/) and contributors.
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
 *     stan
 */
package org.nuxeo.ide.archetype.ui;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

/**
 * New Project Wizard for webengine.
 * 
 * @author stan
 * 
 */
public class NewProjectWizard extends Wizard implements INewWizard {

    private WizardNewProjectCreationPage mainPage;

    private ArchetypeWizardPage archetypeWizardPage;

    private ArchetypeChooserWizardPage archetypeChooserWizardPage;

    public NewProjectWizard() {
        mainPage = new WizardNewProjectCreationPage("Nuxeo Webengine Project");
        // archetypeWizardPage = new ArchetypeWizardPage();
        archetypeChooserWizardPage = new ArchetypeChooserWizardPage();
    }
    
    
    public void setArchetypeWizardPage(ArchetypeWizardPage archetypeWizardPage) {
        this.archetypeWizardPage = archetypeWizardPage;
        archetypeWizardPage.setWizard(this);

    }

    @Override
    public void addPages() {
        super.addPages();

        // Add the main project page
        mainPage.setTitle("Nuxeo Webengine Project");
        mainPage.setDescription("Create a new Nuxeo Webengine Project");
        mainPage.setImageDescriptor(Activator.getImageDescriptor("icons/nuxeo/dialog_editfile.png"));

        archetypeChooserWizardPage.setTitle("Nuxeo Webengine Project");
        archetypeChooserWizardPage.setDescription("Choose Archetype (template) location");
        archetypeChooserWizardPage.setImageDescriptor(Activator.getImageDescriptor("icons/nuxeo/dialog_editfile.png"));

        addPage(mainPage);
        addPage(archetypeChooserWizardPage);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.wizard.Wizard#performFinish()
     */
    @Override
    public boolean performFinish() {
        try {
            getContainer().run(false, true, new WorkspaceModifyOperation() {

                @Override
                protected void execute(IProgressMonitor monitor)
                        throws CoreException, InvocationTargetException,
                        InterruptedException {

                    // start task
                    monitor.beginTask("Creating and setting up project", 1);

                    monitor.subTask("Creating project");

                    // create project
                    IProject project = createProject();
                    monitor.worked(1);

                    monitor.subTask("Creating project from archetype");
                    try {
                        archetypeWizardPage.archetype.doProcess(
                                archetypeWizardPage.values,
                                project.getLocation().toString());
                        project.refreshLocal(IResource.DEPTH_INFINITE, monitor);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    monitor.worked(1);

                }

                private IProject createProject() throws CoreException {
                    IProject project = mainPage.getProjectHandle().getProject();
                    if (!project.exists()) {
                        IPath location = mainPage.getLocationPath();
                        if (!Platform.getLocation().equals(location)) {
                            IProjectDescription desc = project.getWorkspace().newProjectDescription(
                                    project.getName());
                            desc.setLocation(location);
                            project.create(desc, null);
                        } else {
                            project.create(null);
                        }
                        project.open(null);
                    }

                    if (!project.hasNature(JavaCore.NATURE_ID)) {
                        NewProjectWizard.addNatureToProject(project,
                                JavaCore.NATURE_ID, null);
                    }

                    return project;
                }
            });

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
     * org.eclipse.jface.viewers.IStructuredSelection)
     */
    public void init(IWorkbench workbench, IStructuredSelection selection) {
    }

    public static void addNatureToProject(IProject proj, String natureId,
            IProgressMonitor monitor) throws CoreException {
        IProjectDescription description = proj.getDescription();
        String[] prevNatures = description.getNatureIds();
        String[] newNatures = new String[prevNatures.length + 1];
        System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
        newNatures[prevNatures.length] = natureId;
        description.setNatureIds(newNatures);
        proj.setDescription(description, monitor);
    }

}
