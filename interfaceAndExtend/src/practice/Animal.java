package practice;

public abstract class Animal {

	protected int legs;
	
	protected  Animal(int legs) {
		this.legs = legs;
	}
	
	protected Animal() {
		
	}
	
	public abstract void eat();
	
	public void walk(int legs){
		System.out.println("ʹ��"+legs+"������·");
	}
	
}
