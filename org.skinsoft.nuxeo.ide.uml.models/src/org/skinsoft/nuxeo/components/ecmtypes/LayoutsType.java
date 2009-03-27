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
 * A representation of the model object '<em><b>Layouts Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.ecmtypes.LayoutsType#getLayout <em>Layout</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.ecmtypes.LayoutsType#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.ecmtypes.EcmtypesPackage#getLayoutsType()
 * @model extendedMetaData="name='layoutsType' kind='elementOnly'"
 * @generated
 */
public interface LayoutsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Layout</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout</em>' attribute list.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.EcmtypesPackage#getLayoutsType_Layout()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='layout'"
	 * @generated
	 */
	EList<String> getLayout();

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
	 * @see org.skinsoft.nuxeo.components.ecmtypes.EcmtypesPackage#getLayoutsType_Mode()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='mode'"
	 * @generated
	 */
	String getMode();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.ecmtypes.LayoutsType#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see #getMode()
	 * @generated
	 */
	void setMode(String value);

} // LayoutsType
