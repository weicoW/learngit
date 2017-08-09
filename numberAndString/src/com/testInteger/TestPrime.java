package com.testInteger;

public class TestPrime {

	public static void main(String[] args) {

		int n = 10000000;
		int count = 0;
		for (int i = 2; i <= n; i++) {
			if (isprime(i)) {
				count++;
			}

		}
		System.out.println("有" + count + "个质数");
	}

	private static boolean isprime(int i) {

		for (int j = 2; j <= Math.sqrt(i) + 1; j++) {
			if (i % j == 0) {
				return false;
			}
		}
		return true;
	}

}
