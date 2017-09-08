package com.threadPool;

import java.util.LinkedList;

public class ThreadPool {

	//线程池大小
	int threadPoolSize;
	//任务容器
	LinkedList<Runnable> tasks = new LinkedList<>();
	
	//初始化线程池
	public ThreadPool() {
		threadPoolSize = 10;
		//启动线程
		synchronized (tasks) {
			for (int i = 0; i < threadPoolSize; i++) {
				new ConsumeThread("任务消费者线程 " + i).start();
			}
		}
	}
	
	public void add(Runnable r){
		synchronized (tasks) {
			//添加任务
			tasks.add(r);
			//唤醒等待的任务线程
			tasks.notifyAll();
		}
	}
	
	//消费线程启动
	class ConsumeThread extends Thread{
		public ConsumeThread(String name) {
			super(name);
		}
		Runnable task;
		
		@Override
		public void run() {
			System.out.println(this.getName()+"启动");
			while (true) {
				synchronized (tasks) {
					while (tasks.isEmpty()) {
						try {
							tasks.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					//取出任务集合里的任务
					task = tasks.removeLast();
					//没有任务的线程可以继续添加任务
					tasks.notifyAll();
				}
				System.out.println(this.getName()+"获取到任务，并执行");
				task.run();
			}
		}
		
	}
	
}
