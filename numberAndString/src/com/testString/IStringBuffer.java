package com.testString;

public interface IStringBuffer {

	public void append(String str) throws Throwable; // ׷���ַ���

	public void append(char c) throws Throwable; // ׷���ַ�

	public void insert(int pos, char b) throws Throwable; // ָ��λ�ò����ַ�

	public void insert(int pos, String b) throws Throwable; // ָ��λ�ò����ַ���

	public void delete(int start) throws Throwable; // �ӿ�ʼλ��ɾ��ʣ�µ�

	public void delete(int start, int end) throws Throwable; // �ӿ�ʼλ��ɾ������λ��-1

	public void reverse(); // ��ת

	public int length(); // ���س���
}
