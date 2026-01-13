package com.collections.junit;

public class PerformanceService {

	String longRunningTask() throws InterruptedException {
		Thread.sleep(3000); // 3 seconds
		return "Done";
	}
}
