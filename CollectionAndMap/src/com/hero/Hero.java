package com.hero;

public class Hero implements LOL{

	public String name;
	public float hp;
	public int damage;
	
	public Hero() {
		// TODO Auto-generated constructor stub
	}
	public Hero(String name){
		this.name = name;
	}
	//��дtoString
	public String toString(){
		return name;
	}
	
}
