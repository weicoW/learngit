package com.hero;

import java.util.ArrayList;
import java.util.List;

public class HeroNode {

	public HeroNode leftNode;
	public HeroNode rightNode;
	public Hero hero;

	public HeroNode() {

	}

	public HeroNode(Hero hero) {
		this.hero = hero;
	}
	
	//添加数据
	public void addHero(Hero h){
		//如果当前节点没有值，给节点赋值
		if (null == hero) {
			hero = h;
		}//如果有值，比较hero.hp的大小，hp大的放在左边,hp小的放在右边
		else {
			if (hero.hp - h.hp <= 0) {
				if (leftNode == null) {
					leftNode = new HeroNode();
				}
				leftNode.addHero(h);
			}else {
				if (rightNode == null) {
					rightNode = new HeroNode();
				}
				rightNode.addHero(h);
			}
		}

	}
	public List<Hero> peek(){
		List<Hero> list = new ArrayList<>();
		//先递归添加左边的hp大的
		if (null != leftNode) {
			list.addAll(leftNode.peek());
		}
		//添加当前节点
		list.add(hero);
		//添加右边hp小的
		if (null != rightNode) {
			list.addAll(rightNode.peek());
		}
		return list;
	}
	public static void main(String[] args) {
		
		Hero[] hs = new Hero[10];
		for (int i = 0; i < hs.length; i++) {
			hs[i] = new Hero("hero 1"+i);
			hs[i].hp = (float) (Math.random() * 1000);
		}
		System.out.println("初始话10个Hero");
		for (Hero hero : hs) {
			System.out.println(hero.name+"\t"+hero.hp);
		}
		HeroNode node = new HeroNode();
		//添加数据
		for (Hero hero : hs) {
			node.addHero(hero);
		}		
		System.out.println("根据血量倒序排序后");
		//打印
		List<Hero> heros = node.peek();
		for (Hero hero : heros) {
			System.out.println(hero.name+"\t"+hero.hp);
		}
		
	}

}
