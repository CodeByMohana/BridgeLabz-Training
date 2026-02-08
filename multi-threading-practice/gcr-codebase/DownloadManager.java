package com.multithreading;

import java.util.Random;

class FileDownloaderThread extends Thread {
	private String fileName;
	private Random random = new Random();

	public FileDownloaderThread(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 100; i += 25) {
				System.out.println("[" + getName() + "] Downloading " + fileName + ": " + i + "%");
				Thread.sleep(200 + random.nextInt(400));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class DownloadManager {
	public static void main(String[] args) throws Exception {

		Thread t1 = new FileDownloaderThread("Document.pdf");
		Thread t2 = new FileDownloaderThread("Image.jpg");
		Thread t3 = new FileDownloaderThread("Video.mp4");

		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();

		System.out.println("All downloads complete!");

	}

}
