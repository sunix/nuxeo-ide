/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.layouts;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Properties Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.PropertiesType#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.PropertiesType#getProperty <em>Property</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.PropertiesType#getMode <em>Mode</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.PropertiesType#getWidgetMode <em>Widget Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getPropertiesType()
 * @model extendedMetaData="name='propertiesType' kind='mixed'"
 * @generated
 */
public interface PropertiesType extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getPropertiesType_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>Property</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.layouts.PropertyType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * property applying in view mode
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Property</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getPropertiesType_Property()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='property'"
	 * @generated
	 */
	EList<PropertyType> getProperty();

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see #setMode(String)
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getPropertiesType_Mode()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='mode'"
	 * @generated
	 */
	String getMode();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.layouts.PropertiesType#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see #getMode()
	 * @generated
	 */
	void setMode(String value);

	/**
	 * Returns the value of the '<em><b>Widget Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widget Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widget Mode</em>' attribute.
	 * @see #setWidgetMode(String)
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getPropertiesType_WidgetMode()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='widgetMode'"
	 * @generated
	 */
	String getWidgetMode();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.layouts.PropertiesType#getWidgetMode <em>Widget Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Widget Mode</em>' attribute.
	 * @see #getWidgetMode()
	 * @generated
	 */
	void setWidgetMode(String value);

} // PropertiesType
