/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.actions;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Filter Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.FilterType#getRule <em>Rule</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.FilterType#getAppend <em>Append</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.FilterType#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.actions.ActionsPackage#getFilterType()
 * @model extendedMetaData="name='filterType' kind='elementOnly'"
 * @generated
 */
public interface FilterType extends EObject {
	/**
	 * Returns the value of the '<em><b>Rule</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.actions.RuleType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.actions.ActionsPackage#getFilterType_Rule()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='rule' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<RuleType> getRule();

	/**
	 * Returns the value of the '<em><b>Append</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Append</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Append</em>' attribute.
	 * @see #setAppend(String)
	 * @see org.skinsoft.nuxeo.components.actions.ActionsPackage#getFilterType_Append()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='append'"
	 * @generated
	 */
	String getAppend();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.actions.FilterType#getAppend <em>Append</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Append</em>' attribute.
	 * @see #getAppend()
	 * @generated
	 */
	void setAppend(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.skinsoft.nuxeo.components.actions.ActionsPackage#getFilterType_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.actions.FilterType#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // FilterType
