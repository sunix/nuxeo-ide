/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.ecmtypes.impl;

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

import org.skinsoft.nuxeo.components.ecmtypes.EcmtypesPackage;
import org.skinsoft.nuxeo.components.ecmtypes.LayoutsType;
import org.skinsoft.nuxeo.components.ecmtypes.SubtypesType;
import org.skinsoft.nuxeo.components.ecmtypes.TypeType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.ecmtypes.impl.TypeTypeImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.ecmtypes.impl.TypeTypeImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.ecmtypes.impl.TypeTypeImpl#getDefaultView <em>Default View</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.ecmtypes.impl.TypeTypeImpl#getLayouts <em>Layouts</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.ecmtypes.impl.TypeTypeImpl#getSubtypes <em>Subtypes</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.ecmtypes.impl.TypeTypeImpl#getCoretype <em>Coretype</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.ecmtypes.impl.TypeTypeImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeTypeImpl extends EObjectImpl implements TypeType {
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
	 * The default value of the '{@link #getDefaultView() <em>Default View</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultView()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_VIEW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultView() <em>Default View</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultView()
	 * @generated
	 * @ordered
	 */
	protected String defaultView = DEFAULT_VIEW_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLayouts() <em>Layouts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayouts()
	 * @generated
	 * @ordered
	 */
	protected EList<LayoutsType> layouts;

	/**
	 * The cached value of the '{@link #getSubtypes() <em>Subtypes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubtypes()
	 * @generated
	 * @ordered
	 */
	protected SubtypesType subtypes;

	/**
	 * The default value of the '{@link #getCoretype() <em>Coretype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoretype()
	 * @generated
	 * @ordered
	 */
	protected static final String CORETYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCoretype() <em>Coretype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoretype()
	 * @generated
	 * @ordered
	 */
	protected String coretype = CORETYPE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcmtypesPackage.Literals.TYPE_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcmtypesPackage.TYPE_TYPE__LABEL, oldLabel, label));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcmtypesPackage.TYPE_TYPE__ICON, oldIcon, icon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultView() {
		return defaultView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultView(String newDefaultView) {
		String oldDefaultView = defaultView;
		defaultView = newDefaultView;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcmtypesPackage.TYPE_TYPE__DEFAULT_VIEW, oldDefaultView, defaultView));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LayoutsType> getLayouts() {
		if (layouts == null) {
			layouts = new EObjectContainmentEList<LayoutsType>(LayoutsType.class, this, EcmtypesPackage.TYPE_TYPE__LAYOUTS);
		}
		return layouts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubtypesType getSubtypes() {
		return subtypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubtypes(SubtypesType newSubtypes, NotificationChain msgs) {
		SubtypesType oldSubtypes = subtypes;
		subtypes = newSubtypes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcmtypesPackage.TYPE_TYPE__SUBTYPES, oldSubtypes, newSubtypes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubtypes(SubtypesType newSubtypes) {
		if (newSubtypes != subtypes) {
			NotificationChain msgs = null;
			if (subtypes != null)
				msgs = ((InternalEObject)subtypes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EcmtypesPackage.TYPE_TYPE__SUBTYPES, null, msgs);
			if (newSubtypes != null)
				msgs = ((InternalEObject)newSubtypes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EcmtypesPackage.TYPE_TYPE__SUBTYPES, null, msgs);
			msgs = basicSetSubtypes(newSubtypes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcmtypesPackage.TYPE_TYPE__SUBTYPES, newSubtypes, newSubtypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCoretype() {
		return coretype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoretype(String newCoretype) {
		String oldCoretype = coretype;
		coretype = newCoretype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcmtypesPackage.TYPE_TYPE__CORETYPE, oldCoretype, coretype));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EcmtypesPackage.TYPE_TYPE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EcmtypesPackage.TYPE_TYPE__LAYOUTS:
				return ((InternalEList<?>)getLayouts()).basicRemove(otherEnd, msgs);
			case EcmtypesPackage.TYPE_TYPE__SUBTYPES:
				return basicSetSubtypes(null, msgs);
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
			case EcmtypesPackage.TYPE_TYPE__LABEL:
				return getLabel();
			case EcmtypesPackage.TYPE_TYPE__ICON:
				return getIcon();
			case EcmtypesPackage.TYPE_TYPE__DEFAULT_VIEW:
				return getDefaultView();
			case EcmtypesPackage.TYPE_TYPE__LAYOUTS:
				return getLayouts();
			case EcmtypesPackage.TYPE_TYPE__SUBTYPES:
				return getSubtypes();
			case EcmtypesPackage.TYPE_TYPE__CORETYPE:
				return getCoretype();
			case EcmtypesPackage.TYPE_TYPE__ID:
				return getId();
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
			case EcmtypesPackage.TYPE_TYPE__LABEL:
				setLabel((String)newValue);
				return;
			case EcmtypesPackage.TYPE_TYPE__ICON:
				setIcon((String)newValue);
				return;
			case EcmtypesPackage.TYPE_TYPE__DEFAULT_VIEW:
				setDefaultView((String)newValue);
				return;
			case EcmtypesPackage.TYPE_TYPE__LAYOUTS:
				getLayouts().clear();
				getLayouts().addAll((Collection<? extends LayoutsType>)newValue);
				return;
			case EcmtypesPackage.TYPE_TYPE__SUBTYPES:
				setSubtypes((SubtypesType)newValue);
				return;
			case EcmtypesPackage.TYPE_TYPE__CORETYPE:
				setCoretype((String)newValue);
				return;
			case EcmtypesPackage.TYPE_TYPE__ID:
				setId((String)newValue);
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
			case EcmtypesPackage.TYPE_TYPE__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case EcmtypesPackage.TYPE_TYPE__ICON:
				setIcon(ICON_EDEFAULT);
				return;
			case EcmtypesPackage.TYPE_TYPE__DEFAULT_VIEW:
				setDefaultView(DEFAULT_VIEW_EDEFAULT);
				return;
			case EcmtypesPackage.TYPE_TYPE__LAYOUTS:
				getLayouts().clear();
				return;
			case EcmtypesPackage.TYPE_TYPE__SUBTYPES:
				setSubtypes((SubtypesType)null);
				return;
			case EcmtypesPackage.TYPE_TYPE__CORETYPE:
				setCoretype(CORETYPE_EDEFAULT);
				return;
			case EcmtypesPackage.TYPE_TYPE__ID:
				setId(ID_EDEFAULT);
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
			case EcmtypesPackage.TYPE_TYPE__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case EcmtypesPackage.TYPE_TYPE__ICON:
				return ICON_EDEFAULT == null ? icon != null : !ICON_EDEFAULT.equals(icon);
			case EcmtypesPackage.TYPE_TYPE__DEFAULT_VIEW:
				return DEFAULT_VIEW_EDEFAULT == null ? defaultView != null : !DEFAULT_VIEW_EDEFAULT.equals(defaultView);
			case EcmtypesPackage.TYPE_TYPE__LAYOUTS:
				return layouts != null && !layouts.isEmpty();
			case EcmtypesPackage.TYPE_TYPE__SUBTYPES:
				return subtypes != null;
			case EcmtypesPackage.TYPE_TYPE__CORETYPE:
				return CORETYPE_EDEFAULT == null ? coretype != null : !CORETYPE_EDEFAULT.equals(coretype);
			case EcmtypesPackage.TYPE_TYPE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
		result.append(" (label: ");
		result.append(label);
		result.append(", icon: ");
		result.append(icon);
		result.append(", defaultView: ");
		result.append(defaultView);
		result.append(", coretype: ");
		result.append(coretype);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //TypeTypeImpl
