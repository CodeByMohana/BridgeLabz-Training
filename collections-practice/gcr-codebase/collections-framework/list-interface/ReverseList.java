package com.collections.framework.listinterface;

import java.util.LinkedList;

public class ReverseList {

	public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list) {
		LinkedList<Integer> reversed = new LinkedList<>();

		for (Integer value : list) {
			reversed.addFirst(value);
		}
		return reversed;
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		list = reverseLinkedList(list);
		System.out.println(list); // [5, 4, 3, 2, 1]
	}
}
