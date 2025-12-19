package com.controlflows;

import java.util.Scanner;

public class YoungestAndTallest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the height and age of Amar: ");
		System.out.print("Enter the age: ");
		int amarAge = sc.nextInt();
		System.out.print("Enter the height: ");
		double amarHeight = sc.nextInt();
		System.out.println("Enter the height and age of Akbar: ");
		System.out.print("Enter the age: ");
		int akbarAge = sc.nextInt();
		System.out.print("Enter the height: ");
		double akbarHeight = sc.nextInt();
		System.out.println("Enter the height and age of Antony: ");
		System.out.print("Enter the age: ");
		int antonyAge = sc.nextInt();
		System.out.print("Enter the height: ");
		double antonyHeight = sc.nextInt();

		String youngest = "";
		int minAge = amarAge;

		youngest = "Amar";
		if (akbarAge < minAge) {
			minAge = akbarAge;
			youngest = "Akbar";
		}
		if (antonyAge < minAge) {
			minAge = antonyAge;
			youngest = "Anthony";
		}

		String tallest = "";
		double maxHeight = amarHeight;

		tallest = "Amar";
		if (akbarHeight > maxHeight) {
			maxHeight = akbarHeight;
			tallest = "Akbar";
		}
		if (antonyHeight > maxHeight) {
			maxHeight = antonyHeight;
			tallest = "Anthony";
		}

		System.out.println("\nThe youngest friend is: " + youngest + " (Age: " + minAge + ")");
		System.out.println("The tallest friend is: " + tallest + " (Height: " + maxHeight + " cm)");

		sc.close();

	}

}
