/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.coretypes;

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
 * @see org.skinsoft.nuxeo.components.coretypes.CoretypesFactory
 * @model kind="package"
 * @generated
 */
public interface CoretypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "coretypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://skinsoft.org/nuxeo/components/coretypes";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "coretypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CoretypesPackage eINSTANCE = org.skinsoft.nuxeo.components.coretypes.impl.CoretypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.coretypes.impl.ComponentTypeImpl <em>Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.coretypes.impl.ComponentTypeImpl
	 * @see org.skinsoft.nuxeo.components.coretypes.impl.CoretypesPackageImpl#getComponentType()
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
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.coretypes.impl.DoctypeTypeImpl <em>Doctype Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.coretypes.impl.DoctypeTypeImpl
	 * @see org.skinsoft.nuxeo.components.coretypes.impl.CoretypesPackageImpl#getDoctypeType()
	 * @generated
	 */
	int DOCTYPE_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Schema</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCTYPE_TYPE__SCHEMA = 0;

	/**
	 * The feature id for the '<em><b>Facet</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCTYPE_TYPE__FACET = 1;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCTYPE_TYPE__EXTENDS = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCTYPE_TYPE__NAME = 3;

	/**
	 * The number of structural features of the '<em>Doctype Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCTYPE_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.coretypes.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.coretypes.impl.DocumentRootImpl
	 * @see org.skinsoft.nuxeo.components.coretypes.impl.CoretypesPackageImpl#getDocumentRoot()
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
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.coretypes.impl.ExtensionTypeImpl <em>Extension Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.coretypes.impl.ExtensionTypeImpl
	 * @see org.skinsoft.nuxeo.components.coretypes.impl.CoretypesPackageImpl#getExtensionType()
	 * @generated
	 */
	int EXTENSION_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Schema</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__SCHEMA = 0;

	/**
	 * The feature id for the '<em><b>Doctype</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__DOCTYPE = 1;

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
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.coretypes.impl.FacetTypeImpl <em>Facet Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.coretypes.impl.FacetTypeImpl
	 * @see org.skinsoft.nuxeo.components.coretypes.impl.CoretypesPackageImpl#getFacetType()
	 * @generated
	 */
	int FACET_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_TYPE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Facet Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.coretypes.impl.SchemaTypeImpl <em>Schema Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.coretypes.impl.SchemaTypeImpl
	 * @see org.skinsoft.nuxeo.components.coretypes.impl.CoretypesPackageImpl#getSchemaType()
	 * @generated
	 */
	int SCHEMA_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_TYPE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_TYPE__PREFIX = 2;

	/**
	 * The feature id for the '<em><b>Src</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_TYPE__SRC = 3;

	/**
	 * The number of structural features of the '<em>Schema Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_TYPE_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.coretypes.ComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Type</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.ComponentType
	 * @generated
	 */
	EClass getComponentType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.coretypes.ComponentType#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extension</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.ComponentType#getExtension()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_Extension();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.coretypes.ComponentType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.ComponentType#getName()
	 * @see #getComponentType()
	 * @generated
	 */
	EAttribute getComponentType_Name();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.coretypes.DoctypeType <em>Doctype Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Doctype Type</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.DoctypeType
	 * @generated
	 */
	EClass getDoctypeType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.coretypes.DoctypeType#getSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Schema</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.DoctypeType#getSchema()
	 * @see #getDoctypeType()
	 * @generated
	 */
	EReference getDoctypeType_Schema();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.coretypes.DoctypeType#getFacet <em>Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Facet</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.DoctypeType#getFacet()
	 * @see #getDoctypeType()
	 * @generated
	 */
	EReference getDoctypeType_Facet();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.coretypes.DoctypeType#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extends</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.DoctypeType#getExtends()
	 * @see #getDoctypeType()
	 * @generated
	 */
	EAttribute getDoctypeType_Extends();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.coretypes.DoctypeType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.DoctypeType#getName()
	 * @see #getDoctypeType()
	 * @generated
	 */
	EAttribute getDoctypeType_Name();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.coretypes.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.coretypes.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.skinsoft.nuxeo.components.coretypes.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.skinsoft.nuxeo.components.coretypes.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.coretypes.DocumentRoot#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.DocumentRoot#getComponent()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Component();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.coretypes.ExtensionType <em>Extension Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Type</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.ExtensionType
	 * @generated
	 */
	EClass getExtensionType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.coretypes.ExtensionType#getSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Schema</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.ExtensionType#getSchema()
	 * @see #getExtensionType()
	 * @generated
	 */
	EReference getExtensionType_Schema();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.coretypes.ExtensionType#getDoctype <em>Doctype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Doctype</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.ExtensionType#getDoctype()
	 * @see #getExtensionType()
	 * @generated
	 */
	EReference getExtensionType_Doctype();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.coretypes.ExtensionType#getPoint <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Point</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.ExtensionType#getPoint()
	 * @see #getExtensionType()
	 * @generated
	 */
	EAttribute getExtensionType_Point();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.coretypes.ExtensionType#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.ExtensionType#getTarget()
	 * @see #getExtensionType()
	 * @generated
	 */
	EAttribute getExtensionType_Target();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.coretypes.FacetType <em>Facet Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet Type</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.FacetType
	 * @generated
	 */
	EClass getFacetType();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.coretypes.FacetType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.FacetType#getValue()
	 * @see #getFacetType()
	 * @generated
	 */
	EAttribute getFacetType_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.coretypes.FacetType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.FacetType#getName()
	 * @see #getFacetType()
	 * @generated
	 */
	EAttribute getFacetType_Name();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.coretypes.SchemaType <em>Schema Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schema Type</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.SchemaType
	 * @generated
	 */
	EClass getSchemaType();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.coretypes.SchemaType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.SchemaType#getValue()
	 * @see #getSchemaType()
	 * @generated
	 */
	EAttribute getSchemaType_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.coretypes.SchemaType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.SchemaType#getName()
	 * @see #getSchemaType()
	 * @generated
	 */
	EAttribute getSchemaType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.coretypes.SchemaType#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.SchemaType#getPrefix()
	 * @see #getSchemaType()
	 * @generated
	 */
	EAttribute getSchemaType_Prefix();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.coretypes.SchemaType#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src</em>'.
	 * @see org.skinsoft.nuxeo.components.coretypes.SchemaType#getSrc()
	 * @see #getSchemaType()
	 * @generated
	 */
	EAttribute getSchemaType_Src();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CoretypesFactory getCoretypesFactory();

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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.coretypes.impl.ComponentTypeImpl <em>Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.coretypes.impl.ComponentTypeImpl
		 * @see org.skinsoft.nuxeo.components.coretypes.impl.CoretypesPackageImpl#getComponentType()
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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.coretypes.impl.DoctypeTypeImpl <em>Doctype Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.coretypes.impl.DoctypeTypeImpl
		 * @see org.skinsoft.nuxeo.components.coretypes.impl.CoretypesPackageImpl#getDoctypeType()
		 * @generated
		 */
		EClass DOCTYPE_TYPE = eINSTANCE.getDoctypeType();

		/**
		 * The meta object literal for the '<em><b>Schema</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCTYPE_TYPE__SCHEMA = eINSTANCE.getDoctypeType_Schema();

		/**
		 * The meta object literal for the '<em><b>Facet</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCTYPE_TYPE__FACET = eINSTANCE.getDoctypeType_Facet();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCTYPE_TYPE__EXTENDS = eINSTANCE.getDoctypeType_Extends();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCTYPE_TYPE__NAME = eINSTANCE.getDoctypeType_Name();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.coretypes.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.coretypes.impl.DocumentRootImpl
		 * @see org.skinsoft.nuxeo.components.coretypes.impl.CoretypesPackageImpl#getDocumentRoot()
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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.coretypes.impl.ExtensionTypeImpl <em>Extension Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.coretypes.impl.ExtensionTypeImpl
		 * @see org.skinsoft.nuxeo.components.coretypes.impl.CoretypesPackageImpl#getExtensionType()
		 * @generated
		 */
		EClass EXTENSION_TYPE = eINSTANCE.getExtensionType();

		/**
		 * The meta object literal for the '<em><b>Schema</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TYPE__SCHEMA = eINSTANCE.getExtensionType_Schema();

		/**
		 * The meta object literal for the '<em><b>Doctype</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TYPE__DOCTYPE = eINSTANCE.getExtensionType_Doctype();

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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.coretypes.impl.FacetTypeImpl <em>Facet Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.coretypes.impl.FacetTypeImpl
		 * @see org.skinsoft.nuxeo.components.coretypes.impl.CoretypesPackageImpl#getFacetType()
		 * @generated
		 */
		EClass FACET_TYPE = eINSTANCE.getFacetType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACET_TYPE__VALUE = eINSTANCE.getFacetType_Value();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACET_TYPE__NAME = eINSTANCE.getFacetType_Name();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.coretypes.impl.SchemaTypeImpl <em>Schema Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.coretypes.impl.SchemaTypeImpl
		 * @see org.skinsoft.nuxeo.components.coretypes.impl.CoretypesPackageImpl#getSchemaType()
		 * @generated
		 */
		EClass SCHEMA_TYPE = eINSTANCE.getSchemaType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEMA_TYPE__VALUE = eINSTANCE.getSchemaType_Value();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEMA_TYPE__NAME = eINSTANCE.getSchemaType_Name();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEMA_TYPE__PREFIX = eINSTANCE.getSchemaType_Prefix();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEMA_TYPE__SRC = eINSTANCE.getSchemaType_Src();

	}

} //CoretypesPackage
