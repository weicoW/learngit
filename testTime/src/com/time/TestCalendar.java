package com.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestCalendar {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		//给calendar设置现在的时间
		System.out.println("当前日期："+sdf.format(date));
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		System.out.println("下个月的今天："+sdf.format(calendar.getTime()));
		
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, 1);
		System.out.println("一年后的今天"+sdf.format(calendar.getTime()));
		
		calendar.setTime(date);
		calendar.add(Calendar.MONDAY, -1);
		calendar.set(Calendar.DATE, 3);
		System.out.println("上个月的第三天："+sdf.format(calendar.getTime()));
		
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 2);
		calendar.set(Calendar.DATE,-3);
		System.out.println("下个月的倒数第三天："+sdf.format(calendar.getTime()));
		
	}
	
	
}
