package com.compare;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class HashMapAndHashTable {

	public static void main(String[] args) {
		HashMap<String, String> hashMap = new HashMap<>();
		Hashtable<String, String> hashtable = new Hashtable<>();
		//hashMap可以用null作为key或者value
		hashMap.put(null, "312");
		//HashTable不能用Null作为key和value
		//hashtable.put(null, "fsdfs");
		hashMap.put("adc","物理英雄");
		hashMap.put("apc", "魔法英雄");
		hashMap.put("t", "坦克");
		System.out.println(hashMap);
		rever(hashMap);
	}

	//翻转hashMap键和值
	private static void rever(HashMap<String, String> hashMap) {

		HashMap< String, String> newHashMap = new HashMap<>();
		for (String key : hashMap.keySet()) {
			newHashMap.put(hashMap.get(key), key);
		}
		System.out.println(newHashMap);
		
	}
	
	
	
}
