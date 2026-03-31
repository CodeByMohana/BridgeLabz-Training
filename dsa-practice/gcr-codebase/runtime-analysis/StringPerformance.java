package com.dsapractice.runtimeanalysis;

public class StringPerformance {

	public static void main(String[] args) {

		int n = 10000;

		// Using String
		long start = System.nanoTime();
		String s = "";
		for (int i = 0; i < n; i++) {
			s = s + "a";
		}
		long end = System.nanoTime();
		System.out.println("String Time: " + (end - start) + " ns");

		// Using StringBuilder
		start = System.nanoTime();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append("a");
		}
		end = System.nanoTime();
		System.out.println("StringBuilder Time: " + (end - start) + " ns");

		// Using StringBuffer
		start = System.nanoTime();
		StringBuffer sf = new StringBuffer();
		for (int i = 0; i < n; i++) {
			sf.append("a");
		}
		end = System.nanoTime();
		System.out.println("StringBuffer Time: " + (end - start) + " ns");
	}
}
