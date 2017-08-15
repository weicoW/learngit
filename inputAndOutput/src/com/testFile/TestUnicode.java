package com.testFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Stack;

public class TestUnicode {

	public static void main(String[] args) {
		File file = new File("D:/test/stream/read.txt");
		byte[] data = new byte[(int) file.length()];
		byte[] bom = {(byte) 0xef,(byte) 0xbb,(byte) 0xbf};
		try (FileInputStream inputStream = new FileInputStream(file)){
			inputStream.read(data);
			System.out.println("读取出来的数据是");
			for (byte b : data) {
				int i = b&0x000000ff;
				System.out.println(Integer.toHexString(i));
			}
			System.out.println("把这个数字放在GBK棋牌上");
			String string = new String(data, "GBK");
			System.out.println(string);
			System.out.println("把数字放到UTF-8棋盘上");
			String str = new String(data, "UTF-8");
			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//输出默认编码方式
//		System.out.println(Charset.defaultCharset());
//		try (FileReader reader = new FileReader(file)){
//			char[] date = new char[(int) file.length()];
//			reader.read(date);
//			System.out.format("fileReader使用默认编码方式%s输出,识别出来的字符是:%n", Charset.defaultCharset());
//			System.out.println(new String(date));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8"));){
//			char [] data = new char[(int) file.length()];
//			reader.read(data);
//			System.out.println("使用inputStreamReader指定编码，识别出来的字符是");
//			System.out.println(new String(data));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//numberToWord();
		removeBom(data,bom);
	}

	private static void removeBom(byte[] data, byte[] bom) {
		
		try {
			String s = new String(Arrays.copyOfRange(data, bom.length, data.length), "UTF-8");
			System.out.print("去掉bom之后:");
			System.out.println(s);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void numberToWord() {
		
//      找出 E5 B1 8C 这3个十六进制对应UTF-8编码的汉字 
        byte[] bs = new byte[3];
        bs[0] = (byte) 0xE5;
        bs[1] = (byte) 0xB1;
        bs[2] = (byte) 0x8C;
         
        String str;
		try {
			str = new String(bs,"UTF-8");
			System.out.println("E5 B1 8C 对应的字符是："+str);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}
	
	
	
}
