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
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDCompositor;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDFactory;
import org.eclipse.xsd.XSDForm;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.util.XSDConstants;
import org.eclipse.xsd.util.XSDResourceImpl;
import org.eclipse.xsd.util.XSDSchemaBuildingTools;
import org.skinsoft.nuxeo.ide.uml.core.util.TransformationsUtils;

/**
 * Generates a bunch of xml schemas from a collection of class diagrams
 * @author nel
 *
 */
public class CDToXSDSwitch extends CDAbstractSwitch {
	
	/**
	 * Utility method to get the prefix for the target namespace
	 * @param schema
	 * @return
	 */
	static String getSchemaPrefix( XSDSchema schema ) {
		for( String key : schema.getQNamePrefixToNamespaceMap().keySet() ) {
			String value = schema.getQNamePrefixToNamespaceMap().get( key ) ;
			if( value != null && value.equals( schema.getTargetNamespace() ) ) {
				return key ;
			}
		}
		return null ;
	}
	
	protected XSDFactory xsdFactory ;
	protected List<XSDSchema> documentPartSchemas ;

	protected List<XSDSchema> directorySchemas ;

	protected String packageName ;
	protected String targetNamespace ;
	
	protected Map<XSDSchema, Map<String, XSDComplexTypeDefinition>> complexTypesDefinitions ;
	protected Map<XSDSchema, Map<String, XSDSimpleTypeDefinition>> simpleListTypesDefinitions ;
	
	
	public CDToXSDSwitch( XSDFactory xsdFactory ) {
		super();
		this.xsdFactory = xsdFactory ;
		
		this.documentPartSchemas = new ArrayList<XSDSchema>() ;
		this.directorySchemas = new ArrayList<XSDSchema>() ;
		this.complexTypesDefinitions = new HashMap<XSDSchema, Map<String,XSDComplexTypeDefinition>>() ;
		this.simpleListTypesDefinitions = new HashMap<XSDSchema, Map<String,XSDSimpleTypeDefinition>>() ;
	}
	
	
	/* *************************************************************************
	 * Getters/Setters methods
	 */

	public List<XSDSchema> getDocumentPartSchemas() {
		return documentPartSchemas;
	}
	
	public List<XSDSchema> getDirectorySchemas() {
		return directorySchemas;
	}
	
	/* *************************************************************************
	 * Business methods
	 */
	
	
	/**
	 * Creates an xml schema representing a document part.
	 * @param object
	 */
	protected void createDocumentPartSchema( Class object ) {
		assert this.isDocumentPart( object ) ;
		
		XSDSchema schema = this.xsdFactory.createXSDSchema() ;
		this.documentPartSchemas.add( schema ) ;
		
		this.computeTargetNamespace( schema , object ) ;
		this.computeSchemaAttributes( schema , object ) ;
		
	}
	
	/**
	 * Creates a xml schema for a directory
	 * @param object
	 */
	protected void createDirectorySchema( DataType object ) {
		assert this.isDirectory( object ) ;
		
		XSDSchema schema = this.xsdFactory.createXSDSchema() ;
		this.directorySchemas.add( schema ) ;
		
		this.computeTargetNamespace( schema , object ) ;
		this.computeSchemaAttributes( schema , object ) ;
		
	}
	
	

	protected void computeSchemaAttributes(XSDSchema schema, Classifier object) {
		this.computeSimpleTypeElements( schema, object ) ;
		this.computeComplexTypeElements( schema , object ) ;
		this.computeDirectoryReferenceElements( schema , object ) ;
	}
	
	
	
	
	/**
	 * Add element at the root of the schema for attribute definitions
	 * @param schema
	 * @param object
	 */
	protected void computeSimpleTypeElements( XSDSchema schema , Classifier object ) {
		for( Property attribute : object.getAllAttributes() ) {
			XSDTypeDefinition typeDefinition = this.getXSDSimpleType( attribute , schema ) ;
			if( typeDefinition != null ) {
				XSDElementDeclaration element = this.xsdFactory.createXSDElementDeclaration() ;
				
				element.setName( attribute.getName() ) ;
				element.setTypeDefinition( typeDefinition ) ;
				
				schema.getContents().add( element ) ;
			} else {
				System.out.println( "type def is null for " + attribute.getType() ) ;
			}
		}
	}
	
	/**
	 * Create complex types and add complex type element at the schema's root
	 * @param schema
	 * @param object
	 */
	protected void computeComplexTypeElements( XSDSchema schema , Classifier object ) {
		for( Association association : object.getAssociations() ) {
			if( object.equals( association.getEndTypes().get( 0 ) ) ) {
				
				Type targetType = association.getEndTypes().get( 1 ) ;
				Property targetProperty = (Property) association.getFeatures().get( 1 ) ;
				
				if( targetProperty.getAggregation() != null ) {
					if(
							targetProperty.getAggregation().equals( AggregationKind.COMPOSITE_LITERAL ) &&
							targetType instanceof DataType 
						) {
						
						XSDComplexTypeDefinition complexType = this.getComplexType( targetProperty , (DataType) targetType , schema ) ;
						
						if( targetProperty.getUpper() == -1 || targetProperty.getUpper() > 1 ) {
							complexType = this.getComplexTypeList( complexType, schema ) ;
						}
						
						XSDElementDeclaration element = this.xsdFactory.createXSDElementDeclaration() ;
						
						element.setName( targetProperty.getName() ) ;
						element.setTypeDefinition( complexType ) ;
						
						schema.getContents().add( element ) ;
					}
				}
				
			}
		}
	}
	

	/**
	 * <p>Create schema's root element designed to point to directory entry</p>
	 * <p>In facts, only create a string element to store the entry's id</p>
	 * @param schema
	 * @param object
	 */
	protected void computeDirectoryReferenceElements( XSDSchema schema , Classifier object ) {
		for( Association association : object.getAssociations() ) {
			if( object.equals( association.getEndTypes().get( 0 ) ) ) {
				
				Type targetType = association.getEndTypes().get( 1 ) ;
				Property targetProperty = (Property) association.getFeatures().get( 1 ) ;
				
				if( targetProperty.getAggregation() != null ) {
					if( 
							targetProperty.getAggregation().equals( AggregationKind.SHARED_LITERAL ) && 
							targetType instanceof Class && 
							this.isDirectoryInstance( (Class) targetType )
						) {
						XSDElementDeclaration element = this.xsdFactory.createXSDElementDeclaration() ;
						
						element.setName( targetProperty.getName() ) ;
						
						XSDSimpleTypeDefinition stringType = schema.getSchemaForSchema().resolveSimpleTypeDefinition( "string" ) ;
						if( targetProperty.getUpper() == -1 || targetProperty.getUpper() > 1 ) {
							element.setTypeDefinition( this.getXSDSimpleTypeList( stringType , schema ) ) ;
						} else {
							element.setTypeDefinition( stringType ) ;
						}
						
						schema.getContents().add( element ) ;
					}
				}
				
			}
		}
	}
	
	/**
	 * <p>Returns a complex type definition for the given data type</p>
	 * <p>Create if necessary</p>
	 * <p>Create nested complex types</p>
	 * @param property
	 * @param type
	 * @param schema
	 * @return
	 */
	protected XSDComplexTypeDefinition getComplexType( Property property , DataType type , XSDSchema schema ) {
		if( this.complexTypesDefinitions.get(schema ) == null ) {
			this.complexTypesDefinitions.put( schema , new HashMap<String, XSDComplexTypeDefinition>() ) ;
		}
		
		if( this.complexTypesDefinitions.get( schema ).get( type.getName() ) == null ) {
			XSDComplexTypeDefinition complexType;
			complexType = this.xsdFactory.createXSDComplexTypeDefinition() ;
			complexType.setName( TransformationsUtils.normaliseAttributeName( type.getName() ) ) ;
			
			XSDModelGroup modelGroup = this.xsdFactory.createXSDModelGroup() ;
			modelGroup.setCompositor( XSDCompositor.SEQUENCE_LITERAL ) ;
			
			XSDParticle part = this.xsdFactory.createXSDParticle() ;
			part.setContent( modelGroup ) ;
			
			complexType.setContent( part ) ;
			
			schema.getContents().add( complexType ) ;
			
			this.complexTypesDefinitions.get( schema ).put( type.getName() , complexType ) ;
			
			for( Property attribute : type.getAllAttributes() ) {
				XSDTypeDefinition typeDefinition = this.getXSDSimpleType( attribute , schema ) ;
				if( typeDefinition != null ) {
					XSDElementDeclaration element = this.xsdFactory.createXSDElementDeclaration() ;
					
					element.setName( attribute.getName() ) ;
					element.setTypeDefinition( typeDefinition ) ;
					
					schema.getElementDeclarations().add( element ) ;
					XSDParticle elementPart = this.xsdFactory.createXSDParticle() ;
					elementPart.setContent( element ) ;
					modelGroup.getContents().add( elementPart ) ;
				} else {
					System.out.println( "type def is null for " + attribute.getType() ) ;
				}
			}
			
			this.computeComplexTypeComplexTypeElements( complexType , modelGroup , type, schema ) ;
			this.computeComplexTypeDirectoryReferenceElements( complexType , modelGroup , type , schema ) ;
		}
		
		
		return this.complexTypesDefinitions.get( schema ).get( type.getName() );
	}
	

	protected XSDComplexTypeDefinition getComplexTypeList( XSDTypeDefinition complexType , XSDSchema schema ) {
		if( this.complexTypesDefinitions.get(schema ) == null ) {
			this.complexTypesDefinitions.put( schema , new HashMap<String, XSDComplexTypeDefinition>() ) ;
		}
		
		String complexListName = TransformationsUtils.normaliseAttributeName( complexType.getName() ) + "List" ;
		
		if( this.complexTypesDefinitions.get( schema ).get( complexListName ) == null ) {
			XSDComplexTypeDefinition complexListType = this.xsdFactory.createXSDComplexTypeDefinition() ;
			complexListType.setName( complexListName ) ;
			
			XSDModelGroup modelGroup = this.xsdFactory.createXSDModelGroup() ;
			modelGroup.setCompositor( XSDCompositor.SEQUENCE_LITERAL ) ;
			
			XSDParticle part = this.xsdFactory.createXSDParticle() ;
			part.setContent( modelGroup ) ;
			
			complexListType.setContent( part ) ;
			
			XSDElementDeclaration element = this.xsdFactory.createXSDElementDeclaration() ;
			element.setName( "item" ) ;
			element.setTypeDefinition( complexType ) ;
			XSDParticle elementPart = this.xsdFactory.createXSDParticle() ;
			elementPart.setContent( element ) ;
			elementPart.setMinOccurs( 0 ) ;
			elementPart.setMaxOccurs( XSDParticle.UNBOUNDED ) ;
			modelGroup.getContents().add( elementPart ) ;
			
			schema.getContents().add( complexListType ) ;
			this.complexTypesDefinitions.get( schema ).put( complexListName , complexListType ) ;
		}
		
		return this.complexTypesDefinitions.get( schema ).get( complexListName );
	}
	
	/**
	 * Create nested complex types and add complex type element in the complex type
	 * 
	 * @param complexType
	 * @param modelGroup
	 * @param type
	 * @param schema
	 */
	protected void computeComplexTypeComplexTypeElements(
			XSDComplexTypeDefinition complexType, 
			XSDModelGroup modelGroup,
			DataType type, 
			XSDSchema schema ) {
		
		for( Association association : type.getAssociations() ) {
			if( type.equals( association.getEndTypes().get( 0 ) ) ) {
				
				Type targetType = association.getEndTypes().get( 1 ) ;
				Property targetProperty = (Property) association.getFeatures().get( 1 ) ;
				
				if( targetProperty.getAggregation() != null ) {
					if(
							targetProperty.getAggregation().equals( AggregationKind.COMPOSITE_LITERAL ) &&
							targetType instanceof DataType 
						) {
						
						XSDComplexTypeDefinition nestedComplexType = this.getComplexType( targetProperty , (DataType) targetType , schema ) ;
						
						if( targetProperty.getUpper() == -1 || targetProperty.getUpper() > 1 ) {
							nestedComplexType = this.getComplexTypeList( nestedComplexType, schema ) ;
						}
						
						XSDElementDeclaration element = this.xsdFactory.createXSDElementDeclaration() ;
						
						element.setName( targetProperty.getName() ) ;
						element.setTypeDefinition( nestedComplexType ) ;
						
						schema.getElementDeclarations().add( element ) ;
						XSDParticle elementPart = this.xsdFactory.createXSDParticle() ;
						elementPart.setContent( element ) ;
						modelGroup.getContents().add( elementPart ) ;
					}
				}
				
			}
		}
		
	}


	/**
	 * <p>Create complex type element designed to point to directory entry</p>
	 * <p>In facts, only create a string element to store the entry's id</p>
	 * 
	 * @param complexType
	 * @param type
	 * @param schema
	 */
	protected void computeComplexTypeDirectoryReferenceElements(
			XSDComplexTypeDefinition complexType, 
			XSDModelGroup modelGroup ,
			DataType type,
			XSDSchema schema ) {
		
		for( Association association : type.getAssociations() ) {
			if( type.equals( association.getEndTypes().get( 0 ) ) ) {
				
				Type targetType = association.getEndTypes().get( 1 ) ;
				Property targetProperty = (Property) association.getFeatures().get( 1 ) ;
				
				if( targetProperty.getAggregation() != null ) {
					if( 
							targetProperty.getAggregation().equals( AggregationKind.SHARED_LITERAL ) && 
							targetType instanceof Class && 
							this.isDirectoryInstance( (Class) targetType )
						) {
						XSDElementDeclaration element = this.xsdFactory.createXSDElementDeclaration() ;
						
						element.setName( targetProperty.getName() ) ;
						
						XSDSimpleTypeDefinition stringType = schema.getSchemaForSchema().resolveSimpleTypeDefinition( "string" ) ;
						if( targetProperty.getUpper() == -1 || targetProperty.getUpper() > 1 ) {
							element.setTypeDefinition( this.getXSDSimpleTypeList( stringType , schema ) ) ;
						} else {
							element.setTypeDefinition( stringType ) ;
						}
						
						schema.getElementDeclarations().add( element ) ;
						XSDParticle elementPart = this.xsdFactory.createXSDParticle() ;
						elementPart.setContent( element ) ;
						modelGroup.getContents().add( elementPart ) ;
					}
				}
				
			}
		}
		
	}
	
	 


	protected void computeTargetNamespace(XSDSchema schema, Classifier object) {
		String nameSpace = this.targetNamespace + TransformationsUtils.normaliseAttributeName( object.getName() ) ;
		
		schema.setTargetNamespace( nameSpace ) ;
		schema.setElementFormDefault( XSDForm.QUALIFIED_LITERAL ) ;
		schema.setAttributeFormDefault( XSDForm.UNQUALIFIED_LITERAL ) ;
		
		String schemaPrefix = TransformationsUtils.normaliseAttributeName( object.getName() ) ;
		
		schema.setSchemaForSchemaQNamePrefix( "xs" ) ;
		
		Map<String, String> qNamePrefixToNamespaceMap = schema.getQNamePrefixToNamespaceMap() ;
	    qNamePrefixToNamespaceMap.put( schemaPrefix , schema.getTargetNamespace() );
	    qNamePrefixToNamespaceMap.put( schema.getSchemaForSchemaQNamePrefix(), XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001 ) ;
	}
	
	
	
	/* *************************************************************************
	 * Switch methods
	 */
	

	@Override
	public EObject casePackage( Package object ) {
		
		this.packageName = object.getName() ;
		
		this.targetNamespace = "http://" ;
		
		String [] splitted = this.packageName.split( "\\." ) ;
		for( int i = splitted.length - 1 ; i >= 0 ; i-- ) {
			this.targetNamespace += splitted[i] ;
			if( i > 0 ) {
				this.targetNamespace += "." ;
			}
		}
		
		this.targetNamespace += "/schemas/" ;
		
		for( EObject element : object.getPackagedElements() ) {
			this.doSwitch( element ) ;
		}
		
		return object ;
	}

	@Override
	public EObject caseClass(Class object) {
		if( object.isAbstract() ) {
			return object ;
		}
		
		if( this.isDocumentPart( object ) ) {
			this.createDocumentPartSchema( object ) ;
		} else {
			return null ;
		}
		
		return object ;
	}

	@Override
	public EObject caseDataType(DataType object) {
		if( object.isAbstract() ) {
			return object ;
		}
		
		if( this.isDirectory( object ) ) {
			this.createDirectorySchema( object ) ;
		}
		
		return object ;
	}
	

	/* *************************************************************************
	 * Utility methods
	 */
	
	protected XSDTypeDefinition getXSDSimpleType( Property attribute , XSDSchema schema ) {
		PrimitiveType type = null ;
		if( attribute.getType() instanceof PrimitiveType ) {
			type = (PrimitiveType) attribute.getType() ;
		} else {
			System.err.println( "Dont know what to do with type " + attribute.getType() );
		}
		
		XSDTypeDefinition simpleType = null ;
		
		if( type.getName().equals( "String" ) ) {
			simpleType = schema.getSchemaForSchema().resolveSimpleTypeDefinition( "string" ) ;
		} else if( type.getName().endsWith( "Integer" ) ) {
			simpleType = schema.getSchemaForSchema().resolveSimpleTypeDefinition( "int" ) ;
		} else if( type.getName().endsWith( "EDate" ) ) {
			simpleType = schema.getSchemaForSchema().resolveSimpleTypeDefinition( "date" ) ;
		} else if( type.getName().endsWith( "Float" ) ) {
			simpleType = schema.getSchemaForSchema().resolveSimpleTypeDefinition( "float" ) ;
		} else if( type.getName().endsWith( "Boolean" ) ) {
			simpleType = schema.getSchemaForSchema().resolveSimpleTypeDefinition( "boolean" ) ;
		} else {
			System.err.println( "notype for _" + type.getName() + "_" ) ;
		}
		
		if( attribute.getUpper() > 1 || attribute.getUpper() == -1 ) {
			return  this.getXSDSimpleTypeList( simpleType , schema ) ;
		} else {
			return simpleType ;
		}
	}


	protected XSDSimpleTypeDefinition getXSDSimpleTypeList( XSDTypeDefinition simpleType , XSDSchema schema ) {
		if( this.simpleListTypesDefinitions.get( schema ) == null ) {
			this.simpleListTypesDefinitions.put( schema , new HashMap<String, XSDSimpleTypeDefinition>() ) ;
		}
		
		String listTypeName = simpleType.getName() + "List" ;
		
		if( this.simpleListTypesDefinitions.get( schema ).get( listTypeName ) == null ) {
			XSDSimpleTypeDefinition listType = this.xsdFactory.createXSDSimpleTypeDefinition() ;
			listType.setName( listTypeName ) ;
			listType.setItemTypeDefinition( (XSDSimpleTypeDefinition) simpleType ) ;
			
			schema.getContents().add( listType ) ;
			this.simpleListTypesDefinitions.get( schema ).put( listTypeName , listType ) ;
		}
		
		return this.simpleListTypesDefinitions.get( schema ).get( listTypeName );
	}
	
	
	/* *************************************************************************
	 * Generation methods
	 */
	
	public void generateDocumentPartSchemas( File schemaRepository ) {
		for( XSDSchema schema : this.getDocumentPartSchemas() ) {
			File xsd = new File( schemaRepository , getSchemaPrefix( schema ) + ".xsd" ) ;
			XSDResourceImpl xsdResource = 
				new XSDResourceImpl( 
						URI.createFileURI( xsd.getAbsolutePath() ) ) ;
			xsdResource.getContents().add( schema ) ;
			try {
				xsdResource.save( Collections.EMPTY_MAP ) ;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void generateDirectorySchemas( File schemaRepository ) {
		for( XSDSchema schema : this.getDirectorySchemas() ) {
			File xsd = new File( schemaRepository , getSchemaPrefix( schema ) + ".xsd" ) ;
			XSDResourceImpl xsdResource = 
				new XSDResourceImpl( 
						URI.createFileURI( xsd.getAbsolutePath() ) ) ;
			xsdResource.getContents().add( schema ) ;
			try {
				xsdResource.save( Collections.EMPTY_MAP ) ;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void generateAllSchemas( File schemaRepository ) {
		this.generateDirectorySchemas( schemaRepository ) ; 
		this.generateDocumentPartSchemas( schemaRepository ) ;
	}
	
	
	
	
	
	
	
	static public void main( String [] args ) {
		if( args.length < 1 ) throw new RuntimeException() ;
		
		File uml = new File( args[0] ) ;
		if( ! uml.getName().endsWith( ".uml" ) ) {
			throw new RuntimeException( "must provide uml use case diagram file" ) ;
		}
		
		XSDFactory schemasFactory = XSDSchemaBuildingTools.getXSDFactory() ;
		
		CDToXSDSwitch sw = new CDToXSDSwitch( schemasFactory ) ;
		
		ResourceSet resourceSet = new ResourceSetImpl() ;
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				UMLResource.FILE_EXTENSION , 
			    UMLResource.Factory.INSTANCE
			   ) ;
		
		Resource resource = resourceSet.getResource( URI.createFileURI( args[0] ) , true ) ;
		sw.doSwitch( ((UMLResource)resource).getContents().get( 0 ) ) ;
		
		File schemaRepository = new File( "/home/nel/Bureau/dudu/" ) ;
		
		sw.generateAllSchemas( schemaRepository ) ;
		
	}
}
