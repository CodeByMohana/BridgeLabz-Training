package com.collections.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringUtilsTest {

	StringUtils util = new StringUtils();

	@Test
	void testReverse() {
		assertEquals("cba", util.reverse("abc"));
	}

	@Test
	void testPalindrome() {
		assertTrue(util.isPalindrome("dad"));
	}

	@Test
	void testUpperCase() {
		assertEquals("ABC", util.toUpperCase("abc"));
	}
}
