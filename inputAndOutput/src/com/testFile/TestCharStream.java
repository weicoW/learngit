package com.testFile;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestCharStream {

	public static void main(String[] args) {
		File encodingFile = new File("d:/encoding.txt");
		File encodedFile = new File("d:encoded.txt");
		if (encodingFile.exists()) {
			encodeFile(encodingFile, encodedFile);
		}
	}
	
	public static void encodeFile(File encodingFile,File encodedFile){
		char [] data = new char[(int) encodingFile.length()];
		try(FileReader reader = new FileReader(encodingFile);) {
			reader.read(data);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < data.length; i++) {
			if (data[i] >= '0' && data[i] < '9') {
				data[i] += 1;
			}else if (data[i]=='9') {
				data[i] = '0';
			}else if (data[i] >= 'A' && data[i] < 'Z') {
				data[i] += 1;
			}else if (data[i] == 'Z') {
				 data[i] = 'A';
			}else if (data[i] >= 'a' && data[i] < 'z') {
				data[i] += 1;
			}else if (data[i] == 'z') {
				data[i] = 'a';
			}
		}
		try (FileWriter writer = new FileWriter(encodedFile)){
			writer.write(data);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
