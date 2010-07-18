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
import org.skinsoft.nuxeo.components.coretypes.FacetType;
import org.skinsoft.nuxeo.components.coretypes.SchemaType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Doctype Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.coretypes.impl.DoctypeTypeImpl#getSchema <em>Schema</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.coretypes.impl.DoctypeTypeImpl#getFacet <em>Facet</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.coretypes.impl.DoctypeTypeImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.coretypes.impl.DoctypeTypeImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DoctypeTypeImpl extends EObjectImpl implements DoctypeType {
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
	 * The cached value of the '{@link #getFacet() <em>Facet</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacet()
	 * @generated
	 * @ordered
	 */
	protected EList<FacetType> facet;

	/**
	 * The default value of the '{@link #getExtends() <em>Extends</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTENDS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected String extends_ = EXTENDS_EDEFAULT;

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
	protected DoctypeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CoretypesPackage.Literals.DOCTYPE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SchemaType> getSchema() {
		if (schema == null) {
			schema = new EObjectContainmentEList<SchemaType>(SchemaType.class, this, CoretypesPackage.DOCTYPE_TYPE__SCHEMA);
		}
		return schema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FacetType> getFacet() {
		if (facet == null) {
			facet = new EObjectContainmentEList<FacetType>(FacetType.class, this, CoretypesPackage.DOCTYPE_TYPE__FACET);
		}
		return facet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExtends() {
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtends(String newExtends) {
		String oldExtends = extends_;
		extends_ = newExtends;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoretypesPackage.DOCTYPE_TYPE__EXTENDS, oldExtends, extends_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CoretypesPackage.DOCTYPE_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoretypesPackage.DOCTYPE_TYPE__SCHEMA:
				return ((InternalEList<?>)getSchema()).basicRemove(otherEnd, msgs);
			case CoretypesPackage.DOCTYPE_TYPE__FACET:
				return ((InternalEList<?>)getFacet()).basicRemove(otherEnd, msgs);
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
			case CoretypesPackage.DOCTYPE_TYPE__SCHEMA:
				return getSchema();
			case CoretypesPackage.DOCTYPE_TYPE__FACET:
				return getFacet();
			case CoretypesPackage.DOCTYPE_TYPE__EXTENDS:
				return getExtends();
			case CoretypesPackage.DOCTYPE_TYPE__NAME:
				return getName();
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
			case CoretypesPackage.DOCTYPE_TYPE__SCHEMA:
				getSchema().clear();
				getSchema().addAll((Collection<? extends SchemaType>)newValue);
				return;
			case CoretypesPackage.DOCTYPE_TYPE__FACET:
				getFacet().clear();
				getFacet().addAll((Collection<? extends FacetType>)newValue);
				return;
			case CoretypesPackage.DOCTYPE_TYPE__EXTENDS:
				setExtends((String)newValue);
				return;
			case CoretypesPackage.DOCTYPE_TYPE__NAME:
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
			case CoretypesPackage.DOCTYPE_TYPE__SCHEMA:
				getSchema().clear();
				return;
			case CoretypesPackage.DOCTYPE_TYPE__FACET:
				getFacet().clear();
				return;
			case CoretypesPackage.DOCTYPE_TYPE__EXTENDS:
				setExtends(EXTENDS_EDEFAULT);
				return;
			case CoretypesPackage.DOCTYPE_TYPE__NAME:
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
			case CoretypesPackage.DOCTYPE_TYPE__SCHEMA:
				return schema != null && !schema.isEmpty();
			case CoretypesPackage.DOCTYPE_TYPE__FACET:
				return facet != null && !facet.isEmpty();
			case CoretypesPackage.DOCTYPE_TYPE__EXTENDS:
				return EXTENDS_EDEFAULT == null ? extends_ != null : !EXTENDS_EDEFAULT.equals(extends_);
			case CoretypesPackage.DOCTYPE_TYPE__NAME:
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
		result.append(" (extends: ");
		result.append(extends_);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //DoctypeTypeImpl
