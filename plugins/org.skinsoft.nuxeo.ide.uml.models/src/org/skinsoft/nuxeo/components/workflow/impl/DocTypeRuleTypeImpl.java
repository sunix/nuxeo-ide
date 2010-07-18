/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.workflow.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.skinsoft.nuxeo.components.workflow.DocTypeRuleType;
import org.skinsoft.nuxeo.components.workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Doc Type Rule Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.impl.DocTypeRuleTypeImpl#getWorkflowDefinition <em>Workflow Definition</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.impl.DocTypeRuleTypeImpl#getDocType <em>Doc Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocTypeRuleTypeImpl extends EObjectImpl implements DocTypeRuleType {
	/**
	 * The cached value of the '{@link #getWorkflowDefinition() <em>Workflow Definition</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkflowDefinition()
	 * @generated
	 * @ordered
	 */
	protected EList<String> workflowDefinition;

	/**
	 * The default value of the '{@link #getDocType() <em>Doc Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocType()
	 * @generated
	 * @ordered
	 */
	protected static final String DOC_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDocType() <em>Doc Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocType()
	 * @generated
	 * @ordered
	 */
	protected String docType = DOC_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocTypeRuleTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.DOC_TYPE_RULE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getWorkflowDefinition() {
		if (workflowDefinition == null) {
			workflowDefinition = new EDataTypeEList<String>(String.class, this, WorkflowPackage.DOC_TYPE_RULE_TYPE__WORKFLOW_DEFINITION);
		}
		return workflowDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDocType() {
		return docType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocType(String newDocType) {
		String oldDocType = docType;
		docType = newDocType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.DOC_TYPE_RULE_TYPE__DOC_TYPE, oldDocType, docType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowPackage.DOC_TYPE_RULE_TYPE__WORKFLOW_DEFINITION:
				return getWorkflowDefinition();
			case WorkflowPackage.DOC_TYPE_RULE_TYPE__DOC_TYPE:
				return getDocType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WorkflowPackage.DOC_TYPE_RULE_TYPE__WORKFLOW_DEFINITION:
				getWorkflowDefinition().clear();
				getWorkflowDefinition().addAll((Collection<? extends String>)newValue);
				return;
			case WorkflowPackage.DOC_TYPE_RULE_TYPE__DOC_TYPE:
				setDocType((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case WorkflowPackage.DOC_TYPE_RULE_TYPE__WORKFLOW_DEFINITION:
				getWorkflowDefinition().clear();
				return;
			case WorkflowPackage.DOC_TYPE_RULE_TYPE__DOC_TYPE:
				setDocType(DOC_TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WorkflowPackage.DOC_TYPE_RULE_TYPE__WORKFLOW_DEFINITION:
				return workflowDefinition != null && !workflowDefinition.isEmpty();
			case WorkflowPackage.DOC_TYPE_RULE_TYPE__DOC_TYPE:
				return DOC_TYPE_EDEFAULT == null ? docType != null : !DOC_TYPE_EDEFAULT.equals(docType);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (workflowDefinition: ");
		result.append(workflowDefinition);
		result.append(", docType: ");
		result.append(docType);
		result.append(')');
		return result.toString();
	}

} //DocTypeRuleTypeImpl
