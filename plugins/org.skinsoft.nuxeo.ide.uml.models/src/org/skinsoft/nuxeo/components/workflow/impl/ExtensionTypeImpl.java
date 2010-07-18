/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.workflow.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.skinsoft.nuxeo.components.workflow.DefinitionType;
import org.skinsoft.nuxeo.components.workflow.DocTypeRuleType;
import org.skinsoft.nuxeo.components.workflow.ExtensionType;
import org.skinsoft.nuxeo.components.workflow.PathRuleType;
import org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyRelationType;
import org.skinsoft.nuxeo.components.workflow.WorkflowDocumentSecurityPolicyType;
import org.skinsoft.nuxeo.components.workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.impl.ExtensionTypeImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.impl.ExtensionTypeImpl#getWorkflowDocumentSecurityPolicy <em>Workflow Document Security Policy</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.impl.ExtensionTypeImpl#getDocTypeRule <em>Doc Type Rule</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.impl.ExtensionTypeImpl#getPathRule <em>Path Rule</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.impl.ExtensionTypeImpl#getWorkflowDocumentSecurityPolicyRelation <em>Workflow Document Security Policy Relation</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.impl.ExtensionTypeImpl#getPoint <em>Point</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.impl.ExtensionTypeImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionTypeImpl extends EObjectImpl implements ExtensionType {
	/**
	 * The cached value of the '{@link #getDefinition() <em>Definition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected EList<DefinitionType> definition;

	/**
	 * The cached value of the '{@link #getWorkflowDocumentSecurityPolicy() <em>Workflow Document Security Policy</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkflowDocumentSecurityPolicy()
	 * @generated
	 * @ordered
	 */
	protected EList<WorkflowDocumentSecurityPolicyType> workflowDocumentSecurityPolicy;

	/**
	 * The cached value of the '{@link #getDocTypeRule() <em>Doc Type Rule</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocTypeRule()
	 * @generated
	 * @ordered
	 */
	protected EList<DocTypeRuleType> docTypeRule;

	/**
	 * The cached value of the '{@link #getPathRule() <em>Path Rule</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathRule()
	 * @generated
	 * @ordered
	 */
	protected EList<PathRuleType> pathRule;

	/**
	 * The cached value of the '{@link #getWorkflowDocumentSecurityPolicyRelation() <em>Workflow Document Security Policy Relation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkflowDocumentSecurityPolicyRelation()
	 * @generated
	 * @ordered
	 */
	protected EList<WorkflowDocumentSecurityPolicyRelationType> workflowDocumentSecurityPolicyRelation;

	/**
	 * The default value of the '{@link #getPoint() <em>Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoint()
	 * @generated
	 * @ordered
	 */
	protected static final String POINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPoint() <em>Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoint()
	 * @generated
	 * @ordered
	 */
	protected String point = POINT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected String target = TARGET_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.EXTENSION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DefinitionType> getDefinition() {
		if (definition == null) {
			definition = new EObjectContainmentEList<DefinitionType>(DefinitionType.class, this, WorkflowPackage.EXTENSION_TYPE__DEFINITION);
		}
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WorkflowDocumentSecurityPolicyType> getWorkflowDocumentSecurityPolicy() {
		if (workflowDocumentSecurityPolicy == null) {
			workflowDocumentSecurityPolicy = new EObjectContainmentEList<WorkflowDocumentSecurityPolicyType>(WorkflowDocumentSecurityPolicyType.class, this, WorkflowPackage.EXTENSION_TYPE__WORKFLOW_DOCUMENT_SECURITY_POLICY);
		}
		return workflowDocumentSecurityPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DocTypeRuleType> getDocTypeRule() {
		if (docTypeRule == null) {
			docTypeRule = new EObjectContainmentEList<DocTypeRuleType>(DocTypeRuleType.class, this, WorkflowPackage.EXTENSION_TYPE__DOC_TYPE_RULE);
		}
		return docTypeRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PathRuleType> getPathRule() {
		if (pathRule == null) {
			pathRule = new EObjectContainmentEList<PathRuleType>(PathRuleType.class, this, WorkflowPackage.EXTENSION_TYPE__PATH_RULE);
		}
		return pathRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WorkflowDocumentSecurityPolicyRelationType> getWorkflowDocumentSecurityPolicyRelation() {
		if (workflowDocumentSecurityPolicyRelation == null) {
			workflowDocumentSecurityPolicyRelation = new EObjectContainmentEList<WorkflowDocumentSecurityPolicyRelationType>(WorkflowDocumentSecurityPolicyRelationType.class, this, WorkflowPackage.EXTENSION_TYPE__WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION);
		}
		return workflowDocumentSecurityPolicyRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPoint() {
		return point;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPoint(String newPoint) {
		String oldPoint = point;
		point = newPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.EXTENSION_TYPE__POINT, oldPoint, point));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(String newTarget) {
		String oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.EXTENSION_TYPE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowPackage.EXTENSION_TYPE__DEFINITION:
				return ((InternalEList<?>)getDefinition()).basicRemove(otherEnd, msgs);
			case WorkflowPackage.EXTENSION_TYPE__WORKFLOW_DOCUMENT_SECURITY_POLICY:
				return ((InternalEList<?>)getWorkflowDocumentSecurityPolicy()).basicRemove(otherEnd, msgs);
			case WorkflowPackage.EXTENSION_TYPE__DOC_TYPE_RULE:
				return ((InternalEList<?>)getDocTypeRule()).basicRemove(otherEnd, msgs);
			case WorkflowPackage.EXTENSION_TYPE__PATH_RULE:
				return ((InternalEList<?>)getPathRule()).basicRemove(otherEnd, msgs);
			case WorkflowPackage.EXTENSION_TYPE__WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION:
				return ((InternalEList<?>)getWorkflowDocumentSecurityPolicyRelation()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowPackage.EXTENSION_TYPE__DEFINITION:
				return getDefinition();
			case WorkflowPackage.EXTENSION_TYPE__WORKFLOW_DOCUMENT_SECURITY_POLICY:
				return getWorkflowDocumentSecurityPolicy();
			case WorkflowPackage.EXTENSION_TYPE__DOC_TYPE_RULE:
				return getDocTypeRule();
			case WorkflowPackage.EXTENSION_TYPE__PATH_RULE:
				return getPathRule();
			case WorkflowPackage.EXTENSION_TYPE__WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION:
				return getWorkflowDocumentSecurityPolicyRelation();
			case WorkflowPackage.EXTENSION_TYPE__POINT:
				return getPoint();
			case WorkflowPackage.EXTENSION_TYPE__TARGET:
				return getTarget();
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
			case WorkflowPackage.EXTENSION_TYPE__DEFINITION:
				getDefinition().clear();
				getDefinition().addAll((Collection<? extends DefinitionType>)newValue);
				return;
			case WorkflowPackage.EXTENSION_TYPE__WORKFLOW_DOCUMENT_SECURITY_POLICY:
				getWorkflowDocumentSecurityPolicy().clear();
				getWorkflowDocumentSecurityPolicy().addAll((Collection<? extends WorkflowDocumentSecurityPolicyType>)newValue);
				return;
			case WorkflowPackage.EXTENSION_TYPE__DOC_TYPE_RULE:
				getDocTypeRule().clear();
				getDocTypeRule().addAll((Collection<? extends DocTypeRuleType>)newValue);
				return;
			case WorkflowPackage.EXTENSION_TYPE__PATH_RULE:
				getPathRule().clear();
				getPathRule().addAll((Collection<? extends PathRuleType>)newValue);
				return;
			case WorkflowPackage.EXTENSION_TYPE__WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION:
				getWorkflowDocumentSecurityPolicyRelation().clear();
				getWorkflowDocumentSecurityPolicyRelation().addAll((Collection<? extends WorkflowDocumentSecurityPolicyRelationType>)newValue);
				return;
			case WorkflowPackage.EXTENSION_TYPE__POINT:
				setPoint((String)newValue);
				return;
			case WorkflowPackage.EXTENSION_TYPE__TARGET:
				setTarget((String)newValue);
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
			case WorkflowPackage.EXTENSION_TYPE__DEFINITION:
				getDefinition().clear();
				return;
			case WorkflowPackage.EXTENSION_TYPE__WORKFLOW_DOCUMENT_SECURITY_POLICY:
				getWorkflowDocumentSecurityPolicy().clear();
				return;
			case WorkflowPackage.EXTENSION_TYPE__DOC_TYPE_RULE:
				getDocTypeRule().clear();
				return;
			case WorkflowPackage.EXTENSION_TYPE__PATH_RULE:
				getPathRule().clear();
				return;
			case WorkflowPackage.EXTENSION_TYPE__WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION:
				getWorkflowDocumentSecurityPolicyRelation().clear();
				return;
			case WorkflowPackage.EXTENSION_TYPE__POINT:
				setPoint(POINT_EDEFAULT);
				return;
			case WorkflowPackage.EXTENSION_TYPE__TARGET:
				setTarget(TARGET_EDEFAULT);
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
			case WorkflowPackage.EXTENSION_TYPE__DEFINITION:
				return definition != null && !definition.isEmpty();
			case WorkflowPackage.EXTENSION_TYPE__WORKFLOW_DOCUMENT_SECURITY_POLICY:
				return workflowDocumentSecurityPolicy != null && !workflowDocumentSecurityPolicy.isEmpty();
			case WorkflowPackage.EXTENSION_TYPE__DOC_TYPE_RULE:
				return docTypeRule != null && !docTypeRule.isEmpty();
			case WorkflowPackage.EXTENSION_TYPE__PATH_RULE:
				return pathRule != null && !pathRule.isEmpty();
			case WorkflowPackage.EXTENSION_TYPE__WORKFLOW_DOCUMENT_SECURITY_POLICY_RELATION:
				return workflowDocumentSecurityPolicyRelation != null && !workflowDocumentSecurityPolicyRelation.isEmpty();
			case WorkflowPackage.EXTENSION_TYPE__POINT:
				return POINT_EDEFAULT == null ? point != null : !POINT_EDEFAULT.equals(point);
			case WorkflowPackage.EXTENSION_TYPE__TARGET:
				return TARGET_EDEFAULT == null ? target != null : !TARGET_EDEFAULT.equals(target);
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
		result.append(" (point: ");
		result.append(point);
		result.append(", target: ");
		result.append(target);
		result.append(')');
		return result.toString();
	}

} //ExtensionTypeImpl
