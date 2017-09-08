package com.thread;

import com.list.MyStack;

public class TestPAndC {

	public static void main(String[] args) {
		//String pool = "AZQSXWDCEFVRGTBHYNMJUIKLOP";
		//char ramdonChar = (char) (Math.random() * 26 + 'A');
		MyStack<Character> myStack = new MyStack<>();
		new ProducerThread(myStack, "Product1").start();
		new ProducerThread(myStack, "Product1").start();
		new ConsumerThread(myStack, "Consume1").start();
		new ConsumerThread(myStack, "Consume2").start();
		new ConsumerThread(myStack, "Consume3").start();
	}
	
}
