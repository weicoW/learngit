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
	
	//�������
	public void addHero(Hero h){
		//�����ǰ�ڵ�û��ֵ�����ڵ㸳ֵ
		if (null == hero) {
			hero = h;
		}//�����ֵ���Ƚ�hero.hp�Ĵ�С��hp��ķ������,hpС�ķ����ұ�
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
		//�ȵݹ������ߵ�hp���
		if (null != leftNode) {
			list.addAll(leftNode.peek());
		}
		//��ӵ�ǰ�ڵ�
		list.add(hero);
		//����ұ�hpС��
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
		System.out.println("��ʼ��10��Hero");
		for (Hero hero : hs) {
			System.out.println(hero.name+"\t"+hero.hp);
		}
		HeroNode node = new HeroNode();
		//�������
		for (Hero hero : hs) {
			node.addHero(hero);
		}		
		System.out.println("����Ѫ�����������");
		//��ӡ
		List<Hero> heros = node.peek();
		for (Hero hero : heros) {
			System.out.println(hero.name+"\t"+hero.hp);
		}
		
	}

}
