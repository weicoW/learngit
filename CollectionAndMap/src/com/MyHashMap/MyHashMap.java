package com.MyHashMap;

import java.util.LinkedList;

import com.compare.Hashcode;

public class MyHashMap implements IHashMap{
	
	Object[] os = new Object[2000];
	
	public static void main(String[] args) {
		MyHashMap hashMap = new MyHashMap();
		hashMap.put("12", "ab");
		hashMap.put("12", "cd");
		System.out.println(hashMap.get("12"));
		System.out.println(hashMap.get("12"));
	}

	@Override
	public void put(String key, Object object) {
		int hashCode = Hashcode.hashcode(key);
		if (null == os[hashCode]) {
			Entry entry = new Entry(key, object);
			LinkedList<Entry> entries = new LinkedList<>();
			entries.addFirst(entry);
			os[hashCode] = entries;
		}else {
			LinkedList<Entry> entries = (LinkedList<Entry>) os[hashCode];
			Entry entry = new Entry(key, object);
			entries.add(entry);
			
		}
		
	}

	@Override
	public Object get(String key) {
		int hashCode = Hashcode.hashcode(key);
		if (null == os[hashCode]) {
			return null;
		}else {
			LinkedList<Entry> entries = (LinkedList<Entry>) os[hashCode];
			for (Entry entry : entries) {
				if (entry.key.equals(key)) {
					return entry.value;
				}
			}
			return null;
		}
		
	}

	
	
}
