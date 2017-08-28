package com.compare;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListAndLinkList {

	public static void main(String[] args) {
		List<Integer> list;
//		//使用ArrayList插入数据
//		list = new ArrayList<Integer>();
//		insertFirst(list,"ArrayList");
//		modify(list, "ArrayList");
//		//使用LinkList插入数据
//		list = new LinkedList<Integer>();
//		insertFirst(list, "LinkList");
//		modify(list, "LinkList");
		//比较后面插入数据
//		list = new ArrayList();
//		insertLast(list, "ArrayList");
//		list = new LinkedList<>();
//		insertLast(list, "LinkList");
		//比较中间插入数据
		//引用构造器初始化list
		insertMin(ArrayList::new, "ArrayList",20000);
		
		insertMin(LinkedList::new, "LinkList", 20000);
		
	}
	//在中间
	private static void insertMin(Supplier<List> s, String type,int index) {

		int total = 100*1000;
		final int number = 5;
		//初始化数组
		List<Integer> list = s.get();
		for (int i = 0; i < total; i++) {
			list.add(number);
		}
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			list.add(index, number);
		}
		long end = System.currentTimeMillis();
		System.out.format("在%s的第%d个位置不断插入%d个数据，总共耗时 %d 毫秒%n", type,index,total,(end-start));
		
	}
	//最后插入数据
	private static void insertLast(List<Integer> list, String type) {
		int total = 1000 * 10000;
		final int number = 5;
		//后面增加数据
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			list.add(number);
		}
		long end = System.currentTimeMillis();
		System.out.format("在%s后面不断增加数据，总共耗时 %d 毫秒%n", type,(end - start));
	}
	
	

	private static void modify(List<Integer> list, String type) {

		int index = 50000;
		int total = 100 * 1000;
		final int number = 5;
		//数组初始化
		for (int i = 0; i < total; i++) {
			list.add(number);
		}
		//定位数据
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			int n = list.get(index);
			n++;
			list.set(index, n);
		}
		long end = System.currentTimeMillis();
		System.out.format("%s的长度为%d，定位到第%d个数据，取出来加1，再放回去%n 重复%d遍，总共耗时 %d 毫秒%n",type,total,index,total,(end-start) );
		
	}

	private static void insertFirst(List<Integer> list, String type) {
		//前面不断增加数据
		int total = 1000 * 100;
		final int number = 5;
		//前面插入数据
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			list.add(0,number);
		}
		long end = System.currentTimeMillis();
		System.out.format("在%s前面增加%d条数据，总共耗时%d毫秒\n",type,total,(end-start) );
	}
	
	
	
}
