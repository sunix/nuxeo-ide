/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.ecmtypes;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subtypes Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.ecmtypes.SubtypesType#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.ecmtypes.EcmtypesPackage#getSubtypesType()
 * @model extendedMetaData="name='subtypesType' kind='elementOnly'"
 * @generated
 */
public interface SubtypesType extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute list.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.EcmtypesPackage#getSubtypesType_Type()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='type'"
	 * @generated
	 */
	EList<String> getType();

} // SubtypesType
