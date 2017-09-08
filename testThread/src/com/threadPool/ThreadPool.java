package com.threadPool;

import java.util.LinkedList;

public class ThreadPool {

	//�̳߳ش�С
	int threadPoolSize;
	//��������
	LinkedList<Runnable> tasks = new LinkedList<>();
	
	//��ʼ���̳߳�
	public ThreadPool() {
		threadPoolSize = 10;
		//�����߳�
		synchronized (tasks) {
			for (int i = 0; i < threadPoolSize; i++) {
				new ConsumeThread("�����������߳� " + i).start();
			}
		}
	}
	
	public void add(Runnable r){
		synchronized (tasks) {
			//�������
			tasks.add(r);
			//���ѵȴ��������߳�
			tasks.notifyAll();
		}
	}
	
	//�����߳�����
	class ConsumeThread extends Thread{
		public ConsumeThread(String name) {
			super(name);
		}
		Runnable task;
		
		@Override
		public void run() {
			System.out.println(this.getName()+"����");
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
					//ȡ�����񼯺��������
					task = tasks.removeLast();
					//û��������߳̿��Լ����������
					tasks.notifyAll();
				}
				System.out.println(this.getName()+"��ȡ�����񣬲�ִ��");
				task.run();
			}
		}
		
	}
	
}
