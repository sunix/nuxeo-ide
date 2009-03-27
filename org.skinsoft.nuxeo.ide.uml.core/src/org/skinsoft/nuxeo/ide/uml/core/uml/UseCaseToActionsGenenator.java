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
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLResource.XMLInfo;
import org.eclipse.emf.ecore.xmi.XMLResource.XMLMap;
import org.eclipse.emf.ecore.xmi.impl.XMLInfoImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extend;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UseCase;
import org.skinsoft.nuxeo.components.actions.ActionType;
import org.skinsoft.nuxeo.components.actions.ActionsFactory;
import org.skinsoft.nuxeo.components.actions.DocumentRoot;
import org.skinsoft.nuxeo.components.actions.ExtensionType;
import org.skinsoft.nuxeo.components.actions.FilterType;
import org.skinsoft.nuxeo.components.actions.RuleType;
import org.skinsoft.nuxeo.components.jbpm.service.ProcessDefinitionType;
import org.skinsoft.nuxeo.components.jbpm.service.SecurityPolicyType;
import org.skinsoft.nuxeo.components.jbpm.service.ServiceFactory;
import org.skinsoft.nuxeo.components.jbpm.service.TypeType;
import org.skinsoft.nuxeo.components.permissions.ItemType;
import org.skinsoft.nuxeo.components.permissions.PermissionType;
import org.skinsoft.nuxeo.components.permissions.PermissionsFactory;
import org.skinsoft.nuxeo.components.permissions.VisibilityType;
import org.skinsoft.nuxeo.components.workflow.DefinitionType;
import org.skinsoft.nuxeo.components.workflow.DocTypeRuleType;
import org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyRelationType;
import org.skinsoft.nuxeo.components.workflow.WorkflowFactory;
import org.skinsoft.nuxeo.ide.uml.core.util.TransformationsUtils;

/**
 * <p>Generates actions and permissions contrib based on use case diagrams.</p>
 * <p>Workflow contribution are also supported.</p>
 * 
 * @author nel
 *
 */
public class UseCaseToActionsGenenator {
	
	private static final String JBPM_WORKFLOW_SUFFIX = ".uml.jbpm.workflow";
	private static final String WORKFLOW_SUFFIX = ".uml.workflow";
	public static final String PERMISSIONS_SUFFIX = ".uml.permissions";
	public static final String ACTIONS_SUFFIX = ".uml.actions";
	
	public static final String EXTENSION_POINT_WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION = "workflowDocumentSecurityPolicyRelation";
	public static final String TARGET_WORKFLOW_DOCUMENT_SECURITY_POLICY_SERVICE = "org.nuxeo.ecm.platform.workflow.document.service.WorkflowDocumentSecurityPolicyService";
	public static final String EXTENSION_POINT_DOC_TYPE_RULE = "docTypeRule";
	public static final String TARGET_WORKFLOW_RULES_SERVICE = "org.nuxeo.ecm.platform.workflow.document.service.WorkflowRulesService";
	public static final String EXTENSION_POINT_DEFINITION = "definition";
	public static final String TARGET_WORKFLOW_SERVICE = "org.nuxeo.ecm.platform.workflow.service.WorkflowService";
	public static final String DEFAULT_WORKFLOW_SECURITY_POLICY = "document-modification-policy-based";
	public static final String DEFAULT_WORKFLOW_DEFINITION_MIMETYPE = "text/xml";
	public static final String DEFAULT_WORKFLOW_ENGINE = "jbpm";
	public static final String WORKFLOW = "Workflow";
	static public final String TARGET_ACTION_SERVICE = "org.nuxeo.ecm.platform.actions.ActionService" ;
	static public final String TARGET_SECURITY_SERVICE = "org.nuxeo.ecm.core.security.SecurityService" ;
	
	static public final String TARGET_JBPM_SERVICE =  "org.nuxeo.ecm.platform.jbpm.core.JbpmService" ;
	static public final String EXTENSION_POINT_JBPM_PROCESS_DEFINITION = "processDefinition" ;
	static public final String EXTENSION_POINT_JBPM_SECURITY_POLICY = "securityPolicy" ;
	static public final String EXTENSION_POINT_JBPM_TYPE_FILTER = "typeFilter" ;

	static public final String EXTENSION_POINT_ACTIONS = "actions" ;
	static public final String EXTENSION_POINT_FILTERS = "filters" ;
	
	static public final String EXTENSION_POINT_PERMISSIONS = "permissions" ;
	static public final String EXTENSION_POINT_PERMISSIONS_VISIBILITY = "permissionsVisibility" ;
	
	static public final String SUBACTIONS_SUFFIX = "_SUBACTIONS" ;
	
	static public enum WorkflowTypeEnum {
		OLD_TYPE ,
		JBPM_SERVICE
	}
	
	protected WorkflowTypeEnum workflowType = WorkflowTypeEnum.JBPM_SERVICE ;
	
	protected ActionsFactory actionsFactory ;
	protected PermissionsFactory permissionsFactory ;
	protected WorkflowFactory workflowFactory ;
	protected ServiceFactory jbpmServiceFactory ;
	
	protected DocumentRoot actionsContrib ;
	protected ExtensionType actionsExtension ;
	
	protected org.skinsoft.nuxeo.components.permissions.DocumentRoot permissionsContrib ;
	protected org.skinsoft.nuxeo.components.permissions.ExtensionType permissionsExtension ;
	protected org.skinsoft.nuxeo.components.permissions.ExtensionType visibilityExtension ;
	
	protected org.skinsoft.nuxeo.components.workflow.DocumentRoot workflowContrib ;
	protected org.skinsoft.nuxeo.components.workflow.ExtensionType workflowDefinitionExtension ;
	protected org.skinsoft.nuxeo.components.workflow.ExtensionType workflowDocTypeRuleExtension ;
	protected org.skinsoft.nuxeo.components.workflow.ExtensionType workflowDocumentSecurityPolicyRelationExtension ;
	
	protected org.skinsoft.nuxeo.components.jbpm.service.DocumentRoot jbpmServiceContrib ;
	protected org.skinsoft.nuxeo.components.jbpm.service.ExtensionType jbpmServiceProcessDefinitionExtension ;
	protected org.skinsoft.nuxeo.components.jbpm.service.ExtensionType jbpmServiceSecurityPolicyExtension ;
	protected org.skinsoft.nuxeo.components.jbpm.service.ExtensionType jbpmServiceTypeFilterExtension ;
	
	
	protected String componentBaseName ;
	
	protected HashMap<Component, List<FilterType>> componentFilters ;
	
	protected File packageResourcesRepository ;
	protected Package umlPackage;

//	protected MessagesBuilder messagesBuilder ;
	
	
	public UseCaseToActionsGenenator( 
			ActionsFactory actionsFactory , 
			PermissionsFactory permissionsFactory /*, 
			MessagesBuilder messagesBuilder*/ , 
			WorkflowFactory workflowFactory ,
			ServiceFactory jbpmServiceFactory ,
			String packageName ,
			File packageResourcesRepository ) {
		super();
		this.actionsFactory = actionsFactory ;
		this.permissionsFactory = permissionsFactory ;
//		this.messagesBuilder = messagesBuilder ;
		this.workflowFactory = workflowFactory ;
		this.jbpmServiceFactory = jbpmServiceFactory ;
		
		this.componentFilters = new HashMap<Component, List<FilterType>>() ;
		
		this.packageResourcesRepository = packageResourcesRepository ;

		this.initContribution( packageName ) ;
		
	}
	
	protected void orderActorsOnGeneralization( ArrayList<Actor> actors ) {
		if( actors == null || actors.size() == 0 ) return ;
		
		boolean changesMade = true ;
		
		while( changesMade ) {
			changesMade = false ;
			
			for( int i = 0 ; i < actors.size() ; i++ ) {
				Actor base = actors.get( i ) ;
				for( int j = i + 1 ; j < actors.size() ; j++ ) {
					Actor actor = actors.get( j ) ;
					if( this.hasGeneral( base , actor ) ) {
						changesMade = true ;
						actors.remove( base ) ;
						actors.add( actors.indexOf( actor ) + 1 , base ) ;
						break ;
					}
				}
				
				if( changesMade ) {
					break ;
				}
			}
			
		}
		
	}
	
	protected boolean hasGeneral( Actor actor , Actor general ) {
		for( Generalization generalization : actor.getGeneralizations() ) {
			if( 
					general.equals( generalization.getGeneral() ) ||
					general.getName().equals( generalization.getGeneral().getName() ) ) {
				return true ;
			} else if( generalization.getGeneral() instanceof Actor ) {
				if( hasGeneral( (Actor) generalization.getGeneral() , general ) ) {
					return true ;
				}
			}
		}
		return false ;
	}

	public DocumentRoot computeActionsContrib( Package pack ) {
		
		this.umlPackage = pack ;
		
		this.setComponentBaseName( this.getBeanPrefix( pack ) ) ;
		
		// actors have to be ordered so that sub permission are
		// created before
		
		ArrayList<Actor> orderedActors = new ArrayList<Actor>( this.filterList( pack.getPackagedElements() , Actor.class ) ) ;
		this.orderActorsOnGeneralization( orderedActors ) ;
		
		for( Actor actor : orderedActors ) {
			if( ! actor.isAbstract() ) {
				
				PermissionType perm = this.permissionsFactory.createPermissionType() ;
				
				for( Generalization generalization : actor.getGeneralizations() ) {
					if( generalization.getGeneral() instanceof Actor ) {
						perm.getInclude().add( ((Actor)generalization.getGeneral()).getName() ) ;
					}
				}
				
				this.permissionsExtension.getPermission().add( perm ) ;
				perm.setName( actor.getName() ) ;
				
				System.out.println( "Add Perm : " + perm.getName() );
			}
		}
		
		for( Component component : this.filterList( pack.getPackagedElements() , Component.class ) ) {
			System.out.println( "Component " + component.getName() ) ;
			
			VisibilityType componentVisibility = this.permissionsFactory.createVisibilityType() ;
			this.visibilityExtension.getVisibility().add( componentVisibility ) ;
			componentVisibility.setType( TransformationsUtils.normaliseTypeName( component.getName() ) ) ;
			
			HashSet<String> added = new HashSet<String>() ;
			int order = 100 ;
			for( Actor actor : this.retrieveActors( component ) ) {
				if( ! added.contains( actor.getName() ) ) {
					ItemType item = this.permissionsFactory.createItemType() ;
					componentVisibility.getItem().add( item ) ;
					item.setOrder( order ) ;
					item.setShow( "true" ) ;
					item.setValue( actor.getName() ) ;
					order ++ ;
					added.add( actor.getName() ) ;
				}
			}
			
			for( UseCase uc : component.getUseCases() ) {
				if( ! uc.isAbstract() ) {
					System.out.println( "\tuse case " + uc.getName() );
					this.createUseCaseAction( uc , component , pack ) ;
				}
			}
		}
		
		return this.actionsContrib ;
	}
	
	

	private String getBeanPrefix( Package pack ) {
		for( Constraint constraint : this.filterList( pack.getPackagedElements() , Constraint.class ) ) {
			if( constraint.getConstrainedElements().contains( pack ) && constraint.getName().startsWith( "beanPrefix=" ) ) {
				return constraint.getName().substring( "beanPrefix=".length() ) ;
			}
		}
		return null;
	}

	private void initContribution( String packageName ) {
		this.actionsContrib = this.actionsFactory.createDocumentRoot() ;
		this.actionsContrib.setComponent( this.actionsFactory.createComponentType() ) ;
		this.actionsContrib.getComponent().setName( packageName + ACTIONS_SUFFIX ) ;
		
		this.actionsExtension = this.actionsFactory.createExtensionType() ;
		this.actionsContrib.getComponent().getExtension().add( this.actionsExtension ) ;
		this.actionsExtension.setTarget( TARGET_ACTION_SERVICE ) ;
		this.actionsExtension.setPoint( EXTENSION_POINT_ACTIONS ) ;
		
		this.permissionsContrib = this.permissionsFactory.createDocumentRoot() ;
		this.permissionsContrib.setComponent( this.permissionsFactory.createComponentType() ) ;
		this.permissionsContrib.getComponent().setName( packageName + PERMISSIONS_SUFFIX ) ;
		
		this.permissionsExtension = this.permissionsFactory.createExtensionType() ;
		this.permissionsContrib.getComponent().getExtension().add( this.permissionsExtension ) ;
		this.permissionsExtension.setTarget( TARGET_SECURITY_SERVICE ) ;
		this.permissionsExtension.setPoint( EXTENSION_POINT_PERMISSIONS ) ;
		
		this.visibilityExtension = this.permissionsFactory.createExtensionType() ;
		this.permissionsContrib.getComponent().getExtension().add( this.visibilityExtension ) ;
		this.visibilityExtension.setTarget( TARGET_SECURITY_SERVICE ) ;
		this.visibilityExtension.setPoint( EXTENSION_POINT_PERMISSIONS_VISIBILITY ) ;
		
		if( this.workflowType == WorkflowTypeEnum.OLD_TYPE ) {
			this.initOldTypeWorkflowContrib(packageName);
		} else if( this.workflowType == WorkflowTypeEnum.JBPM_SERVICE ) {
			this.initJbpmServiceTypeWorkflowContrib( packageName ) ;
		}
		
	}


	private void initOldTypeWorkflowContrib(String packageName) {
		this.workflowContrib = this.workflowFactory.createDocumentRoot() ;
		this.workflowContrib.setComponent( this.workflowFactory.createComponentType() ) ;
		this.workflowContrib.getComponent().setName( packageName + WORKFLOW_SUFFIX ) ;
		
		this.workflowDefinitionExtension = this.workflowFactory.createExtensionType() ;
		this.workflowContrib.getComponent().getExtension().add( this.workflowDefinitionExtension ) ;
		this.workflowDefinitionExtension.setTarget( TARGET_WORKFLOW_SERVICE ) ;
		this.workflowDefinitionExtension.setPoint( EXTENSION_POINT_DEFINITION ) ;
		
		this.workflowDocTypeRuleExtension = this.workflowFactory.createExtensionType() ;
		this.workflowContrib.getComponent().getExtension().add( this.workflowDocTypeRuleExtension ) ;
		this.workflowDocTypeRuleExtension.setTarget( TARGET_WORKFLOW_RULES_SERVICE ) ;
		this.workflowDocTypeRuleExtension.setPoint( EXTENSION_POINT_DOC_TYPE_RULE ) ;
		
		this.workflowDocumentSecurityPolicyRelationExtension = this.workflowFactory.createExtensionType() ;
		this.workflowContrib.getComponent().getExtension().add( this.workflowDocumentSecurityPolicyRelationExtension ) ;
		this.workflowDocumentSecurityPolicyRelationExtension.setTarget( TARGET_WORKFLOW_DOCUMENT_SECURITY_POLICY_SERVICE ) ;
		this.workflowDocumentSecurityPolicyRelationExtension.setPoint( EXTENSION_POINT_WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION ) ;
	}
	

	private void initJbpmServiceTypeWorkflowContrib(String packageName) {
		this.jbpmServiceContrib = this.jbpmServiceFactory.createDocumentRoot() ;
		this.jbpmServiceContrib.setComponent( this.jbpmServiceFactory.createComponentType() ) ;
		this.jbpmServiceContrib.getComponent().setName( packageName + JBPM_WORKFLOW_SUFFIX ) ;
		
		this.jbpmServiceProcessDefinitionExtension = this.jbpmServiceFactory.createExtensionType() ;
		this.jbpmServiceContrib.getComponent().getExtension().add( this.jbpmServiceProcessDefinitionExtension ) ;
		this.jbpmServiceProcessDefinitionExtension.setTarget( TARGET_JBPM_SERVICE ) ;
		this.jbpmServiceProcessDefinitionExtension.setPoint( EXTENSION_POINT_JBPM_PROCESS_DEFINITION ) ;
		
		this.jbpmServiceSecurityPolicyExtension = this.jbpmServiceFactory.createExtensionType() ;
		this.jbpmServiceContrib.getComponent().getExtension().add( this.jbpmServiceSecurityPolicyExtension ) ;
		this.jbpmServiceSecurityPolicyExtension.setTarget( TARGET_JBPM_SERVICE ) ;
		this.jbpmServiceSecurityPolicyExtension.setPoint( EXTENSION_POINT_JBPM_SECURITY_POLICY ) ;
		
		this.jbpmServiceTypeFilterExtension = this.jbpmServiceFactory.createExtensionType() ;
		this.jbpmServiceContrib.getComponent().getExtension().add( this.jbpmServiceTypeFilterExtension ) ;
		this.jbpmServiceTypeFilterExtension.setTarget( TARGET_JBPM_SERVICE ) ;
		this.jbpmServiceTypeFilterExtension.setPoint( EXTENSION_POINT_JBPM_TYPE_FILTER ) ;
	}
	
	protected void createUseCaseAction( UseCase uc , Component component , Package pack ) {

		List<String> categories = this.getCategories( uc ) ;
		

		for( Generalization generalization : uc.getGeneralizations() ) {
			if( generalization.getGeneral() instanceof UseCase ) {
				this.handleGenralisation( uc , (UseCase) generalization.getGeneral() ) ;
			}
		}
		
		ActionType result = this.actionsFactory.createActionType() ;
		
		result.setId( this.getUseCaseActionId( uc ) ) ;
		result.setLabel( "actions.label." + result.getId() ) ;
		
		result.setEnabled( "true" ) ;
		

		if( ! categories.isEmpty() ) {
			result.getCategory().addAll( categories ) ;
		}
		
		result.setLink( uc.getName() ) ;
		
		int i = 0 ;
		for( FilterType filter : this.createUseCaseFilters( uc , component , pack ) ) {
			filter.setId( result.getId() + "Filter" + i ) ;
			result.getFilter().add( filter ) ;
			i ++ ;
		}
		
		this.actionsExtension.getAction().add( result ) ;
	}
	
	
	protected String getUseCaseActionId( UseCase uc ) {
		if( uc.getSubjects().isEmpty() ) {
			return TransformationsUtils.normaliseTypeName( uc.getName() ) ;
		} else {
			return TransformationsUtils.normaliseTypeName( uc.getName() ) + "On" + TransformationsUtils.normaliseTypeName( uc.getSubjects().iterator().next().getName() ) ; 
		}
		
	}
	
	protected void handleGenralisation( UseCase uc , UseCase general ) {
		if( WORKFLOW.equals( general.getName() ) ) {
			this.handleWorkflow( uc , general ) ;
		} else {
			System.out.println("UCDiagramToActionsGen.handleGenralisation() -> " + uc.getName() + " -> " + general.getName() ) ;
		}
	}
	
	protected void handleWorkflow(UseCase uc, UseCase general) {
		if( this.workflowType == WorkflowTypeEnum.OLD_TYPE ) {
			this.handleOldTypeWorkflow( uc , general ) ;
		} else if( this.workflowType == WorkflowTypeEnum.JBPM_SERVICE ) {
			this.handleJbpmServiceWorkflow( uc , general ) ;
		}
	}
	
	
	protected void handleOldTypeWorkflow(UseCase uc, UseCase general) {
		
		if( uc.isAbstract() ) return ;
		
		if( ! this.isWorkflowDefined( uc.getName() ) ) {
			if( this.processDefinitionExists( uc.getName() ) ) {
				this.createWorkflowDefinition( uc ) ;
				this.createWorkflowSecurityPolicyAssociation( uc ) ;
			}
		}
		
		for( Classifier subject : uc.getSubjects() ) {
			this.createWorkflowTypeAssociation( uc , subject ) ;
		}
		
	}
	
	protected void handleJbpmServiceWorkflow(UseCase uc, UseCase general) {
		
		if( uc.isAbstract() ) return ;
		
		if( ! this.isWorkflowDefined( uc.getName() ) ) {
			if( this.processDefinitionExists( uc.getName() ) ) {
				/* 
				 	<processDefinition path="process/parallel-review.xml" deployer="ifChanged" />
				 */
				ProcessDefinitionType processDefinition = this.jbpmServiceFactory.createProcessDefinitionType() ;
				this.jbpmServiceProcessDefinitionExtension.getProcessDefinition().add( processDefinition ) ;
				processDefinition.setPath( this.getProcessDefinitionPath( uc.getName() ) ) ;
				processDefinition.setDeployer( "ifChanged" ) ;
				
				/*
					 <securityPolicy
					      class="org.nuxeo.ecm.platform.jbpm.core.service.DefaultJbpmSecurityPolicy"
					      for="review_parallel" />
				 */
				SecurityPolicyType securityPolicy = this.jbpmServiceFactory.createSecurityPolicyType() ;
				this.jbpmServiceSecurityPolicyExtension.getSecurityPolicy().add( securityPolicy ) ;
				securityPolicy.setClass( "org.nuxeo.ecm.platform.jbpm.core.service.DefaultJbpmSecurityPolicy" ) ;
				securityPolicy.setFor( uc.getName() ) ;
			}
		}
		
		for( Classifier subject : uc.getSubjects() ) {
			/*
				<type name="Note">
			      <processDefinition>review_parallel</processDefinition>
			      <processDefinition>review_approbation</processDefinition>
			    </type>
			 */
			TypeType type = this.lookupTypeFilterType( subject.getName() ) ;
			if( type == null ) {
				type = this.jbpmServiceFactory.createTypeType() ;
				this.jbpmServiceTypeFilterExtension.getType().add( type ) ;
				type.setName( subject.getName() ) ;
			}
			
			type.getProcessDefinition().add( uc.getName() ) ;
		}
	}
	
	private TypeType lookupTypeFilterType( String typeName ) {
		for( TypeType type : this.jbpmServiceTypeFilterExtension.getType() ) {
			if( type.getName().equals( typeName ) ) {
				return type ;
			}
		}
		return null ;
	}
	
	private void createWorkflowSecurityPolicyAssociation(UseCase uc) {
		WorkflowDocumentSecurityPolicyRelationType policyRel = this.lookupSecurityPolicyRelations( DEFAULT_WORKFLOW_SECURITY_POLICY ) ;
		
		policyRel.getWorkflowName().add( uc.getName() ) ;
	}

	private void createWorkflowTypeAssociation(UseCase uc, Classifier subject) {
		DocTypeRuleType result = this.lookupDocTypeRuleType( subject.getName() ) ;
		
		result.getWorkflowDefinition().add( uc.getName() ) ;
	}
	
	private void createWorkflowDefinition( UseCase uc ) {
		DefinitionType result = this.workflowFactory.createDefinitionType() ;
		this.workflowDefinitionExtension.getDefinition().add( result ) ;
		
		result.setDefinitionPath( this.getProcessDefinitionPath( uc.getName() ) ) ;
		result.setEngineName( DEFAULT_WORKFLOW_ENGINE ) ;
		result.setMimetype( DEFAULT_WORKFLOW_DEFINITION_MIMETYPE ) ;
	}
	

	private DocTypeRuleType lookupDocTypeRuleType( String typeName ) {
		for( DocTypeRuleType typeRel : this.workflowDocTypeRuleExtension.getDocTypeRule() ) {
			if( typeName.equals( typeRel.getDocType() ) ) {
				return typeRel ;
			}
		}
		
		DocTypeRuleType result = this.workflowFactory.createDocTypeRuleType() ;
		this.workflowDocTypeRuleExtension.getDocTypeRule().add( result ) ;
		
		result.setDocType( typeName ) ;
		
		return result ;
	}
	
	private WorkflowDocumentSecurityPolicyRelationType lookupSecurityPolicyRelations( String securityPolicyName ) {
		for( WorkflowDocumentSecurityPolicyRelationType policyRel : this.workflowDocumentSecurityPolicyRelationExtension.getWorkflowDocumentSecurityPolicyRelation() ) {
			if( securityPolicyName.equals( policyRel.getFor() ) ) {
				return policyRel ;
			}
		}
		
		WorkflowDocumentSecurityPolicyRelationType result = this.workflowFactory.createWorkflowDocumentSecurityPolicyRelationType() ;
		this.workflowDocumentSecurityPolicyRelationExtension.getWorkflowDocumentSecurityPolicyRelation().add( result ) ;
		
		result.setFor( securityPolicyName ) ;
		
		return result ;
	}

	/**
	 * workflows/acquisition-creation/processdefinition.xml
	 * @param name
	 * @return
	 */
	private boolean isWorkflowDefined(String name) {
		if( this.workflowType == WorkflowTypeEnum.OLD_TYPE ) {
			return this.isOldTypeWorkflowDefined( name ) ;
		} else if( this.workflowType == WorkflowTypeEnum.JBPM_SERVICE ) {
			return this.isJbpmServiceTypeWorkflowDefined( name ) ;
		} else {
			return false ;
		}
	}
	
	private boolean isOldTypeWorkflowDefined( String name ) {
		for( DefinitionType definition : this.workflowDefinitionExtension.getDefinition() ) {
			String definitionPath = definition.getDefinitionPath() ;
			
			String defName = definitionPath.substring( 
					"workflows/".length() , 
					definitionPath.length() - "/processdefinition.xml".length()
					) ;
			
			if( name.equals( defName ) ) return true ;
		}
		return false;
	}
	
	private boolean isJbpmServiceTypeWorkflowDefined( String name ) {
		for( ProcessDefinitionType processDefinition : this.jbpmServiceProcessDefinitionExtension.getProcessDefinition() ) {
			String definitionPath = processDefinition.getPath() ;
			

			String defName = definitionPath.substring( 
					"workflows/".length() , 
					definitionPath.length() - "/processdefinition.xml".length()
					) ;
			
			if( name.equals( defName ) ) return true ;
		}
		return false;
	}
	
	private boolean processDefinitionExists( String name ) {
		if( this.packageResourcesRepository == null ) return false ;
		
		File processDefinitionFile = new File( this.packageResourcesRepository , this.getProcessDefinitionPath( name ) ) ;
		return processDefinitionFile.exists() ;
	}

	private String getProcessDefinitionPath(String name) {
		return "workflows/" + name + "/processdefinition.xml";
	}

	protected List<String> getCategories( UseCase uc ) {
		ArrayList<String> result = new ArrayList<String>() ;
		
		if( uc.getExtends().size() > 0 ) {
			for( Extend extend : uc.getExtends() ) {
				result.add( extend.getExtendedCase().getName() ) ;
			}
		}
		
		
		for( DirectedRelationship relationship : uc.getTargetDirectedRelationships( UMLPackage.eINSTANCE.getInclude() ) ) {
			for( Element source : relationship.getSources() ) {
				if( source instanceof UseCase ) {
					result.add( this.getUseCaseActionId( (UseCase)source ) + SUBACTIONS_SUFFIX ) ;
				}
			}
		}
		
		
		return result ;
	}

	protected List<FilterType> createUseCaseFilters( UseCase uc , Component component , Package pack )  {
		ArrayList<FilterType> result = new ArrayList<FilterType>() ;
		
		result.addAll( this.createComponentFilters( component ) ) ;
		
		
		
		// Roles
		List<Actor> actors = this.retrieveActors( uc ) ;
		if( ! actors.isEmpty() ) {
			FilterType filter = this.actionsFactory.createFilterType() ;
			result.add( filter ) ;
			filter.setAppend( "false" )  ;
			
			for( Actor actor : actors ) {
				RuleType rule = this.actionsFactory.createRuleType() ;
				filter.getRule().add( rule ) ;
				rule.setGrant( "true" ) ;
				rule.getPermission().add( TransformationsUtils.normaliseAttributeName( actor.getName() ) ) ;
			}
		}
		
		
		
		// Conditions
		for( Constraint constraint : this.filterList( pack.getPackagedElements() , Constraint.class ) ) {
			if( constraint.getConstrainedElements().contains( uc ) ) {
				FilterType filter = this.actionsFactory.createFilterType() ;
				result.add( filter ) ;
				filter.setAppend( "false" )  ;
				
				RuleType rule = this.actionsFactory.createRuleType() ;
				filter.getRule().add( rule ) ;
				rule.setGrant( "true" ) ;
				rule.getCondition().add( constraint.getName() ) ;
			}
		}
		
		
		return result ;
	}
	
	protected List<Actor> retrieveActors( UseCase uc ) {
		List<Actor> result = new ArrayList<Actor>() ;
		
		for( Association assoc : uc.getAssociations() ) {
			for( Property prop : assoc.getOwnedEnds() ) {
				if( ! uc.equals( prop.getType() ) && prop.getType() instanceof Actor ) {
					result.add( (Actor) prop.getType() ) ;
				}
			}
			
		}
		
		return result ;
	}
	
	protected List<Actor> retrieveActors( Component component ) {
		List<Actor> result = new ArrayList<Actor>() ;
		
		for( UseCase uc : component.getUseCases() ) {
			result.addAll( this.retrieveActors( uc ) ) ;
		}
		
		return result ;
	}
	
	protected List<FilterType> createComponentFilters( Component component ) {
		ArrayList<FilterType> result = new ArrayList<FilterType>() ;
		
		// Type
		FilterType filter = this.actionsFactory.createFilterType() ;
		result.add( filter ) ;
		filter.setAppend( "false" )  ;
		
		RuleType rule = this.actionsFactory.createRuleType() ;
		filter.getRule().add( rule ) ;
		rule.setGrant( "true" ) ;
		rule.getType().add( TransformationsUtils.normaliseTypeName( component.getName() ) ) ;
		
		// Constraints
		for( Constraint constraint : this.filterList( component.getPackage().getPackagedElements() , Constraint.class ) ) {
			if( constraint.getConstrainedElements().contains( component ) ) {
				filter = this.actionsFactory.createFilterType() ;
				result.add( filter ) ;
				filter.setAppend( "false" )  ;
				
				rule = this.actionsFactory.createRuleType() ;
				filter.getRule().add( rule ) ;
				rule.setGrant( "true" ) ;
				rule.getCondition().add( constraint.getName() ) ;
			}
		}
		
		return result ;
	}
	
	
	
	protected <T extends EObject> List<T> filterList( EList list , Class<T> c ) {
		ArrayList<T> result = new ArrayList<T>() ;
		
		for( Object elmt : list ) {
			if( c.isAssignableFrom( elmt.getClass() ) ) {
				result.add( (T) elmt ) ;
			}
		}
		
		return result ;
	}

	public String getComponentBaseName() {
		return componentBaseName;
	}

	public void setComponentBaseName(String componentName) {
		this.componentBaseName = componentName;
	}

	public DocumentRoot getActionsContrib() {
		return actionsContrib;
	}

	public org.skinsoft.nuxeo.components.permissions.DocumentRoot getPermissionsContrib() {
		return permissionsContrib;
	}
	
	public org.skinsoft.nuxeo.components.workflow.DocumentRoot getWorkflowContrib() {
		return this.workflowContrib ;
	}
	
	public org.skinsoft.nuxeo.components.jbpm.service.DocumentRoot getJbpmServiceContrib() {
		return this.jbpmServiceContrib ;
	}
	
	
	public void generatePermissionsContrib( File contribFile ) throws IOException {
		XMLResourceImpl permissionsResource = new XMLResourceImpl( URI.createFileURI( contribFile.getAbsolutePath() ) ) ;
		permissionsResource.getContents().add( this.getPermissionsContrib() ) ;
		
		HashMap<String, Object> permissionsOptions = new HashMap<String, Object>() ;
		permissionsOptions.put( XMLResource.OPTION_ENCODING , "UTF-8" ) ;
		permissionsOptions.put( XMLResource.OPTION_ROOT_OBJECTS , Collections.singletonList( this.getPermissionsContrib().getComponent() ) ) ;

		XMLMap permissionsXmlMap = new XMLMapImpl() ;
		permissionsOptions.put( XMLResource.OPTION_XML_MAP, permissionsXmlMap ) ;
		
		XMLInfo permissionsXmlInfo = new XMLInfoImpl() ;
		
		permissionsXmlInfo.setName( "component" ) ;
		permissionsXmlInfo.setTargetNamespace( null ) ;
		permissionsXmlMap.add( PermissionsFactory.eINSTANCE.getPermissionsPackage().getComponentType() , permissionsXmlInfo ) ;
		
		
		permissionsXmlInfo = new XMLInfoImpl() ;
		permissionsXmlInfo.setXMLRepresentation( XMLInfo.CONTENT ) ;
		permissionsXmlMap.add( PermissionsFactory.eINSTANCE.getPermissionsPackage().getItemType_Value() , permissionsXmlInfo ) ;
		
		permissionsResource.save( permissionsOptions ) ;
	}
	

	public void generateUseCaseActionsContrib( File contribFile ) throws IOException {
		XMLResourceImpl actionsResource = new XMLResourceImpl( URI.createFileURI( contribFile.getAbsolutePath() ) ) ;
		actionsResource.getContents().add( this.getActionsContrib() ) ;
		
		HashMap<String, Object> actionsOptions = new HashMap<String, Object>() ;
		actionsOptions.put( XMLResource.OPTION_ENCODING , "UTF-8" ) ;
		actionsOptions.put( XMLResource.OPTION_ROOT_OBJECTS , Collections.singletonList( this.getActionsContrib().getComponent() ) ) ;
		
		XMLMap actionsXmlMap = new XMLMapImpl() ;
		actionsOptions.put( XMLResource.OPTION_XML_MAP, actionsXmlMap ) ;
		
		XMLInfo actionsXmlInfo = new XMLInfoImpl() ;
		
		actionsXmlInfo.setName( "component" ) ;
		actionsXmlInfo.setTargetNamespace( null ) ;
		actionsXmlMap.add( ActionsFactory.eINSTANCE.getActionsPackage().getComponentType() , actionsXmlInfo ) ;
		
		actionsXmlInfo = new XMLInfoImpl() ;
		actionsXmlInfo.setName( "filter-id" ) ;
		actionsXmlInfo.setTargetNamespace( null ) ;
		actionsXmlMap.add( ActionsFactory.eINSTANCE.getActionsPackage().getActionType_FilterId() , actionsXmlInfo ) ;
		
		
		actionsResource.save( actionsOptions ) ;
	}
	
	public void generateWorkflowContrib( File contribFile ) throws IOException {
		XMLResourceImpl workflowResource = new XMLResourceImpl( URI.createFileURI( contribFile.getAbsolutePath() ) ) ;
		workflowResource.getContents().add( this.getWorkflowContrib() ) ;
		
		HashMap<String, Object> options = new HashMap<String, Object>() ;
		options.put( XMLResource.OPTION_ENCODING , "UTF-8" ) ;
		options.put( XMLResource.OPTION_ROOT_OBJECTS , Collections.singletonList( this.getWorkflowContrib().getComponent() ) ) ;
		
		XMLMap actionsXmlMap = new XMLMapImpl() ;
		options.put( XMLResource.OPTION_XML_MAP, actionsXmlMap ) ;
		
		XMLInfo xmlInfo = new XMLInfoImpl() ;
		
		xmlInfo.setName( "component" ) ;
		xmlInfo.setTargetNamespace( null ) ;
		actionsXmlMap.add( this.workflowFactory.getWorkflowPackage().getComponentType() , xmlInfo ) ;
		
		xmlInfo = new XMLInfoImpl() ;
		xmlInfo.setXMLRepresentation( XMLInfo.ELEMENT ) ;
		actionsXmlMap.add( this.workflowFactory.getWorkflowPackage().getDefinitionType_EngineName() , xmlInfo ) ;
		actionsXmlMap.add( this.workflowFactory.getWorkflowPackage().getDefinitionType_Mimetype() , xmlInfo ) ;
		actionsXmlMap.add( this.workflowFactory.getWorkflowPackage().getDefinitionType_DefinitionPath() , xmlInfo ) ;
		
		workflowResource.save( options ) ;
	}
	
	public void generateJbpmWorkflowContrib( File contribFile ) throws IOException {
		XMLResourceImpl jbpmServiceResource = new XMLResourceImpl( URI.createFileURI( contribFile.getAbsolutePath() ) ) ;
		jbpmServiceResource.getContents().add( this.getJbpmServiceContrib() ) ;
		
		HashMap<String, Object> options = new HashMap<String, Object>() ;
		options.put( XMLResource.OPTION_ENCODING , "UTF-8" ) ;
		options.put( XMLResource.OPTION_ROOT_OBJECTS , Collections.singletonList( this.getJbpmServiceContrib().getComponent() ) ) ;
		
		XMLMap actionsXmlMap = new XMLMapImpl() ;
		options.put( XMLResource.OPTION_XML_MAP, actionsXmlMap ) ;

		XMLInfo xmlInfo = new XMLInfoImpl() ;
		
		xmlInfo.setName( "component" ) ;
		xmlInfo.setTargetNamespace( null ) ;
		actionsXmlMap.add( this.jbpmServiceFactory.getServicePackage().getComponentType() , xmlInfo ) ;
		
		jbpmServiceResource.save( options ) ;
	}
	

	public WorkflowTypeEnum getWorkflowType() {
		return this.workflowType ;
	}

	
}
