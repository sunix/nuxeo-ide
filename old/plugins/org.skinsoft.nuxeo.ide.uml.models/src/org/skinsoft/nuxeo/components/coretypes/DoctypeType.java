/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.coretypes;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Doctype Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.coretypes.DoctypeType#getSchema <em>Schema</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.coretypes.DoctypeType#getFacet <em>Facet</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.coretypes.DoctypeType#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.coretypes.DoctypeType#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.coretypes.CoretypesPackage#getDoctypeType()
 * @model extendedMetaData="name='doctypeType' kind='elementOnly'"
 * @generated
 */
public interface DoctypeType extends EObject {
	/**
	 * Returns the value of the '<em><b>Schema</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.coretypes.SchemaType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.coretypes.CoretypesPackage#getDoctypeType_Schema()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='schema'"
	 * @generated
	 */
	EList<SchemaType> getSchema();

	/**
	 * Returns the value of the '<em><b>Facet</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.coretypes.FacetType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facet</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facet</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.coretypes.CoretypesPackage#getDoctypeType_Facet()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='facet'"
	 * @generated
	 */
	EList<FacetType> getFacet();

	/**
	 * Returns the value of the '<em><b>Extends</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' attribute.
	 * @see #setExtends(String)
	 * @see org.skinsoft.nuxeo.components.coretypes.CoretypesPackage#getDoctypeType_Extends()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='extends'"
	 * @generated
	 */
	String getExtends();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.coretypes.DoctypeType#getExtends <em>Extends</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends</em>' attribute.
	 * @see #getExtends()
	 * @generated
	 */
	void setExtends(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.skinsoft.nuxeo.components.coretypes.CoretypesPackage#getDoctypeType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.coretypes.DoctypeType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // DoctypeType
