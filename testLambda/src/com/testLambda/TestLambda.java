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
		System.out.println("��ʼ����ļ���");
		System.out.println(heros);
		System.out.println("ʹ�������ڲ���ķ�ʽ��ɸѡ�� hp>100 && damange<50��Ӣ��");
		//ʹ�������ڲ��෽ʽ
		HeroChecker checker = new HeroChecker() {
			
			@Override
			public boolean check(Hero h) {
				return (h.hp>100 && h.damage<50) ;
			}
		};
		filter(heros,checker);
        System.out.println("ʹ��Lamdba�ķ�ʽ��ɸѡ�� hp>100 && damange<50��Ӣ��");
        filter(heros, h->h.hp>100 && h.damage<50);
        System.out.println("��Lambda���ʽ��ʹ�þ�̬����");
        filter(heros, h->TestLambda.testHero(h));
        System.out.println("ֱ�����þ�̬����");
        filter(heros, TestLambda::testHero);
        System.out.println("���ö��󷽷�");
        TestLambda lambda = new TestLambda();
        filter(heros, lambda::testHero2);
        System.out.println("���������еĶ��󷽷�");
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
