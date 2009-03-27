/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.coretypes.impl;

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

import org.skinsoft.nuxeo.components.coretypes.CoretypesPackage;
import org.skinsoft.nuxeo.components.coretypes.DoctypeType;
import org.skinsoft.nuxeo.components.coretypes.ExtensionType;
import org.skinsoft.nuxeo.components.coretypes.SchemaType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.coretypes.impl.ExtensionTypeImpl#getSchema <em>Schema</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.coretypes.impl.ExtensionTypeImpl#getDoctype <em>Doctype</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.coretypes.impl.ExtensionTypeImpl#getPoint <em>Point</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.coretypes.impl.ExtensionTypeImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionTypeImpl extends EObjectImpl implements ExtensionType {
	/**
	 * The cached value of the '{@link #getSchema() <em>Schema</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchema()
	 * @generated
	 * @ordered
	 */
	protected EList<SchemaType> schema;

	/**
	 * The cached value of the '{@link #getDoctype() <em>Doctype</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoctype()
	 * @generated
	 * @ordered
	 */
	protected EList<DoctypeType> doctype;

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
		return CoretypesPackage.Literals.EXTENSION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SchemaType> getSchema() {
		if (schema == null) {
			schema = new EObjectContainmentEList<SchemaType>(SchemaType.class, this, CoretypesPackage.EXTENSION_TYPE__SCHEMA);
		}
		return schema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DoctypeType> getDoctype() {
		if (doctype == null) {
			doctype = new EObjectContainmentEList<DoctypeType>(DoctypeType.class, this, CoretypesPackage.EXTENSION_TYPE__DOCTYPE);
		}
		return doctype;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CoretypesPackage.EXTENSION_TYPE__POINT, oldPoint, point));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CoretypesPackage.EXTENSION_TYPE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoretypesPackage.EXTENSION_TYPE__SCHEMA:
				return ((InternalEList<?>)getSchema()).basicRemove(otherEnd, msgs);
			case CoretypesPackage.EXTENSION_TYPE__DOCTYPE:
				return ((InternalEList<?>)getDoctype()).basicRemove(otherEnd, msgs);
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
			case CoretypesPackage.EXTENSION_TYPE__SCHEMA:
				return getSchema();
			case CoretypesPackage.EXTENSION_TYPE__DOCTYPE:
				return getDoctype();
			case CoretypesPackage.EXTENSION_TYPE__POINT:
				return getPoint();
			case CoretypesPackage.EXTENSION_TYPE__TARGET:
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
			case CoretypesPackage.EXTENSION_TYPE__SCHEMA:
				getSchema().clear();
				getSchema().addAll((Collection<? extends SchemaType>)newValue);
				return;
			case CoretypesPackage.EXTENSION_TYPE__DOCTYPE:
				getDoctype().clear();
				getDoctype().addAll((Collection<? extends DoctypeType>)newValue);
				return;
			case CoretypesPackage.EXTENSION_TYPE__POINT:
				setPoint((String)newValue);
				return;
			case CoretypesPackage.EXTENSION_TYPE__TARGET:
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
			case CoretypesPackage.EXTENSION_TYPE__SCHEMA:
				getSchema().clear();
				return;
			case CoretypesPackage.EXTENSION_TYPE__DOCTYPE:
				getDoctype().clear();
				return;
			case CoretypesPackage.EXTENSION_TYPE__POINT:
				setPoint(POINT_EDEFAULT);
				return;
			case CoretypesPackage.EXTENSION_TYPE__TARGET:
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
			case CoretypesPackage.EXTENSION_TYPE__SCHEMA:
				return schema != null && !schema.isEmpty();
			case CoretypesPackage.EXTENSION_TYPE__DOCTYPE:
				return doctype != null && !doctype.isEmpty();
			case CoretypesPackage.EXTENSION_TYPE__POINT:
				return POINT_EDEFAULT == null ? point != null : !POINT_EDEFAULT.equals(point);
			case CoretypesPackage.EXTENSION_TYPE__TARGET:
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
