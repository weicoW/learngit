package com.hero;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentHero {

	public String name;
	//使用atomicInteger修改为线程安全
	public AtomicInteger hp;
	public int damage;

	public void attackHero(ConcurrentHero h) {

		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		h.hp.set(hp.get() - damage);  ;
		System.out.format("%s 正在攻击 %s, %s的血变成了 %d %n", name, h.name, h.name, h.hp.intValue());
		if (h.isDead()) {
			System.out.println(h.name + "死了！");
		}
	}

	// 回血
	public synchronized void recover() {

		while (hp.get() >= 1000) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		hp.incrementAndGet();
		System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
		this.notify();
	}

	// 掉血
	public synchronized void hurt() {
		while (hp.get() <= 1) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		hp.decrementAndGet();
		System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
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
			System.out.println("第" + (++count) + "发");
		}
		if (count == 3) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("开始5秒");
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
		return 0 >= hp.get() ? true : false;

	}

}
