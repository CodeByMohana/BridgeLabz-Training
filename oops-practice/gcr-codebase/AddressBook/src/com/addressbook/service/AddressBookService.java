package com.addressbook.service;

import com.addressbook.dao.AddressBookDAO;
import com.addressbook.model.Contact;

public class AddressBookService {
	private AddressBookDAO addressBookDAO;

	public AddressBookService() {
		this.addressBookDAO = new AddressBookDAO();
	}

	public void addContact(String firstName, String lastName, String address, String city, String state, String zip,
			String phoneNumber, String email) {
		Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);

		addressBookDAO.addContact(contact);
	}

	public boolean editContact(String firstName, String address, String city, String state, String zip,
			String phoneNumber, String email) {
		return addressBookDAO.updateContactByFirstName(firstName, address, city, state, zip, phoneNumber, email);
	}

	public boolean deleteContact(String firstName) {
		return addressBookDAO.deleteContactByFirstName(firstName);
	}

}
