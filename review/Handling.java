package com.reviewquestions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Handling {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		try {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			ans = num1 / num2;
			
		}catch(InputMismatchException e) {
			System.err.println("Enter input in integer format");
		}catch (ArithmeticException e) {
			System.err.println("num1 is not divisible by 0");
		}finally {
			System.out.println(ans);
			sc.close();
		}
	}
}
