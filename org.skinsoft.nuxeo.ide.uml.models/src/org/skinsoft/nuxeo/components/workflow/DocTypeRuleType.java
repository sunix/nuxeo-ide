/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.workflow;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Doc Type Rule Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.DocTypeRuleType#getWorkflowDefinition <em>Workflow Definition</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.DocTypeRuleType#getDocType <em>Doc Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#getDocTypeRuleType()
 * @model extendedMetaData="name='docTypeRuleType' kind='elementOnly'"
 * @generated
 */
public interface DocTypeRuleType extends EObject {
	/**
	 * Returns the value of the '<em><b>Workflow Definition</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workflow Definition</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workflow Definition</em>' attribute list.
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#getDocTypeRuleType_WorkflowDefinition()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='workflowDefinition' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<String> getWorkflowDefinition();

	/**
	 * Returns the value of the '<em><b>Doc Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Doc Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Doc Type</em>' attribute.
	 * @see #setDocType(String)
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#getDocTypeRuleType_DocType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='docType'"
	 * @generated
	 */
	String getDocType();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.workflow.DocTypeRuleType#getDocType <em>Doc Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Doc Type</em>' attribute.
	 * @see #getDocType()
	 * @generated
	 */
	void setDocType(String value);

} // DocTypeRuleType
