/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.lifecycle.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.skinsoft.nuxeo.components.lifecycle.ComponentType;
import org.skinsoft.nuxeo.components.lifecycle.DocumentRoot;
import org.skinsoft.nuxeo.components.lifecycle.ExtensionType;
import org.skinsoft.nuxeo.components.lifecycle.LifecycleFactory;
import org.skinsoft.nuxeo.components.lifecycle.LifecyclePackage;
import org.skinsoft.nuxeo.components.lifecycle.LifecycleType;
import org.skinsoft.nuxeo.components.lifecycle.StateTransitionsType;
import org.skinsoft.nuxeo.components.lifecycle.StateType;
import org.skinsoft.nuxeo.components.lifecycle.StatesType;
import org.skinsoft.nuxeo.components.lifecycle.TransitionType;
import org.skinsoft.nuxeo.components.lifecycle.TransitionsType;
import org.skinsoft.nuxeo.components.lifecycle.TypeType;
import org.skinsoft.nuxeo.components.lifecycle.TypesType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LifecyclePackageImpl extends EPackageImpl implements LifecyclePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lifecycleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateTransitionsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transitionsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transitionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeTypeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.skinsoft.nuxeo.components.lifecycle.LifecyclePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LifecyclePackageImpl() {
		super(eNS_URI, LifecycleFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LifecyclePackage init() {
		if (isInited) return (LifecyclePackage)EPackage.Registry.INSTANCE.getEPackage(LifecyclePackage.eNS_URI);

		// Obtain or create and register package
		LifecyclePackageImpl theLifecyclePackage = (LifecyclePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof LifecyclePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new LifecyclePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theLifecyclePackage.createPackageContents();

		// Initialize created meta-data
		theLifecyclePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLifecyclePackage.freeze();

		return theLifecyclePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentType() {
		return componentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_Extension() {
		return (EReference)componentTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentType_Name() {
		return (EAttribute)componentTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Component() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtensionType() {
		return extensionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionType_Lifecycle() {
		return (EReference)extensionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionType_Types() {
		return (EReference)extensionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtensionType_Point() {
		return (EAttribute)extensionTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtensionType_Target() {
		return (EAttribute)extensionTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLifecycleType() {
		return lifecycleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLifecycleType_Transitions() {
		return (EReference)lifecycleTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLifecycleType_States() {
		return (EReference)lifecycleTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLifecycleType_Initial() {
		return (EAttribute)lifecycleTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLifecycleType_Lifecyclemanager() {
		return (EAttribute)lifecycleTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLifecycleType_Name() {
		return (EAttribute)lifecycleTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatesType() {
		return statesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStatesType_State() {
		return (EReference)statesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateTransitionsType() {
		return stateTransitionsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStateTransitionsType_Transition() {
		return (EAttribute)stateTransitionsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateType() {
		return stateTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateType_Transitions() {
		return (EReference)stateTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStateType_Description() {
		return (EAttribute)stateTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStateType_Name() {
		return (EAttribute)stateTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransitionsType() {
		return transitionsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransitionsType_Transition() {
		return (EReference)transitionsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransitionType() {
		return transitionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransitionType_Mixed() {
		return (EAttribute)transitionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransitionType_Description() {
		return (EAttribute)transitionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransitionType_DestinationState() {
		return (EAttribute)transitionTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransitionType_Name() {
		return (EAttribute)transitionTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypesType() {
		return typesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypesType_Type() {
		return (EReference)typesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeType() {
		return typeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeType_Value() {
		return (EAttribute)typeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeType_Name() {
		return (EAttribute)typeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LifecycleFactory getLifecycleFactory() {
		return (LifecycleFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		componentTypeEClass = createEClass(COMPONENT_TYPE);
		createEReference(componentTypeEClass, COMPONENT_TYPE__EXTENSION);
		createEAttribute(componentTypeEClass, COMPONENT_TYPE__NAME);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__COMPONENT);

		extensionTypeEClass = createEClass(EXTENSION_TYPE);
		createEReference(extensionTypeEClass, EXTENSION_TYPE__LIFECYCLE);
		createEReference(extensionTypeEClass, EXTENSION_TYPE__TYPES);
		createEAttribute(extensionTypeEClass, EXTENSION_TYPE__POINT);
		createEAttribute(extensionTypeEClass, EXTENSION_TYPE__TARGET);

		lifecycleTypeEClass = createEClass(LIFECYCLE_TYPE);
		createEReference(lifecycleTypeEClass, LIFECYCLE_TYPE__TRANSITIONS);
		createEReference(lifecycleTypeEClass, LIFECYCLE_TYPE__STATES);
		createEAttribute(lifecycleTypeEClass, LIFECYCLE_TYPE__INITIAL);
		createEAttribute(lifecycleTypeEClass, LIFECYCLE_TYPE__LIFECYCLEMANAGER);
		createEAttribute(lifecycleTypeEClass, LIFECYCLE_TYPE__NAME);

		statesTypeEClass = createEClass(STATES_TYPE);
		createEReference(statesTypeEClass, STATES_TYPE__STATE);

		stateTransitionsTypeEClass = createEClass(STATE_TRANSITIONS_TYPE);
		createEAttribute(stateTransitionsTypeEClass, STATE_TRANSITIONS_TYPE__TRANSITION);

		stateTypeEClass = createEClass(STATE_TYPE);
		createEReference(stateTypeEClass, STATE_TYPE__TRANSITIONS);
		createEAttribute(stateTypeEClass, STATE_TYPE__DESCRIPTION);
		createEAttribute(stateTypeEClass, STATE_TYPE__NAME);

		transitionsTypeEClass = createEClass(TRANSITIONS_TYPE);
		createEReference(transitionsTypeEClass, TRANSITIONS_TYPE__TRANSITION);

		transitionTypeEClass = createEClass(TRANSITION_TYPE);
		createEAttribute(transitionTypeEClass, TRANSITION_TYPE__MIXED);
		createEAttribute(transitionTypeEClass, TRANSITION_TYPE__DESCRIPTION);
		createEAttribute(transitionTypeEClass, TRANSITION_TYPE__DESTINATION_STATE);
		createEAttribute(transitionTypeEClass, TRANSITION_TYPE__NAME);

		typesTypeEClass = createEClass(TYPES_TYPE);
		createEReference(typesTypeEClass, TYPES_TYPE__TYPE);

		typeTypeEClass = createEClass(TYPE_TYPE);
		createEAttribute(typeTypeEClass, TYPE_TYPE__VALUE);
		createEAttribute(typeTypeEClass, TYPE_TYPE__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(componentTypeEClass, ComponentType.class, "ComponentType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentType_Extension(), this.getExtensionType(), null, "extension", null, 0, -1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Component(), this.getComponentType(), null, "component", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(extensionTypeEClass, ExtensionType.class, "ExtensionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtensionType_Lifecycle(), this.getLifecycleType(), null, "lifecycle", null, 0, -1, ExtensionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtensionType_Types(), this.getTypesType(), null, "types", null, 0, 1, ExtensionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtensionType_Point(), theXMLTypePackage.getString(), "point", null, 0, 1, ExtensionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtensionType_Target(), theXMLTypePackage.getString(), "target", null, 0, 1, ExtensionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lifecycleTypeEClass, LifecycleType.class, "LifecycleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLifecycleType_Transitions(), this.getTransitionsType(), null, "transitions", null, 1, 1, LifecycleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLifecycleType_States(), this.getStatesType(), null, "states", null, 1, 1, LifecycleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLifecycleType_Initial(), theXMLTypePackage.getString(), "initial", null, 0, 1, LifecycleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLifecycleType_Lifecyclemanager(), theXMLTypePackage.getString(), "lifecyclemanager", null, 0, 1, LifecycleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLifecycleType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, LifecycleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statesTypeEClass, StatesType.class, "StatesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStatesType_State(), this.getStateType(), null, "state", null, 0, -1, StatesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateTransitionsTypeEClass, StateTransitionsType.class, "StateTransitionsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStateTransitionsType_Transition(), theXMLTypePackage.getString(), "transition", null, 0, -1, StateTransitionsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateTypeEClass, StateType.class, "StateType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateType_Transitions(), this.getStateTransitionsType(), null, "transitions", null, 1, 1, StateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStateType_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, StateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStateType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, StateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transitionsTypeEClass, TransitionsType.class, "TransitionsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransitionsType_Transition(), this.getTransitionType(), null, "transition", null, 0, -1, TransitionsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transitionTypeEClass, TransitionType.class, "TransitionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTransitionType_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, TransitionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransitionType_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, TransitionType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransitionType_DestinationState(), theXMLTypePackage.getString(), "destinationState", null, 0, 1, TransitionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransitionType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TransitionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typesTypeEClass, TypesType.class, "TypesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypesType_Type(), this.getTypeType(), null, "type", null, 0, -1, TypesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeTypeEClass, TypeType.class, "TypeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypeType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, TypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypeType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (componentTypeEClass, 
		   source, 
		   new String[] {
			 "name", "componentType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getComponentType_Extension(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "extension",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getComponentType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getDocumentRoot_Component(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "component",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (extensionTypeEClass, 
		   source, 
		   new String[] {
			 "name", "extensionType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getExtensionType_Lifecycle(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "lifecycle",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getExtensionType_Types(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "types",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getExtensionType_Point(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "point"
		   });		
		addAnnotation
		  (getExtensionType_Target(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "target"
		   });		
		addAnnotation
		  (lifecycleTypeEClass, 
		   source, 
		   new String[] {
			 "name", "lifecycleType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getLifecycleType_Transitions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "transitions",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getLifecycleType_States(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "states",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getLifecycleType_Initial(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "initial"
		   });		
		addAnnotation
		  (getLifecycleType_Lifecyclemanager(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "lifecyclemanager"
		   });		
		addAnnotation
		  (getLifecycleType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (statesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "statesType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getStatesType_State(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "state",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (stateTransitionsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "stateTransitionsType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getStateTransitionsType_Transition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "transition",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (stateTypeEClass, 
		   source, 
		   new String[] {
			 "name", "stateType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getStateType_Transitions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "transitions",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getStateType_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "description"
		   });		
		addAnnotation
		  (getStateType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (transitionsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "transitionsType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTransitionsType_Transition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "transition",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (transitionTypeEClass, 
		   source, 
		   new String[] {
			 "name", "transitionType",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getTransitionType_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getTransitionType_Description(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "description",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTransitionType_DestinationState(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "destinationState"
		   });		
		addAnnotation
		  (getTransitionType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (typesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "typesType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTypesType_Type(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "type",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (typeTypeEClass, 
		   source, 
		   new String[] {
			 "name", "typeType",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getTypeType_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getTypeType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });
	}

} //LifecyclePackageImpl
