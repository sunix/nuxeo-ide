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
 * A representation of the model object '<em><b>Extension Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.ExtensionType#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.ExtensionType#getWorkflowDocumentSecurityPolicy <em>Workflow Document Security Policy</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.ExtensionType#getDocTypeRule <em>Doc Type Rule</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.ExtensionType#getPathRule <em>Path Rule</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.ExtensionType#getWorkflowDocumentSecurityPolicyRelation <em>Workflow Document Security Policy Relation</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.ExtensionType#getPoint <em>Point</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.ExtensionType#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#getExtensionType()
 * @model extendedMetaData="name='extensionType' kind='elementOnly'"
 * @generated
 */
public interface ExtensionType extends EObject {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.workflow.DefinitionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#getExtensionType_Definition()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='definition' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<DefinitionType> getDefinition();

	/**
	 * Returns the value of the '<em><b>Workflow Document Security Policy</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workflow Document Security Policy</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workflow Document Security Policy</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#getExtensionType_WorkflowDocumentSecurityPolicy()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='workflowDocumentSecurityPolicy' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<WorkflowDocumentSecurityPolicyType> getWorkflowDocumentSecurityPolicy();

	/**
	 * Returns the value of the '<em><b>Doc Type Rule</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.workflow.DocTypeRuleType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Doc Type Rule</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Doc Type Rule</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#getExtensionType_DocTypeRule()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='docTypeRule' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<DocTypeRuleType> getDocTypeRule();

	/**
	 * Returns the value of the '<em><b>Path Rule</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.workflow.PathRuleType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Rule</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Rule</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#getExtensionType_PathRule()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='pathRule' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<PathRuleType> getPathRule();

	/**
	 * Returns the value of the '<em><b>Workflow Document Security Policy Relation</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyRelationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workflow Document Security Policy Relation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workflow Document Security Policy Relation</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#getExtensionType_WorkflowDocumentSecurityPolicyRelation()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='workflowDocumentSecurityPolicyRelation' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<WorkflowDocumentSecurityPolicyRelationType> getWorkflowDocumentSecurityPolicyRelation();

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
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#getExtensionType_Point()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='point'"
	 * @generated
	 */
	String getPoint();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.workflow.ExtensionType#getPoint <em>Point</em>}' attribute.
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
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#getExtensionType_Target()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='target'"
	 * @generated
	 */
	String getTarget();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.workflow.ExtensionType#getTarget <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' attribute.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(String value);

} // ExtensionType
