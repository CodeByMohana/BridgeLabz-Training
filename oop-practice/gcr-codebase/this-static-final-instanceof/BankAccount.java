package com.oop.gcrcodebase.thisstaticinstanceof;

public class BankAccount {
	static String bankName = "BOB Bank";
	private static int totalAccounts = 0;

	private final String accountNumber;

	private String accountHolderName;

	public BankAccount(String accountNumber, String accountHolderName) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		totalAccounts++;
	}

	private static void getTotalAccounts() {
		System.out.println("Total Accounts: " + totalAccounts);
	}

	public void displayDetails() {
		if (this instanceof BankAccount) {
			System.out.println("Bank Name: " + bankName);
			System.out.println("Account Holder Name: " + accountHolderName);
			System.out.println("Account Number: " + accountNumber);
			System.out.println("------------------------------");
		} else {
			System.out.println("Invalid account object.");
		}
	}

// Main Method
	public static void main(String[] args) {
		BankAccount acc1 = new BankAccount("123561", "Rohan");
		BankAccount acc2 = new BankAccount("123562", "Rohit");

		acc1.displayDetails();
		acc2.displayDetails();

		BankAccount.getTotalAccounts();

	}

}
