/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.workflow;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Definition Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.DefinitionType#getEngineName <em>Engine Name</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.DefinitionType#getMimetype <em>Mimetype</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.DefinitionType#getDefinitionPath <em>Definition Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#getDefinitionType()
 * @model extendedMetaData="name='definitionType' kind='elementOnly'"
 * @generated
 */
public interface DefinitionType extends EObject {
	/**
	 * Returns the value of the '<em><b>Engine Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engine Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Engine Name</em>' attribute.
	 * @see #setEngineName(String)
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#getDefinitionType_EngineName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='engineName' namespace='##targetNamespace'"
	 * @generated
	 */
	String getEngineName();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.workflow.DefinitionType#getEngineName <em>Engine Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Engine Name</em>' attribute.
	 * @see #getEngineName()
	 * @generated
	 */
	void setEngineName(String value);

	/**
	 * Returns the value of the '<em><b>Mimetype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mimetype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mimetype</em>' attribute.
	 * @see #setMimetype(String)
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#getDefinitionType_Mimetype()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='mimetype' namespace='##targetNamespace'"
	 * @generated
	 */
	String getMimetype();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.workflow.DefinitionType#getMimetype <em>Mimetype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mimetype</em>' attribute.
	 * @see #getMimetype()
	 * @generated
	 */
	void setMimetype(String value);

	/**
	 * Returns the value of the '<em><b>Definition Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition Path</em>' attribute.
	 * @see #setDefinitionPath(String)
	 * @see org.skinsoft.nuxeo.components.workflow.WorkflowPackage#getDefinitionType_DefinitionPath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='definitionPath' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDefinitionPath();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.workflow.DefinitionType#getDefinitionPath <em>Definition Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition Path</em>' attribute.
	 * @see #getDefinitionPath()
	 * @generated
	 */
	void setDefinitionPath(String value);

} // DefinitionType
