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
package org.skinsoft.nuxeo.ide.uml.ui.popup.actions;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.skinsoft.nuxeo.ide.uml.ui.operations.GenerateUMLContribOperation;

public class GenerateUmlContribs implements IObjectActionDelegate {

	private Shell shell;
	
	/**
	 * Constructor for Action1.
	 */
	public GenerateUmlContribs() {
		super();
	}
	
	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		
		IWorkbench wb = PlatformUI.getWorkbench() ;
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow() ;
		IWorkbenchPage page = win.getActivePage() ;
		ISelection s = page.getSelection() ;		
		
		if( s instanceof IStructuredSelection ) {
			IStructuredSelection selection = (IStructuredSelection) s ;
			
			ArrayList<String> messages = new ArrayList<String>() ;
			
			for( Iterator<Object> elements = selection.iterator() ; elements.hasNext() ; ) {
				Object element = elements.next() ;
				IResource resource = null ;
				
				if( element instanceof IResource ) {
					resource = (IResource) element ;
				} else if( element instanceof IAdaptable ) {
					IAdaptable adaptable = (IAdaptable)element;
					resource = (IResource) adaptable.getAdapter( IResource.class ) ;
				}
				

				if( resource != null ) {
					File project = resource.getLocation().toFile() ;
					
					File umlRepo = new File( project , "uml" ) ;
					
					if( ! umlRepo.exists() ) {
							messages.add( "* Project " + project.getName() + " : not generating contribs since project doesn't have an uml directory" ) ;
					} else {
						
						try {
							win.run( true , true , new GenerateUMLContribOperation( this.shell , project ) ) ;
						} catch (InvocationTargetException e) {
							e.printStackTrace();
							MessageDialog.openError(
									shell,
									"Uml Plug-in",
									"Error occure while generating uml contribs" ) ;
						} catch (InterruptedException e) {
							e.printStackTrace();
							MessageDialog.openError(
									shell,
									"Uml Plug-in",
									"Error occure while generating uml contribs" ) ;
						}
					}
				} else {
					MessageDialog.openError(
							shell,
							"Uml Plug-in",
							"A project must be selected" ) ;
				}
			}

			if( ! messages.isEmpty() ) {
				StringBuffer sb = new StringBuffer() ;
				for( String message : messages ) {
					sb.append( message ) ;
					sb.append( "\n" ) ;
				}
				MessageDialog.openInformation(
						shell,
						"Uml Contrib Generation",
						sb.toString() ) ;
			}
			
		}
		
		
		
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

}
