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
 * A representation of the model object '<em><b>Transitions Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.lifecycle.TransitionsType#getTransition <em>Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.lifecycle.LifecyclePackage#getTransitionsType()
 * @model extendedMetaData="name='transitionsType' kind='elementOnly'"
 * @generated
 */
public interface TransitionsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Transition</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.lifecycle.TransitionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.lifecycle.LifecyclePackage#getTransitionsType_Transition()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='transition' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TransitionType> getTransition();

} // TransitionsType
