/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.layouts;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.skinsoft.nuxeo.components.layouts.LayoutsFactory
 * @model kind="package"
 * @generated
 */
public interface LayoutsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "layouts";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://skinsoft.org/nuxeo/components/layouts";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "layouts";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LayoutsPackage eINSTANCE = org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.layouts.impl.ComponentTypeImpl <em>Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.layouts.impl.ComponentTypeImpl
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getComponentType()
	 * @generated
	 */
	int COMPONENT_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__EXTENSION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.layouts.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.layouts.impl.DocumentRootImpl
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 1;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__COMPONENT = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.layouts.impl.ExtensionTypeImpl <em>Extension Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.layouts.impl.ExtensionTypeImpl
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getExtensionType()
	 * @generated
	 */
	int EXTENSION_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__LAYOUT = 0;

	/**
	 * The feature id for the '<em><b>Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__POINT = 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__TARGET = 2;

	/**
	 * The number of structural features of the '<em>Extension Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.layouts.impl.FieldsTypeImpl <em>Fields Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.layouts.impl.FieldsTypeImpl
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getFieldsType()
	 * @generated
	 */
	int FIELDS_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Field</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDS_TYPE__FIELD = 0;

	/**
	 * The number of structural features of the '<em>Fields Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDS_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.layouts.impl.FieldTypeImpl <em>Field Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.layouts.impl.FieldTypeImpl
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getFieldType()
	 * @generated
	 */
	int FIELD_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Schema</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_TYPE__SCHEMA = 1;

	/**
	 * The number of structural features of the '<em>Field Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.layouts.impl.HelpLabelsTypeImpl <em>Help Labels Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.layouts.impl.HelpLabelsTypeImpl
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getHelpLabelsType()
	 * @generated
	 */
	int HELP_LABELS_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELP_LABELS_TYPE__LABEL = 0;

	/**
	 * The number of structural features of the '<em>Help Labels Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELP_LABELS_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.layouts.impl.LabelsTypeImpl <em>Labels Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LabelsTypeImpl
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getLabelsType()
	 * @generated
	 */
	int LABELS_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELS_TYPE__LABEL = 0;

	/**
	 * The number of structural features of the '<em>Labels Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELS_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.layouts.impl.LabelTypeImpl <em>Label Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LabelTypeImpl
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getLabelType()
	 * @generated
	 */
	int LABEL_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_TYPE__MODE = 1;

	/**
	 * The number of structural features of the '<em>Label Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.layouts.impl.LayoutTypeImpl <em>Layout Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutTypeImpl
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getLayoutType()
	 * @generated
	 */
	int LAYOUT_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Templates</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__TEMPLATES = 1;

	/**
	 * The feature id for the '<em><b>Rows</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__ROWS = 2;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__WIDGET = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE__NAME = 4;

	/**
	 * The number of structural features of the '<em>Layout Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_TYPE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.layouts.impl.ModeTypeImpl <em>Mode Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.layouts.impl.ModeTypeImpl
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getModeType()
	 * @generated
	 */
	int MODE_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Value1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_TYPE__VALUE1 = 1;

	/**
	 * The number of structural features of the '<em>Mode Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.layouts.impl.PropertiesTypeImpl <em>Properties Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.layouts.impl.PropertiesTypeImpl
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getPropertiesType()
	 * @generated
	 */
	int PROPERTIES_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_TYPE__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_TYPE__PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_TYPE__MODE = 2;

	/**
	 * The feature id for the '<em><b>Widget Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_TYPE__WIDGET_MODE = 3;

	/**
	 * The number of structural features of the '<em>Properties Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.layouts.impl.PropertyTypeImpl <em>Property Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.layouts.impl.PropertyTypeImpl
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getPropertyType()
	 * @generated
	 */
	int PROPERTY_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Property Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.layouts.impl.RowsTypeImpl <em>Rows Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.layouts.impl.RowsTypeImpl
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getRowsType()
	 * @generated
	 */
	int ROWS_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Row</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROWS_TYPE__ROW = 0;

	/**
	 * The number of structural features of the '<em>Rows Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROWS_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.layouts.impl.RowTypeImpl <em>Row Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.layouts.impl.RowTypeImpl
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getRowType()
	 * @generated
	 */
	int ROW_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_TYPE__WIDGET = 0;

	/**
	 * The number of structural features of the '<em>Row Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.layouts.impl.SubWidgetsTypeImpl <em>Sub Widgets Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.layouts.impl.SubWidgetsTypeImpl
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getSubWidgetsType()
	 * @generated
	 */
	int SUB_WIDGETS_TYPE = 14;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_WIDGETS_TYPE__WIDGET = 0;

	/**
	 * The number of structural features of the '<em>Sub Widgets Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_WIDGETS_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.layouts.impl.TemplatesTypeImpl <em>Templates Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.layouts.impl.TemplatesTypeImpl
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getTemplatesType()
	 * @generated
	 */
	int TEMPLATES_TYPE = 15;

	/**
	 * The feature id for the '<em><b>Template</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATES_TYPE__TEMPLATE = 0;

	/**
	 * The number of structural features of the '<em>Templates Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATES_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.layouts.impl.TemplateTypeImpl <em>Template Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.layouts.impl.TemplateTypeImpl
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getTemplateType()
	 * @generated
	 */
	int TEMPLATE_TYPE = 16;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE__MODE = 1;

	/**
	 * The number of structural features of the '<em>Template Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.layouts.impl.WidgetModesTypeImpl <em>Widget Modes Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.layouts.impl.WidgetModesTypeImpl
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getWidgetModesType()
	 * @generated
	 */
	int WIDGET_MODES_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_MODES_TYPE__MODE = 0;

	/**
	 * The number of structural features of the '<em>Widget Modes Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_MODES_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.skinsoft.nuxeo.components.layouts.impl.WidgetTypeImpl <em>Widget Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.skinsoft.nuxeo.components.layouts.impl.WidgetTypeImpl
	 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getWidgetType()
	 * @generated
	 */
	int WIDGET_TYPE = 18;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_TYPE__LABELS = 0;

	/**
	 * The feature id for the '<em><b>Help Labels</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_TYPE__HELP_LABELS = 1;

	/**
	 * The feature id for the '<em><b>Translated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_TYPE__TRANSLATED = 2;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_TYPE__FIELDS = 3;

	/**
	 * The feature id for the '<em><b>Widget Modes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_TYPE__WIDGET_MODES = 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_TYPE__PROPERTIES = 5;

	/**
	 * The feature id for the '<em><b>Sub Widgets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_TYPE__SUB_WIDGETS = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_TYPE__NAME = 7;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_TYPE__TYPE = 8;

	/**
	 * The number of structural features of the '<em>Widget Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_TYPE_FEATURE_COUNT = 9;


	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.layouts.ComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Type</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.ComponentType
	 * @generated
	 */
	EClass getComponentType();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.layouts.ComponentType#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extension</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.ComponentType#getExtension()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_Extension();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.layouts.ComponentType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.ComponentType#getName()
	 * @see #getComponentType()
	 * @generated
	 */
	EAttribute getComponentType_Name();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.layouts.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.layouts.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.skinsoft.nuxeo.components.layouts.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.skinsoft.nuxeo.components.layouts.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.layouts.DocumentRoot#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.DocumentRoot#getComponent()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Component();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.layouts.ExtensionType <em>Extension Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Type</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.ExtensionType
	 * @generated
	 */
	EClass getExtensionType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.layouts.ExtensionType#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Layout</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.ExtensionType#getLayout()
	 * @see #getExtensionType()
	 * @generated
	 */
	EReference getExtensionType_Layout();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.layouts.ExtensionType#getPoint <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Point</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.ExtensionType#getPoint()
	 * @see #getExtensionType()
	 * @generated
	 */
	EAttribute getExtensionType_Point();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.layouts.ExtensionType#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.ExtensionType#getTarget()
	 * @see #getExtensionType()
	 * @generated
	 */
	EAttribute getExtensionType_Target();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.layouts.FieldsType <em>Fields Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fields Type</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.FieldsType
	 * @generated
	 */
	EClass getFieldsType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.layouts.FieldsType#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Field</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.FieldsType#getField()
	 * @see #getFieldsType()
	 * @generated
	 */
	EReference getFieldsType_Field();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.layouts.FieldType <em>Field Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field Type</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.FieldType
	 * @generated
	 */
	EClass getFieldType();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.layouts.FieldType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.FieldType#getValue()
	 * @see #getFieldType()
	 * @generated
	 */
	EAttribute getFieldType_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.layouts.FieldType#getSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Schema</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.FieldType#getSchema()
	 * @see #getFieldType()
	 * @generated
	 */
	EAttribute getFieldType_Schema();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.layouts.HelpLabelsType <em>Help Labels Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Help Labels Type</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.HelpLabelsType
	 * @generated
	 */
	EClass getHelpLabelsType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.layouts.HelpLabelsType#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Label</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.HelpLabelsType#getLabel()
	 * @see #getHelpLabelsType()
	 * @generated
	 */
	EReference getHelpLabelsType_Label();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.layouts.LabelsType <em>Labels Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Labels Type</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.LabelsType
	 * @generated
	 */
	EClass getLabelsType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.layouts.LabelsType#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Label</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.LabelsType#getLabel()
	 * @see #getLabelsType()
	 * @generated
	 */
	EReference getLabelsType_Label();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.layouts.LabelType <em>Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label Type</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.LabelType
	 * @generated
	 */
	EClass getLabelType();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.layouts.LabelType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.LabelType#getValue()
	 * @see #getLabelType()
	 * @generated
	 */
	EAttribute getLabelType_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.layouts.LabelType#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.LabelType#getMode()
	 * @see #getLabelType()
	 * @generated
	 */
	EAttribute getLabelType_Mode();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.layouts.LayoutType <em>Layout Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layout Type</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutType
	 * @generated
	 */
	EClass getLayoutType();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.layouts.LayoutType#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutType#getMixed()
	 * @see #getLayoutType()
	 * @generated
	 */
	EAttribute getLayoutType_Mixed();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.layouts.LayoutType#getTemplates <em>Templates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Templates</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutType#getTemplates()
	 * @see #getLayoutType()
	 * @generated
	 */
	EReference getLayoutType_Templates();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.layouts.LayoutType#getRows <em>Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rows</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutType#getRows()
	 * @see #getLayoutType()
	 * @generated
	 */
	EReference getLayoutType_Rows();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.layouts.LayoutType#getWidget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Widget</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutType#getWidget()
	 * @see #getLayoutType()
	 * @generated
	 */
	EReference getLayoutType_Widget();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.layouts.LayoutType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutType#getName()
	 * @see #getLayoutType()
	 * @generated
	 */
	EAttribute getLayoutType_Name();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.layouts.ModeType <em>Mode Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mode Type</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.ModeType
	 * @generated
	 */
	EClass getModeType();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.layouts.ModeType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.ModeType#getValue()
	 * @see #getModeType()
	 * @generated
	 */
	EAttribute getModeType_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.layouts.ModeType#getValue1 <em>Value1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value1</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.ModeType#getValue1()
	 * @see #getModeType()
	 * @generated
	 */
	EAttribute getModeType_Value1();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.layouts.PropertiesType <em>Properties Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Properties Type</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.PropertiesType
	 * @generated
	 */
	EClass getPropertiesType();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.layouts.PropertiesType#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.PropertiesType#getMixed()
	 * @see #getPropertiesType()
	 * @generated
	 */
	EAttribute getPropertiesType_Mixed();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.layouts.PropertiesType#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.PropertiesType#getProperty()
	 * @see #getPropertiesType()
	 * @generated
	 */
	EReference getPropertiesType_Property();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.layouts.PropertiesType#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.PropertiesType#getMode()
	 * @see #getPropertiesType()
	 * @generated
	 */
	EAttribute getPropertiesType_Mode();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.layouts.PropertiesType#getWidgetMode <em>Widget Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Widget Mode</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.PropertiesType#getWidgetMode()
	 * @see #getPropertiesType()
	 * @generated
	 */
	EAttribute getPropertiesType_WidgetMode();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.layouts.PropertyType <em>Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Type</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.PropertyType
	 * @generated
	 */
	EClass getPropertyType();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.layouts.PropertyType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.PropertyType#getValue()
	 * @see #getPropertyType()
	 * @generated
	 */
	EAttribute getPropertyType_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.layouts.PropertyType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.PropertyType#getName()
	 * @see #getPropertyType()
	 * @generated
	 */
	EAttribute getPropertyType_Name();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.layouts.RowsType <em>Rows Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rows Type</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.RowsType
	 * @generated
	 */
	EClass getRowsType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.layouts.RowsType#getRow <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Row</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.RowsType#getRow()
	 * @see #getRowsType()
	 * @generated
	 */
	EReference getRowsType_Row();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.layouts.RowType <em>Row Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Row Type</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.RowType
	 * @generated
	 */
	EClass getRowType();

	/**
	 * Returns the meta object for the attribute list '{@link org.skinsoft.nuxeo.components.layouts.RowType#getWidget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Widget</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.RowType#getWidget()
	 * @see #getRowType()
	 * @generated
	 */
	EAttribute getRowType_Widget();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.layouts.SubWidgetsType <em>Sub Widgets Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Widgets Type</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.SubWidgetsType
	 * @generated
	 */
	EClass getSubWidgetsType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.layouts.SubWidgetsType#getWidget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Widget</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.SubWidgetsType#getWidget()
	 * @see #getSubWidgetsType()
	 * @generated
	 */
	EReference getSubWidgetsType_Widget();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.layouts.TemplatesType <em>Templates Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Templates Type</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.TemplatesType
	 * @generated
	 */
	EClass getTemplatesType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.layouts.TemplatesType#getTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Template</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.TemplatesType#getTemplate()
	 * @see #getTemplatesType()
	 * @generated
	 */
	EReference getTemplatesType_Template();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.layouts.TemplateType <em>Template Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Type</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.TemplateType
	 * @generated
	 */
	EClass getTemplateType();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.layouts.TemplateType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.TemplateType#getValue()
	 * @see #getTemplateType()
	 * @generated
	 */
	EAttribute getTemplateType_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.layouts.TemplateType#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.TemplateType#getMode()
	 * @see #getTemplateType()
	 * @generated
	 */
	EAttribute getTemplateType_Mode();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.layouts.WidgetModesType <em>Widget Modes Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Widget Modes Type</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.WidgetModesType
	 * @generated
	 */
	EClass getWidgetModesType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.layouts.WidgetModesType#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mode</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.WidgetModesType#getMode()
	 * @see #getWidgetModesType()
	 * @generated
	 */
	EReference getWidgetModesType_Mode();

	/**
	 * Returns the meta object for class '{@link org.skinsoft.nuxeo.components.layouts.WidgetType <em>Widget Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Widget Type</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.WidgetType
	 * @generated
	 */
	EClass getWidgetType();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getLabels <em>Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Labels</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.WidgetType#getLabels()
	 * @see #getWidgetType()
	 * @generated
	 */
	EReference getWidgetType_Labels();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getHelpLabels <em>Help Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Help Labels</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.WidgetType#getHelpLabels()
	 * @see #getWidgetType()
	 * @generated
	 */
	EReference getWidgetType_HelpLabels();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getTranslated <em>Translated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Translated</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.WidgetType#getTranslated()
	 * @see #getWidgetType()
	 * @generated
	 */
	EAttribute getWidgetType_Translated();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Fields</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.WidgetType#getFields()
	 * @see #getWidgetType()
	 * @generated
	 */
	EReference getWidgetType_Fields();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getWidgetModes <em>Widget Modes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Widget Modes</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.WidgetType#getWidgetModes()
	 * @see #getWidgetType()
	 * @generated
	 */
	EReference getWidgetType_WidgetModes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.WidgetType#getProperties()
	 * @see #getWidgetType()
	 * @generated
	 */
	EReference getWidgetType_Properties();

	/**
	 * Returns the meta object for the containment reference '{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getSubWidgets <em>Sub Widgets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Widgets</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.WidgetType#getSubWidgets()
	 * @see #getWidgetType()
	 * @generated
	 */
	EReference getWidgetType_SubWidgets();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.WidgetType#getName()
	 * @see #getWidgetType()
	 * @generated
	 */
	EAttribute getWidgetType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.skinsoft.nuxeo.components.layouts.WidgetType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.skinsoft.nuxeo.components.layouts.WidgetType#getType()
	 * @see #getWidgetType()
	 * @generated
	 */
	EAttribute getWidgetType_Type();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LayoutsFactory getLayoutsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.layouts.impl.ComponentTypeImpl <em>Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.layouts.impl.ComponentTypeImpl
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getComponentType()
		 * @generated
		 */
		EClass COMPONENT_TYPE = eINSTANCE.getComponentType();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_TYPE__EXTENSION = eINSTANCE.getComponentType_Extension();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_TYPE__NAME = eINSTANCE.getComponentType_Name();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.layouts.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.layouts.impl.DocumentRootImpl
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__COMPONENT = eINSTANCE.getDocumentRoot_Component();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.layouts.impl.ExtensionTypeImpl <em>Extension Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.layouts.impl.ExtensionTypeImpl
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getExtensionType()
		 * @generated
		 */
		EClass EXTENSION_TYPE = eINSTANCE.getExtensionType();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_TYPE__LAYOUT = eINSTANCE.getExtensionType_Layout();

		/**
		 * The meta object literal for the '<em><b>Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_TYPE__POINT = eINSTANCE.getExtensionType_Point();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_TYPE__TARGET = eINSTANCE.getExtensionType_Target();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.layouts.impl.FieldsTypeImpl <em>Fields Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.layouts.impl.FieldsTypeImpl
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getFieldsType()
		 * @generated
		 */
		EClass FIELDS_TYPE = eINSTANCE.getFieldsType();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIELDS_TYPE__FIELD = eINSTANCE.getFieldsType_Field();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.layouts.impl.FieldTypeImpl <em>Field Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.layouts.impl.FieldTypeImpl
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getFieldType()
		 * @generated
		 */
		EClass FIELD_TYPE = eINSTANCE.getFieldType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD_TYPE__VALUE = eINSTANCE.getFieldType_Value();

		/**
		 * The meta object literal for the '<em><b>Schema</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD_TYPE__SCHEMA = eINSTANCE.getFieldType_Schema();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.layouts.impl.HelpLabelsTypeImpl <em>Help Labels Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.layouts.impl.HelpLabelsTypeImpl
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getHelpLabelsType()
		 * @generated
		 */
		EClass HELP_LABELS_TYPE = eINSTANCE.getHelpLabelsType();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HELP_LABELS_TYPE__LABEL = eINSTANCE.getHelpLabelsType_Label();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.layouts.impl.LabelsTypeImpl <em>Labels Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LabelsTypeImpl
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getLabelsType()
		 * @generated
		 */
		EClass LABELS_TYPE = eINSTANCE.getLabelsType();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABELS_TYPE__LABEL = eINSTANCE.getLabelsType_Label();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.layouts.impl.LabelTypeImpl <em>Label Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LabelTypeImpl
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getLabelType()
		 * @generated
		 */
		EClass LABEL_TYPE = eINSTANCE.getLabelType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL_TYPE__VALUE = eINSTANCE.getLabelType_Value();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL_TYPE__MODE = eINSTANCE.getLabelType_Mode();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.layouts.impl.LayoutTypeImpl <em>Layout Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutTypeImpl
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getLayoutType()
		 * @generated
		 */
		EClass LAYOUT_TYPE = eINSTANCE.getLayoutType();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYOUT_TYPE__MIXED = eINSTANCE.getLayoutType_Mixed();

		/**
		 * The meta object literal for the '<em><b>Templates</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYOUT_TYPE__TEMPLATES = eINSTANCE.getLayoutType_Templates();

		/**
		 * The meta object literal for the '<em><b>Rows</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYOUT_TYPE__ROWS = eINSTANCE.getLayoutType_Rows();

		/**
		 * The meta object literal for the '<em><b>Widget</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYOUT_TYPE__WIDGET = eINSTANCE.getLayoutType_Widget();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYOUT_TYPE__NAME = eINSTANCE.getLayoutType_Name();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.layouts.impl.ModeTypeImpl <em>Mode Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.layouts.impl.ModeTypeImpl
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getModeType()
		 * @generated
		 */
		EClass MODE_TYPE = eINSTANCE.getModeType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODE_TYPE__VALUE = eINSTANCE.getModeType_Value();

		/**
		 * The meta object literal for the '<em><b>Value1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODE_TYPE__VALUE1 = eINSTANCE.getModeType_Value1();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.layouts.impl.PropertiesTypeImpl <em>Properties Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.layouts.impl.PropertiesTypeImpl
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getPropertiesType()
		 * @generated
		 */
		EClass PROPERTIES_TYPE = eINSTANCE.getPropertiesType();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES_TYPE__MIXED = eINSTANCE.getPropertiesType_Mixed();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTIES_TYPE__PROPERTY = eINSTANCE.getPropertiesType_Property();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES_TYPE__MODE = eINSTANCE.getPropertiesType_Mode();

		/**
		 * The meta object literal for the '<em><b>Widget Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES_TYPE__WIDGET_MODE = eINSTANCE.getPropertiesType_WidgetMode();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.layouts.impl.PropertyTypeImpl <em>Property Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.layouts.impl.PropertyTypeImpl
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getPropertyType()
		 * @generated
		 */
		EClass PROPERTY_TYPE = eINSTANCE.getPropertyType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_TYPE__VALUE = eINSTANCE.getPropertyType_Value();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_TYPE__NAME = eINSTANCE.getPropertyType_Name();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.layouts.impl.RowsTypeImpl <em>Rows Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.layouts.impl.RowsTypeImpl
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getRowsType()
		 * @generated
		 */
		EClass ROWS_TYPE = eINSTANCE.getRowsType();

		/**
		 * The meta object literal for the '<em><b>Row</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROWS_TYPE__ROW = eINSTANCE.getRowsType_Row();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.layouts.impl.RowTypeImpl <em>Row Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.layouts.impl.RowTypeImpl
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getRowType()
		 * @generated
		 */
		EClass ROW_TYPE = eINSTANCE.getRowType();

		/**
		 * The meta object literal for the '<em><b>Widget</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROW_TYPE__WIDGET = eINSTANCE.getRowType_Widget();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.layouts.impl.SubWidgetsTypeImpl <em>Sub Widgets Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.layouts.impl.SubWidgetsTypeImpl
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getSubWidgetsType()
		 * @generated
		 */
		EClass SUB_WIDGETS_TYPE = eINSTANCE.getSubWidgetsType();

		/**
		 * The meta object literal for the '<em><b>Widget</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_WIDGETS_TYPE__WIDGET = eINSTANCE.getSubWidgetsType_Widget();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.layouts.impl.TemplatesTypeImpl <em>Templates Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.layouts.impl.TemplatesTypeImpl
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getTemplatesType()
		 * @generated
		 */
		EClass TEMPLATES_TYPE = eINSTANCE.getTemplatesType();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATES_TYPE__TEMPLATE = eINSTANCE.getTemplatesType_Template();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.layouts.impl.TemplateTypeImpl <em>Template Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.layouts.impl.TemplateTypeImpl
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getTemplateType()
		 * @generated
		 */
		EClass TEMPLATE_TYPE = eINSTANCE.getTemplateType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_TYPE__VALUE = eINSTANCE.getTemplateType_Value();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_TYPE__MODE = eINSTANCE.getTemplateType_Mode();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.layouts.impl.WidgetModesTypeImpl <em>Widget Modes Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.layouts.impl.WidgetModesTypeImpl
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getWidgetModesType()
		 * @generated
		 */
		EClass WIDGET_MODES_TYPE = eINSTANCE.getWidgetModesType();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIDGET_MODES_TYPE__MODE = eINSTANCE.getWidgetModesType_Mode();

		/**
		 * The meta object literal for the '{@link org.skinsoft.nuxeo.components.layouts.impl.WidgetTypeImpl <em>Widget Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.skinsoft.nuxeo.components.layouts.impl.WidgetTypeImpl
		 * @see org.skinsoft.nuxeo.components.layouts.impl.LayoutsPackageImpl#getWidgetType()
		 * @generated
		 */
		EClass WIDGET_TYPE = eINSTANCE.getWidgetType();

		/**
		 * The meta object literal for the '<em><b>Labels</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIDGET_TYPE__LABELS = eINSTANCE.getWidgetType_Labels();

		/**
		 * The meta object literal for the '<em><b>Help Labels</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIDGET_TYPE__HELP_LABELS = eINSTANCE.getWidgetType_HelpLabels();

		/**
		 * The meta object literal for the '<em><b>Translated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET_TYPE__TRANSLATED = eINSTANCE.getWidgetType_Translated();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIDGET_TYPE__FIELDS = eINSTANCE.getWidgetType_Fields();

		/**
		 * The meta object literal for the '<em><b>Widget Modes</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIDGET_TYPE__WIDGET_MODES = eINSTANCE.getWidgetType_WidgetModes();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIDGET_TYPE__PROPERTIES = eINSTANCE.getWidgetType_Properties();

		/**
		 * The meta object literal for the '<em><b>Sub Widgets</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIDGET_TYPE__SUB_WIDGETS = eINSTANCE.getWidgetType_SubWidgets();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET_TYPE__NAME = eINSTANCE.getWidgetType_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET_TYPE__TYPE = eINSTANCE.getWidgetType_Type();

	}

} //LayoutsPackage
