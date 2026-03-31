package com.collections.junit;

public class StringUtils {
	public String reverse(String str) {
		StringBuilder ans = new StringBuilder(str);
		return ans.reverse().toString();
	}

	public boolean isPalindrome(String str) {
		String reverse = reverse(str);
		return reverse.equals(str);
	}

	public String toUpperCase(String str) {
		return str.toUpperCase();
	}
}
