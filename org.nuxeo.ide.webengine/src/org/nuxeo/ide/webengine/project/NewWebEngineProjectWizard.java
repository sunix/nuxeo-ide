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
package org.nuxeo.ide.webengine.project;

import org.eclipse.core.runtime.Path;
import org.nuxeo.ide.archetype.ui.ArchetypeListWizardPage;
import org.nuxeo.ide.archetype.ui.NewArchetypeListBasedProjectWizard;
import org.nuxeo.ide.archetype.ui.providers.BundleArchetypeFileEntry;
import org.nuxeo.ide.archetype.ui.providers.IArchetypeFileEntry;
import org.nuxeo.ide.webengine.Nuxeo;

/**
 * @author stan
 * 
 */
public class NewWebEngineProjectWizard extends
        NewArchetypeListBasedProjectWizard {

    public NewWebEngineProjectWizard() {
        super(new ArchetypeListWizardPage() {
            @Override
            public IArchetypeFileEntry[] getArchetypeFileEntry() {
                return new IArchetypeFileEntry[] {
                        new BundleArchetypeFileEntry(
                                Nuxeo.getDefault().getBundle(), new Path(
                                        "archetypes/gwebmodule"),
                                "Webengine Project with groovy files"),
                        new BundleArchetypeFileEntry(
                                Nuxeo.getDefault().getBundle(), new Path(
                                        "archetypes/webmodule"),
                                "Webengine Project with java files") };

            }
        });
    }

}
