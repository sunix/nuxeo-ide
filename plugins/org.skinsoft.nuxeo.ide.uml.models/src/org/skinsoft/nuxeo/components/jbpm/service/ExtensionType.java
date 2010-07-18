/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.jbpm.service;

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
 *   <li>{@link org.skinsoft.nuxeo.components.jbpm.service.ExtensionType#getProcessDefinition <em>Process Definition</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.jbpm.service.ExtensionType#getSecurityPolicy <em>Security Policy</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.jbpm.service.ExtensionType#getType <em>Type</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.jbpm.service.ExtensionType#getPoint <em>Point</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.jbpm.service.ExtensionType#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.jbpm.service.ServicePackage#getExtensionType()
 * @model extendedMetaData="name='extensionType' kind='elementOnly'"
 * @generated
 */
public interface ExtensionType extends EObject {
	/**
	 * Returns the value of the '<em><b>Process Definition</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.jbpm.service.ProcessDefinitionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Definition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Definition</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ServicePackage#getExtensionType_ProcessDefinition()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='processDefinition' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ProcessDefinitionType> getProcessDefinition();

	/**
	 * Returns the value of the '<em><b>Security Policy</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.jbpm.service.SecurityPolicyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Security Policy</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Security Policy</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ServicePackage#getExtensionType_SecurityPolicy()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='securityPolicy' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<SecurityPolicyType> getSecurityPolicy();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.jbpm.service.TypeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ServicePackage#getExtensionType_Type()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='type' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TypeType> getType();

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
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ServicePackage#getExtensionType_Point()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='point'"
	 * @generated
	 */
	String getPoint();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.jbpm.service.ExtensionType#getPoint <em>Point</em>}' attribute.
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
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ServicePackage#getExtensionType_Target()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='target'"
	 * @generated
	 */
	String getTarget();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.jbpm.service.ExtensionType#getTarget <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' attribute.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(String value);

} // ExtensionType
