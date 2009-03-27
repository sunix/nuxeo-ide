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
 * A representation of the model object '<em><b>Extension Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.lifecycle.ExtensionType#getLifecycle <em>Lifecycle</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.lifecycle.ExtensionType#getTypes <em>Types</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.lifecycle.ExtensionType#getPoint <em>Point</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.lifecycle.ExtensionType#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.lifecycle.LifecyclePackage#getExtensionType()
 * @model extendedMetaData="name='extensionType' kind='elementOnly'"
 * @generated
 */
public interface ExtensionType extends EObject {
	/**
	 * Returns the value of the '<em><b>Lifecycle</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.lifecycle.LifecycleType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lifecycle</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lifecycle</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.lifecycle.LifecyclePackage#getExtensionType_Lifecycle()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='lifecycle' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<LifecycleType> getLifecycle();

	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' containment reference.
	 * @see #setTypes(TypesType)
	 * @see org.skinsoft.nuxeo.components.lifecycle.LifecyclePackage#getExtensionType_Types()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='types' namespace='##targetNamespace'"
	 * @generated
	 */
	TypesType getTypes();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.lifecycle.ExtensionType#getTypes <em>Types</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Types</em>' containment reference.
	 * @see #getTypes()
	 * @generated
	 */
	void setTypes(TypesType value);

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
	 * @see org.skinsoft.nuxeo.components.lifecycle.LifecyclePackage#getExtensionType_Point()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='point'"
	 * @generated
	 */
	String getPoint();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.lifecycle.ExtensionType#getPoint <em>Point</em>}' attribute.
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
	 * @see org.skinsoft.nuxeo.components.lifecycle.LifecyclePackage#getExtensionType_Target()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='target'"
	 * @generated
	 */
	String getTarget();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.lifecycle.ExtensionType#getTarget <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' attribute.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(String value);

} // ExtensionType
