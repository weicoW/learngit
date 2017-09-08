package com.lock;

import com.list.MyStack2;

public class ConsumerThread extends Thread {

	private MyStack2<Character> stack;
	
	public ConsumerThread(MyStack2<Character> stack,String name) {
		super(name);
		this.stack = stack;
	}
	
	@Override
	public void run() {
		while (true) {
			char c = stack.pull();
			System.out.println(this.getName()+"µ¯³ö£º"+c);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
