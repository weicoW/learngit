package charactor;

public class Hero implements Comparable<Hero>{
 
	public String name = "Hero";
	public float hp;
	public float damage;

	@Override
	public int compareTo(Hero o) {
		return (int) (hp-o.hp);
	}
	
}
