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
 * A representation of the model object '<em><b>Rows Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.RowsType#getRow <em>Row</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getRowsType()
 * @model extendedMetaData="name='rowsType' kind='elementOnly'"
 * @generated
 */
public interface RowsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Row</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.layouts.RowType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Row</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Row</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getRowsType_Row()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='row'"
	 * @generated
	 */
	EList<RowType> getRow();

} // RowsType
