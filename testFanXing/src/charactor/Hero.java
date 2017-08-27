package charactor;

public class Hero implements Comparable<Hero>{
 
	public String name = "Hero";
	public float hp;

	@Override
	public int compareTo(Hero o) {
		return (int) (hp-o.hp);
	}
	
}
