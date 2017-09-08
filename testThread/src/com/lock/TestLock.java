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
					log("�߳�����");
					log("��ͼռ�ж���lock");
					locked = lock.tryLock(1, TimeUnit.SECONDS);

					lock.lock();
					log("ռ�ж���lock");
					log("����ҵ�����");
					Thread.sleep(5000);
					log("��ʱ�ͷŶ��� lock�� ���ȴ�");
					condition.await();
					log("����ռ�ж��� lock��������5���ҵ�����");
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {

					log("�ͷŶ���lock");
					lock.unlock();

				}
				log("�߳̽���");
			}
		};
		t1.setName("�߳�1");
		t1.start();
		// t1����2��
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2
		// t2�߳�
		Thread t2 = new Thread() {
			@Override
			public void run() {
				boolean locked = false;
				try {
					log("�߳�����");
					log("��ͼռ�ж���lock");
					locked = lock.tryLock();

					lock.lock();
					log("ռ�ж���lock");
					log("����ҵ�����");
					Thread.sleep(5000);
					log("���ѵȴ��е��߳�");
					condition.signalAll();

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {

					log("�ͷŶ���:lock");
					lock.unlock();
				}
				log("�߳̽���");
			}
		};
		t2.setName("�߳�2");
		t2.start();
	}

	protected static void log(String msg) {
		System.out.format("%s %s %s %n", nowTime(), Thread.currentThread().getName(), msg);

	}

	private static String nowTime() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}

}
