package com.test;

public class Hero {

	public String name;
	protected float hp;
	
	public void attackHero(Hero h) throws EnemyHeroIsDeadException{
		if (h.hp == 0.0) {
			throw new EnemyHeroIsDeadException(h.name + " 已经挂了,不许要施放技能");
		}
	}

	
	public static void main(String[] args) {
		Hero hero1 = new Hero();
		hero1.name = "aaa";
		hero1.hp = 123;
		Hero hero2 = new Hero();
		hero2.name = "bbb";
		hero2.hp = 0;
		try { 
			hero1.attackHero(hero2);
			System.out.println("攻击成功");
		} catch (EnemyHeroIsDeadException e) {
			System.out.println("原因:"+e.getMessage());
			e.printStackTrace();
		}
	}
}
