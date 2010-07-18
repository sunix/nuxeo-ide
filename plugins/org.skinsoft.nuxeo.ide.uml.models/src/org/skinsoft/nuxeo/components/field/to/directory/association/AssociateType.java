/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.field.to.directory.association;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Associate Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.field.to.directory.association.AssociateType#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.field.to.directory.association.AssociateType#getType <em>Type</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.field.to.directory.association.AssociateType#getToDirectory <em>To Directory</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.field.to.directory.association.AssociateType#getXpath <em>Xpath</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.field.to.directory.association.AssociationPackage#getAssociateType()
 * @model extendedMetaData="name='associateType' kind='mixed'"
 * @generated
 */
public interface AssociateType extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see org.skinsoft.nuxeo.components.field.to.directory.association.AssociationPackage#getAssociateType_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

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
	 * @see org.skinsoft.nuxeo.components.field.to.directory.association.AssociationPackage#getAssociateType_Type()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='type' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<String> getType();

	/**
	 * Returns the value of the '<em><b>To Directory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Directory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Directory</em>' attribute.
	 * @see #setToDirectory(String)
	 * @see org.skinsoft.nuxeo.components.field.to.directory.association.AssociationPackage#getAssociateType_ToDirectory()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='toDirectory'"
	 * @generated
	 */
	String getToDirectory();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.field.to.directory.association.AssociateType#getToDirectory <em>To Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Directory</em>' attribute.
	 * @see #getToDirectory()
	 * @generated
	 */
	void setToDirectory(String value);

	/**
	 * Returns the value of the '<em><b>Xpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xpath</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xpath</em>' attribute.
	 * @see #setXpath(String)
	 * @see org.skinsoft.nuxeo.components.field.to.directory.association.AssociationPackage#getAssociateType_Xpath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='xpath'"
	 * @generated
	 */
	String getXpath();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.field.to.directory.association.AssociateType#getXpath <em>Xpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xpath</em>' attribute.
	 * @see #getXpath()
	 * @generated
	 */
	void setXpath(String value);

} // AssociateType
