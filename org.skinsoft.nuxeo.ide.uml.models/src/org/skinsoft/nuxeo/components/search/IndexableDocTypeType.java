/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.search;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Indexable Doc Type Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.search.IndexableDocTypeType#getValue <em>Value</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.search.IndexableDocTypeType#getIndexAllSchemas <em>Index All Schemas</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.search.IndexableDocTypeType#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.search.SearchPackage#getIndexableDocTypeType()
 * @model extendedMetaData="name='indexableDocTypeType' kind='simple'"
 * @generated
 */
public interface IndexableDocTypeType extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.skinsoft.nuxeo.components.search.SearchPackage#getIndexableDocTypeType_Value()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="name=':0' kind='simple'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.search.IndexableDocTypeType#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Index All Schemas</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index All Schemas</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index All Schemas</em>' attribute.
	 * @see #setIndexAllSchemas(String)
	 * @see org.skinsoft.nuxeo.components.search.SearchPackage#getIndexableDocTypeType_IndexAllSchemas()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='indexAllSchemas'"
	 * @generated
	 */
	String getIndexAllSchemas();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.search.IndexableDocTypeType#getIndexAllSchemas <em>Index All Schemas</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index All Schemas</em>' attribute.
	 * @see #getIndexAllSchemas()
	 * @generated
	 */
	void setIndexAllSchemas(String value);

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
	 * @see org.skinsoft.nuxeo.components.search.SearchPackage#getIndexableDocTypeType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.search.IndexableDocTypeType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // IndexableDocTypeType
