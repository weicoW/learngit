package com.testFile;

import java.awt.event.FocusEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class TestStream {

	public static void main(String[] args) {
//		File f  = new File("readme.txt");
//		try {
//			//创建一个文件输出流
//			FileInputStream inputStream = new FileInputStream(f);
//			//穿件字节数组接受
//			byte[] bs = new byte[(int) f.length()];
//			//以字节流的形式读取文件
//			inputStream.read(bs);
//			for (byte b : bs) {
//				System.out.println(b);
//			}
//			//关闭流
//			inputStream.close();
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		File file = new File("read.txt");
//		byte[] data = {65,98,48};
//		try {
//			FileOutputStream outputStream = new FileOutputStream(file);
//			outputStream.write(data);
//			outputStream.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		streamPractise();
		
	}
	
	public static void streamPractise(){
//		File f = new File("d:/test/stream/read.txt");
//		File dir = f.getParentFile();
//		if (!dir.exists()) {
//			dir.mkdirs();
//		}
//		byte data[] = {88,89};
//		try {
//			FileOutputStream outputStream = new FileOutputStream(f);
//			outputStream.write(data);
//			outputStream.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		/* 下标异常代码
		try {
			if (file.exists()) {
				FileInputStream inputStream = new FileInputStream(file);
				byte[] data = new byte[102400];
				for (int i = 0; i < file.length(); i++) {
					if ((i+1)*1024 > file.length() ) {
						inputStream.read(data, i*102400, (int) (file.length()-i*102400));
					}
					inputStream.read(data, i*102400, 102400);
					File f = new File("E:/Irving/Git/git-bash.exe-"+i);
					FileOutputStream outputStream = new FileOutputStream(f);
					if (data.length < 102400) {
						outputStream.write(data);
						break;
					}
					outputStream.write(data, i*102400, 102400);
					outputStream.close();
				}
				inputStream.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		File file = new File("E:/Irving/Git/git-bash.exe");
		int eachSize = 100 * 1024;//100k
		if (file.length() == 0) {
			throw new RuntimeException("长度为0，不可拆分");
		}
		byte[] data = new byte[(int) file.length()];
		//把文件读取到数组
		FileInputStream inputStream = null;
		try {
			 inputStream = new FileInputStream(file);
			inputStream.read(data);
			
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		//计算需要多少个文件
		int fileNumber;
		if (data.length % eachSize == 0) {
			fileNumber = data.length / eachSize;
		}else {
			fileNumber = data.length / eachSize +1;
		}
		//迭代把数据从数组分段写进新的文件
		for (int i = 0; i < fileNumber; i++) {
			String fileName = file.getName() +"-"+ i;
			File eachFile = new File(file.getParent(),fileName );
			byte[] eachData;
			if (i == fileNumber-1) {
				eachData = Arrays.copyOfRange(data, eachSize * i, data.length);
			}else {
				eachData = Arrays.copyOfRange(data, i * eachSize, eachSize * (i + 1));
			}
			//把数组写到文件
			try (FileOutputStream outputStream = new FileOutputStream(eachFile)){
				outputStream.write(eachData);
				outputStream.close();
				//输出文件信息
				System.out.format("输出子文件%s,大小为 %d 字节 %n", eachFile.getName(),eachFile.length());
			}  catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
