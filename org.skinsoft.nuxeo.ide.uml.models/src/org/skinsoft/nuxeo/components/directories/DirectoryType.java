/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.directories;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Directory Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getSchema <em>Schema</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getParentDirectory <em>Parent Directory</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getIdField <em>Id Field</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getDataSource <em>Data Source</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getTable <em>Table</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getCreateTablePolicy <em>Create Table Policy</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getDataFile <em>Data File</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getName <em>Name</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getAutoincrementIdField <em>Autoincrement Id Field</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getTimestampField <em>Timestamp Field</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.directories.DirectoriesPackage#getDirectoryType()
 * @model extendedMetaData="name='directoryType' kind='elementOnly'"
 * @generated
 */
public interface DirectoryType extends EObject {
	/**
	 * Returns the value of the '<em><b>Schema</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema</em>' attribute.
	 * @see #setSchema(String)
	 * @see org.skinsoft.nuxeo.components.directories.DirectoriesPackage#getDirectoryType_Schema()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='schema' namespace='##targetNamespace'"
	 * @generated
	 */
	String getSchema();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getSchema <em>Schema</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema</em>' attribute.
	 * @see #getSchema()
	 * @generated
	 */
	void setSchema(String value);

	/**
	 * Returns the value of the '<em><b>Parent Directory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Directory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Directory</em>' attribute.
	 * @see #setParentDirectory(String)
	 * @see org.skinsoft.nuxeo.components.directories.DirectoriesPackage#getDirectoryType_ParentDirectory()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='parentDirectory' namespace='##targetNamespace'"
	 * @generated
	 */
	String getParentDirectory();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getParentDirectory <em>Parent Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Directory</em>' attribute.
	 * @see #getParentDirectory()
	 * @generated
	 */
	void setParentDirectory(String value);

	/**
	 * Returns the value of the '<em><b>Id Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Field</em>' attribute.
	 * @see #setIdField(String)
	 * @see org.skinsoft.nuxeo.components.directories.DirectoriesPackage#getDirectoryType_IdField()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='idField' namespace='##targetNamespace'"
	 * @generated
	 */
	String getIdField();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getIdField <em>Id Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Field</em>' attribute.
	 * @see #getIdField()
	 * @generated
	 */
	void setIdField(String value);

	/**
	 * Returns the value of the '<em><b>Data Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Source</em>' attribute.
	 * @see #setDataSource(String)
	 * @see org.skinsoft.nuxeo.components.directories.DirectoriesPackage#getDirectoryType_DataSource()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='dataSource' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDataSource();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getDataSource <em>Data Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Source</em>' attribute.
	 * @see #getDataSource()
	 * @generated
	 */
	void setDataSource(String value);

	/**
	 * Returns the value of the '<em><b>Table</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Table</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' attribute.
	 * @see #setTable(String)
	 * @see org.skinsoft.nuxeo.components.directories.DirectoriesPackage#getDirectoryType_Table()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='table' namespace='##targetNamespace'"
	 * @generated
	 */
	String getTable();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getTable <em>Table</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' attribute.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(String value);

	/**
	 * Returns the value of the '<em><b>Create Table Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create Table Policy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Create Table Policy</em>' attribute.
	 * @see #setCreateTablePolicy(String)
	 * @see org.skinsoft.nuxeo.components.directories.DirectoriesPackage#getDirectoryType_CreateTablePolicy()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='createTablePolicy' namespace='##targetNamespace'"
	 * @generated
	 */
	String getCreateTablePolicy();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getCreateTablePolicy <em>Create Table Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create Table Policy</em>' attribute.
	 * @see #getCreateTablePolicy()
	 * @generated
	 */
	void setCreateTablePolicy(String value);

	/**
	 * Returns the value of the '<em><b>Data File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data File</em>' attribute.
	 * @see #setDataFile(String)
	 * @see org.skinsoft.nuxeo.components.directories.DirectoriesPackage#getDirectoryType_DataFile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='dataFile' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDataFile();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getDataFile <em>Data File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data File</em>' attribute.
	 * @see #getDataFile()
	 * @generated
	 */
	void setDataFile(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.skinsoft.nuxeo.components.directories.DirectoriesPackage#getDirectoryType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Autoincrement Id Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Autoincrement Id Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Autoincrement Id Field</em>' attribute.
	 * @see #setAutoincrementIdField(String)
	 * @see org.skinsoft.nuxeo.components.directories.DirectoriesPackage#getDirectoryType_AutoincrementIdField()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getAutoincrementIdField();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getAutoincrementIdField <em>Autoincrement Id Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Autoincrement Id Field</em>' attribute.
	 * @see #getAutoincrementIdField()
	 * @generated
	 */
	void setAutoincrementIdField(String value);

	/**
	 * Returns the value of the '<em><b>Timestamp Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timestamp Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timestamp Field</em>' attribute.
	 * @see #setTimestampField(String)
	 * @see org.skinsoft.nuxeo.components.directories.DirectoriesPackage#getDirectoryType_TimestampField()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getTimestampField();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.directories.DirectoryType#getTimestampField <em>Timestamp Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timestamp Field</em>' attribute.
	 * @see #getTimestampField()
	 * @generated
	 */
	void setTimestampField(String value);

} // DirectoryType
