/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.workflow.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.skinsoft.nuxeo.components.workflow.DefinitionType;
import org.skinsoft.nuxeo.components.workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Definition Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.impl.DefinitionTypeImpl#getEngineName <em>Engine Name</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.impl.DefinitionTypeImpl#getMimetype <em>Mimetype</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.workflow.impl.DefinitionTypeImpl#getDefinitionPath <em>Definition Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefinitionTypeImpl extends EObjectImpl implements DefinitionType {
	/**
	 * The default value of the '{@link #getEngineName() <em>Engine Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngineName()
	 * @generated
	 * @ordered
	 */
	protected static final String ENGINE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEngineName() <em>Engine Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEngineName()
	 * @generated
	 * @ordered
	 */
	protected String engineName = ENGINE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMimetype() <em>Mimetype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMimetype()
	 * @generated
	 * @ordered
	 */
	protected static final String MIMETYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMimetype() <em>Mimetype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMimetype()
	 * @generated
	 * @ordered
	 */
	protected String mimetype = MIMETYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefinitionPath() <em>Definition Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitionPath()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFINITION_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefinitionPath() <em>Definition Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitionPath()
	 * @generated
	 * @ordered
	 */
	protected String definitionPath = DEFINITION_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefinitionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.DEFINITION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEngineName() {
		return engineName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEngineName(String newEngineName) {
		String oldEngineName = engineName;
		engineName = newEngineName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.DEFINITION_TYPE__ENGINE_NAME, oldEngineName, engineName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMimetype() {
		return mimetype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMimetype(String newMimetype) {
		String oldMimetype = mimetype;
		mimetype = newMimetype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.DEFINITION_TYPE__MIMETYPE, oldMimetype, mimetype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefinitionPath() {
		return definitionPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinitionPath(String newDefinitionPath) {
		String oldDefinitionPath = definitionPath;
		definitionPath = newDefinitionPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.DEFINITION_TYPE__DEFINITION_PATH, oldDefinitionPath, definitionPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowPackage.DEFINITION_TYPE__ENGINE_NAME:
				return getEngineName();
			case WorkflowPackage.DEFINITION_TYPE__MIMETYPE:
				return getMimetype();
			case WorkflowPackage.DEFINITION_TYPE__DEFINITION_PATH:
				return getDefinitionPath();
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
			case WorkflowPackage.DEFINITION_TYPE__ENGINE_NAME:
				setEngineName((String)newValue);
				return;
			case WorkflowPackage.DEFINITION_TYPE__MIMETYPE:
				setMimetype((String)newValue);
				return;
			case WorkflowPackage.DEFINITION_TYPE__DEFINITION_PATH:
				setDefinitionPath((String)newValue);
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
			case WorkflowPackage.DEFINITION_TYPE__ENGINE_NAME:
				setEngineName(ENGINE_NAME_EDEFAULT);
				return;
			case WorkflowPackage.DEFINITION_TYPE__MIMETYPE:
				setMimetype(MIMETYPE_EDEFAULT);
				return;
			case WorkflowPackage.DEFINITION_TYPE__DEFINITION_PATH:
				setDefinitionPath(DEFINITION_PATH_EDEFAULT);
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
			case WorkflowPackage.DEFINITION_TYPE__ENGINE_NAME:
				return ENGINE_NAME_EDEFAULT == null ? engineName != null : !ENGINE_NAME_EDEFAULT.equals(engineName);
			case WorkflowPackage.DEFINITION_TYPE__MIMETYPE:
				return MIMETYPE_EDEFAULT == null ? mimetype != null : !MIMETYPE_EDEFAULT.equals(mimetype);
			case WorkflowPackage.DEFINITION_TYPE__DEFINITION_PATH:
				return DEFINITION_PATH_EDEFAULT == null ? definitionPath != null : !DEFINITION_PATH_EDEFAULT.equals(definitionPath);
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
		result.append(" (engineName: ");
		result.append(engineName);
		result.append(", mimetype: ");
		result.append(mimetype);
		result.append(", definitionPath: ");
		result.append(definitionPath);
		result.append(')');
		return result.toString();
	}

} //DefinitionTypeImpl
