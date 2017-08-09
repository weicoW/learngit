package com.testInteger;

public class TestNumer {

	byte a = 0;
	short b = 2;
	int d = 5;
	float c = 4;
	
	Byte a2 = a;
	Short b2 = b;
	float c2 = c;
	Integer d2 = d;
	
	
	
	public static void main(String[] args) {
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Short.MAX_VALUE);
		
		int i = 5;
		
		Integer i2 = i;
		
//		double p = 3.14;
//		String p1 = String.valueOf(p);
//		int p2 = Integer.parseInt(p1); //数据格式异常
		
//		String q = "3.1a4";
//		float p2 = Float.parseFloat(q); //不能转
		
		String s = String.valueOf(i2);
		String s2 = i2.toString();
		System.out.println(s2);
		
	    int  n = Integer.MAX_VALUE;
		System.out.println(n);
		double d = Math.pow((1+1d/n), n);
		System.out.println(d);
		System.out.println(Math.E);
	}
	
}
