package com.testLambda;

import java.util.ArrayList;
import java.util.Random;

import com.hero.Hero;

public class TestLambda {

	public static void main(String[] args) {
		Random r = new Random();
		ArrayList<Hero> heros = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Hero hero = new Hero("hero"+i ,r.nextInt(1000), r.nextInt(100));
			heros.add(hero);
		}
		System.out.println("初始化后的集合");
		System.out.println(heros);
		System.out.println("使用匿名内部类的方式，筛选出 hp>100 && damange<50的英雄");
		//使用匿名内部类方式
		HeroChecker checker = new HeroChecker() {
			
			@Override
			public boolean check(Hero h) {
				return (h.hp>100 && h.damage<50) ;
			}
		};
		filter(heros,checker);
        System.out.println("使用Lamdba的方式，筛选出 hp>100 && damange<50的英雄");
        filter(heros, h->h.hp>100 && h.damage<50);
        System.out.println("在Lambda表达式中使用静态方法");
        filter(heros, h->TestLambda.testHero(h));
        System.out.println("直接引用静态方法");
        filter(heros, TestLambda::testHero);
        System.out.println("引用对象方法");
        TestLambda lambda = new TestLambda();
        filter(heros, lambda::testHero2);
        System.out.println("调用容器中的对象方法");
        filter(heros, Hero::matched);
        
	}
	public boolean testHero2(Hero h) {
        return h.hp>100 && h.damage<50;
    }
	
	 public static boolean testHero(Hero h) {
	        return h.hp>100 && h.damage<50;
	    }

	private static void filter(ArrayList<Hero> heros, HeroChecker checker) {
		for (Hero hero : heros) {
			if (checker.check(hero)) {
				System.out.println(hero);
			}
		}
		
	}
	
}
