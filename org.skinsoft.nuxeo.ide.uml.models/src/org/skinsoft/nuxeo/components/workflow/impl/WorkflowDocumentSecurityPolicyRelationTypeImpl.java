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

import org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyRelationType;
import org.skinsoft.nuxeo.components.workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Security Policy Relation Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.impl.WorkflowDocumentSecurityPolicyRelationTypeImpl#getWorkflowName <em>Workflow Name</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.impl.WorkflowDocumentSecurityPolicyRelationTypeImpl#getFor <em>For</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkflowDocumentSecurityPolicyRelationTypeImpl extends EObjectImpl implements WorkflowDocumentSecurityPolicyRelationType {
	/**
	 * The cached value of the '{@link #getWorkflowName() <em>Workflow Name</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkflowName()
	 * @generated
	 * @ordered
	 */
	protected EList<String> workflowName;

	/**
	 * The default value of the '{@link #getFor() <em>For</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFor()
	 * @generated
	 * @ordered
	 */
	protected static final String FOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFor() <em>For</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFor()
	 * @generated
	 * @ordered
	 */
	protected String for_ = FOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkflowDocumentSecurityPolicyRelationTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getWorkflowName() {
		if (workflowName == null) {
			workflowName = new EDataTypeEList<String>(String.class, this, WorkflowPackage.WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE__WORKFLOW_NAME);
		}
		return workflowName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFor() {
		return for_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFor(String newFor) {
		String oldFor = for_;
		for_ = newFor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE__FOR, oldFor, for_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowPackage.WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE__WORKFLOW_NAME:
				return getWorkflowName();
			case WorkflowPackage.WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE__FOR:
				return getFor();
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
			case WorkflowPackage.WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE__WORKFLOW_NAME:
				getWorkflowName().clear();
				getWorkflowName().addAll((Collection<? extends String>)newValue);
				return;
			case WorkflowPackage.WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE__FOR:
				setFor((String)newValue);
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
			case WorkflowPackage.WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE__WORKFLOW_NAME:
				getWorkflowName().clear();
				return;
			case WorkflowPackage.WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE__FOR:
				setFor(FOR_EDEFAULT);
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
			case WorkflowPackage.WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE__WORKFLOW_NAME:
				return workflowName != null && !workflowName.isEmpty();
			case WorkflowPackage.WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION_TYPE__FOR:
				return FOR_EDEFAULT == null ? for_ != null : !FOR_EDEFAULT.equals(for_);
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
		result.append(" (workflowName: ");
		result.append(workflowName);
		result.append(", for: ");
		result.append(for_);
		result.append(')');
		return result.toString();
	}

} //WorkflowDocumentSecurityPolicyRelationTypeImpl
