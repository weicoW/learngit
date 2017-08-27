package com.testArrayList;

import java.util.ArrayList;
import java.util.List;

public class Node {

	public Node leftNode;
	public Node rightNode;
	public Object value;
	
	//插入数据
	public void add(Object v){
		//如果节点没有数据则把数据放在节点上
		if (null == value) {
			value = v;
		}//当前节点有数据，则进行判断，新增的值与当前值的大小关系
		else {
			if ((Integer)v - (Integer)value <= 0) {
				//如果做节点为空，则new一个左节点
				if(null == leftNode)
					leftNode = new Node();
				leftNode.add(v);
			}//新增的值，比当前的值大
			else {
				if(null == rightNode)
					rightNode = new Node();
				rightNode.add(v);
			}
			
		}
	}
	
	//中序遍历所有的节点
	public List<Object> values(){
		
		List<Object> list = new ArrayList<>();
		//先添加左节点
		if (null != leftNode) {
			list.addAll(leftNode.values());
		}
		//添加当前节点
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
