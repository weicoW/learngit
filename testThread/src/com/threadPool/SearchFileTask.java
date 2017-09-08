package com.threadPool;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchFileTask implements Runnable {

	private File file;
	private String search;

	public SearchFileTask(File srcFile, String search) {
		this.file = srcFile;
		this.search = search;
	}

	public void run() {
		String fileContent = readFileConent(file);
        if(fileContent.contains(search)){
            System.out.printf( "�߳�: %s �ҵ���Ŀ���ַ���%s,���ļ�:%s%n",Thread.currentThread().getName(), search,file);
             
        }
	}

	private String readFileConent(File file) {
		try (FileReader fr = new FileReader(file)) {
            char[] all = new char[(int) file.length()];
            fr.read(all);
            return new String(all);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
		
	}

}
