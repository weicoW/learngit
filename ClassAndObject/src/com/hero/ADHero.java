package com.hero;

import com.pojo.Hero;

public class ADHero extends Hero{

	public static void main(String[] args) {
		ADHero bh = new ADHero();
		bh.name = "����";
		
		Hero h1 = new Hero();
		h1.name = "��ɪ";
		Hero h2 = new Hero();
		h2.name = "��Ī";
		
		bh.attack(h1);
		bh.attack(h1,h2);
				
		
		
	}

	private void attack(Hero... heros) {
		
		for (int i = 0; i < heros.length; i++) {
			System.out.print(name + "attacked" + heros[i].name + "\t");
		}
		System.out.println();
		
	}
	
}
