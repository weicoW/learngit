package com.testCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestCollection {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		System.out.println("ԭ��������");
		System.out.println(list);
		Collections.reverse(list);
		System.out.println("��ת������");
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println("�����������");
		System.out.println(list);
		System.out.println("����������");
		Collections.sort(list);
		System.out.println(list);
		System.out.println("4��9�±꽻�����ݺ�ļ�������");
		Collections.swap(list, 4, 9);
		System.out.println(list);
		System.out.println("���������������2����λ�������");
		Collections.rotate(list, 2);
		System.out.println(list);
		//System.out.println("ת��Ϊ�̰߳�ȫ��list");
		//List<Integer> synchronizedList = (List<Integer>) Collections.synchronizedCollection(list);
		
		List<Integer> number = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < 10; i++) {
			number.add(i);
		}
		for (int i = 0; i < 1000000; i++) {
			Collections.shuffle(number);
			if (number.get(0) == 3 || number.get(0) == 1|| number.get(0) == 4) {
				count++;
			}
			if (number.get(1) == 3 || number.get(1) == 1|| number.get(1) == 4) {
				count++;
			}
			if (number.get(2) == 3 || number.get(2) == 1|| number.get(2) == 4) {
				count++;
			}
		}
		System.out.println(count);
		double frequency = count/1000000d;
		System.out.println("Ƶ��Ϊ:"+frequency);
	}
	
}
