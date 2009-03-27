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

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.skinsoft.nuxeo.components.actions.ActionType;
import org.skinsoft.nuxeo.components.actions.ActionsPackage;
import org.skinsoft.nuxeo.components.actions.FilterType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.impl.ActionTypeImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.impl.ActionTypeImpl#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.impl.ActionTypeImpl#getFilterId <em>Filter Id</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.impl.ActionTypeImpl#getEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.impl.ActionTypeImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.impl.ActionTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.impl.ActionTypeImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.impl.ActionTypeImpl#getLink <em>Link</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.impl.ActionTypeImpl#getOrder <em>Order</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionTypeImpl extends EObjectImpl implements ActionType {
	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected EList<String> category;

	/**
	 * The cached value of the '{@link #getFilter() <em>Filter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilter()
	 * @generated
	 * @ordered
	 */
	protected EList<FilterType> filter;

	/**
	 * The cached value of the '{@link #getFilterId() <em>Filter Id</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilterId()
	 * @generated
	 * @ordered
	 */
	protected EList<String> filterId;

	/**
	 * The default value of the '{@link #getEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final String ENABLED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnabled()
	 * @generated
	 * @ordered
	 */
	protected String enabled = ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected String icon = ICON_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getLink() <em>Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLink() <em>Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink()
	 * @generated
	 * @ordered
	 */
	protected String link = LINK_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected static final String ORDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected String order = ORDER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionsPackage.Literals.ACTION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCategory() {
		if (category == null) {
			category = new EDataTypeEList<String>(String.class, this, ActionsPackage.ACTION_TYPE__CATEGORY);
		}
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FilterType> getFilter() {
		if (filter == null) {
			filter = new EObjectContainmentEList<FilterType>(FilterType.class, this, ActionsPackage.ACTION_TYPE__FILTER);
		}
		return filter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getFilterId() {
		if (filterId == null) {
			filterId = new EDataTypeEList<String>(String.class, this, ActionsPackage.ACTION_TYPE__FILTER_ID);
		}
		return filterId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEnabled() {
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(String newEnabled) {
		String oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.ACTION_TYPE__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcon(String newIcon) {
		String oldIcon = icon;
		icon = newIcon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.ACTION_TYPE__ICON, oldIcon, icon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.ACTION_TYPE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.ACTION_TYPE__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLink() {
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink(String newLink) {
		String oldLink = link;
		link = newLink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.ACTION_TYPE__LINK, oldLink, link));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrder(String newOrder) {
		String oldOrder = order;
		order = newOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.ACTION_TYPE__ORDER, oldOrder, order));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionsPackage.ACTION_TYPE__FILTER:
				return ((InternalEList<?>)getFilter()).basicRemove(otherEnd, msgs);
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
			case ActionsPackage.ACTION_TYPE__CATEGORY:
				return getCategory();
			case ActionsPackage.ACTION_TYPE__FILTER:
				return getFilter();
			case ActionsPackage.ACTION_TYPE__FILTER_ID:
				return getFilterId();
			case ActionsPackage.ACTION_TYPE__ENABLED:
				return getEnabled();
			case ActionsPackage.ACTION_TYPE__ICON:
				return getIcon();
			case ActionsPackage.ACTION_TYPE__ID:
				return getId();
			case ActionsPackage.ACTION_TYPE__LABEL:
				return getLabel();
			case ActionsPackage.ACTION_TYPE__LINK:
				return getLink();
			case ActionsPackage.ACTION_TYPE__ORDER:
				return getOrder();
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
			case ActionsPackage.ACTION_TYPE__CATEGORY:
				getCategory().clear();
				getCategory().addAll((Collection<? extends String>)newValue);
				return;
			case ActionsPackage.ACTION_TYPE__FILTER:
				getFilter().clear();
				getFilter().addAll((Collection<? extends FilterType>)newValue);
				return;
			case ActionsPackage.ACTION_TYPE__FILTER_ID:
				getFilterId().clear();
				getFilterId().addAll((Collection<? extends String>)newValue);
				return;
			case ActionsPackage.ACTION_TYPE__ENABLED:
				setEnabled((String)newValue);
				return;
			case ActionsPackage.ACTION_TYPE__ICON:
				setIcon((String)newValue);
				return;
			case ActionsPackage.ACTION_TYPE__ID:
				setId((String)newValue);
				return;
			case ActionsPackage.ACTION_TYPE__LABEL:
				setLabel((String)newValue);
				return;
			case ActionsPackage.ACTION_TYPE__LINK:
				setLink((String)newValue);
				return;
			case ActionsPackage.ACTION_TYPE__ORDER:
				setOrder((String)newValue);
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
			case ActionsPackage.ACTION_TYPE__CATEGORY:
				getCategory().clear();
				return;
			case ActionsPackage.ACTION_TYPE__FILTER:
				getFilter().clear();
				return;
			case ActionsPackage.ACTION_TYPE__FILTER_ID:
				getFilterId().clear();
				return;
			case ActionsPackage.ACTION_TYPE__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case ActionsPackage.ACTION_TYPE__ICON:
				setIcon(ICON_EDEFAULT);
				return;
			case ActionsPackage.ACTION_TYPE__ID:
				setId(ID_EDEFAULT);
				return;
			case ActionsPackage.ACTION_TYPE__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case ActionsPackage.ACTION_TYPE__LINK:
				setLink(LINK_EDEFAULT);
				return;
			case ActionsPackage.ACTION_TYPE__ORDER:
				setOrder(ORDER_EDEFAULT);
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
			case ActionsPackage.ACTION_TYPE__CATEGORY:
				return category != null && !category.isEmpty();
			case ActionsPackage.ACTION_TYPE__FILTER:
				return filter != null && !filter.isEmpty();
			case ActionsPackage.ACTION_TYPE__FILTER_ID:
				return filterId != null && !filterId.isEmpty();
			case ActionsPackage.ACTION_TYPE__ENABLED:
				return ENABLED_EDEFAULT == null ? enabled != null : !ENABLED_EDEFAULT.equals(enabled);
			case ActionsPackage.ACTION_TYPE__ICON:
				return ICON_EDEFAULT == null ? icon != null : !ICON_EDEFAULT.equals(icon);
			case ActionsPackage.ACTION_TYPE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ActionsPackage.ACTION_TYPE__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case ActionsPackage.ACTION_TYPE__LINK:
				return LINK_EDEFAULT == null ? link != null : !LINK_EDEFAULT.equals(link);
			case ActionsPackage.ACTION_TYPE__ORDER:
				return ORDER_EDEFAULT == null ? order != null : !ORDER_EDEFAULT.equals(order);
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
		result.append(" (category: ");
		result.append(category);
		result.append(", filterId: ");
		result.append(filterId);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", icon: ");
		result.append(icon);
		result.append(", id: ");
		result.append(id);
		result.append(", label: ");
		result.append(label);
		result.append(", link: ");
		result.append(link);
		result.append(", order: ");
		result.append(order);
		result.append(')');
		return result.toString();
	}

} //ActionTypeImpl
