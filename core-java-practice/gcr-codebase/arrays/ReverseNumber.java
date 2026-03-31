package com.corejavapractice.gcrcodebase.arrays;

import java.util.Scanner;

public class ReverseNumber {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int temp = number;
        int digits = 0;
        while(temp > 0){
            temp /= 10;
            digits++;
        }
        int[] arr = new int[digits];
        temp = number;
        for (int i = digits - 1; i >= 0; i--) {
            arr[i] = temp % 10;
            temp /= 10;
        }
        System.out.print("Reversed numbers: ");
        for (int i = digits - 1; i >= 0; i--) {
            System.out.print(arr[i]);
            
        }
        sc.close();
    }
}
