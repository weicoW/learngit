package com.list;


public interface Stack<T> {

	// ��Ӣ�����뵽���λ��
	public void push(T t);

	// ������һ��Ӣ��ȡ����
	public T pull();

	// �鿴���һ��Ӣ��
	public T peek();

}
