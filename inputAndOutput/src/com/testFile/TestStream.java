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
//			//����һ���ļ������
//			FileInputStream inputStream = new FileInputStream(f);
//			//�����ֽ��������
//			byte[] bs = new byte[(int) f.length()];
//			//���ֽ�������ʽ��ȡ�ļ�
//			inputStream.read(bs);
//			for (byte b : bs) {
//				System.out.println(b);
//			}
//			//�ر���
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
		
		/* �±��쳣����
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
			throw new RuntimeException("����Ϊ0�����ɲ��");
		}
		byte[] data = new byte[(int) file.length()];
		//���ļ���ȡ������
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
		//������Ҫ���ٸ��ļ�
		int fileNumber;
		if (data.length % eachSize == 0) {
			fileNumber = data.length / eachSize;
		}else {
			fileNumber = data.length / eachSize +1;
		}
		//���������ݴ�����ֶ�д���µ��ļ�
		for (int i = 0; i < fileNumber; i++) {
			String fileName = file.getName() +"-"+ i;
			File eachFile = new File(file.getParent(),fileName );
			byte[] eachData;
			if (i == fileNumber-1) {
				eachData = Arrays.copyOfRange(data, eachSize * i, data.length);
			}else {
				eachData = Arrays.copyOfRange(data, i * eachSize, eachSize * (i + 1));
			}
			//������д���ļ�
			try (FileOutputStream outputStream = new FileOutputStream(eachFile)){
				outputStream.write(eachData);
				outputStream.close();
				//����ļ���Ϣ
				System.out.format("������ļ�%s,��СΪ %d �ֽ� %n", eachFile.getName(),eachFile.length());
			}  catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
