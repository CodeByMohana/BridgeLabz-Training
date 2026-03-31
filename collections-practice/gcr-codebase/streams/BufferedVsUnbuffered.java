package com.collections.streams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedVsUnbuffered {

	public static void main(String[] args) throws IOException {

		String source = "bigfile.txt";
		String dest1 = "normalCopy.txt";
		String dest2 = "bufferedCopy.txt";

		long start1 = System.nanoTime();

		FileInputStream fis1 = new FileInputStream(source);
		FileOutputStream fos1 = new FileOutputStream(dest1);

		byte[] buffer = new byte[4096];
		int bytesRead;

		while ((bytesRead = fis1.read(buffer)) != -1) {
			fos1.write(buffer, 0, bytesRead);
		}

		fis1.close();
		fos1.close();

		long end1 = System.nanoTime();
		System.out.println("Unbuffered Time: " + (end1 - start1) + " ns");

		long start2 = System.nanoTime();

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest2));

		while ((bytesRead = bis.read(buffer)) != -1) {
			bos.write(buffer, 0, bytesRead);
		}

		bis.close();
		bos.close();

		long end2 = System.nanoTime();
		System.out.println("Buffered Time: " + (end2 - start2) + " ns");
	}
}
