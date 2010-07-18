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

import org.skinsoft.nuxeo.components.layouts.LayoutType;
import org.skinsoft.nuxeo.components.layouts.LayoutsPackage;
import org.skinsoft.nuxeo.components.layouts.RowsType;
import org.skinsoft.nuxeo.components.layouts.TemplatesType;
import org.skinsoft.nuxeo.components.layouts.WidgetType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layout Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.impl.LayoutTypeImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.impl.LayoutTypeImpl#getTemplates <em>Templates</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.impl.LayoutTypeImpl#getRows <em>Rows</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.impl.LayoutTypeImpl#getWidget <em>Widget</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.impl.LayoutTypeImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LayoutTypeImpl extends EObjectImpl implements LayoutType {
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
	protected LayoutTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayoutsPackage.Literals.LAYOUT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, LayoutsPackage.LAYOUT_TYPE__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplatesType getTemplates() {
		return (TemplatesType)getMixed().get(LayoutsPackage.Literals.LAYOUT_TYPE__TEMPLATES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTemplates(TemplatesType newTemplates, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LayoutsPackage.Literals.LAYOUT_TYPE__TEMPLATES, newTemplates, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplates(TemplatesType newTemplates) {
		((FeatureMap.Internal)getMixed()).set(LayoutsPackage.Literals.LAYOUT_TYPE__TEMPLATES, newTemplates);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RowsType getRows() {
		return (RowsType)getMixed().get(LayoutsPackage.Literals.LAYOUT_TYPE__ROWS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRows(RowsType newRows, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LayoutsPackage.Literals.LAYOUT_TYPE__ROWS, newRows, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRows(RowsType newRows) {
		((FeatureMap.Internal)getMixed()).set(LayoutsPackage.Literals.LAYOUT_TYPE__ROWS, newRows);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WidgetType> getWidget() {
		return getMixed().list(LayoutsPackage.Literals.LAYOUT_TYPE__WIDGET);
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
			eNotify(new ENotificationImpl(this, Notification.SET, LayoutsPackage.LAYOUT_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayoutsPackage.LAYOUT_TYPE__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case LayoutsPackage.LAYOUT_TYPE__TEMPLATES:
				return basicSetTemplates(null, msgs);
			case LayoutsPackage.LAYOUT_TYPE__ROWS:
				return basicSetRows(null, msgs);
			case LayoutsPackage.LAYOUT_TYPE__WIDGET:
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
			case LayoutsPackage.LAYOUT_TYPE__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case LayoutsPackage.LAYOUT_TYPE__TEMPLATES:
				return getTemplates();
			case LayoutsPackage.LAYOUT_TYPE__ROWS:
				return getRows();
			case LayoutsPackage.LAYOUT_TYPE__WIDGET:
				return getWidget();
			case LayoutsPackage.LAYOUT_TYPE__NAME:
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
			case LayoutsPackage.LAYOUT_TYPE__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case LayoutsPackage.LAYOUT_TYPE__TEMPLATES:
				setTemplates((TemplatesType)newValue);
				return;
			case LayoutsPackage.LAYOUT_TYPE__ROWS:
				setRows((RowsType)newValue);
				return;
			case LayoutsPackage.LAYOUT_TYPE__WIDGET:
				getWidget().clear();
				getWidget().addAll((Collection<? extends WidgetType>)newValue);
				return;
			case LayoutsPackage.LAYOUT_TYPE__NAME:
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
			case LayoutsPackage.LAYOUT_TYPE__MIXED:
				getMixed().clear();
				return;
			case LayoutsPackage.LAYOUT_TYPE__TEMPLATES:
				setTemplates((TemplatesType)null);
				return;
			case LayoutsPackage.LAYOUT_TYPE__ROWS:
				setRows((RowsType)null);
				return;
			case LayoutsPackage.LAYOUT_TYPE__WIDGET:
				getWidget().clear();
				return;
			case LayoutsPackage.LAYOUT_TYPE__NAME:
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
			case LayoutsPackage.LAYOUT_TYPE__MIXED:
				return mixed != null && !mixed.isEmpty();
			case LayoutsPackage.LAYOUT_TYPE__TEMPLATES:
				return getTemplates() != null;
			case LayoutsPackage.LAYOUT_TYPE__ROWS:
				return getRows() != null;
			case LayoutsPackage.LAYOUT_TYPE__WIDGET:
				return !getWidget().isEmpty();
			case LayoutsPackage.LAYOUT_TYPE__NAME:
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
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //LayoutTypeImpl
