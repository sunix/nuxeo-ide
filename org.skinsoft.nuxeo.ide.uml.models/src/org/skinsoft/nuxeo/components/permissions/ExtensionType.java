/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.permissions;

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
 *   <li>{@link org.skinsoft.nuxeo.components.permissions.ExtensionType#getPermission <em>Permission</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.permissions.ExtensionType#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.permissions.ExtensionType#getPoint <em>Point</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.permissions.ExtensionType#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.permissions.PermissionsPackage#getExtensionType()
 * @model extendedMetaData="name='extensionType' kind='elementOnly'"
 * @generated
 */
public interface ExtensionType extends EObject {
	/**
	 * Returns the value of the '<em><b>Permission</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.permissions.PermissionType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * BBB deprecated old name  use ReadVersion instead once alias works  special permission given to administrators: god-level access  deprecated - was used only for a single customer
	 *       project before pluggable permission definitions
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Permission</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.permissions.PermissionsPackage#getExtensionType_Permission()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='permission' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<PermissionType> getPermission();

	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.permissions.VisibilityType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.permissions.PermissionsPackage#getExtensionType_Visibility()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='visibility' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<VisibilityType> getVisibility();

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
	 * @see org.skinsoft.nuxeo.components.permissions.PermissionsPackage#getExtensionType_Point()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='point'"
	 * @generated
	 */
	String getPoint();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.permissions.ExtensionType#getPoint <em>Point</em>}' attribute.
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
	 * @see org.skinsoft.nuxeo.components.permissions.PermissionsPackage#getExtensionType_Target()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='target'"
	 * @generated
	 */
	String getTarget();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.permissions.ExtensionType#getTarget <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' attribute.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(String value);

} // ExtensionType
