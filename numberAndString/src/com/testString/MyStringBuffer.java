package com.testString;

import java.lang.Thread.State;

import com.exception.IndexIsNagetiveException;
import com.exception.IndexIsOutofRangeException;

public class MyStringBuffer implements IStringBuffer{
	
	int capacity = 16;
	int length = 0;
	char[] value;
	public MyStringBuffer() {
		value = new char[capacity];
	}
	public MyStringBuffer(String str){
		if (null != str) {
			value = str.toCharArray();
		}
		
		if (capacity < str.length()) {
			capacity = value.length * 2;
		}
		
		if (capacity >= str.length()) {
			System.arraycopy(str.toCharArray(), 0, value, 0, str.length());
		}
		length = str.length();
	}

	@Override
	public void append(String str) throws Throwable {
		insert(length, str);
		
	}

	@Override
	public void append(char c) throws Throwable {
		append(String.valueOf(c));
		
	}

	@Override
	public void insert(int pos, char b) throws Throwable {
		insert(pos, String.valueOf(b));
		
	}

	@Override
	public void insert(int pos, String b) throws Throwable {
		// �жϲ���λ���Ƿ�Ϸ�
		if (pos < 0) {
			throw new IndexIsNagetiveException("�±�Ϊ��");
		}
		if (pos > length) {
			throw new IndexIsOutofRangeException("�±߳�����Χ");
		}
		if (null == b) {
			throw new NullPointerException();
		}
		while (length + b.length() > capacity) {
			capacity = (int) ((length + b.length()) * 1.5f);
			char [] newValue = new char[capacity];
			System.arraycopy(value, 0, newValue, 0, length);
			value = newValue;
		}
		
		char [] cs = b.toCharArray();
		//�Ȱ�ԭ�������������Ʋ�������鳤��
		System.arraycopy(value, pos, value, pos + cs.length, length - pos);
		//��������뵽ָ��λ��
		System.arraycopy(cs, 0, value, pos, cs.length);
		//�ı�����ĳ���
		length = length + cs.length;
		
	}
	
	//toString ����
	public String toString(){
		char [] newValue = new char[length];
		System.arraycopy(value, 0, newValue, 0, length);
		return new String(newValue);
	}

	@Override
	public void delete(int start) throws Throwable {
		if (start < 0) {
			throw new IndexIsNagetiveException("�±�Ϊ��");
		}
		delete(start,length);
	}

	@Override
	public void delete(int start, int end) throws Throwable {
		if (start < 0) {
			throw new IndexIsNagetiveException("�±�Ϊ��");
		}
		if (end > length) {
			end = length;
		}
		if (start >= end) {
			throw new IndexOutOfBoundsException("�±곬����Χ");
		}
		int len = end - start;
		if (len > 0) {
			System.arraycopy(value, len+start, value, start, length-end);
			length -=len;
		}
		
	}

	@Override
	public void reverse() {
		for (int i = 0; i < length/2; i++) {
			char temp = value[i];
			value[i] = value[length-i-1];
			value[length-i-1] = temp;
		}
		
	}

	@Override
	public int length() {
		
		return length;
	}

}
