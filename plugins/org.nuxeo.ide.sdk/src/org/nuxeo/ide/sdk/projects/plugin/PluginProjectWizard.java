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
package org.nuxeo.ide.sdk.projects.plugin;

import org.eclipse.jface.wizard.WizardPage;
import org.nuxeo.ide.sdk.projects.AbstractProjectWizard;
import org.nuxeo.ide.sdk.projects.NuxeoProjectPage1;
import org.nuxeo.ide.sdk.projects.NuxeoProjectPage2;
import org.nuxeo.ide.sdk.projects.NuxeoProjectPage3;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class PluginProjectWizard extends AbstractProjectWizard {

    @Override
    protected WizardPage[] createPages() {
        return new WizardPage[] { new NuxeoProjectPage1(),
                new NuxeoProjectPage2(), new NuxeoProjectPage3() };
    }

}
