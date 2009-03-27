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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDElementDeclaration;
import org.skinsoft.nuxeo.components.actions.ActionsFactory;
import org.skinsoft.nuxeo.components.actions.DocumentRoot;
import org.skinsoft.nuxeo.components.actions.FilterType;
import org.skinsoft.nuxeo.components.coretypes.ComponentType;
import org.skinsoft.nuxeo.components.coretypes.CoretypesFactory;
import org.skinsoft.nuxeo.components.coretypes.DoctypeType;
import org.skinsoft.nuxeo.components.coretypes.ExtensionType;
import org.skinsoft.nuxeo.components.coretypes.FacetType;
import org.skinsoft.nuxeo.components.coretypes.SchemaType;
import org.skinsoft.nuxeo.components.directories.DirectoriesFactory;
import org.skinsoft.nuxeo.components.directories.DirectoryType;
import org.skinsoft.nuxeo.components.directories.TimestampType;
import org.skinsoft.nuxeo.components.lifecycle.LifecycleFactory;
import org.skinsoft.nuxeo.components.lifecycle.TypeType;
import org.skinsoft.nuxeo.components.search.IndexableDocTypeType;
import org.skinsoft.nuxeo.components.search.SearchFactory;
import org.skinsoft.nuxeo.ide.uml.core.util.TransformationsUtils;

/**
 * Generates core type contrib based on a collection of class diagrams
 * @author nel
 *
 */
public class CDToCoreTypeSwitch extends CDAbstractSwitch {
	
	private static final String LIFECYCLE_CONSTRAINT_PREFIX = "lifecycle=";
	
	private static final String DIRECTORY_REPLICATION_DEFAULT_CONSTRAINT_PREFIX = "directoryReplicationDefault=" ;
	private static final String DIRECTORY_REPLICATED_CONSTRAINT_PREFIX = "replicated=" ;
	
	
	static public final String TARGET_TYPE_SERVICE = "org.nuxeo.ecm.core.schema.TypeService" ;
	
	static public final String EXTENSION_POINT_SCHEMA = "schema" ;
	static public final String EXTENSION_POINT_DOCTYPE = "doctype" ;
	static public final String CORETYPE_COMPONENT_SUFFIX = ".uml.core.types" ;
	
	static public final String TARGET_LIFECYCLE_SERVICE = "org.nuxeo.ecm.core.lifecycle.LifeCycleService" ;
	static public final String EXTENSION_POINT_TYPES = "types" ;
	static public final String LIFECYCLE_COMPONENT_SUFFIX = ".uml.lifecycle" ;
	static public final String DEFAULT_LIFECYCLE = "default";
	
	static public final String TARGET_SEARCH_SERVICE = "org.nuxeo.ecm.core.search.service.SearchServiceImpl" ;
	static public final String EXTENSION_POINT_INDEXABLE_DOCTYPE = "indexableDocType" ;
	static public final String SEARCH_COMPONENT_SUFFIX = ".uml.search" ;
	
	static public final String TARGET_DIRECTORY_SERVICE = "org.nuxeo.ecm.directory.sql.SQLDirectoryFactory" ;
//	static public final String TARGET_REPLICATED_DIRECTORY_SERVICE = "org.skinsoft.platform.gears.directories.main.GearsReplicatedSQLDirectoryFactory" ;
	
	static public final String EXTENSION_POINT_DIRECTORIES = "directories" ;
	static public final String EXTENSION_POINT_TIMESTAMP = "timestamps" ;
	static public final String DIRECTORIES_COMPONENT_SUFFIX = ".uml.directories" ;
	static public final String DIRECTORY_CREATE_POLICY_ALWAYS = "always";
	static public final String DIRECTORY_CREATE_POLICY_ON_MISSING_COLUMN = "on_missing_columns" ;
	
	static public final String TARGET_ACTION_SERVICE = "org.nuxeo.ecm.platform.actions.ActionService" ;
	static public final String EXTENSION_POINT_ACTIONS = "actions" ;
	static public final String EXTENSION_POINT_FILTERS = "filters" ;
	
	static public final String TYPE_FILTERS_COMPONENT_SUFFIX = ".uml.type.filters" ;
	
	
	private CoretypesFactory coreTypesFactory ;
	private org.skinsoft.nuxeo.components.coretypes.DocumentRoot coreTypesContrib ;
	protected ExtensionType schemaExtension ;
	protected ExtensionType doctypeExtension ;
	
	private LifecycleFactory lifecycleFactory ;
	private org.skinsoft.nuxeo.components.lifecycle.DocumentRoot lifecycleContrib ;
	protected org.skinsoft.nuxeo.components.lifecycle.ExtensionType lifecycleTypeExtension ;
	
	private SearchFactory searchFactory ;
	private org.skinsoft.nuxeo.components.search.DocumentRoot searchContrib ;
	
	protected DirectoriesFactory directoriesFactory ;
	protected org.skinsoft.nuxeo.components.directories.DocumentRoot directoriesContrib ;
	protected org.skinsoft.nuxeo.components.directories.ExtensionType directoriesExtension ;
//	protected org.skinsoft.nuxeo.components.directories.ExtensionType replicatedDirectoriesExtension ;
//	protected org.skinsoft.nuxeo.components.directories.ExtensionType replicatedDirectoriesTimestampExtension;
	

	private ActionsFactory actionsFactory ;
	protected DocumentRoot typeFiltersContrib ;
	
	protected String packageName ;

	protected boolean directoryReplicationDefault;


	

	public CDToCoreTypeSwitch(
			CoretypesFactory coreTypesFactory,
			DirectoriesFactory directoriesFactory,
			LifecycleFactory lifecycleFactory, 
			SearchFactory searchFactory ,
			ActionsFactory actionsFactory ) {
		super();
		this.coreTypesFactory = coreTypesFactory;
		this.directoriesFactory = directoriesFactory;
		this.lifecycleFactory = lifecycleFactory;
		this.searchFactory = searchFactory;
		this.actionsFactory = actionsFactory ;
	}
	
	

	/* *************************************************************************
	 * Getters / Setters methods
	 */

	public org.skinsoft.nuxeo.components.directories.DocumentRoot getDirectoriesContrib() {
		return directoriesContrib;
	}

	


	public org.skinsoft.nuxeo.components.coretypes.DocumentRoot getCoreTypesContrib() {
		return coreTypesContrib;
	}




	public org.skinsoft.nuxeo.components.lifecycle.DocumentRoot getLifecycleContrib() {
		return lifecycleContrib;
	}




	public org.skinsoft.nuxeo.components.search.DocumentRoot getSearchContrib() {
		return searchContrib;
	}
	
	public DocumentRoot getTypeFiltersContrib() {
		return typeFiltersContrib ;
	}
	
	

	/* *************************************************************************
	 * Create contribution methods
	 */
	

	protected void createCoreTypesContrib() {
		if( this.coreTypesContrib == null ) {
			this.coreTypesContrib = this.coreTypesFactory.createDocumentRoot() ;
			
			ComponentType component = this.coreTypesFactory.createComponentType() ;
			component.setName( this.packageName + CORETYPE_COMPONENT_SUFFIX ) ;
			this.coreTypesContrib.setComponent( component ) ;
			
			this.schemaExtension = this.coreTypesFactory.createExtensionType();
			this.schemaExtension.setTarget( TARGET_TYPE_SERVICE ) ;
			this.schemaExtension.setPoint( EXTENSION_POINT_SCHEMA ) ;
			this.coreTypesContrib.getComponent().getExtension().add( this.schemaExtension ) ;
			
			this.doctypeExtension = this.coreTypesFactory.createExtensionType();
			this.doctypeExtension.setTarget( TARGET_TYPE_SERVICE ) ;
			this.doctypeExtension.setPoint( EXTENSION_POINT_DOCTYPE ) ;
			this.coreTypesContrib.getComponent().getExtension().add( this.doctypeExtension ) ;
		}
	}
	
	protected void createLifecycleContrib() {
		if( this.lifecycleContrib == null ) {
			this.lifecycleContrib = this.lifecycleFactory.createDocumentRoot() ;
			
			org.skinsoft.nuxeo.components.lifecycle.ComponentType component = this.lifecycleFactory.createComponentType() ;
			component.setName( this.packageName + LIFECYCLE_COMPONENT_SUFFIX ) ;
			this.lifecycleContrib.setComponent( component ) ;
			
			this.lifecycleTypeExtension = this.lifecycleFactory.createExtensionType() ;
			this.lifecycleContrib.getComponent().getExtension().add( this.lifecycleTypeExtension ) ;
			this.lifecycleTypeExtension.setTarget( TARGET_LIFECYCLE_SERVICE ) ;
			this.lifecycleTypeExtension.setPoint( EXTENSION_POINT_TYPES ) ;
			this.lifecycleTypeExtension.setTypes( this.lifecycleFactory.createTypesType() ) ;
		}
	}
	
	protected void createSearchContrib() {
		if( this.searchContrib == null ) {
			this.searchContrib = this.searchFactory.createDocumentRoot() ;
			
			org.skinsoft.nuxeo.components.search.ComponentType component = this.searchFactory.createComponentType() ;
			component.setName( this.packageName + SEARCH_COMPONENT_SUFFIX ) ;
			this.searchContrib.setComponent( component ) ;
			
			this.searchContrib.getComponent().setExtension( this.searchFactory.createExtensionType() ) ;
			this.searchContrib.getComponent().getExtension().setTarget( TARGET_SEARCH_SERVICE ) ;
			this.searchContrib.getComponent().getExtension().setPoint( EXTENSION_POINT_INDEXABLE_DOCTYPE ) ;
		}
	}
	
	protected void createDirectoriesContrib() {
		if( this.directoriesContrib == null ) {
			this.directoriesContrib = this.directoriesFactory.createDocumentRoot() ;
			
			org.skinsoft.nuxeo.components.directories.ComponentType component = this.directoriesFactory.createComponentType() ;
			component.setName( this.packageName + DIRECTORIES_COMPONENT_SUFFIX ) ;
			this.directoriesContrib.setComponent( component ) ;
			
			this.directoriesExtension = this.directoriesFactory.createExtensionType() ;
			this.directoriesExtension.setTarget( TARGET_DIRECTORY_SERVICE ) ;
			this.directoriesExtension.setPoint( EXTENSION_POINT_DIRECTORIES ) ;

//			this.replicatedDirectoriesExtension = this.directoriesFactory.createExtensionType() ;
//			this.replicatedDirectoriesExtension.setTarget( TARGET_REPLICATED_DIRECTORY_SERVICE ) ;
//			this.replicatedDirectoriesExtension.setPoint( EXTENSION_POINT_DIRECTORIES ) ;
//			
//			this.replicatedDirectoriesTimestampExtension = this.directoriesFactory.createExtensionType() ;
//			this.replicatedDirectoriesTimestampExtension.setTarget( TARGET_REPLICATED_DIRECTORY_SERVICE ) ;
//			this.replicatedDirectoriesTimestampExtension.setPoint( EXTENSION_POINT_TIMESTAMP ) ;
			
			this.directoriesContrib.getComponent().getExtension().add( this.directoriesExtension ) ;
//			this.directoriesContrib.getComponent().getExtension().add( this.replicatedDirectoriesExtension ) ;
//			this.directoriesContrib.getComponent().getExtension().add( this.replicatedDirectoriesTimestampExtension ) ;
		}
	}
	
	protected void createTypeFiltersContrib() {
		if( this.typeFiltersContrib == null ) {
			this.typeFiltersContrib = this.actionsFactory.createDocumentRoot() ;
			
			org.skinsoft.nuxeo.components.actions.ComponentType component = this.actionsFactory.createComponentType() ;
			this.typeFiltersContrib.setComponent( component ) ;
			this.typeFiltersContrib.getComponent().setName( this.packageName + TYPE_FILTERS_COMPONENT_SUFFIX ) ;
			
			this.typeFiltersContrib.getComponent().getExtension().add( this.actionsFactory.createExtensionType() ) ;
			this.typeFiltersContrib.getComponent().getExtension().get( 0 ).setTarget( TARGET_ACTION_SERVICE ) ;
			this.typeFiltersContrib.getComponent().getExtension().get( 0 ).setPoint( EXTENSION_POINT_FILTERS ) ;
		}
	}
	
	/* *************************************************************************
	 * Business methods
	 */
	
	protected void computeCoreTypeContrib( Class object ) {
		
		String idAsType = TransformationsUtils.normaliseTypeName( object.getName() ) ;
		
		DoctypeType doctype = this.coreTypesFactory.createDoctypeType() ;
		doctype.setName( idAsType ) ;
		
		
		Classifier superType = this.getSuperType( object ) ;
		doctype.setExtends( superType.getName() ) ;
		this.doctypeExtension.getDoctype().add( doctype ) ;
		
		for( Class documentPart : this.getDocumentParts( object ) ) {
			SchemaType schema = this.coreTypesFactory.createSchemaType() ;
			schema.setName( TransformationsUtils.normaliseAttributeName( documentPart.getName() ) ) ;
			doctype.getSchema().add( schema ) ;
		}
		
		System.out.println( object.getName() + " facets : " + this.getDocumentFacets( object ) );
		
		for( Interface intface : this.getDocumentFacets( object ) ) {
			FacetType facet = this.coreTypesFactory.createFacetType() ;
			facet.setName( intface.getName() ) ;
			doctype.getFacet().add( facet ) ;
		}
		
	}
	
	protected void computeTypeFilter( Class object ) {
		if( ! object.isAbstract() ) {
			FilterType filter = this.actionsFactory.createFilterType() ;
			this.typeFiltersContrib.getComponent().getExtension().get( 0 ).getFilter().add( filter ) ;
			
			filter.setId( "is" + TransformationsUtils.normaliseTypeName( object.getName() ) ) ;
			
			filter.getRule().add( this.actionsFactory.createRuleType() ) ;
			filter.getRule().get( 0 ).getType().add( TransformationsUtils.normaliseTypeName( object.getName() ) ) ;
		}
	}
	

	protected void computeSchemaExtension(Classifier object) {
		String idAsAttribute = TransformationsUtils.normaliseAttributeName( object.getName() ) ;
		
		SchemaType schema = this.coreTypesFactory.createSchemaType() ;
		schema.setName( idAsAttribute ) ;
		schema.setPrefix( idAsAttribute ) ;
		schema.setSrc( "schemas/" + idAsAttribute + ".xsd" ) ;
		
		this.schemaExtension.getSchema().add( schema ) ;
	}
	
	protected void computeLifecycleContrib( Class object ) {
		String idAsType = TransformationsUtils.normaliseTypeName( object.getName() ) ;
		
		List<Constraint> lifecycleConstraints = this.lookupConstraints( object.getPackage() , object , LIFECYCLE_CONSTRAINT_PREFIX ) ;
		
		TypeType type = this.lifecycleFactory.createTypeType() ;
		type.setName( idAsType ) ;
		if( lifecycleConstraints.isEmpty() ) {
			type.setValue( DEFAULT_LIFECYCLE ) ;
		} else {
			type.setValue( lifecycleConstraints.get( 0 ).getName().substring( LIFECYCLE_CONSTRAINT_PREFIX.length() ) ) ;
		}
		this.lifecycleTypeExtension.getTypes().getType().add( type ) ;
	}
	
	
	protected void computeSearchContrib( Class object ) {
		String idAsType = TransformationsUtils.normaliseTypeName( object.getName() ) ;
		
		IndexableDocTypeType indexable = this.searchFactory.createIndexableDocTypeType() ;
		indexable.setIndexAllSchemas( "true" ) ;
		indexable.setName( idAsType ) ;
		this.searchContrib.getComponent().getExtension().getIndexableDocType().add( indexable ) ;
	}
	
	protected void computeDirectoriesContrib( Class object ) {
		String directoryName = TransformationsUtils.normaliseAttributeName( object.getName() ) ;
		String schemaName = TransformationsUtils.normaliseAttributeName( this.getSuperType( object ).getName() ) ;
		
		DirectoryType directory = this.directoriesFactory.createDirectoryType() ;
		directory.setName( directoryName ) ;
		directory.setIdField( schemaName + ":id" ) ;
		directory.setDataSource( "java:/nxsqldirectory" ) ;
		directory.setTable( directoryName ) ;
		directory.setSchema( schemaName ) ;
		directory.setCreateTablePolicy( DIRECTORY_CREATE_POLICY_ON_MISSING_COLUMN ) ;
		directory.setAutoincrementIdField( "true" ) ;
		
		this.directoriesExtension.getDirectory().add( directory ) ;
		
//		List<Constraint> replicatedConstraints = this.lookupConstraints( object.getPackage() , object , DIRECTORY_REPLICATED_CONSTRAINT_PREFIX );
//		boolean replicated = this.directoryReplicationDefault ;
//		if( replicatedConstraints != null && ! replicatedConstraints.isEmpty() ) {
//			replicated = "true".equals( replicatedConstraints.get( 0 ).getName().substring( DIRECTORY_REPLICATED_CONSTRAINT_PREFIX.length() ) ) ;
//		}
		
		
//		if( replicated ) {
//			this.replicatedDirectoriesExtension.getDirectory().add( directory ) ;
//			
//			TimestampType timestamp = this.directoriesFactory.createTimestampType() ;
//			timestamp.setDirectory( directory.getName() ) ;
//			timestamp.setField( schemaName + ":timestamp" ) ;
//			this.replicatedDirectoriesTimestampExtension.getTimestamp().add( timestamp ) ;
//			
//		} else {
//			this.directoriesExtension.getDirectory().add( directory ) ;
//		}
	}
	
	
	
	
	
	/* *************************************************************************
	 * Switch methods
	 */
	
	@Override
	public EObject casePackage(Package object) {
		
		this.packageName = object.getName() ;
		
		List<Constraint> replicationDefaultConstraints = this.lookupConstraints( object , null , DIRECTORY_REPLICATION_DEFAULT_CONSTRAINT_PREFIX );
		if( replicationDefaultConstraints != null && replicationDefaultConstraints.size() > 0 ) {
			this.directoryReplicationDefault = "true".equals( replicationDefaultConstraints.get( 0 ).getName().substring( DIRECTORY_REPLICATION_DEFAULT_CONSTRAINT_PREFIX.length() ) ) ;
		} else {
			this.directoryReplicationDefault = false ;
		}
		
		this.createCoreTypesContrib() ;
		this.createLifecycleContrib() ;
		this.createSearchContrib() ;
		this.createDirectoriesContrib() ;
		this.createTypeFiltersContrib() ;
		
		for( EObject element : object.getPackagedElements() ) {
			this.doSwitch( element ) ;
		}
		
		return object ;
	}
	



	@Override
	public EObject caseClass(Class object) {
		if( object.isAbstract() ) return object ;
		
		if( this.isDocument( object ) ) {
			this.computeCoreTypeContrib( object ) ;
			this.computeLifecycleContrib( object ) ;
			this.computeSearchContrib( object ) ;
			this.computeTypeFilter( object ) ;
		} else if( this.isDirectoryInstance( object ) ) {
			this.computeDirectoriesContrib( object ) ;
		} else if( this.isDocumentPart( object ) ) {
			this.computeSchemaExtension( object ) ;
		}
		
		return object ;
	}
	
	

	@Override
	public EObject caseDataType(DataType object) {
		if( object.isAbstract() ) return object ;
		
		if( this.isDirectory( object ) ) {
			this.computeSchemaExtension( object ) ;
		}
		
		return object ;
	}


	
	
	
	
	/* *************************************************************************
	 * Contribution generation methods
	 */

	public void generateCoreTypeContrib( File coreTypeContribFile ) throws IOException {
		XMLResourceImpl coreTypesResource = new XMLResourceImpl( URI.createFileURI( coreTypeContribFile.getAbsolutePath() ) ) ;
		coreTypesResource.getContents().add( this.getCoreTypesContrib() ) ;
		
		HashMap<String, Object> options = new HashMap<String, Object>() ;
		options.put( XMLResource.OPTION_ENCODING , "UTF-8" ) ;
		options.put( XMLResource.OPTION_ROOT_OBJECTS , Collections.singletonList( this.getCoreTypesContrib().getComponent() ) ) ;
		
		XMLMap xmlMap = new XMLMapImpl() ;
		options.put( XMLResource.OPTION_XML_MAP, xmlMap ) ;
		
		XMLInfo xmlInfo = new XMLInfoImpl() ;
		xmlInfo.setName( "component" ) ;
		xmlInfo.setTargetNamespace( null ) ;
		
		xmlMap.add( this.coreTypesFactory.getCoretypesPackage().getComponentType() , xmlInfo ) ;
		
		coreTypesResource.save( options ) ;
	}
	
	public void generateLifecycleContrib( File lifecycleContribFile ) throws IOException {
		XMLResourceImpl xmlResource = new XMLResourceImpl( URI.createFileURI( lifecycleContribFile.getAbsolutePath() ) ) ;
		xmlResource.getContents().add( this.getLifecycleContrib() ) ;
		
		HashMap<String, Object> options = new HashMap<String, Object>() ;
		options.put( XMLResource.OPTION_ENCODING , "UTF-8" ) ;
		options.put( XMLResource.OPTION_ROOT_OBJECTS , Collections.singletonList( this.getLifecycleContrib().getComponent() ) ) ;
		
		XMLMap xmlMap = new XMLMapImpl() ;
		options.put( XMLResource.OPTION_XML_MAP, xmlMap ) ;
		
		XMLInfo xmlInfo = new XMLInfoImpl() ;
		xmlInfo.setName( "component" ) ;
		xmlInfo.setTargetNamespace( null ) ;
		
		xmlMap.add( this.lifecycleFactory.getLifecyclePackage().getComponentType() , xmlInfo ) ;
		
		xmlInfo = new XMLInfoImpl() ;
		xmlInfo.setXMLRepresentation( XMLInfo.CONTENT ) ;
		xmlMap.add( this.lifecycleFactory.getLifecyclePackage().getTypeType_Value() , xmlInfo ) ;
		
		
		xmlResource.save( options ) ;
	}
	
	public void generateSearchContrib( File searchContribFile ) throws IOException {
		XMLResourceImpl xmlResource = new XMLResourceImpl( URI.createFileURI( searchContribFile.getAbsolutePath() ) ) ;
		xmlResource.getContents().add( this.getSearchContrib() ) ;
		
		HashMap<String, Object> options = new HashMap<String, Object>() ;
		options.put( XMLResource.OPTION_ENCODING , "UTF-8" ) ;
		options.put( XMLResource.OPTION_ROOT_OBJECTS , Collections.singletonList( this.getSearchContrib().getComponent() ) ) ;
		
		XMLMap xmlMap = new XMLMapImpl() ;
		options.put( XMLResource.OPTION_XML_MAP, xmlMap ) ;
		
		XMLInfo xmlInfo = new XMLInfoImpl() ;
		xmlInfo.setName( "component" ) ;
		xmlInfo.setTargetNamespace( null ) ;
		
		xmlMap.add( this.searchFactory.getSearchPackage().getComponentType() , xmlInfo ) ;
		
		xmlResource.save( options ) ;
	}
	
	public void generateDirectoriesContrib( File directoriesContribFile ) throws IOException {
		XMLResourceImpl xmlResource = new XMLResourceImpl( URI.createFileURI( directoriesContribFile.getAbsolutePath() ) ) ;
		xmlResource.getContents().add( this.getDirectoriesContrib() ) ;
		
		HashMap<String, Object> options = new HashMap<String, Object>() ;
		options.put( XMLResource.OPTION_ENCODING , "UTF-8" ) ;
		options.put( XMLResource.OPTION_ROOT_OBJECTS , Collections.singletonList( this.getDirectoriesContrib().getComponent() ) ) ;
		
		XMLMap xmlMap = new XMLMapImpl() ;
		options.put( XMLResource.OPTION_XML_MAP, xmlMap ) ;
		
		XMLInfo xmlInfo = new XMLInfoImpl() ;
		
		xmlInfo.setName( "component" ) ;
		xmlInfo.setTargetNamespace( null ) ;
		xmlMap.add( this.directoriesFactory.getDirectoriesPackage().getComponentType() , xmlInfo ) ;
		
		xmlInfo = new XMLInfoImpl() ;
		xmlInfo.setXMLRepresentation( XMLInfo.ELEMENT ) ;
		xmlMap.add( this.directoriesFactory.getDirectoriesPackage().getDirectoryType_DataFile(), xmlInfo ) ;
		xmlMap.add( this.directoriesFactory.getDirectoriesPackage().getDirectoryType_DataSource(), xmlInfo ) ;
		xmlMap.add( this.directoriesFactory.getDirectoriesPackage().getDirectoryType_IdField(), xmlInfo ) ;
		xmlMap.add( this.directoriesFactory.getDirectoriesPackage().getDirectoryType_ParentDirectory(), xmlInfo ) ;
		xmlMap.add( this.directoriesFactory.getDirectoriesPackage().getDirectoryType_Schema(), xmlInfo ) ;
		xmlMap.add( this.directoriesFactory.getDirectoriesPackage().getDirectoryType_Table(), xmlInfo ) ;
		xmlMap.add( this.directoriesFactory.getDirectoriesPackage().getDirectoryType_CreateTablePolicy(), xmlInfo ) ;
		xmlMap.add( this.directoriesFactory.getDirectoriesPackage().getDirectoryType_AutoincrementIdField(), xmlInfo ) ;
		
		xmlResource.save( options ) ;
	}
	
	public void generateTypeFiltersContrib( File directoriesContribFile ) throws IOException {
		XMLResourceImpl xmlResource = new XMLResourceImpl( URI.createFileURI( directoriesContribFile.getAbsolutePath() ) ) ;
		xmlResource.getContents().add( this.getDirectoriesContrib() ) ;
		
		HashMap<String, Object> options = new HashMap<String, Object>() ;
		options.put( XMLResource.OPTION_ENCODING , "UTF-8" ) ;
		options.put( XMLResource.OPTION_ROOT_OBJECTS , Collections.singletonList( this.getTypeFiltersContrib().getComponent() ) ) ;
		
		XMLMap xmlMap = new XMLMapImpl() ;
		options.put( XMLResource.OPTION_XML_MAP, xmlMap ) ;
		
		XMLInfo xmlInfo = new XMLInfoImpl() ;
		
		xmlInfo.setName( "component" ) ;
		xmlInfo.setTargetNamespace( null ) ;
		xmlMap.add( this.actionsFactory.getActionsPackage().getComponentType() , xmlInfo ) ;
		
		xmlResource.save( options ) ;
	}



	
	
}
