package com.controlflows;

import java.util.Scanner;

public class CheckSpring {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Month: ");
		int month = sc.nextInt();
		System.out.print("Enter the day: ");
		int day = sc.nextInt();
		boolean isSpring = (month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20);
		if (isSpring)
			System.out.println("Spring Season");
		else
			System.out.println("Not Spring Season");
		sc.close();
	}

}
