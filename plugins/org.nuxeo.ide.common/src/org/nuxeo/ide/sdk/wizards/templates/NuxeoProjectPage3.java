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
package org.nuxeo.ide.sdk.wizards.templates;

import org.eclipse.swt.widgets.Composite;
import org.nuxeo.ide.common.wizards.FormWizardPage;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class NuxeoProjectPage3 extends FormWizardPage<TemplateContext>
        implements Constants {

    public NuxeoProjectPage3() {
        super("nuxeoProjectPage3", "Select a template for the project", null);
    }

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
    }

    public String getTemplate() {
        return form.getWidgetValueAsString(PROJECT_TEMPLATE);
    }

    @Override
    public void update(TemplateContext ctx) {
        ctx.setTemplate(getTemplate());
    }

}
