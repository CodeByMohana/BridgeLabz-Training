package com.scenariobased.juint.testcase;

public class Main {

	public static void main(String[] args) {

		Program account = new Program(1000);

		System.out.println("Initial Balance: " + account.getBalance());

		// Deposit
		account.deposit(500);
		System.out.println("After Deposit: " + account.getBalance());

		// Withdraw
		account.withdraw(300);
		System.out.println("After Withdraw: " + account.getBalance());

		// Exception Demo
		try {
			account.deposit(-50);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			account.withdraw(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
