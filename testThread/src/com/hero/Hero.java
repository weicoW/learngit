package com.hero;

public class Hero {

	public String name;
	public float hp;
	public int damage;

	public void attackHero(Hero h) {

		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		h.hp -= damage;  ;
		System.out.format("%s ���ڹ��� %s, %s��Ѫ�����%.0f %n", name, h.name, h.name, h.hp);
		if (h.isDead()) {
			System.out.println(h.name + "���ˣ�");
		}
	}

	// ��Ѫ
	public synchronized void recover() {

		while (hp >= 1000) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		hp = hp + 1;
		System.out.printf("%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n", name, name, hp);
		this.notify();
	}

	// ��Ѫ
	public synchronized void hurt() {
		while (hp <= 1) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		hp = hp - 1;
		System.out.printf("%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n", name, name, hp);
		this.notify();
	}

	public void adugen(int i) {

		int count = i;
		while (!(count == 3)) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("��" + (++count) + "��");
		}
		if (count == 3) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("��ʼ5��");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count = 0;
			adugen(count);
		}
	}

	public boolean isDead() {
		return 0 >= hp ? true : false;

	}

}
