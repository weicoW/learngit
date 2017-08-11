package com.integratedPractise;

public class TestAccount {

	public static void main(String[] args) {
		Account account = new Account();
		System.out.println(account.getBalance());
		account.deposit(600);
		System.out.println(account.getBalance());
		try {
			account.withdraw(800);
		} catch (Throwable e) {
			if (e instanceof OverdraftExcetpion) {
				System.out.println(((OverdraftExcetpion) e).getDeficit());
			}
			e.printStackTrace();
		}
		CheckingAccount ca = new CheckingAccount(100, 100);
		try {
			ca.withdraw(300);
		} catch (Throwable e) {
			if (e instanceof OverdraftExcetpion) {
				System.out.println(((OverdraftExcetpion) e).getDeficit());
			}
			e.printStackTrace();
		}
	}
	
}
