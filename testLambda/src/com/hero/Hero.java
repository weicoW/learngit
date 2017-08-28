package com.hero;

public class Hero implements LOL {

	public String name;
	public float hp;
	public int damage;

	public Hero() {
		// TODO Auto-generated constructor stub
	}

	public Hero(String name, float hp, int damage) {
		this.name = name;
		this.hp = hp;
		this.damage = damage;
	}

	// ÖØÐ´toString
	public String toString() {
		return name + "\t hp:" + hp + "\t damage" + damage + "\n";
	}

	public boolean matched() {
		return this.hp > 100 && this.damage < 50;
	}

}
