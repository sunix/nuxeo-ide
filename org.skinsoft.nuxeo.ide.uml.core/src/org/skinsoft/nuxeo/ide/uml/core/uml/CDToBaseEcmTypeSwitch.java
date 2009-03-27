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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLResource.XMLInfo;
import org.eclipse.emf.ecore.xmi.XMLResource.XMLMap;
import org.eclipse.emf.ecore.xmi.impl.XMLInfoImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.skinsoft.nuxeo.components.ecmtypes.EcmtypesFactory;
import org.skinsoft.nuxeo.components.ecmtypes.TypeType;
import org.skinsoft.nuxeo.ide.uml.core.util.TransformationsUtils;

/**
 * Generates an ecm-type contrib based on a collection of class diagrams.
 * 
 * @author nel
 *
 */
public class CDToBaseEcmTypeSwitch extends CDAbstractSwitch {
	
	static public final String ECM_TYPES_SUFFIX = ".uml.ecm.types";
	static public final String TARGET_TYPE_SERVICE = "org.nuxeo.ecm.platform.types.TypeService" ;
	static public final String EXTENSION_POINT_TYPES = "types" ;
	
	protected String packageName;
	
	protected EcmtypesFactory ecmFactory ;
	protected org.skinsoft.nuxeo.components.ecmtypes.DocumentRoot ecmContrib ;
	

	protected HashMap<String, TypeType> types ;
	

	
	public CDToBaseEcmTypeSwitch(EcmtypesFactory ecmFactory) {
		super();
		this.ecmFactory = ecmFactory;
		
		this.types = new HashMap<String, TypeType>() ;
	}
	

	public org.skinsoft.nuxeo.components.ecmtypes.DocumentRoot getEcmContrib() {
		return ecmContrib;
	}
	
	/* *************************************************************************
	 * Business methods
	 */


	private void computeTypeDeclaration(Class object) {
		TypeType type = this.ecmFactory.createTypeType() ;
		this.ecmContrib.getComponent().getExtension().getType().add( type ) ;
		
		String name = TransformationsUtils.normaliseTypeName( object.getName() ) ;
		
		type.setId( name ) ;
//		type.setLabel( name ) ;
//		type.setDefaultView( "view_documents" ) ;
		
		this.types.put( name , type ) ;
	}
	

	private void computeContainmentType(Class object) {
		
		TypeType type = this.types.get( object.getName() ) ;
		if( type == null ) {
			type = this.ecmFactory.createTypeType() ;
			type.setId( object.getName() ) ;
			this.ecmContrib.getComponent().getExtension().getType().add( type ) ;
			this.types.put( object.getName() , type ) ;
		}
		
		List<Type> containedTypes = this.getSubtypeProperties( object ) ;
		if( ! containedTypes.isEmpty() ) {
			if( type.getSubtypes() == null ) {
				type.setSubtypes( this.ecmFactory.createSubtypesType() ) ;
			}
			for( Type containedType : containedTypes ) {
				type.getSubtypes().getType().add( containedType.getName() ) ;
			}
		}
		
		
	}
	
	/* *************************************************************************
	 * Utility methods
	 */
	
	protected List<Type> getSubtypeProperties( Class object ) {
		ArrayList<Type> result = new ArrayList<Type>() ;
		
		for( Association association : object.getAssociations() ) {
			if( object.equals( association.getEndTypes().get( 0 ) ) ) {
				
				Type targetType = association.getEndTypes().get( 1 ) ;
				Property targetProperty = (Property) association.getFeatures().get( 1 ) ;
				
				if( targetProperty.getAggregation() != null ) {
					if( targetProperty.getAggregation().equals( AggregationKind.SHARED_LITERAL ) ) {
						result.add( targetType ) ;
					}
				}
			}
		}
		
		return result ;
	}
	
	protected void initEcmContrib() {
		if( this.ecmContrib == null ) {
			this.ecmContrib = this.ecmFactory.createDocumentRoot() ;
			
			this.ecmContrib.setComponent( this.ecmFactory.createComponentType() ) ;
			this.ecmContrib.getComponent().setName( this.packageName + ECM_TYPES_SUFFIX ) ;
			
			this.ecmContrib.getComponent().setExtension( this.ecmFactory.createExtensionType() ) ;
			this.ecmContrib.getComponent().getExtension().setTarget( TARGET_TYPE_SERVICE ) ;
			this.ecmContrib.getComponent().getExtension().setPoint( EXTENSION_POINT_TYPES ) ;
		}
	}
	
	/* *************************************************************************
	 * Switch methods
	 */

	@Override
	public EObject casePackage(Package object) {
		this.packageName = object.getName() ;
		
		this.initEcmContrib() ;
		
		for( EObject element : object.getPackagedElements() ) {
			this.doSwitch( element ) ;
		}
		
		return object ;
	}
	
	
	@Override
	public EObject caseClass(Class object) {
		
		if( ! object.isAbstract() ) {
			this.computeTypeDeclaration( object ) ;
		}
		this.computeContainmentType( object ) ;
		
		return object ;
	}
	

	
	/* *************************************************************************
	 * Contribution generation methods
	 */

	public void generateEcmTypesContrib( File ecmTypeContribFile ) throws IOException {
		XMLResourceImpl ecmTypesResource = new XMLResourceImpl( URI.createFileURI( ecmTypeContribFile.getAbsolutePath() ) ) ;
		ecmTypesResource.getContents().add( this.ecmContrib ) ;
		
		HashMap<String, Object> options = new HashMap<String, Object>() ;
		options.put( XMLResource.OPTION_ENCODING , "UTF-8" ) ;
		options.put( XMLResource.OPTION_ROOT_OBJECTS , Collections.singletonList( this.ecmContrib.getComponent() ) ) ;
		
		XMLMap xmlMap = new XMLMapImpl() ;
		options.put( XMLResource.OPTION_XML_MAP, xmlMap ) ;
		
		XMLInfo xmlInfo = new XMLInfoImpl() ;
		xmlInfo.setName( "component" ) ;
		xmlInfo.setTargetNamespace( null ) ;
		xmlMap.add( this.ecmFactory.getEcmtypesPackage().getComponentType() , xmlInfo ) ;
		
		xmlInfo = new XMLInfoImpl() ;
		xmlInfo.setName( "default-view" ) ;
		xmlInfo.setTargetNamespace( null ) ;
		xmlInfo.setXMLRepresentation( XMLInfo.ELEMENT ) ;
		xmlMap.add( this.ecmFactory.getEcmtypesPackage().getTypeType_DefaultView() , xmlInfo ) ;
		
		xmlInfo = new XMLInfoImpl() ;
		xmlInfo.setXMLRepresentation( XMLInfo.ELEMENT ) ;
		xmlMap.add( this.ecmFactory.getEcmtypesPackage().getTypeType_Icon(), xmlInfo ) ;
		xmlMap.add( this.ecmFactory.getEcmtypesPackage().getTypeType_Label(), xmlInfo ) ;
		
		ecmTypesResource.save( options ) ;
	}
	
	
	
}
