package com.multithreading;

class BankAccount {
	private int balance = 10000;

	public synchronized boolean withdraw(String customer, int amount) {
		System.out.println("[" + customer + "] Attempting to withdraw " + amount);

		if (balance >= amount) {
			balance -= amount;

			System.out.println("Transaction successful: " + customer + ", Amount: " + amount + ", Balance: " + balance);
			return true;
		} else {
			System.out.println("Transaction FAILED: " + customer + ", Insufficient balance");
			return false;
		}
	}
}

class Transaction implements Runnable {

	private BankAccount account;
	private int amount;

	public Transaction(BankAccount account, int amount) {
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void run() {
		account.withdraw(Thread.currentThread().getName(), amount);

	}

}

public class BankingSystem {
	public static void main(String[] args) {
		BankAccount account = new BankAccount();
		int[] amounts = { 3000, 4000, 2000, 5000, 1500 };

		for (int i = 0; i < amounts.length; i++) {
			Thread t = new Thread(new Transaction(account, amounts[i]), "Customer-" + (i + 1));
			System.out.println(t.getName() + " state: " + t.getState());
			t.start();
		}
	}
}
