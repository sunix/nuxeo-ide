/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.ecmtypes;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.ecmtypes.TypeType#getLabel <em>Label</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.ecmtypes.TypeType#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.ecmtypes.TypeType#getDefaultView <em>Default View</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.ecmtypes.TypeType#getLayouts <em>Layouts</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.ecmtypes.TypeType#getSubtypes <em>Subtypes</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.ecmtypes.TypeType#getCoretype <em>Coretype</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.ecmtypes.TypeType#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.ecmtypes.EcmtypesPackage#getTypeType()
 * @model extendedMetaData="name='typeType' kind='elementOnly'"
 * @generated
 */
public interface TypeType extends EObject {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.skinsoft.nuxeo.components.ecmtypes.EcmtypesPackage#getTypeType_Label()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='label'"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.ecmtypes.TypeType#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' attribute.
	 * @see #setIcon(String)
	 * @see org.skinsoft.nuxeo.components.ecmtypes.EcmtypesPackage#getTypeType_Icon()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='icon'"
	 * @generated
	 */
	String getIcon();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.ecmtypes.TypeType#getIcon <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon</em>' attribute.
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(String value);

	/**
	 * Returns the value of the '<em><b>Default View</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default View</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default View</em>' attribute.
	 * @see #setDefaultView(String)
	 * @see org.skinsoft.nuxeo.components.ecmtypes.EcmtypesPackage#getTypeType_DefaultView()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='default-view'"
	 * @generated
	 */
	String getDefaultView();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.ecmtypes.TypeType#getDefaultView <em>Default View</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default View</em>' attribute.
	 * @see #getDefaultView()
	 * @generated
	 */
	void setDefaultView(String value);

	/**
	 * Returns the value of the '<em><b>Layouts</b></em>' containment reference list.
	 * The list contents are of type {@link org.skinsoft.nuxeo.components.ecmtypes.LayoutsType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layouts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layouts</em>' containment reference list.
	 * @see org.skinsoft.nuxeo.components.ecmtypes.EcmtypesPackage#getTypeType_Layouts()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='layouts'"
	 * @generated
	 */
	EList<LayoutsType> getLayouts();

	/**
	 * Returns the value of the '<em><b>Subtypes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subtypes</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subtypes</em>' containment reference.
	 * @see #setSubtypes(SubtypesType)
	 * @see org.skinsoft.nuxeo.components.ecmtypes.EcmtypesPackage#getTypeType_Subtypes()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='subtypes'"
	 * @generated
	 */
	SubtypesType getSubtypes();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.ecmtypes.TypeType#getSubtypes <em>Subtypes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subtypes</em>' containment reference.
	 * @see #getSubtypes()
	 * @generated
	 */
	void setSubtypes(SubtypesType value);

	/**
	 * Returns the value of the '<em><b>Coretype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coretype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coretype</em>' attribute.
	 * @see #setCoretype(String)
	 * @see org.skinsoft.nuxeo.components.ecmtypes.EcmtypesPackage#getTypeType_Coretype()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='coretype'"
	 * @generated
	 */
	String getCoretype();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.ecmtypes.TypeType#getCoretype <em>Coretype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coretype</em>' attribute.
	 * @see #getCoretype()
	 * @generated
	 */
	void setCoretype(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.skinsoft.nuxeo.components.ecmtypes.EcmtypesPackage#getTypeType_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.ecmtypes.TypeType#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // TypeType
