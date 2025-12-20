package com.corejavapractice.scenariobased;

import java.util.Scanner;

public class TheCoffeeCounterChronicles {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("----- Our Menu -----                --Price--");
		System.out.println("1.     Latte                           $13   ");
		System.out.println("2.   Cappuccino                        $15   ");
		System.out.println("3.     Coffee                          $10   ");
		System.out.println("4.    Hot Coffee                       $18   ");
		System.out.println("5.   Our Special                       $19   ");

		System.out.print("Enter the coffee you want (It's serial number): ");
		int choice = sc.nextInt();
		System.out.print("Enter the quantity: ");
		int quantity = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Your Total Bill: $" + 13 * quantity);
		case 2:
			System.out.println("Your Total Bill: $" + 15 * quantity);
		case 3:
			System.out.println("Your Total Bill: $" + 10 * quantity);
		case 4:
			System.out.println("Your Total Bill: $" + 18 * quantity);
		case 5:
			System.out.println("Your Total Bill: $" + 19 * quantity);
		default:
			System.out.println("Your Entered a number which is not in our menu");
		}

		sc.close();
	}

}
