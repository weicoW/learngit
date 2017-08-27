package com.hero;

public class Item implements LOL,Comparable<Item>{

	public int price;

	@Override
	public int compareTo(Item another) {

		if(price < another.price)
			return 1;
		else
			return -1;
		
	}
	public Item(int price) {
		this.price = price;
	
	}
}
