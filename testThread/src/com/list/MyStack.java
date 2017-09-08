package com.list;

import java.util.LinkedList;


public class MyStack<T> implements Stack<T> {
	
	LinkedList<T> list = new LinkedList<>();

	@Override
	public synchronized void push(T t) {
		while (list.size() >= 200) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notifyAll();
		list.add(t);
	}

	@Override
	public synchronized T pull() {
		while (list.size() <= 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notifyAll();
		return list.removeLast();
	}

	@Override
	public T peek() {
		return list.getLast();
	}
	


}
