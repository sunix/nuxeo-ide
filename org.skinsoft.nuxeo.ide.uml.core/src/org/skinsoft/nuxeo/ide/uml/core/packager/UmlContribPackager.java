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
package org.skinsoft.nuxeo.ide.uml.core.packager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.util.UMLSwitch;
import org.eclipse.xsd.XSDFactory;
import org.eclipse.xsd.util.XSDSchemaBuildingTools;
import org.skinsoft.nuxeo.components.actions.ActionsFactory;
import org.skinsoft.nuxeo.components.coretypes.CoretypesFactory;
import org.skinsoft.nuxeo.components.directories.DirectoriesFactory;
import org.skinsoft.nuxeo.components.ecmtypes.EcmtypesFactory;
import org.skinsoft.nuxeo.components.field.to.directory.association.AssociationFactory;
import org.skinsoft.nuxeo.components.jbpm.service.ServiceFactory;
import org.skinsoft.nuxeo.components.lifecycle.LifecycleFactory;
import org.skinsoft.nuxeo.components.permissions.PermissionsFactory;
import org.skinsoft.nuxeo.components.search.SearchFactory;
import org.skinsoft.nuxeo.components.workflow.WorkflowFactory;
import org.skinsoft.nuxeo.ide.uml.core.packager.exception.ManifestGenerationException;
import org.skinsoft.nuxeo.ide.uml.core.packager.exception.PackagerException;
import org.skinsoft.nuxeo.ide.uml.core.packager.util.ManifestNuxeoComponentAdder;
import org.skinsoft.nuxeo.ide.uml.core.uml.CDToBaseEcmTypeSwitch;
import org.skinsoft.nuxeo.ide.uml.core.uml.CDToCoreTypeSwitch;
import org.skinsoft.nuxeo.ide.uml.core.uml.CDToFieldDirectoryAssociation;
import org.skinsoft.nuxeo.ide.uml.core.uml.CDToXSDSwitch;
import org.skinsoft.nuxeo.ide.uml.core.uml.StateMachineToLifecycleSwitch;
import org.skinsoft.nuxeo.ide.uml.core.uml.UseCaseToActionsGenenator;
import org.skinsoft.nuxeo.ide.uml.core.uml.UseCaseToActionsGenenator.WorkflowTypeEnum;

public class UmlContribPackager {
	
	static public final String USECASE_ACTIONS_CONTRIB_XML = "uml/actions-contrib.xml";
	static public final String USECASE_PERMISSIONS_CONTRIB_XML = "uml/permissions-contrib.xml";
	static public final String USECASE_WORKFLOW_CONTRIB_XML = "uml/workflow-contrib.xml";
	static public final String DIRECTORIES_CONTRIB_XML = "uml/directories-contrib.xml";
	static public final String SEARCH_CONTRIB_XML = "uml/search-contrib.xml";
	static public final String LIFECYCLE_CONTRIB_XML = "uml/lifecycle-contrib.xml";
	static public final String CORE_TYPES_CONTRIB_XML = "uml/core-types-contrib.xml";
	static public final String ECM_TYPES_CONTRIB_XML = "uml/ecm-types-contrib.xml";
	static public final String DIRECTORY_FILLER_CONTRIB_XML = "uml/directory-filler-contrib.xml";
	static public final String FIELD_TO_DIRECTORY_ASSOCIATIONS_CONTRIB_XML = "uml/field-to-directory-associations-contrib.xml";
	static public final String LIFECYCLE_DEFINITION_CONTRIB_XML = "uml/lifecycle-definition-contrib.xml";
	static public final String TYPE_FILTER_CONTRIB_XML = "uml/type-filter-contrib.xml";
	
	static public FileFilter umlFileFilter = new FileFilter() {
		public boolean accept(File pathname) {
			return pathname.getName().endsWith(".uml");
		}
	};
	protected ArrayList<UMLResource> coreTypeDiagramResources;
//	protected UMLResource ecmTypeDiagramResource;
	protected ArrayList<UMLResource> ecmTypeDiagramResources;
	protected ArrayList<UMLResource> lifecycleResources;
	protected ArrayList<UMLResource> useCaseActionsResources ;

	protected CDToXSDSwitch schemaSwitch;
	protected CDToCoreTypeSwitch coreTypeSwitch;
	protected CDToBaseEcmTypeSwitch ecmTypeSwitch;
	protected CDToFieldDirectoryAssociation fieldToDirectorySwitch;
	protected StateMachineToLifecycleSwitch lifecycleSwitch;
	
	protected UseCaseToActionsGenenator usecaseActionGenerator ;

	protected PackageGetter packageGetter = new PackageGetter();
	protected File bundleResources;
	protected String packageName;
	
	protected Properties configuration ;
	protected File project;
	
	/**
	 * <p>Nuxeo contributions are generated from uml files in the uml sub directories
	 * with the following file naming conventions :
	 * <dl>
	 * 		<dt>Core types UML contributions</dt>
	 * 		<dd>
	 * 			<ul>
	 * 				<li>core-type.uml</li>
	 * 				<li>core-type/*.uml</li>
	 * 			</ul>
	 * 		</dd>
	 * 
	 * 		<dt>ECM types UML contributions</dt>
	 * 		<dd>
	 * 			<ul>
	 * 				<li>ecm-type.uml</li>
	 * 				<li>ecm-type/*.uml</li>
	 * 			</ul>
	 * 		</dd>
	 * 
	 * 		<dt>Actions UML contributions</dt>
	 * 		<dd>
	 * 			<ul>
	 * 				<li>actions.uml</li>
	 * 				<li>actions/*.uml</li>
	 * 			</ul>
	 * 		</dd>
	 * 
	 * 		<dt>Lifecycle UML contributions</dt>
	 * 		<dd>
	 * 			<ul>
	 * 				<li>lifecycle.uml</li>
	 * 				<li>lifecycle/*.uml</li>
	 * 			</ul>
	 * 		</dd>
	 * 
	 * </dl></p>
	 * 
	 * <p>All uml contributions are generated to the <code>src/main/resources.OSGI-INF/uml</code> 
	 * folder. They are added to the <code>Nuxeo-Component:</code> part of the 
	 * <code>MANIFEST.MF</code> file.</p>
	 * 
	 * <p>Existing contributions referenced in the <code>MANIFEST.MF</code> are left unchanged
	 * (except for those liying in the <code>OSGI-INF/uml</code> folder).</p>
	 * 
	 * <p>XML Schemas are generated to the <code>src/main/resources/schemas</code>
	 * folder.</p>
	 * 
	 * <p>The project uml directory may contain a <code>packager.properties</code> file configuring
	 * the generation mechanism. Fior now, the only understood property is the
	 * <code>generate.field.to.directory.associations</code> boolean. When tue, a contrib is generated
	 * for a skin-soft service enabling to link directories to xpaths.</p>
	 * 
	 * @param project java project file containing a uml directory with uml contribs
	 * @throws PackagerException
	 */
	public UmlContribPackager( File project ) throws PackagerException {
		super() ;
		
		if( ! project.isDirectory() ) {
			throw new RuntimeException( "Must provide a project directory" ) ;
		}
		
		File umlRepository = new File( project , "uml" ) ;
		if( ! umlRepository.isDirectory() ) {
			throw new RuntimeException( "Project directory must contain an uml directory with core-type.uml and ecm-type.uml files" ) ;
		}
		
		ArrayList<URI> coreTypesURIs = new ArrayList<URI>() ;
		if( new File( umlRepository , "core-type.uml" ).exists() ) {
			coreTypesURIs.add( URI.createFileURI( new File( umlRepository , "core-type.uml" ).getAbsolutePath() ) ) ;
		}
		File coreTypesUmlRepo = new File( umlRepository , "core-type" ) ;
		if( coreTypesUmlRepo.exists() ) {
			File [] coreTypeUMLFiles = coreTypesUmlRepo.listFiles( UmlContribPackager.umlFileFilter );
			if( coreTypeUMLFiles != null ) {
				for( int i = 0 ; i < coreTypeUMLFiles.length ; i++ ) {
					coreTypesURIs.add( URI.createFileURI( coreTypeUMLFiles[i].getAbsolutePath() ) ) ;
				}
			}
		}
		
		ArrayList<URI> ecmTypesURIs = new ArrayList<URI>() ;
		if( new File( umlRepository , "ecm-type.uml" ).exists() ) {
			ecmTypesURIs.add( URI.createFileURI( new File( umlRepository , "ecm-type.uml" ).getAbsolutePath() ) ) ;
		}
		File ecmTypesUmlRepo = new File( umlRepository , "ecm-type" ) ;
		if( ecmTypesUmlRepo.exists() ) {
			File [] ecmTypeUMLFiles = ecmTypesUmlRepo.listFiles( UmlContribPackager.umlFileFilter );
			if( ecmTypeUMLFiles != null ) {
				for( int i = 0 ; i < ecmTypeUMLFiles.length ; i++ ) {
					ecmTypesURIs.add( URI.createFileURI( ecmTypeUMLFiles[i].getAbsolutePath() ) ) ;
				}
			}
		}
		
		ArrayList<URI> lifecycleURIs = new ArrayList<URI>() ;
		if( new File( umlRepository , "lifecycle.uml" ).exists() ) {
			lifecycleURIs.add( URI.createFileURI( new File( umlRepository , "lifecycle.uml" ).getAbsolutePath() ) ) ;
		}
		File lifecycleUmlRepo = new File( umlRepository , "lifecycle" ) ;
		if( lifecycleUmlRepo.exists() ) {
			File [] lifecycleUMLFiles = lifecycleUmlRepo.listFiles( UmlContribPackager.umlFileFilter );
			if( lifecycleUMLFiles != null ) {
				for( int i = 0 ; i < lifecycleUMLFiles.length ; i++ ) {
					lifecycleURIs.add( URI.createFileURI( lifecycleUMLFiles[i].getAbsolutePath() ) ) ;
				}
			}
		}
		
		ArrayList<URI> useCaseActionsURIs = new ArrayList<URI>() ;
		if( new File( umlRepository , "actions.uml" ).exists() ) {
			useCaseActionsURIs.add( URI.createFileURI( new File( umlRepository , "actions.uml" ).getAbsolutePath() ) ) ;
		}
		File usecaseActionsUmlRepo = new File( umlRepository , "actions" ) ;
		if( usecaseActionsUmlRepo.exists() ) {
			File [] usecaseActionsUmlFiles = usecaseActionsUmlRepo.listFiles( UmlContribPackager.umlFileFilter ) ;
			if( usecaseActionsUmlFiles != null ) {
				for (int i = 0; i < usecaseActionsUmlFiles.length; i++) {
					useCaseActionsURIs.add( URI.createFileURI(usecaseActionsUmlFiles[i].getAbsolutePath() ) );
				}
			}
		}
		
		Properties configuration = new Properties() ;
		File umlProperties = new File( project , "uml/packager.properties" ) ;
		if( umlProperties.exists() ) {
			InputStream configStream = null ;
			try {
				configStream = new FileInputStream( umlProperties ) ;
				configuration.load( configStream  ) ;
			} catch (IOException e) {
				throw new PackagerException( e ) ;
			} finally {
				if( configStream != null ) {
					try {
						configStream.close() ;
					} catch (IOException e) {
						throw new PackagerException( e ) ;
					}
				}
			}
			
		}
		
		this.initPackager( 
				project ,
				coreTypesURIs.toArray( new URI [] {} ) , 
				ecmTypesURIs.toArray( new URI [] {} ) ,
				lifecycleURIs.toArray( new URI [] {} ) ,
				useCaseActionsURIs.toArray( new URI [] {} ) ,
				new File( project , "src/main/resources" ) ,
				configuration ) ;
	}

	protected void initPackager(
			File project ,
			URI[] coreTypeDDiagramURIs,
			URI[] ecmTypeDDiagramURIs,
			URI[] lifecyleURIs, 
			URI[] useCaseActionsURIs, 
			File bundleResources,
			Properties configuration ) {
		
		this.project = project ;
		this.configuration = configuration ;
		this.bundleResources = bundleResources ;
		
		XSDFactory schemasFactory = XSDSchemaBuildingTools.getXSDFactory() ;
		
		CoretypesFactory coretypesFactory = CoretypesFactory.eINSTANCE ;
		LifecycleFactory lifecycleFactory = LifecycleFactory.eINSTANCE ;
		SearchFactory searchFactory = SearchFactory.eINSTANCE ;
		DirectoriesFactory directoriesFactory = DirectoriesFactory.eINSTANCE ;
		
		EcmtypesFactory ecmFactory = EcmtypesFactory.eINSTANCE ;
		ActionsFactory actionsFactory = ActionsFactory.eINSTANCE ;
		
		this.schemaSwitch = new CDToXSDSwitch( schemasFactory ) ;
		this.coreTypeSwitch = new CDToCoreTypeSwitch( coretypesFactory , directoriesFactory , lifecycleFactory , searchFactory , actionsFactory ) ;
		this.ecmTypeSwitch = new CDToBaseEcmTypeSwitch( ecmFactory ) ;
		this.fieldToDirectorySwitch = new CDToFieldDirectoryAssociation( AssociationFactory.eINSTANCE ) ;
		this.lifecycleSwitch = new StateMachineToLifecycleSwitch( LifecycleFactory.eINSTANCE ) ;
		
		ResourceSet resourceSet = new ResourceSetImpl() ;
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				UMLResource.FILE_EXTENSION , 
			    UMLResource.Factory.INSTANCE
			   ) ;
		
		this.coreTypeDiagramResources = new ArrayList<UMLResource>() ;
		if( coreTypeDDiagramURIs != null ) {
			for( URI coreTypeDDiagramURI : coreTypeDDiagramURIs ) {
				this.coreTypeDiagramResources.add( (UMLResource) resourceSet.getResource( coreTypeDDiagramURI , true ) ) ;
			}
		}
		
		this.ecmTypeDiagramResources = new ArrayList<UMLResource>() ;
		if( ecmTypeDDiagramURIs != null ) {
			for( URI ecmTypeDDiagramURI : ecmTypeDDiagramURIs ) {
				this.ecmTypeDiagramResources.add( (UMLResource) resourceSet.getResource( ecmTypeDDiagramURI , true ) ) ;
			}
		}
		
		this.lifecycleResources = new ArrayList<UMLResource>() ;
		if( lifecyleURIs != null ) {
			for( URI lifecycleURI : lifecyleURIs ) {
				this.lifecycleResources.add( (UMLResource) resourceSet.getResource( lifecycleURI , true ) ) ;
			}
		}
		
		this.useCaseActionsResources = new ArrayList<UMLResource>() ;
		if( useCaseActionsURIs != null ) {
			for( URI useCaseActionsURI : useCaseActionsURIs ) {
				this.useCaseActionsResources.add( (UMLResource) resourceSet.getResource( useCaseActionsURI , true ) ) ;
			}
		}
	}

	/**
	 * <p>Cleans up <code>OSGI-INF/uml</code> folder, generates the contributions from
	 * the uml files and regenerates the <code>MANIFEST.MF</code> file.</p>
	 * @throws PackagerException
	 * 
	 */
	public void packageContribs() throws PackagerException {
		this.createProjectStructure(this.project);

		File osgiInf = new File(this.project, "src/main/resources/OSGI-INF") ;
		if( new File( osgiInf , "uml" ).exists() ) {
			for( File oldUmlContrib : new File( osgiInf , "uml" ).listFiles() ) {
				this.recursiveDelete( oldUmlContrib ) ;
			}
		}
		
		
		if (this.coreTypeDiagramResources != null
				&& !this.coreTypeDiagramResources.isEmpty()) {

			for (UMLResource coreTypeDiagramResource : this.coreTypeDiagramResources) {
				this.schemaSwitch.doSwitch(coreTypeDiagramResource
						.getContents().get(0));
				this.coreTypeSwitch.doSwitch(coreTypeDiagramResource
						.getContents().get(0));
				this.fieldToDirectorySwitch.doSwitch(coreTypeDiagramResource
						.getContents().get(0));
			}

			File schemas = new File(this.project, "src/main/resources/schemas");
			this.schemaSwitch.generateAllSchemas(schemas);

			try {
				File coretypesContribFile = this.createFile(osgiInf,
						CORE_TYPES_CONTRIB_XML);
				this.coreTypeSwitch
						.generateCoreTypeContrib(coretypesContribFile);
			} catch (IOException e) {
				throw new PackagerException("Error creating contrib file", e);
			}

			try {
				File lifecycleContribFile = this.createFile(osgiInf,
						LIFECYCLE_CONTRIB_XML);
				this.coreTypeSwitch
						.generateLifecycleContrib(lifecycleContribFile);
			} catch (IOException e) {
				throw new PackagerException("Error creating contrib file", e);
			}

			try {
				File searchContribFile = this.createFile(osgiInf,
						SEARCH_CONTRIB_XML);
				this.coreTypeSwitch.generateSearchContrib(searchContribFile);
			} catch (IOException e) {
				throw new PackagerException("Error creating contrib file", e);
			}

			try {
				File directoriesContribFile = this.createFile(osgiInf,
						DIRECTORIES_CONTRIB_XML);
				this.coreTypeSwitch
						.generateDirectoriesContrib(directoriesContribFile);
			} catch (IOException e) {
				throw new PackagerException("Error creating contrib file", e);
			}
			
			try {
				File typeFiltersContribFile = this.createFile(osgiInf,
						TYPE_FILTER_CONTRIB_XML );
				this.coreTypeSwitch
						.generateTypeFiltersContrib(typeFiltersContribFile);
			} catch (IOException e) {
				throw new PackagerException("Error creating contrib file", e);
			}
			
			if( this.shouldGenerateFieldToDirectoryAssociations() ) {
				try {
					File fieldToDirectoryContribFile = this.createFile(osgiInf,
							FIELD_TO_DIRECTORY_ASSOCIATIONS_CONTRIB_XML);
					this.fieldToDirectorySwitch
							.generateFieldToDirectoryAssociationContrib(fieldToDirectoryContribFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		if (this.ecmTypeDiagramResources != null
				&& !this.ecmTypeDiagramResources.isEmpty()) {

			for (UMLResource ecmTypeDiagramResource : this.ecmTypeDiagramResources) {
				this.ecmTypeSwitch.doSwitch(ecmTypeDiagramResource
						.getContents().get(0));
			}
			
			try {
				File ecmTypesContribFile = this.createFile(osgiInf,
						ECM_TYPES_CONTRIB_XML);
				this.ecmTypeSwitch.generateEcmTypesContrib(ecmTypesContribFile);
			} catch (IOException e) {
				throw new PackagerException("Error creating contrib file", e);
			}
		}
		

		String packageName = this.getPackageName();

		this.lifecycleSwitch.setContributionPackage(packageName);
		if (this.lifecycleResources != null
				&& this.lifecycleResources.size() > 0) {
			for (UMLResource lifecycleResource : this.lifecycleResources) {
				this.lifecycleSwitch.doSwitch(lifecycleResource.getContents().get(0));
			}
			try {
				File lifecycleDefinitionContribFile = this.createFile(osgiInf,
						LIFECYCLE_DEFINITION_CONTRIB_XML);
				this.lifecycleSwitch
						.generateLifecycleDefinitionContrib(lifecycleDefinitionContribFile);
			} catch (IOException e) {
				throw new PackagerException("Error creating contrib file", e);
			}
		}
		
		
		
		if( this.useCaseActionsResources != null && ! this.useCaseActionsResources.isEmpty() ) {
			if( this.usecaseActionGenerator == null ) {
				this.usecaseActionGenerator = new UseCaseToActionsGenenator( 
						ActionsFactory.eINSTANCE , 
						PermissionsFactory.eINSTANCE , 
						WorkflowFactory.eINSTANCE ,
						ServiceFactory.eINSTANCE ,
						this.getPackageName() ,
						this.bundleResources
						) ;
			}
			for( UMLResource res : this.useCaseActionsResources ) {
				this.usecaseActionGenerator.computeActionsContrib( (Package) res.getContents().get( 0 ) ) ;
			}
			try {
				File usecasePermissionsContribFile = this.createFile( osgiInf , USECASE_PERMISSIONS_CONTRIB_XML ) ;
				this.usecaseActionGenerator.generatePermissionsContrib( usecasePermissionsContribFile ) ;
				
				File usecaseActionsContribFile = this.createFile( osgiInf , USECASE_ACTIONS_CONTRIB_XML ) ;
				this.usecaseActionGenerator.generateUseCaseActionsContrib( usecaseActionsContribFile ) ;
				
				File usecaseWorkflowContribFile = this.createFile( osgiInf , USECASE_WORKFLOW_CONTRIB_XML ) ;
				if( this.usecaseActionGenerator.getWorkflowType() == WorkflowTypeEnum.OLD_TYPE ) {
					this.usecaseActionGenerator.generateWorkflowContrib( usecaseWorkflowContribFile ) ;
				} else if( this.usecaseActionGenerator.getWorkflowType() == WorkflowTypeEnum.JBPM_SERVICE ) {
					this.usecaseActionGenerator.generateJbpmWorkflowContrib( usecaseWorkflowContribFile ) ;
				}
			} catch (IOException e) {
				throw new PackagerException("Error creating contrib file", e);
			}
		}

		ManifestNuxeoComponentAdder manifestGen = new ManifestNuxeoComponentAdder();
		
		if (!this.coreTypeDiagramResources.isEmpty()) {
			manifestGen.addNuxeoComponent(
					"OSGI-INF/" + CORE_TYPES_CONTRIB_XML);
			manifestGen.addNuxeoComponent(
					"OSGI-INF/" + LIFECYCLE_CONTRIB_XML);
			manifestGen.addNuxeoComponent(
					"OSGI-INF/" + SEARCH_CONTRIB_XML);
			manifestGen.addNuxeoComponent(
					"OSGI-INF/" + DIRECTORIES_CONTRIB_XML);
			manifestGen.addNuxeoComponent(
					"OSGI-INF/" + TYPE_FILTER_CONTRIB_XML);
			manifestGen.addNuxeoComponent(
					"OSGI-INF/" + FIELD_TO_DIRECTORY_ASSOCIATIONS_CONTRIB_XML);
			
			
			
		}
		
		if( this.useCaseActionsResources != null && ! this.useCaseActionsResources.isEmpty() ) {
			manifestGen.addNuxeoComponent( "OSGI-INF/" + USECASE_ACTIONS_CONTRIB_XML ) ;
			manifestGen.addNuxeoComponent( "OSGI-INF/" + USECASE_PERMISSIONS_CONTRIB_XML ) ;
			manifestGen.addNuxeoComponent( "OSGI-INF/" + USECASE_WORKFLOW_CONTRIB_XML ) ;
		}

		if (this.ecmTypeDiagramResources != null && ! this.ecmTypeDiagramResources.isEmpty() ) {
			manifestGen.addNuxeoComponent(
					"OSGI-INF/" + ECM_TYPES_CONTRIB_XML);
		}

		if (!this.lifecycleResources.isEmpty()) {
			manifestGen.addNuxeoComponent(
					"OSGI-INF/" + LIFECYCLE_DEFINITION_CONTRIB_XML);
		}
		

		File metaInf = new File(this.project, "src/main/resources/META-INF");
		try {
			manifestGen.generatePackageManifest( this.createFile(metaInf, "MANIFEST.MF" ) ) ;
		} catch (ManifestGenerationException e) {
			throw new PackagerException(e);
		} catch (IOException e) {
			throw new PackagerException(e);
		}
	}

	private boolean shouldGenerateFieldToDirectoryAssociations() {
		return Boolean.valueOf( this.configuration.getProperty( "generate.field.to.directory.associations" , "false" ) ) ;
	}

	protected String getPackageName() throws PackagerException {
		if( this.packageName == null ) {
			// read package name from the manifest Provide-Package entry
			BufferedReader manifest = null ;
			try {
				manifest = new BufferedReader( new FileReader( new File( this.bundleResources , "META-INF/MANIFEST.MF" ) ) ) ;
				
				String line = null ;
				while( (line = manifest.readLine()) != null ) {
					if( line.startsWith( "Provide-Package: " ) ) {
						
						System.out.println( "Package : " + line.substring( "Provide-Package: ".length() ) ) ;
						this.packageName = line.substring( "Provide-Package: ".length() ) ;
					}
				}
			} catch (FileNotFoundException e) {
				throw new PackagerException( "Need a valid manifest with Provide-Package entry" , e ) ;
			} catch (IOException e) {
				throw new PackagerException( "Error reading manifest" , e ) ;
			} finally {
				if( manifest != null ) {
					try {
						manifest.close() ;
					} catch (IOException e) {
						throw new PackagerException( "Error while closing manifest" , e ) ;
					}
				}
			}
		}
		
		return this.packageName ;
		
	}

	protected void createProjectStructure(File project)
			throws PackagerException {
		try {
			this.createDirectory(project);
		} catch (IOException e) {
			throw new PackagerException("Unable to create project directory", e);
		}
		try {
			this.createDirectory(new File(project, "src"));
		} catch (IOException e) {
			throw new PackagerException("Unable to create src directory", e);
		}
		try {
			this.createDirectory(new File(project, "src/main"));
		} catch (IOException e) {
			throw new PackagerException("Unable to create src/main directory",
					e);
		}
		try {
			this.createDirectory(new File(project, "src/main/resources"));
		} catch (IOException e) {
			throw new PackagerException(
					"Unable to create src/main/resources directory", e);
		}
		try {
			this.createDirectory(new File(project,
					"src/main/resources/META-INF"));
		} catch (IOException e) {
			throw new PackagerException(
					"Unable to create src/main/resources/META-INF directory", e);
		}
		try {
			this.createDirectory(new File(project,
					"src/main/resources/OSGI-INF"));
		} catch (IOException e) {
			throw new PackagerException(
					"Unable to create src/main/resources/OSGI-INF directory", e);
		}
		try {
			this.createDirectory(new File(project,
					"src/main/resources/OSGI-INF/uml"));
		} catch (IOException e) {
			throw new PackagerException(
					"Unable to create src/main/resources/OSGI-INF/uml directory", e);
		}
		try {
			this
					.createDirectory(new File(project,
							"src/main/resources/schemas"));
		} catch (IOException e) {
			throw new PackagerException(
					"Unable to create src/main/resources/schemas directory", e);
		}
		try {
			this.createDirectory(new File(project,
					"src/main/resources/directories"));
		} catch (IOException e) {
			throw new PackagerException(
					"Unable to create src/main/resources/directories directory",
					e);
		}
	}

	protected void createDirectory(File directory) throws IOException {
		if (!directory.exists()) {
			directory.getParentFile().mkdirs();
			directory.mkdir();
		}
	}

	protected File createFile(File parent, String name) throws IOException {
		File result = new File(parent, name);
		if (!result.exists()) {
			result.createNewFile();
		}
		return result;
	}
	
	protected void recursiveDelete( File parent ) {
		if( parent.exists() ) {
			if( parent.isDirectory() ) {
				for( File child : parent.listFiles() ) {
					this.recursiveDelete( child ) ;
				}
			}
			parent.delete() ;
		}
	}

	static protected class PackageGetter extends UMLSwitch<EObject> {
		protected String packageName;

		public String getPackageName(UMLResource resource) {
			this.packageName = null;
			this.doSwitch(resource.getContents().get(0));

			return this.packageName;
		}

		@Override
		public EObject casePackage(org.eclipse.uml2.uml.Package object) {

			this.packageName = object.getName();

			return object;
		}

	}

	

}
