package com.lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				boolean locked = false;
				try {
					log("线程启动");
					log("试图占有对象：lock");
					locked = lock.tryLock(1, TimeUnit.SECONDS);

					lock.lock();
					log("占有对象lock");
					log("五秒业务操作");
					Thread.sleep(5000);
					log("临时释放对象 lock， 并等待");
					condition.await();
					log("重新占有对象 lock，并进行5秒的业务操作");
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {

					log("释放对象：lock");
					lock.unlock();

				}
				log("线程结束");
			}
		};
		t1.setName("线程1");
		t1.start();
		// t1运行2秒
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2
		// t2线程
		Thread t2 = new Thread() {
			@Override
			public void run() {
				boolean locked = false;
				try {
					log("线程启动");
					log("试图占有对象：lock");
					locked = lock.tryLock();

					lock.lock();
					log("占有对象lock");
					log("五秒业务操作");
					Thread.sleep(5000);
					log("唤醒等待中的线程");
					condition.signalAll();

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {

					log("释放对象:lock");
					lock.unlock();
				}
				log("线程结束");
			}
		};
		t2.setName("线程2");
		t2.start();
	}

	protected static void log(String msg) {
		System.out.format("%s %s %s %n", nowTime(), Thread.currentThread().getName(), msg);

	}

	private static String nowTime() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}

}
