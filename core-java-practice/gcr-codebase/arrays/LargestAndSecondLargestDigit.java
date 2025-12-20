package com.corejavapractice.gcrcodebase.arrays;

import java.util.Scanner;

public class LargestAndSecondLargestDigit {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of an array: ");
        int size = sc.nextInt();
        System.out.println("Ehter the elements: ");
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                min = max; 
                max = arr[i];
            }
            if(arr[i] < max && arr[i] > min){
                min = arr[i];
            }
        }
        System.out.println("Largest: " + max + " Second Largest: " + min);
        sc.close();

    }
}
