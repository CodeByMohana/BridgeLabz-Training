package com.controlflows;

import java.util.Scanner;

public class RocketLauncherWithWhileLoop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number for countdown: ");
		int counter = sc.nextInt();
		while (counter != 0) {
			System.out.println("Rocket launching in : " + counter--);
			if (counter == 0) {
				System.out.println("Rocket launched");
			}
		}
		sc.close();
	}
}
