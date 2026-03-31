package com.addressbook.model;

import java.util.HashMap;
import java.util.Map;

public class AddressBook {
	private String name;
	private Map<String, Contact> contacts = new HashMap<>();

	public AddressBook(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Map<String, Contact> getContacts() {
		return contacts;
	}
}
