package com.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestCalendar {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		//��calendar�������ڵ�ʱ��
		System.out.println("��ǰ���ڣ�"+sdf.format(date));
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		System.out.println("�¸��µĽ��죺"+sdf.format(calendar.getTime()));
		
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, 1);
		System.out.println("һ���Ľ���"+sdf.format(calendar.getTime()));
		
		calendar.setTime(date);
		calendar.add(Calendar.MONDAY, -1);
		calendar.set(Calendar.DATE, 3);
		System.out.println("�ϸ��µĵ����죺"+sdf.format(calendar.getTime()));
		
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 2);
		calendar.set(Calendar.DATE,-3);
		System.out.println("�¸��µĵ��������죺"+sdf.format(calendar.getTime()));
		
	}
	
	
}
