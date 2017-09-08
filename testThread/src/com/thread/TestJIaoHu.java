package com.thread;

import com.hero.Hero;

public class TestJIaoHu {

	public static void main(String[] args) {
		Hero hero = new Hero();
		 hero.name = "gareen";
	     hero.hp = 616;
	     Thread[] rThread = new Thread[2];
	     Thread[] hThread = new Thread[5];
	     for (int i = 0; i < rThread.length; i++) {
	    	 Thread t1 = new Thread(){
		    	 @Override
		    	public void run() {
		    		 while(true){
		    			 hero.recover();
		    			 try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    		 }
		    	 }
		     };
		     t1.start();
		     rThread[i] = t1;
		}
	     for (int i = 0; i < hThread.length; i++) {
	    	 Thread t2 = new Thread(){
		    	 @Override
		    	public void run() {
		    		while (true) {
						hero.hurt();
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
		    	}
		     };
		     t2.start();
		     hThread[i] = t2;
		}
	}
	
}
