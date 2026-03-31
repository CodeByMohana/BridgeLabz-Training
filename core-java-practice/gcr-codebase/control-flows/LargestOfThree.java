package com.controlflows;

import java.util.Scanner;

public class LargestOfThree {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number1 = sc.nextInt();
        System.out.print("Enter a number: ");
        int number2 = sc.nextInt();
        System.out.print("Enter a number: ");
        int number3 = sc.nextInt();
        if (number1 > number2 && number1 > number3) {
            System.out.println("The first number is largest");
        } else if (number2 > number1 && number2 > number3) {
            System.out.println("The second number is largest");
        } else if (number3 > number1 && number3 > number2) {
            System.out.println("The third number is largest");
        } else {
            System.out.println("All are equal");
        }
        sc.close();
    }

}
