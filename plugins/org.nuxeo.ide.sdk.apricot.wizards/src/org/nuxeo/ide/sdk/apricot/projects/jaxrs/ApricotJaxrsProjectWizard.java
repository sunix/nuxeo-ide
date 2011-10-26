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
package org.nuxeo.ide.sdk.apricot.projects.jaxrs;

import org.eclipse.jface.wizard.WizardPage;
import org.nuxeo.ide.sdk.projects.AbstractProjectWizard;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ApricotJaxrsProjectWizard extends AbstractProjectWizard {

    public static final String ID = ApricotJaxrsProjectWizard.class.getName();

    public ApricotJaxrsProjectWizard() {
        super("jaxrs");
    }

    @Override
    protected WizardPage[] createPages() {
        return null;
    }

    public void addPages() {
        addPage(new Page1());
    }

    @Override
    public String getTargetVersion() {
        return "1.0.0.qualifier";
    }
}
