/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.workflow.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.skinsoft.nuxeo.components.workflow.ComponentType;
import org.skinsoft.nuxeo.components.workflow.DefinitionType;
import org.skinsoft.nuxeo.components.workflow.DocTypeRuleType;
import org.skinsoft.nuxeo.components.workflow.DocumentRoot;
import org.skinsoft.nuxeo.components.workflow.ExtensionType;
import org.skinsoft.nuxeo.components.workflow.PathRuleType;
import org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyRelationType;
import org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyType;
import org.skinsoft.nuxeo.components.workflow.WorkflowFactory;
import org.skinsoft.nuxeo.components.workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorkflowPackageImpl extends EPackageImpl implements WorkflowPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass definitionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass docTypeRuleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathRuleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workflowDocumentSecurityPolicyRelationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workflowDocumentSecurityPolicyTypeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WorkflowPackageImpl() {
		super(eNS_URI, WorkflowFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static WorkflowPackage init() {
		if (isInited) return (WorkflowPackage)EPackage.Registry.INSTANCE.getEPackage(WorkflowPackage.eNS_URI);

		// Obtain or create and register package
		WorkflowPackageImpl theWorkflowPackage = (WorkflowPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof WorkflowPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new WorkflowPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theWorkflowPackage.createPackageContents();

		// Initialize created meta-data
		theWorkflowPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWorkflowPackage.freeze();

		return theWorkflowPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentType() {
		return componentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_Extension() {
		return (EReference)componentTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentType_Name() {
		return (EAttribute)componentTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefinitionType() {
		return definitionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefinitionType_EngineName() {
		return (EAttribute)definitionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefinitionType_Mimetype() {
		return (EAttribute)definitionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefinitionType_DefinitionPath() {
		return (EAttribute)definitionTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocTypeRuleType() {
		return docTypeRuleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocTypeRuleType_WorkflowDefinition() {
		return (EAttribute)docTypeRuleTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocTypeRuleType_DocType() {
		return (EAttribute)docTypeRuleTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Component() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtensionType() {
		return extensionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionType_Definition() {
		return (EReference)extensionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionType_WorkflowDocumentSecurityPolicy() {
		return (EReference)extensionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionType_DocTypeRule() {
		return (EReference)extensionTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionType_PathRule() {
		return (EReference)extensionTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionType_WorkflowDocumentSecurityPolicyRelation() {
		return (EReference)extensionTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtensionType_Point() {
		return (EAttribute)extensionTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtensionType_Target() {
		return (EAttribute)extensionTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPathRuleType() {
		return pathRuleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPathRuleType_WorkflowDefinition() {
		return (EAttribute)pathRuleTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPathRuleType_Path() {
		return (EAttribute)pathRuleTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkflowDocumentSecurityPolicyRelationType() {
		return workflowDocumentSecurityPolicyRelationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkflowDocumentSecurityPolicyRelationType_WorkflowName() {
		return (EAttribute)workflowDocumentSecurityPolicyRelationTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkflowDocumentSecurityPolicyRelationType_For() {
		return (EAttribute)workflowDocumentSecurityPolicyRelationTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkflowDocumentSecurityPolicyType() {
		return workflowDocumentSecurityPolicyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkflowDocumentSecurityPolicyType_Value() {
		return (EAttribute)workflowDocumentSecurityPolicyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkflowDocumentSecurityPolicyType_Class() {
		return (EAttribute)workflowDocumentSecurityPolicyTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkflowDocumentSecurityPolicyType_Name() {
		return (EAttribute)workflowDocumentSecurityPolicyTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowFactory getWorkflowFactory() {
		return (WorkflowFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		componentTypeEClass = createEClass(COMPONENT_TYPE);
		createEReference(componentTypeEClass, COMPONENT_TYPE__EXTENSION);
		createEAttribute(componentTypeEClass, COMPONENT_TYPE__NAME);

		definitionTypeEClass = createEClass(DEFINITION_TYPE);
		createEAttribute(definitionTypeEClass, DEFINITION_TYPE__ENGINE_NAME);
		createEAttribute(definitionTypeEClass, DEFINITION_TYPE__MIMETYPE);
		createEAttribute(definitionTypeEClass, DEFINITION_TYPE__DEFINITION_PATH);

		docTypeRuleTypeEClass = createEClass(DOC_TYPE_RULE_TYPE);
		createEAttribute(docTypeRuleTypeEClass, DOC_TYPE_RULE_TYPE__WORKFLOW_DEFINITION);
		createEAttribute(docTypeRuleTypeEClass, DOC_TYPE_RULE_TYPE__DOC_TYPE);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__COMPONENT);

		extensionTypeEClass = createEClass(EXTENSION_TYPE);
		createEReference(extensionTypeEClass, EXTENSION_TYPE__DEFINITION);
		createEReference(extensionTypeEClass, EXTENSION_TYPE__WORKFLOW_DOCUMENT_SECURITY_POLICY);
		createEReference(extensionTypeEClass, EXTENSION_TYPE__DOC_TYPE_RULE);
		createEReference(extensionTypeEClass, EXTENSION_TYPE__PATH_RULE);
		createEReference(extensionTypeEClass, EXTENSION_TYPE__WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION);
		createEAttribute(extensionTypeEClass, EXTENSION_TYPE__POINT);
		createEAttribute(extensionTypeEClass, EXTENSION_TYPE__TARGET);

		pathRuleTypeEClass = createEClass(PATH_RULE_TYPE);
		createEAttribute(pathRuleTypeEClass, PATH_RULE_TYPE__WORKFLOW_DEFINITION);
		createEAttribute(pathRuleTypeEClass, PATH_RULE_TYPE__PATH);

		workflowDocumentSecurityPolicyRelationTypeEClass = createEClass(WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE);
		createEAttribute(workflowDocumentSecurityPolicyRelationTypeEClass, WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE__WORKFLOW_NAME);
		createEAttribute(workflowDocumentSecurityPolicyRelationTypeEClass, WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE__FOR);

		workflowDocumentSecurityPolicyTypeEClass = createEClass(WORKFLOW_DOCUMENT_SECURITY_POLICY_TYPE);
		createEAttribute(workflowDocumentSecurityPolicyTypeEClass, WORKFLOW_DOCUMENT_SECURITY_POLICY_TYPE__VALUE);
		createEAttribute(workflowDocumentSecurityPolicyTypeEClass, WORKFLOW_DOCUMENT_SECURITY_POLICY_TYPE__CLASS);
		createEAttribute(workflowDocumentSecurityPolicyTypeEClass, WORKFLOW_DOCUMENT_SECURITY_POLICY_TYPE__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(componentTypeEClass, ComponentType.class, "ComponentType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentType_Extension(), this.getExtensionType(), null, "extension", null, 0, -1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(definitionTypeEClass, DefinitionType.class, "DefinitionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDefinitionType_EngineName(), theXMLTypePackage.getString(), "engineName", null, 1, 1, DefinitionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefinitionType_Mimetype(), theXMLTypePackage.getString(), "mimetype", null, 1, 1, DefinitionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefinitionType_DefinitionPath(), theXMLTypePackage.getString(), "definitionPath", null, 1, 1, DefinitionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(docTypeRuleTypeEClass, DocTypeRuleType.class, "DocTypeRuleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocTypeRuleType_WorkflowDefinition(), theXMLTypePackage.getString(), "workflowDefinition", null, 0, -1, DocTypeRuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocTypeRuleType_DocType(), theXMLTypePackage.getString(), "docType", null, 0, 1, DocTypeRuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Component(), this.getComponentType(), null, "component", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(extensionTypeEClass, ExtensionType.class, "ExtensionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtensionType_Definition(), this.getDefinitionType(), null, "definition", null, 0, -1, ExtensionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtensionType_WorkflowDocumentSecurityPolicy(), this.getWorkflowDocumentSecurityPolicyType(), null, "workflowDocumentSecurityPolicy", null, 0, -1, ExtensionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtensionType_DocTypeRule(), this.getDocTypeRuleType(), null, "docTypeRule", null, 0, -1, ExtensionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtensionType_PathRule(), this.getPathRuleType(), null, "pathRule", null, 0, -1, ExtensionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtensionType_WorkflowDocumentSecurityPolicyRelation(), this.getWorkflowDocumentSecurityPolicyRelationType(), null, "workflowDocumentSecurityPolicyRelation", null, 0, -1, ExtensionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtensionType_Point(), theXMLTypePackage.getString(), "point", null, 0, 1, ExtensionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtensionType_Target(), theXMLTypePackage.getString(), "target", null, 0, 1, ExtensionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pathRuleTypeEClass, PathRuleType.class, "PathRuleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPathRuleType_WorkflowDefinition(), theXMLTypePackage.getString(), "workflowDefinition", null, 0, -1, PathRuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPathRuleType_Path(), theXMLTypePackage.getString(), "path", null, 0, 1, PathRuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(workflowDocumentSecurityPolicyRelationTypeEClass, WorkflowDocumentSecurityPolicyRelationType.class, "WorkflowDocumentSecurityPolicyRelationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWorkflowDocumentSecurityPolicyRelationType_WorkflowName(), theXMLTypePackage.getString(), "workflowName", null, 0, -1, WorkflowDocumentSecurityPolicyRelationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkflowDocumentSecurityPolicyRelationType_For(), theXMLTypePackage.getString(), "for", null, 0, 1, WorkflowDocumentSecurityPolicyRelationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(workflowDocumentSecurityPolicyTypeEClass, WorkflowDocumentSecurityPolicyType.class, "WorkflowDocumentSecurityPolicyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWorkflowDocumentSecurityPolicyType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, WorkflowDocumentSecurityPolicyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkflowDocumentSecurityPolicyType_Class(), theXMLTypePackage.getString(), "class", null, 0, 1, WorkflowDocumentSecurityPolicyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkflowDocumentSecurityPolicyType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, WorkflowDocumentSecurityPolicyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (componentTypeEClass, 
		   source, 
		   new String[] {
			 "name", "componentType",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getComponentType_Extension(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "extension",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getComponentType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (definitionTypeEClass, 
		   source, 
		   new String[] {
			 "name", "definitionType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getDefinitionType_EngineName(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "engineName",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDefinitionType_Mimetype(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "mimetype",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDefinitionType_DefinitionPath(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "definitionPath",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (docTypeRuleTypeEClass, 
		   source, 
		   new String[] {
			 "name", "docTypeRuleType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getDocTypeRuleType_WorkflowDefinition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "workflowDefinition",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocTypeRuleType_DocType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "docType"
		   });		
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getDocumentRoot_Component(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "component",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (extensionTypeEClass, 
		   source, 
		   new String[] {
			 "name", "extensionType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getExtensionType_Definition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "definition",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getExtensionType_WorkflowDocumentSecurityPolicy(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "workflowDocumentSecurityPolicy",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getExtensionType_DocTypeRule(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "docTypeRule",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getExtensionType_PathRule(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "pathRule",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getExtensionType_WorkflowDocumentSecurityPolicyRelation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "workflowDocumentSecurityPolicyRelation",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getExtensionType_Point(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "point"
		   });		
		addAnnotation
		  (getExtensionType_Target(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "target"
		   });		
		addAnnotation
		  (pathRuleTypeEClass, 
		   source, 
		   new String[] {
			 "name", "pathRuleType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPathRuleType_WorkflowDefinition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "workflowDefinition",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPathRuleType_Path(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "path"
		   });		
		addAnnotation
		  (workflowDocumentSecurityPolicyRelationTypeEClass, 
		   source, 
		   new String[] {
			 "name", "workflowDocumentSecurityPolicyRelationType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getWorkflowDocumentSecurityPolicyRelationType_WorkflowName(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "workflowName",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getWorkflowDocumentSecurityPolicyRelationType_For(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "for"
		   });		
		addAnnotation
		  (workflowDocumentSecurityPolicyTypeEClass, 
		   source, 
		   new String[] {
			 "name", "workflowDocumentSecurityPolicyType",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getWorkflowDocumentSecurityPolicyType_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getWorkflowDocumentSecurityPolicyType_Class(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "class"
		   });		
		addAnnotation
		  (getWorkflowDocumentSecurityPolicyType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });
	}

} //WorkflowPackageImpl
