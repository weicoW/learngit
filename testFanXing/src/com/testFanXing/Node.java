package com.testFanXing;

import java.util.ArrayList;
import java.util.List;

import charactor.Hero;

/**
 * ���Ͷ�����ʵ��
 * @author weico
 *
 */
public class Node<T extends Comparable<T>> {

	public Node<T> left;
	public Node<T> right;
	
	public T value;
	
	//��������
	public void add(T t){
		if (null == value) {
			value = t;
		}else {
			if (t.compareTo(value) <= 0) {
				if(null == left)
					left = new Node<T>();
				left.add(t);
			}else {
				if (null == right) {
					right = new Node<T>();
				}
				right.add(t);
			}
		}
	}
	//��������
	public List<T> values(){
		List<T> list = new ArrayList<>();
		if (null != left) {
			list.addAll(left.values());
		}
		list.add(value);
		if (null != right) {
			list.addAll(right.values());
		}
		return list;
	}
	public static void main(String[] args) {
		int randoms[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };
		Node<Integer> node = new Node<>();
		for (int i : randoms) {
			node.add(i);
		}
		System.out.println(node.values());
		Hero hero = new Hero();
		Node<Hero> node2 = new Node<>();
	}
	
}
