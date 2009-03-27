/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.jbpm.service.impl;

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

import org.skinsoft.nuxeo.components.jbpm.service.ExtensionType;
import org.skinsoft.nuxeo.components.jbpm.service.ProcessDefinitionType;
import org.skinsoft.nuxeo.components.jbpm.service.SecurityPolicyType;
import org.skinsoft.nuxeo.components.jbpm.service.ServicePackage;
import org.skinsoft.nuxeo.components.jbpm.service.TypeType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.jbpm.service.impl.ExtensionTypeImpl#getProcessDefinition <em>Process Definition</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.jbpm.service.impl.ExtensionTypeImpl#getSecurityPolicy <em>Security Policy</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.jbpm.service.impl.ExtensionTypeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.jbpm.service.impl.ExtensionTypeImpl#getPoint <em>Point</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.jbpm.service.impl.ExtensionTypeImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionTypeImpl extends EObjectImpl implements ExtensionType {
	/**
	 * The cached value of the '{@link #getProcessDefinition() <em>Process Definition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessDefinition()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessDefinitionType> processDefinition;

	/**
	 * The cached value of the '{@link #getSecurityPolicy() <em>Security Policy</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecurityPolicy()
	 * @generated
	 * @ordered
	 */
	protected EList<SecurityPolicyType> securityPolicy;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeType> type;

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
		return ServicePackage.Literals.EXTENSION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessDefinitionType> getProcessDefinition() {
		if (processDefinition == null) {
			processDefinition = new EObjectContainmentEList<ProcessDefinitionType>(ProcessDefinitionType.class, this, ServicePackage.EXTENSION_TYPE__PROCESS_DEFINITION);
		}
		return processDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SecurityPolicyType> getSecurityPolicy() {
		if (securityPolicy == null) {
			securityPolicy = new EObjectContainmentEList<SecurityPolicyType>(SecurityPolicyType.class, this, ServicePackage.EXTENSION_TYPE__SECURITY_POLICY);
		}
		return securityPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeType> getType() {
		if (type == null) {
			type = new EObjectContainmentEList<TypeType>(TypeType.class, this, ServicePackage.EXTENSION_TYPE__TYPE);
		}
		return type;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.EXTENSION_TYPE__POINT, oldPoint, point));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.EXTENSION_TYPE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicePackage.EXTENSION_TYPE__PROCESS_DEFINITION:
				return ((InternalEList<?>)getProcessDefinition()).basicRemove(otherEnd, msgs);
			case ServicePackage.EXTENSION_TYPE__SECURITY_POLICY:
				return ((InternalEList<?>)getSecurityPolicy()).basicRemove(otherEnd, msgs);
			case ServicePackage.EXTENSION_TYPE__TYPE:
				return ((InternalEList<?>)getType()).basicRemove(otherEnd, msgs);
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
			case ServicePackage.EXTENSION_TYPE__PROCESS_DEFINITION:
				return getProcessDefinition();
			case ServicePackage.EXTENSION_TYPE__SECURITY_POLICY:
				return getSecurityPolicy();
			case ServicePackage.EXTENSION_TYPE__TYPE:
				return getType();
			case ServicePackage.EXTENSION_TYPE__POINT:
				return getPoint();
			case ServicePackage.EXTENSION_TYPE__TARGET:
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
			case ServicePackage.EXTENSION_TYPE__PROCESS_DEFINITION:
				getProcessDefinition().clear();
				getProcessDefinition().addAll((Collection<? extends ProcessDefinitionType>)newValue);
				return;
			case ServicePackage.EXTENSION_TYPE__SECURITY_POLICY:
				getSecurityPolicy().clear();
				getSecurityPolicy().addAll((Collection<? extends SecurityPolicyType>)newValue);
				return;
			case ServicePackage.EXTENSION_TYPE__TYPE:
				getType().clear();
				getType().addAll((Collection<? extends TypeType>)newValue);
				return;
			case ServicePackage.EXTENSION_TYPE__POINT:
				setPoint((String)newValue);
				return;
			case ServicePackage.EXTENSION_TYPE__TARGET:
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
			case ServicePackage.EXTENSION_TYPE__PROCESS_DEFINITION:
				getProcessDefinition().clear();
				return;
			case ServicePackage.EXTENSION_TYPE__SECURITY_POLICY:
				getSecurityPolicy().clear();
				return;
			case ServicePackage.EXTENSION_TYPE__TYPE:
				getType().clear();
				return;
			case ServicePackage.EXTENSION_TYPE__POINT:
				setPoint(POINT_EDEFAULT);
				return;
			case ServicePackage.EXTENSION_TYPE__TARGET:
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
			case ServicePackage.EXTENSION_TYPE__PROCESS_DEFINITION:
				return processDefinition != null && !processDefinition.isEmpty();
			case ServicePackage.EXTENSION_TYPE__SECURITY_POLICY:
				return securityPolicy != null && !securityPolicy.isEmpty();
			case ServicePackage.EXTENSION_TYPE__TYPE:
				return type != null && !type.isEmpty();
			case ServicePackage.EXTENSION_TYPE__POINT:
				return POINT_EDEFAULT == null ? point != null : !POINT_EDEFAULT.equals(point);
			case ServicePackage.EXTENSION_TYPE__TARGET:
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
