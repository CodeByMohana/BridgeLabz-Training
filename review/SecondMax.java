package com.reviewquestions;

public class SecondMax {
	public static void main(String[] args) {
		int [] arr = {1, 3, 5, 6, 9, 8};
		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		
		for(int i = 0 ; i < arr.length; i++) {
			if(firstMax < arr[i]) {
				secondMax = firstMax;
				firstMax = arr[i];
			}
			if(firstMax > arr[i] && secondMax < arr[i]) {
				secondMax = arr[i];
			}
			
		}
		System.out.println("First Max " + firstMax);
		System.out.println("Second Max " + secondMax);
	}
}
