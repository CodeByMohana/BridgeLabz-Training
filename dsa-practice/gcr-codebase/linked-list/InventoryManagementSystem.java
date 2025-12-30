package com.dsapractice.linkedlist;

class ItemNode {
	String itemName;
	int itemId;
	int quantity;
	double price;
	ItemNode next;

	public ItemNode(String itemName, int itemId, int quantity, double price) {
		this.itemName = itemName;
		this.itemId = itemId;
		this.quantity = quantity;
		this.price = price;
		this.next = null;
	}

}

interface InventoryManagement {
	void addAtBeginning(String itemName, int itemId, int quantity, double price);

	void addAtEnd(String itemName, int itemId, int quantity, double price);

	void addAtPosition(int position, String itemName, int itemId, int quantity, double price);

	void removeByItemId(int id);

	void updateItemQuantity(int id, int quantity);

	ItemNode searchByName(String name);

	ItemNode searchById(int id);

	double totalValue();
}

public class InventoryManagementSystem implements InventoryManagement {

	private ItemNode head;

	@Override
	public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
		ItemNode newItem = new ItemNode(itemName, itemId, quantity, price);
		newItem.next = head;
		head = newItem;

	}

	@Override
	public void addAtEnd(String itemName, int itemId, int quantity, double price) {
		if (head == null) {
			addAtBeginning(itemName, itemId, quantity, price);
			return;
		}
		ItemNode newItem = new ItemNode(itemName, itemId, quantity, price);
		ItemNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newItem;

	}

	@Override
	public void addAtPosition(int position, String itemName, int itemId, int quantity, double price) {
		if (position <= 0) {
			System.out.println("Invalid position");
			return;
		}
		if (head == null || position == 1) {
			addAtBeginning(itemName, itemId, quantity, price);
			return;
		}
		ItemNode newItem = new ItemNode(itemName, itemId, quantity, price);
		ItemNode temp = head;

		for (int i = 1; i < position - 1 && temp.next != null; i++) {
			temp = temp.next;
		}

		newItem.next = temp.next;
		temp.next = newItem;
	}

	@Override
	public void removeByItemId(int id) {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		if (head.itemId == id) {
			head = head.next;
			System.out.println("Item removed");
			return;
		}
		ItemNode temp = head;
		while (temp.next != null && temp.next.itemId != id) {
			temp = temp.next;
		}
		if (temp.next == null) {
			System.out.println("Item not found");
			return;
		}
		temp.next = temp.next.next;
		System.out.println("Item removed");

	}

	@Override
	public void updateItemQuantity(int id, int quantity) {
		if (head == null) {
			System.out.println("List is empty ");
			return;
		}
		ItemNode updateQuantity = searchById(id);
		if (updateQuantity == null) {
			System.out.println("Item not found");
			return;
		}
		updateQuantity.quantity = quantity;

	}

	@Override
	public ItemNode searchByName(String name) {
		ItemNode temp = head;

		while (temp != null) {
			if (temp.itemName.equalsIgnoreCase(name))
				return temp;
			temp = temp.next;
		}
		System.out.println("Name Not Found ");
		return null;

	}

	@Override
	public ItemNode searchById(int id) {
		ItemNode temp = head;

		while (temp != null) {
			if (temp.itemId == id)
				return temp;
			temp = temp.next;
		}
		System.out.println("Id Not Found");
		return null;
	}

	@Override
	public double totalValue() {
		if (head == null) {
			System.out.println("List Is empty");
			return 0;
		}
		double total = 0;
		ItemNode temp = head;
		while (temp != null) {
			total += temp.quantity * temp.price;
			temp = temp.next;
		}
		return total;
	}

	public static void main(String[] args) {

		InventoryManagement inventory = new InventoryManagementSystem();

		System.out.println("===== TEST 1: Remove from empty list =====");
		inventory.removeByItemId(1);

		System.out.println("\n===== TEST 2: Update quantity in empty list =====");
		inventory.updateItemQuantity(1, 10);

		System.out.println("\n===== TEST 3: Search in empty list =====");
		System.out.println(inventory.searchById(1)); // null
		System.out.println(inventory.searchByName("Pen"));// null

		System.out.println("\n===== TEST 4: Add first item (beginning) =====");
		inventory.addAtBeginning("Pen", 1, 10, 5.0);

		System.out.println("\n===== TEST 5: Add item at end =====");
		inventory.addAtEnd("Notebook", 2, 5, 40.0);

		System.out.println("\n===== TEST 6: Add item at beginning again =====");
		inventory.addAtBeginning("Pencil", 3, 20, 2.0);

		System.out.println("\n===== TEST 7: Add item at position (middle) =====");
		inventory.addAtPosition(2, "Eraser", 4, 15, 3.0);

		System.out.println("\n===== TEST 8: Add item at oversized position (end) =====");
		inventory.addAtPosition(10, "Scale", 5, 8, 10.0);

		System.out.println("\n===== TEST 9: Invalid position =====");
		inventory.addAtPosition(0, "Invalid", 99, 1, 1.0);

		System.out.println("\n===== TEST 10: Search by ID (exists) =====");
		ItemNode foundById = inventory.searchById(2);
		print(foundById);

		System.out.println("\n===== TEST 11: Search by ID (not exists) =====");
		print(inventory.searchById(100));

		System.out.println("\n===== TEST 12: Search by Name (exists) =====");
		ItemNode foundByName = inventory.searchByName("Pen");
		print(foundByName);

		System.out.println("\n===== TEST 13: Search by Name (not exists) =====");
		print(inventory.searchByName("Marker"));

		System.out.println("\n===== TEST 14: Update quantity (valid) =====");
		inventory.updateItemQuantity(1, 50);
		print(inventory.searchById(1));

		System.out.println("\n===== TEST 15: Update quantity (invalid ID) =====");
		inventory.updateItemQuantity(999, 10);

		System.out.println("\n===== TEST 16: Remove middle item =====");
		inventory.removeByItemId(4);

		System.out.println("\n===== TEST 17: Remove head item =====");
		inventory.removeByItemId(3);

		System.out.println("\n===== TEST 18: Remove last item =====");
		inventory.removeByItemId(5);

		System.out.println("\n===== TEST 19: Remove non-existing item =====");
		inventory.removeByItemId(777);

		System.out.println("\n===== TEST 20: Total inventory value =====");
		System.out.println("Total Value: " + inventory.totalValue());

		System.out.println("\n===== TEST 21: Remove remaining items =====");
		inventory.removeByItemId(1);
		inventory.removeByItemId(2);

		System.out.println("\n===== TEST 22: Total value on empty list =====");
		System.out.println("Total Value: " + inventory.totalValue());
	}

	private static void print(ItemNode item) {
		if (item == null) {
			System.out.println("Item not found");
			return;
		}
		System.out.println("ID: " + item.itemId + ", Name: " + item.itemName + ", Quantity: " + item.quantity
				+ ", Price: " + item.price);
	}

}
