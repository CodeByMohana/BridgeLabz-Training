package com.scenariobased.juint.testcase;

public class Program {
	private double balance;

	public Program(double initialbalance) {
		this.balance = initialbalance;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Deposit amount must be positive");
		}
		balance += amount;
	}

	public void withdraw(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Withdrawal amount must be positive");
		}
		if (amount > balance) {
			throw new IllegalArgumentException("Insufficient funds for withdrawal");
		}
		balance -= amount;
	}

}
