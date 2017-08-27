package com.testArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareSort {

//	//冒泡法排序
//	public static List<Object> bubbleSort(Object v){
//		List<Object> list = new ArrayList<>();
//		int[] is = (int[]) v;
//		for (int i = 0; i < is.length; i++) {
//			for (int j = 0; j < is.length-i-1; j++) {
//				if (is[j] > is[j+1]) {
//					int temp = is[j];
//					is[j] = is[j+1];
//					is[j+1] = temp;
//				}
//			}
//		}
//		for (int i : is) {
//			list.add(i);
//		}
//		return list;
//	}
//	//选择排序
//	public static List<Object> selectSort(Object v){
//		List<Object> list = new ArrayList<>();
//		int[] is = (int[]) v;
//		for (int i = 0; i < is.length-1; i++) {
//			for (int j = i+1; j < is.length; j++) {
//				if (is[i] > is[j]) {
//					int temp = is[i];
//					is[i] = is[j];
//					is[j] = temp;
//				}
//			}
//		}
//		for (int i : is) {
//			list.add(i);
//		}
//		return list;
//	}
//	public static void main(String[] args) {
//		int[] is = new int[40000];
//		for (int i : is) {
//			i = (int) (Math.random() * 40000);
//		}
//		long sstart = System.currentTimeMillis();
//		List<Object> slist = selectSort(is);
//		long send = System.currentTimeMillis();
//		System.out.println("选择排序时间："+(send - sstart));
//		long bstart = System.currentTimeMillis();
//		List<Object> blist = bubbleSort(is);
//		long bend = System.currentTimeMillis();
//		System.out.println("冒泡排序时间："+(bend - bstart));
//		System.out.print("比较冒泡和选择排序结果是否相同\t");
//		System.out.println(Arrays.equals(slist.toArray(), blist.toArray()));
////		long tstart = System.currentTimeMillis();
////		Node node = new Node();
////		for (int i : is) {
////			node.add(i);
////		}
////		long tend = System.currentTimeMillis();
////		System.out.println("二叉树法排序时间："+(tend - tstart));
//	}
	//完善版
	public static void main(String[] args) {
		//生成随机数
		int[] originalNumber = new int[4000];
		for (int i : originalNumber) {
			i = (int) (Math.random() * 40000);
		}
		//把初始化数组复制过来，保证每一种算法的目标数组都是一样的
		int use4sort[];
		use4sort = Arrays.copyOf(originalNumber, originalNumber.length);
		int[] sortNumberBySelection = performance(new SelectionSort(use4sort),"选择法");
		int[] sortNumberByBubbling = performance(new BubblingSort(use4sort), "冒泡法");
		int[] sortNumberByTree = performance(new TreeSort(use4sort), "二叉树法");
		//比较三个排序好的数组是否相同
		System.out.print("比较选择法和二叉树法排序是否相同\t");
		System.out.println(Arrays.equals(sortNumberBySelection, sortNumberByTree));
	}
	
	private static int[] performance(Sort algorithm, String type) {

		long start = System.currentTimeMillis();
		algorithm.sort();
		int[] sortedNumber = algorithm.value();
		long end = System.currentTimeMillis();
		System.out.format("%s排序，消耗%d毫秒%n",type,end-start);
		return sortedNumber;
	}

	interface Sort{
		void sort();
		int[] value();
	}
	static class SelectionSort implements Sort{

		int numbers[];
		
		public SelectionSort(int[] numbers) {
			this.numbers = numbers;
		}

		@Override
		public void sort() {
			
			for (int i = 0; i < numbers.length-1; i++) {
				for (int j = i+1; j < numbers.length; j++) {
					if (numbers[i] > numbers[j]) {
						int temp = numbers[i];
						numbers[i] = numbers[j];
						numbers[j] = temp;
					}
				}
			}
		}

		@Override
		public int[] value() {
			return numbers;
		}
		
	}
	
	static class BubblingSort implements Sort{

		int numbers[];
		
		public BubblingSort(int[] numbers) {
			this.numbers = numbers;
		}

		@Override
		public void sort() {
			for (int i = 0; i < numbers.length; i++) {
				for (int j = 0; j < numbers.length-i-1; j++) {
					if (numbers[j] > numbers[j+1]) {
						int temp = numbers[j];
						numbers[j] = numbers[j+1];
						numbers[j+1] = temp;
					}
				}
			}
		}

		@Override
		public int[] value() {
			// TODO Auto-generated method stub
			return numbers;
		}
	}
	static class TreeSort implements Sort{
		
		int[] numbers;
		Node n;

		public TreeSort(int[] numbers) {
			n = new Node();
			this.numbers = numbers;
		}

		@Override
		public void sort() {
			for (int i : numbers) {
				n.add(i);
			}
			
		}

		@Override
		public int[] value() {
			List<Object> list = n.values();
			int[] sortedNumbers = new int[list.size()];
			for (int i = 0; i < sortedNumbers.length; i++) {
				sortedNumbers[i] = Integer.parseInt(list.get(i).toString());
			}
			return sortedNumbers;
		}
		
	}
}
