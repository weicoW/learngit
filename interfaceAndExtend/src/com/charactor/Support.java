package com.charactor;

import com.pojo.Hero;

public class Support extends Hero implements AD,AP,Heal{

	@Override
	public void physicAttack() {
		
		System.out.println("物理");
		
		
		
	}

	@Override
	public void magicAttack() {
		
		System.out.println("魔法");
		
	}

	@Override
	public void heal() {
		System.out.println("治疗");
		
	}
	
	
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		AD.super.attack();
	}

	public static void main(String[] args) {
		
		Hero hero = new Hero();
		Support support = new Support();
		support.attack();
		
		hero = support;
		System.out.println(hero instanceof Support);
		
	}

	
	
}
