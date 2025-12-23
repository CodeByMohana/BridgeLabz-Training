package com.corejavapractice.gcrcodebase.methods;

import java.util.Scanner;

public class PositiveNegativeOrZero {
	public boolean isPositive(int n) {
		return n >= 0;
	}

	public boolean isEven(int n) {
		return n % 2 == 0;
	}

	public int compare(int a, int b) {
		return Integer.compare(a, b);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[5];
		PositiveNegativeOrZero p = new PositiveNegativeOrZero();
		System.out.println("Enter five numbers:  ");
		for (int i = 0; i < 5; i++) {
			System.out.print("Enter a number " + (i + 1) + ": ");
			nums[i] = sc.nextInt();
			if (p.isPositive(nums[i])) {
				System.out.print("Positive ");
				System.out.println(p.isEven(nums[i]) ? "Even" : "Odd");
			} else {
				System.out.println("Negative");
			}
		}

		int cmp = p.compare(nums[0], nums[4]);
		if (cmp == 0)
			System.out.println("First and Last are Equal");
		else if (cmp > 0)
			System.out.println("First is Greater");
		else
			System.out.println("Last is Greater");
		sc.close();
	}
}
