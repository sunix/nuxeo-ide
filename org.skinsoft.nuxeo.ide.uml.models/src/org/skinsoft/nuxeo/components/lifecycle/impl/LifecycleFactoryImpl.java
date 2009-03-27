/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.lifecycle.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.skinsoft.nuxeo.components.lifecycle.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LifecycleFactoryImpl extends EFactoryImpl implements LifecycleFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LifecycleFactory init() {
		try {
			LifecycleFactory theLifecycleFactory = (LifecycleFactory)EPackage.Registry.INSTANCE.getEFactory("http://skinsoft.org/nuxeo/components/lifecycle"); 
			if (theLifecycleFactory != null) {
				return theLifecycleFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LifecycleFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LifecycleFactoryImpl() {
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
			case LifecyclePackage.COMPONENT_TYPE: return createComponentType();
			case LifecyclePackage.DOCUMENT_ROOT: return createDocumentRoot();
			case LifecyclePackage.EXTENSION_TYPE: return createExtensionType();
			case LifecyclePackage.LIFECYCLE_TYPE: return createLifecycleType();
			case LifecyclePackage.STATES_TYPE: return createStatesType();
			case LifecyclePackage.STATE_TRANSITIONS_TYPE: return createStateTransitionsType();
			case LifecyclePackage.STATE_TYPE: return createStateType();
			case LifecyclePackage.TRANSITIONS_TYPE: return createTransitionsType();
			case LifecyclePackage.TRANSITION_TYPE: return createTransitionType();
			case LifecyclePackage.TYPES_TYPE: return createTypesType();
			case LifecyclePackage.TYPE_TYPE: return createTypeType();
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
	public LifecycleType createLifecycleType() {
		LifecycleTypeImpl lifecycleType = new LifecycleTypeImpl();
		return lifecycleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatesType createStatesType() {
		StatesTypeImpl statesType = new StatesTypeImpl();
		return statesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateTransitionsType createStateTransitionsType() {
		StateTransitionsTypeImpl stateTransitionsType = new StateTransitionsTypeImpl();
		return stateTransitionsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateType createStateType() {
		StateTypeImpl stateType = new StateTypeImpl();
		return stateType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionsType createTransitionsType() {
		TransitionsTypeImpl transitionsType = new TransitionsTypeImpl();
		return transitionsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionType createTransitionType() {
		TransitionTypeImpl transitionType = new TransitionTypeImpl();
		return transitionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesType createTypesType() {
		TypesTypeImpl typesType = new TypesTypeImpl();
		return typesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeType createTypeType() {
		TypeTypeImpl typeType = new TypeTypeImpl();
		return typeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LifecyclePackage getLifecyclePackage() {
		return (LifecyclePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LifecyclePackage getPackage() {
		return LifecyclePackage.eINSTANCE;
	}

} //LifecycleFactoryImpl
