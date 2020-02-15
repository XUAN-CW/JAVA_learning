package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class BufferedStreamDemo {
	public static void main(String[] args)
	{ 
		/*** ���������ļ� **/
		final String testFilePath = "src/test/test.txt";	//·�����ԣ��޸�����
		File testFile = new File(testFilePath );	//file = new File(path+"/"+ filename);
		if(!testFile.exists())
			try {
				testFile.createNewFile();
				System.out.println("�ļ��Ѵ���");
			} catch (IOException e) {
				e.printStackTrace();
			}
		else {
			System.out.println("�ļ��Ѵ���\n");
		}
		
		/*** ���ӻ��� - д **/
		BufferedOutputStream buffOutputStream = null;
		try {
			buffOutputStream = new BufferedOutputStream(new FileOutputStream(testFilePath),1024);	//��רҵ��д�����ο�����ġ�����
			buffOutputStream.write("������д�������".getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				buffOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
		/*** ���ӻ��� - �� **/
		FileInputStream fInputStream = null;
		BufferedInputStream buffInputStream = null;	//��ֹ�޷��رգ�����try/catch����
		try {
			fInputStream = new FileInputStream(testFilePath);
			buffInputStream = new BufferedInputStream(fInputStream,1024 * 10);	//��Ҫ̫��Ѹ��Ҳ�ͼ�ʮM
			byte[] bytes = new byte[buffInputStream.available()];
			buffInputStream.read(bytes);
			System.out.println(new String(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {	//�ȹػ��������ٹ��ļ���
			try {
				buffInputStream.close();
				fInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
}
