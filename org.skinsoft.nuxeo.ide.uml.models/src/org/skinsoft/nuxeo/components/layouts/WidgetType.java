/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.layouts;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Widget Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getLabels <em>Labels</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getHelpLabels <em>Help Labels</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getTranslated <em>Translated</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getFields <em>Fields</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getWidgetModes <em>Widget Modes</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getSubWidgets <em>Sub Widgets</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getName <em>Name</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getWidgetType()
 * @model extendedMetaData="name='widgetType' kind='elementOnly'"
 * @generated
 */
public interface WidgetType extends EObject {
	/**
	 * Returns the value of the '<em><b>Labels</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Labels</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Labels</em>' containment reference.
	 * @see #setLabels(LabelsType)
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getWidgetType_Labels()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='labels'"
	 * @generated
	 */
	LabelsType getLabels();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getLabels <em>Labels</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Labels</em>' containment reference.
	 * @see #getLabels()
	 * @generated
	 */
	void setLabels(LabelsType value);

	/**
	 * Returns the value of the '<em><b>Help Labels</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Help Labels</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Help Labels</em>' containment reference.
	 * @see #setHelpLabels(HelpLabelsType)
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getWidgetType_HelpLabels()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='helpLabels'"
	 * @generated
	 */
	HelpLabelsType getHelpLabels();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getHelpLabels <em>Help Labels</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Help Labels</em>' containment reference.
	 * @see #getHelpLabels()
	 * @generated
	 */
	void setHelpLabels(HelpLabelsType value);

	/**
	 * Returns the value of the '<em><b>Translated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Translated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Translated</em>' attribute.
	 * @see #setTranslated(String)
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getWidgetType_Translated()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='translated'"
	 * @generated
	 */
	String getTranslated();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getTranslated <em>Translated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Translated</em>' attribute.
	 * @see #getTranslated()
	 * @generated
	 */
	void setTranslated(String value);

	/**
	 * Returns the value of the '<em><b>Fields</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fields</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fields</em>' containment reference.
	 * @see #setFields(FieldsType)
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getWidgetType_Fields()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='fields'"
	 * @generated
	 */
	FieldsType getFields();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getFields <em>Fields</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fields</em>' containment reference.
	 * @see #getFields()
	 * @generated
	 */
	void setFields(FieldsType value);

	/**
	 * Returns the value of the '<em><b>Widget Modes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widget Modes</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widget Modes</em>' containment reference.
	 * @see #setWidgetModes(WidgetModesType)
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getWidgetType_WidgetModes()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='widgetModes'"
	 * @generated
	 */
	WidgetModesType getWidgetModes();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getWidgetModes <em>Widget Modes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Widget Modes</em>' containment reference.
	 * @see #getWidgetModes()
	 * @generated
	 */
	void setWidgetModes(WidgetModesType value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.layouts.PropertiesType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getWidgetType_Properties()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='properties'"
	 * @generated
	 */
	EList<PropertiesType> getProperties();

	/**
	 * Returns the value of the '<em><b>Sub Widgets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Widgets</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Widgets</em>' containment reference.
	 * @see #setSubWidgets(SubWidgetsType)
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getWidgetType_SubWidgets()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='subWidgets'"
	 * @generated
	 */
	SubWidgetsType getSubWidgets();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getSubWidgets <em>Sub Widgets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Widgets</em>' containment reference.
	 * @see #getSubWidgets()
	 * @generated
	 */
	void setSubWidgets(SubWidgetsType value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getWidgetType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getWidgetType_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='type'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // WidgetType
