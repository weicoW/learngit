package com.hero;

import com.pojo.Hero;

public class Support extends Hero{

	public void heal(){
		System.out.println("���Ƽ�Ѫ");
	}
	
	public void heal(int hp,Hero...heros){
		for (int i = 0; i < heros.length; i++) {
			System.out.println("Ϊ"+heros[i].name+"Ӣ������"+hp+"Ѫ��");
		}
		
	}
	
	public static void main(String[] args) {
		
		Support sp = new Support();
		sp.name = "�ļ�";
		Hero hero = new Hero();
		hero.name = "�����";
		sp.heal();
		sp.heal(700, hero);
		
	}

}
