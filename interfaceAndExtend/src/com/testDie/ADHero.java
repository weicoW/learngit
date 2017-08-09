package com.testDie;

public class ADHero extends Hero implements Mortal {

	@Override
	public void die() {
		System.out.println("ADHero die");
		
	}
	
	public static void battleWin(){
		
		System.out.println("ad hero battle win");
	}
	
	public static void main(String[] args) {
		
		Hero h = new ADHero();
		h.battleWin();
		
		Hero.battleWin();
		ADHero.battleWin();
	}

}
