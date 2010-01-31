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



import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.internal.debug.ui.JDIDebugUIPlugin;
import org.eclipse.jdt.internal.debug.ui.SWTFactory;
import org.eclipse.jdt.internal.debug.ui.launcher.DebugTypeSelectionDialog;
import org.eclipse.jdt.internal.debug.ui.launcher.LauncherMessages;
import org.eclipse.jdt.internal.debug.ui.launcher.MainMethodSearchEngine;
import org.eclipse.jdt.internal.debug.ui.launcher.SharedJavaMainTab;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.nuxeo.dev.ide.builder.NuxeoProject;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 *
 */
public class NuxeoMainTab extends SharedJavaMainTab implements NuxeoLaunchAttributes, IJavaLaunchConfigurationConstants {
    
    protected Text mainClass;
    protected Combo profiles;
    protected Text customProfile;
    protected Text host;
    protected Combo update;
    protected Button nocache;
    protected Button offline;
    
    @Override
    public String getMessage() {
        return "Run the selected project into a Nuxeo Server";
    }

    @Override
    public boolean isValid(ILaunchConfiguration launchConfig) {
        try {
            if (launchConfig.getAttribute(ATTR_PROJECT_NAME, "").length() == 0) {
                setErrorMessage("Must select a project having a Nuxeo nature");
                return false;
            } else {
                setErrorMessage(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    protected void handleSearchButtonSelected() {
        IJavaProject project = getJavaProject();
        IJavaElement[] elements = null;
        if ((project == null) || !project.exists()) {
            IJavaModel model = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot());
            if (model != null) {
                try {
                    elements = model.getJavaProjects();
                }
                catch (JavaModelException e) {JDIDebugUIPlugin.log(e);}
            }
        }
        else {
            elements = new IJavaElement[]{project};
        }
        if (elements == null) {
            elements = new IJavaElement[]{};
        }
        int constraints = IJavaSearchScope.SOURCES;
//        constraints |= IJavaSearchScope.APPLICATION_LIBRARIES;
//        if (fSearchExternalJarsCheckButton.getSelection()) {
//            constraints |= IJavaSearchScope.SYSTEM_LIBRARIES;
//        }
        IJavaSearchScope searchScope = SearchEngine.createJavaSearchScope(elements, constraints);
        MainMethodSearchEngine engine = new MainMethodSearchEngine();
        IType[] types = null;
        try {
            types = engine.searchMainMethods(getLaunchConfigurationDialog(), searchScope, false);
        }
        catch (InvocationTargetException e) {
            setErrorMessage(e.getMessage());
            return;
        }
        catch (InterruptedException e) {
            setErrorMessage(e.getMessage());
            return;
        }
        DebugTypeSelectionDialog mmsd = new DebugTypeSelectionDialog(getShell(), types, LauncherMessages.JavaMainTab_Choose_Main_Type_11); 
        if (mmsd.open() == Window.CANCEL) {
            return;
        }
        Object[] results = mmsd.getResult();    
        IType type = (IType)results[0];
        if (type != null) {
            fMainText.setText(type.getFullyQualifiedName());
            fProjText.setText(type.getJavaProject().getElementName());
        }
    }
    
    public void createControl(Composite parent) {
        Composite projComp = SWTFactory.createComposite(parent, parent.getFont(), 1, 1, GridData.FILL_BOTH); 
        ((GridLayout)projComp.getLayout()).verticalSpacing = 0;
        createProjectEditor(projComp);
        createVerticalSpacer(projComp, 1);
        createMainTypeEditor(projComp, "Main Class:");
        createVerticalSpacer(projComp, 1);
        createProfilesEditor(projComp);
        createVerticalSpacer(projComp, 1);
        createHostEditor(projComp);
        createVerticalSpacer(projComp, 1);
        createOptionsEditor(projComp);
        setControl(projComp);
    }

    public String getName() {
        return "Nuxeo Main";
    }


    public void setDefaults(ILaunchConfigurationWorkingCopy config) {
        IJavaElement javaElement = getContext();
        if (javaElement != null) {
            initializeJavaProject(javaElement, config);
        }
        else {
            config.setAttribute(ATTR_PROJECT_NAME, "");
        }
        setDefaultValues(config);
    }

    public static void setDefaultValues(ILaunchConfigurationWorkingCopy config) {
        config.setAttribute(HOST, "localhost:8081");
        config.setAttribute(UPDATE, "daily");
        config.setAttribute(OFFLINE, false);
        config.setAttribute(NOCACHE, false);
    }
    
    protected String getDefaultHome(ILaunchConfiguration config) throws CoreException {
        String h = System.getProperty("user.home")+"/.nxserver";
        String pname = config.getAttribute(ATTR_PROJECT_NAME, (String)null);
        if (pname != null && pname.length()>0) {
            return h+"/projects/"+pname;
        }
        return h;
    }
    
    @Override
    public void initializeFrom(ILaunchConfiguration config) {
        super.initializeFrom(config);
        updateMainTypeFromConfig(config);
        try {
            String c = config.getAttribute(CUSTOM_PROFILE, "");
            String p = config.getAttribute(PROFILE, "");
            String h = config.getAttribute(HOST, "localhost:8081");
            String u = config.getAttribute(UPDATE, "daily");
            boolean o = config.getAttribute(OFFLINE, false);            
            boolean nocache = config.getAttribute(NOCACHE, false);
            if (c.length()>0) {
                customProfile.setText(c);
                profiles.setText("Custom ...");
            }
            if (p.length()>0) {
                profiles.setText(p);
            }
            host.setText(h);
            update.setText(u);
            offline.setSelection(o);
            this.nocache.setSelection(nocache);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void performApply(ILaunchConfigurationWorkingCopy configuration) {
        configuration.setAttribute(IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME, fProjText.getText());
        configuration.setAttribute(IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME, fMainText.getText());
        if (customProfile.isEnabled()) {
            configuration.setAttribute(CUSTOM_PROFILE, customProfile.getText());
            configuration.removeAttribute(PROFILE);
        } else {
            configuration.setAttribute(PROFILE, profiles.getText());
            configuration.removeAttribute(CUSTOM_PROFILE);
        }
        configuration.setAttribute(HOST, host.getText());
        configuration.setAttribute(UPDATE, update.getText());
        if (nocache.getSelection()) {
            configuration.setAttribute(NOCACHE, true);
        } else {
            configuration.setAttribute(NOCACHE, false);
        }
        if (offline.getSelection()) {
            configuration.setAttribute(OFFLINE, true);
        } else {
            configuration.setAttribute(OFFLINE, false);
        }
    }


    protected void createProfilesEditor(Composite parent) {
        Font font = parent.getFont();
        Group group = new Group(parent, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        group.setLayoutData(gd);
        group.setFont(font);
        group.setText("Nuxeo Profile:");
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        group.setLayout(layout);        
        profiles = new Combo(group, SWT.BORDER | SWT.READ_ONLY | SWT.DROP_DOWN);
        profiles.add("core-5.3.0");
        profiles.add("core-5.3.1-SNAPSHOT");
        profiles.add("Custom ...");
        profiles.setText("core-5.3.1-SNAPSHOT");
        gd = new GridData(GridData.FILL_HORIZONTAL);
        customProfile = new Text(group, SWT.BORDER);
        customProfile.setEnabled(false);
        customProfile.setLayoutData(gd);        
        final Button browse = SWTFactory.createPushButton(group, "Browse ...", null);
        browse.setEnabled(false);
        profiles.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                setDirty(true);
                updateLaunchConfigurationDialog();
                if (profiles.getText().startsWith("Custom")) {
                    customProfile.setEnabled(true);
                    browse.setEnabled(true);
                } else {
                    customProfile.setEnabled(false);
                    browse.setEnabled(false);
                }
                updateLaunchConfigurationDialog();
            }
        });
        browse.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                FileDialog dlg = new FileDialog(Display.getCurrent().getActiveShell());
                String path = dlg.open();
                if (path != null) {
                    customProfile.setText(path);
                }
            }
            public void widgetDefaultSelected(SelectionEvent e) {
                // do nothing
            }
        });
    }

    protected void createHostEditor(Composite parent) {
        Font font = parent.getFont();
        Group group = new Group(parent, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        group.setLayoutData(gd);
        group.setFont(font);
        group.setText("HTTP Server Address:");
        GridLayout layout = new GridLayout();
        layout.numColumns = 1;
        group.setLayout(layout);
        gd = new GridData(GridData.FILL_HORIZONTAL);

        host = new Text(group, SWT.BORDER);
        host.setLayoutData(gd);
        host.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                setDirty(true);
                updateLaunchConfigurationDialog();
            }
        });
    }   

    protected void createOptionsEditor(Composite parent) {
        Font font = parent.getFont();
        Group group = new Group(parent, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        group.setLayoutData(gd);
        group.setFont(font);
        group.setText("Build Options:");
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        group.setLayout(layout);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;

        
        nocache = new Button(group, SWT.CHECK);
        nocache.setText("Rebuild application at next run");
        nocache.setLayoutData(gd);
        nocache.addSelectionListener(new SelectionListener() {            
            public void widgetSelected(SelectionEvent e) {    
                setDirty(true);
                updateLaunchConfigurationDialog();
            }
            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
                
        offline = new Button(group, SWT.CHECK);
        offline.setText("Put Maven offline");
        offline.setLayoutData(gd);
        offline.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent e) {                
                setDirty(true);
                updateLaunchConfigurationDialog();
            }
            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
        
        Label label = new Label(group, SWT.NONE);        
        label.setText("Update policy");
        update = new Combo(group, SWT.DROP_DOWN | SWT.READ_ONLY | SWT.BORDER);
        update.add("always");
        update.add("daily");
        update.add("never");
        update.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                setDirty(true);
                updateLaunchConfigurationDialog();
            }
        });
    }   

    
    @Override
    protected void updateLaunchConfigurationDialog() {
        super.updateLaunchConfigurationDialog();
    }

    @Override
    protected void handleProjectButtonSelected() {
        IJavaProject project = chooseJavaProject();
        if (project == null) {
            return;
        }
        String projectName = project.getElementName();
        fProjText.setText(projectName);     
    }
    
    protected IJavaProject chooseJavaProject() {
        ILabelProvider labelProvider= new JavaElementLabelProvider(JavaElementLabelProvider.SHOW_DEFAULT);
        ElementListSelectionDialog dialog= new ElementListSelectionDialog(getShell(), labelProvider);
        dialog.setTitle(LauncherMessages.AbstractJavaMainTab_4); 
        dialog.setMessage(LauncherMessages.AbstractJavaMainTab_3); 
        try {
            IJavaProject[] prjs = JavaCore.create(getWorkspaceRoot()).getJavaProjects();
            ArrayList<IJavaProject> result = new ArrayList<IJavaProject>();
            for (IJavaProject prj : prjs) {
                if (prj.getProject().hasNature(NuxeoProject.NATURE_ID)) {
                    result.add(prj);
                }
            }
            dialog.setElements(result.toArray());
        }
        catch (Exception jme) {JDIDebugUIPlugin.log(jme);}
        IJavaProject javaProject= getJavaProject();
        if (javaProject != null) {
            dialog.setInitialSelections(new Object[] { javaProject });
        }
        if (dialog.open() == Window.OK) {           
            return (IJavaProject) dialog.getFirstResult();
        }       
        return null;        
    }

}
