package com.collections.exceptions;

import java.io.FileInputStream;
import java.io.IOException;

public class InputOutputException {
	public static void main(String[] args) {
		FileInputStream file = null;
		try {
			file = new FileInputStream("data.txt");
			int ch;
			while ((ch = file.read()) != -1) {
				System.out.print((char) ch);
			}
		} catch (IOException e) {
			System.out.println("File not found");

		} finally {
			try {
				if (file != null) {
					file.close();
				}
			} catch (IOException e) {
				System.out.println("Error while closing the file");
			}

		}
	}
}
