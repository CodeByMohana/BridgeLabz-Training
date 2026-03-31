package com.oop.gcrcodebase.inheritance;

class BankAccount {
	int accountNumber;
	double balance;

	public BankAccount(int accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

}

class SavingsAccount extends BankAccount {
	double interestRate;

	public SavingsAccount(int accountNumber, double balance, double interestRate) {
		super(accountNumber, balance);
		this.interestRate = interestRate;
	}

	public void applyInterest() {
		balance += balance * interestRate / 100;
	}

	public void displayInfo() {
		System.out.println("Savings Account Number: " + accountNumber);
		System.out.println("Balance: ₹" + balance);
		System.out.println("Interest Rate: " + interestRate + "%");
		System.out.println();
	}

}

class CurrentAccount extends BankAccount {
	double withdrawlLimit;

	public CurrentAccount(int accountNumber, double balance, double withdrawlLimit) {
		super(accountNumber, balance);
		this.withdrawlLimit = withdrawlLimit;
	}

	public void withdraw(double amount) {
		if (amount <= withdrawlLimit && amount <= balance) {
			balance -= amount;
		} else {
			System.out.println("Withdrawal exceeds limit or insufficient balance.");
		}
	}

	public void displayInfo() {
		System.out.println("Checking Account Number: " + accountNumber);
		System.out.println("Balance: ₹" + balance);
		System.out.println("Withdrawl Limit: ₹" + withdrawlLimit);
		System.out.println();
	}
}

class FixedDeposit extends BankAccount{
	double depositAmount;
	int maturityPeriod; // in months

	

	public FixedDeposit(int accountNumber, double balance, double depositAmount, int maturityPeriod) {
		super(accountNumber, balance);
		this.depositAmount = depositAmount;
		this.maturityPeriod = maturityPeriod;
	}



	public void displayInfo() {
		System.out.println("Fixed Deposit Account Number: " + accountNumber);
		System.out.println("Balance: ₹" + balance);
		System.out.println("Deposit Amount: ₹" + depositAmount);
		System.out.println("Maturity Period: " + maturityPeriod + " months");
		System.out.println();
	}
}
public class BankAccountManagement {
	public static void main(String[] args) {
		SavingsAccount savings = new SavingsAccount(101, 5000, 4.5);
		savings.applyInterest();
		savings.displayInfo();

		CurrentAccount checking = new CurrentAccount(102, 3000, 1000);
		checking.withdraw(3500);
		checking.displayInfo();

		FixedDeposit fixedDeposit = new FixedDeposit(103, 10000, 20000, 12);
		fixedDeposit.displayInfo();
	}
}
