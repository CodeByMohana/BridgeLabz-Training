package com.collections.streams;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageToByteArray {

	public static void main(String[] args) {

		String inputImage = "input.jpg";
		String outputImage = "output.jpg";

		try {
			FileInputStream fis = new FileInputStream(inputImage);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			int data;
			while ((data = fis.read()) != -1) {
				baos.write(data);
			}

			byte[] imageBytes = baos.toByteArray();

			ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
			FileOutputStream fos = new FileOutputStream(outputImage);

			while ((data = bais.read()) != -1) {
				fos.write(data);
			}

			fis.close();
			fos.close();

			System.out.println("Image copied successfully");

		} catch (IOException e) {
			System.out.println("Error occurred");
		}
	}
}
