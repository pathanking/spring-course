package com.myorg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

	static Calculator calculator;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		calculator = new Calculator();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	@DisplayName("should test add method")
	void testAdd() {
		int actual = calculator.add(2, 5);
		assertEquals(7, actual);
	}

	@Test
	@DisplayName("should test sub method")
	void testSub() {
		int actual = calculator.sub(5, 2);
		assertEquals(3, actual);
	}

	@ParameterizedTest
	@ValueSource(ints = { 11, 3, 5, 7, 9 })
	@DisplayName("should test isOdd method")
	void testIsOdd(int num) {
		boolean actual = calculator.isOdd(num);
		assertTrue(actual);
	}

	@Test
	@DisplayName("should test isEven method")
	void testIsEven() {
		boolean actual = calculator.isEven(6);
		assertTrue(actual);
	}
}
