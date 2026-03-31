package com.collections.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ListManagerTest {

	ListManager manager = new ListManager();

	@Test
	void testAddElement() {
		List<Integer> list = new ArrayList<>();
		manager.addElement(list, 10);
		assertEquals(1, manager.getSize(list));
	}

	@Test
	void testRemoveElement() {
		List<Integer> list = new ArrayList<>(List.of(10, 20, 30));
		manager.removeElement(list, 10);
		assertFalse(list.contains(10));
	}

	@Test
	void testGetSize() {
		List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
		assertEquals(3, manager.getSize(list));
	}
}
