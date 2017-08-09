package com.testInteger;

import java.util.Scanner;

public class TestString {
	
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
	
	public static void upperBetweenLower(String s){
		char [] cs = s.toCharArray();
		
		for (int i = 0; i < cs.length; i++) {
			
		}
		
	}

	public static char[] getCharArray(){
		char [] cs = new char[5];
		for (int i = 0; i < cs.length; i++) {
			short ran = (short) (Math.random()*100+48);
			if (Character.isDigit(ran)|| Character.isUpperCase(ran) || Character.isLowerCase(ran)) {
				cs[i] = (char) ran;
				System.out.println(cs[i]);
			}
			
		}
		return cs;
	}
	
	public static String[] getStringArray(){
		
		String[] ss = new String [8];
		for (int i = 0; i < ss.length; i++) {
			char [] cs = getCharArray();
			String s = new String(cs);
			ss[i] = s;
		}
		
		return ss;
	}
	
	public static void main(String[] args) {
		
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
		
		String word = "let there be light";
		changeToUpper(word);
		String word1 = "peter piper picked a peck of pickled peppers";
		testContain(word1);
	}
}
