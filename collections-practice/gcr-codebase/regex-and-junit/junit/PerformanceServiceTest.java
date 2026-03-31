package com.collections.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class PerformanceServiceTest {

	PerformanceService service = new PerformanceService();

	@Test
	@Timeout(value = 2, unit = TimeUnit.SECONDS)
	void testLongRunningTaskTimeout() throws InterruptedException {
		service.longRunningTask();
	}

	@Test
	@Timeout(value = 4, unit = TimeUnit.SECONDS)
	void testLongRunningTaskPasses() throws InterruptedException {
		String result = service.longRunningTask(); // call ONCE
		assertEquals("Done", result);
	}

}
