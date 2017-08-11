package com.integratedPractise;

public class Account {

	protected double balance;
	
	public Account(){
		
	}
	
	public Account(double init){
		
	}
	public double getBalance() {
		return balance;
	}
	public void deposit(double amt){
		balance += amt;
	}
	public void withdraw(double amt) throws Throwable{
		if (balance - amt < 0) {
			throw new OverdraftExcetpion("͸֧�쳣",(balance - amt));
		}
	}
	
}
