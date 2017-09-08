package com.automic;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {

	//������������������1000���̣߳��Ƚ����Ľ��
	private static int value = 0;
	private static AtomicInteger atomicValue = new AtomicInteger();
	public static void main(String[] args) {
		Thread[] ts1 = new Thread[1000];
		Thread[] ts2 = new Thread[1000];
		for (int i = 0; i < ts1.length; i++) {
			Thread t1 = new Thread(){
				@Override
				public void run() {
					
					value++;
				}
			};
			t1.start();
			ts1[i] = t1;
		}
		for (Thread thread : ts1) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.printf("%d���߳̽���value++��value��ֵ���:%d%n", 1000,value);
		for (int i = 0; i < ts2.length; i++) {
			Thread t2 = new Thread(){
				@Override
				public void run() {
					atomicValue.incrementAndGet();
				}
			};
			t2.start();
			ts2[i] = t2;
		}
		for (Thread thread : ts2) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.printf("%d���߳̽���atomicValue.incrementAndGet();��atomicValue��ֵ���:%d%n", 1000,atomicValue.intValue());
	}
	
}
