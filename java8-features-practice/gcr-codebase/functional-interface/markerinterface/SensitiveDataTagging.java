package com.java8practice.functionalinterface.markerinterface;

interface SensitiveData {
	// Marker interface - no methods
}

class UserAccount implements SensitiveData {
	private String username;
	private String password;

	public UserAccount(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserAccount{username='" + username + "', password='" + password + "'}";
	}
}

class BankAccount implements SensitiveData {
	private String accountNumber;
	private double balance;

	public BankAccount(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount{accountNumber='" + accountNumber + "', balance=" + balance + "}";
	}
}

class PublicInfo {
	private String info;

	public PublicInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "PublicInfo{info='" + info + "'}";
	}

}

class EncptionService {

	public static void process(Object obj) {
		if (obj instanceof SensitiveData) {
			System.out.println("Encrypting sensitive data: " + encrypt(obj.toString()));
		} else {
			System.out.println("No encryption needed for: " + obj);
		}
	}

	private static String encrypt(String data) {
		return "###ENCRYPTED###";
	}
}

public class SensitiveDataTagging {
	public static void main(String[] args) {
		UserAccount user = new UserAccount("john_doe", "password123");
		BankAccount bankAccount = new BankAccount("1234567890", 10000.50);
		PublicInfo publicInfo = new PublicInfo("This is public information.");

		EncptionService.process(user);
		EncptionService.process(bankAccount);
		EncptionService.process(publicInfo);
	}
}
