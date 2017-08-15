package com.testFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.util.Scanner;

import com.hero.Hero;

public class TestObjectStream {

	public static void main(String[] args) {
//		Hero h = new Hero();
//		h.name = "aaa";
//		h.hp = 352;
//		File file = new File("D:/test/stream/read.txt");
//		//�������������
//		try (FileOutputStream fos = new FileOutputStream(file);
//			ObjectOutputStream oos = new ObjectOutputStream(fos);){
//			oos.writeObject(h);
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//��������������
//		try (FileInputStream fis = new FileInputStream(file);
//			ObjectInputStream ois = new ObjectInputStream(fis);){
//			
//			//�������ý��ܶ���
//			Hero h2 = (Hero) ois.readObject();
//			System.out.println(h2.name);
//			System.out.println(h2.hp);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//testObjectStream();
		//����̨����
//		Scanner s = new Scanner(System.in);
//		int a = s.nextInt();
//		System.out.println(a);
		
		pratise();
	}
	
	//����ģ������Java��
	private static void pratise() {
		//���û�����
		System.out.println("������������ƣ�");
		Scanner scanner = new Scanner(System.in);
		String className = scanner.nextLine();
		System.out.println("�������������ͣ�");
		Scanner scanner2 = new Scanner(System.in);
		String type = scanner2.nextLine();
		System.out.println("��������������");
		Scanner scanner3 = new Scanner(System.in);
		String property = scanner3.nextLine();
		String uproperty = toUpperFirstLetter(property);
		//��ȡģ���ļ�
		File modelFile = new File("D:/test/stream/read.txt");
		String modelContent = null;
		try (InputStreamReader isr = new InputStreamReader(new FileInputStream(modelFile),Charset.forName("UTF-8"));){
		
			char[] cs = new char[(int) modelFile.length()];
			isr.read(cs);
			modelContent = new String(cs);
			System.out.println(modelContent);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�������
		modelContent = modelContent.replaceAll("@class@", className);
		modelContent = modelContent.replaceAll("@type@", type);
		modelContent = modelContent.replaceAll("@property@", property);
		modelContent = modelContent.replaceAll("@Uproperty@", uproperty);
		System.out.println(modelContent);
		//�����ļ���
		String fileName = className + ".java";
		File file = new File("D:/test/stream",fileName);
		//д���ļ�
		try (FileWriter fw = new FileWriter(file);){
			
			fw.write(modelContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��ʾ�ļ�·��
		System.out.println("�ļ������ڣ�"+file.getAbsolutePath());
	}

	private static String toUpperFirstLetter(String str) {
		char upperCaseFirst = Character.toUpperCase(str.charAt(0));
		String last = str.substring(1);
		return upperCaseFirst + last;
	}

	private static void testObjectStream() {
		File file = new File("D:/test/stream/read.txt");
		Hero[] hs = new Hero[10];
		for (int i = 0; i < hs.length; i++) {
			hs[i] = new Hero();
			hs[i].name = "hero:"+i;
		}
		try (FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
		){
			oos.writeObject(hs);
			Hero[] hs2 = (Hero[]) ois.readObject();
			for (Hero hero : hs2) {
				System.out.println(hero.name);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
