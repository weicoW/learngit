package com.charactor;

import com.pojo.Hero;

public class Support extends Hero implements AD,AP,Heal{

	@Override
	public void physicAttack() {
		
		System.out.println("����");
		
		
		
	}

	@Override
	public void magicAttack() {
		
		System.out.println("ħ��");
		
	}

	@Override
	public void heal() {
		System.out.println("����");
		
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
