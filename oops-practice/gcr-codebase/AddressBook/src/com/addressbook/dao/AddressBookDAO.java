package com.addressbook.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.addressbook.model.AddressBook;
import com.addressbook.model.Contact;

public class AddressBookDAO {
	Map<String, AddressBook> addressBooks = new HashMap<>();
	private Map<String, List<Contact>> cityMap = new HashMap<>();
	private Map<String, List<Contact>> stateMap = new HashMap<>();

	public boolean createAddressBook(String name) {
		String key = name.toLowerCase();
		if (addressBooks.containsKey(key))
			return false;
		addressBooks.put(key, new AddressBook(name));
		return true;
	}

	public AddressBook getAddressBook(String name) {
		return addressBooks.get(name);
	}

	public Map<String, AddressBook> getAllAddressBooks() {
		return addressBooks;
	}

	public List<Contact> getContactsByCity(String city) {
		return cityMap.getOrDefault(city.toLowerCase(), new ArrayList<>());
	}

	public List<Contact> getContactsByState(String state) {
		return stateMap.getOrDefault(state.toLowerCase(), new ArrayList<>());
	}

	public void addToCityIndex(Contact contact) {
		String city = contact.getCity().toLowerCase();
		cityMap.putIfAbsent(city, new ArrayList<>());
		cityMap.get(city).add(contact);
	}

	public void addToStateIndex(Contact contact) {
		String state = contact.getState().toLowerCase();
		stateMap.putIfAbsent(state, new ArrayList<>());
		stateMap.get(state).add(contact);
	}

	public void removeFromCityIndex(Contact contact) {
		String city = contact.getCity().toLowerCase();
		List<Contact> list = cityMap.get(city);
		if (list != null) {
			list.remove(contact);
			if (list.isEmpty())
				cityMap.remove(city);
		}
	}

	public void removeFromStateIndex(Contact contact) {
		String state = contact.getState().toLowerCase();
		List<Contact> list = stateMap.get(state);
		if (list != null) {
			list.remove(contact);
			if (list.isEmpty())
				stateMap.remove(state);
		}
	}

	public int getCountByCity(String city) {
		return cityMap.getOrDefault(city.toLowerCase(), new ArrayList<>()).size();
	}

	public int getCountByState(String state) {
		return stateMap.getOrDefault(state.toLowerCase(), new ArrayList<>()).size();
	}

}
