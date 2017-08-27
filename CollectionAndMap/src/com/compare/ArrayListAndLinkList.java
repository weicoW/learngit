package com.compare;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListAndLinkList {

	public static void main(String[] args) {
		List<Integer> list;
//		//ʹ��ArrayList��������
//		list = new ArrayList<Integer>();
//		insertFirst(list,"ArrayList");
//		modify(list, "ArrayList");
//		//ʹ��LinkList��������
//		list = new LinkedList<Integer>();
//		insertFirst(list, "LinkList");
//		modify(list, "LinkList");
		//�ȽϺ����������
//		list = new ArrayList();
//		insertLast(list, "ArrayList");
//		list = new LinkedList<>();
//		insertLast(list, "LinkList");
		//�Ƚ��м��������
		list = new ArrayList<>();
		insertMin(list, "ArrayList",20000);
		list = new LinkedList<>();
		insertMin(list, "LinkList", 20000);
		
	}
	//���м�
	private static void insertMin(List<Integer> list, String type,int index) {

		int total = 100*1000;
		final int number = 5;
		//��ʼ������
		for (int i = 0; i < total; i++) {
			list.add(number);
		}
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			list.add(index, number);
		}
		long end = System.currentTimeMillis();
		System.out.format("��%s�ĵ�%d��λ�ò��ϲ���%d�����ݣ��ܹ���ʱ %d ����%n", type,index,total,(end-start));
		
	}
	//����������
	private static void insertLast(List<Integer> list, String type) {
		int total = 1000 * 10000;
		final int number = 5;
		//������������
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			list.add(number);
		}
		long end = System.currentTimeMillis();
		System.out.format("��%s���治���������ݣ��ܹ���ʱ %d ����%n", type,(end - start));
	}
	
	

	private static void modify(List<Integer> list, String type) {

		int index = 50000;
		int total = 100 * 1000;
		final int number = 5;
		//�����ʼ��
		for (int i = 0; i < total; i++) {
			list.add(number);
		}
		//��λ����
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			int n = list.get(index);
			n++;
			list.set(index, n);
		}
		long end = System.currentTimeMillis();
		System.out.format("%s�ĳ���Ϊ%d����λ����%d�����ݣ�ȡ������1���ٷŻ�ȥ%n �ظ�%d�飬�ܹ���ʱ %d ����%n",type,total,index,total,(end-start) );
		
	}

	private static void insertFirst(List<Integer> list, String type) {
		//ǰ�治����������
		int total = 1000 * 100;
		final int number = 5;
		//ǰ���������
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			list.add(0,number);
		}
		long end = System.currentTimeMillis();
		System.out.format("��%sǰ������%d�����ݣ��ܹ���ʱ%d����\n",type,total,(end-start) );
	}
	
	
	
}
