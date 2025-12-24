package com.corejavapractice.gcrcodebase.builtinfunctions;

import java.util.Scanner;

public class FibonacciGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int terms = getInput(scanner);
        printFibonacci(terms);
        scanner.close();
    }

    public static int getInput(Scanner scanner) {
        System.out.print("Enter number of terms: ");
        return scanner.nextInt();
    }

    public static void printFibonacci(int n) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Sequence: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }
}