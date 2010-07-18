/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.permissions;

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
 * @see org.skinsoft.nuxeo.components.permissions.PermissionsFactory
 * @model kind="package"
 * @generated
 */
public interface PermissionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "permissions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://skinsoft.org/nuxeo/components/permissions";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "permissions";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PermissionsPackage eINSTANCE = org.skinsoft.nuxeo.components.permissions.impl.PermissionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.permissions.impl.ComponentTypeImpl <em>Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.permissions.impl.ComponentTypeImpl
	 * @see org.skinsoft.nuxeo.components.permissions.impl.PermissionsPackageImpl#getComponentType()
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
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.permissions.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.permissions.impl.DocumentRootImpl
	 * @see org.skinsoft.nuxeo.components.permissions.impl.PermissionsPackageImpl#getDocumentRoot()
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
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.permissions.impl.ExtensionTypeImpl <em>Extension Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.permissions.impl.ExtensionTypeImpl
	 * @see org.skinsoft.nuxeo.components.permissions.impl.PermissionsPackageImpl#getExtensionType()
	 * @generated
	 */
	int EXTENSION_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__PERMISSION = 0;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__VISIBILITY = 1;

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
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.permissions.impl.ItemTypeImpl <em>Item Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.permissions.impl.ItemTypeImpl
	 * @see org.skinsoft.nuxeo.components.permissions.impl.PermissionsPackageImpl#getItemType()
	 * @generated
	 */
	int ITEM_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_TYPE__ORDER = 1;

	/**
	 * The feature id for the '<em><b>Show</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_TYPE__SHOW = 2;

	/**
	 * The number of structural features of the '<em>Item Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.permissions.impl.PermissionTypeImpl <em>Permission Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.permissions.impl.PermissionTypeImpl
	 * @see org.skinsoft.nuxeo.components.permissions.impl.PermissionsPackageImpl#getPermissionType()
	 * @generated
	 */
	int PERMISSION_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_TYPE__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Include</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_TYPE__INCLUDE = 1;

	/**
	 * The feature id for the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_TYPE__ALIAS = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_TYPE__NAME = 3;

	/**
	 * The number of structural features of the '<em>Permission Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.permissions.impl.VisibilityTypeImpl <em>Visibility Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.permissions.impl.VisibilityTypeImpl
	 * @see org.skinsoft.nuxeo.components.permissions.impl.PermissionsPackageImpl#getVisibilityType()
	 * @generated
	 */
	int VISIBILITY_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Item</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIBILITY_TYPE__ITEM = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIBILITY_TYPE__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Visibility Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIBILITY_TYPE_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.permissions.ComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Type</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.ComponentType
	 * @generated
	 */
	EClass getComponentType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.permissions.ComponentType#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extension</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.ComponentType#getExtension()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_Extension();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.permissions.ComponentType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.ComponentType#getName()
	 * @see #getComponentType()
	 * @generated
	 */
	EAttribute getComponentType_Name();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.permissions.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.permissions.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.skinsoft.nuxeo.components.permissions.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.skinsoft.nuxeo.components.permissions.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.permissions.DocumentRoot#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.DocumentRoot#getComponent()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Component();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.permissions.ExtensionType <em>Extension Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Type</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.ExtensionType
	 * @generated
	 */
	EClass getExtensionType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.permissions.ExtensionType#getPermission <em>Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Permission</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.ExtensionType#getPermission()
	 * @see #getExtensionType()
	 * @generated
	 */
	EReference getExtensionType_Permission();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.permissions.ExtensionType#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Visibility</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.ExtensionType#getVisibility()
	 * @see #getExtensionType()
	 * @generated
	 */
	EReference getExtensionType_Visibility();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.permissions.ExtensionType#getPoint <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Point</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.ExtensionType#getPoint()
	 * @see #getExtensionType()
	 * @generated
	 */
	EAttribute getExtensionType_Point();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.permissions.ExtensionType#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.ExtensionType#getTarget()
	 * @see #getExtensionType()
	 * @generated
	 */
	EAttribute getExtensionType_Target();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.permissions.ItemType <em>Item Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item Type</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.ItemType
	 * @generated
	 */
	EClass getItemType();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.permissions.ItemType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.ItemType#getValue()
	 * @see #getItemType()
	 * @generated
	 */
	EAttribute getItemType_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.permissions.ItemType#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.ItemType#getOrder()
	 * @see #getItemType()
	 * @generated
	 */
	EAttribute getItemType_Order();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.permissions.ItemType#getShow <em>Show</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Show</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.ItemType#getShow()
	 * @see #getItemType()
	 * @generated
	 */
	EAttribute getItemType_Show();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.permissions.PermissionType <em>Permission Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Permission Type</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.PermissionType
	 * @generated
	 */
	EClass getPermissionType();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.permissions.PermissionType#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.PermissionType#getMixed()
	 * @see #getPermissionType()
	 * @generated
	 */
	EAttribute getPermissionType_Mixed();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.permissions.PermissionType#getInclude <em>Include</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Include</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.PermissionType#getInclude()
	 * @see #getPermissionType()
	 * @generated
	 */
	EAttribute getPermissionType_Include();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.permissions.PermissionType#getAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.PermissionType#getAlias()
	 * @see #getPermissionType()
	 * @generated
	 */
	EAttribute getPermissionType_Alias();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.permissions.PermissionType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.PermissionType#getName()
	 * @see #getPermissionType()
	 * @generated
	 */
	EAttribute getPermissionType_Name();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.permissions.VisibilityType <em>Visibility Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visibility Type</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.VisibilityType
	 * @generated
	 */
	EClass getVisibilityType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.permissions.VisibilityType#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Item</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.VisibilityType#getItem()
	 * @see #getVisibilityType()
	 * @generated
	 */
	EReference getVisibilityType_Item();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.permissions.VisibilityType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.skinsoft.nuxeo.components.permissions.VisibilityType#getType()
	 * @see #getVisibilityType()
	 * @generated
	 */
	EAttribute getVisibilityType_Type();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PermissionsFactory getPermissionsFactory();

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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.permissions.impl.ComponentTypeImpl <em>Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.permissions.impl.ComponentTypeImpl
		 * @see org.skinsoft.nuxeo.components.permissions.impl.PermissionsPackageImpl#getComponentType()
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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.permissions.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.permissions.impl.DocumentRootImpl
		 * @see org.skinsoft.nuxeo.components.permissions.impl.PermissionsPackageImpl#getDocumentRoot()
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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.permissions.impl.ExtensionTypeImpl <em>Extension Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.permissions.impl.ExtensionTypeImpl
		 * @see org.skinsoft.nuxeo.components.permissions.impl.PermissionsPackageImpl#getExtensionType()
		 * @generated
		 */
		EClass EXTENSION_TYPE = eINSTANCE.getExtensionType();

		/**
		 * The meta object literal for the '<em><b>Permission</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TYPE__PERMISSION = eINSTANCE.getExtensionType_Permission();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TYPE__VISIBILITY = eINSTANCE.getExtensionType_Visibility();

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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.permissions.impl.ItemTypeImpl <em>Item Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.permissions.impl.ItemTypeImpl
		 * @see org.skinsoft.nuxeo.components.permissions.impl.PermissionsPackageImpl#getItemType()
		 * @generated
		 */
		EClass ITEM_TYPE = eINSTANCE.getItemType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM_TYPE__VALUE = eINSTANCE.getItemType_Value();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM_TYPE__ORDER = eINSTANCE.getItemType_Order();

		/**
		 * The meta object literal for the '<em><b>Show</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM_TYPE__SHOW = eINSTANCE.getItemType_Show();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.permissions.impl.PermissionTypeImpl <em>Permission Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.permissions.impl.PermissionTypeImpl
		 * @see org.skinsoft.nuxeo.components.permissions.impl.PermissionsPackageImpl#getPermissionType()
		 * @generated
		 */
		EClass PERMISSION_TYPE = eINSTANCE.getPermissionType();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION_TYPE__MIXED = eINSTANCE.getPermissionType_Mixed();

		/**
		 * The meta object literal for the '<em><b>Include</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION_TYPE__INCLUDE = eINSTANCE.getPermissionType_Include();

		/**
		 * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION_TYPE__ALIAS = eINSTANCE.getPermissionType_Alias();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION_TYPE__NAME = eINSTANCE.getPermissionType_Name();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.permissions.impl.VisibilityTypeImpl <em>Visibility Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.permissions.impl.VisibilityTypeImpl
		 * @see org.skinsoft.nuxeo.components.permissions.impl.PermissionsPackageImpl#getVisibilityType()
		 * @generated
		 */
		EClass VISIBILITY_TYPE = eINSTANCE.getVisibilityType();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISIBILITY_TYPE__ITEM = eINSTANCE.getVisibilityType_Item();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VISIBILITY_TYPE__TYPE = eINSTANCE.getVisibilityType_Type();

	}

} //PermissionsPackage
