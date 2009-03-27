/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.actions.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.skinsoft.nuxeo.components.actions.ActionsPackage;
import org.skinsoft.nuxeo.components.actions.RuleType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.impl.RuleTypeImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.impl.RuleTypeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.impl.RuleTypeImpl#getPermission <em>Permission</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.impl.RuleTypeImpl#getSchema <em>Schema</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.impl.RuleTypeImpl#getFacet <em>Facet</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.impl.RuleTypeImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.impl.RuleTypeImpl#getGrant <em>Grant</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleTypeImpl extends EObjectImpl implements RuleType {
	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group;

	/**
	 * The default value of the '{@link #getGrant() <em>Grant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrant()
	 * @generated
	 * @ordered
	 */
	protected static final String GRANT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGrant() <em>Grant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrant()
	 * @generated
	 * @ordered
	 */
	protected String grant = GRANT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionsPackage.Literals.RULE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, ActionsPackage.RULE_TYPE__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getType() {
		return getGroup().list(ActionsPackage.Literals.RULE_TYPE__TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPermission() {
		return getGroup().list(ActionsPackage.Literals.RULE_TYPE__PERMISSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSchema() {
		return getGroup().list(ActionsPackage.Literals.RULE_TYPE__SCHEMA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getFacet() {
		return getGroup().list(ActionsPackage.Literals.RULE_TYPE__FACET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCondition() {
		return getGroup().list(ActionsPackage.Literals.RULE_TYPE__CONDITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGrant() {
		return grant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrant(String newGrant) {
		String oldGrant = grant;
		grant = newGrant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.RULE_TYPE__GRANT, oldGrant, grant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionsPackage.RULE_TYPE__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
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
			case ActionsPackage.RULE_TYPE__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case ActionsPackage.RULE_TYPE__TYPE:
				return getType();
			case ActionsPackage.RULE_TYPE__PERMISSION:
				return getPermission();
			case ActionsPackage.RULE_TYPE__SCHEMA:
				return getSchema();
			case ActionsPackage.RULE_TYPE__FACET:
				return getFacet();
			case ActionsPackage.RULE_TYPE__CONDITION:
				return getCondition();
			case ActionsPackage.RULE_TYPE__GRANT:
				return getGrant();
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
			case ActionsPackage.RULE_TYPE__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case ActionsPackage.RULE_TYPE__TYPE:
				getType().clear();
				getType().addAll((Collection<? extends String>)newValue);
				return;
			case ActionsPackage.RULE_TYPE__PERMISSION:
				getPermission().clear();
				getPermission().addAll((Collection<? extends String>)newValue);
				return;
			case ActionsPackage.RULE_TYPE__SCHEMA:
				getSchema().clear();
				getSchema().addAll((Collection<? extends String>)newValue);
				return;
			case ActionsPackage.RULE_TYPE__FACET:
				getFacet().clear();
				getFacet().addAll((Collection<? extends String>)newValue);
				return;
			case ActionsPackage.RULE_TYPE__CONDITION:
				getCondition().clear();
				getCondition().addAll((Collection<? extends String>)newValue);
				return;
			case ActionsPackage.RULE_TYPE__GRANT:
				setGrant((String)newValue);
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
			case ActionsPackage.RULE_TYPE__GROUP:
				getGroup().clear();
				return;
			case ActionsPackage.RULE_TYPE__TYPE:
				getType().clear();
				return;
			case ActionsPackage.RULE_TYPE__PERMISSION:
				getPermission().clear();
				return;
			case ActionsPackage.RULE_TYPE__SCHEMA:
				getSchema().clear();
				return;
			case ActionsPackage.RULE_TYPE__FACET:
				getFacet().clear();
				return;
			case ActionsPackage.RULE_TYPE__CONDITION:
				getCondition().clear();
				return;
			case ActionsPackage.RULE_TYPE__GRANT:
				setGrant(GRANT_EDEFAULT);
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
			case ActionsPackage.RULE_TYPE__GROUP:
				return group != null && !group.isEmpty();
			case ActionsPackage.RULE_TYPE__TYPE:
				return !getType().isEmpty();
			case ActionsPackage.RULE_TYPE__PERMISSION:
				return !getPermission().isEmpty();
			case ActionsPackage.RULE_TYPE__SCHEMA:
				return !getSchema().isEmpty();
			case ActionsPackage.RULE_TYPE__FACET:
				return !getFacet().isEmpty();
			case ActionsPackage.RULE_TYPE__CONDITION:
				return !getCondition().isEmpty();
			case ActionsPackage.RULE_TYPE__GRANT:
				return GRANT_EDEFAULT == null ? grant != null : !GRANT_EDEFAULT.equals(grant);
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
		result.append(" (group: ");
		result.append(group);
		result.append(", grant: ");
		result.append(grant);
		result.append(')');
		return result.toString();
	}

} //RuleTypeImpl
