/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.directories.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.skinsoft.nuxeo.components.directories.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DirectoriesFactoryImpl extends EFactoryImpl implements DirectoriesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DirectoriesFactory init() {
		try {
			DirectoriesFactory theDirectoriesFactory = (DirectoriesFactory)EPackage.Registry.INSTANCE.getEFactory("http://skinsoft.org/nuxeo/components/directories"); 
			if (theDirectoriesFactory != null) {
				return theDirectoriesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DirectoriesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectoriesFactoryImpl() {
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
			case DirectoriesPackage.COMPONENT_TYPE: return createComponentType();
			case DirectoriesPackage.DIRECTORY_TYPE: return createDirectoryType();
			case DirectoriesPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case DirectoriesPackage.EXTENSION_TYPE: return createExtensionType();
			case DirectoriesPackage.TIMESTAMP_TYPE: return createTimestampType();
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
	public DirectoryType createDirectoryType() {
		DirectoryTypeImpl directoryType = new DirectoryTypeImpl();
		return directoryType;
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
	public TimestampType createTimestampType() {
		TimestampTypeImpl timestampType = new TimestampTypeImpl();
		return timestampType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectoriesPackage getDirectoriesPackage() {
		return (DirectoriesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DirectoriesPackage getPackage() {
		return DirectoriesPackage.eINSTANCE;
	}

} //DirectoriesFactoryImpl
