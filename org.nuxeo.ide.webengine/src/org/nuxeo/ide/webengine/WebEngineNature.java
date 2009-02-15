/*
 * (C) Copyright 2006-2008 Nuxeo SAS (http://nuxeo.com/) and contributors.
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
package org.nuxeo.ide.webengine;

import java.util.ArrayList;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

/**
 * This class is instantiated when a new project with thewebngine nature is created from the new project wizard.
 * This nature will add an annotation builder specific for webengine projects.
 *
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public class WebEngineNature implements IProjectNature {

    public final static String BUILDER_ID = "org.nuxeo.ide.webengine.AnnotationBuilder";
    public final static String ID = "org.nuxeo.ide.webengine.WebEngineNature";

    protected IProject project;

    /**
     *
     */
    public WebEngineNature() {
    }

    public IProject getProject() {
        return project;
    }

    public void setProject(IProject project) {
        this.project = project;
    }

    public void configure() throws CoreException {

        IProjectDescription desc = project.getDescription();
        ICommand[] commands = desc.getBuildSpec();
        boolean found = false;

        for (int i = 0; i < commands.length; ++i) {
           if (commands[i].getBuilderName().equals(BUILDER_ID)) {
              found = true;
              break;
           }
        }
        if (!found) {
           //add builder to project
           ICommand command = desc.newCommand();
           command.setBuilderName(BUILDER_ID);
           ICommand[] newCommands = new ICommand[commands.length + 1];

           // Add it after other builders.
           System.arraycopy(commands, 0, newCommands, 0, commands.length);
           newCommands[commands.length] = command;
           desc.setBuildSpec(newCommands);
           project.setDescription(desc, null);
        }

    }

    public void deconfigure() throws CoreException {
        IProjectDescription desc = project.getDescription();
        ICommand[] commands = desc.getBuildSpec();
        ArrayList<ICommand> newCommands = new ArrayList<ICommand>();
        for (ICommand cmd : commands) {
            if (!BUILDER_ID.equals(cmd.getBuilderName())) {
                newCommands.add(cmd);
            }
        }
        if (newCommands.size() != commands .length) {
            desc.setBuildSpec(newCommands.toArray(new ICommand[newCommands.size()]));
            project.setDescription(desc, null);
        }
    }

    public static void install(IProject project) {
        try {
            IProjectDescription description = project.getDescription();
            String[] natures = description.getNatureIds();
            String[] newNatures = new String[natures.length + 1];
            System.arraycopy(natures, 0, newNatures, 0, natures.length);
            newNatures[natures.length] = ID;
            description.setNatureIds(newNatures);
            project.setDescription(description, null);
        } catch (CoreException e) {
            // Something went wrong
        }
    }

    public static void uninstall(IProject project) {
        try {
            IProjectDescription description = project.getDescription();
            String[] natures = description.getNatureIds();
            ArrayList<String> newNatures = new ArrayList<String>();
            for (String nature : natures) {
                if (!ID.equals(nature)) {
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
