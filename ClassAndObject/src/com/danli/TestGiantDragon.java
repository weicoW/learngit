package com.danli;

public class TestGiantDragon {

	public static void main(String[] args) {

		//GiantDragon��Ĺ��췽��˽�л�������new��ֻ��ͨ��getInstance��ȡ����
		GiantDragon dragon1 = GiantDragon.getInstance();
		GiantDragon dragon2 = GiantDragon.getInstance();
		//����ģʽ��ȡ�Ķ��󣬶���ͬһ������
		System.out.println(dragon1);
		System.out.println(dragon2);
		
		LGiantDragon dragon = LGiantDragon.getInstance();
		
	}

}
