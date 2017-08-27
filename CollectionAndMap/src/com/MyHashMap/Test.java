package com.MyHashMap;

import java.util.ArrayList;
import java.util.List;

import com.hero.Hero;

public class Test {

	public static void main(String[] args) {
		//��ArrayList��׼��ʮ���Hero����
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
	
	
	//�������ܱȽ�
	private static void performance(Search search,String type) {
		long start = System.currentTimeMillis();
		search.search();
		long end = System.currentTimeMillis();
		System.out.format("ʹ��%s�ķ�ʽ����%d����%n",type,(end-start));
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
			System.out.println("�ܹ���"+count+"��hero-5555");
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
			System.out.println("�ܹ���"+count+"��hero-5555");
			
		}
		
	}
	
}
