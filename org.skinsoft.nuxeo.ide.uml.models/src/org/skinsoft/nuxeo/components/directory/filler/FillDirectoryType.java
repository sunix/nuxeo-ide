/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.directory.filler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fill Directory Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.directory.filler.FillDirectoryType#getDataFile <em>Data File</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directory.filler.FillDirectoryType#getDataFormat <em>Data Format</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directory.filler.FillDirectoryType#getMode <em>Mode</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.directory.filler.FillDirectoryType#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.skinsoft.nuxeo.components.directory.filler.FillerPackage#getFillDirectoryType()
 * @model extendedMetaData="name='fillDirectoryType' kind='elementOnly'"
 * @generated
 */
public interface FillDirectoryType extends EObject {
	/**
	 * Returns the value of the '<em><b>Data File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data File</em>' attribute.
	 * @see #setDataFile(String)
	 * @see org.skinsoft.nuxeo.components.directory.filler.FillerPackage#getFillDirectoryType_DataFile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='dataFile' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDataFile();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.directory.filler.FillDirectoryType#getDataFile <em>Data File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data File</em>' attribute.
	 * @see #getDataFile()
	 * @generated
	 */
	void setDataFile(String value);

	/**
	 * Returns the value of the '<em><b>Data Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Format</em>' attribute.
	 * @see #setDataFormat(String)
	 * @see org.skinsoft.nuxeo.components.directory.filler.FillerPackage#getFillDirectoryType_DataFormat()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='dataFormat' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDataFormat();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.directory.filler.FillDirectoryType#getDataFormat <em>Data Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Format</em>' attribute.
	 * @see #getDataFormat()
	 * @generated
	 */
	void setDataFormat(String value);

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see #setMode(String)
	 * @see org.skinsoft.nuxeo.components.directory.filler.FillerPackage#getFillDirectoryType_Mode()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='mode'"
	 * @generated
	 */
	String getMode();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.directory.filler.FillDirectoryType#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see #getMode()
	 * @generated
	 */
	void setMode(String value);

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
	 * @see org.skinsoft.nuxeo.components.directory.filler.FillerPackage#getFillDirectoryType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.skinsoft.nuxeo.components.directory.filler.FillDirectoryType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // FillDirectoryType
