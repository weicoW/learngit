package com.danli;
/**
 * �񺺵���ģʽ
 * @author weico
 *
 */
public class GiantDragon {

	private GiantDragon(){
		
	}
	//��̬����ָ��ʵ����������Ϊ�Ǿ�̬���ԣ�����ֻ��һ��
	private static GiantDragon instance = new GiantDragon();
	
	//�ṩpublic��̬�����ṩ���û�ȡ����
	public static GiantDragon getInstance(){
		
		return instance;
	}
	
}
