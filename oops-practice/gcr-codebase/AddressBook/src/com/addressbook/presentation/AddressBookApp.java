package com.addressbook.presentation;

import java.util.Scanner;
import java.util.Set;

import com.addressbook.model.AddressBook;
import com.addressbook.model.Contact;
import com.addressbook.service.AddressBookService;

public class AddressBookApp {

	private final Scanner scanner = new Scanner(System.in);
	private final AddressBookService service = new AddressBookService();

	public void start() {

		System.out.println("=================================");
		System.out.println("   Welcome to Address Book App");
		System.out.println("=================================");

		boolean running = true;

		while (running) {
			printMenu();
			int choice = readInt("Enter your choice");

			switch (choice) {

			case 1 -> createAddressBook();
			case 2 -> viewAllAddressBooks();
			case 3 -> addContact();
			case 4 -> editContact();
			case 5 -> deleteContact();
			case 6 -> displayContacts();
			case 7 -> service.searchByCityOrState(read("Enter City"), true);
			case 8 -> service.searchByCityOrState(read("Enter State"), false);
			case 9 -> service.viewByCity(read("Enter City"));
			case 10 -> service.viewByState(read("Enter State"));
			case 11 -> service.countByCity(read("Enter City"));
			case 12 -> service.countByState(read("Enter State"));

			case 13 -> {
				System.out.println("\nThank you for using Address Book. Goodbye!");
				running = false;
			}
			default -> System.out.println("❌ Invalid option. Please try again.");
			}
		}
	}

	// ================= MENU ACTIONS =================

	private void createAddressBook() {
		System.out.println("\n--- Create Address Book ---");
		String name = read("Enter Address Book name");

		boolean created = service.createAddressBook(name);
		System.out.println(created ? "Address Book '" + name + "' created successfully."
				: "Address Book '" + name + "' already exists.");
	}

	private void viewAllAddressBooks() {
		System.out.println("\n--- Available Address Books ---");

		Set<String> names = service.getAllAddressBookNames();

		if (names.isEmpty()) {
			System.out.println("ℹ️ No Address Books created yet.");
			return;
		}

		names.forEach(name -> System.out.println("• " + name));
	}

	private void addContact() {
		System.out.println("\n--- Add Contact ---");
		String bookName = read("Enter Address Book name");

		Contact contact = readContact();

		boolean added = service.addContact(bookName, contact);
		System.out.println(added ? "Contact added successfully."
				: "Failed to add contact. Address Book may not exist or contact is duplicate.");
	}

	private void editContact() {
		System.out.println("\n--- Edit Contact ---");
		String bookName = read("Enter Address Book name");
		String firstName = read("Enter First Name");
		String lastName = read("Enter Last Name");

		boolean updated = service.editContact(bookName, firstName, lastName, read("New Address"), read("New City"),
				read("New State"), read("New Zip"), read("New Phone"), read("New Email"));

		System.out.println(updated ? "Contact updated successfully." : "Contact or Address Book not found.");
	}

	private void deleteContact() {
		System.out.println("\n--- Delete Contact ---");
		String bookName = read("Enter Address Book name");
		String firstName = read("Enter First Name");
		String lastName = read("Enter Last Name");

		boolean deleted = service.deleteContact(bookName, firstName, lastName);
		System.out.println(deleted ? "Contact deleted successfully." : "Contact or Address Book not found.");
	}

	private void displayContacts() {
		System.out.println("\n--- Display Contacts ---");
		String bookName = read("Enter Address Book name");

		AddressBook book = service.getAddressBook(bookName);
		if (book == null) {
			System.out.println("Address Book not found.");
			return;
		}

		if (book.getContacts().isEmpty()) {
			System.out.println("No contacts available in this Address Book.");
			return;
		}

		System.out.println("\nContacts in '" + bookName + "':");
		book.getContacts().values().forEach(System.out::println);
	}

	// ================= HELPER METHODS =================

	private void printMenu() {
		System.out.println("\n------------ MENU ------------");
		System.out.println("1. Create Address Book");
		System.out.println("2. View All Address Books");
		System.out.println("3. Add Contact");
		System.out.println("4. Edit Contact");
		System.out.println("5. Delete Contact");
		System.out.println("6. Display Contacts");
		System.out.println("7. Search by City");
		System.out.println("8. Search by State");
		System.out.println("9. View Contacts by City");
		System.out.println("10. View Contacts by State");
		System.out.println("11. Count Contacts by City");
		System.out.println("12. Count Contacts by State");

		System.out.println("13. Exit");

	}

	private Contact readContact() {
		return new Contact(read("First Name"), read("Last Name"), read("Address"), read("City"), read("State"),
				read("Zip"), read("Phone"), read("Email"));
	}

	private String read(String label) {
		System.out.print(label + ": ");
		return scanner.nextLine();
	}

	private int readInt(String label) {
		System.out.print(label + ": ");
		int value = scanner.nextInt();
		scanner.nextLine(); // consume newline
		return value;
	}
}
