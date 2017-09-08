package com.thread;

import java.io.File;
import java.io.FileReader;

public class FileThread {

	public static void main(String[] args) {
		File srcFile = new File("E:/project");
		String searchWord = "name";
		search(srcFile, searchWord);
	}

	private static void searchFile(File file, String searchWord) {
		char[] data = new char[(int) file.length()];
		try (FileReader reader = new FileReader(file)) {
			reader.read(data);
			String s = new String(data);
			if (s.contains(searchWord)) {
				System.out.println("找到子目标字符串" + searchWord + "，在文件:" + file.getAbsolutePath());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private static void search(File srcfile, String searchWord) {
		// 不是文件夹
		if (!srcfile.isDirectory()) {
			return;
		}
		// 文件夹不存在
		if (!srcfile.exists()) {
			return;
		}
		File[] files = srcfile.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				
				// 后缀是.java则创建线程遍历
				if (file.getName().toLowerCase().endsWith(".java")) {
					Thread thread = new Thread() {
						@Override
						public void run() {
							searchFile(file, searchWord);
						}
					};
					thread.start();
				}
				//searchFile(file, searchWord);
			}
			// 是文件夹
			if (file.isDirectory()) {
				File newFile = new File(srcfile.getAbsolutePath(),file.getName());
				search(newFile, searchWord);
			}
		}
	}

}
