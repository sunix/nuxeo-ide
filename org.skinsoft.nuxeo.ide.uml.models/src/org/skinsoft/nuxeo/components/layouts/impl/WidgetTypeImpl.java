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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.skinsoft.nuxeo.components.layouts.FieldsType;
import org.skinsoft.nuxeo.components.layouts.HelpLabelsType;
import org.skinsoft.nuxeo.components.layouts.LabelsType;
import org.skinsoft.nuxeo.components.layouts.LayoutsPackage;
import org.skinsoft.nuxeo.components.layouts.PropertiesType;
import org.skinsoft.nuxeo.components.layouts.SubWidgetsType;
import org.skinsoft.nuxeo.components.layouts.WidgetModesType;
import org.skinsoft.nuxeo.components.layouts.WidgetType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Widget Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.impl.WidgetTypeImpl#getLabels <em>Labels</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.impl.WidgetTypeImpl#getHelpLabels <em>Help Labels</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.impl.WidgetTypeImpl#getTranslated <em>Translated</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.impl.WidgetTypeImpl#getFields <em>Fields</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.impl.WidgetTypeImpl#getWidgetModes <em>Widget Modes</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.impl.WidgetTypeImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.impl.WidgetTypeImpl#getSubWidgets <em>Sub Widgets</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.impl.WidgetTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.impl.WidgetTypeImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WidgetTypeImpl extends EObjectImpl implements WidgetType {
	/**
	 * The cached value of the '{@link #getLabels() <em>Labels</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabels()
	 * @generated
	 * @ordered
	 */
	protected LabelsType labels;

	/**
	 * The cached value of the '{@link #getHelpLabels() <em>Help Labels</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHelpLabels()
	 * @generated
	 * @ordered
	 */
	protected HelpLabelsType helpLabels;

	/**
	 * The default value of the '{@link #getTranslated() <em>Translated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslated()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSLATED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTranslated() <em>Translated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslated()
	 * @generated
	 * @ordered
	 */
	protected String translated = TRANSLATED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFields() <em>Fields</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFields()
	 * @generated
	 * @ordered
	 */
	protected FieldsType fields;

	/**
	 * The cached value of the '{@link #getWidgetModes() <em>Widget Modes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidgetModes()
	 * @generated
	 * @ordered
	 */
	protected WidgetModesType widgetModes;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertiesType> properties;

	/**
	 * The cached value of the '{@link #getSubWidgets() <em>Sub Widgets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubWidgets()
	 * @generated
	 * @ordered
	 */
	protected SubWidgetsType subWidgets;

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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WidgetTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayoutsPackage.Literals.WIDGET_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabelsType getLabels() {
		return labels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLabels(LabelsType newLabels, NotificationChain msgs) {
		LabelsType oldLabels = labels;
		labels = newLabels;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LayoutsPackage.WIDGET_TYPE__LABELS, oldLabels, newLabels);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabels(LabelsType newLabels) {
		if (newLabels != labels) {
			NotificationChain msgs = null;
			if (labels != null)
				msgs = ((InternalEObject)labels).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LayoutsPackage.WIDGET_TYPE__LABELS, null, msgs);
			if (newLabels != null)
				msgs = ((InternalEObject)newLabels).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LayoutsPackage.WIDGET_TYPE__LABELS, null, msgs);
			msgs = basicSetLabels(newLabels, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayoutsPackage.WIDGET_TYPE__LABELS, newLabels, newLabels));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HelpLabelsType getHelpLabels() {
		return helpLabels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHelpLabels(HelpLabelsType newHelpLabels, NotificationChain msgs) {
		HelpLabelsType oldHelpLabels = helpLabels;
		helpLabels = newHelpLabels;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LayoutsPackage.WIDGET_TYPE__HELP_LABELS, oldHelpLabels, newHelpLabels);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHelpLabels(HelpLabelsType newHelpLabels) {
		if (newHelpLabels != helpLabels) {
			NotificationChain msgs = null;
			if (helpLabels != null)
				msgs = ((InternalEObject)helpLabels).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LayoutsPackage.WIDGET_TYPE__HELP_LABELS, null, msgs);
			if (newHelpLabels != null)
				msgs = ((InternalEObject)newHelpLabels).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LayoutsPackage.WIDGET_TYPE__HELP_LABELS, null, msgs);
			msgs = basicSetHelpLabels(newHelpLabels, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayoutsPackage.WIDGET_TYPE__HELP_LABELS, newHelpLabels, newHelpLabels));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTranslated() {
		return translated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTranslated(String newTranslated) {
		String oldTranslated = translated;
		translated = newTranslated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayoutsPackage.WIDGET_TYPE__TRANSLATED, oldTranslated, translated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FieldsType getFields() {
		return fields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFields(FieldsType newFields, NotificationChain msgs) {
		FieldsType oldFields = fields;
		fields = newFields;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LayoutsPackage.WIDGET_TYPE__FIELDS, oldFields, newFields);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFields(FieldsType newFields) {
		if (newFields != fields) {
			NotificationChain msgs = null;
			if (fields != null)
				msgs = ((InternalEObject)fields).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LayoutsPackage.WIDGET_TYPE__FIELDS, null, msgs);
			if (newFields != null)
				msgs = ((InternalEObject)newFields).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LayoutsPackage.WIDGET_TYPE__FIELDS, null, msgs);
			msgs = basicSetFields(newFields, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayoutsPackage.WIDGET_TYPE__FIELDS, newFields, newFields));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WidgetModesType getWidgetModes() {
		return widgetModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWidgetModes(WidgetModesType newWidgetModes, NotificationChain msgs) {
		WidgetModesType oldWidgetModes = widgetModes;
		widgetModes = newWidgetModes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LayoutsPackage.WIDGET_TYPE__WIDGET_MODES, oldWidgetModes, newWidgetModes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidgetModes(WidgetModesType newWidgetModes) {
		if (newWidgetModes != widgetModes) {
			NotificationChain msgs = null;
			if (widgetModes != null)
				msgs = ((InternalEObject)widgetModes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LayoutsPackage.WIDGET_TYPE__WIDGET_MODES, null, msgs);
			if (newWidgetModes != null)
				msgs = ((InternalEObject)newWidgetModes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LayoutsPackage.WIDGET_TYPE__WIDGET_MODES, null, msgs);
			msgs = basicSetWidgetModes(newWidgetModes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayoutsPackage.WIDGET_TYPE__WIDGET_MODES, newWidgetModes, newWidgetModes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertiesType> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<PropertiesType>(PropertiesType.class, this, LayoutsPackage.WIDGET_TYPE__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubWidgetsType getSubWidgets() {
		return subWidgets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubWidgets(SubWidgetsType newSubWidgets, NotificationChain msgs) {
		SubWidgetsType oldSubWidgets = subWidgets;
		subWidgets = newSubWidgets;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LayoutsPackage.WIDGET_TYPE__SUB_WIDGETS, oldSubWidgets, newSubWidgets);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubWidgets(SubWidgetsType newSubWidgets) {
		if (newSubWidgets != subWidgets) {
			NotificationChain msgs = null;
			if (subWidgets != null)
				msgs = ((InternalEObject)subWidgets).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LayoutsPackage.WIDGET_TYPE__SUB_WIDGETS, null, msgs);
			if (newSubWidgets != null)
				msgs = ((InternalEObject)newSubWidgets).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LayoutsPackage.WIDGET_TYPE__SUB_WIDGETS, null, msgs);
			msgs = basicSetSubWidgets(newSubWidgets, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayoutsPackage.WIDGET_TYPE__SUB_WIDGETS, newSubWidgets, newSubWidgets));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LayoutsPackage.WIDGET_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayoutsPackage.WIDGET_TYPE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayoutsPackage.WIDGET_TYPE__LABELS:
				return basicSetLabels(null, msgs);
			case LayoutsPackage.WIDGET_TYPE__HELP_LABELS:
				return basicSetHelpLabels(null, msgs);
			case LayoutsPackage.WIDGET_TYPE__FIELDS:
				return basicSetFields(null, msgs);
			case LayoutsPackage.WIDGET_TYPE__WIDGET_MODES:
				return basicSetWidgetModes(null, msgs);
			case LayoutsPackage.WIDGET_TYPE__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case LayoutsPackage.WIDGET_TYPE__SUB_WIDGETS:
				return basicSetSubWidgets(null, msgs);
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
			case LayoutsPackage.WIDGET_TYPE__LABELS:
				return getLabels();
			case LayoutsPackage.WIDGET_TYPE__HELP_LABELS:
				return getHelpLabels();
			case LayoutsPackage.WIDGET_TYPE__TRANSLATED:
				return getTranslated();
			case LayoutsPackage.WIDGET_TYPE__FIELDS:
				return getFields();
			case LayoutsPackage.WIDGET_TYPE__WIDGET_MODES:
				return getWidgetModes();
			case LayoutsPackage.WIDGET_TYPE__PROPERTIES:
				return getProperties();
			case LayoutsPackage.WIDGET_TYPE__SUB_WIDGETS:
				return getSubWidgets();
			case LayoutsPackage.WIDGET_TYPE__NAME:
				return getName();
			case LayoutsPackage.WIDGET_TYPE__TYPE:
				return getType();
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
			case LayoutsPackage.WIDGET_TYPE__LABELS:
				setLabels((LabelsType)newValue);
				return;
			case LayoutsPackage.WIDGET_TYPE__HELP_LABELS:
				setHelpLabels((HelpLabelsType)newValue);
				return;
			case LayoutsPackage.WIDGET_TYPE__TRANSLATED:
				setTranslated((String)newValue);
				return;
			case LayoutsPackage.WIDGET_TYPE__FIELDS:
				setFields((FieldsType)newValue);
				return;
			case LayoutsPackage.WIDGET_TYPE__WIDGET_MODES:
				setWidgetModes((WidgetModesType)newValue);
				return;
			case LayoutsPackage.WIDGET_TYPE__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends PropertiesType>)newValue);
				return;
			case LayoutsPackage.WIDGET_TYPE__SUB_WIDGETS:
				setSubWidgets((SubWidgetsType)newValue);
				return;
			case LayoutsPackage.WIDGET_TYPE__NAME:
				setName((String)newValue);
				return;
			case LayoutsPackage.WIDGET_TYPE__TYPE:
				setType((String)newValue);
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
			case LayoutsPackage.WIDGET_TYPE__LABELS:
				setLabels((LabelsType)null);
				return;
			case LayoutsPackage.WIDGET_TYPE__HELP_LABELS:
				setHelpLabels((HelpLabelsType)null);
				return;
			case LayoutsPackage.WIDGET_TYPE__TRANSLATED:
				setTranslated(TRANSLATED_EDEFAULT);
				return;
			case LayoutsPackage.WIDGET_TYPE__FIELDS:
				setFields((FieldsType)null);
				return;
			case LayoutsPackage.WIDGET_TYPE__WIDGET_MODES:
				setWidgetModes((WidgetModesType)null);
				return;
			case LayoutsPackage.WIDGET_TYPE__PROPERTIES:
				getProperties().clear();
				return;
			case LayoutsPackage.WIDGET_TYPE__SUB_WIDGETS:
				setSubWidgets((SubWidgetsType)null);
				return;
			case LayoutsPackage.WIDGET_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case LayoutsPackage.WIDGET_TYPE__TYPE:
				setType(TYPE_EDEFAULT);
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
			case LayoutsPackage.WIDGET_TYPE__LABELS:
				return labels != null;
			case LayoutsPackage.WIDGET_TYPE__HELP_LABELS:
				return helpLabels != null;
			case LayoutsPackage.WIDGET_TYPE__TRANSLATED:
				return TRANSLATED_EDEFAULT == null ? translated != null : !TRANSLATED_EDEFAULT.equals(translated);
			case LayoutsPackage.WIDGET_TYPE__FIELDS:
				return fields != null;
			case LayoutsPackage.WIDGET_TYPE__WIDGET_MODES:
				return widgetModes != null;
			case LayoutsPackage.WIDGET_TYPE__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case LayoutsPackage.WIDGET_TYPE__SUB_WIDGETS:
				return subWidgets != null;
			case LayoutsPackage.WIDGET_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case LayoutsPackage.WIDGET_TYPE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
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
		result.append(" (translated: ");
		result.append(translated);
		result.append(", name: ");
		result.append(name);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //WidgetTypeImpl
