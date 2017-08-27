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
		//hashMap������null��Ϊkey����value
		hashMap.put(null, "312");
		//HashTable������Null��Ϊkey��value
		//hashtable.put(null, "fsdfs");
		hashMap.put("adc","����Ӣ��");
		hashMap.put("apc", "ħ��Ӣ��");
		hashMap.put("t", "̹��");
		System.out.println(hashMap);
		rever(hashMap);
	}

	//��תhashMap����ֵ
	private static void rever(HashMap<String, String> hashMap) {

		HashMap< String, String> newHashMap = new HashMap<>();
		for (String key : hashMap.keySet()) {
			newHashMap.put(hashMap.get(key), key);
		}
		System.out.println(newHashMap);
		
	}
	
	
	
}
