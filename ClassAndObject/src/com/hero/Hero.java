package com.hero;

public class Hero {

	String name; //����
    
    float hp; //Ѫ��
        
    float armor; //����
        
    int moveSpeed; //�ƶ��ٶ�
    
    private static Hero instance = new Hero();
    
    public  static Hero getInstance(){
    	return instance;
    }
     
    private Hero(){
         
    }
     
    public Hero(String name,float hp){
        this.name = name;
        this.hp = hp;
    }
    //test static
    public static void display(){
    	Hero hero = new Hero();
    	hero.revive(hero);;
    	
    }
 
    //����
    public void revive(Hero h){
        h = new Hero("��Ī",383);
    }
 
    public static void main(String[] args) {
        Hero teemo =  new Hero("��Ī",383);
         
        //�ܵ�400�˺�������
        teemo.hp = teemo.hp - 400;
        System.out.println(teemo.hp);
         
        teemo.revive(teemo);
         
         System.out.println(teemo.hp); //������٣� ��ô��⣿
         
         for (HeroType heroType : HeroType.values()) {
			System.out.println(heroType);
		}
         
    }
	
}
