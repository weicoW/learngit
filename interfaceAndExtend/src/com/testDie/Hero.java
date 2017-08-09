package com.testDie;

public class Hero {

	private String name;
	private float hp;
	
	public static void main(String[] args) {
		Hero hero = new Hero();
		hero.name = "gan";
		APHero apHero = new APHero();
		ADHero adHero = new ADHero();
		APADHero apadHero = new APADHero();
		hero.kill(apHero);
		hero.kill(adHero);
		hero.kill(apadHero);
		
	}
	
	public static void battleWin(){
		
		System.out.println("hero battle win");
	}
	
	public void kill(Mortal m){
		
		m.die();
	}
	
}
