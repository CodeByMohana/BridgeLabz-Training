package com.addressbook.presentation;

import java.util.Scanner;

import com.addressbook.service.AddressBookService;

public class AddressBookMain {
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");

		Scanner scanner = new Scanner(System.in);
		AddressBookService service = new AddressBookService();

		System.out.print("Enter First Name: ");
		String firstName = scanner.nextLine();

		System.out.print("Enter Last Name: ");
		String lastName = scanner.nextLine();

		System.out.print("Enter Address: ");
		String address = scanner.nextLine();

		System.out.print("Enter City: ");
		String city = scanner.nextLine();

		System.out.print("Enter State: ");
		String state = scanner.nextLine();

		System.out.print("Enter Zip: ");
		String zip = scanner.nextLine();

		System.out.print("Enter Phone Number: ");
		String phoneNumber = scanner.nextLine();

		System.out.print("Enter Email: ");
		String email = scanner.nextLine();

		service.addContact(firstName, lastName, address, city, state, zip, phoneNumber, email);
		System.out.println("Contact added succesfully!");

		System.out.print("Enter First Name of contact to edit: ");
		String nameToEdit = scanner.nextLine();

		System.out.print("Enter New Address: ");
		String newAddress = scanner.nextLine();

		System.out.print("Enter New City: ");
		String newCity = scanner.nextLine();

		System.out.print("Enter New State: ");
		String newState = scanner.nextLine();

		System.out.print("Enter New Zip: ");
		String newZip = scanner.nextLine();

		System.out.print("Enter New Phone Number: ");
		String newPhone = scanner.nextLine();

		System.out.print("Enter New Email: ");
		String newEmail = scanner.nextLine();

		boolean updated = service.editContact(nameToEdit, newAddress, newCity, newState, newZip, newPhone, newEmail);

		if (updated) {
			System.out.println("Contact updated successfully!");
		} else {
			System.out.println("Contact not found.");
		}

		System.out.print("Enter First Name of contact to delete: ");
		String nameToDelete = scanner.nextLine();

		boolean deleted = service.deleteContact(nameToDelete);

		if (deleted) {
			System.out.println("Contact deleted successfully!");
		} else {
			System.out.println("Contact not found.");
		}

		scanner.close();

	}

}
