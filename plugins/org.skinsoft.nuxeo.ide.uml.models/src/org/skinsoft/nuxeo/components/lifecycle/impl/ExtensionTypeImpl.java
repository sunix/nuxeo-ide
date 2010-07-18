/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.lifecycle.impl;

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

import org.skinsoft.nuxeo.components.lifecycle.ExtensionType;
import org.skinsoft.nuxeo.components.lifecycle.LifecyclePackage;
import org.skinsoft.nuxeo.components.lifecycle.LifecycleType;
import org.skinsoft.nuxeo.components.lifecycle.TypesType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.lifecycle.impl.ExtensionTypeImpl#getLifecycle <em>Lifecycle</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.lifecycle.impl.ExtensionTypeImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.lifecycle.impl.ExtensionTypeImpl#getPoint <em>Point</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.lifecycle.impl.ExtensionTypeImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionTypeImpl extends EObjectImpl implements ExtensionType {
	/**
	 * The cached value of the '{@link #getLifecycle() <em>Lifecycle</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLifecycle()
	 * @generated
	 * @ordered
	 */
	protected EList<LifecycleType> lifecycle;

	/**
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected TypesType types;

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
		return LifecyclePackage.Literals.EXTENSION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LifecycleType> getLifecycle() {
		if (lifecycle == null) {
			lifecycle = new EObjectContainmentEList<LifecycleType>(LifecycleType.class, this, LifecyclePackage.EXTENSION_TYPE__LIFECYCLE);
		}
		return lifecycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesType getTypes() {
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypes(TypesType newTypes, NotificationChain msgs) {
		TypesType oldTypes = types;
		types = newTypes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LifecyclePackage.EXTENSION_TYPE__TYPES, oldTypes, newTypes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypes(TypesType newTypes) {
		if (newTypes != types) {
			NotificationChain msgs = null;
			if (types != null)
				msgs = ((InternalEObject)types).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LifecyclePackage.EXTENSION_TYPE__TYPES, null, msgs);
			if (newTypes != null)
				msgs = ((InternalEObject)newTypes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LifecyclePackage.EXTENSION_TYPE__TYPES, null, msgs);
			msgs = basicSetTypes(newTypes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LifecyclePackage.EXTENSION_TYPE__TYPES, newTypes, newTypes));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LifecyclePackage.EXTENSION_TYPE__POINT, oldPoint, point));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LifecyclePackage.EXTENSION_TYPE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LifecyclePackage.EXTENSION_TYPE__LIFECYCLE:
				return ((InternalEList<?>)getLifecycle()).basicRemove(otherEnd, msgs);
			case LifecyclePackage.EXTENSION_TYPE__TYPES:
				return basicSetTypes(null, msgs);
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
			case LifecyclePackage.EXTENSION_TYPE__LIFECYCLE:
				return getLifecycle();
			case LifecyclePackage.EXTENSION_TYPE__TYPES:
				return getTypes();
			case LifecyclePackage.EXTENSION_TYPE__POINT:
				return getPoint();
			case LifecyclePackage.EXTENSION_TYPE__TARGET:
				return getTarget();
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
			case LifecyclePackage.EXTENSION_TYPE__LIFECYCLE:
				getLifecycle().clear();
				getLifecycle().addAll((Collection<? extends LifecycleType>)newValue);
				return;
			case LifecyclePackage.EXTENSION_TYPE__TYPES:
				setTypes((TypesType)newValue);
				return;
			case LifecyclePackage.EXTENSION_TYPE__POINT:
				setPoint((String)newValue);
				return;
			case LifecyclePackage.EXTENSION_TYPE__TARGET:
				setTarget((String)newValue);
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
			case LifecyclePackage.EXTENSION_TYPE__LIFECYCLE:
				getLifecycle().clear();
				return;
			case LifecyclePackage.EXTENSION_TYPE__TYPES:
				setTypes((TypesType)null);
				return;
			case LifecyclePackage.EXTENSION_TYPE__POINT:
				setPoint(POINT_EDEFAULT);
				return;
			case LifecyclePackage.EXTENSION_TYPE__TARGET:
				setTarget(TARGET_EDEFAULT);
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
			case LifecyclePackage.EXTENSION_TYPE__LIFECYCLE:
				return lifecycle != null && !lifecycle.isEmpty();
			case LifecyclePackage.EXTENSION_TYPE__TYPES:
				return types != null;
			case LifecyclePackage.EXTENSION_TYPE__POINT:
				return POINT_EDEFAULT == null ? point != null : !POINT_EDEFAULT.equals(point);
			case LifecyclePackage.EXTENSION_TYPE__TARGET:
				return TARGET_EDEFAULT == null ? target != null : !TARGET_EDEFAULT.equals(target);
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
