/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.directories.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.skinsoft.nuxeo.components.directories.DirectoriesPackage;
import org.skinsoft.nuxeo.components.directories.DirectoryType;
import org.skinsoft.nuxeo.components.directories.ExtensionType;
import org.skinsoft.nuxeo.components.directories.TimestampType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.impl.ExtensionTypeImpl#getDirectory <em>Directory</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.impl.ExtensionTypeImpl#getPoint <em>Point</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.impl.ExtensionTypeImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directories.impl.ExtensionTypeImpl#getTimestamp <em>Timestamp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionTypeImpl extends EObjectImpl implements ExtensionType {
	/**
	 * The cached value of the '{@link #getDirectory() <em>Directory</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectory()
	 * @generated
	 * @ordered
	 */
	protected EList<DirectoryType> directory;

	/**
	 * The default value of the '{@link #getPoint() <em>Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoint()
	 * @generated
	 * @ordered
	 */
	protected static final String POINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPoint() <em>Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoint()
	 * @generated
	 * @ordered
	 */
	protected String point = POINT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected String target = TARGET_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTimestamp() <em>Timestamp</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestamp()
	 * @generated
	 * @ordered
	 */
	protected EList<TimestampType> timestamp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DirectoriesPackage.Literals.EXTENSION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DirectoryType> getDirectory() {
		if (directory == null) {
			directory = new EObjectContainmentEList<DirectoryType>(DirectoryType.class, this, DirectoriesPackage.EXTENSION_TYPE__DIRECTORY);
		}
		return directory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPoint() {
		return point;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPoint(String newPoint) {
		String oldPoint = point;
		point = newPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DirectoriesPackage.EXTENSION_TYPE__POINT, oldPoint, point));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(String newTarget) {
		String oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DirectoriesPackage.EXTENSION_TYPE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TimestampType> getTimestamp() {
		if (timestamp == null) {
			timestamp = new EObjectContainmentEList<TimestampType>(TimestampType.class, this, DirectoriesPackage.EXTENSION_TYPE__TIMESTAMP);
		}
		return timestamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DirectoriesPackage.EXTENSION_TYPE__DIRECTORY:
				return ((InternalEList<?>)getDirectory()).basicRemove(otherEnd, msgs);
			case DirectoriesPackage.EXTENSION_TYPE__TIMESTAMP:
				return ((InternalEList<?>)getTimestamp()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DirectoriesPackage.EXTENSION_TYPE__DIRECTORY:
				return getDirectory();
			case DirectoriesPackage.EXTENSION_TYPE__POINT:
				return getPoint();
			case DirectoriesPackage.EXTENSION_TYPE__TARGET:
				return getTarget();
			case DirectoriesPackage.EXTENSION_TYPE__TIMESTAMP:
				return getTimestamp();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DirectoriesPackage.EXTENSION_TYPE__DIRECTORY:
				getDirectory().clear();
				getDirectory().addAll((Collection<? extends DirectoryType>)newValue);
				return;
			case DirectoriesPackage.EXTENSION_TYPE__POINT:
				setPoint((String)newValue);
				return;
			case DirectoriesPackage.EXTENSION_TYPE__TARGET:
				setTarget((String)newValue);
				return;
			case DirectoriesPackage.EXTENSION_TYPE__TIMESTAMP:
				getTimestamp().clear();
				getTimestamp().addAll((Collection<? extends TimestampType>)newValue);
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
			case DirectoriesPackage.EXTENSION_TYPE__DIRECTORY:
				getDirectory().clear();
				return;
			case DirectoriesPackage.EXTENSION_TYPE__POINT:
				setPoint(POINT_EDEFAULT);
				return;
			case DirectoriesPackage.EXTENSION_TYPE__TARGET:
				setTarget(TARGET_EDEFAULT);
				return;
			case DirectoriesPackage.EXTENSION_TYPE__TIMESTAMP:
				getTimestamp().clear();
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
			case DirectoriesPackage.EXTENSION_TYPE__DIRECTORY:
				return directory != null && !directory.isEmpty();
			case DirectoriesPackage.EXTENSION_TYPE__POINT:
				return POINT_EDEFAULT == null ? point != null : !POINT_EDEFAULT.equals(point);
			case DirectoriesPackage.EXTENSION_TYPE__TARGET:
				return TARGET_EDEFAULT == null ? target != null : !TARGET_EDEFAULT.equals(target);
			case DirectoriesPackage.EXTENSION_TYPE__TIMESTAMP:
				return timestamp != null && !timestamp.isEmpty();
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
		result.append(" (point: ");
		result.append(point);
		result.append(", target: ");
		result.append(target);
		result.append(')');
		return result.toString();
	}

} //ExtensionTypeImpl
