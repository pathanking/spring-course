package com.myorg;

public class Calculator {

	public int add(int x, int y) {
		return x + y;
	}

	public int sub(int x, int y) {
		return x - y;
	}

	public boolean isOdd(int num) {
		return num % 2 == 1;
	}

	public boolean isEven(int num) {
		return num % 2 == 0;
	}
}
