/*******************************************************************************
 * Copyright (c) 2006, 2009 David A Carlson.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 *******************************************************************************/
package org.eclipse.mdht.uml.common.ui.util;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.swt.widgets.Widget;

/**
 * This cell modifier wraps an AdapterFactory and it delegates its JFace viewer
 * interfaces to corresponding adapter-implemented item provider interfaces. All
 * method calls to the various cell modifier interfaces are delegated to
 * interfaces implemented by the adapters generated by the AdapterFactory. {@link ICellModifier} is delegated to {@link IItemCellModifier}.
 */
public class AdapterFactoryCellModifier implements ICellModifier {
	/**
	 * This keep track of the one factory we are using. Use a {@link org.eclipse.emf.edit.provider.ComposedAdapterFactory} if adapters
	 * from more the one factory are involved in the model.
	 */
	protected AdapterFactory adapterFactory;

	private static final Class ICellModifierClass = ICellModifier.class;

	/**
	 * Construct an instance that wraps this factory. The AdapterFactory should
	 * yield adapters that implement the various item label provider interfaces.
	 */
	public AdapterFactoryCellModifier(AdapterFactory adapterFactory) {
		this.adapterFactory = adapterFactory;
	}

	/**
	 * Return the wrapped AdapterFactory.
	 */
	public AdapterFactory getAdapterFactory() {
		return adapterFactory;
	}

	/**
	 * Set the wrapped AdapterFactory.
	 */
	public void setAdapterFactory(AdapterFactory adapterFactory) {
		this.adapterFactory = adapterFactory;
	}

	public boolean canModify(Object element, String property) {
		// Get the adapter from the factory.
		ICellModifier cellModifier = (ICellModifier) adapterFactory.adapt(element, ICellModifierClass);

		// Now we could check that the adapter implements interface ICellModifier.
		if (cellModifier != null) {
			// And delegate the call.
			return cellModifier.canModify(element, property);
		}
		return false;
	}

	public Object getValue(Object element, String property) {
		// Get the adapter from the factory.
		ICellModifier cellModifier = (ICellModifier) adapterFactory.adapt(element, ICellModifierClass);

		// Now we could check that the adapter implements interface ICellModifier.
		if (cellModifier != null) {
			// And delegate the call.
			return cellModifier.getValue(element, property);
		}
		return null;
	}

	public void modify(Object element, String property, Object value) {
		Object object = (element instanceof Widget)
				? ((Widget) element).getData()
				: element;

		// Get the adapter from the factory.
		ICellModifier cellModifier = (ICellModifier) adapterFactory.adapt(object, ICellModifierClass);

		// Now we could check that the adapter implements interface ICellModifier.
		if (cellModifier != null) {
			// And delegate the call.
			cellModifier.modify(object, property, value);
		}
	}

}