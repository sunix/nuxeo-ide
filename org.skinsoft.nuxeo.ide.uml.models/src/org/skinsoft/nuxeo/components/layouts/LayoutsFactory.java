/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.layouts;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage
 * @generated
 */
public interface LayoutsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LayoutsFactory eINSTANCE = org.skinsoft.nuxeo.components.layouts.impl.LayoutsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Type</em>'.
	 * @generated
	 */
	ComponentType createComponentType();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>Extension Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension Type</em>'.
	 * @generated
	 */
	ExtensionType createExtensionType();

	/**
	 * Returns a new object of class '<em>Fields Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fields Type</em>'.
	 * @generated
	 */
	FieldsType createFieldsType();

	/**
	 * Returns a new object of class '<em>Field Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Field Type</em>'.
	 * @generated
	 */
	FieldType createFieldType();

	/**
	 * Returns a new object of class '<em>Help Labels Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Help Labels Type</em>'.
	 * @generated
	 */
	HelpLabelsType createHelpLabelsType();

	/**
	 * Returns a new object of class '<em>Labels Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Labels Type</em>'.
	 * @generated
	 */
	LabelsType createLabelsType();

	/**
	 * Returns a new object of class '<em>Label Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Label Type</em>'.
	 * @generated
	 */
	LabelType createLabelType();

	/**
	 * Returns a new object of class '<em>Layout Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layout Type</em>'.
	 * @generated
	 */
	LayoutType createLayoutType();

	/**
	 * Returns a new object of class '<em>Mode Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mode Type</em>'.
	 * @generated
	 */
	ModeType createModeType();

	/**
	 * Returns a new object of class '<em>Properties Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Properties Type</em>'.
	 * @generated
	 */
	PropertiesType createPropertiesType();

	/**
	 * Returns a new object of class '<em>Property Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Type</em>'.
	 * @generated
	 */
	PropertyType createPropertyType();

	/**
	 * Returns a new object of class '<em>Rows Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rows Type</em>'.
	 * @generated
	 */
	RowsType createRowsType();

	/**
	 * Returns a new object of class '<em>Row Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Row Type</em>'.
	 * @generated
	 */
	RowType createRowType();

	/**
	 * Returns a new object of class '<em>Sub Widgets Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Widgets Type</em>'.
	 * @generated
	 */
	SubWidgetsType createSubWidgetsType();

	/**
	 * Returns a new object of class '<em>Templates Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Templates Type</em>'.
	 * @generated
	 */
	TemplatesType createTemplatesType();

	/**
	 * Returns a new object of class '<em>Template Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Type</em>'.
	 * @generated
	 */
	TemplateType createTemplateType();

	/**
	 * Returns a new object of class '<em>Widget Modes Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Widget Modes Type</em>'.
	 * @generated
	 */
	WidgetModesType createWidgetModesType();

	/**
	 * Returns a new object of class '<em>Widget Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Widget Type</em>'.
	 * @generated
	 */
	WidgetType createWidgetType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LayoutsPackage getLayoutsPackage();

} //LayoutsFactory
