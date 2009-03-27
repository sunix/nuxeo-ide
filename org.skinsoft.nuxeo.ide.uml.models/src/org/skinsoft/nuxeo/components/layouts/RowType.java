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
 * A representation of the model object '<em><b>Row Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.RowType#getWidget <em>Widget</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getRowType()
 * @model extendedMetaData="name='rowType' kind='elementOnly'"
 * @generated
 */
public interface RowType extends EObject {
	/**
	 * Returns the value of the '<em><b>Widget</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widget</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widget</em>' attribute list.
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getRowType_Widget()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='widget'"
	 * @generated
	 */
	EList<String> getWidget();

} // RowType
