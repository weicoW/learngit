package com.lock;

import com.list.MyStack2;

public class TestPAndC {

	public static void main(String[] args) {
		//String pool = "AZQSXWDCEFVRGTBHYNMJUIKLOP";
		//char ramdonChar = (char) (Math.random() * 26 + 'A');
		MyStack2<Character> myStack = new MyStack2<>();
		new ProducerThread(myStack, "Product1").start();
		new ProducerThread(myStack, "Product1").start();
		new ConsumerThread(myStack, "Consume1").start();
		new ConsumerThread(myStack, "Consume2").start();
		new ConsumerThread(myStack, "Consume3").start();
	}
	
}
