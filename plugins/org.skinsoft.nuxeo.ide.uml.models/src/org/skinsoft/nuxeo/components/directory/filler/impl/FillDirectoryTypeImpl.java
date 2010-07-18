/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.directory.filler.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.skinsoft.nuxeo.components.directory.filler.FillDirectoryType;
import org.skinsoft.nuxeo.components.directory.filler.FillerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fill Directory Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.directory.filler.impl.FillDirectoryTypeImpl#getDataFile <em>Data File</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directory.filler.impl.FillDirectoryTypeImpl#getDataFormat <em>Data Format</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directory.filler.impl.FillDirectoryTypeImpl#getMode <em>Mode</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directory.filler.impl.FillDirectoryTypeImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FillDirectoryTypeImpl extends EObjectImpl implements FillDirectoryType {
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
	 * The default value of the '{@link #getDataFormat() <em>Data Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataFormat() <em>Data Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataFormat()
	 * @generated
	 * @ordered
	 */
	protected String dataFormat = DATA_FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected static final String MODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected String mode = MODE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FillDirectoryTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FillerPackage.Literals.FILL_DIRECTORY_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FillerPackage.FILL_DIRECTORY_TYPE__DATA_FILE, oldDataFile, dataFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDataFormat() {
		return dataFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataFormat(String newDataFormat) {
		String oldDataFormat = dataFormat;
		dataFormat = newDataFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FillerPackage.FILL_DIRECTORY_TYPE__DATA_FORMAT, oldDataFormat, dataFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMode(String newMode) {
		String oldMode = mode;
		mode = newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FillerPackage.FILL_DIRECTORY_TYPE__MODE, oldMode, mode));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FillerPackage.FILL_DIRECTORY_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FillerPackage.FILL_DIRECTORY_TYPE__DATA_FILE:
				return getDataFile();
			case FillerPackage.FILL_DIRECTORY_TYPE__DATA_FORMAT:
				return getDataFormat();
			case FillerPackage.FILL_DIRECTORY_TYPE__MODE:
				return getMode();
			case FillerPackage.FILL_DIRECTORY_TYPE__NAME:
				return getName();
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
			case FillerPackage.FILL_DIRECTORY_TYPE__DATA_FILE:
				setDataFile((String)newValue);
				return;
			case FillerPackage.FILL_DIRECTORY_TYPE__DATA_FORMAT:
				setDataFormat((String)newValue);
				return;
			case FillerPackage.FILL_DIRECTORY_TYPE__MODE:
				setMode((String)newValue);
				return;
			case FillerPackage.FILL_DIRECTORY_TYPE__NAME:
				setName((String)newValue);
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
			case FillerPackage.FILL_DIRECTORY_TYPE__DATA_FILE:
				setDataFile(DATA_FILE_EDEFAULT);
				return;
			case FillerPackage.FILL_DIRECTORY_TYPE__DATA_FORMAT:
				setDataFormat(DATA_FORMAT_EDEFAULT);
				return;
			case FillerPackage.FILL_DIRECTORY_TYPE__MODE:
				setMode(MODE_EDEFAULT);
				return;
			case FillerPackage.FILL_DIRECTORY_TYPE__NAME:
				setName(NAME_EDEFAULT);
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
			case FillerPackage.FILL_DIRECTORY_TYPE__DATA_FILE:
				return DATA_FILE_EDEFAULT == null ? dataFile != null : !DATA_FILE_EDEFAULT.equals(dataFile);
			case FillerPackage.FILL_DIRECTORY_TYPE__DATA_FORMAT:
				return DATA_FORMAT_EDEFAULT == null ? dataFormat != null : !DATA_FORMAT_EDEFAULT.equals(dataFormat);
			case FillerPackage.FILL_DIRECTORY_TYPE__MODE:
				return MODE_EDEFAULT == null ? mode != null : !MODE_EDEFAULT.equals(mode);
			case FillerPackage.FILL_DIRECTORY_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (dataFile: ");
		result.append(dataFile);
		result.append(", dataFormat: ");
		result.append(dataFormat);
		result.append(", mode: ");
		result.append(mode);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //FillDirectoryTypeImpl
