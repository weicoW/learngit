package com.testArrayList;

import java.util.ArrayList;
import java.util.List;

public class Node {

	public Node leftNode;
	public Node rightNode;
	public Object value;
	
	//��������
	public void add(Object v){
		//����ڵ�û������������ݷ��ڽڵ���
		if (null == value) {
			value = v;
		}//��ǰ�ڵ������ݣ�������жϣ�������ֵ�뵱ǰֵ�Ĵ�С��ϵ
		else {
			if ((Integer)v - (Integer)value <= 0) {
				//������ڵ�Ϊ�գ���newһ����ڵ�
				if(null == leftNode)
					leftNode = new Node();
				leftNode.add(v);
			}//������ֵ���ȵ�ǰ��ֵ��
			else {
				if(null == rightNode)
					rightNode = new Node();
				rightNode.add(v);
			}
			
		}
	}
	
	//����������еĽڵ�
	public List<Object> values(){
		
		List<Object> list = new ArrayList<>();
		//�������ڵ�
		if (null != leftNode) {
			list.addAll(leftNode.values());
		}
		//��ӵ�ǰ�ڵ�
		list.add(value);
		if (null != rightNode) {
			list.addAll(rightNode.values());
		}
		return list;
	}
	
//	public static void main(String[] args) {
//		int randoms[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };
//		Node node = new Node();
//		for (int i : randoms) {
//			node.add(i);
//		}
//		System.out.println(node.values());
//	}
	
}
