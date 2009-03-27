/*
 * (C) Copyright 2009 SKIN-SOFT (http://www.skin-soft.org/) and contributors.
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
 *     SKIN-SOFT - initial API and implementation
 *
 */
package org.skinsoft.nuxeo.ide.uml.ui.operations;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.skinsoft.nuxeo.ide.uml.core.packager.UmlContribPackager;
import org.skinsoft.nuxeo.ide.uml.core.packager.exception.PackagerException;

public class GenerateUMLContribOperation implements IRunnableWithProgress {
	
	protected File project ;
	
	public GenerateUMLContribOperation(Shell shell, File project) {
		super();
		this.project = project;
	}

	public void run( IProgressMonitor progress ) throws InvocationTargetException, InterruptedException {
		try {
			progress.beginTask( "Generating UML Contribs for " + this.project.getName() , IProgressMonitor.UNKNOWN ) ;
			
			UmlContribPackager packager = new UmlContribPackager( project ) ;
			packager.packageContribs() ;
			
		} catch (PackagerException e) {
			e.printStackTrace() ;
		} finally {
			progress.done() ;
		}
	}

	public File getProject() {
		return project;
	}

	public void setProject(File project) {
		this.project = project;
	}
	
	

}
