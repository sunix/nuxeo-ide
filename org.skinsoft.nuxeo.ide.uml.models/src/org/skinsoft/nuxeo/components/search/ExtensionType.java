/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.search;

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
 *   <li>{@link org.skinsoft.nuxeo.components.search.ExtensionType#getIndexableDocType <em>Indexable Doc Type</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.search.ExtensionType#getPoint <em>Point</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.search.ExtensionType#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.search.SearchPackage#getExtensionType()
 * @model extendedMetaData="name='extensionType' kind='elementOnly'"
 * @generated
 */
public interface ExtensionType extends EObject {
	/**
	 * Returns the value of the '<em><b>Indexable Doc Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.search.IndexableDocTypeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indexable Doc Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indexable Doc Type</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.search.SearchPackage#getExtensionType_IndexableDocType()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='indexableDocType' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<IndexableDocTypeType> getIndexableDocType();

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
	 * @see org.skinsoft.nuxeo.components.search.SearchPackage#getExtensionType_Point()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='point'"
	 * @generated
	 */
	String getPoint();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.search.ExtensionType#getPoint <em>Point</em>}' attribute.
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
	 * @see org.skinsoft.nuxeo.components.search.SearchPackage#getExtensionType_Target()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='target'"
	 * @generated
	 */
	String getTarget();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.search.ExtensionType#getTarget <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' attribute.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(String value);

} // ExtensionType
