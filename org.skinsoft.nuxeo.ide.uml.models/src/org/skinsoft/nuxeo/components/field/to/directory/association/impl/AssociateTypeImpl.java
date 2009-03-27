/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.field.to.directory.association.impl;

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

import org.skinsoft.nuxeo.components.field.to.directory.association.AssociateType;
import org.skinsoft.nuxeo.components.field.to.directory.association.AssociationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Associate Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.field.to.directory.association.impl.AssociateTypeImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.field.to.directory.association.impl.AssociateTypeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.field.to.directory.association.impl.AssociateTypeImpl#getToDirectory <em>To Directory</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.field.to.directory.association.impl.AssociateTypeImpl#getXpath <em>Xpath</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociateTypeImpl extends EObjectImpl implements AssociateType {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The default value of the '{@link #getToDirectory() <em>To Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToDirectory()
	 * @generated
	 * @ordered
	 */
	protected static final String TO_DIRECTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getToDirectory() <em>To Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToDirectory()
	 * @generated
	 * @ordered
	 */
	protected String toDirectory = TO_DIRECTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getXpath() <em>Xpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXpath()
	 * @generated
	 * @ordered
	 */
	protected static final String XPATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXpath() <em>Xpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXpath()
	 * @generated
	 * @ordered
	 */
	protected String xpath = XPATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociateTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AssociationPackage.Literals.ASSOCIATE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, AssociationPackage.ASSOCIATE_TYPE__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getType() {
		return getMixed().list(AssociationPackage.Literals.ASSOCIATE_TYPE__TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getToDirectory() {
		return toDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToDirectory(String newToDirectory) {
		String oldToDirectory = toDirectory;
		toDirectory = newToDirectory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssociationPackage.ASSOCIATE_TYPE__TO_DIRECTORY, oldToDirectory, toDirectory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXpath() {
		return xpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXpath(String newXpath) {
		String oldXpath = xpath;
		xpath = newXpath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssociationPackage.ASSOCIATE_TYPE__XPATH, oldXpath, xpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AssociationPackage.ASSOCIATE_TYPE__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
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
			case AssociationPackage.ASSOCIATE_TYPE__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case AssociationPackage.ASSOCIATE_TYPE__TYPE:
				return getType();
			case AssociationPackage.ASSOCIATE_TYPE__TO_DIRECTORY:
				return getToDirectory();
			case AssociationPackage.ASSOCIATE_TYPE__XPATH:
				return getXpath();
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
			case AssociationPackage.ASSOCIATE_TYPE__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case AssociationPackage.ASSOCIATE_TYPE__TYPE:
				getType().clear();
				getType().addAll((Collection<? extends String>)newValue);
				return;
			case AssociationPackage.ASSOCIATE_TYPE__TO_DIRECTORY:
				setToDirectory((String)newValue);
				return;
			case AssociationPackage.ASSOCIATE_TYPE__XPATH:
				setXpath((String)newValue);
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
			case AssociationPackage.ASSOCIATE_TYPE__MIXED:
				getMixed().clear();
				return;
			case AssociationPackage.ASSOCIATE_TYPE__TYPE:
				getType().clear();
				return;
			case AssociationPackage.ASSOCIATE_TYPE__TO_DIRECTORY:
				setToDirectory(TO_DIRECTORY_EDEFAULT);
				return;
			case AssociationPackage.ASSOCIATE_TYPE__XPATH:
				setXpath(XPATH_EDEFAULT);
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
			case AssociationPackage.ASSOCIATE_TYPE__MIXED:
				return mixed != null && !mixed.isEmpty();
			case AssociationPackage.ASSOCIATE_TYPE__TYPE:
				return !getType().isEmpty();
			case AssociationPackage.ASSOCIATE_TYPE__TO_DIRECTORY:
				return TO_DIRECTORY_EDEFAULT == null ? toDirectory != null : !TO_DIRECTORY_EDEFAULT.equals(toDirectory);
			case AssociationPackage.ASSOCIATE_TYPE__XPATH:
				return XPATH_EDEFAULT == null ? xpath != null : !XPATH_EDEFAULT.equals(xpath);
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
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(", toDirectory: ");
		result.append(toDirectory);
		result.append(", xpath: ");
		result.append(xpath);
		result.append(')');
		return result.toString();
	}

} //AssociateTypeImpl
