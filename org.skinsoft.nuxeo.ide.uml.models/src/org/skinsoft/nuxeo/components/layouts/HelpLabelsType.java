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
 * A representation of the model object '<em><b>Help Labels Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.layouts.HelpLabelsType#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getHelpLabelsType()
 * @model extendedMetaData="name='helpLabelsType' kind='elementOnly'"
 * @generated
 */
public interface HelpLabelsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.layouts.LabelType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage#getHelpLabelsType_Label()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='label'"
	 * @generated
	 */
	EList<LabelType> getLabel();

} // HelpLabelsType
