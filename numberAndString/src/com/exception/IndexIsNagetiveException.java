package com.exception;

/**
 * 下标为负异常
 * @author weico
 *
 */
public class IndexIsNagetiveException extends Exception{

	public IndexIsNagetiveException(){
		
	}
	
	public IndexIsNagetiveException(String msg){
		super(msg);
	}
}
