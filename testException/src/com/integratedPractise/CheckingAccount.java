package com.integratedPractise;

public class CheckingAccount extends Account{

	private double overdraftProtection;
	
	public CheckingAccount(double balance) {
		super.balance = balance;
	}
	public CheckingAccount(double balance,double protect) {
		super.balance = balance;
		overdraftProtection = protect;
	}
	
	public void withdraw(double amt) throws Throwable{
		if (Math.abs(balance - amt) > overdraftProtection ) {
			throw new OverdraftExcetpion("³¬¹ýÍ¸Ö§¶î¶È", Math.abs(balance-amt)-overdraftProtection);
		}
		
	}
	
}
