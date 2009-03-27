/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.workflow.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.skinsoft.nuxeo.components.workflow.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorkflowFactoryImpl extends EFactoryImpl implements WorkflowFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WorkflowFactory init() {
		try {
			WorkflowFactory theWorkflowFactory = (WorkflowFactory)EPackage.Registry.INSTANCE.getEFactory("http://skinsoft.org/nuxeo/components/workflow"); 
			if (theWorkflowFactory != null) {
				return theWorkflowFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new WorkflowFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case WorkflowPackage.COMPONENT_TYPE: return createComponentType();
			case WorkflowPackage.DEFINITION_TYPE: return createDefinitionType();
			case WorkflowPackage.DOC_TYPE_RULE_TYPE: return createDocTypeRuleType();
			case WorkflowPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case WorkflowPackage.EXTENSION_TYPE: return createExtensionType();
			case WorkflowPackage.PATH_RULE_TYPE: return createPathRuleType();
			case WorkflowPackage.WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE: return createWorkflowDocumentSecurityPolicyRelationType();
			case WorkflowPackage.WORKFLOW_DOCUMENT_SECURITY_POLICY_TYPE: return createWorkflowDocumentSecurityPolicyType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentType createComponentType() {
		ComponentTypeImpl componentType = new ComponentTypeImpl();
		return componentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefinitionType createDefinitionType() {
		DefinitionTypeImpl definitionType = new DefinitionTypeImpl();
		return definitionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocTypeRuleType createDocTypeRuleType() {
		DocTypeRuleTypeImpl docTypeRuleType = new DocTypeRuleTypeImpl();
		return docTypeRuleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionType createExtensionType() {
		ExtensionTypeImpl extensionType = new ExtensionTypeImpl();
		return extensionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathRuleType createPathRuleType() {
		PathRuleTypeImpl pathRuleType = new PathRuleTypeImpl();
		return pathRuleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowDocumentSecurityPolicyRelationType createWorkflowDocumentSecurityPolicyRelationType() {
		WorkflowDocumentSecurityPolicyRelationTypeImpl workflowDocumentSecurityPolicyRelationType = new WorkflowDocumentSecurityPolicyRelationTypeImpl();
		return workflowDocumentSecurityPolicyRelationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowDocumentSecurityPolicyType createWorkflowDocumentSecurityPolicyType() {
		WorkflowDocumentSecurityPolicyTypeImpl workflowDocumentSecurityPolicyType = new WorkflowDocumentSecurityPolicyTypeImpl();
		return workflowDocumentSecurityPolicyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowPackage getWorkflowPackage() {
		return (WorkflowPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static WorkflowPackage getPackage() {
		return WorkflowPackage.eINSTANCE;
	}

} //WorkflowFactoryImpl
