package com.controlflows;

import java.util.Scanner;

public class OddOrEven {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = sc.nextInt();
		if (num > 0) {
			for (int i = 1; i <= num; i++) {
				if (i % 2 == 0) {
					System.out.println("Even Number: " + i);
				} else {
					System.out.println("Odd number: " + i);
				}
			}
		}
		sc.close();
	}
}
