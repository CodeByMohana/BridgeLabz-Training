package com.collections.junit;

import java.util.List;

public class ListManager {
	void addElement(List<Integer> list, int element) {
		list.add(element);
	}

	void removeElement(List<Integer> list, int element) {
		list.remove(Integer.valueOf(element));
	}

	int getSize(List<Integer> list) {
		return list.size();
	}
}
