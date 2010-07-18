/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.actions;

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
 * @see org.skinsoft.nuxeo.components.actions.ActionsFactory
 * @model kind="package"
 * @generated
 */
public interface ActionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "actions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://skinsoft.org/nuxeo/components/actions";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "actions";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActionsPackage eINSTANCE = org.skinsoft.nuxeo.components.actions.impl.ActionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.actions.impl.ActionTypeImpl <em>Action Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.actions.impl.ActionTypeImpl
	 * @see org.skinsoft.nuxeo.components.actions.impl.ActionsPackageImpl#getActionType()
	 * @generated
	 */
	int ACTION_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__CATEGORY = 0;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__FILTER = 1;

	/**
	 * The feature id for the '<em><b>Filter Id</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__FILTER_ID = 2;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__ENABLED = 3;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__ICON = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__ID = 5;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__LABEL = 6;

	/**
	 * The feature id for the '<em><b>Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__LINK = 7;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE__ORDER = 8;

	/**
	 * The number of structural features of the '<em>Action Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_TYPE_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.actions.impl.ComponentTypeImpl <em>Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.actions.impl.ComponentTypeImpl
	 * @see org.skinsoft.nuxeo.components.actions.impl.ActionsPackageImpl#getComponentType()
	 * @generated
	 */
	int COMPONENT_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Require</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__REQUIRE = 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__EXTENSION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__NAME = 2;

	/**
	 * The number of structural features of the '<em>Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.actions.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.actions.impl.DocumentRootImpl
	 * @see org.skinsoft.nuxeo.components.actions.impl.ActionsPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 2;

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
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.actions.impl.ExtensionTypeImpl <em>Extension Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.actions.impl.ExtensionTypeImpl
	 * @see org.skinsoft.nuxeo.components.actions.impl.ActionsPackageImpl#getExtensionType()
	 * @generated
	 */
	int EXTENSION_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__ACTION = 0;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__FILTER = 1;

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
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.actions.impl.FilterTypeImpl <em>Filter Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.actions.impl.FilterTypeImpl
	 * @see org.skinsoft.nuxeo.components.actions.impl.ActionsPackageImpl#getFilterType()
	 * @generated
	 */
	int FILTER_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_TYPE__RULE = 0;

	/**
	 * The feature id for the '<em><b>Append</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_TYPE__APPEND = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_TYPE__ID = 2;

	/**
	 * The number of structural features of the '<em>Filter Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.actions.impl.RuleTypeImpl <em>Rule Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.actions.impl.RuleTypeImpl
	 * @see org.skinsoft.nuxeo.components.actions.impl.ActionsPackageImpl#getRuleType()
	 * @generated
	 */
	int RULE_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE__PERMISSION = 2;

	/**
	 * The feature id for the '<em><b>Schema</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE__SCHEMA = 3;

	/**
	 * The feature id for the '<em><b>Facet</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE__FACET = 4;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE__CONDITION = 5;

	/**
	 * The feature id for the '<em><b>Grant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE__GRANT = 6;

	/**
	 * The number of structural features of the '<em>Rule Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE_FEATURE_COUNT = 7;


	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.actions.ActionType <em>Action Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Type</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.ActionType
	 * @generated
	 */
	EClass getActionType();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.actions.ActionType#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Category</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.ActionType#getCategory()
	 * @see #getActionType()
	 * @generated
	 */
	EAttribute getActionType_Category();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.actions.ActionType#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Filter</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.ActionType#getFilter()
	 * @see #getActionType()
	 * @generated
	 */
	EReference getActionType_Filter();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.actions.ActionType#getFilterId <em>Filter Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Filter Id</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.ActionType#getFilterId()
	 * @see #getActionType()
	 * @generated
	 */
	EAttribute getActionType_FilterId();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.actions.ActionType#getEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.ActionType#getEnabled()
	 * @see #getActionType()
	 * @generated
	 */
	EAttribute getActionType_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.actions.ActionType#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.ActionType#getIcon()
	 * @see #getActionType()
	 * @generated
	 */
	EAttribute getActionType_Icon();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.actions.ActionType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.ActionType#getId()
	 * @see #getActionType()
	 * @generated
	 */
	EAttribute getActionType_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.actions.ActionType#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.ActionType#getLabel()
	 * @see #getActionType()
	 * @generated
	 */
	EAttribute getActionType_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.actions.ActionType#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Link</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.ActionType#getLink()
	 * @see #getActionType()
	 * @generated
	 */
	EAttribute getActionType_Link();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.actions.ActionType#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.ActionType#getOrder()
	 * @see #getActionType()
	 * @generated
	 */
	EAttribute getActionType_Order();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.actions.ComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Type</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.ComponentType
	 * @generated
	 */
	EClass getComponentType();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.actions.ComponentType#getRequire <em>Require</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Require</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.ComponentType#getRequire()
	 * @see #getComponentType()
	 * @generated
	 */
	EAttribute getComponentType_Require();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.actions.ComponentType#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extension</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.ComponentType#getExtension()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_Extension();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.actions.ComponentType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.ComponentType#getName()
	 * @see #getComponentType()
	 * @generated
	 */
	EAttribute getComponentType_Name();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.actions.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.actions.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.skinsoft.nuxeo.components.actions.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.skinsoft.nuxeo.components.actions.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.actions.DocumentRoot#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.DocumentRoot#getComponent()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Component();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.actions.ExtensionType <em>Extension Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Type</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.ExtensionType
	 * @generated
	 */
	EClass getExtensionType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.actions.ExtensionType#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Action</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.ExtensionType#getAction()
	 * @see #getExtensionType()
	 * @generated
	 */
	EReference getExtensionType_Action();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.actions.ExtensionType#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Filter</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.ExtensionType#getFilter()
	 * @see #getExtensionType()
	 * @generated
	 */
	EReference getExtensionType_Filter();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.actions.ExtensionType#getPoint <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Point</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.ExtensionType#getPoint()
	 * @see #getExtensionType()
	 * @generated
	 */
	EAttribute getExtensionType_Point();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.actions.ExtensionType#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.ExtensionType#getTarget()
	 * @see #getExtensionType()
	 * @generated
	 */
	EAttribute getExtensionType_Target();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.actions.FilterType <em>Filter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Filter Type</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.FilterType
	 * @generated
	 */
	EClass getFilterType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.actions.FilterType#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rule</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.FilterType#getRule()
	 * @see #getFilterType()
	 * @generated
	 */
	EReference getFilterType_Rule();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.actions.FilterType#getAppend <em>Append</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Append</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.FilterType#getAppend()
	 * @see #getFilterType()
	 * @generated
	 */
	EAttribute getFilterType_Append();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.actions.FilterType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.FilterType#getId()
	 * @see #getFilterType()
	 * @generated
	 */
	EAttribute getFilterType_Id();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.actions.RuleType <em>Rule Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Type</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.RuleType
	 * @generated
	 */
	EClass getRuleType();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.actions.RuleType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.RuleType#getGroup()
	 * @see #getRuleType()
	 * @generated
	 */
	EAttribute getRuleType_Group();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.actions.RuleType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Type</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.RuleType#getType()
	 * @see #getRuleType()
	 * @generated
	 */
	EAttribute getRuleType_Type();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.actions.RuleType#getPermission <em>Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Permission</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.RuleType#getPermission()
	 * @see #getRuleType()
	 * @generated
	 */
	EAttribute getRuleType_Permission();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.actions.RuleType#getSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Schema</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.RuleType#getSchema()
	 * @see #getRuleType()
	 * @generated
	 */
	EAttribute getRuleType_Schema();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.actions.RuleType#getFacet <em>Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Facet</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.RuleType#getFacet()
	 * @see #getRuleType()
	 * @generated
	 */
	EAttribute getRuleType_Facet();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.actions.RuleType#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Condition</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.RuleType#getCondition()
	 * @see #getRuleType()
	 * @generated
	 */
	EAttribute getRuleType_Condition();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.actions.RuleType#getGrant <em>Grant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grant</em>'.
	 * @see org.skinsoft.nuxeo.components.actions.RuleType#getGrant()
	 * @see #getRuleType()
	 * @generated
	 */
	EAttribute getRuleType_Grant();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ActionsFactory getActionsFactory();

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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.actions.impl.ActionTypeImpl <em>Action Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.actions.impl.ActionTypeImpl
		 * @see org.skinsoft.nuxeo.components.actions.impl.ActionsPackageImpl#getActionType()
		 * @generated
		 */
		EClass ACTION_TYPE = eINSTANCE.getActionType();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_TYPE__CATEGORY = eINSTANCE.getActionType_Category();

		/**
		 * The meta object literal for the '<em><b>Filter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_TYPE__FILTER = eINSTANCE.getActionType_Filter();

		/**
		 * The meta object literal for the '<em><b>Filter Id</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_TYPE__FILTER_ID = eINSTANCE.getActionType_FilterId();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_TYPE__ENABLED = eINSTANCE.getActionType_Enabled();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_TYPE__ICON = eINSTANCE.getActionType_Icon();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_TYPE__ID = eINSTANCE.getActionType_Id();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_TYPE__LABEL = eINSTANCE.getActionType_Label();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_TYPE__LINK = eINSTANCE.getActionType_Link();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_TYPE__ORDER = eINSTANCE.getActionType_Order();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.actions.impl.ComponentTypeImpl <em>Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.actions.impl.ComponentTypeImpl
		 * @see org.skinsoft.nuxeo.components.actions.impl.ActionsPackageImpl#getComponentType()
		 * @generated
		 */
		EClass COMPONENT_TYPE = eINSTANCE.getComponentType();

		/**
		 * The meta object literal for the '<em><b>Require</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_TYPE__REQUIRE = eINSTANCE.getComponentType_Require();

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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.actions.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.actions.impl.DocumentRootImpl
		 * @see org.skinsoft.nuxeo.components.actions.impl.ActionsPackageImpl#getDocumentRoot()
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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.actions.impl.ExtensionTypeImpl <em>Extension Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.actions.impl.ExtensionTypeImpl
		 * @see org.skinsoft.nuxeo.components.actions.impl.ActionsPackageImpl#getExtensionType()
		 * @generated
		 */
		EClass EXTENSION_TYPE = eINSTANCE.getExtensionType();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TYPE__ACTION = eINSTANCE.getExtensionType_Action();

		/**
		 * The meta object literal for the '<em><b>Filter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TYPE__FILTER = eINSTANCE.getExtensionType_Filter();

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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.actions.impl.FilterTypeImpl <em>Filter Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.actions.impl.FilterTypeImpl
		 * @see org.skinsoft.nuxeo.components.actions.impl.ActionsPackageImpl#getFilterType()
		 * @generated
		 */
		EClass FILTER_TYPE = eINSTANCE.getFilterType();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILTER_TYPE__RULE = eINSTANCE.getFilterType_Rule();

		/**
		 * The meta object literal for the '<em><b>Append</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILTER_TYPE__APPEND = eINSTANCE.getFilterType_Append();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILTER_TYPE__ID = eINSTANCE.getFilterType_Id();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.actions.impl.RuleTypeImpl <em>Rule Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.actions.impl.RuleTypeImpl
		 * @see org.skinsoft.nuxeo.components.actions.impl.ActionsPackageImpl#getRuleType()
		 * @generated
		 */
		EClass RULE_TYPE = eINSTANCE.getRuleType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_TYPE__GROUP = eINSTANCE.getRuleType_Group();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_TYPE__TYPE = eINSTANCE.getRuleType_Type();

		/**
		 * The meta object literal for the '<em><b>Permission</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_TYPE__PERMISSION = eINSTANCE.getRuleType_Permission();

		/**
		 * The meta object literal for the '<em><b>Schema</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_TYPE__SCHEMA = eINSTANCE.getRuleType_Schema();

		/**
		 * The meta object literal for the '<em><b>Facet</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_TYPE__FACET = eINSTANCE.getRuleType_Facet();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_TYPE__CONDITION = eINSTANCE.getRuleType_Condition();

		/**
		 * The meta object literal for the '<em><b>Grant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_TYPE__GRANT = eINSTANCE.getRuleType_Grant();

	}

} //ActionsPackage
