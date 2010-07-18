/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.layouts.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.skinsoft.nuxeo.components.layouts.LayoutsPackage;
import org.skinsoft.nuxeo.components.layouts.SubWidgetsType;
import org.skinsoft.nuxeo.components.layouts.WidgetType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Widgets Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.impl.SubWidgetsTypeImpl#getWidget <em>Widget</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubWidgetsTypeImpl extends EObjectImpl implements SubWidgetsType {
	/**
	 * The cached value of the '{@link #getWidget() <em>Widget</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidget()
	 * @generated
	 * @ordered
	 */
	protected EList<WidgetType> widget;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubWidgetsTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayoutsPackage.Literals.SUB_WIDGETS_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WidgetType> getWidget() {
		if (widget == null) {
			widget = new EObjectContainmentEList<WidgetType>(WidgetType.class, this, LayoutsPackage.SUB_WIDGETS_TYPE__WIDGET);
		}
		return widget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayoutsPackage.SUB_WIDGETS_TYPE__WIDGET:
				return ((InternalEList<?>)getWidget()).basicRemove(otherEnd, msgs);
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
			case LayoutsPackage.SUB_WIDGETS_TYPE__WIDGET:
				return getWidget();
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
			case LayoutsPackage.SUB_WIDGETS_TYPE__WIDGET:
				getWidget().clear();
				getWidget().addAll((Collection<? extends WidgetType>)newValue);
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
			case LayoutsPackage.SUB_WIDGETS_TYPE__WIDGET:
				getWidget().clear();
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
			case LayoutsPackage.SUB_WIDGETS_TYPE__WIDGET:
				return widget != null && !widget.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SubWidgetsTypeImpl
