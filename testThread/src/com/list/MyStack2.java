package com.list;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//使用lock对象实现线程安全
public class MyStack2<T> implements Stack<T> {

	LinkedList<T> list = new LinkedList<>();
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	@Override
	public void push(T t) {

		try {
			lock.lock();

			while (list.size() >= 200) {
				condition.await();
			}
			condition.signalAll();
			list.addLast(t);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			lock.unlock();

		}
	}

	@Override
	public T pull() {
		T t = null;

		try {
			lock.lock();

			while (list.size() <= 0) {
				condition.await();
			}
			condition.signalAll();
			t = list.removeLast();

		} catch (Exception e) {

		} finally {

			lock.unlock();

		}
		return t;
	}

	@Override
	public T peek() {

		return list.getLast();
	}

}
