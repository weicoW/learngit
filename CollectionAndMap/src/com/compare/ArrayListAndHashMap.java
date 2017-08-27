package com.compare;

import java.util.ArrayList;
import java.util.HashSet;

public class ArrayListAndHashMap {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		System.out.println("向list中插入两个9");
		list.add(9);
		list.add(9);
		System.out.println(list);
		HashSet<Integer> set = new HashSet<>();
		System.out.println("向set中插入两个9");
		set.add(9);
		set.add(9);
		System.out.println(set);
		HashSet<Integer> integers = getRandomNumber(50);
		System.out.println(integers);
	}
	
	public static HashSet<Integer> getRandomNumber(int length){
		HashSet<Integer> integers = new HashSet<>();
		for (int i = 0; integers.size() < length; i++) {
			int n = (int) (Math.random() * 10000);
			integers.add(n);
		}
		return integers;
	}
	
}
