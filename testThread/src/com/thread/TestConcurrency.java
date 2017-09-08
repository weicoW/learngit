package com.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hero.Hero;

//�߳�ͬ������
public class TestConcurrency {

	public static void main(String[] args) {
		final Object someObjct = new Object();
		final Hero hero = new Hero();
		hero.name = "garren";
		hero.hp = 10000;
		System.out.println(hero.name+"��ʼѪ����"+hero.hp);
		int n = 10000;
		Thread[] addThreads = new Thread[n];
		Thread[] attackThreads = new Thread[n];
		//n���߳�����
		for (int i = 0; i < n; i++) {
			Thread t = new Thread(){
				@Override
				public void run() {	
						hero.recover();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			t.start();
			addThreads[i] = t;
		}
		//n���̼߳���
		for (int i = 0; i < n; i++) {
			Thread t = new Thread(){
				@Override
				public void run() {
						hero.hurt();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			t.start();
			attackThreads[i] = t;
		}
		
		//�ȴ������߳̽���
		for (Thread thread : addThreads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//�ȴ������߳̽���
		for (Thread thread : attackThreads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.printf("%d�������̺߳�%d�������߳̽�����%n���׵�Ѫ������� %.0f%n", n,n,hero.hp);
		//���̰߳�ȫ��ת�����̰߳�ȫ��
		List<Integer> integers = new ArrayList<>();
		List<Integer> list = Collections.synchronizedList(integers);
		
		//��������
//		final Hero yaohu = new Hero();
//		yaohu.name = "yaohu";
//		final Hero google = new Hero();
//		google.name = "Google";
//		Thread yThread = new Thread(){
//			@Override
//			public void run() {
//				synchronized (yaohu) {
//					System.out.println("yThreadռ��yaohu");
//					//ͣһ�룬ʹ��һ���߳�ռ��google
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					System.out.println("yThread��ͼռ��Google");
//					System.out.println("yThread�ȴ���.....");
//					synchronized (google) {
//						System.out.println("yThreadռ��Google��do something...");
//					}
//				}
//			}
//		};
//		yThread.start();
//		Thread gThread = new Thread(){
//			@Override
//			public void run() {
//				synchronized (google) {
//					System.out.println("gThreadռ��Google");
//					//ͣ��1��
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					System.out.println("gThread��ͼռ��yaohu");
//					System.out.println("gThread�ȴ���....");
//					synchronized (yaohu) {
//						System.out.println("gThreadռ��yaohu��do something...");
//					}
//				}
//			}
//		};
//		gThread.start();
	}
	
}
