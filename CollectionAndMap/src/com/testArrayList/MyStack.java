package com.testArrayList;

import java.util.LinkedList;

import com.hero.Hero;

public class MyStack implements Stack{
	
	LinkedList<Hero> heros = new LinkedList<>();
	int length = 0;

	@Override
	public void push(Hero h) {
		
		heros.add(h);
		length = heros.size();
	}

	@Override
	public Hero pull() {
		Hero hero = heros.removeLast();
		length = heros.size();
		return hero;
	}

	@Override
	public Hero peek() {
		return heros.getLast();
	}
	
	

}
