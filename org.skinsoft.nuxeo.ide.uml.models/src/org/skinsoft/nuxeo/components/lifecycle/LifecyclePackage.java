/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.lifecycle;

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
 * @see org.skinsoft.nuxeo.components.lifecycle.LifecycleFactory
 * @model kind="package"
 * @generated
 */
public interface LifecyclePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "lifecycle";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://skinsoft.org/nuxeo/components/lifecycle";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "lifecycle";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LifecyclePackage eINSTANCE = org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.ComponentTypeImpl <em>Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.ComponentTypeImpl
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getComponentType()
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
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.DocumentRootImpl
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getDocumentRoot()
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
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.ExtensionTypeImpl <em>Extension Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.ExtensionTypeImpl
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getExtensionType()
	 * @generated
	 */
	int EXTENSION_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Lifecycle</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__LIFECYCLE = 0;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__TYPES = 1;

	/**
	 * The feature id for the '<em><b>Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__POINT = 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__TARGET = 3;

	/**
	 * The number of structural features of the '<em>Extension Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.LifecycleTypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecycleTypeImpl
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getLifecycleType()
	 * @generated
	 */
	int LIFECYCLE_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFECYCLE_TYPE__TRANSITIONS = 0;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFECYCLE_TYPE__STATES = 1;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFECYCLE_TYPE__INITIAL = 2;

	/**
	 * The feature id for the '<em><b>Lifecyclemanager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFECYCLE_TYPE__LIFECYCLEMANAGER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFECYCLE_TYPE__NAME = 4;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFECYCLE_TYPE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.StatesTypeImpl <em>States Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.StatesTypeImpl
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getStatesType()
	 * @generated
	 */
	int STATES_TYPE = 4;

	/**
	 * The feature id for the '<em><b>State</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATES_TYPE__STATE = 0;

	/**
	 * The number of structural features of the '<em>States Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATES_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.StateTransitionsTypeImpl <em>State Transitions Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.StateTransitionsTypeImpl
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getStateTransitionsType()
	 * @generated
	 */
	int STATE_TRANSITIONS_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITIONS_TYPE__TRANSITION = 0;

	/**
	 * The number of structural features of the '<em>State Transitions Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITIONS_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.StateTypeImpl <em>State Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.StateTypeImpl
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getStateType()
	 * @generated
	 */
	int STATE_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TYPE__TRANSITIONS = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TYPE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TYPE__NAME = 2;

	/**
	 * The number of structural features of the '<em>State Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.TransitionsTypeImpl <em>Transitions Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.TransitionsTypeImpl
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getTransitionsType()
	 * @generated
	 */
	int TRANSITIONS_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITIONS_TYPE__TRANSITION = 0;

	/**
	 * The number of structural features of the '<em>Transitions Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITIONS_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.TransitionTypeImpl <em>Transition Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.TransitionTypeImpl
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getTransitionType()
	 * @generated
	 */
	int TRANSITION_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_TYPE__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_TYPE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Destination State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_TYPE__DESTINATION_STATE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_TYPE__NAME = 3;

	/**
	 * The number of structural features of the '<em>Transition Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.TypesTypeImpl <em>Types Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.TypesTypeImpl
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getTypesType()
	 * @generated
	 */
	int TYPES_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPES_TYPE__TYPE = 0;

	/**
	 * The number of structural features of the '<em>Types Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPES_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.TypeTypeImpl <em>Type Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.TypeTypeImpl
	 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getTypeType()
	 * @generated
	 */
	int TYPE_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__VALUE = 0;

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
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.lifecycle.ComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Type</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.ComponentType
	 * @generated
	 */
	EClass getComponentType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.lifecycle.ComponentType#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extension</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.ComponentType#getExtension()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_Extension();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.lifecycle.ComponentType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.ComponentType#getName()
	 * @see #getComponentType()
	 * @generated
	 */
	EAttribute getComponentType_Name();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.lifecycle.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.lifecycle.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.skinsoft.nuxeo.components.lifecycle.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.skinsoft.nuxeo.components.lifecycle.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.lifecycle.DocumentRoot#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.DocumentRoot#getComponent()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Component();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.lifecycle.ExtensionType <em>Extension Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Type</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.ExtensionType
	 * @generated
	 */
	EClass getExtensionType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.lifecycle.ExtensionType#getLifecycle <em>Lifecycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lifecycle</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.ExtensionType#getLifecycle()
	 * @see #getExtensionType()
	 * @generated
	 */
	EReference getExtensionType_Lifecycle();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.lifecycle.ExtensionType#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Types</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.ExtensionType#getTypes()
	 * @see #getExtensionType()
	 * @generated
	 */
	EReference getExtensionType_Types();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.lifecycle.ExtensionType#getPoint <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Point</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.ExtensionType#getPoint()
	 * @see #getExtensionType()
	 * @generated
	 */
	EAttribute getExtensionType_Point();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.lifecycle.ExtensionType#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.ExtensionType#getTarget()
	 * @see #getExtensionType()
	 * @generated
	 */
	EAttribute getExtensionType_Target();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.lifecycle.LifecycleType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.LifecycleType
	 * @generated
	 */
	EClass getLifecycleType();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.lifecycle.LifecycleType#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Transitions</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.LifecycleType#getTransitions()
	 * @see #getLifecycleType()
	 * @generated
	 */
	EReference getLifecycleType_Transitions();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.lifecycle.LifecycleType#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>States</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.LifecycleType#getStates()
	 * @see #getLifecycleType()
	 * @generated
	 */
	EReference getLifecycleType_States();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.lifecycle.LifecycleType#getInitial <em>Initial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.LifecycleType#getInitial()
	 * @see #getLifecycleType()
	 * @generated
	 */
	EAttribute getLifecycleType_Initial();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.lifecycle.LifecycleType#getLifecyclemanager <em>Lifecyclemanager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lifecyclemanager</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.LifecycleType#getLifecyclemanager()
	 * @see #getLifecycleType()
	 * @generated
	 */
	EAttribute getLifecycleType_Lifecyclemanager();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.lifecycle.LifecycleType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.LifecycleType#getName()
	 * @see #getLifecycleType()
	 * @generated
	 */
	EAttribute getLifecycleType_Name();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.lifecycle.StatesType <em>States Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>States Type</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.StatesType
	 * @generated
	 */
	EClass getStatesType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.lifecycle.StatesType#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>State</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.StatesType#getState()
	 * @see #getStatesType()
	 * @generated
	 */
	EReference getStatesType_State();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.lifecycle.StateTransitionsType <em>State Transitions Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Transitions Type</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.StateTransitionsType
	 * @generated
	 */
	EClass getStateTransitionsType();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.lifecycle.StateTransitionsType#getTransition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Transition</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.StateTransitionsType#getTransition()
	 * @see #getStateTransitionsType()
	 * @generated
	 */
	EAttribute getStateTransitionsType_Transition();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.lifecycle.StateType <em>State Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Type</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.StateType
	 * @generated
	 */
	EClass getStateType();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.lifecycle.StateType#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Transitions</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.StateType#getTransitions()
	 * @see #getStateType()
	 * @generated
	 */
	EReference getStateType_Transitions();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.lifecycle.StateType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.StateType#getDescription()
	 * @see #getStateType()
	 * @generated
	 */
	EAttribute getStateType_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.lifecycle.StateType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.StateType#getName()
	 * @see #getStateType()
	 * @generated
	 */
	EAttribute getStateType_Name();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.lifecycle.TransitionsType <em>Transitions Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transitions Type</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.TransitionsType
	 * @generated
	 */
	EClass getTransitionsType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.lifecycle.TransitionsType#getTransition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transition</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.TransitionsType#getTransition()
	 * @see #getTransitionsType()
	 * @generated
	 */
	EReference getTransitionsType_Transition();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.lifecycle.TransitionType <em>Transition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition Type</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.TransitionType
	 * @generated
	 */
	EClass getTransitionType();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.lifecycle.TransitionType#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.TransitionType#getMixed()
	 * @see #getTransitionType()
	 * @generated
	 */
	EAttribute getTransitionType_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.lifecycle.TransitionType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.TransitionType#getDescription()
	 * @see #getTransitionType()
	 * @generated
	 */
	EAttribute getTransitionType_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.lifecycle.TransitionType#getDestinationState <em>Destination State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Destination State</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.TransitionType#getDestinationState()
	 * @see #getTransitionType()
	 * @generated
	 */
	EAttribute getTransitionType_DestinationState();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.lifecycle.TransitionType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.TransitionType#getName()
	 * @see #getTransitionType()
	 * @generated
	 */
	EAttribute getTransitionType_Name();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.lifecycle.TypesType <em>Types Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Types Type</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.TypesType
	 * @generated
	 */
	EClass getTypesType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.lifecycle.TypesType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.TypesType#getType()
	 * @see #getTypesType()
	 * @generated
	 */
	EReference getTypesType_Type();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.lifecycle.TypeType <em>Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Type</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.TypeType
	 * @generated
	 */
	EClass getTypeType();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.lifecycle.TypeType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.TypeType#getValue()
	 * @see #getTypeType()
	 * @generated
	 */
	EAttribute getTypeType_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.lifecycle.TypeType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.lifecycle.TypeType#getName()
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
	LifecycleFactory getLifecycleFactory();

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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.ComponentTypeImpl <em>Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.ComponentTypeImpl
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getComponentType()
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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.DocumentRootImpl
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getDocumentRoot()
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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.ExtensionTypeImpl <em>Extension Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.ExtensionTypeImpl
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getExtensionType()
		 * @generated
		 */
		EClass EXTENSION_TYPE = eINSTANCE.getExtensionType();

		/**
		 * The meta object literal for the '<em><b>Lifecycle</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TYPE__LIFECYCLE = eINSTANCE.getExtensionType_Lifecycle();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TYPE__TYPES = eINSTANCE.getExtensionType_Types();

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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.LifecycleTypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecycleTypeImpl
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getLifecycleType()
		 * @generated
		 */
		EClass LIFECYCLE_TYPE = eINSTANCE.getLifecycleType();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIFECYCLE_TYPE__TRANSITIONS = eINSTANCE.getLifecycleType_Transitions();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIFECYCLE_TYPE__STATES = eINSTANCE.getLifecycleType_States();

		/**
		 * The meta object literal for the '<em><b>Initial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIFECYCLE_TYPE__INITIAL = eINSTANCE.getLifecycleType_Initial();

		/**
		 * The meta object literal for the '<em><b>Lifecyclemanager</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIFECYCLE_TYPE__LIFECYCLEMANAGER = eINSTANCE.getLifecycleType_Lifecyclemanager();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIFECYCLE_TYPE__NAME = eINSTANCE.getLifecycleType_Name();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.StatesTypeImpl <em>States Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.StatesTypeImpl
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getStatesType()
		 * @generated
		 */
		EClass STATES_TYPE = eINSTANCE.getStatesType();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATES_TYPE__STATE = eINSTANCE.getStatesType_State();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.StateTransitionsTypeImpl <em>State Transitions Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.StateTransitionsTypeImpl
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getStateTransitionsType()
		 * @generated
		 */
		EClass STATE_TRANSITIONS_TYPE = eINSTANCE.getStateTransitionsType();

		/**
		 * The meta object literal for the '<em><b>Transition</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_TRANSITIONS_TYPE__TRANSITION = eINSTANCE.getStateTransitionsType_Transition();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.StateTypeImpl <em>State Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.StateTypeImpl
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getStateType()
		 * @generated
		 */
		EClass STATE_TYPE = eINSTANCE.getStateType();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_TYPE__TRANSITIONS = eINSTANCE.getStateType_Transitions();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_TYPE__DESCRIPTION = eINSTANCE.getStateType_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_TYPE__NAME = eINSTANCE.getStateType_Name();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.TransitionsTypeImpl <em>Transitions Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.TransitionsTypeImpl
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getTransitionsType()
		 * @generated
		 */
		EClass TRANSITIONS_TYPE = eINSTANCE.getTransitionsType();

		/**
		 * The meta object literal for the '<em><b>Transition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITIONS_TYPE__TRANSITION = eINSTANCE.getTransitionsType_Transition();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.TransitionTypeImpl <em>Transition Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.TransitionTypeImpl
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getTransitionType()
		 * @generated
		 */
		EClass TRANSITION_TYPE = eINSTANCE.getTransitionType();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION_TYPE__MIXED = eINSTANCE.getTransitionType_Mixed();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION_TYPE__DESCRIPTION = eINSTANCE.getTransitionType_Description();

		/**
		 * The meta object literal for the '<em><b>Destination State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION_TYPE__DESTINATION_STATE = eINSTANCE.getTransitionType_DestinationState();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION_TYPE__NAME = eINSTANCE.getTransitionType_Name();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.TypesTypeImpl <em>Types Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.TypesTypeImpl
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getTypesType()
		 * @generated
		 */
		EClass TYPES_TYPE = eINSTANCE.getTypesType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPES_TYPE__TYPE = eINSTANCE.getTypesType_Type();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.lifecycle.impl.TypeTypeImpl <em>Type Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.TypeTypeImpl
		 * @see org.skinsoft.nuxeo.components.lifecycle.impl.LifecyclePackageImpl#getTypeType()
		 * @generated
		 */
		EClass TYPE_TYPE = eINSTANCE.getTypeType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_TYPE__VALUE = eINSTANCE.getTypeType_Value();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_TYPE__NAME = eINSTANCE.getTypeType_Name();

	}

} //LifecyclePackage
