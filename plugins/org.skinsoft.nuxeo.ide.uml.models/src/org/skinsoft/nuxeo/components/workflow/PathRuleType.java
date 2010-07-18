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
 * A representation of the model object '<em><b>Path Rule Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.PathRuleType#getWorkflowDefinition <em>Workflow Definition</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.PathRuleType#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#getPathRuleType()
 * @model extendedMetaData="name='pathRuleType' kind='elementOnly'"
 * @generated
 */
public interface PathRuleType extends EObject {
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
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#getPathRuleType_WorkflowDefinition()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='workflowDefinition' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<String> getWorkflowDefinition();

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#getPathRuleType_Path()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='path'"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.workflow.PathRuleType#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

} // PathRuleType
