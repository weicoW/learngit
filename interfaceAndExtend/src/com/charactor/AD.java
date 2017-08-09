package com.charactor;

public interface AD {

	public void physicAttack();
	
	public default void attack(){
		System.out.println("AD attack");
	}
	
}
