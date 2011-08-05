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
package org.nuxeo.ide.sdk.ui.widgets;

import org.eclipse.jdt.internal.ui.workingsets.IWorkingSetIDs;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.dialogs.WorkingSetConfigurationBlock;
import org.nuxeo.ide.sdk.SDKPlugin;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class WorkingSetsPanel extends Composite {

    protected WorkingSetConfigurationBlock wscfg;

    public WorkingSetsPanel(Composite parent, IStructuredSelection selection) {
        super(parent, SWT.NONE);
        setLayout(new GridLayout(1, false));
        String[] workingSetIds = new String[] { IWorkingSetIDs.JAVA,
                IWorkingSetIDs.RESOURCE };
        wscfg = new WorkingSetConfigurationBlock(workingSetIds,
                SDKPlugin.getDefault().getDialogSettings());
        wscfg.setWorkingSets(wscfg.findApplicableWorkingSets(selection));
        wscfg.createContent(this);
    }

    public IWorkingSet[] getSelectedWorkingSets() {
        return wscfg.getSelectedWorkingSets();
    }
}
