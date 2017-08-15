package com.integratedPractise;

import java.awt.geom.RectangularShape;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.plaf.synth.SynthScrollBarUI;
import javax.swing.text.AbstractDocument.LeafElement;
import javax.xml.crypto.Data;

public class IntegratedPractise{

	public static void main(String[] args) {
//		String srcFile = "D:/test/stream/Hero.java";
//		String destFile = "D:/test/stream/Hero2.java";
//		String scrFolderPath = "E:/project";
//		String destFolderPath = "D:/project";
		
		//copyFile(srcFile,destFile);
		//copyFolder(scrFolderPath,destFolderPath);
		File srcFile = new File("E:/project");
		String search = "Magic";
		search(srcFile,search);
	}

	private static void search(File srcFile, String search) {
		//�ļ��в�����
		if (!srcFile.exists()) {
			return;
		}
		//�����ļ���
		if (!srcFile.isDirectory()) {
			return;
		}
		File[] files = srcFile.listFiles();
		for (File file : files) {
			//���ļ�,��ȡ�ļ�����
			if (file.isFile()) {
				char[] data = new char[(int) file.length()];
				try (FileReader reader = new FileReader(file);
				){
					
					reader.read(data);
					String s = new String(data);
					if (s.contains(search)) {
						System.out.println("�ҵ���Ŀ���ַ���Magic�����ļ�:"+file.getAbsolutePath());
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//������ļ��У��͵ݹ����
			if (file.isDirectory()) {
				File newSrcFile = new File(srcFile.getAbsolutePath(),file.getName());
				search(newSrcFile, search);
			}
		}
		
	}

	private static void copyFolder(String scrFolder, String destFolder) {
		
		File scrf = new File(scrFolder);
		File destf = new File(destFolder);
		
		if (!scrf.exists()) {
			return;
		}
		if (!scrf.isDirectory()) {
			return;
		}
		if (destf.isFile()) {
			return;
		}
		//������Ŀ���ļ��У�����һ��
		if (!destf.exists()) {
			destf.mkdirs();
		}
		File[] files = scrf.listFiles();
		for (File file : files) {
			//������ļ����͸����ļ�
			if (file.isFile()) {
				File newDestFile = new File(destFolder,file.getName());
				copyFile(file.getAbsolutePath(),newDestFile.getAbsolutePath());	
			}
			//������ļ��У��ݹ����
			if (file.isDirectory()) {
				File newDestFile = new File(destFolder,file.getName());
				copyFolder(file.getAbsolutePath(), newDestFile.getAbsolutePath());
			}
		}
	}

	private static void copyFile(String srcPath, String destPath) {
		File srcFile = new File(srcPath);
		File destFile = new File(destPath);
		//���û�����
		byte[] buffer = new byte[1024*10];
		try (FileInputStream inputStream = new FileInputStream(srcFile);
			FileOutputStream outputStream = new FileOutputStream(destFile);
		){
			while (true) {
				int i = inputStream.read(buffer);
				//û�����ݿɶ�
				if (-1 == i) {
					break;
				}
				outputStream.write(buffer, 0, i);
				outputStream.flush();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	private static void copyFile(String srcFile, String destFile) {
//		File scr = new File(srcFile);
//		File dest = new File(destFile);
//		char[] data = new char[(int) scr.length()];
//		try (FileReader fr = new FileReader(scr);){
//			
//			fr.read(data);
//			System.out.println(new String(data));
//		}  catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try (FileWriter writer = new FileWriter(dest);){
//			
//			writer.write(new String(data));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

	
}
