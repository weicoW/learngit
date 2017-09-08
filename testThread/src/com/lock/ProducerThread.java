package com.lock;

import com.list.MyStack2;

public class ProducerThread extends Thread {
	
	private MyStack2<Character> stack;

	public ProducerThread(MyStack2<Character> stack,String name) {
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
