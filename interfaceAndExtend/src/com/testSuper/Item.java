package com.testSuper;

public abstract class Item {

	String name;
	float price;
	
	@Override
	public String toString() {
		
		return name+price;
	}
	
	@Override
	protected void finalize() throws Throwable {
		
		System.out.println("当前对象正在被回收");
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Item) {
			Item i = (Item) obj;
			return this.price == i.price;
		}
		return false;
	}
	
	public abstract boolean disposable();
	
	
	public static void main(String[] args) {
	    
	}
	
}
