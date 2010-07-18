/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.directory.filler;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.directory.filler.ExtensionType#getFillDirectory <em>Fill Directory</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directory.filler.ExtensionType#getPoint <em>Point</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directory.filler.ExtensionType#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.directory.filler.FillerPackage#getExtensionType()
 * @model extendedMetaData="name='extensionType' kind='elementOnly'"
 * @generated
 */
public interface ExtensionType extends EObject {
	/**
	 * Returns the value of the '<em><b>Fill Directory</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.directory.filler.FillDirectoryType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fill Directory</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fill Directory</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.directory.filler.FillerPackage#getExtensionType_FillDirectory()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='fillDirectory' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<FillDirectoryType> getFillDirectory();

	/**
	 * Returns the value of the '<em><b>Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Point</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Point</em>' attribute.
	 * @see #setPoint(String)
	 * @see org.skinsoft.nuxeo.components.directory.filler.FillerPackage#getExtensionType_Point()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='point'"
	 * @generated
	 */
	String getPoint();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.directory.filler.ExtensionType#getPoint <em>Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Point</em>' attribute.
	 * @see #getPoint()
	 * @generated
	 */
	void setPoint(String value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' attribute.
	 * @see #setTarget(String)
	 * @see org.skinsoft.nuxeo.components.directory.filler.FillerPackage#getExtensionType_Target()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='target'"
	 * @generated
	 */
	String getTarget();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.directory.filler.ExtensionType#getTarget <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' attribute.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(String value);

} // ExtensionType
