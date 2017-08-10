package com.testString;

import java.util.Scanner;

public class TestString {
	
	//比较字符串
	public static void compareString(){
//		String s1 = "the light";
//		String s2 = new String("the light");
//		if (s1==(s2)) {
//			System.out.println("is equal");
//		}else {
//			System.out.println("is not equal");
//		}
		String[] ss = getStringArray(100, 2);
		String[] es = new String [ss.length];
		int count = 0;
		for (int i = 0; i < ss.length; i++) {
			
			System.out.print(ss[i]+"\t");
			if ((i+1)%10 ==0 ) {
				System.out.println();
			}
			for (int j = i+1; j < ss.length; j++) {
				if (ss[i].equals(ss[j])) {
					count++;
					es[i] = ss[i];
				}
			}
			
		}
		System.out.println("总共有"+count+"种重复字段");
		System.out.println("分别是：");
		for (int i = 0; i < es.length; i++) {
			if (es[i] != null) {
				System.out.print(es[i]+"\t");
			}
		}
	}
	
	public static void changeToUpper(String s){
		String[] word = s.split(" ");
		StringBuffer sb = new StringBuffer();
//		for (String string : word) {
//			System.out.println(string);
//		}
		for (int i = 0; i < word.length; i++) {
			char[] cs = word[i].toCharArray();
			char c = Character.toUpperCase(cs[0]);
			cs[0] = c;
			word[i] = new String(cs);	
			//System.out.println(word[i]);
			sb.append(word[i]+" ");
			System.out.println(sb);
		}
		
	}
	
	public static void testContain(String s){
		String[] word = s.split(" ");
		int count = 0;
		for (int i = 0; i < word.length; i++) {
			if (word[i].indexOf('p') == 0) {
				count++;
				
			}
			
		}
		System.out.println("有"+count+"个以p开头的词");
	}
	//大小写相间 
	public static void upperBetweenLower(String s){
		char [] cs = s.toCharArray();
		
		for (int i = 0; i < cs.length; i++) {
			if (i == 0 || i % 2 ==0) {
				cs[i] = Character.toUpperCase(cs[i]);
			}
		}
		String string = new String(cs);
		System.out.println("转换后："+string);
	}

	public static char[] getCharArray(int lengh){
		char [] cs = new char[lengh];
		int index = 0;
		String pool = "qwertyuioplkjhgfdsazxcvbnmZXCVBNMKLJHGFDSAQWERTYUIOP123546987";
		for (int i = 0; i < cs.length; i++) {
			index = (int) (Math.random() * pool.length());
			cs[i] = pool.charAt(index);
		}
		return cs;
	}
	
	public static String[] getStringArray(int slenth,int clenth){
		
		String[] ss = new String [slenth];
		for (int i = 0; i < ss.length; i++) {
			ss[i] = new String(getCharArray(clenth));
			
		}
		
		return ss;
	}
	
	public static void main(String[] args) {
		
		compareString();
		
//		String s = "lengendary";
//		upperBetweenLower(s);
		
//		String s = "a";
		//String c = 'a';
		//选出大写 字母
//		System.out.println("请输入含有数字和字母的字符串");
//		Scanner scanner = new Scanner(System.in);
//		String str = scanner.nextLine();
//		
//		char [] cs = str.toCharArray();
//		char [] cs2 = new char[cs.length];
//		
//		for (int i = 0; i < cs2.length; i++) {
//			Character ch = cs[i];
//			if (Character.isUpperCase(ch)) {
//				cs2[i] = cs[i];
//			}
//			if (Character.isDigit(ch)) {
//				cs2[i] = cs[i];
//			}
//		}
//			
//		for (int i = 0; i < cs2.length; i++) {
//			if (cs2[i] != 0) {
//				System.out.println(cs2[i]);
//			}
//		}	
		
//		String [] ss = getStringArray();
//		for (int i = 0; i < ss.length-1; i++) {
//			 for (int j = i+1; j < ss.length; j++) {
//				char a = ss[i].charAt(0);
//				char b = ss[j].charAt(0);
//				short i1 = (short) a;
//				short i2 = (short) b;
//				if (i1 >= 97) {
//					i1 -= 32;
//				}
//				if (i2 >= 97) {
//					i2 -= 32;
//				}
//				if (i1 > i2) {
//					String box = ss [i];
//					ss [i] = ss [j];
//					ss [j] = box;
//				}
//			}
//		}
//		for (String string : ss) {
//			System.out.println(string);
//		}
		
//		String st = "    你加,  上不,了卡    ";
//		System.out.println(st.replaceFirst(",", "."));
//		System.out.println(st.replace(",", "."));
		
//		String word = "let there be light";
//		changeToUpper(word);
//		String word1 = "peter piper picked a peck of pickled peppers";
//		testContain(word1);
	}
}
