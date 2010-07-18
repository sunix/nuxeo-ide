/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.layouts.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.skinsoft.nuxeo.components.layouts.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.skinsoft.nuxeo.components.layouts.LayoutsPackage
 * @generated
 */
public class LayoutsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LayoutsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = LayoutsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayoutsSwitch<Adapter> modelSwitch =
		new LayoutsSwitch<Adapter>() {
			@Override
			public Adapter caseComponentType(ComponentType object) {
				return createComponentTypeAdapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseExtensionType(ExtensionType object) {
				return createExtensionTypeAdapter();
			}
			@Override
			public Adapter caseFieldsType(FieldsType object) {
				return createFieldsTypeAdapter();
			}
			@Override
			public Adapter caseFieldType(FieldType object) {
				return createFieldTypeAdapter();
			}
			@Override
			public Adapter caseHelpLabelsType(HelpLabelsType object) {
				return createHelpLabelsTypeAdapter();
			}
			@Override
			public Adapter caseLabelsType(LabelsType object) {
				return createLabelsTypeAdapter();
			}
			@Override
			public Adapter caseLabelType(LabelType object) {
				return createLabelTypeAdapter();
			}
			@Override
			public Adapter caseLayoutType(LayoutType object) {
				return createLayoutTypeAdapter();
			}
			@Override
			public Adapter caseModeType(ModeType object) {
				return createModeTypeAdapter();
			}
			@Override
			public Adapter casePropertiesType(PropertiesType object) {
				return createPropertiesTypeAdapter();
			}
			@Override
			public Adapter casePropertyType(PropertyType object) {
				return createPropertyTypeAdapter();
			}
			@Override
			public Adapter caseRowsType(RowsType object) {
				return createRowsTypeAdapter();
			}
			@Override
			public Adapter caseRowType(RowType object) {
				return createRowTypeAdapter();
			}
			@Override
			public Adapter caseSubWidgetsType(SubWidgetsType object) {
				return createSubWidgetsTypeAdapter();
			}
			@Override
			public Adapter caseTemplatesType(TemplatesType object) {
				return createTemplatesTypeAdapter();
			}
			@Override
			public Adapter caseTemplateType(TemplateType object) {
				return createTemplateTypeAdapter();
			}
			@Override
			public Adapter caseWidgetModesType(WidgetModesType object) {
				return createWidgetModesTypeAdapter();
			}
			@Override
			public Adapter caseWidgetType(WidgetType object) {
				return createWidgetTypeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.skinsoft.nuxeo.components.layouts.ComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.skinsoft.nuxeo.components.layouts.ComponentType
	 * @generated
	 */
	public Adapter createComponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.skinsoft.nuxeo.components.layouts.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.skinsoft.nuxeo.components.layouts.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.skinsoft.nuxeo.components.layouts.ExtensionType <em>Extension Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.skinsoft.nuxeo.components.layouts.ExtensionType
	 * @generated
	 */
	public Adapter createExtensionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.skinsoft.nuxeo.components.layouts.FieldsType <em>Fields Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.skinsoft.nuxeo.components.layouts.FieldsType
	 * @generated
	 */
	public Adapter createFieldsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.skinsoft.nuxeo.components.layouts.FieldType <em>Field Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.skinsoft.nuxeo.components.layouts.FieldType
	 * @generated
	 */
	public Adapter createFieldTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.skinsoft.nuxeo.components.layouts.HelpLabelsType <em>Help Labels Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.skinsoft.nuxeo.components.layouts.HelpLabelsType
	 * @generated
	 */
	public Adapter createHelpLabelsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.skinsoft.nuxeo.components.layouts.LabelsType <em>Labels Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.skinsoft.nuxeo.components.layouts.LabelsType
	 * @generated
	 */
	public Adapter createLabelsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.skinsoft.nuxeo.components.layouts.LabelType <em>Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.skinsoft.nuxeo.components.layouts.LabelType
	 * @generated
	 */
	public Adapter createLabelTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.skinsoft.nuxeo.components.layouts.LayoutType <em>Layout Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.skinsoft.nuxeo.components.layouts.LayoutType
	 * @generated
	 */
	public Adapter createLayoutTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.skinsoft.nuxeo.components.layouts.ModeType <em>Mode Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.skinsoft.nuxeo.components.layouts.ModeType
	 * @generated
	 */
	public Adapter createModeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.skinsoft.nuxeo.components.layouts.PropertiesType <em>Properties Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.skinsoft.nuxeo.components.layouts.PropertiesType
	 * @generated
	 */
	public Adapter createPropertiesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.skinsoft.nuxeo.components.layouts.PropertyType <em>Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.skinsoft.nuxeo.components.layouts.PropertyType
	 * @generated
	 */
	public Adapter createPropertyTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.skinsoft.nuxeo.components.layouts.RowsType <em>Rows Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.skinsoft.nuxeo.components.layouts.RowsType
	 * @generated
	 */
	public Adapter createRowsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.skinsoft.nuxeo.components.layouts.RowType <em>Row Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.skinsoft.nuxeo.components.layouts.RowType
	 * @generated
	 */
	public Adapter createRowTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.skinsoft.nuxeo.components.layouts.SubWidgetsType <em>Sub Widgets Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.skinsoft.nuxeo.components.layouts.SubWidgetsType
	 * @generated
	 */
	public Adapter createSubWidgetsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.skinsoft.nuxeo.components.layouts.TemplatesType <em>Templates Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.skinsoft.nuxeo.components.layouts.TemplatesType
	 * @generated
	 */
	public Adapter createTemplatesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.skinsoft.nuxeo.components.layouts.TemplateType <em>Template Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.skinsoft.nuxeo.components.layouts.TemplateType
	 * @generated
	 */
	public Adapter createTemplateTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.skinsoft.nuxeo.components.layouts.WidgetModesType <em>Widget Modes Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.skinsoft.nuxeo.components.layouts.WidgetModesType
	 * @generated
	 */
	public Adapter createWidgetModesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.skinsoft.nuxeo.components.layouts.WidgetType <em>Widget Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.skinsoft.nuxeo.components.layouts.WidgetType
	 * @generated
	 */
	public Adapter createWidgetTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //LayoutsAdapterFactory
