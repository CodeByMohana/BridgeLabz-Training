package com.java8practice.functionalinterface.markerinterface;

class Document implements Cloneable {
	private String title;
	private String content;

	public Document(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Documents [title=" + title + ", content=" + content + "]";
	}

}

public class CloneDemo {
	public static void main(String[] args) {
		Document original = new Document("Test Doc", "This is a test document.");

		try {
			Document copy1 = (Document) original.clone();
			copy1.setTitle("Cloned Doc 1");

			Document copy2 = (Document) original.clone();
			copy2.setTitle("Cloned Doc 2");

			System.out.println("Original: " + original);
			System.out.println("Copy 1: " + copy1);
			System.out.println("Copy 2: " + copy2);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

	}

}
