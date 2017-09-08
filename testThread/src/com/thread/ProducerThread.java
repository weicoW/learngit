package com.thread;

import com.list.MyStack;

public class ProducerThread extends Thread {
	
	private MyStack<Character> stack;

	public ProducerThread(MyStack<Character> stack,String name) {
		super(name);
		this.stack = stack;
	}
	@Override
	public void run() {
		while(true){
			char randomChar = (char) (Math.random() * 26 + 'A');
			System.out.println(this.getName()+"ѹ�룺"+randomChar);
			stack.push(randomChar);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
