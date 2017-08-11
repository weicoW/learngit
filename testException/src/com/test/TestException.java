package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestException {

	public static void main(String[] args) {

		try {
			File f = new File("d:/lol.exe");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse("2017/08/09");
			new FileInputStream(f);
		} catch (FileNotFoundException | ParseException e) {

			if (e instanceof FileNotFoundException) {
				System.out.println("没找到文件");
			}
			if (e instanceof ParseException) {
				System.out.println("日期转换异常");
			}
			e.printStackTrace();
			
		}

		System.out.println("next");
		System.out.println(method());
	}
	
	public static int method(){
		
		try {
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 2;
		}finally {
			return 3;
		}
	
	}
	
	public static void method1(){
		
		try {
			method2();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void method2() throws Throwable {
		File f = new File("d:/LOL.exe");
		new FileInputStream(f);
		
	}

}
