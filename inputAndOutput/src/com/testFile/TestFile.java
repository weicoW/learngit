package com.testFile;

import java.io.File;
import java.util.Date;

import javax.sound.midi.Synthesizer;

public class TestFile {

	public static void main(String[] args) {
		getMaxFileAndMinFile();
		
//		File f1 = new File("lolFolder");
//		System.out.println(f1.getAbsolutePath());
//		File f2 = new File(f1,"LOL.exe");
//		System.out.println(f2.getAbsolutePath());
//		//��ǰ�ļ���
//		System.out.println(f1);
//		//�Ƿ�����ļ�
//		System.out.println(f1.exists());
//		//�ж��Ƿ�Ϊ�ļ���
//		
//		File file = new File("d:/HBuilder");
//		System.out.println(file.exists());
//		//�ж��Ƿ�Ϊ�ļ���
//		System.out.println(file.isDirectory());
//		//�ж��Ƿ�Ϊ�ļ�
//		System.out.println(file.isFile());
//		//��ȡ�ļ�����
//		System.out.println(file.length());
//		long time = file.lastModified();
//		Date date = new Date(time);
//		System.out.println(date);
		
		//�ַ���ʽ�����ļ����������ļ�
//		String [] ss = file.list();
//		for (String string : ss) {
//			System.out.println(string);
//		}
		//���ļ�������ʽ���ص����ļ��������ļ�
//		File [] fs = file.listFiles();
//		for (File file2 : fs) {
//			System.out.println(file2);
//		}
		//�ַ�����ʽ���������ļ���
//		System.out.println(file.getParent());
//		//�����ļ���
//		f1.mkdir();
//		System.out.println(f1.exists());
	}

	private static void getMaxFileAndMinFile() {

		File file = new File("c:/windows");
		File[] fs = file.listFiles();
		File max = null;
		File min = null;
		
//		for (int i = 0; i < fs.length; i++) {
//			
//			for (int j = 0; j < fs.length-i-1; j++) {
//				if (fs[j].length() > fs[j+1].length()) {
//					File temp = fs[j];
//					fs[j] = fs[j+1];
//					fs[j+1] = temp;
//				}
//			}
//		}
		for (int i = 0; i < fs.length-1; i++) {
			if (fs[i].length() > fs[i+1].length()) {
				max = fs[i];
				if (fs[i+1].length() != 0) {
					min = fs[i+1];
				}
			}
		}
		System.out.println("the max file is:"+max+"�ļ���С��"+max.length());
		System.out.println("the min file is:"+min+"�ļ���С��"+min.length());
		
	}	
}
