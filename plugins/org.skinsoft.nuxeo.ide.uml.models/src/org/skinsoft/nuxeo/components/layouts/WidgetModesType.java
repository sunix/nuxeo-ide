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
 * A representation of the model object '<em><b>Widget Modes Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.WidgetModesType#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getWidgetModesType()
 * @model extendedMetaData="name='widgetModesType' kind='elementOnly'"
 * @generated
 */
public interface WidgetModesType extends EObject {
	/**
	 * Returns the value of the '<em><b>Mode</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.layouts.ModeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getWidgetModesType_Mode()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='mode'"
	 * @generated
	 */
	EList<ModeType> getMode();

} // WidgetModesType
