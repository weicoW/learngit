package com.testArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hero.Hero;
import com.hero.Item;
import com.hero.LOL;

public class TestArrayList {

	public static void main(String[] args) {
		ArrayList<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 100; i++) {
			
			heros.add(new Hero("hero "+i));
			
		}
//		System.out.println(heros);
//		for (Hero hero : heros) {
//			if ("hero 1".equals(hero.name)) {
//				System.out.println(hero);
//			}
//		}
//		MyBufferString msb = new MyBufferString();
//		String s = "dnasfdasl";
//		msb.insert(0, s);
//		msb.reverse();
//		System.out.println(msb.toString());
//		List<LOL> lolList = new ArrayList<>();
//		lolList.add(new Hero());
//		lolList.add(new Item());
		//迭代器
//		Iterator<Hero> iterator = heros.iterator();
		//使用while遍历迭代器
//		while (iterator.hasNext()) {
//			Hero hero = iterator.next();
//			System.out.println(hero);
//		}
		//使用for遍历迭代器
//		for (Iterator<Hero> iterator2 = heros.iterator();iterator2.hasNext();) {
//			Hero hero = iterator2.next();
//			System.out.println(hero);
//		}
		for (int i = 0; i < heros.size(); i++) {
			if (i%8 == 0) {
				System.out.println(heros.get(i));
				heros.remove(i);
			}
		}
		for (int i = 0; i < heros.size(); i++) {
			System.out.println(heros.get(i));
		}
		
	}
	
}
