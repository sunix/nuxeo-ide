/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.lifecycle;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Transitions Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.lifecycle.StateTransitionsType#getTransition <em>Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.lifecycle.LifecyclePackage#getStateTransitionsType()
 * @model extendedMetaData="name='stateTransitionsType' kind='elementOnly'"
 * @generated
 */
public interface StateTransitionsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Transition</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transition</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition</em>' attribute list.
	 * @see org.skinsoft.nuxeo.components.lifecycle.LifecyclePackage#getStateTransitionsType_Transition()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='transition' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<String> getTransition();

} // StateTransitionsType
