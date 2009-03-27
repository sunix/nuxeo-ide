/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.jbpm.service;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Security Policy Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.jbpm.service.SecurityPolicyType#getValue <em>Value</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.jbpm.service.SecurityPolicyType#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.jbpm.service.SecurityPolicyType#getFor <em>For</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.jbpm.service.ServicePackage#getSecurityPolicyType()
 * @model extendedMetaData="name='securityPolicyType' kind='simple'"
 * @generated
 */
public interface SecurityPolicyType extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ServicePackage#getSecurityPolicyType_Value()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="name=':0' kind='simple'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.jbpm.service.SecurityPolicyType#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' attribute.
	 * @see #setClass(String)
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ServicePackage#getSecurityPolicyType_Class()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='class'"
	 * @generated
	 */
	String getClass_();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.jbpm.service.SecurityPolicyType#getClass_ <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' attribute.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(String value);

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
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ServicePackage#getSecurityPolicyType_For()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='for'"
	 * @generated
	 */
	String getFor();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.jbpm.service.SecurityPolicyType#getFor <em>For</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>For</em>' attribute.
	 * @see #getFor()
	 * @generated
	 */
	void setFor(String value);

} // SecurityPolicyType
