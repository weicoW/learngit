package com.testFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class TestBufferReader {

	public static void main(String[] args) {
		
//		try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file) , Charset.forName("GBK"));
//				BufferedReader br = new BufferedReader(reader);
//			){
//				while (true) {
//					String line = br.readLine();
//					if (null == line) {
//						break;
//					}
//				System.out.println(line);
//			}
//		}  catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try (FileWriter writer = new FileWriter(file);
//			PrintWriter pw = new PrintWriter(writer);){
//			
//			pw.println("garen kill teemo");
//			pw.flush();
//			pw.println("解放路开始的弗兰克");
//		
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		write();
		read();
		
		
		
	}

	private static void read() {
		File file = new File("D:/test/stream/read.txt");
		try (FileInputStream fis = new FileInputStream(file);
				DataInputStream dis = new DataInputStream(fis);
			){
				for (int i = 0; i < 2; i++) {
					int j = dis.readInt();
		            System.out.println(j);
				}
	            
		} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		try (FileReader fr = new FileReader(file);
//			BufferedReader br = new BufferedReader(fr);){
//			
//			String s = br.readLine();
//			char [] cs = s.toCharArray();
//			for (char c : cs) {
//				if ('-' == c) {
//					System.out.println();
//					continue;
//				}
//				System.out.print(c);
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	private static void write() {
		File file = new File("D:/test/stream/read.txt");
		try (FileOutputStream outputStream = new FileOutputStream(file);
				DataOutputStream dos = new DataOutputStream(outputStream);){
		
				dos.writeInt(300);
				dos.writeInt(45);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		try (FileOutputStream fos = new FileOutputStream(file);	
//				PrintWriter pw = new PrintWriter(fos);){
//				
//				String s = "32-45";
//				pw.println(s);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	}

}
