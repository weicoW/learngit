package com.testSuper;

public abstract class Hero {

	static String name; // 姓名

	float hp; // 血量

	float armor; // 护甲

	int moveSpeed; // 移动速度

	//敌方的水晶
    static class EnemyCrystal{
        int hp=0;
         
        //如果水晶的血量为0，则宣布胜利
        public void checkIfVictory(){
            if(hp==0){
                Hero.battleWin();
                 
                //静态内部类不能直接访问外部类的对象属性
                System.out.println(name + " win this game");
            }
        }
    }
	
	public Hero() {
		System.out.println("Hero的构造方法 ");
	}
	
	public static void battleWin() {
		System.out.println("battle win");
		
	}

	public Hero(String name){
		System.out.println("Hero 一个参数的构造方法");
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
