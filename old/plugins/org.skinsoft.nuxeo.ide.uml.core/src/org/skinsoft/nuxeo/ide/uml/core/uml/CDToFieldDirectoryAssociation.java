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
import java.util.HashSet;
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
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.skinsoft.nuxeo.components.field.to.directory.association.AssociateType;
import org.skinsoft.nuxeo.components.field.to.directory.association.AssociationFactory;
import org.skinsoft.nuxeo.components.field.to.directory.association.DocumentRoot;
import org.skinsoft.nuxeo.ide.uml.core.util.TransformationsUtils;

/**
 * Generates field to directory association based on class diagrams.
 * This is generating a contribution to a skinsoft service.
 * 
 * @author nel
 *
 */
public class CDToFieldDirectoryAssociation extends CDAbstractSwitch {
	
	public static final String ASSOCIATE_FIELD_TO_DIRECTORY_EXTENSION_POINT = "associateFieldToDirectory";

	public static final String FIELD_TO_DIRECTORY_ASSOCIATION_TARGET = "org.skinsoft.platform.directories.fieldassoc.service.FieldToDirectoryAssociationServiceImpl";

	protected HashMap<String, List<String>> directoryToXpaths ;
	protected HashMap<String, HashSet<String>> xpathToDocType ;
	
	protected AssociationFactory associationFactory ;

	protected String packageName;
	
	public CDToFieldDirectoryAssociation( AssociationFactory associationFactory ) {
		this.directoryToXpaths = new HashMap<String, List<String>>() ;
		this.xpathToDocType = new HashMap<String, HashSet<String>>() ;
		this.associationFactory = associationFactory ;
	}
	
	/* ********************************
	 * Switch Methods
	 */
	

	@Override
	public EObject casePackage(Package object) {
		
		this.packageName = object.getName() ;
		
		for( EObject element : object.getPackagedElements() ) {
			this.doSwitch( element ) ;
		}
		
		return object ;
	}
	
	@Override
	public EObject caseAssociation( Association object ) {
		
		Type targetType = object.getEndTypes().get( 1 ) ;
		Property targetProperty = (Property) object.getFeatures().get( 1 ) ;
		
		if( 
				targetProperty.getAggregation() != null &&
				targetProperty.getAggregation().equals( AggregationKind.SHARED_LITERAL ) && 
				targetType instanceof Class && 
				this.isDirectoryInstance( (Class) targetType )
			) {
			
			String directory = TransformationsUtils.normaliseAttributeName( targetType.getName() ) ;
			if( this.directoryToXpaths.get( directory ) == null ) {
				this.directoryToXpaths.put( 
						directory , 
						new ArrayList<String>() 
					) ;
			}
			this.directoryToXpaths.get( directory ).addAll( 
					this.getXpaths( (Classifier) ((Property)object.getFeatures().get( 0 )).getType() , targetProperty.getName() ) 
				) ;
			
		}
		
		return object ;
	}
	
	/* ********************************
	 * Business Methods
	 */
	

	
	protected List<String> getXpaths( Classifier classifier , String path ) {
		ArrayList<String> result = new ArrayList<String>() ;
		
		if( classifier instanceof Class ) {
			// cas terminal schema:path
			String xpath = TransformationsUtils.normaliseAttributeName( classifier.getName() ) + ":" + path ;
			result.add( xpath ) ;
			
			// store xpath -> doctype info
			for( Association association : classifier.getAssociations() ) {
				Property targetProperty = (Property) association.getFeatures().get( 1 ) ;
				if( 
						targetProperty.getAggregation() != null &&
						targetProperty.getAggregation().equals( AggregationKind.COMPOSITE_LITERAL ) &&
						targetProperty.getType().equals( classifier )
					) {
					
					if( this.xpathToDocType.get( xpath ) == null ) {
						this.xpathToDocType.put( xpath , new HashSet<String>() ) ;
					}
					this.xpathToDocType.get( xpath ).add( ((Property)association.getFeatures().get( 0 )).getType().getName() ) ;
				}
			}
		} else if( classifier instanceof DataType ) {
			
			for( Association association : classifier.getAssociations() ) {
				Property targetProperty = (Property) association.getFeatures().get( 1 ) ;
				if( 
						targetProperty.getAggregation() != null &&
						targetProperty.getAggregation().equals( AggregationKind.COMPOSITE_LITERAL ) &&
						targetProperty.getType().equals( classifier )
					) {
					
					result.addAll( this.getXpaths( (Classifier) ((Property)association.getFeatures().get( 0 )).getType() , targetProperty.getName() + "/" + path ) ) ;
				}
			}
		}
		
		return result ;
	}
	

	protected DocumentRoot doGenerateFieldToDirectoryAssociationContrib() {
		DocumentRoot contrib = this.associationFactory.createDocumentRoot() ;
		
		contrib.setComponent( this.associationFactory.createComponentType() ) ;
		contrib.getComponent().setName( this.packageName + ".field.to.directory.associations" ) ;
		
		contrib.getComponent().setExtension( this.associationFactory.createExtensionType() ) ;
		contrib.getComponent().getExtension().setTarget( FIELD_TO_DIRECTORY_ASSOCIATION_TARGET ) ;
		contrib.getComponent().getExtension().setPoint( ASSOCIATE_FIELD_TO_DIRECTORY_EXTENSION_POINT ) ;
		
		for( String directory : this.directoryToXpaths.keySet() ) {
			for( String xpath : this.directoryToXpaths.get( directory ) ) {
				AssociateType association = this.associationFactory.createAssociateType() ;
				contrib.getComponent().getExtension().getAssociate().add( association ) ;
				
				association.setXpath( xpath ) ;
				association.setToDirectory( directory ) ;
				
//				if( this.xpathToDocType.get( xpath ) != null ) {
//					for( String type : this.xpathToDocType.get( xpath ) ) {
//						association.getType().add( type ) ;
//					}
//				}
			}
		}
		
		return contrib ;
	}
	
	public void generateFieldToDirectoryAssociationContrib( File contribFile ) throws IOException {
		DocumentRoot contrib = this.doGenerateFieldToDirectoryAssociationContrib() ;
		
		XMLResourceImpl coreTypesResource = new XMLResourceImpl( URI.createFileURI( contribFile.getAbsolutePath() ) ) ;
		coreTypesResource.getContents().add( contrib ) ;
		
		HashMap<String, Object> options = new HashMap<String, Object>() ;
		options.put( XMLResource.OPTION_ENCODING , "UTF-8" ) ;
		options.put( XMLResource.OPTION_ROOT_OBJECTS , Collections.singletonList( contrib.getComponent() ) ) ;
		
		XMLMap xmlMap = new XMLMapImpl() ;
		options.put( XMLResource.OPTION_XML_MAP, xmlMap ) ;
		
		XMLInfo xmlInfo = new XMLInfoImpl() ;
		xmlInfo.setName( "component" ) ;
		xmlInfo.setTargetNamespace( null ) ;
		xmlMap.add( this.associationFactory.getAssociationPackage().getComponentType() , xmlInfo ) ;
		
		xmlInfo = new XMLInfoImpl() ;
		xmlInfo.setXMLRepresentation( XMLInfo.ELEMENT ) ;
		xmlMap.add( this.associationFactory.getAssociationPackage().getAssociateType_Type() , xmlInfo ) ;
		
		coreTypesResource.save( options ) ;
	}

}
