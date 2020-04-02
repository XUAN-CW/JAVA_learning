package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * ��ʾ�ļ����롢������Ļ����÷�
 * ���ֽڶ�ȡ����Ч
 * ע�⣺Ŀǰ���x����ʽ߀���^ԭʼ�����h���@�e��ϤInputStream/OutputStream��һЩ���÷�������
 */
public class OutputStream_InputStream {
	public static void main(String[] args) throws IOException
	{
		/*** ���������ļ� **/
		final String currentFilePath = "src/test/test.txt";	//·�����ԣ��޸�����
		File testFile=new File(currentFilePath );	//file = new File(path+"/"+ filename);
		if(!testFile.exists())
			try {
				testFile.createNewFile();
				System.out.println("�ļ��Ѵ���");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else {
			System.out.println("�ļ��Ѵ���\n");
		}

		/*** д���ļ� **/
		// �����ָ������ļ�
		//����ʵ�ָ��� - ��̬��FileOutputStream extends OutputStream�����ڵ�70�У�
		//OutputStream outStream = new FileOutputStream(currentFilePath,true);	//׷��д��
		OutputStream outStream = new FileOutputStream(currentFilePath,false);	//����д��
		String outString = "������д�������";
		outStream.write(outString.getBytes());
		outStream.close();	//�ر��ļ�
		
		/*** ��ȡ�ļ��Ļ������� - ���ֽڶ�ȡ **/
		//ԭʼ��Ч
		// ������ָ������ļ�
		//����ʵ�ָ��� - ��̬
		InputStream inputStream = new FileInputStream(testFile);	//����try-catch����Ϊ����Ҫ�õ���inputStream��
		byte[] bytes = new byte[20000];		//ֻ�ܶ�20000�ֽ�
		int count = 0;
		while ((bytes[count] = (byte)inputStream.read() ) != -1) {
			count++;
		}
		bytes[count] = 0;	//ȥ���ʺţ�û����������һ���ʺ�
		String content = new String(bytes);
		System.out.println(content);
		inputStream.close(); 	//�ر��ļ�
	}

}







