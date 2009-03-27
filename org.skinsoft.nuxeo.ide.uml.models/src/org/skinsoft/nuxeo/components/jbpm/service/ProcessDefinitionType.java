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
 * A representation of the model object '<em><b>Process Definition Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.jbpm.service.ProcessDefinitionType#getValue <em>Value</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.jbpm.service.ProcessDefinitionType#getDeployer <em>Deployer</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.jbpm.service.ProcessDefinitionType#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.jbpm.service.ServicePackage#getProcessDefinitionType()
 * @model extendedMetaData="name='processDefinitionType' kind='simple'"
 * @generated
 */
public interface ProcessDefinitionType extends EObject {
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
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ServicePackage#getProcessDefinitionType_Value()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="name=':0' kind='simple'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.jbpm.service.ProcessDefinitionType#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Deployer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deployer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deployer</em>' attribute.
	 * @see #setDeployer(String)
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ServicePackage#getProcessDefinitionType_Deployer()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='deployer'"
	 * @generated
	 */
	String getDeployer();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.jbpm.service.ProcessDefinitionType#getDeployer <em>Deployer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deployer</em>' attribute.
	 * @see #getDeployer()
	 * @generated
	 */
	void setDeployer(String value);

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
	 * @see org.skinsoft.nuxeo.components.jbpm.service.ServicePackage#getProcessDefinitionType_Path()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='path'"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.jbpm.service.ProcessDefinitionType#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

} // ProcessDefinitionType
