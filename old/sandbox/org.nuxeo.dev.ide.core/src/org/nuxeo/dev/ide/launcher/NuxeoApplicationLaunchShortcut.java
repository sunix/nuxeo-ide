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
package org.nuxeo.dev.ide.launcher;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.debug.ui.JavaDebugUtils;
import org.eclipse.jdt.internal.debug.ui.JDIDebugUIPlugin;
import org.eclipse.jdt.internal.debug.ui.launcher.LauncherMessages;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public class NuxeoApplicationLaunchShortcut implements ILaunchShortcut {
    /* (non-Javadoc)
     * @see org.eclipse.debug.ui.ILaunchShortcut#launch(org.eclipse.ui.IEditorPart, java.lang.String)
     */
    public void launch(IEditorPart editor, String mode) {
        IEditorInput input = editor.getEditorInput();
        IJavaElement je = (IJavaElement) input.getAdapter(IJavaElement.class);
        if (je != null) {
            searchAndLaunch(new Object[] {je}, mode);
        }
    }

    /* (non-Javadoc)
     * @see org.eclipse.debug.ui.ILaunchShortcut#launch(org.eclipse.jface.viewers.ISelection, java.lang.String)
     */
    public void launch(ISelection selection, String mode) {
        if (selection instanceof IStructuredSelection) {
            searchAndLaunch(((IStructuredSelection)selection).toArray(), mode);
        }
    }
    
    protected void searchAndLaunch(Object[] scope, String mode) {
            Object o = scope[0];
            if(o instanceof IAdaptable) {
                IAdaptable adapt = (IAdaptable) o;
                IJavaElement element = (IJavaElement) adapt.getAdapter(IJavaElement.class);
                IJavaProject project = element.getJavaProject();
                boolean isMainType = isMainType(element);
                ILaunchConfigurationType configType = getConfigurationType();
                try {
                    ILaunchConfiguration config = null;
                    ILaunchConfiguration[] configs = DebugPlugin.getDefault().getLaunchManager().getLaunchConfigurations(configType);
                    for (ILaunchConfiguration c : configs) {
                        String pname = c.getAttribute(IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME, (String)null);
                        if (project.getElementName().equals(pname)) {
                            if (isMainType) {
                                String maint = c.getAttribute(IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME, (String)null);
                                if (element.getElementName().equals(maint)) {
                                    config = c;
                                    break;
                                }
                            } else {
                                config = c;
                                break;
                            }
                        } 
                    }
                    if (config == null) {
                        config = createConfiguration(project, element, isMainType);
                    }
                    if (config != null) {
                        DebugUITools.launch(config, mode);
                    }           
                } catch (Exception e) {
                    JDIDebugUIPlugin.log(e);
                }
            }
    }


    protected ILaunchConfigurationType getConfigurationType() {
        ILaunchManager lm= DebugPlugin.getDefault().getLaunchManager();
        return lm.getLaunchConfigurationType("org.eclipse.jdt.launching.nuxeoApplication");
    }
    
    protected ILaunchConfiguration createConfiguration(IJavaProject project, IJavaElement mainType, boolean isMainType) {
        ILaunchConfiguration config = null;
        ILaunchConfigurationWorkingCopy wc = null;
        try {
            ILaunchConfigurationType configType = getConfigurationType();
            wc = configType.newInstance(null, getLaunchManager().generateUniqueLaunchConfigurationNameFrom(project.getElementName()));
//            wc.setAttribute(IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME, type.getFullyQualifiedName());
            //wc.setAttribute(IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME, "org.nuxeo.dev.Main");
            wc.setAttribute(IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME, project.getElementName());
            if (isMainType) {
                wc.setAttribute(IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME, mainType.getElementName());
            }
            NuxeoMainTab.setDefaultValues(wc);
            //wc.setMappedResources(new IResource[] {type.getUnderlyingResource()});
            config = wc.doSave();
        } catch (CoreException exception) {
            MessageDialog.openError(JDIDebugUIPlugin.getActiveWorkbenchShell(), LauncherMessages.JavaLaunchShortcut_3, exception.getStatus().getMessage()); 
        } 
        return config;
    }
    
    private ILaunchManager getLaunchManager() {
        return DebugPlugin.getDefault().getLaunchManager();
    }

    
    protected boolean isMainType(IJavaElement element) {
        if (IJavaElement.CLASS_FILE == element.getElementType()) {
            return false;
        }
        return false;
    }
}
