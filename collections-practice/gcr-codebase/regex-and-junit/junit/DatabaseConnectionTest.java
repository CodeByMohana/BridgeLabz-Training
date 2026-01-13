package com.collections.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DatabaseConnectionTest {

	DatabaseConnection db;

	@BeforeEach
	void setUp() {
		db = new DatabaseConnection();
		db.connect();
	}

	@AfterEach
	void tearDown() {
		db.disconnect();
	}

	@Test
	void testConnectionIsEstablished() {
		assertTrue(db.isConnected());
	}

	@Test
	void testConnectionIsClosedAfterEachTest() {
		assertTrue(db.isConnected());
	}

}
