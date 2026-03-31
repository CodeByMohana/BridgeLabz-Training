package com.java8practice.functionalinterface.defaultmethod;

interface PaymentProcessor {

	void pay(double amount);

	default void refund(double amount) {
		System.out.println("Refund not supported for this provider.");
	}
}

class UpiPayment implements PaymentProcessor {

	@Override
	public void pay(double amount) {
		System.out.println("Paid ₹" + amount + " using UPI");
	}
}

class WalletPayment implements PaymentProcessor {

	@Override
	public void pay(double amount) {
		System.out.println("Paid ₹" + amount + " using Wallet");
	}
}

class CreditCardPayment implements PaymentProcessor {

	@Override
	public void pay(double amount) {
		System.out.println("Paid ₹" + amount + " using Credit Card");
	}

	@Override
	public void refund(double amount) {
		System.out.println("Refunded ₹" + amount + " to Credit Card");
	}
}

public class PaymentGateway {
	public static void main(String[] args) {

		PaymentProcessor upi = new UpiPayment();
		PaymentProcessor card = new CreditCardPayment();

		upi.pay(1000);
		upi.refund(1000); // default

		card.pay(2000);
		card.refund(2000); // overridden
	}
}
