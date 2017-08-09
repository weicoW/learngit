package com.testSuper;

import com.charactor.AD;

public class ADHero extends Hero implements AD{
	
	private String name ;
	 
	class BattleScore {
        int kill;
        int die;
        int assit;
 
        public void legendary() {
            if (kill >= 8)
                System.out.println(name + "超神！");
            else
                System.out.println(name + "尚未超神！");
        }
    }

	@Override
	public void physicAttack() {
		System.out.println("AD attack");	
		
	}
	
	public ADHero(String name){
		super();
		this.name = name;
		System.out.println("AD Hero 构造方法");
		
	}
	
	public String getSuperName(){
		
		return super.name;
	}
	
	public void adAttack(){
		System.out.println("adhero attack");
	}
	
	public static void main(String[] args) {
		ADHero adHero = new ADHero("YYP");
		ADHero hero = new ADHero("ganlun");
		BattleScore score = hero.new BattleScore();
		score.kill = 10;
		score.legendary();
		
		adHero.adAttack();
		
	}

	@Override
	public void attack() {
		System.out.println("ad attack");
		
	}
	
}
