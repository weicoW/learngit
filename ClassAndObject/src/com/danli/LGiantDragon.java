package com.danli;
/**
 * 懒汉式单例模式（延迟加载方式，只有在getInstance的时候才会创建实例
 * @author weico
 *
 */
public class LGiantDragon {

	//私有化构造方法，外部不能调用
	private LGiantDragon(){
		
	}
	private static LGiantDragon instance ;
	
	public static LGiantDragon getInstance(){
		//第一次调用时instance为空，则实例化一个对象
		if (instance == null) {
			instance = new LGiantDragon();
		}
		//返回instance指向的对象
		return instance;
		
	}
}
