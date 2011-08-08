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
package org.nuxeo.ide.common;

import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class NatureInstaller {

    public static void addNatures(final ISelection selection,
            final String... natureIds) {
        if (natureIds == null) {
            return;
        }
        if (selection instanceof IStructuredSelection) {
            Job job = new Job("Add Natures Job") {
                protected IStatus run(IProgressMonitor monitor) {
                    try {
                        Object[] objs = ((IStructuredSelection) selection).toArray();
                        for (Object obj : objs) {
                            if (obj instanceof IProject) {
                                IProject project = (IProject) obj;
                                boolean needBuild = false;
                                for (String natureId : natureIds) {
                                    if (project.getNature(natureId) == null) {
                                        install(project, natureId);
                                        needBuild = true;
                                    }
                                }
                                if (needBuild) {
                                    project.build(
                                            IncrementalProjectBuilder.FULL_BUILD,
                                            monitor);
                                }
                            }
                        }
                    } catch (CoreException e) {
                        return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                                "Failed to add natures", e);
                    }
                    return Status.OK_STATUS;
                }
            };
            job.setPriority(Job.SHORT);
            job.schedule(); // start as soon as possible
        }
    }

    public static void removeNatures(final ISelection selection,
            final String... natureIds) {
        if (selection instanceof IStructuredSelection) {
            try {
                Object[] objs = ((IStructuredSelection) selection).toArray();
                for (Object obj : objs) {
                    if (obj instanceof IProject) {
                        IProject project = (IProject) obj;
                        for (String natureId : natureIds) {
                            if (project.getNature(natureId) != null) {
                                uninstall(project, natureId);
                            }
                        }
                    }
                }
            } catch (CoreException e) {
                e.printStackTrace();
            }
        }
    }

    public static void install(IProject project, String natureId) {
        try {
            IProjectDescription description = project.getDescription();
            String[] natures = description.getNatureIds();
            String[] newNatures = new String[natures.length + 1];
            System.arraycopy(natures, 0, newNatures, 0, natures.length);
            newNatures[natures.length] = natureId;
            description.setNatureIds(newNatures);
            project.setDescription(description, null);
        } catch (CoreException e) {
            // Something went wrong
        }
    }

    public static void uninstall(IProject project, String natureId) {
        try {
            IProjectDescription description = project.getDescription();
            String[] natures = description.getNatureIds();
            ArrayList<String> newNatures = new ArrayList<String>();
            for (String nature : natures) {
                if (!natureId.equals(nature)) {
                    newNatures.add(nature);
                }
            }
            if (newNatures.size() != natures.length) {
                description.setNatureIds(newNatures.toArray(new String[newNatures.size()]));
                project.setDescription(description, null);
            }
        } catch (CoreException e) {
            // Something went wrong
        }
    }

}
