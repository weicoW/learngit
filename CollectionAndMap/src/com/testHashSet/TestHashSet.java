package com.testHashSet;

import java.util.HashSet;
import java.util.Iterator;

import javax.swing.text.AbstractDocument.LeafElement;

public class TestHashSet {

	public static void main(String[] args) {
		HashSet<Integer> hashSet = new HashSet<>();
		
//		for (int i = 0; i < 20; i++) {
//			hashSet.add(i);
//		}
//		for (Integer integer : hashSet) {
//			System.out.println(integer);
//		}
//		for (Iterator iterator = hashSet.iterator(); iterator.hasNext();) {
//			Integer integer = (Integer) iterator.next();
//			System.out.println(integer);
//		}
		getRandomStringArray(100);
	}

	private static void getRandomStringArray(int length) {
		String[] stringArray = new String[100];
		String pool = "zxcvbnmlkjhgfdsaqwertyuiop1234056987MNBVCXZASDFGHJKLQWERTYUIOP";
		for (int i = 0; i < stringArray.length; i++) {
			char[] cs = new char[2];
			for (int j = 0; j < cs.length; j++) {
				int random = (int) (Math.random() * 62);
				cs[j] = pool.charAt(random);
			}
			stringArray[i] = new String(cs);
		}
		for (int i = 0; i < stringArray.length; i++) {
			System.out.print(stringArray[i]+"\t");
			if ((i+1)%10 == 0 && i != 0) {
				System.out.println();
			}
		}
		HashSet<String> originSet = new HashSet<>();
		HashSet<String> resultSet = new HashSet<>();
		for (int i = 0; i < stringArray.length; i++) {
			int originSize = originSet.size();
			originSet.add(stringArray[i]);
			if (originSet.size() == originSize) {
				resultSet.add(stringArray[i]);
			}
		}
		System.out.format("总共有%d种重复的字符,分别是%n",resultSet.size());
		for (String string : resultSet) {
			System.out.print(string+"\t");
		}
	}
	
	
	
}
