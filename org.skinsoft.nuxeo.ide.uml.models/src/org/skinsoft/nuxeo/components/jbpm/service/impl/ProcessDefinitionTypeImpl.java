/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.jbpm.service.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.skinsoft.nuxeo.components.jbpm.service.ProcessDefinitionType;
import org.skinsoft.nuxeo.components.jbpm.service.ServicePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Definition Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.jbpm.service.impl.ProcessDefinitionTypeImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.jbpm.service.impl.ProcessDefinitionTypeImpl#getDeployer <em>Deployer</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.jbpm.service.impl.ProcessDefinitionTypeImpl#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessDefinitionTypeImpl extends EObjectImpl implements ProcessDefinitionType {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDeployer() <em>Deployer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeployer()
	 * @generated
	 * @ordered
	 */
	protected static final String DEPLOYER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDeployer() <em>Deployer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeployer()
	 * @generated
	 * @ordered
	 */
	protected String deployer = DEPLOYER_EDEFAULT;

	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessDefinitionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicePackage.Literals.PROCESS_DEFINITION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.PROCESS_DEFINITION_TYPE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDeployer() {
		return deployer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeployer(String newDeployer) {
		String oldDeployer = deployer;
		deployer = newDeployer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.PROCESS_DEFINITION_TYPE__DEPLOYER, oldDeployer, deployer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.PROCESS_DEFINITION_TYPE__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServicePackage.PROCESS_DEFINITION_TYPE__VALUE:
				return getValue();
			case ServicePackage.PROCESS_DEFINITION_TYPE__DEPLOYER:
				return getDeployer();
			case ServicePackage.PROCESS_DEFINITION_TYPE__PATH:
				return getPath();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ServicePackage.PROCESS_DEFINITION_TYPE__VALUE:
				setValue((String)newValue);
				return;
			case ServicePackage.PROCESS_DEFINITION_TYPE__DEPLOYER:
				setDeployer((String)newValue);
				return;
			case ServicePackage.PROCESS_DEFINITION_TYPE__PATH:
				setPath((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ServicePackage.PROCESS_DEFINITION_TYPE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case ServicePackage.PROCESS_DEFINITION_TYPE__DEPLOYER:
				setDeployer(DEPLOYER_EDEFAULT);
				return;
			case ServicePackage.PROCESS_DEFINITION_TYPE__PATH:
				setPath(PATH_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ServicePackage.PROCESS_DEFINITION_TYPE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case ServicePackage.PROCESS_DEFINITION_TYPE__DEPLOYER:
				return DEPLOYER_EDEFAULT == null ? deployer != null : !DEPLOYER_EDEFAULT.equals(deployer);
			case ServicePackage.PROCESS_DEFINITION_TYPE__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (value: ");
		result.append(value);
		result.append(", deployer: ");
		result.append(deployer);
		result.append(", path: ");
		result.append(path);
		result.append(')');
		return result.toString();
	}

} //ProcessDefinitionTypeImpl
