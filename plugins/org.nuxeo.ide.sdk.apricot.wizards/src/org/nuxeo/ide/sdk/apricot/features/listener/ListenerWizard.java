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
 *     ldoguin
 */
package org.nuxeo.ide.sdk.apricot.features.listener;

import org.nuxeo.ide.sdk.features.FeatureCreationWizard;

/**
 * @author <a href="mailto:ldoguin@nuxeo.com">Laurent Doguin</a>
 * 
 */
public class ListenerWizard extends FeatureCreationWizard {

    public ListenerWizard() {
        super("listener");
    }

    @Override
    public void addPages() {
        addPage(new ListenerWizardPage());
    }

    @Override
    public String getTargetProjectNature() {
        return "org.eclipse.pde.PluginNature";
    }

}
