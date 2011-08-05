/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.layouts.impl;

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

import org.skinsoft.nuxeo.components.layouts.LayoutsPackage;
import org.skinsoft.nuxeo.components.layouts.PropertiesType;
import org.skinsoft.nuxeo.components.layouts.PropertyType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Properties Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.impl.PropertiesTypeImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.impl.PropertiesTypeImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.impl.PropertiesTypeImpl#getMode <em>Mode</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.impl.PropertiesTypeImpl#getWidgetMode <em>Widget Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertiesTypeImpl extends EObjectImpl implements PropertiesType {
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
	 * The default value of the '{@link #getWidgetMode() <em>Widget Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidgetMode()
	 * @generated
	 * @ordered
	 */
	protected static final String WIDGET_MODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWidgetMode() <em>Widget Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidgetMode()
	 * @generated
	 * @ordered
	 */
	protected String widgetMode = WIDGET_MODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertiesTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayoutsPackage.Literals.PROPERTIES_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, LayoutsPackage.PROPERTIES_TYPE__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyType> getProperty() {
		return getMixed().list(LayoutsPackage.Literals.PROPERTIES_TYPE__PROPERTY);
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
			eNotify(new ENotificationImpl(this, Notification.SET, LayoutsPackage.PROPERTIES_TYPE__MODE, oldMode, mode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWidgetMode() {
		return widgetMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidgetMode(String newWidgetMode) {
		String oldWidgetMode = widgetMode;
		widgetMode = newWidgetMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayoutsPackage.PROPERTIES_TYPE__WIDGET_MODE, oldWidgetMode, widgetMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayoutsPackage.PROPERTIES_TYPE__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case LayoutsPackage.PROPERTIES_TYPE__PROPERTY:
				return ((InternalEList<?>)getProperty()).basicRemove(otherEnd, msgs);
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
			case LayoutsPackage.PROPERTIES_TYPE__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case LayoutsPackage.PROPERTIES_TYPE__PROPERTY:
				return getProperty();
			case LayoutsPackage.PROPERTIES_TYPE__MODE:
				return getMode();
			case LayoutsPackage.PROPERTIES_TYPE__WIDGET_MODE:
				return getWidgetMode();
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
			case LayoutsPackage.PROPERTIES_TYPE__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case LayoutsPackage.PROPERTIES_TYPE__PROPERTY:
				getProperty().clear();
				getProperty().addAll((Collection<? extends PropertyType>)newValue);
				return;
			case LayoutsPackage.PROPERTIES_TYPE__MODE:
				setMode((String)newValue);
				return;
			case LayoutsPackage.PROPERTIES_TYPE__WIDGET_MODE:
				setWidgetMode((String)newValue);
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
			case LayoutsPackage.PROPERTIES_TYPE__MIXED:
				getMixed().clear();
				return;
			case LayoutsPackage.PROPERTIES_TYPE__PROPERTY:
				getProperty().clear();
				return;
			case LayoutsPackage.PROPERTIES_TYPE__MODE:
				setMode(MODE_EDEFAULT);
				return;
			case LayoutsPackage.PROPERTIES_TYPE__WIDGET_MODE:
				setWidgetMode(WIDGET_MODE_EDEFAULT);
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
			case LayoutsPackage.PROPERTIES_TYPE__MIXED:
				return mixed != null && !mixed.isEmpty();
			case LayoutsPackage.PROPERTIES_TYPE__PROPERTY:
				return !getProperty().isEmpty();
			case LayoutsPackage.PROPERTIES_TYPE__MODE:
				return MODE_EDEFAULT == null ? mode != null : !MODE_EDEFAULT.equals(mode);
			case LayoutsPackage.PROPERTIES_TYPE__WIDGET_MODE:
				return WIDGET_MODE_EDEFAULT == null ? widgetMode != null : !WIDGET_MODE_EDEFAULT.equals(widgetMode);
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
		result.append(", mode: ");
		result.append(mode);
		result.append(", widgetMode: ");
		result.append(widgetMode);
		result.append(')');
		return result.toString();
	}

} //PropertiesTypeImpl
