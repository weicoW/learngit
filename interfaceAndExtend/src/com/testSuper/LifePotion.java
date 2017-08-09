package com.testSuper;

public class LifePotion {
	
	public static void main(String[] args) {
		Item item = new Item() {
			
			@Override
			public boolean disposable() {
				
				return true;
			}
		};
	}
	

}
