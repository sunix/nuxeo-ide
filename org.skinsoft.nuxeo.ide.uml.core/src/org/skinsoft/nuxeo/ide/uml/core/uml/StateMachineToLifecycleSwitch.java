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
package org.skinsoft.nuxeo.ide.uml.core.uml;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLResource.XMLInfo;
import org.eclipse.emf.ecore.xmi.XMLResource.XMLMap;
import org.eclipse.emf.ecore.xmi.impl.XMLInfoImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.internal.resource.UML22UMLResourceFactoryImpl;
import org.eclipse.uml2.uml.internal.resource.UMLResourceImpl;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.util.UMLSwitch;
import org.skinsoft.nuxeo.components.lifecycle.ExtensionType;
import org.skinsoft.nuxeo.components.lifecycle.LifecycleFactory;
import org.skinsoft.nuxeo.components.lifecycle.LifecycleType;
import org.skinsoft.nuxeo.components.lifecycle.StateType;
import org.skinsoft.nuxeo.components.lifecycle.TransitionType;
import org.skinsoft.nuxeo.components.lifecycle.TransitionsType;
import org.skinsoft.nuxeo.ide.uml.core.exception.TransformationException;

/**
 * Generates life cycle definitions based on state machine diagrams
 * 
 * @author nel
 *
 */
public class StateMachineToLifecycleSwitch extends UMLSwitch<EObject> {
	
	static public final String TARGET_SERVICE = "org.nuxeo.ecm.core.lifecycle.LifeCycleService" ;
	static public final String EXTENSION_POINT = "lifecycle" ;
	
	static public final String LIFECYCLE_MANAGER = "jcrlifecyclemanager" ;
	
	private LifecycleFactory lifecycleFactory ;
	private org.skinsoft.nuxeo.components.lifecycle.DocumentRoot lifecycleContrib ;
	
	protected ExtensionType lifecycleExtension ;
	
	protected Stack<LifecycleType> workingLifecycle ;
	
	//Configuration
	private String contributionPackage ;
	
	public StateMachineToLifecycleSwitch(LifecycleFactory lifecycleFactory) {
		super();
		this.lifecycleFactory = lifecycleFactory;
	}

	@Override
	public EObject caseStateMachine(StateMachine object) {
		System.out.println( "StateMachine : " + object.getName() ) ;
		
		if( this.lifecycleContrib == null ) {
			this.lifecycleContrib = this.lifecycleFactory.createDocumentRoot() ;
			
			this.lifecycleContrib.setComponent( this.lifecycleFactory.createComponentType() ) ;
			this.lifecycleContrib.getComponent().setName( this.contributionPackage + ".lifecycle.definition" ) ;
		}
		
		if( this.lifecycleExtension == null ) {
			this.lifecycleExtension = this.lifecycleFactory.createExtensionType() ;
			this.lifecycleContrib.getComponent().getExtension().add( this.lifecycleExtension ) ;
			this.lifecycleExtension.setTarget( TARGET_SERVICE ) ;
			this.lifecycleExtension.setPoint( EXTENSION_POINT ) ;
		}
		
		if( this.workingLifecycle == null ) {
			this.workingLifecycle = new Stack<LifecycleType>() ;
		}
		
		
		this.workingLifecycle.push( this.lifecycleFactory.createLifecycleType() ) ;
		this.lifecycleExtension.getLifecycle().add( this.workingLifecycle.peek() ) ;
		
		this.workingLifecycle.peek().setName( object.getName() ) ;
		this.workingLifecycle.peek().setLifecyclemanager( LIFECYCLE_MANAGER ) ;
		
		
		for( Region region : object.getRegions() ) {
			this.doSwitch( region ) ;
			
		}
		
		this.workingLifecycle.pop() ;
		
		return object ;
	}
	
	@Override
	public EObject caseRegion(Region object) {
		System.out.println( "Region : " + object.getName() ) ;
		
		for( Transition transition : object.getTransitions() ) {
			this.doSwitch( transition ) ;
		}
		
		for( Vertex vertex : object.getSubvertices() ) {
			this.doSwitch( vertex ) ;
		}
		
		return object ;
	}

	
	@Override
	public EObject caseTransition(Transition object) {
		System.out.println( "Transition : " + object.getName() ) ;
		
		if( this.isNullOrEmpty( object.getName() ) ) {
			if( ! (object.getSource() instanceof Pseudostate) ) {
				throw new TransformationException( "Transitions must be named" ) ;
			}
		}
		
		if( object.getSource() instanceof Pseudostate ) {
			// Transition from start state ignored
			return object ;
		}
		
		if( object.getTarget() == null || this.isNullOrEmpty( object.getTarget().getName() ) ) {
			throw new TransformationException( "Transition must have a named target (" + object.getName() + ")" ) ;
		}
		
		if( this.workingLifecycle.peek().getTransitions() == null ) {
			this.workingLifecycle.peek().setTransitions( this.lifecycleFactory.createTransitionsType() ) ;
		}
		
		TransitionType transition = this.lifecycleFactory.createTransitionType() ;
		transition.setName( object.getName() ) ;
		transition.setDestinationState( object.getTarget().getName() ) ;
		
		this.workingLifecycle.peek().getTransitions().getTransition().add( transition ) ;
		
		return object ;
	}
	
	

	@Override
	public EObject caseState(State object) {
		System.out.println( "State : " + object.getName() ) ;
		
		if( this.isNullOrEmpty( object.getName() ) ) {
			throw new TransformationException( "State must be named" ) ;
		}
		
		if( this.workingLifecycle.peek().getStates() == null ) {
			this.workingLifecycle.peek().setStates( this.lifecycleFactory.createStatesType() ) ;
		}
		
		StateType state = this.lifecycleFactory.createStateType() ;
		this.workingLifecycle.peek().getStates().getState().add( state ) ;
		state.setName( object.getName() ) ;
		
		if( ! this.isNullOrEmpty( object.getOutgoings() ) ) {
			if( state.getTransitions() == null ) {
				state.setTransitions( this.lifecycleFactory.createStateTransitionsType() ) ;
			}
			
			for( Transition outgoing : object.getOutgoings() ) {
				state.getTransitions().getTransition().add( outgoing.getName() ) ;
			}
			
		}
		
		return object ;
	}
	
	
	
	

	@Override
	public EObject casePseudostate(Pseudostate object) {
		System.out.println( "Pseudostate : " + object.getKind() ) ;
		
		if( PseudostateKind.INITIAL_LITERAL.equals( object.getKind() ) ) {
			String initialStateName = object.getOutgoings().get( 0 ).getTarget().getName() ;
			this.workingLifecycle.peek().setInitial( initialStateName ) ;
		}
		
		return object ;
	}

	
	

	private boolean isNullOrEmpty( String str ) {
		return str == null || "".equals( str.trim() ) ;
	}
	private boolean isNullOrEmpty( Collection<?> c ) {
		return c == null || c.isEmpty() ;
	}

	public void setContributionPackage(String contributionPackage) {
		this.contributionPackage = contributionPackage;
	}
	

	public org.skinsoft.nuxeo.components.lifecycle.DocumentRoot getLifecycleContrib() {
		return lifecycleContrib;
	}
	

	public void generateLifecycleDefinitionContrib( File lifecycleDefinitionContribFile ) throws IOException {
		XMLResourceImpl xmlResource = new XMLResourceImpl( URI.createFileURI( lifecycleDefinitionContribFile.getAbsolutePath() ) ) ;
		xmlResource.getContents().add( this.getLifecycleContrib() ) ;
		
		HashMap<String, Object> options = new HashMap<String, Object>() ;
		options.put( XMLResource.OPTION_ENCODING , "UTF-8" ) ;
		options.put( XMLResource.OPTION_ROOT_OBJECTS , Collections.singletonList( this.getLifecycleContrib().getComponent() ) ) ;
		
		XMLMap xmlMap = new XMLMapImpl() ;
		options.put( XMLResource.OPTION_XML_MAP, xmlMap ) ;
		
		XMLInfo xmlInfo = new XMLInfoImpl() ;
		xmlInfo.setName( "component" ) ;
		xmlInfo.setTargetNamespace( null ) ;
		xmlMap.add( LifecycleFactory.eINSTANCE.getLifecyclePackage().getComponentType() , xmlInfo ) ;
		
		xmlResource.save( options ) ;
	}
	
	
}
