package com.hero;

public class Hero {

	String name; //姓名
    
    float hp; //血量
        
    float armor; //护甲
        
    int moveSpeed; //移动速度
    
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
 
    //复活
    public void revive(Hero h){
        h = new Hero("提莫",383);
    }
 
    public static void main(String[] args) {
        Hero teemo =  new Hero("提莫",383);
         
        //受到400伤害，挂了
        teemo.hp = teemo.hp - 400;
        System.out.println(teemo.hp);
         
        teemo.revive(teemo);
         
         System.out.println(teemo.hp); //输出多少？ 怎么理解？
         
         for (HeroType heroType : HeroType.values()) {
			System.out.println(heroType);
		}
         
    }
	
}
