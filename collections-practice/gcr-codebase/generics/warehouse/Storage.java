package com.collections.generics.warehouse;

import java.util.ArrayList;
import java.util.List;

public class Storage<T extends WarehouseItem> {
	private List<T> items;

	public Storage() {
		items = new ArrayList<>();
	}

	public void addItem(T item) {
		items.add(item);
	}

	public T getItem(int index) {
		if (index >= 0 && index < items.size()) {
			return items.get(index);
		}
		return null;
	}

	public List<T> getAllItems() {
		return items;
	}
}
