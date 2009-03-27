/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.lifecycle;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.lifecycle.LifecycleType#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.lifecycle.LifecycleType#getStates <em>States</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.lifecycle.LifecycleType#getInitial <em>Initial</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.lifecycle.LifecycleType#getLifecyclemanager <em>Lifecyclemanager</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.lifecycle.LifecycleType#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.lifecycle.LifecyclePackage#getLifecycleType()
 * @model extendedMetaData="name='lifecycleType' kind='elementOnly'"
 * @generated
 */
public interface LifecycleType extends EObject {
	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference.
	 * @see #setTransitions(TransitionsType)
	 * @see org.skinsoft.nuxeo.components.lifecycle.LifecyclePackage#getLifecycleType_Transitions()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='transitions' namespace='##targetNamespace'"
	 * @generated
	 */
	TransitionsType getTransitions();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.lifecycle.LifecycleType#getTransitions <em>Transitions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transitions</em>' containment reference.
	 * @see #getTransitions()
	 * @generated
	 */
	void setTransitions(TransitionsType value);

	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference.
	 * @see #setStates(StatesType)
	 * @see org.skinsoft.nuxeo.components.lifecycle.LifecyclePackage#getLifecycleType_States()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='states' namespace='##targetNamespace'"
	 * @generated
	 */
	StatesType getStates();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.lifecycle.LifecycleType#getStates <em>States</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>States</em>' containment reference.
	 * @see #getStates()
	 * @generated
	 */
	void setStates(StatesType value);

	/**
	 * Returns the value of the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial</em>' attribute.
	 * @see #setInitial(String)
	 * @see org.skinsoft.nuxeo.components.lifecycle.LifecyclePackage#getLifecycleType_Initial()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='initial'"
	 * @generated
	 */
	String getInitial();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.lifecycle.LifecycleType#getInitial <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial</em>' attribute.
	 * @see #getInitial()
	 * @generated
	 */
	void setInitial(String value);

	/**
	 * Returns the value of the '<em><b>Lifecyclemanager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lifecyclemanager</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lifecyclemanager</em>' attribute.
	 * @see #setLifecyclemanager(String)
	 * @see org.skinsoft.nuxeo.components.lifecycle.LifecyclePackage#getLifecycleType_Lifecyclemanager()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='lifecyclemanager'"
	 * @generated
	 */
	String getLifecyclemanager();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.lifecycle.LifecycleType#getLifecyclemanager <em>Lifecyclemanager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lifecyclemanager</em>' attribute.
	 * @see #getLifecyclemanager()
	 * @generated
	 */
	void setLifecyclemanager(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.skinsoft.nuxeo.components.lifecycle.LifecyclePackage#getLifecycleType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.lifecycle.LifecycleType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // LifecycleType
