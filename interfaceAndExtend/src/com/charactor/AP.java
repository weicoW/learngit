package com.charactor;

public interface AP {

	public void magicAttack();
	
	public default void attack(){
		System.out.println("AP attack");
	}
	
}
