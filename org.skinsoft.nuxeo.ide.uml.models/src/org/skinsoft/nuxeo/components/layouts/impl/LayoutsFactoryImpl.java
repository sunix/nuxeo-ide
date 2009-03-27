/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.layouts.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.skinsoft.nuxeo.components.layouts.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LayoutsFactoryImpl extends EFactoryImpl implements LayoutsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LayoutsFactory init() {
		try {
			LayoutsFactory theLayoutsFactory = (LayoutsFactory)EPackage.Registry.INSTANCE.getEFactory("http://skinsoft.org/nuxeo/components/layouts"); 
			if (theLayoutsFactory != null) {
				return theLayoutsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LayoutsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case LayoutsPackage.COMPONENT_TYPE: return createComponentType();
			case LayoutsPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case LayoutsPackage.EXTENSION_TYPE: return createExtensionType();
			case LayoutsPackage.FIELDS_TYPE: return createFieldsType();
			case LayoutsPackage.FIELD_TYPE: return createFieldType();
			case LayoutsPackage.HELP_LABELS_TYPE: return createHelpLabelsType();
			case LayoutsPackage.LABELS_TYPE: return createLabelsType();
			case LayoutsPackage.LABEL_TYPE: return createLabelType();
			case LayoutsPackage.LAYOUT_TYPE: return createLayoutType();
			case LayoutsPackage.MODE_TYPE: return createModeType();
			case LayoutsPackage.PROPERTIES_TYPE: return createPropertiesType();
			case LayoutsPackage.PROPERTY_TYPE: return createPropertyType();
			case LayoutsPackage.ROWS_TYPE: return createRowsType();
			case LayoutsPackage.ROW_TYPE: return createRowType();
			case LayoutsPackage.SUB_WIDGETS_TYPE: return createSubWidgetsType();
			case LayoutsPackage.TEMPLATES_TYPE: return createTemplatesType();
			case LayoutsPackage.TEMPLATE_TYPE: return createTemplateType();
			case LayoutsPackage.WIDGET_MODES_TYPE: return createWidgetModesType();
			case LayoutsPackage.WIDGET_TYPE: return createWidgetType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentType createComponentType() {
		ComponentTypeImpl componentType = new ComponentTypeImpl();
		return componentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionType createExtensionType() {
		ExtensionTypeImpl extensionType = new ExtensionTypeImpl();
		return extensionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FieldsType createFieldsType() {
		FieldsTypeImpl fieldsType = new FieldsTypeImpl();
		return fieldsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FieldType createFieldType() {
		FieldTypeImpl fieldType = new FieldTypeImpl();
		return fieldType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HelpLabelsType createHelpLabelsType() {
		HelpLabelsTypeImpl helpLabelsType = new HelpLabelsTypeImpl();
		return helpLabelsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabelsType createLabelsType() {
		LabelsTypeImpl labelsType = new LabelsTypeImpl();
		return labelsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabelType createLabelType() {
		LabelTypeImpl labelType = new LabelTypeImpl();
		return labelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutType createLayoutType() {
		LayoutTypeImpl layoutType = new LayoutTypeImpl();
		return layoutType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModeType createModeType() {
		ModeTypeImpl modeType = new ModeTypeImpl();
		return modeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertiesType createPropertiesType() {
		PropertiesTypeImpl propertiesType = new PropertiesTypeImpl();
		return propertiesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyType createPropertyType() {
		PropertyTypeImpl propertyType = new PropertyTypeImpl();
		return propertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RowsType createRowsType() {
		RowsTypeImpl rowsType = new RowsTypeImpl();
		return rowsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RowType createRowType() {
		RowTypeImpl rowType = new RowTypeImpl();
		return rowType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubWidgetsType createSubWidgetsType() {
		SubWidgetsTypeImpl subWidgetsType = new SubWidgetsTypeImpl();
		return subWidgetsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplatesType createTemplatesType() {
		TemplatesTypeImpl templatesType = new TemplatesTypeImpl();
		return templatesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateType createTemplateType() {
		TemplateTypeImpl templateType = new TemplateTypeImpl();
		return templateType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WidgetModesType createWidgetModesType() {
		WidgetModesTypeImpl widgetModesType = new WidgetModesTypeImpl();
		return widgetModesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WidgetType createWidgetType() {
		WidgetTypeImpl widgetType = new WidgetTypeImpl();
		return widgetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutsPackage getLayoutsPackage() {
		return (LayoutsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LayoutsPackage getPackage() {
		return LayoutsPackage.eINSTANCE;
	}

} //LayoutsFactoryImpl
