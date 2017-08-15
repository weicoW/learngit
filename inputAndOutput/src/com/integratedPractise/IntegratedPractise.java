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
		//文件夹不存在
		if (!srcFile.exists()) {
			return;
		}
		//不是文件夹
		if (!srcFile.isDirectory()) {
			return;
		}
		File[] files = srcFile.listFiles();
		for (File file : files) {
			//是文件,读取文件内容
			if (file.isFile()) {
				char[] data = new char[(int) file.length()];
				try (FileReader reader = new FileReader(file);
				){
					
					reader.read(data);
					String s = new String(data);
					if (s.contains(search)) {
						System.out.println("找到子目标字符串Magic，在文件:"+file.getAbsolutePath());
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//如果是文件夹，就递归调用
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
		//不存在目标文件夹，创建一个
		if (!destf.exists()) {
			destf.mkdirs();
		}
		File[] files = scrf.listFiles();
		for (File file : files) {
			//如果是文件，就复制文件
			if (file.isFile()) {
				File newDestFile = new File(destFolder,file.getName());
				copyFile(file.getAbsolutePath(),newDestFile.getAbsolutePath());	
			}
			//如果是文件夹，递归调用
			if (file.isDirectory()) {
				File newDestFile = new File(destFolder,file.getName());
				copyFolder(file.getAbsolutePath(), newDestFile.getAbsolutePath());
			}
		}
	}

	private static void copyFile(String srcPath, String destPath) {
		File srcFile = new File(srcPath);
		File destFile = new File(destPath);
		//设置缓冲区
		byte[] buffer = new byte[1024*10];
		try (FileInputStream inputStream = new FileInputStream(srcFile);
			FileOutputStream outputStream = new FileOutputStream(destFile);
		){
			while (true) {
				int i = inputStream.read(buffer);
				//没有数据可读
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
