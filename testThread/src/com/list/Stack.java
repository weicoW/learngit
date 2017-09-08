package com.list;


public interface Stack<T> {

	// 把英雄推入到最后位置
	public void push(T t);

	// 把最有一个英雄取出来
	public T pull();

	// 查看最后一个英雄
	public T peek();

}
