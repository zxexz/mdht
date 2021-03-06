/*******************************************************************************
 * Copyright (c) 2010 David A Carlson.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     David A Carlson (XMLmodeling.com) - initial API and implementation
 *     
 * $Id$
 *******************************************************************************/
package org.openhealthtools.mdht.uml.term.core.profile.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.openhealthtools.mdht.uml.term.core.profile.StatusKind;
import org.openhealthtools.mdht.uml.term.core.profile.TermPackage;
import org.openhealthtools.mdht.uml.term.core.profile.UsageContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Usage Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.openhealthtools.mdht.uml.term.core.profile.impl.UsageContextImpl#getIdentifier <em>Identifier</em>}</li>
 * <li>{@link org.openhealthtools.mdht.uml.term.core.profile.impl.UsageContextImpl#getStatus <em>Status</em>}</li>
 * <li>{@link org.openhealthtools.mdht.uml.term.core.profile.impl.UsageContextImpl#getStatusDate <em>Status Date</em>}</li>
 * <li>{@link org.openhealthtools.mdht.uml.term.core.profile.impl.UsageContextImpl#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class UsageContextImpl extends EObjectImpl implements UsageContext {
	/**
	 * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String identifier = IDENTIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final StatusKind STATUS_EDEFAULT = StatusKind.ACTIVE;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected StatusKind status = STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatusDate() <em>Status Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getStatusDate()
	 * @generated
	 * @ordered
	 */
	protected static final String STATUS_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatusDate() <em>Status Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getStatusDate()
	 * @generated
	 * @ordered
	 */
	protected String statusDate = STATUS_DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected UsageContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TermPackage.USAGE_CONTEXT__IDENTIFIER:
				return getIdentifier();
			case TermPackage.USAGE_CONTEXT__STATUS:
				return getStatus();
			case TermPackage.USAGE_CONTEXT__STATUS_DATE:
				return getStatusDate();
			case TermPackage.USAGE_CONTEXT__BASE_CLASS:
				if (resolve) {
					return getBase_Class();
				}
				return basicGetBase_Class();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TermPackage.USAGE_CONTEXT__IDENTIFIER:
				return IDENTIFIER_EDEFAULT == null
						? identifier != null
						: !IDENTIFIER_EDEFAULT.equals(identifier);
			case TermPackage.USAGE_CONTEXT__STATUS:
				return status != STATUS_EDEFAULT;
			case TermPackage.USAGE_CONTEXT__STATUS_DATE:
				return STATUS_DATE_EDEFAULT == null
						? statusDate != null
						: !STATUS_DATE_EDEFAULT.equals(statusDate);
			case TermPackage.USAGE_CONTEXT__BASE_CLASS:
				return base_Class != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TermPackage.USAGE_CONTEXT__IDENTIFIER:
				setIdentifier((String) newValue);
				return;
			case TermPackage.USAGE_CONTEXT__STATUS:
				setStatus((StatusKind) newValue);
				return;
			case TermPackage.USAGE_CONTEXT__STATUS_DATE:
				setStatusDate((String) newValue);
				return;
			case TermPackage.USAGE_CONTEXT__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TermPackage.Literals.USAGE_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TermPackage.USAGE_CONTEXT__IDENTIFIER:
				setIdentifier(IDENTIFIER_EDEFAULT);
				return;
			case TermPackage.USAGE_CONTEXT__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case TermPackage.USAGE_CONTEXT__STATUS_DATE:
				setStatusDate(STATUS_DATE_EDEFAULT);
				return;
			case TermPackage.USAGE_CONTEXT__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class) null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject) base_Class;
			base_Class = (org.eclipse.uml2.uml.Class) eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(
						this, Notification.RESOLVE, TermPackage.USAGE_CONTEXT__BASE_CLASS, oldBase_Class, base_Class));
				}
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StatusKind getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getStatusDate() {
		return statusDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(
				this, Notification.SET, TermPackage.USAGE_CONTEXT__BASE_CLASS, oldBase_Class, base_Class));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIdentifier(String newIdentifier) {
		String oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(
				this, Notification.SET, TermPackage.USAGE_CONTEXT__IDENTIFIER, oldIdentifier, identifier));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setStatus(StatusKind newStatus) {
		StatusKind oldStatus = status;
		status = newStatus == null
				? STATUS_EDEFAULT
				: newStatus;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TermPackage.USAGE_CONTEXT__STATUS, oldStatus, status));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setStatusDate(String newStatusDate) {
		String oldStatusDate = statusDate;
		statusDate = newStatusDate;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(
				this, Notification.SET, TermPackage.USAGE_CONTEXT__STATUS_DATE, oldStatusDate, statusDate));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		return base_Class.getQualifiedName();

		// StringBuffer result = new StringBuffer(super.toString());
		// result.append(" (identifier: ");
		// result.append(identifier);
		// result.append(", status: ");
		// result.append(status);
		// result.append(", statusDate: ");
		// result.append(statusDate);
		// result.append(')');
		// return result.toString();
	}

} // UsageContextImpl
