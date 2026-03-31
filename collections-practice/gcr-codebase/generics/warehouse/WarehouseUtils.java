package com.collections.generics.warehouse;

import java.util.List;

public class WarehouseUtils {
	public static void displayItems(List<? extends WarehouseItem> items) {
		for (WarehouseItem item : items) {
			System.out.println("Item Name: " + item.getName() + ", Price: " + item.getPrice());
		}
	}
}