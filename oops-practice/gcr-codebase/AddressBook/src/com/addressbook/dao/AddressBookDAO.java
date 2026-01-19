package com.addressbook.dao;

import java.util.ArrayList;
import java.util.Iterator;

import com.addressbook.model.Contact;

public class AddressBookDAO {
	ArrayList<Contact> contactList = new ArrayList<>();

	public void addContact(Contact contact) {
		contactList.add(contact);
	}

	public boolean updateContactByFirstName(String firstName, String address, String city, String state, String zip,
			String phoneNumber, String email) {

		for (Contact contact : contactList) {
			if (contact.getFirstName().equalsIgnoreCase(firstName)) {
				contact.setAddress(address);
				contact.setCity(city);
				contact.setState(state);
				contact.setPhoneNumber(phoneNumber);
				contact.setEmail(email);

				return true;
			}
		}
		return false;
	}

	public boolean deleteContactByFirstName(String firstName) {
		Iterator<Contact> iterator = contactList.iterator();

		while (iterator.hasNext()) {
			Contact contact = iterator.next();
			if (contact.getFirstName().equalsIgnoreCase(firstName)) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}
}
