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
package org.nuxeo.ide.sdk.server.ui;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.ui.util.BusyIndicatorRunnableContext;
import org.eclipse.jdt.internal.ui.util.ExceptionHandler;
import org.eclipse.jdt.ui.jarpackager.IJarExportRunnable;
import org.eclipse.jdt.ui.jarpackager.JarPackageData;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.nuxeo.ide.common.UI;

/**
 * Fake add nature - used as an example
 * 
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 * 
 */
public class ExportProjectJar implements IObjectActionDelegate {

    protected ISelection selection;

    protected IWorkbenchPart part;

    public ExportProjectJar() {
    }

    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        part = targetPart;
    }

    public void run(IAction action) {
        if (selection instanceof IStructuredSelection) {
            IProject project = (IProject) ((IStructuredSelection) selection).getFirstElement();
            exportJar(project, part.getSite().getShell());
        }
    }

    public void selectionChanged(IAction action, ISelection selection) {
        this.selection = selection;
    }

    public boolean exportJar(IProject project, Shell shell) {
        FileDialog dlg = new FileDialog(shell, SWT.SAVE);
        dlg.setFileName(project.getName() + ".jar");
        dlg.setText("Export Project JAR");
        // dlg.setMessage("Select the directory where the JAR will be exported");
        String p = dlg.open();
        if (p == null) {
            return false;
        }
        IPath path = new Path(p);
        JarPackageData jarData = new JarPackageData();
        jarData.setBuildIfNeeded(true);
        jarData.setExportWarnings(true);
        jarData.setCompress(true);
        jarData.setOverwrite(true);
        jarData.setIncludeDirectoryEntries(true);
        IFile mf = project.getFile("src/main/resources/META-INF/MANIFEST.MF");
        if (mf.exists()) {
            jarData.setGenerateManifest(false);
            jarData.setManifestLocation(mf.getFullPath());
        }

        jarData.setJarLocation(path);
        try {
            jarData.setElements(collectElementsToExport(project));
        } catch (Exception e) {
            UI.showError("Failed to export project", e);
        }
        IJarExportRunnable op = jarData.createJarExportRunnable(shell);
        if (!executeOperation(shell, op)) {
            return false;
        }
        IStatus status = op.getStatus();
        if (!status.isOK()) {
            ErrorDialog.openError(shell, "Jar Export", null, status);
            return !(status.matches(IStatus.ERROR));
        }
        return true;
    }

    protected Object[] collectElementsToExport(IProject project)
            throws JavaModelException {
        IJavaProject jp = JavaCore.create(project);
        ArrayList<Object> result = new ArrayList<Object>();
        // IFolder folder = project.getFolder("src/main/java");
        // if (folder.exists()) {
        // result.add(jp.getPackageFragmentRoot(folder));
        // }
        // folder = project.getFolder("src/main/resources");
        // if (folder.exists()) {
        // result.add(jp.getPackageFragmentRoot(folder));
        // }
        // return result;
        IFolder testSrc = project.getFolder("src/test");
        IPath test = testSrc.exists() ? testSrc.getFullPath() : null;
        IPackageFragmentRoot[] roots = jp.getPackageFragmentRoots();
        for (IPackageFragmentRoot root : roots) {
            if (root.getKind() == IPackageFragmentRoot.K_SOURCE) {
                if (test == null || !test.isPrefixOf(root.getPath())) {
                    result.add(root);
                }
            }
        }
        return result.toArray(new Object[result.size()]);
    }

    protected boolean executeOperation(Shell shell, IRunnableWithProgress op) {
        try {
            new BusyIndicatorRunnableContext().run(false, true, op);
        } catch (InterruptedException e) {
            return false;
        } catch (InvocationTargetException ex) {
            if (ex.getTargetException() != null) {
                ExceptionHandler.handle(ex, shell, "JAR Export Error",
                        "Creation of JAR failed");
                return false;
            }
        }
        return true;
    }

}
