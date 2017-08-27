package com.testFanXing;
 
import java.util.ArrayList;

import charactor.ADHero;
import charactor.APHero;
import charactor.Hero;
 
public class TestGeneric {
 
    public static void iterate(ArrayList<? extends Hero> list) {
		   
    	for (Hero hero : list) {
			System.out.println(hero.name);
		}
    	
    }
 
 
    public static void main(String[] args) {
//    	ArrayList<Hero> hs = new ArrayList<>();
        ArrayList<APHero> aphs = new ArrayList<>();
        ArrayList<ADHero> adhs = new ArrayList<>();
        
//        Hero hero = new Hero();
//        hs.add(hero);
        ADHero adHero = new ADHero("ADHero");
        adhs.add(adHero);
        APHero apHero = new APHero();
        aphs.add(apHero);

//        iterate(hs);
        iterate(adhs);
        iterate(aphs);
        
    }
 
}
