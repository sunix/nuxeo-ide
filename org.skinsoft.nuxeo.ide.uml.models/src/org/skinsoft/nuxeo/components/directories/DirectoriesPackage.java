/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.directories;

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
 * @see org.skinsoft.nuxeo.components.directories.DirectoriesFactory
 * @model kind="package"
 * @generated
 */
public interface DirectoriesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "directories";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://skinsoft.org/nuxeo/components/directories";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "directories";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DirectoriesPackage eINSTANCE = org.skinsoft.nuxeo.components.directories.impl.DirectoriesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.directories.impl.ComponentTypeImpl <em>Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.directories.impl.ComponentTypeImpl
	 * @see org.skinsoft.nuxeo.components.directories.impl.DirectoriesPackageImpl#getComponentType()
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
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.directories.impl.DirectoryTypeImpl <em>Directory Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.directories.impl.DirectoryTypeImpl
	 * @see org.skinsoft.nuxeo.components.directories.impl.DirectoriesPackageImpl#getDirectoryType()
	 * @generated
	 */
	int DIRECTORY_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Schema</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_TYPE__SCHEMA = 0;

	/**
	 * The feature id for the '<em><b>Parent Directory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_TYPE__PARENT_DIRECTORY = 1;

	/**
	 * The feature id for the '<em><b>Id Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_TYPE__ID_FIELD = 2;

	/**
	 * The feature id for the '<em><b>Data Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_TYPE__DATA_SOURCE = 3;

	/**
	 * The feature id for the '<em><b>Table</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_TYPE__TABLE = 4;

	/**
	 * The feature id for the '<em><b>Create Table Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_TYPE__CREATE_TABLE_POLICY = 5;

	/**
	 * The feature id for the '<em><b>Data File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_TYPE__DATA_FILE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_TYPE__NAME = 7;

	/**
	 * The feature id for the '<em><b>Autoincrement Id Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_TYPE__AUTOINCREMENT_ID_FIELD = 8;

	/**
	 * The feature id for the '<em><b>Timestamp Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_TYPE__TIMESTAMP_FIELD = 9;

	/**
	 * The number of structural features of the '<em>Directory Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_TYPE_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.directories.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.directories.impl.DocumentRootImpl
	 * @see org.skinsoft.nuxeo.components.directories.impl.DirectoriesPackageImpl#getDocumentRoot()
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
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.directories.impl.ExtensionTypeImpl <em>Extension Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.directories.impl.ExtensionTypeImpl
	 * @see org.skinsoft.nuxeo.components.directories.impl.DirectoriesPackageImpl#getExtensionType()
	 * @generated
	 */
	int EXTENSION_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Directory</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__DIRECTORY = 0;

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
	 * The feature id for the '<em><b>Timestamp</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__TIMESTAMP = 3;

	/**
	 * The number of structural features of the '<em>Extension Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.directories.impl.TimestampTypeImpl <em>Timestamp Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.directories.impl.TimestampTypeImpl
	 * @see org.skinsoft.nuxeo.components.directories.impl.DirectoriesPackageImpl#getTimestampType()
	 * @generated
	 */
	int TIMESTAMP_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMESTAMP_TYPE__FIELD = 0;

	/**
	 * The feature id for the '<em><b>Directory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMESTAMP_TYPE__DIRECTORY = 1;

	/**
	 * The number of structural features of the '<em>Timestamp Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMESTAMP_TYPE_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.directories.ComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Type</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.ComponentType
	 * @generated
	 */
	EClass getComponentType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.directories.ComponentType#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extension</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.ComponentType#getExtension()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_Extension();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.directories.ComponentType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.ComponentType#getName()
	 * @see #getComponentType()
	 * @generated
	 */
	EAttribute getComponentType_Name();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.directories.DirectoryType <em>Directory Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Directory Type</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.DirectoryType
	 * @generated
	 */
	EClass getDirectoryType();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Schema</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.DirectoryType#getSchema()
	 * @see #getDirectoryType()
	 * @generated
	 */
	EAttribute getDirectoryType_Schema();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getParentDirectory <em>Parent Directory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent Directory</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.DirectoryType#getParentDirectory()
	 * @see #getDirectoryType()
	 * @generated
	 */
	EAttribute getDirectoryType_ParentDirectory();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getIdField <em>Id Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Field</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.DirectoryType#getIdField()
	 * @see #getDirectoryType()
	 * @generated
	 */
	EAttribute getDirectoryType_IdField();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getDataSource <em>Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Source</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.DirectoryType#getDataSource()
	 * @see #getDirectoryType()
	 * @generated
	 */
	EAttribute getDirectoryType_DataSource();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Table</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.DirectoryType#getTable()
	 * @see #getDirectoryType()
	 * @generated
	 */
	EAttribute getDirectoryType_Table();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getCreateTablePolicy <em>Create Table Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Create Table Policy</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.DirectoryType#getCreateTablePolicy()
	 * @see #getDirectoryType()
	 * @generated
	 */
	EAttribute getDirectoryType_CreateTablePolicy();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getDataFile <em>Data File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data File</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.DirectoryType#getDataFile()
	 * @see #getDirectoryType()
	 * @generated
	 */
	EAttribute getDirectoryType_DataFile();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.DirectoryType#getName()
	 * @see #getDirectoryType()
	 * @generated
	 */
	EAttribute getDirectoryType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getAutoincrementIdField <em>Autoincrement Id Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Autoincrement Id Field</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.DirectoryType#getAutoincrementIdField()
	 * @see #getDirectoryType()
	 * @generated
	 */
	EAttribute getDirectoryType_AutoincrementIdField();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getTimestampField <em>Timestamp Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp Field</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.DirectoryType#getTimestampField()
	 * @see #getDirectoryType()
	 * @generated
	 */
	EAttribute getDirectoryType_TimestampField();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.directories.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.directories.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.skinsoft.nuxeo.components.directories.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.skinsoft.nuxeo.components.directories.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.directories.DocumentRoot#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.DocumentRoot#getComponent()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Component();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.directories.ExtensionType <em>Extension Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Type</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.ExtensionType
	 * @generated
	 */
	EClass getExtensionType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.directories.ExtensionType#getDirectory <em>Directory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Directory</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.ExtensionType#getDirectory()
	 * @see #getExtensionType()
	 * @generated
	 */
	EReference getExtensionType_Directory();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.directories.ExtensionType#getPoint <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Point</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.ExtensionType#getPoint()
	 * @see #getExtensionType()
	 * @generated
	 */
	EAttribute getExtensionType_Point();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.directories.ExtensionType#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.ExtensionType#getTarget()
	 * @see #getExtensionType()
	 * @generated
	 */
	EAttribute getExtensionType_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.directories.ExtensionType#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Timestamp</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.ExtensionType#getTimestamp()
	 * @see #getExtensionType()
	 * @generated
	 */
	EReference getExtensionType_Timestamp();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.directories.TimestampType <em>Timestamp Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timestamp Type</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.TimestampType
	 * @generated
	 */
	EClass getTimestampType();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.directories.TimestampType#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.TimestampType#getField()
	 * @see #getTimestampType()
	 * @generated
	 */
	EAttribute getTimestampType_Field();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.directories.TimestampType#getDirectory <em>Directory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Directory</em>'.
	 * @see org.skinsoft.nuxeo.components.directories.TimestampType#getDirectory()
	 * @see #getTimestampType()
	 * @generated
	 */
	EAttribute getTimestampType_Directory();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DirectoriesFactory getDirectoriesFactory();

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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.directories.impl.ComponentTypeImpl <em>Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.directories.impl.ComponentTypeImpl
		 * @see org.skinsoft.nuxeo.components.directories.impl.DirectoriesPackageImpl#getComponentType()
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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.directories.impl.DirectoryTypeImpl <em>Directory Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.directories.impl.DirectoryTypeImpl
		 * @see org.skinsoft.nuxeo.components.directories.impl.DirectoriesPackageImpl#getDirectoryType()
		 * @generated
		 */
		EClass DIRECTORY_TYPE = eINSTANCE.getDirectoryType();

		/**
		 * The meta object literal for the '<em><b>Schema</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECTORY_TYPE__SCHEMA = eINSTANCE.getDirectoryType_Schema();

		/**
		 * The meta object literal for the '<em><b>Parent Directory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECTORY_TYPE__PARENT_DIRECTORY = eINSTANCE.getDirectoryType_ParentDirectory();

		/**
		 * The meta object literal for the '<em><b>Id Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECTORY_TYPE__ID_FIELD = eINSTANCE.getDirectoryType_IdField();

		/**
		 * The meta object literal for the '<em><b>Data Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECTORY_TYPE__DATA_SOURCE = eINSTANCE.getDirectoryType_DataSource();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECTORY_TYPE__TABLE = eINSTANCE.getDirectoryType_Table();

		/**
		 * The meta object literal for the '<em><b>Create Table Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECTORY_TYPE__CREATE_TABLE_POLICY = eINSTANCE.getDirectoryType_CreateTablePolicy();

		/**
		 * The meta object literal for the '<em><b>Data File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECTORY_TYPE__DATA_FILE = eINSTANCE.getDirectoryType_DataFile();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECTORY_TYPE__NAME = eINSTANCE.getDirectoryType_Name();

		/**
		 * The meta object literal for the '<em><b>Autoincrement Id Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECTORY_TYPE__AUTOINCREMENT_ID_FIELD = eINSTANCE.getDirectoryType_AutoincrementIdField();

		/**
		 * The meta object literal for the '<em><b>Timestamp Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECTORY_TYPE__TIMESTAMP_FIELD = eINSTANCE.getDirectoryType_TimestampField();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.directories.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.directories.impl.DocumentRootImpl
		 * @see org.skinsoft.nuxeo.components.directories.impl.DirectoriesPackageImpl#getDocumentRoot()
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
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.directories.impl.ExtensionTypeImpl <em>Extension Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.directories.impl.ExtensionTypeImpl
		 * @see org.skinsoft.nuxeo.components.directories.impl.DirectoriesPackageImpl#getExtensionType()
		 * @generated
		 */
		EClass EXTENSION_TYPE = eINSTANCE.getExtensionType();

		/**
		 * The meta object literal for the '<em><b>Directory</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TYPE__DIRECTORY = eINSTANCE.getExtensionType_Directory();

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
		 * The meta object literal for the '<em><b>Timestamp</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TYPE__TIMESTAMP = eINSTANCE.getExtensionType_Timestamp();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.directories.impl.TimestampTypeImpl <em>Timestamp Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.directories.impl.TimestampTypeImpl
		 * @see org.skinsoft.nuxeo.components.directories.impl.DirectoriesPackageImpl#getTimestampType()
		 * @generated
		 */
		EClass TIMESTAMP_TYPE = eINSTANCE.getTimestampType();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMESTAMP_TYPE__FIELD = eINSTANCE.getTimestampType_Field();

		/**
		 * The meta object literal for the '<em><b>Directory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMESTAMP_TYPE__DIRECTORY = eINSTANCE.getTimestampType_Directory();

	}

} //DirectoriesPackage
