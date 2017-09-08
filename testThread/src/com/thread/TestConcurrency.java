package com.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hero.Hero;

//线程同步问题
public class TestConcurrency {

	public static void main(String[] args) {
		final Object someObjct = new Object();
		final Hero hero = new Hero();
		hero.name = "garren";
		hero.hp = 10000;
		System.out.println(hero.name+"初始血量是"+hero.hp);
		int n = 10000;
		Thread[] addThreads = new Thread[n];
		Thread[] attackThreads = new Thread[n];
		//n个线程增加
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
		//n个线程减少
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
		
		//等待增加线程结束
		for (Thread thread : addThreads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//等待减少线程结束
		for (Thread thread : attackThreads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量变成了 %.0f%n", n,n,hero.hp);
		//非线程安全类转换成线程安全类
		List<Integer> integers = new ArrayList<>();
		List<Integer> list = Collections.synchronizedList(integers);
		
		//测试死锁
//		final Hero yaohu = new Hero();
//		yaohu.name = "yaohu";
//		final Hero google = new Hero();
//		google.name = "Google";
//		Thread yThread = new Thread(){
//			@Override
//			public void run() {
//				synchronized (yaohu) {
//					System.out.println("yThread占有yaohu");
//					//停一秒，使另一个线程占有google
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					System.out.println("yThread试图占有Google");
//					System.out.println("yThread等待中.....");
//					synchronized (google) {
//						System.out.println("yThread占有Google，do something...");
//					}
//				}
//			}
//		};
//		yThread.start();
//		Thread gThread = new Thread(){
//			@Override
//			public void run() {
//				synchronized (google) {
//					System.out.println("gThread占有Google");
//					//停顿1秒
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					System.out.println("gThread试图占有yaohu");
//					System.out.println("gThread等待中....");
//					synchronized (yaohu) {
//						System.out.println("gThread占有yaohu，do something...");
//					}
//				}
//			}
//		};
//		gThread.start();
	}
	
}
