package com.danli;
/**
 * ����ʽ����ģʽ���ӳټ��ط�ʽ��ֻ����getInstance��ʱ��Żᴴ��ʵ��
 * @author weico
 *
 */
public class LGiantDragon {

	//˽�л����췽�����ⲿ���ܵ���
	private LGiantDragon(){
		
	}
	private static LGiantDragon instance ;
	
	public static LGiantDragon getInstance(){
		//��һ�ε���ʱinstanceΪ�գ���ʵ����һ������
		if (instance == null) {
			instance = new LGiantDragon();
		}
		//����instanceָ��Ķ���
		return instance;
		
	}
}
