package com.testLambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import com.hero.Hero;

public class TestAggregate {

	public static void main(String[] args) {
		Random random = new Random();
		ArrayList<Hero> heros = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			heros.add(new Hero("hero"+i, random.nextInt(1000), random.nextInt(100)));
		}
		System.out.println(heros);
		Search(heros,3);
		aggregateSearch(heros,3);
	}

	private static void aggregateSearch(ArrayList<Hero> heros, int i) {
		System.out.println("hp第三");
		heros.stream().sorted((h1,h2)->h1.hp <= h2.hp ? 1:-1).limit(i).skip(i-1).forEach(h->System.out.println(h));
		System.out.println("damage最小");
		Hero minHero = heros.stream().min((h1,h2)->h1.damage - h2.damage).get();
		System.out.println(minHero);
	}

	private static void Search(ArrayList<Hero> heros, int i) {
		Collections.sort(heros,new Comparator<Hero>() {

			@Override
			public int compare(Hero o1, Hero o2) {
				return (int) -(o1.hp - o2.hp);
			}
		} );
		System.out.println("hp第三");
		System.out.println(heros.get(i-1));
		
	}
	
}
