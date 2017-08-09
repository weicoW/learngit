package com.hero;

import com.pojo.Hero;

public class Support extends Hero{

	public void heal(){
		System.out.println("治疗加血");
	}
	
	public void heal(int hp,Hero...heros){
		for (int i = 0; i < heros.length; i++) {
			System.out.println("为"+heros[i].name+"英雄增加"+hp+"血量");
		}
		
	}
	
	public static void main(String[] args) {
		
		Support sp = new Support();
		sp.name = "文姬";
		Hero hero = new Hero();
		hero.name = "诸葛亮";
		sp.heal();
		sp.heal(700, hero);
		
	}

}
