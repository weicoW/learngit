package com.integratedPractise;
/**
 *  ͸֧�쳣
 * @author weico
 *
 */
public class OverdraftExcetpion extends Exception{
	
	private double deficit;

	public OverdraftExcetpion() {
		// TODO Auto-generated constructor stub
	}
	
	public OverdraftExcetpion(String msg,double deficit) {
		super(msg);
		this.deficit = deficit;
	}
	public double getDeficit() {
		return deficit;
	}
	
}
