/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.lifecycle.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.skinsoft.nuxeo.components.lifecycle.LifecyclePackage;
import org.skinsoft.nuxeo.components.lifecycle.LifecycleType;
import org.skinsoft.nuxeo.components.lifecycle.StatesType;
import org.skinsoft.nuxeo.components.lifecycle.TransitionsType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.lifecycle.impl.LifecycleTypeImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.lifecycle.impl.LifecycleTypeImpl#getStates <em>States</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.lifecycle.impl.LifecycleTypeImpl#getInitial <em>Initial</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.lifecycle.impl.LifecycleTypeImpl#getLifecyclemanager <em>Lifecyclemanager</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.lifecycle.impl.LifecycleTypeImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LifecycleTypeImpl extends EObjectImpl implements LifecycleType {
	/**
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected TransitionsType transitions;

	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected StatesType states;

	/**
	 * The default value of the '{@link #getInitial() <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitial()
	 * @generated
	 * @ordered
	 */
	protected static final String INITIAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInitial() <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitial()
	 * @generated
	 * @ordered
	 */
	protected String initial = INITIAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getLifecyclemanager() <em>Lifecyclemanager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLifecyclemanager()
	 * @generated
	 * @ordered
	 */
	protected static final String LIFECYCLEMANAGER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLifecyclemanager() <em>Lifecyclemanager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLifecyclemanager()
	 * @generated
	 * @ordered
	 */
	protected String lifecyclemanager = LIFECYCLEMANAGER_EDEFAULT;

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
	protected LifecycleTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LifecyclePackage.Literals.LIFECYCLE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionsType getTransitions() {
		return transitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransitions(TransitionsType newTransitions, NotificationChain msgs) {
		TransitionsType oldTransitions = transitions;
		transitions = newTransitions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LifecyclePackage.LIFECYCLE_TYPE__TRANSITIONS, oldTransitions, newTransitions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransitions(TransitionsType newTransitions) {
		if (newTransitions != transitions) {
			NotificationChain msgs = null;
			if (transitions != null)
				msgs = ((InternalEObject)transitions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LifecyclePackage.LIFECYCLE_TYPE__TRANSITIONS, null, msgs);
			if (newTransitions != null)
				msgs = ((InternalEObject)newTransitions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LifecyclePackage.LIFECYCLE_TYPE__TRANSITIONS, null, msgs);
			msgs = basicSetTransitions(newTransitions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LifecyclePackage.LIFECYCLE_TYPE__TRANSITIONS, newTransitions, newTransitions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatesType getStates() {
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStates(StatesType newStates, NotificationChain msgs) {
		StatesType oldStates = states;
		states = newStates;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LifecyclePackage.LIFECYCLE_TYPE__STATES, oldStates, newStates);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStates(StatesType newStates) {
		if (newStates != states) {
			NotificationChain msgs = null;
			if (states != null)
				msgs = ((InternalEObject)states).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LifecyclePackage.LIFECYCLE_TYPE__STATES, null, msgs);
			if (newStates != null)
				msgs = ((InternalEObject)newStates).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LifecyclePackage.LIFECYCLE_TYPE__STATES, null, msgs);
			msgs = basicSetStates(newStates, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LifecyclePackage.LIFECYCLE_TYPE__STATES, newStates, newStates));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInitial() {
		return initial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitial(String newInitial) {
		String oldInitial = initial;
		initial = newInitial;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LifecyclePackage.LIFECYCLE_TYPE__INITIAL, oldInitial, initial));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLifecyclemanager() {
		return lifecyclemanager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLifecyclemanager(String newLifecyclemanager) {
		String oldLifecyclemanager = lifecyclemanager;
		lifecyclemanager = newLifecyclemanager;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LifecyclePackage.LIFECYCLE_TYPE__LIFECYCLEMANAGER, oldLifecyclemanager, lifecyclemanager));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LifecyclePackage.LIFECYCLE_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LifecyclePackage.LIFECYCLE_TYPE__TRANSITIONS:
				return basicSetTransitions(null, msgs);
			case LifecyclePackage.LIFECYCLE_TYPE__STATES:
				return basicSetStates(null, msgs);
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
			case LifecyclePackage.LIFECYCLE_TYPE__TRANSITIONS:
				return getTransitions();
			case LifecyclePackage.LIFECYCLE_TYPE__STATES:
				return getStates();
			case LifecyclePackage.LIFECYCLE_TYPE__INITIAL:
				return getInitial();
			case LifecyclePackage.LIFECYCLE_TYPE__LIFECYCLEMANAGER:
				return getLifecyclemanager();
			case LifecyclePackage.LIFECYCLE_TYPE__NAME:
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
			case LifecyclePackage.LIFECYCLE_TYPE__TRANSITIONS:
				setTransitions((TransitionsType)newValue);
				return;
			case LifecyclePackage.LIFECYCLE_TYPE__STATES:
				setStates((StatesType)newValue);
				return;
			case LifecyclePackage.LIFECYCLE_TYPE__INITIAL:
				setInitial((String)newValue);
				return;
			case LifecyclePackage.LIFECYCLE_TYPE__LIFECYCLEMANAGER:
				setLifecyclemanager((String)newValue);
				return;
			case LifecyclePackage.LIFECYCLE_TYPE__NAME:
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
			case LifecyclePackage.LIFECYCLE_TYPE__TRANSITIONS:
				setTransitions((TransitionsType)null);
				return;
			case LifecyclePackage.LIFECYCLE_TYPE__STATES:
				setStates((StatesType)null);
				return;
			case LifecyclePackage.LIFECYCLE_TYPE__INITIAL:
				setInitial(INITIAL_EDEFAULT);
				return;
			case LifecyclePackage.LIFECYCLE_TYPE__LIFECYCLEMANAGER:
				setLifecyclemanager(LIFECYCLEMANAGER_EDEFAULT);
				return;
			case LifecyclePackage.LIFECYCLE_TYPE__NAME:
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
			case LifecyclePackage.LIFECYCLE_TYPE__TRANSITIONS:
				return transitions != null;
			case LifecyclePackage.LIFECYCLE_TYPE__STATES:
				return states != null;
			case LifecyclePackage.LIFECYCLE_TYPE__INITIAL:
				return INITIAL_EDEFAULT == null ? initial != null : !INITIAL_EDEFAULT.equals(initial);
			case LifecyclePackage.LIFECYCLE_TYPE__LIFECYCLEMANAGER:
				return LIFECYCLEMANAGER_EDEFAULT == null ? lifecyclemanager != null : !LIFECYCLEMANAGER_EDEFAULT.equals(lifecyclemanager);
			case LifecyclePackage.LIFECYCLE_TYPE__NAME:
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
		result.append(" (initial: ");
		result.append(initial);
		result.append(", lifecyclemanager: ");
		result.append(lifecyclemanager);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //LifecycleTypeImpl
