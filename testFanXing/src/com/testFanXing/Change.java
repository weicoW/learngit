package com.testFanXing;

import java.util.ArrayList;

import charactor.ADHero;
import charactor.Hero;

public class Change {

	public static void main(String[] args) {
		ArrayList<? super Hero> heros = new ArrayList<>();
		ArrayList<ADHero> adHeros = new ArrayList<>();
		//���෺��Ҳ����ת��Ϊ���෺��
		//adHeros = heros;
		Hero hero = new Hero();
		Object object = new Object();
		heros.add(hero);
		
	}
	
}
