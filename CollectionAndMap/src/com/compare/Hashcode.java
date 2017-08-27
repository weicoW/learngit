package com.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hero.Hero;

public class Hashcode {

	public static void main(String[] args) {
//		List<Hero> heros = new ArrayList<>();
//		for (int i = 0; i < 2000000; i++) {
//			Hero h = new Hero("Hero "+i);
//			heros.add(h);
//		}
//		//顺序打乱
//		for (int i = 0; i < 10; i++) {
//			Collections.shuffle(heros);
//			long start = System.currentTimeMillis();
//			for (Hero hero : heros) {
//				if ("Hero 1000000".equals(hero.name)) {
//					System.out.println("找到了");
//					break;
//				}
//			}
//			long end = System.currentTimeMillis();
//			System.out.println("一共花了"+(end-start)+"毫秒");
//		}
		for (int i = 0; i < 10; i++) {
			int random = (int) (1+Math.random()*10);
			String rs = getRandomString(random);
			System.out.println(rs);
			int hashCode = hashcode(rs);
			System.out.println(hashCode);
		}
		
		
	}
	
	private static String getRandomString(int length) {
		
		char[] cs = new char[length];
		String pool = "qwertyuioplkjhgfdsazxcvbnm1QAZXSW23EDCVFR45TGBNHY67UJMKLOI890";
		for (int i = 0; i < cs.length; i++) {
			int random = (int) (Math.random()*62);
			cs[i] = pool.charAt(random);
		}
		return new String(cs);
	}

	public static int hashcode(String s){
		char cs[] = s.toCharArray();
		int hashCode = 0;
		int sum = 0;
		for (int i = 0; i < cs.length; i++) {
			sum += cs[i];
		}
		hashCode = sum*23;
		if (hashCode > 1999) {
			hashCode = hashCode % 2000;
		}
		if (hashCode < 0) {
			hashCode = Math.abs(hashCode);
		}
		return hashCode;
	}
	
}
