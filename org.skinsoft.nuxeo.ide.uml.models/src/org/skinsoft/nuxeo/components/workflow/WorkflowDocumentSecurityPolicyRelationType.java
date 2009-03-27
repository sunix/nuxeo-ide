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
 * A representation of the model object '<em><b>Document Security Policy Relation Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyRelationType#getWorkflowName <em>Workflow Name</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyRelationType#getFor <em>For</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#getWorkflowDocumentSecurityPolicyRelationType()
 * @model extendedMetaData="name='workflowDocumentSecurityPolicyRelationType' kind='elementOnly'"
 * @generated
 */
public interface WorkflowDocumentSecurityPolicyRelationType extends EObject {
	/**
	 * Returns the value of the '<em><b>Workflow Name</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workflow Name</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workflow Name</em>' attribute list.
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#getWorkflowDocumentSecurityPolicyRelationType_WorkflowName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='workflowName' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<String> getWorkflowName();

	/**
	 * Returns the value of the '<em><b>For</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>For</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>For</em>' attribute.
	 * @see #setFor(String)
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#getWorkflowDocumentSecurityPolicyRelationType_For()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='for'"
	 * @generated
	 */
	String getFor();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyRelationType#getFor <em>For</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>For</em>' attribute.
	 * @see #getFor()
	 * @generated
	 */
	void setFor(String value);

} // WorkflowDocumentSecurityPolicyRelationType
