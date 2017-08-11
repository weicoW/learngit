package com.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTime {

	public static void main(String[] args) {
//		Date date = new Date();
//		System.out.println(date);
//		System.out.println(date.getTime());
//		Date zero = new Date(0);
//		System.out.println(zero);
		//getRandomDate();
		//dateFormat();
		dateSort();
	}
	
	//���1995����������
	public static Date getRandomDate(){
		
		long second = 1000;
		long minute = second * 60;
		long hour = minute * 60;
		long day = hour * 24;
		long year = day * 365;
		long yearStart = (2000-1970) * year;
		long leapDay = (2000-1970)/4 * day;//�������յ�ʱ��
		yearStart += leapDay;
		long eightHour = hour * 8;//�й��͸�������ʱ���ʱ���
		yearStart -= eightHour;
		Date start = new Date(yearStart);
		//System.out.println("1995�꿪ʼ��ʱ�䣺"+start);
		long yearEnd = yearStart + year -1;
		Date end = new Date(yearEnd);
		//System.out.println("1995�����ʱ��:"+end);
		long randomTime = (long) (Math.random() * yearEnd);
		Date randomdate = new Date(randomTime);
		//System.out.println("1995�����ʱ��"+randomdate);
		return randomdate;
	}
	
	public static void dateFormat(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yy-MM-dd");
		Date date = new Date();
		System.out.println(sdf.format(date));
		System.out.println(sdf1.format(date));
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
		String dateString = "2017/08/09";
		Date date1;
		try {
			date1 = sdf2.parse(dateString);
			System.out.println(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
//	׼��һ��������9����������
//	ʹ��1970��-2000��֮���������ڳ�ʼ��������
//	������Щ���ڵ�ʱ�������������
//	���� 1988-1-21 12:33:22 �ͻ����� 1978-4-21 19:07:23 ǰ�棬��Ϊ����ʱ���С����Ȼ���ڸ��� 
	public static void dateSort(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String [] dates = new String[9];
		//����ǰ��ʼ������
		for (int i = 0; i < dates.length; i++) {
			dates[i] = sdf.format(getRandomDate());
			System.out.print(dates[i]+"\t");
			if ((i+1)%3 == 0) {
				System.out.println();
			}
		}
		
		//����ʱ���ַ����ĺ�������������
		for (int i = 0; i < dates.length; i++) {
			for (int j = 0; j < dates.length-i-1; j++) {
				try {
					if (sdf.parse(dates[j]).getTime() < sdf.parse(dates[j+1]).getTime()) {
						String temp = dates[j];
						dates[j] = dates[j+1];
						dates[j+1] = temp;
					} 
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		System.out.println("���������");
		for (int i = 0; i < dates.length; i++) {
			System.out.print(dates[i]+"\t");
			if ((i+1)%3 == 0) {
				System.out.println();
			}
		}
		
	}
}
