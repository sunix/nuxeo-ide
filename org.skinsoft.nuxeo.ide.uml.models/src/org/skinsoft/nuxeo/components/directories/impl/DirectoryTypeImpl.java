/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.directories.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.skinsoft.nuxeo.components.directories.DirectoriesPackage;
import org.skinsoft.nuxeo.components.directories.DirectoryType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Directory Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.impl.DirectoryTypeImpl#getSchema <em>Schema</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.impl.DirectoryTypeImpl#getParentDirectory <em>Parent Directory</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.impl.DirectoryTypeImpl#getIdField <em>Id Field</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.impl.DirectoryTypeImpl#getDataSource <em>Data Source</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.impl.DirectoryTypeImpl#getTable <em>Table</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.impl.DirectoryTypeImpl#getCreateTablePolicy <em>Create Table Policy</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.impl.DirectoryTypeImpl#getDataFile <em>Data File</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.impl.DirectoryTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.impl.DirectoryTypeImpl#getAutoincrementIdField <em>Autoincrement Id Field</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.impl.DirectoryTypeImpl#getTimestampField <em>Timestamp Field</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DirectoryTypeImpl extends EObjectImpl implements DirectoryType {
	/**
	 * The default value of the '{@link #getSchema() <em>Schema</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchema()
	 * @generated
	 * @ordered
	 */
	protected static final String SCHEMA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSchema() <em>Schema</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchema()
	 * @generated
	 * @ordered
	 */
	protected String schema = SCHEMA_EDEFAULT;

	/**
	 * The default value of the '{@link #getParentDirectory() <em>Parent Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentDirectory()
	 * @generated
	 * @ordered
	 */
	protected static final String PARENT_DIRECTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParentDirectory() <em>Parent Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentDirectory()
	 * @generated
	 * @ordered
	 */
	protected String parentDirectory = PARENT_DIRECTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getIdField() <em>Id Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdField()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_FIELD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdField() <em>Id Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdField()
	 * @generated
	 * @ordered
	 */
	protected String idField = ID_FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataSource() <em>Data Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSource()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataSource() <em>Data Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSource()
	 * @generated
	 * @ordered
	 */
	protected String dataSource = DATA_SOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTable() <em>Table</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTable()
	 * @generated
	 * @ordered
	 */
	protected static final String TABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTable() <em>Table</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTable()
	 * @generated
	 * @ordered
	 */
	protected String table = TABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreateTablePolicy() <em>Create Table Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateTablePolicy()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATE_TABLE_POLICY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreateTablePolicy() <em>Create Table Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateTablePolicy()
	 * @generated
	 * @ordered
	 */
	protected String createTablePolicy = CREATE_TABLE_POLICY_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataFile() <em>Data File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataFile()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataFile() <em>Data File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataFile()
	 * @generated
	 * @ordered
	 */
	protected String dataFile = DATA_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAutoincrementIdField() <em>Autoincrement Id Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutoincrementIdField()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTOINCREMENT_ID_FIELD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAutoincrementIdField() <em>Autoincrement Id Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutoincrementIdField()
	 * @generated
	 * @ordered
	 */
	protected String autoincrementIdField = AUTOINCREMENT_ID_FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimestampField() <em>Timestamp Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestampField()
	 * @generated
	 * @ordered
	 */
	protected static final String TIMESTAMP_FIELD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimestampField() <em>Timestamp Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestampField()
	 * @generated
	 * @ordered
	 */
	protected String timestampField = TIMESTAMP_FIELD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DirectoryTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DirectoriesPackage.Literals.DIRECTORY_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSchema() {
		return schema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchema(String newSchema) {
		String oldSchema = schema;
		schema = newSchema;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DirectoriesPackage.DIRECTORY_TYPE__SCHEMA, oldSchema, schema));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParentDirectory() {
		return parentDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentDirectory(String newParentDirectory) {
		String oldParentDirectory = parentDirectory;
		parentDirectory = newParentDirectory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DirectoriesPackage.DIRECTORY_TYPE__PARENT_DIRECTORY, oldParentDirectory, parentDirectory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdField() {
		return idField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdField(String newIdField) {
		String oldIdField = idField;
		idField = newIdField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DirectoriesPackage.DIRECTORY_TYPE__ID_FIELD, oldIdField, idField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDataSource() {
		return dataSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataSource(String newDataSource) {
		String oldDataSource = dataSource;
		dataSource = newDataSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DirectoriesPackage.DIRECTORY_TYPE__DATA_SOURCE, oldDataSource, dataSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTable() {
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTable(String newTable) {
		String oldTable = table;
		table = newTable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DirectoriesPackage.DIRECTORY_TYPE__TABLE, oldTable, table));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreateTablePolicy() {
		return createTablePolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreateTablePolicy(String newCreateTablePolicy) {
		String oldCreateTablePolicy = createTablePolicy;
		createTablePolicy = newCreateTablePolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DirectoriesPackage.DIRECTORY_TYPE__CREATE_TABLE_POLICY, oldCreateTablePolicy, createTablePolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDataFile() {
		return dataFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataFile(String newDataFile) {
		String oldDataFile = dataFile;
		dataFile = newDataFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DirectoriesPackage.DIRECTORY_TYPE__DATA_FILE, oldDataFile, dataFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DirectoriesPackage.DIRECTORY_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAutoincrementIdField() {
		return autoincrementIdField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoincrementIdField(String newAutoincrementIdField) {
		String oldAutoincrementIdField = autoincrementIdField;
		autoincrementIdField = newAutoincrementIdField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DirectoriesPackage.DIRECTORY_TYPE__AUTOINCREMENT_ID_FIELD, oldAutoincrementIdField, autoincrementIdField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTimestampField() {
		return timestampField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimestampField(String newTimestampField) {
		String oldTimestampField = timestampField;
		timestampField = newTimestampField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DirectoriesPackage.DIRECTORY_TYPE__TIMESTAMP_FIELD, oldTimestampField, timestampField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DirectoriesPackage.DIRECTORY_TYPE__SCHEMA:
				return getSchema();
			case DirectoriesPackage.DIRECTORY_TYPE__PARENT_DIRECTORY:
				return getParentDirectory();
			case DirectoriesPackage.DIRECTORY_TYPE__ID_FIELD:
				return getIdField();
			case DirectoriesPackage.DIRECTORY_TYPE__DATA_SOURCE:
				return getDataSource();
			case DirectoriesPackage.DIRECTORY_TYPE__TABLE:
				return getTable();
			case DirectoriesPackage.DIRECTORY_TYPE__CREATE_TABLE_POLICY:
				return getCreateTablePolicy();
			case DirectoriesPackage.DIRECTORY_TYPE__DATA_FILE:
				return getDataFile();
			case DirectoriesPackage.DIRECTORY_TYPE__NAME:
				return getName();
			case DirectoriesPackage.DIRECTORY_TYPE__AUTOINCREMENT_ID_FIELD:
				return getAutoincrementIdField();
			case DirectoriesPackage.DIRECTORY_TYPE__TIMESTAMP_FIELD:
				return getTimestampField();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DirectoriesPackage.DIRECTORY_TYPE__SCHEMA:
				setSchema((String)newValue);
				return;
			case DirectoriesPackage.DIRECTORY_TYPE__PARENT_DIRECTORY:
				setParentDirectory((String)newValue);
				return;
			case DirectoriesPackage.DIRECTORY_TYPE__ID_FIELD:
				setIdField((String)newValue);
				return;
			case DirectoriesPackage.DIRECTORY_TYPE__DATA_SOURCE:
				setDataSource((String)newValue);
				return;
			case DirectoriesPackage.DIRECTORY_TYPE__TABLE:
				setTable((String)newValue);
				return;
			case DirectoriesPackage.DIRECTORY_TYPE__CREATE_TABLE_POLICY:
				setCreateTablePolicy((String)newValue);
				return;
			case DirectoriesPackage.DIRECTORY_TYPE__DATA_FILE:
				setDataFile((String)newValue);
				return;
			case DirectoriesPackage.DIRECTORY_TYPE__NAME:
				setName((String)newValue);
				return;
			case DirectoriesPackage.DIRECTORY_TYPE__AUTOINCREMENT_ID_FIELD:
				setAutoincrementIdField((String)newValue);
				return;
			case DirectoriesPackage.DIRECTORY_TYPE__TIMESTAMP_FIELD:
				setTimestampField((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DirectoriesPackage.DIRECTORY_TYPE__SCHEMA:
				setSchema(SCHEMA_EDEFAULT);
				return;
			case DirectoriesPackage.DIRECTORY_TYPE__PARENT_DIRECTORY:
				setParentDirectory(PARENT_DIRECTORY_EDEFAULT);
				return;
			case DirectoriesPackage.DIRECTORY_TYPE__ID_FIELD:
				setIdField(ID_FIELD_EDEFAULT);
				return;
			case DirectoriesPackage.DIRECTORY_TYPE__DATA_SOURCE:
				setDataSource(DATA_SOURCE_EDEFAULT);
				return;
			case DirectoriesPackage.DIRECTORY_TYPE__TABLE:
				setTable(TABLE_EDEFAULT);
				return;
			case DirectoriesPackage.DIRECTORY_TYPE__CREATE_TABLE_POLICY:
				setCreateTablePolicy(CREATE_TABLE_POLICY_EDEFAULT);
				return;
			case DirectoriesPackage.DIRECTORY_TYPE__DATA_FILE:
				setDataFile(DATA_FILE_EDEFAULT);
				return;
			case DirectoriesPackage.DIRECTORY_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DirectoriesPackage.DIRECTORY_TYPE__AUTOINCREMENT_ID_FIELD:
				setAutoincrementIdField(AUTOINCREMENT_ID_FIELD_EDEFAULT);
				return;
			case DirectoriesPackage.DIRECTORY_TYPE__TIMESTAMP_FIELD:
				setTimestampField(TIMESTAMP_FIELD_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DirectoriesPackage.DIRECTORY_TYPE__SCHEMA:
				return SCHEMA_EDEFAULT == null ? schema != null : !SCHEMA_EDEFAULT.equals(schema);
			case DirectoriesPackage.DIRECTORY_TYPE__PARENT_DIRECTORY:
				return PARENT_DIRECTORY_EDEFAULT == null ? parentDirectory != null : !PARENT_DIRECTORY_EDEFAULT.equals(parentDirectory);
			case DirectoriesPackage.DIRECTORY_TYPE__ID_FIELD:
				return ID_FIELD_EDEFAULT == null ? idField != null : !ID_FIELD_EDEFAULT.equals(idField);
			case DirectoriesPackage.DIRECTORY_TYPE__DATA_SOURCE:
				return DATA_SOURCE_EDEFAULT == null ? dataSource != null : !DATA_SOURCE_EDEFAULT.equals(dataSource);
			case DirectoriesPackage.DIRECTORY_TYPE__TABLE:
				return TABLE_EDEFAULT == null ? table != null : !TABLE_EDEFAULT.equals(table);
			case DirectoriesPackage.DIRECTORY_TYPE__CREATE_TABLE_POLICY:
				return CREATE_TABLE_POLICY_EDEFAULT == null ? createTablePolicy != null : !CREATE_TABLE_POLICY_EDEFAULT.equals(createTablePolicy);
			case DirectoriesPackage.DIRECTORY_TYPE__DATA_FILE:
				return DATA_FILE_EDEFAULT == null ? dataFile != null : !DATA_FILE_EDEFAULT.equals(dataFile);
			case DirectoriesPackage.DIRECTORY_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DirectoriesPackage.DIRECTORY_TYPE__AUTOINCREMENT_ID_FIELD:
				return AUTOINCREMENT_ID_FIELD_EDEFAULT == null ? autoincrementIdField != null : !AUTOINCREMENT_ID_FIELD_EDEFAULT.equals(autoincrementIdField);
			case DirectoriesPackage.DIRECTORY_TYPE__TIMESTAMP_FIELD:
				return TIMESTAMP_FIELD_EDEFAULT == null ? timestampField != null : !TIMESTAMP_FIELD_EDEFAULT.equals(timestampField);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (schema: ");
		result.append(schema);
		result.append(", parentDirectory: ");
		result.append(parentDirectory);
		result.append(", idField: ");
		result.append(idField);
		result.append(", dataSource: ");
		result.append(dataSource);
		result.append(", table: ");
		result.append(table);
		result.append(", createTablePolicy: ");
		result.append(createTablePolicy);
		result.append(", dataFile: ");
		result.append(dataFile);
		result.append(", name: ");
		result.append(name);
		result.append(", autoincrementIdField: ");
		result.append(autoincrementIdField);
		result.append(", timestampField: ");
		result.append(timestampField);
		result.append(')');
		return result.toString();
	}

} //DirectoryTypeImpl
