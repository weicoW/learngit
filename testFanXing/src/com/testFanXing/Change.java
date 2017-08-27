package com.testFanXing;

import java.util.ArrayList;

import charactor.ADHero;
import charactor.Hero;

public class Change {

	public static void main(String[] args) {
		ArrayList<? super Hero> heros = new ArrayList<>();
		ArrayList<ADHero> adHeros = new ArrayList<>();
		//父类泛型也不能转换为子类泛型
		//adHeros = heros;
		Hero hero = new Hero();
		Object object = new Object();
		heros.add(hero);
		
	}
	
}
