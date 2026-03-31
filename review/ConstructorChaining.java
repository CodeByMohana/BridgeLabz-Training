package com.reviewquestions;

public class ConstructorChaining {
	String name;
	String id;

	public ConstructorChaining() {
		name = null;
		id = null;
	}

	public ConstructorChaining(String name, String id) {
		this();
	}

}

class constructor extends ConstructorChaining {

	public constructor(String name, String id) {
		super(name, id);
	}

}
