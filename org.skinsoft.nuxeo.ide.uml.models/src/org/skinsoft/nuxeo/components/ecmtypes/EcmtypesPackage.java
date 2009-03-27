/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.ecmtypes;

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
 * @see org.skinsoft.nuxeo.components.ecmtypes.EcmtypesFactory
 * @model kind="package"
 * @generated
 */
public interface EcmtypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ecmtypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://skinsoft.org/nuxeo/components/ecmtypes";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ecmtypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EcmtypesPackage eINSTANCE = org.skinsoft.nuxeo.components.ecmtypes.impl.EcmtypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.ecmtypes.impl.ComponentTypeImpl <em>Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.ComponentTypeImpl
	 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.EcmtypesPackageImpl#getComponentType()
	 * @generated
	 */
	int COMPONENT_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Require</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__REQUIRE = 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference.
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
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.ecmtypes.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.DocumentRootImpl
	 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.EcmtypesPackageImpl#getDocumentRoot()
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
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.ecmtypes.impl.ExtensionTypeImpl <em>Extension Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.ExtensionTypeImpl
	 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.EcmtypesPackageImpl#getExtensionType()
	 * @generated
	 */
	int EXTENSION_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__POINT = 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__TARGET = 2;

	/**
	 * The number of structural features of the '<em>Extension Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.ecmtypes.impl.LayoutsTypeImpl <em>Layouts Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.LayoutsTypeImpl
	 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.EcmtypesPackageImpl#getLayoutsType()
	 * @generated
	 */
	int LAYOUTS_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUTS_TYPE__LAYOUT = 0;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUTS_TYPE__MODE = 1;

	/**
	 * The number of structural features of the '<em>Layouts Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUTS_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.ecmtypes.impl.SubtypesTypeImpl <em>Subtypes Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.SubtypesTypeImpl
	 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.EcmtypesPackageImpl#getSubtypesType()
	 * @generated
	 */
	int SUBTYPES_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTYPES_TYPE__TYPE = 0;

	/**
	 * The number of structural features of the '<em>Subtypes Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTYPES_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.ecmtypes.impl.TypeTypeImpl <em>Type Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.TypeTypeImpl
	 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.EcmtypesPackageImpl#getTypeType()
	 * @generated
	 */
	int TYPE_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__ICON = 1;

	/**
	 * The feature id for the '<em><b>Default View</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__DEFAULT_VIEW = 2;

	/**
	 * The feature id for the '<em><b>Layouts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__LAYOUTS = 3;

	/**
	 * The feature id for the '<em><b>Subtypes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__SUBTYPES = 4;

	/**
	 * The feature id for the '<em><b>Coretype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__CORETYPE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__ID = 6;

	/**
	 * The number of structural features of the '<em>Type Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_FEATURE_COUNT = 7;


	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.ecmtypes.ComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Type</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.ComponentType
	 * @generated
	 */
	EClass getComponentType();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.ecmtypes.ComponentType#getRequire <em>Require</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Require</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.ComponentType#getRequire()
	 * @see #getComponentType()
	 * @generated
	 */
	EAttribute getComponentType_Require();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.ecmtypes.ComponentType#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extension</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.ComponentType#getExtension()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_Extension();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.ecmtypes.ComponentType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.ComponentType#getName()
	 * @see #getComponentType()
	 * @generated
	 */
	EAttribute getComponentType_Name();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.ecmtypes.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.ecmtypes.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.skinsoft.nuxeo.components.ecmtypes.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.skinsoft.nuxeo.components.ecmtypes.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.ecmtypes.DocumentRoot#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.DocumentRoot#getComponent()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Component();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.ecmtypes.ExtensionType <em>Extension Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Type</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.ExtensionType
	 * @generated
	 */
	EClass getExtensionType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.ecmtypes.ExtensionType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.ExtensionType#getType()
	 * @see #getExtensionType()
	 * @generated
	 */
	EReference getExtensionType_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.ecmtypes.ExtensionType#getPoint <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Point</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.ExtensionType#getPoint()
	 * @see #getExtensionType()
	 * @generated
	 */
	EAttribute getExtensionType_Point();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.ecmtypes.ExtensionType#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.ExtensionType#getTarget()
	 * @see #getExtensionType()
	 * @generated
	 */
	EAttribute getExtensionType_Target();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.ecmtypes.LayoutsType <em>Layouts Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layouts Type</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.LayoutsType
	 * @generated
	 */
	EClass getLayoutsType();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.ecmtypes.LayoutsType#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Layout</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.LayoutsType#getLayout()
	 * @see #getLayoutsType()
	 * @generated
	 */
	EAttribute getLayoutsType_Layout();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.ecmtypes.LayoutsType#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.LayoutsType#getMode()
	 * @see #getLayoutsType()
	 * @generated
	 */
	EAttribute getLayoutsType_Mode();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.ecmtypes.SubtypesType <em>Subtypes Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subtypes Type</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.SubtypesType
	 * @generated
	 */
	EClass getSubtypesType();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.ecmtypes.SubtypesType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Type</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.SubtypesType#getType()
	 * @see #getSubtypesType()
	 * @generated
	 */
	EAttribute getSubtypesType_Type();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.ecmtypes.TypeType <em>Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Type</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.TypeType
	 * @generated
	 */
	EClass getTypeType();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.ecmtypes.TypeType#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.TypeType#getLabel()
	 * @see #getTypeType()
	 * @generated
	 */
	EAttribute getTypeType_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.ecmtypes.TypeType#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.TypeType#getIcon()
	 * @see #getTypeType()
	 * @generated
	 */
	EAttribute getTypeType_Icon();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.ecmtypes.TypeType#getDefaultView <em>Default View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default View</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.TypeType#getDefaultView()
	 * @see #getTypeType()
	 * @generated
	 */
	EAttribute getTypeType_DefaultView();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.ecmtypes.TypeType#getLayouts <em>Layouts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Layouts</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.TypeType#getLayouts()
	 * @see #getTypeType()
	 * @generated
	 */
	EReference getTypeType_Layouts();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.ecmtypes.TypeType#getSubtypes <em>Subtypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Subtypes</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.TypeType#getSubtypes()
	 * @see #getTypeType()
	 * @generated
	 */
	EReference getTypeType_Subtypes();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.ecmtypes.TypeType#getCoretype <em>Coretype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Coretype</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.TypeType#getCoretype()
	 * @see #getTypeType()
	 * @generated
	 */
	EAttribute getTypeType_Coretype();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.ecmtypes.TypeType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.TypeType#getId()
	 * @see #getTypeType()
	 * @generated
	 */
	EAttribute getTypeType_Id();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EcmtypesFactory getEcmtypesFactory();

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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.ecmtypes.impl.ComponentTypeImpl <em>Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.ComponentTypeImpl
		 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.EcmtypesPackageImpl#getComponentType()
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
		 * The meta object literal for the '<em><b>Extension</b></em>' containment reference feature.
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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.ecmtypes.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.DocumentRootImpl
		 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.EcmtypesPackageImpl#getDocumentRoot()
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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.ecmtypes.impl.ExtensionTypeImpl <em>Extension Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.ExtensionTypeImpl
		 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.EcmtypesPackageImpl#getExtensionType()
		 * @generated
		 */
		EClass EXTENSION_TYPE = eINSTANCE.getExtensionType();

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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.ecmtypes.impl.LayoutsTypeImpl <em>Layouts Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.LayoutsTypeImpl
		 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.EcmtypesPackageImpl#getLayoutsType()
		 * @generated
		 */
		EClass LAYOUTS_TYPE = eINSTANCE.getLayoutsType();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYOUTS_TYPE__LAYOUT = eINSTANCE.getLayoutsType_Layout();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYOUTS_TYPE__MODE = eINSTANCE.getLayoutsType_Mode();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.ecmtypes.impl.SubtypesTypeImpl <em>Subtypes Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.SubtypesTypeImpl
		 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.EcmtypesPackageImpl#getSubtypesType()
		 * @generated
		 */
		EClass SUBTYPES_TYPE = eINSTANCE.getSubtypesType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBTYPES_TYPE__TYPE = eINSTANCE.getSubtypesType_Type();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.ecmtypes.impl.TypeTypeImpl <em>Type Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.TypeTypeImpl
		 * @see org.skinsoft.nuxeo.components.ecmtypes.impl.EcmtypesPackageImpl#getTypeType()
		 * @generated
		 */
		EClass TYPE_TYPE = eINSTANCE.getTypeType();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_TYPE__LABEL = eINSTANCE.getTypeType_Label();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_TYPE__ICON = eINSTANCE.getTypeType_Icon();

		/**
		 * The meta object literal for the '<em><b>Default View</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_TYPE__DEFAULT_VIEW = eINSTANCE.getTypeType_DefaultView();

		/**
		 * The meta object literal for the '<em><b>Layouts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_TYPE__LAYOUTS = eINSTANCE.getTypeType_Layouts();

		/**
		 * The meta object literal for the '<em><b>Subtypes</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_TYPE__SUBTYPES = eINSTANCE.getTypeType_Subtypes();

		/**
		 * The meta object literal for the '<em><b>Coretype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_TYPE__CORETYPE = eINSTANCE.getTypeType_Coretype();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_TYPE__ID = eINSTANCE.getTypeType_Id();

	}

} //EcmtypesPackage
