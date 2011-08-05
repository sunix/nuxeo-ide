/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.skinsoft.nuxeo.components.search.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.skinsoft.nuxeo.components.search.IndexableDocTypeType;
import org.skinsoft.nuxeo.components.search.SearchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Indexable Doc Type Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.skinsoft.nuxeo.components.search.impl.IndexableDocTypeTypeImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.search.impl.IndexableDocTypeTypeImpl#getIndexAllSchemas <em>Index All Schemas</em>}</li>
 *   <li>{@link org.skinsoft.nuxeo.components.search.impl.IndexableDocTypeTypeImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IndexableDocTypeTypeImpl extends EObjectImpl implements IndexableDocTypeType {
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
	 * The default value of the '{@link #getIndexAllSchemas() <em>Index All Schemas</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexAllSchemas()
	 * @generated
	 * @ordered
	 */
	protected static final String INDEX_ALL_SCHEMAS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIndexAllSchemas() <em>Index All Schemas</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexAllSchemas()
	 * @generated
	 * @ordered
	 */
	protected String indexAllSchemas = INDEX_ALL_SCHEMAS_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndexableDocTypeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchPackage.Literals.INDEXABLE_DOC_TYPE_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.INDEXABLE_DOC_TYPE_TYPE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIndexAllSchemas() {
		return indexAllSchemas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndexAllSchemas(String newIndexAllSchemas) {
		String oldIndexAllSchemas = indexAllSchemas;
		indexAllSchemas = newIndexAllSchemas;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.INDEXABLE_DOC_TYPE_TYPE__INDEX_ALL_SCHEMAS, oldIndexAllSchemas, indexAllSchemas));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.INDEXABLE_DOC_TYPE_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SearchPackage.INDEXABLE_DOC_TYPE_TYPE__VALUE:
				return getValue();
			case SearchPackage.INDEXABLE_DOC_TYPE_TYPE__INDEX_ALL_SCHEMAS:
				return getIndexAllSchemas();
			case SearchPackage.INDEXABLE_DOC_TYPE_TYPE__NAME:
				return getName();
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
			case SearchPackage.INDEXABLE_DOC_TYPE_TYPE__VALUE:
				setValue((String)newValue);
				return;
			case SearchPackage.INDEXABLE_DOC_TYPE_TYPE__INDEX_ALL_SCHEMAS:
				setIndexAllSchemas((String)newValue);
				return;
			case SearchPackage.INDEXABLE_DOC_TYPE_TYPE__NAME:
				setName((String)newValue);
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
			case SearchPackage.INDEXABLE_DOC_TYPE_TYPE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case SearchPackage.INDEXABLE_DOC_TYPE_TYPE__INDEX_ALL_SCHEMAS:
				setIndexAllSchemas(INDEX_ALL_SCHEMAS_EDEFAULT);
				return;
			case SearchPackage.INDEXABLE_DOC_TYPE_TYPE__NAME:
				setName(NAME_EDEFAULT);
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
			case SearchPackage.INDEXABLE_DOC_TYPE_TYPE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case SearchPackage.INDEXABLE_DOC_TYPE_TYPE__INDEX_ALL_SCHEMAS:
				return INDEX_ALL_SCHEMAS_EDEFAULT == null ? indexAllSchemas != null : !INDEX_ALL_SCHEMAS_EDEFAULT.equals(indexAllSchemas);
			case SearchPackage.INDEXABLE_DOC_TYPE_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(", indexAllSchemas: ");
		result.append(indexAllSchemas);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //IndexableDocTypeTypeImpl
