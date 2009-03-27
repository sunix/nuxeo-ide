/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.workflow;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.skinsoft.nuxeo.components.workflow.WorkflowFactory
 * @model kind="package"
 * @generated
 */
public interface WorkflowPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "workflow";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://skinsoft.org/nuxeo/components/workflow";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "workflow";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WorkflowPackage eINSTANCE = org.skinsoft.nuxeo.components.workflow.impl.WorkflowPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.workflow.impl.ComponentTypeImpl <em>Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.workflow.impl.ComponentTypeImpl
	 * @see org.skinsoft.nuxeo.components.workflow.impl.WorkflowPackageImpl#getComponentType()
	 * @generated
	 */
	int COMPONENT_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__EXTENSION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.workflow.impl.DefinitionTypeImpl <em>Definition Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.workflow.impl.DefinitionTypeImpl
	 * @see org.skinsoft.nuxeo.components.workflow.impl.WorkflowPackageImpl#getDefinitionType()
	 * @generated
	 */
	int DEFINITION_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Engine Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_TYPE__ENGINE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Mimetype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_TYPE__MIMETYPE = 1;

	/**
	 * The feature id for the '<em><b>Definition Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_TYPE__DEFINITION_PATH = 2;

	/**
	 * The number of structural features of the '<em>Definition Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.workflow.impl.DocTypeRuleTypeImpl <em>Doc Type Rule Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.workflow.impl.DocTypeRuleTypeImpl
	 * @see org.skinsoft.nuxeo.components.workflow.impl.WorkflowPackageImpl#getDocTypeRuleType()
	 * @generated
	 */
	int DOC_TYPE_RULE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Workflow Definition</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOC_TYPE_RULE_TYPE__WORKFLOW_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Doc Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOC_TYPE_RULE_TYPE__DOC_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Doc Type Rule Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOC_TYPE_RULE_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.workflow.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.workflow.impl.DocumentRootImpl
	 * @see org.skinsoft.nuxeo.components.workflow.impl.WorkflowPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 3;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__COMPONENT = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.workflow.impl.ExtensionTypeImpl <em>Extension Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.workflow.impl.ExtensionTypeImpl
	 * @see org.skinsoft.nuxeo.components.workflow.impl.WorkflowPackageImpl#getExtensionType()
	 * @generated
	 */
	int EXTENSION_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Workflow Document Security Policy</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__WORKFLOW_DOCUMENT_SECURITY_POLICY = 1;

	/**
	 * The feature id for the '<em><b>Doc Type Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__DOC_TYPE_RULE = 2;

	/**
	 * The feature id for the '<em><b>Path Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__PATH_RULE = 3;

	/**
	 * The feature id for the '<em><b>Workflow Document Security Policy Relation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION = 4;

	/**
	 * The feature id for the '<em><b>Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__POINT = 5;

	/**
	 * The feature id for the '<em><b>Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__TARGET = 6;

	/**
	 * The number of structural features of the '<em>Extension Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.workflow.impl.PathRuleTypeImpl <em>Path Rule Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.workflow.impl.PathRuleTypeImpl
	 * @see org.skinsoft.nuxeo.components.workflow.impl.WorkflowPackageImpl#getPathRuleType()
	 * @generated
	 */
	int PATH_RULE_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Workflow Definition</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_RULE_TYPE__WORKFLOW_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_RULE_TYPE__PATH = 1;

	/**
	 * The number of structural features of the '<em>Path Rule Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_RULE_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.workflow.impl.WorkflowDocumentSecurityPolicyRelationTypeImpl <em>Document Security Policy Relation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.workflow.impl.WorkflowDocumentSecurityPolicyRelationTypeImpl
	 * @see org.skinsoft.nuxeo.components.workflow.impl.WorkflowPackageImpl#getWorkflowDocumentSecurityPolicyRelationType()
	 * @generated
	 */
	int WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Workflow Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE__WORKFLOW_NAME = 0;

	/**
	 * The feature id for the '<em><b>For</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE__FOR = 1;

	/**
	 * The number of structural features of the '<em>Document Security Policy Relation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.workflow.impl.WorkflowDocumentSecurityPolicyTypeImpl <em>Document Security Policy Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.workflow.impl.WorkflowDocumentSecurityPolicyTypeImpl
	 * @see org.skinsoft.nuxeo.components.workflow.impl.WorkflowPackageImpl#getWorkflowDocumentSecurityPolicyType()
	 * @generated
	 */
	int WORKFLOW_DOCUMENT_SECURITY_POLICY_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_DOCUMENT_SECURITY_POLICY_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_DOCUMENT_SECURITY_POLICY_TYPE__CLASS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_DOCUMENT_SECURITY_POLICY_TYPE__NAME = 2;

	/**
	 * The number of structural features of the '<em>Document Security Policy Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_DOCUMENT_SECURITY_POLICY_TYPE_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.workflow.ComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Type</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.ComponentType
	 * @generated
	 */
	EClass getComponentType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.workflow.ComponentType#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extension</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.ComponentType#getExtension()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_Extension();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.workflow.ComponentType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.ComponentType#getName()
	 * @see #getComponentType()
	 * @generated
	 */
	EAttribute getComponentType_Name();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.workflow.DefinitionType <em>Definition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Definition Type</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.DefinitionType
	 * @generated
	 */
	EClass getDefinitionType();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.workflow.DefinitionType#getEngineName <em>Engine Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Engine Name</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.DefinitionType#getEngineName()
	 * @see #getDefinitionType()
	 * @generated
	 */
	EAttribute getDefinitionType_EngineName();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.workflow.DefinitionType#getMimetype <em>Mimetype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mimetype</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.DefinitionType#getMimetype()
	 * @see #getDefinitionType()
	 * @generated
	 */
	EAttribute getDefinitionType_Mimetype();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.workflow.DefinitionType#getDefinitionPath <em>Definition Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Definition Path</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.DefinitionType#getDefinitionPath()
	 * @see #getDefinitionType()
	 * @generated
	 */
	EAttribute getDefinitionType_DefinitionPath();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.workflow.DocTypeRuleType <em>Doc Type Rule Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Doc Type Rule Type</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.DocTypeRuleType
	 * @generated
	 */
	EClass getDocTypeRuleType();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.workflow.DocTypeRuleType#getWorkflowDefinition <em>Workflow Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Workflow Definition</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.DocTypeRuleType#getWorkflowDefinition()
	 * @see #getDocTypeRuleType()
	 * @generated
	 */
	EAttribute getDocTypeRuleType_WorkflowDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.workflow.DocTypeRuleType#getDocType <em>Doc Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Doc Type</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.DocTypeRuleType#getDocType()
	 * @see #getDocTypeRuleType()
	 * @generated
	 */
	EAttribute getDocTypeRuleType_DocType();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.workflow.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.workflow.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.skinsoft.nuxeo.components.workflow.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.skinsoft.nuxeo.components.workflow.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.workflow.DocumentRoot#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.DocumentRoot#getComponent()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Component();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.workflow.ExtensionType <em>Extension Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Type</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.ExtensionType
	 * @generated
	 */
	EClass getExtensionType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.workflow.ExtensionType#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Definition</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.ExtensionType#getDefinition()
	 * @see #getExtensionType()
	 * @generated
	 */
	EReference getExtensionType_Definition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.workflow.ExtensionType#getWorkflowDocumentSecurityPolicy <em>Workflow Document Security Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Workflow Document Security Policy</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.ExtensionType#getWorkflowDocumentSecurityPolicy()
	 * @see #getExtensionType()
	 * @generated
	 */
	EReference getExtensionType_WorkflowDocumentSecurityPolicy();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.workflow.ExtensionType#getDocTypeRule <em>Doc Type Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Doc Type Rule</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.ExtensionType#getDocTypeRule()
	 * @see #getExtensionType()
	 * @generated
	 */
	EReference getExtensionType_DocTypeRule();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.workflow.ExtensionType#getPathRule <em>Path Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Path Rule</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.ExtensionType#getPathRule()
	 * @see #getExtensionType()
	 * @generated
	 */
	EReference getExtensionType_PathRule();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.workflow.ExtensionType#getWorkflowDocumentSecurityPolicyRelation <em>Workflow Document Security Policy Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Workflow Document Security Policy Relation</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.ExtensionType#getWorkflowDocumentSecurityPolicyRelation()
	 * @see #getExtensionType()
	 * @generated
	 */
	EReference getExtensionType_WorkflowDocumentSecurityPolicyRelation();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.workflow.ExtensionType#getPoint <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Point</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.ExtensionType#getPoint()
	 * @see #getExtensionType()
	 * @generated
	 */
	EAttribute getExtensionType_Point();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.workflow.ExtensionType#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.ExtensionType#getTarget()
	 * @see #getExtensionType()
	 * @generated
	 */
	EAttribute getExtensionType_Target();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.workflow.PathRuleType <em>Path Rule Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Rule Type</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.PathRuleType
	 * @generated
	 */
	EClass getPathRuleType();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.workflow.PathRuleType#getWorkflowDefinition <em>Workflow Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Workflow Definition</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.PathRuleType#getWorkflowDefinition()
	 * @see #getPathRuleType()
	 * @generated
	 */
	EAttribute getPathRuleType_WorkflowDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.workflow.PathRuleType#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.PathRuleType#getPath()
	 * @see #getPathRuleType()
	 * @generated
	 */
	EAttribute getPathRuleType_Path();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyRelationType <em>Document Security Policy Relation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Security Policy Relation Type</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyRelationType
	 * @generated
	 */
	EClass getWorkflowDocumentSecurityPolicyRelationType();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyRelationType#getWorkflowName <em>Workflow Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Workflow Name</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyRelationType#getWorkflowName()
	 * @see #getWorkflowDocumentSecurityPolicyRelationType()
	 * @generated
	 */
	EAttribute getWorkflowDocumentSecurityPolicyRelationType_WorkflowName();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyRelationType#getFor <em>For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>For</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyRelationType#getFor()
	 * @see #getWorkflowDocumentSecurityPolicyRelationType()
	 * @generated
	 */
	EAttribute getWorkflowDocumentSecurityPolicyRelationType_For();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyType <em>Document Security Policy Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Security Policy Type</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyType
	 * @generated
	 */
	EClass getWorkflowDocumentSecurityPolicyType();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyType#getValue()
	 * @see #getWorkflowDocumentSecurityPolicyType()
	 * @generated
	 */
	EAttribute getWorkflowDocumentSecurityPolicyType_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyType#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyType#getClass_()
	 * @see #getWorkflowDocumentSecurityPolicyType()
	 * @generated
	 */
	EAttribute getWorkflowDocumentSecurityPolicyType_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyType#getName()
	 * @see #getWorkflowDocumentSecurityPolicyType()
	 * @generated
	 */
	EAttribute getWorkflowDocumentSecurityPolicyType_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WorkflowFactory getWorkflowFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.workflow.impl.ComponentTypeImpl <em>Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.workflow.impl.ComponentTypeImpl
		 * @see org.skinsoft.nuxeo.components.workflow.impl.WorkflowPackageImpl#getComponentType()
		 * @generated
		 */
		EClass COMPONENT_TYPE = eINSTANCE.getComponentType();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_TYPE__EXTENSION = eINSTANCE.getComponentType_Extension();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_TYPE__NAME = eINSTANCE.getComponentType_Name();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.workflow.impl.DefinitionTypeImpl <em>Definition Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.workflow.impl.DefinitionTypeImpl
		 * @see org.skinsoft.nuxeo.components.workflow.impl.WorkflowPackageImpl#getDefinitionType()
		 * @generated
		 */
		EClass DEFINITION_TYPE = eINSTANCE.getDefinitionType();

		/**
		 * The meta object literal for the '<em><b>Engine Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFINITION_TYPE__ENGINE_NAME = eINSTANCE.getDefinitionType_EngineName();

		/**
		 * The meta object literal for the '<em><b>Mimetype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFINITION_TYPE__MIMETYPE = eINSTANCE.getDefinitionType_Mimetype();

		/**
		 * The meta object literal for the '<em><b>Definition Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFINITION_TYPE__DEFINITION_PATH = eINSTANCE.getDefinitionType_DefinitionPath();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.workflow.impl.DocTypeRuleTypeImpl <em>Doc Type Rule Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.workflow.impl.DocTypeRuleTypeImpl
		 * @see org.skinsoft.nuxeo.components.workflow.impl.WorkflowPackageImpl#getDocTypeRuleType()
		 * @generated
		 */
		EClass DOC_TYPE_RULE_TYPE = eINSTANCE.getDocTypeRuleType();

		/**
		 * The meta object literal for the '<em><b>Workflow Definition</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOC_TYPE_RULE_TYPE__WORKFLOW_DEFINITION = eINSTANCE.getDocTypeRuleType_WorkflowDefinition();

		/**
		 * The meta object literal for the '<em><b>Doc Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOC_TYPE_RULE_TYPE__DOC_TYPE = eINSTANCE.getDocTypeRuleType_DocType();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.workflow.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.workflow.impl.DocumentRootImpl
		 * @see org.skinsoft.nuxeo.components.workflow.impl.WorkflowPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__COMPONENT = eINSTANCE.getDocumentRoot_Component();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.workflow.impl.ExtensionTypeImpl <em>Extension Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.workflow.impl.ExtensionTypeImpl
		 * @see org.skinsoft.nuxeo.components.workflow.impl.WorkflowPackageImpl#getExtensionType()
		 * @generated
		 */
		EClass EXTENSION_TYPE = eINSTANCE.getExtensionType();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TYPE__DEFINITION = eINSTANCE.getExtensionType_Definition();

		/**
		 * The meta object literal for the '<em><b>Workflow Document Security Policy</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TYPE__WORKFLOW_DOCUMENT_SECURITY_POLICY = eINSTANCE.getExtensionType_WorkflowDocumentSecurityPolicy();

		/**
		 * The meta object literal for the '<em><b>Doc Type Rule</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TYPE__DOC_TYPE_RULE = eINSTANCE.getExtensionType_DocTypeRule();

		/**
		 * The meta object literal for the '<em><b>Path Rule</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TYPE__PATH_RULE = eINSTANCE.getExtensionType_PathRule();

		/**
		 * The meta object literal for the '<em><b>Workflow Document Security Policy Relation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TYPE__WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION = eINSTANCE.getExtensionType_WorkflowDocumentSecurityPolicyRelation();

		/**
		 * The meta object literal for the '<em><b>Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_TYPE__POINT = eINSTANCE.getExtensionType_Point();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_TYPE__TARGET = eINSTANCE.getExtensionType_Target();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.workflow.impl.PathRuleTypeImpl <em>Path Rule Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.workflow.impl.PathRuleTypeImpl
		 * @see org.skinsoft.nuxeo.components.workflow.impl.WorkflowPackageImpl#getPathRuleType()
		 * @generated
		 */
		EClass PATH_RULE_TYPE = eINSTANCE.getPathRuleType();

		/**
		 * The meta object literal for the '<em><b>Workflow Definition</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATH_RULE_TYPE__WORKFLOW_DEFINITION = eINSTANCE.getPathRuleType_WorkflowDefinition();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATH_RULE_TYPE__PATH = eINSTANCE.getPathRuleType_Path();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.workflow.impl.WorkflowDocumentSecurityPolicyRelationTypeImpl <em>Document Security Policy Relation Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.workflow.impl.WorkflowDocumentSecurityPolicyRelationTypeImpl
		 * @see org.skinsoft.nuxeo.components.workflow.impl.WorkflowPackageImpl#getWorkflowDocumentSecurityPolicyRelationType()
		 * @generated
		 */
		EClass WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE = eINSTANCE.getWorkflowDocumentSecurityPolicyRelationType();

		/**
		 * The meta object literal for the '<em><b>Workflow Name</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE__WORKFLOW_NAME = eINSTANCE.getWorkflowDocumentSecurityPolicyRelationType_WorkflowName();

		/**
		 * The meta object literal for the '<em><b>For</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE__FOR = eINSTANCE.getWorkflowDocumentSecurityPolicyRelationType_For();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.workflow.impl.WorkflowDocumentSecurityPolicyTypeImpl <em>Document Security Policy Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.workflow.impl.WorkflowDocumentSecurityPolicyTypeImpl
		 * @see org.skinsoft.nuxeo.components.workflow.impl.WorkflowPackageImpl#getWorkflowDocumentSecurityPolicyType()
		 * @generated
		 */
		EClass WORKFLOW_DOCUMENT_SECURITY_POLICY_TYPE = eINSTANCE.getWorkflowDocumentSecurityPolicyType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKFLOW_DOCUMENT_SECURITY_POLICY_TYPE__VALUE = eINSTANCE.getWorkflowDocumentSecurityPolicyType_Value();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKFLOW_DOCUMENT_SECURITY_POLICY_TYPE__CLASS = eINSTANCE.getWorkflowDocumentSecurityPolicyType_Class();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKFLOW_DOCUMENT_SECURITY_POLICY_TYPE__NAME = eINSTANCE.getWorkflowDocumentSecurityPolicyType_Name();

	}

} //WorkflowPackage
