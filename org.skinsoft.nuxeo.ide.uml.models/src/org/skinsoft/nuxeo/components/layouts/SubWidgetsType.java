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
 * A representation of the model object '<em><b>Sub Widgets Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.SubWidgetsType#getWidget <em>Widget</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getSubWidgetsType()
 * @model extendedMetaData="name='subWidgetsType' kind='elementOnly'"
 * @generated
 */
public interface SubWidgetsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Widget</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.layouts.WidgetType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widget</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widget</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getSubWidgetsType_Widget()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='widget'"
	 * @generated
	 */
	EList<WidgetType> getWidget();

} // SubWidgetsType
