package com.scenariobased.juint.testcase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class UnitTest {
	@Test
	public void Test_Deposit_ValidAmount() {
		Program account = new Program(100);
		account.deposit(50);
		assertEquals(150, account.getBalance());
	}
	
	@Test
	public void Test_Deposit_NegativeAmount() {
		Program account = new Program(100);
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> account.deposit(-50));
		
		assertEquals("Deposit amount must be positive", exception.getMessage());
	}
	
	@Test
	public void Test_Withdraw_ValidAmount() {
		Program account = new Program(100);
		account.withdraw(50);
		assertEquals(50,  account.getBalance());
	}
	
	@Test
	public void Test_Withdraw_InsufficientFunds() {
		Program account = new Program(100);
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(200));
		
		assertEquals("Insufficient funds for withdrawal", exception.getMessage());
	}
}
