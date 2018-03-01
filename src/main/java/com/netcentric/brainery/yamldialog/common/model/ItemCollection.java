package com.netcentric.brainery.yamldialog.common.model;

import java.util.ArrayList;
import java.util.Collection;

public class ItemCollection<E> {

	protected Collection<E> items = new ArrayList<>();

	public void add(E e) {
		if (e != null) {
			items.add(e);
		}
	}

	public void add(Collection<E> items) {
		if (items != null) {
			this.items.addAll(items);
		}
	}

	public Collection<E> list() {
		return items;
	}
	
	public boolean isEmpty() {
		return items.isEmpty();
	}
}
