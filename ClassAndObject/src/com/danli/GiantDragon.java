package com.danli;
/**
 * 恶汉单例模式
 * @author weico
 *
 */
public class GiantDragon {

	private GiantDragon(){
		
	}
	//静态属性指向实例化对象，因为是静态属性，所以只有一个
	private static GiantDragon instance = new GiantDragon();
	
	//提供public静态方法提供调用获取对象
	public static GiantDragon getInstance(){
		
		return instance;
	}
	
}
