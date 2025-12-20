package com.corejavapractice.scenariobased;

import java.util.Scanner;

public class TheCoffeeCounterChronicles {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("----- Our Menu -----                --Price--");
		System.out.println("1.     Latte                           ₹130  ");
		System.out.println("2.   Cappuccino                        ₹150  ");
		System.out.println("3.     Coffee                          ₹100  ");
		System.out.println("4.    Hot Coffee                       ₹180  ");
		System.out.println("5.   Our Special                       ₹190  ");

		System.out.print("Enter the coffee you want (It's serial number): ");
		int choice = sc.nextInt();
		System.out.print("Enter the quantity: ");
		int quantity = sc.nextInt();
		int total = 0;
		int price = 0;
		switch (choice) {
		case 1:
			price = 130;
			break;
		case 2:
			price = 150;
			break;
		case 3:
			price = 100;
			break;
		case 4:
			price = 180;
			break;
		case 5:
			price = 190;
			break;
		default:
			System.out.println("Your Entered a number which is not in our menu");
			return;
		}
		int baseAmount = price * quantity;
		total = (baseAmount) + ((baseAmount) * 5) / 100;
		System.out.println("Your Total Bill: ₹" + total);

		sc.close();
	}

}
