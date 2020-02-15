package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ʹ���ַ������ļ����л����Ķ�д����
 * �����ı��ļ�,ʹ��BufferedReader,BufferedWriter���ж�дЧ�ʸ���
 * ��Чԭ��ʹ���˻�����
 * ��������:�Ȱ��ı����ݶ�д��������,����������,�Զ��ѻ������е����ݶ�д���ļ�(defaultCharBufferSize = 8192)
 */
public class BufferedReader_BufferedWriter {
	private static final String FilePath = "src/test/test.txt";
	
	public static void main(String[] args) {
		
		/*** �����ļ� **/
		File file = new File(FilePath);	//file = new File(path+"/"+ filename);
		if(!file.exists())
			try {
				file.createNewFile();
				System.out.println("�ļ��Ѵ���");
			} catch (IOException e) {
				e.printStackTrace();
			}
		else {
			System.out.println("�ļ��Ѵ���");
		}
		
		/*** Ҫд����ַ��� **/
		String content = "package com.xuetang9.javabase.chapter13;\n";
		content += "//�����ɴ����Զ�����\n";
		content += "public class FileDemo1{\n";
		content += "\tpublic static void main(String[] args){\n";
		content += "\t\tSystem.out.println(\"Hello World!\");\n\t}\n}";
		try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(FilePath))) {
			//ʹ����jdk7�Ժ��������Զ��ر���Դ��д��
			//ʹ��ǰ�᣺��Դ�����ʵ��Closeable�ӿ�
			bWriter.write(content);	//���ַ���д�뵽������
			System.out.println(content);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			//ע�⣺����bWriter.close���׳�IOException��������쳣�ͱ��½ṹ������
			//���µĴ��������鿴�����Ƶ��쳣��Ϣ
//			if(e.getSuppressed() != null){
//				Throwable[] throwables = e.getSuppressed();
//				for(Throwable t : throwables){
//					System.err.println(t.getMessage() + "cased by " + t.getClass().getSimpleName());
//				}
//			}
		}
		
		/*** �� - ���ж�ȡ **/
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(FilePath));
			//�̶��Ķ�ȡ��ʽ��
			String line = null;
			while((line = bReader.readLine()) != null){
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
