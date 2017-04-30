package com.hk.line_editor.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import com.hk.line_editor.exception.ArgumentException;

public class FileManager {
	
	private static FileManager instance;
	private FileManager() {
	}
	public static FileManager getInstance() {
		if(instance == null)
			instance = new FileManager();
		return instance;
	}

	public static String load_file(String addr, String encoding) throws ArgumentException{
		List<StringBuffer> lineList;

		try {
			BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(addr), encoding));
			lineList = new LinkedList<>();
			String ch;

			while ((ch = buff.readLine()) != null) { // 하나하나씩 받아오고 출력시킨다!
				lineList.add(new StringBuffer(ch));
				System.out.print(ch);
				System.out.println();
			}

			Registry.register(lineList);
			buff.close(); // 파일을 닫음.
		} catch (IOException e) {
			throw new ArgumentException(e , addr);
			
		}
		return fileName(addr);
	}
	
	private static String fileName(String path) {
		String fileName = null;
		StringTokenizer st = new StringTokenizer(path , "\\");
		while(st.hasMoreTokens()) {
			fileName = st.nextToken();
		}
		return fileName;
	}

	public static void save_file(String addr,String encoding) {
		List<StringBuffer> lineList;
		lineList = Registry.getText();

		Iterator iterator = lineList.iterator();
		OutputStreamWriter writer = null;
		BufferedWriter buffer = null;

		try {
			writer = new OutputStreamWriter(new FileOutputStream(addr), encoding);
			buffer = new BufferedWriter(writer);
			while (iterator.hasNext()) {
				buffer.write(iterator.next().toString());
				buffer.newLine();
			}

			Registry.unRegister();
			buffer.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
