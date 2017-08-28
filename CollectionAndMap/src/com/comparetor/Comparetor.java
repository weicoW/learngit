package com.comparetor;

import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

import org.omg.CORBA.OMGVMCID;

import com.hero.Item;
import com.hero.ItemChecker;

public class Comparetor {

	public static void main(String[] args) {
		TreeSet<Integer> integers = new TreeSet<>();
		for (int i = 0; i < 10; i++) {
			integers.add(i);
		}
		System.out.println("顺序"+integers);
		//实例化一个带有比较器的TreeSet
		Comparator<Integer> comparator = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {

				if (o1 > o2) {
					return -1;
				}else {
					return 1;
				}
			
			}
		};
		TreeSet<Integer> integers2 = new TreeSet<>(comparator);
		for (int i = 0; i < 10; i++) {
			integers2.add(i);
		}
		System.out.println("逆序"+integers2);
		
		//item大到小
		ArrayList<Item> items = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int ramdom = (int) (Math.random() * 100);
			Item item = new Item(ramdom);
			items.add(item);
		}
		System.out.println("排序前");
		for (Item item : items) {
			System.out.print(item.price+"\t");
		}
		System.out.println();
		//排序
		Collections.sort(items);
		System.out.println("排序后");
		for (Item item : items) {
			System.out.print(item.price+"\t");
		}
		System.out.println();
		//使用lambda表达式排序
		System.out.println("使用lambda表达式排序");
		Collections.sort(items,(i1,i2)->i1.price <= i2.price?1:-1);
		for (Item item : items) {
			System.out.print(item.price+"\t");
		}
		System.out.println("引用静态方法方式");
		Collections.sort(items,(i1,i2)->Comparetor.SortRule(i1, i2)?1:-1);
		System.out.println("引用容器中的对象的方法");
		Collections.sort(items,(i1,i2)->i1.compareTo(i2));
		
	}

	public static boolean SortRule(Item item1,Item item2){
		return item1.price <= item2.price;
	}
	
	
}
