package com.testFile;

import java.io.File;
import java.util.Date;

import javax.sound.midi.Synthesizer;

public class TestFile {

	public static void main(String[] args) {
		getMaxFileAndMinFile();
		
//		File f1 = new File("lolFolder");
//		System.out.println(f1.getAbsolutePath());
//		File f2 = new File(f1,"LOL.exe");
//		System.out.println(f2.getAbsolutePath());
//		//当前文件名
//		System.out.println(f1);
//		//是否存在文件
//		System.out.println(f1.exists());
//		//判断是否为文件夹
//		
//		File file = new File("d:/HBuilder");
//		System.out.println(file.exists());
//		//判断是否为文件夹
//		System.out.println(file.isDirectory());
//		//判断是否为文件
//		System.out.println(file.isFile());
//		//获取文件长度
//		System.out.println(file.length());
//		long time = file.lastModified();
//		Date date = new Date(time);
//		System.out.println(date);
		
		//字符形式返回文件夹下所有文件
//		String [] ss = file.list();
//		for (String string : ss) {
//			System.out.println(string);
//		}
		//以文件数组形式返回当下文件夹所有文件
//		File [] fs = file.listFiles();
//		for (File file2 : fs) {
//			System.out.println(file2);
//		}
		//字符串形式返回所在文件夹
//		System.out.println(file.getParent());
//		//创建文件夹
//		f1.mkdir();
//		System.out.println(f1.exists());
	}

	private static void getMaxFileAndMinFile() {

		File file = new File("c:/windows");
		File[] fs = file.listFiles();
		File max = null;
		File min = null;
		
//		for (int i = 0; i < fs.length; i++) {
//			
//			for (int j = 0; j < fs.length-i-1; j++) {
//				if (fs[j].length() > fs[j+1].length()) {
//					File temp = fs[j];
//					fs[j] = fs[j+1];
//					fs[j+1] = temp;
//				}
//			}
//		}
		for (int i = 0; i < fs.length-1; i++) {
			if (fs[i].length() > fs[i+1].length()) {
				max = fs[i];
				if (fs[i+1].length() != 0) {
					min = fs[i+1];
				}
			}
		}
		System.out.println("the max file is:"+max+"文件大小是"+max.length());
		System.out.println("the min file is:"+min+"文件大小是"+min.length());
		
	}	
}
