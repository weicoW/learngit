package com.thread;

import java.util.ArrayList;

import com.hero.Hero;

public class StartAThread {

	public static void main(String[] args) {

		Hero gareen = new Hero();
		gareen.name = "盖伦";
		gareen.hp = 616;
		gareen.damage = 1;

		Hero teemo = new Hero();
		teemo.name = "提莫";
		teemo.hp = 300;
		teemo.damage = 1;

		Hero bh = new Hero();
		bh.name = "赏金猎人";
		bh.hp = 500;
		bh.damage = 1;

		Hero leesin = new Hero();
		leesin.name = "盲僧";
		leesin.hp = 455;
		leesin.damage = 1;
		// 不使用多线程
		// while (!gareen.isDead()) {
		// teemo.attackHero(gareen);
		// }
		// while (!leesin.isDead()) {
		// bh.attackHero(leesin);
		// }
		// 继承thread类使用多线程
		// KillThread killThread = new KillThread(teemo, gareen);
		// killThread.start();
		// KillThread killThread2 = new KillThread(leesin, bh);
		// killThread2.start();
		// 实现runnable接口使用多线程
		// Battle battle = new Battle(gareen, teemo);
		// new Thread(battle).start();
		// Battle battle2 = new Battle(leesin, teemo);
		// new Thread(battle2).start();
		// 使用匿名内部类的方法使用多线程
		Thread thread = new Thread() {
			@Override
			public void run() {
				while (!gareen.isDead()) {
					teemo.attackHero(gareen);

				}

			}
		};
		// 设置线程优先级
//		thread.setPriority(thread.MAX_PRIORITY);

		Thread thread2 = new Thread() {
			@Override
			public void run() {
				while (!bh.isDead()) {
					// 线程临时暂停
					Thread.yield();
					leesin.attackHero(bh);
				}
			}
		};
//		thread2.setPriority(thread2.MIN_PRIORITY);
		// 守护线程，所有线程都是守护线程，程序结束
		// thread.setDaemon(true);
		 thread.start();
		// thread2.setDaemon(true);
		 thread2.start();
		// practise
		Thread t = new Thread() {
			@Override
			public void run() {
				gareen.adugen(0);
			}
		};
		// t.start();
		String password = randomString(3);
		System.out.println("密码是"+password);
		ArrayList<String> passwordList = new ArrayList<>();
		Thread gussThread = new Thread() {
			@Override
			public void run() {
				char[] newPassword = new char[3];
				for (short i = '0'; i <= 'z'; i++) {
					for (short j = '0'; j <= 'z'; j++) {
						for (short k = '0'; k <= 'z'; k++) {
							if (!isLetterOrDigit(i, j, k)) {
								continue;
							}
							newPassword[0] = (char) i;
							newPassword[1] = (char) j;
							newPassword[2] = (char) k;
							String np = new String(newPassword);
							passwordList.add(np);
							if (password.equals(np)) {
								System.out.println("找到了，密码是" + np);
								return;
							}
						}

					}
				}

			}
		};

		Thread guessLog = new Thread() {
			@Override
			public void run() {
				while (true) {
					
					while (passwordList.isEmpty()) {
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					String guess = passwordList.remove(0);
					System.out.println(guess);

				}
			}
		};
		gussThread.start();
		guessLog.setDaemon(true);
		guessLog.start();
	}

	private static boolean isLetterOrDigit(short i, short j, short k) {
		return Character.isLetterOrDigit(i) && Character.isLetterOrDigit(j) && Character.isLetterOrDigit(k);
	}

	private static String randomString(int length) {
		String pool = "";
		for (short i = '0'; i <= '9'; i++) {
			pool += (char) i;
		}
		for (short i = 'a'; i <= 'z'; i++) {
			pool += (char) i;
		}
		for (short i = 'A'; i <= 'Z'; i++) {
			pool += (char) i;
		}
		char cs[] = new char[length];
		for (int i = 0; i < cs.length; i++) {
			int index = (int) (Math.random() * pool.length());
			cs[i] = pool.charAt(index);
		}
		String result = new String(cs);
		return result;
	}
}
