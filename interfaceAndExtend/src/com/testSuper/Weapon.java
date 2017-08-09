package com.testSuper;

public class Weapon {

	public static void main(String[] args) {
		Item item = new Item() {
			
			@Override
			public boolean disposable() {

				return true;
			}
		};
	}
	
}
