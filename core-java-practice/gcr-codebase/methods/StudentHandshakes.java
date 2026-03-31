package com.corejavapractice.gcrcodebase.methods;

import java.util.Scanner;

public class StudentHandshakes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of students: ");
		int students = sc.nextInt();
		int handshakes = calculateHandshakes(students);
		System.out.println("Maximum number of handshakes: " + handshakes);
		sc.close();
	}

	public static int calculateHandshakes(int n) {
		return (n * (n - 1)) / 2;
	}
}
