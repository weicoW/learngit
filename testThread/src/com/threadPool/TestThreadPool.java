package com.threadPool;

import java.io.File;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {
	
	//static ThreadPool pool = new ThreadPool();
	static ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
	public static void main(String[] args) {
		//自定义线程池
//		ThreadPool pool = new ThreadPool();
//		int sleep = 1000;
//		while(true) {
//			Runnable task = new Runnable() {
//				
//				@Override
//				public void run() {
//					//System.out.println("执行任务");
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			};
//			pool.add(task);
//			try {
//				Thread.sleep(sleep);
//				sleep = sleep>100?sleep-100:sleep;
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		//Java自带线程池
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
//		executor.execute(new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println("任务一");
//				
//			}
//		});
		//查找文件内容
		File folder = new File("E:\\project");
		search(folder,"name");
		
	}

	private static void search(File srcFile, String search) {
		if (srcFile.isFile()) {
			if (srcFile.getName().toLowerCase().endsWith(".java")) {
				SearchFileTask task = new SearchFileTask(srcFile,search);
				//pool.add(task);
				executor.execute(task);
			}
		}
		if (srcFile.isDirectory()) {
			File[] files = srcFile.listFiles();
			for (File file : files) {
				search(file, search);
			}
		}
		
	}
	
}
