/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.jbpm.service;

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
 * @see org.skinsoft.nuxeo.components.jbpm.service.ServiceFactory
 * @model kind="package"
 * @generated
 */
public interface ServicePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "service";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://skinsoft.org/nuxeo/components/jbpmService";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "service";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ServicePackage eINSTANCE = org.skinsoft.nuxeo.components.jbpm.service.impl.ServicePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.jbpm.service.impl.ComponentTypeImpl <em>Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.ComponentTypeImpl
	 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.ServicePackageImpl#getComponentType()
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
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.jbpm.service.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.DocumentRootImpl
	 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.ServicePackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 1;

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
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.jbpm.service.impl.ExtensionTypeImpl <em>Extension Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.ExtensionTypeImpl
	 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.ServicePackageImpl#getExtensionType()
	 * @generated
	 */
	int EXTENSION_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Process Definition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__PROCESS_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Security Policy</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__SECURITY_POLICY = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__POINT = 3;

	/**
	 * The feature id for the '<em><b>Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__TARGET = 4;

	/**
	 * The number of structural features of the '<em>Extension Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.jbpm.service.impl.ProcessDefinitionTypeImpl <em>Process Definition Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.ProcessDefinitionTypeImpl
	 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.ServicePackageImpl#getProcessDefinitionType()
	 * @generated
	 */
	int PROCESS_DEFINITION_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_DEFINITION_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Deployer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_DEFINITION_TYPE__DEPLOYER = 1;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_DEFINITION_TYPE__PATH = 2;

	/**
	 * The number of structural features of the '<em>Process Definition Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_DEFINITION_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.jbpm.service.impl.SecurityPolicyTypeImpl <em>Security Policy Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.SecurityPolicyTypeImpl
	 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.ServicePackageImpl#getSecurityPolicyType()
	 * @generated
	 */
	int SECURITY_POLICY_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_POLICY_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_POLICY_TYPE__CLASS = 1;

	/**
	 * The feature id for the '<em><b>For</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_POLICY_TYPE__FOR = 2;

	/**
	 * The number of structural features of the '<em>Security Policy Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_POLICY_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.jbpm.service.impl.TypeTypeImpl <em>Type Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.TypeTypeImpl
	 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.ServicePackageImpl#getTypeType()
	 * @generated
	 */
	int TYPE_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Process Definition</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__PROCESS_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Type Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.jbpm.service.ComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Type</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ComponentType
	 * @generated
	 */
	EClass getComponentType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.jbpm.service.ComponentType#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extension</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ComponentType#getExtension()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_Extension();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.jbpm.service.ComponentType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ComponentType#getName()
	 * @see #getComponentType()
	 * @generated
	 */
	EAttribute getComponentType_Name();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.jbpm.service.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.jbpm.service.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.skinsoft.nuxeo.components.jbpm.service.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.skinsoft.nuxeo.components.jbpm.service.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.jbpm.service.DocumentRoot#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.DocumentRoot#getComponent()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Component();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.jbpm.service.ExtensionType <em>Extension Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Type</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ExtensionType
	 * @generated
	 */
	EClass getExtensionType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.jbpm.service.ExtensionType#getProcessDefinition <em>Process Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Process Definition</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ExtensionType#getProcessDefinition()
	 * @see #getExtensionType()
	 * @generated
	 */
	EReference getExtensionType_ProcessDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.jbpm.service.ExtensionType#getSecurityPolicy <em>Security Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Security Policy</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ExtensionType#getSecurityPolicy()
	 * @see #getExtensionType()
	 * @generated
	 */
	EReference getExtensionType_SecurityPolicy();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.jbpm.service.ExtensionType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ExtensionType#getType()
	 * @see #getExtensionType()
	 * @generated
	 */
	EReference getExtensionType_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.jbpm.service.ExtensionType#getPoint <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Point</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ExtensionType#getPoint()
	 * @see #getExtensionType()
	 * @generated
	 */
	EAttribute getExtensionType_Point();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.jbpm.service.ExtensionType#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ExtensionType#getTarget()
	 * @see #getExtensionType()
	 * @generated
	 */
	EAttribute getExtensionType_Target();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.jbpm.service.ProcessDefinitionType <em>Process Definition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Definition Type</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ProcessDefinitionType
	 * @generated
	 */
	EClass getProcessDefinitionType();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.jbpm.service.ProcessDefinitionType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ProcessDefinitionType#getValue()
	 * @see #getProcessDefinitionType()
	 * @generated
	 */
	EAttribute getProcessDefinitionType_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.jbpm.service.ProcessDefinitionType#getDeployer <em>Deployer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deployer</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ProcessDefinitionType#getDeployer()
	 * @see #getProcessDefinitionType()
	 * @generated
	 */
	EAttribute getProcessDefinitionType_Deployer();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.jbpm.service.ProcessDefinitionType#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ProcessDefinitionType#getPath()
	 * @see #getProcessDefinitionType()
	 * @generated
	 */
	EAttribute getProcessDefinitionType_Path();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.jbpm.service.SecurityPolicyType <em>Security Policy Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Security Policy Type</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.SecurityPolicyType
	 * @generated
	 */
	EClass getSecurityPolicyType();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.jbpm.service.SecurityPolicyType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.SecurityPolicyType#getValue()
	 * @see #getSecurityPolicyType()
	 * @generated
	 */
	EAttribute getSecurityPolicyType_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.jbpm.service.SecurityPolicyType#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.SecurityPolicyType#getClass_()
	 * @see #getSecurityPolicyType()
	 * @generated
	 */
	EAttribute getSecurityPolicyType_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.jbpm.service.SecurityPolicyType#getFor <em>For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>For</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.SecurityPolicyType#getFor()
	 * @see #getSecurityPolicyType()
	 * @generated
	 */
	EAttribute getSecurityPolicyType_For();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.jbpm.service.TypeType <em>Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Type</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.TypeType
	 * @generated
	 */
	EClass getTypeType();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.jbpm.service.TypeType#getProcessDefinition <em>Process Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Process Definition</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.TypeType#getProcessDefinition()
	 * @see #getTypeType()
	 * @generated
	 */
	EAttribute getTypeType_ProcessDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.jbpm.service.TypeType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.TypeType#getName()
	 * @see #getTypeType()
	 * @generated
	 */
	EAttribute getTypeType_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ServiceFactory getServiceFactory();

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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.jbpm.service.impl.ComponentTypeImpl <em>Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.ComponentTypeImpl
		 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.ServicePackageImpl#getComponentType()
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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.jbpm.service.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.DocumentRootImpl
		 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.ServicePackageImpl#getDocumentRoot()
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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.jbpm.service.impl.ExtensionTypeImpl <em>Extension Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.ExtensionTypeImpl
		 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.ServicePackageImpl#getExtensionType()
		 * @generated
		 */
		EClass EXTENSION_TYPE = eINSTANCE.getExtensionType();

		/**
		 * The meta object literal for the '<em><b>Process Definition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TYPE__PROCESS_DEFINITION = eINSTANCE.getExtensionType_ProcessDefinition();

		/**
		 * The meta object literal for the '<em><b>Security Policy</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TYPE__SECURITY_POLICY = eINSTANCE.getExtensionType_SecurityPolicy();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TYPE__TYPE = eINSTANCE.getExtensionType_Type();

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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.jbpm.service.impl.ProcessDefinitionTypeImpl <em>Process Definition Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.ProcessDefinitionTypeImpl
		 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.ServicePackageImpl#getProcessDefinitionType()
		 * @generated
		 */
		EClass PROCESS_DEFINITION_TYPE = eINSTANCE.getProcessDefinitionType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_DEFINITION_TYPE__VALUE = eINSTANCE.getProcessDefinitionType_Value();

		/**
		 * The meta object literal for the '<em><b>Deployer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_DEFINITION_TYPE__DEPLOYER = eINSTANCE.getProcessDefinitionType_Deployer();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_DEFINITION_TYPE__PATH = eINSTANCE.getProcessDefinitionType_Path();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.jbpm.service.impl.SecurityPolicyTypeImpl <em>Security Policy Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.SecurityPolicyTypeImpl
		 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.ServicePackageImpl#getSecurityPolicyType()
		 * @generated
		 */
		EClass SECURITY_POLICY_TYPE = eINSTANCE.getSecurityPolicyType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECURITY_POLICY_TYPE__VALUE = eINSTANCE.getSecurityPolicyType_Value();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECURITY_POLICY_TYPE__CLASS = eINSTANCE.getSecurityPolicyType_Class();

		/**
		 * The meta object literal for the '<em><b>For</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECURITY_POLICY_TYPE__FOR = eINSTANCE.getSecurityPolicyType_For();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.jbpm.service.impl.TypeTypeImpl <em>Type Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.TypeTypeImpl
		 * @see org.skinsoft.nuxeo.components.jbpm.service.impl.ServicePackageImpl#getTypeType()
		 * @generated
		 */
		EClass TYPE_TYPE = eINSTANCE.getTypeType();

		/**
		 * The meta object literal for the '<em><b>Process Definition</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_TYPE__PROCESS_DEFINITION = eINSTANCE.getTypeType_ProcessDefinition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_TYPE__NAME = eINSTANCE.getTypeType_Name();

	}

} //ServicePackage
