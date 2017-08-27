package com.testHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hero.Hero;

public class TestHashMap {

	public static void main(String[] args) {
		ArrayList<Hero> heros = new ArrayList<>();
		for (int i = 0; i < 3000000; i++) {
			int r = (int) (Math.random() * 10000);
			Hero hero = new Hero("hero-"+r);
			heros.add(hero);
		}
		performance(new ForSearch(heros),"for循环查找");
		performance(new MapSearch(heros),"map方法查找");
	}
	
	private static void performance(Sort sort, String type) {
		long start = System.currentTimeMillis();
		sort.serach();
		long end = System.currentTimeMillis();
		System.out.format("使用%s方式消耗%d毫秒%n",type,(end-start));
		
	}

	interface Sort{
		void serach();
	}
	
	static class MapSearch implements Sort{
		
		HashMap<String, List<Hero>> map = new HashMap<>();
		int count = 0;

		public MapSearch(ArrayList<Hero> heros) {
			for (Hero hero : heros) {
				List<Hero> list =  map.get(hero.name);
				if (list == null) {
					list = new ArrayList<>();
					map.put(hero.name, list);
				}
				list.add(hero);
			}
		}

		@Override
		public void serach() {
			//实际开发中，查找会查找很多次，初始化的工作不计算在查找方法内
//			for (Hero hero : heros) {
//				List<Hero> list =  map.get(hero.name);
//				if (list == null) {
//					list = new ArrayList<>();
//					map.put(hero.name, list);
//				}
//				list.add(hero);
//			}
			List<Hero> result = map.get("hero-5555");
			count = result.size();
			System.out.println("总共有"+count+"个hero-5555");
		}
		
	}
	
	static class ForSearch implements Sort{
		
		ArrayList<Hero> heros = new ArrayList<>();
		int count = 0;

		public ForSearch(ArrayList<Hero> heros) {
			this.heros = heros;
		}

		@Override
		public void serach() {
			for (int i = 0; i < heros.size(); i++) {
				if ("hero-5555".equals(heros.get(i).name)) {
					count++;
				}
			}
			System.out.println("总共有"+count+"个hero-5555");
		}
		
	}
	
}
