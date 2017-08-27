package com.testArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareSort {

//	//ð�ݷ�����
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
//	//ѡ������
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
//		System.out.println("ѡ������ʱ�䣺"+(send - sstart));
//		long bstart = System.currentTimeMillis();
//		List<Object> blist = bubbleSort(is);
//		long bend = System.currentTimeMillis();
//		System.out.println("ð������ʱ�䣺"+(bend - bstart));
//		System.out.print("�Ƚ�ð�ݺ�ѡ���������Ƿ���ͬ\t");
//		System.out.println(Arrays.equals(slist.toArray(), blist.toArray()));
////		long tstart = System.currentTimeMillis();
////		Node node = new Node();
////		for (int i : is) {
////			node.add(i);
////		}
////		long tend = System.currentTimeMillis();
////		System.out.println("������������ʱ�䣺"+(tend - tstart));
//	}
	//���ư�
	public static void main(String[] args) {
		//���������
		int[] originalNumber = new int[4000];
		for (int i : originalNumber) {
			i = (int) (Math.random() * 40000);
		}
		//�ѳ�ʼ�����鸴�ƹ�������֤ÿһ���㷨��Ŀ�����鶼��һ����
		int use4sort[];
		use4sort = Arrays.copyOf(originalNumber, originalNumber.length);
		int[] sortNumberBySelection = performance(new SelectionSort(use4sort),"ѡ��");
		int[] sortNumberByBubbling = performance(new BubblingSort(use4sort), "ð�ݷ�");
		int[] sortNumberByTree = performance(new TreeSort(use4sort), "��������");
		//�Ƚ���������õ������Ƿ���ͬ
		System.out.print("�Ƚ�ѡ�񷨺Ͷ������������Ƿ���ͬ\t");
		System.out.println(Arrays.equals(sortNumberBySelection, sortNumberByTree));
	}
	
	private static int[] performance(Sort algorithm, String type) {

		long start = System.currentTimeMillis();
		algorithm.sort();
		int[] sortedNumber = algorithm.value();
		long end = System.currentTimeMillis();
		System.out.format("%s��������%d����%n",type,end-start);
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
