package com.thread;

import com.hero.Hero;
import com.list.MyStack;

public class TestMystack {

	public static void main(String[] args) {
		int n = 100;
		MyStack myStack = new MyStack();
		Thread[] pullThreads = new Thread[n];
		Thread[] pushThreads = new Thread[n];
		//多线程入栈
		for (int i = 0; i < n; i++) {
			final Hero h = new Hero();
			h.name = "hero name " + i;
			System.out.println("压入 hero:" + h.name);
			Thread t = new Thread(){
				@Override
				public void run() {
					myStack.push(h);
					
				}
			};
			t.start();
			pushThreads[i] = t;
		}
		//多线程弹栈
		for (int i = 0; i < n; i++) {
			Thread t = new Thread(){
				@Override
				public void run() {
					Hero h = (Hero) myStack.pull();
					System.out.println("弹出 hero" + h.name);
				}
			};
			t.start();
			pullThreads[i] = t;
		}
		for (Thread thread : pushThreads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (Thread thread : pullThreads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(myStack);
	}
	
}
