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
package org.nuxeo.ide.sdk.widgets;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.IVMInstallType;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.VMStandin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.nuxeo.ide.common.forms.BindingContext;
import org.nuxeo.ide.common.forms.HasValue;
import org.nuxeo.ide.common.forms.WidgetName;
import org.nuxeo.ide.common.forms.model.UIValueObject;
import org.w3c.dom.Element;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
@WidgetName("jre")
public class JREList extends UIValueObject<Combo> implements HasValue {

    @Override
    protected Combo createControl(Composite parent, Element element,
            BindingContext ctx) {
        Combo ctrl = new Combo(parent, SWT.READ_ONLY | SWT.FLAT | SWT.BORDER);
        IVMInstall[] vms = getWorkspaceJREs();
        for (IVMInstall vm : vms) {
            ctrl.add(vm.getName());
        }
        String defVm = getDefaultJVMName();
        ctrl.setText(defVm);
        return ctrl;
    }

    public static IVMInstall[] getWorkspaceJREs() {
        List<IVMInstall> standins = new ArrayList<IVMInstall>();
        IVMInstallType[] types = JavaRuntime.getVMInstallTypes();
        for (int i = 0; i < types.length; i++) {
            IVMInstallType type = types[i];
            IVMInstall[] installs = type.getVMInstalls();
            for (int j = 0; j < installs.length; j++) {
                IVMInstall install = installs[j];
                standins.add(new VMStandin(install));
            }
        }
        return ((IVMInstall[]) standins.toArray(new IVMInstall[standins.size()]));
    }

    public static String getDefaultJVMName() {
        IVMInstall install = JavaRuntime.getDefaultVMInstall();
        if (install != null) {
            return install.getName();
        } else {
            return "Unknown";
        }
    }

    @Override
    public String getValueAsString() {
        return ctrl.getText();
    }

    @Override
    public Object getValue() {
        String name = ctrl.getText().trim();
        IVMInstall[] vms = getWorkspaceJREs();
        for (IVMInstall vm : vms) {
            if (name.equals(vm.getName())) {
                return vm;
            }
        }
        ctrl.getText();
        return null;
    }

    @Override
    public void doSetValue(Object value) {
        if (value != null) {
            ctrl.setText(value.toString());
        }
    }
}
