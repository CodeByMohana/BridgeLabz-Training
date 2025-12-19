package com.controlflows;

import java.util.Scanner;

public class SumOfNaturalNumbers {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        if (number > 0) {
            System.out.println("The sum of "+ ((number * (number + 1)) / 2) + " natural numbers is " + number);
        }else{
            System.out.println("The number "+ number + " is not a natural number");
        }
        sc.close();
    }
}
