package com.testArrayList;

import java.util.LinkedList;
import java.util.Queue;

import com.hero.Hero;

public class TestLinkList {

	public static void main(String[] args) {
//	    LinkedList<Hero> heros = new LinkedList<>();
//		heros.addLast(new Hero("hero 1"));
//		heros.addLast(new Hero("hero 2"));
//		heros.addLast(new Hero("hero 3"));
//		System.out.println(heros);
//		heros.addFirst(new Hero("hero X"));
//		System.out.println(heros);
//		System.out.println(heros.getFirst());
//		System.out.println(heros.getLast());
//		System.out.println(heros.removeLast());
//		System.out.println(heros);
		
		Queue<Hero> heros = new LinkedList<>();
		System.out.print("��ʼ��queue����:"+"\t");
		heros.offer(new Hero("hero 1"));
		heros.offer(new Hero("hero 2"));
		heros.offer(new Hero("hero 3"));
		System.out.println(heros);
		System.out.println("�ѵ�һ��Ԫ��poll��������");
		//ȡ����һ��Ԫ�أ�queue��FIFO�Ƚ��ȳ�ԭ��
		Hero hero = heros.poll();
		System.out.println(hero);
		System.out.print("ȡ����һ��Ԫ�غ�֮��Ķ��У�\t");
		System.out.println(heros);
		//�鿴��һ��Ԫ�أ�����ȡ����
		hero = heros.peek();
		System.out.println(hero);
		System.out.print("peek�����鿴Ԫ�ز����Ԫ��ȡ����:\t");
		System.out.println(heros);
		
		MyStack stack = new MyStack();
		stack.push(new Hero("hero1"));
		stack.push(new Hero("hero2"));
		for (int i = 0; i < stack.length; i++) {
			Hero hero3 = stack.peek();
			System.out.print(hero3.name);
		}
		for (int i = 0; i < stack.length; i++) {
			Hero hero2 = stack.pull();
			System.out.println(hero2.name);
		}
		
	} 
	
}
