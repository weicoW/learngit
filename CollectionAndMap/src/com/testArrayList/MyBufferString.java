package com.testArrayList;

import java.util.ArrayList;

public class MyBufferString implements IStringBuffer {

	ArrayList<Character> value = new ArrayList<Character>();
	int length = 0;

	public MyBufferString() {

	}

	public MyBufferString(String str) {
		if (null != str ) {
			char[] cs = str.toCharArray();
			for (char c : cs) {
				value.add(c);
			}
		}
		length = value.size();
	}

	@Override
	public void append(String str) {
		insert(length, str);

	}

	@Override
	public void append(char c) {
		append(String.valueOf(c));

	}

	@Override
	public void insert(int pos, char b) {
		insert(pos, String.valueOf(b));
	}

	@Override
	public void insert(int pos, String b) {
		//判断下标是否合法
		if (pos < 0) {
			return;
		}
		if (null == b) {
			return;
		}
		//下标超出范围
		if (pos > length) {
			return;
		}
		char[] cs = b.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			value.add(pos+i, cs[i]);
		}
		length = value.size();
		
	}

	@Override
	public void delete(int start) {
		for (int i = start; i < length; i++) {
			value.remove(i);
		}

	}

	@Override
	public void delete(int start, int end) {
		for (int i = start; i < end; i++) {
			value.remove(i);
		}

	}

	@Override
	public void reverse() {
		for (int i = 0; i < length/2; i++) {
			char temp = value.get(i);
			value.set(i, value.get(length-i-1));
			value.set(length-i-1, temp);
		}

	}

	@Override
	public int length() {
		return length;
	}
	
	public String toString(){
		char[] cs = new char[value.size()];
		for (int i = 0; i < cs.length; i++) {
			cs[i] = value.get(i);
		}
		return new String(cs);
	}

}
