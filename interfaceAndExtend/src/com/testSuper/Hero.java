package com.testSuper;

public abstract class Hero {

	static String name; // ����

	float hp; // Ѫ��

	float armor; // ����

	int moveSpeed; // �ƶ��ٶ�

	//�з���ˮ��
    static class EnemyCrystal{
        int hp=0;
         
        //���ˮ����Ѫ��Ϊ0��������ʤ��
        public void checkIfVictory(){
            if(hp==0){
                Hero.battleWin();
                 
                //��̬�ڲ��಻��ֱ�ӷ����ⲿ��Ķ�������
                System.out.println(name + " win this game");
            }
        }
    }
	
	public Hero() {
		System.out.println("Hero�Ĺ��췽�� ");
	}
	
	public static void battleWin() {
		System.out.println("battle win");
		
	}

	public Hero(String name){
		System.out.println("Hero һ�������Ĺ��췽��");
		this.name = name;
	}
	
	public void attack(){
		
		System.out.println("hero attack");
		
	}
	
	public static void main(String[] args) {
		
		
		Hero hero = new APHero();
		hero.attack();
		Hero.EnemyCrystal enemyCrystal = new Hero.EnemyCrystal();
		hero.name = "nazi";
		enemyCrystal.checkIfVictory();
	}

}
