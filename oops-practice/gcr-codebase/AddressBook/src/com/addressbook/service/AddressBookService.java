package com.addressbook.service;

import java.util.Set;

import com.addressbook.dao.AddressBookDAO;
import com.addressbook.model.AddressBook;
import com.addressbook.model.Contact;

public class AddressBookService {
	private AddressBookDAO addressBookDAO = new AddressBookDAO();

	private String contactKey(String fn, String ln) {
		return (fn + "-" + ln).toLowerCase();
	}

	public boolean createAddressBook(String name) {
		return addressBookDAO.createAddressBook(name);
	}

	public boolean addContact(String bookName, Contact contact) {
		AddressBook book = addressBookDAO.getAddressBook(bookName.toLowerCase());
		if (book == null)
			return false;

		if (book.getContacts().containsValue(contact))
			return false;

		book.getContacts().put(contactKey(contact.getFirstName(), contact.getLastName()), contact);
		addressBookDAO.addToCityIndex(contact);
		addressBookDAO.addToStateIndex(contact);
		return true;
	}

	public boolean editContact(String bookName, String fn, String ln, String address, String city, String state,
			String zip, String phone, String email) {

		AddressBook book = addressBookDAO.getAddressBook(bookName.toLowerCase());
		if (book == null)
			return false;

		Contact contact = book.getContacts().get(contactKey(fn, ln));
		if (contact == null)
			return false;

		addressBookDAO.removeFromCityIndex(contact);
		addressBookDAO.removeFromStateIndex(contact);

		contact.setAddress(address);
		contact.setCity(city);
		contact.setState(state);
		contact.setZip(zip);
		contact.setPhoneNumber(phone);
		contact.setEmail(email);

		addressBookDAO.addToCityIndex(contact);
		addressBookDAO.addToStateIndex(contact);

		return true;
	}

	public boolean deleteContact(String bookName, String fn, String ln) {

		AddressBook book = addressBookDAO.getAddressBook(bookName.toLowerCase());
		if (book == null)
			return false;

		String key = contactKey(fn, ln);
		Contact contact = book.getContacts().get(key);

		if (contact == null)
			return false;

		addressBookDAO.removeFromCityIndex(contact);
		addressBookDAO.removeFromStateIndex(contact);

		book.getContacts().remove(key);

		return true;
	}

	public AddressBook getAddressBook(String name) {
		return addressBookDAO.getAddressBook(name.toLowerCase());
	}

	public Set<String> getAllAddressBookNames() {
		return addressBookDAO.getAllAddressBooks().keySet();
	}

	public void searchByCityOrState(String location, boolean searchByCity) {

		boolean found = false;

		for (AddressBook book : addressBookDAO.getAllAddressBooks().values()) {

			for (Contact contact : book.getContacts().values()) {

				if (searchByCity && contact.getCity().equalsIgnoreCase(location)) {

					System.out.println(contact + " (AddressBook: " + book.getName() + ")");
					found = true;

				} else if (!searchByCity && contact.getState().equalsIgnoreCase(location)) {

					System.out.println(contact + " (AddressBook: " + book.getName() + ")");
					found = true;
				}
			}
		}

		if (!found) {
			System.out.println("No contacts found.");
		}
	}

	public void viewByCity(String city) {
		var list = addressBookDAO.getContactsByCity(city);

		if (list.isEmpty()) {
			System.out.println("No contacts found in this city.");
			return;
		}

		list.forEach(System.out::println);
	}

	public void viewByState(String state) {
		var list = addressBookDAO.getContactsByState(state);

		if (list.isEmpty()) {
			System.out.println("No contacts found in this state.");
			return;
		}

		list.forEach(System.out::println);
	}

	public void countByCity(String city) {
		int count = addressBookDAO.getCountByCity(city);

		if (count == 0) {
			System.out.println("No contacts found in this city.");
		} else {
			System.out.println("Total contacts in city '" + city + "' : " + count);
		}
	}

	public void countByState(String state) {
		int count = addressBookDAO.getCountByState(state);

		if (count == 0) {
			System.out.println("No contacts found in this state.");
		} else {
			System.out.println("Total contacts in state '" + state + "' : " + count);
		}
	}

}
