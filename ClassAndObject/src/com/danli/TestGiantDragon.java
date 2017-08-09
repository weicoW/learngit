package com.danli;

public class TestGiantDragon {

	public static void main(String[] args) {

		//GiantDragon类的构造方法私有化，不能new，只能通过getInstance获取对象
		GiantDragon dragon1 = GiantDragon.getInstance();
		GiantDragon dragon2 = GiantDragon.getInstance();
		//单例模式获取的对象，都是同一个对象
		System.out.println(dragon1);
		System.out.println(dragon2);
		
		LGiantDragon dragon = LGiantDragon.getInstance();
		
	}

}
