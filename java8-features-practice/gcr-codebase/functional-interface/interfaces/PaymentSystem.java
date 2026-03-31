package com.java8practice.functionalinterface.interfaces;

interface PaymentMethod {
	void pay(double amount);
}

class CreditCardPayment implements PaymentMethod {

	private String cardNumber;

	public CreditCardPayment(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public void pay(double amount) {
		System.out.println("Paid ₹" + amount + " using Credit Card: " + cardNumber);
	}

}

class UpiPayment implements PaymentMethod {

	private String upiId;

	public UpiPayment(String upiId) {
		this.upiId = upiId;
	}

	@Override
	public void pay(double amount) {
		System.out.println("Paid ₹" + amount + " using UPI: " + upiId);
	}
}

class WalletPayment implements PaymentMethod {

	private double balance;

	public WalletPayment(double balance) {
		this.balance = balance;
	}

	@Override
	public void pay(double amount) {
		if (balance >= amount) {
			balance -= amount;
			System.out.println("Paid ₹" + amount + " using Wallet. Remaining: ₹" + balance);
		} else {
			System.out.println("Insufficient wallet balance");
		}
	}
}

class PaymentService {
	public void processService(PaymentMethod method, double amount) {
		method.pay(amount);
	}
}

public class PaymentSystem{
	public static void main(String[] args) {
		
		PaymentService service = new PaymentService();
		
		PaymentMethod upi = new UpiPayment("abc@upi");
		PaymentMethod card = new CreditCardPayment("1234-5678-9999");
		PaymentMethod wallet = new WalletPayment(5000);
		
		service.processService(wallet, 1500);
		service.processService(card, 2000);
		service.processService(upi, 1000);
		
	}
}
