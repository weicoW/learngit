package com.MyHashMap;

import java.util.ArrayList;
import java.util.List;

import com.hero.Hero;

public class Test {

	public static void main(String[] args) {
		//在ArrayList中准备十万个Hero对象
		ArrayList<Hero> heros = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			int random = (int) (Math.random() * 10000);
			Hero hero = new Hero("hero-"+random);
			heros.add(hero);
		}
		Test test = new Test();
		performance(test.new MapSearch(heros),"MapSearch");
		performance(test.new ForSearch(heros),"ForSearch");
		
	}
	
	
	//查找性能比较
	private static void performance(Search search,String type) {
		long start = System.currentTimeMillis();
		search.search();
		long end = System.currentTimeMillis();
		System.out.format("使用%s的方式消耗%d毫秒%n",type,(end-start));
	}



	interface Search{
		void search();
		
	}
	
	class ForSearch implements Search{
		
		ArrayList<Hero> heros = new ArrayList<>();
		int count = 0;

		public ForSearch(ArrayList<Hero> heros) {
			this.heros = heros;
		}

		@Override
		public void search() {

			for (Hero hero : heros) {
				if ("hero-5555".equals(hero.name)) {
					count++;
				}
			}
			System.out.println("总共有"+count+"个hero-5555");
		}
		
	}
	
	class MapSearch implements Search{
		
		MyHashMap mhm = new MyHashMap();
		ArrayList<Hero> heros = new ArrayList<>();
		int count = 0;

		public MapSearch(ArrayList<Hero> heros) {
			this.heros = heros;
			for (Hero hero : heros) {
				List<Hero> list = (List<Hero>) mhm.get(hero.name);
				if (null == list) {
					list = new ArrayList<>();
					mhm.put(hero.name, list);
				}
				list.add(hero);
			}
		
		}
		
		@Override
		public void search() {
			List<Hero> result = (List<Hero>) mhm.get("hero-5555");
			count = result.size();
			System.out.println("总共有"+count+"个hero-5555");
			
		}
		
	}
	
}
