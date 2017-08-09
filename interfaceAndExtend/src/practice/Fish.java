package practice;

public class Fish extends Animal implements Pet{

	private String name;
	
	public Fish() {
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void walk(int legs) {
		
		System.out.println("fish do not walk");
		
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		Animal animal = new Fish();
		animal.walk(0);
		
	}
	
	
	
}
