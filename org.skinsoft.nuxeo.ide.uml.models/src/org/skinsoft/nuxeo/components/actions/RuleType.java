/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.actions;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.RuleType#getGroup <em>Group</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.RuleType#getType <em>Type</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.RuleType#getPermission <em>Permission</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.RuleType#getSchema <em>Schema</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.RuleType#getFacet <em>Facet</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.RuleType#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.actions.RuleType#getGrant <em>Grant</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.actions.ActionsPackage#getRuleType()
 * @model extendedMetaData="name='ruleType' kind='elementOnly'"
 * @generated
 */
public interface RuleType extends EObject {
	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute list.
	 * @see org.skinsoft.nuxeo.components.actions.ActionsPackage#getRuleType_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

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
	 * @see org.skinsoft.nuxeo.components.actions.ActionsPackage#getRuleType_Type()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='type' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<String> getType();

	/**
	 * Returns the value of the '<em><b>Permission</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Permission</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Permission</em>' attribute list.
	 * @see org.skinsoft.nuxeo.components.actions.ActionsPackage#getRuleType_Permission()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='permission' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<String> getPermission();

	/**
	 * Returns the value of the '<em><b>Schema</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema</em>' attribute list.
	 * @see org.skinsoft.nuxeo.components.actions.ActionsPackage#getRuleType_Schema()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='schema' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<String> getSchema();

	/**
	 * Returns the value of the '<em><b>Facet</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facet</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facet</em>' attribute list.
	 * @see org.skinsoft.nuxeo.components.actions.ActionsPackage#getRuleType_Facet()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='facet' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<String> getFacet();

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute list.
	 * @see org.skinsoft.nuxeo.components.actions.ActionsPackage#getRuleType_Condition()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='condition' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<String> getCondition();

	/**
	 * Returns the value of the '<em><b>Grant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grant</em>' attribute.
	 * @see #setGrant(String)
	 * @see org.skinsoft.nuxeo.components.actions.ActionsPackage#getRuleType_Grant()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='grant'"
	 * @generated
	 */
	String getGrant();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.actions.RuleType#getGrant <em>Grant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grant</em>' attribute.
	 * @see #getGrant()
	 * @generated
	 */
	void setGrant(String value);

} // RuleType
