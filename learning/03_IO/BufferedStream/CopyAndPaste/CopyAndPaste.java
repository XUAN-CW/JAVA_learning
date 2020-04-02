package CopyAndPaste;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * ʹ�ô�����������Ӷ�дЧ�� - װ����ʵ��
 */
public class CopyAndPaste {
	/*** �ļ�·�� **/
	private static final String CopyFile = "src/test/test.wmv";
	private static final String PastePath = "src/test/�Ѹ����ļ�.wmv";
	
	public static void main(String[] args) throws IOException {
		
		/*** ʹ�û�����װ��ϵͳ������������ **/
		//�����ֲ��Ѻã����׳��쳣���ͱ�ȡ����
//		BufferedInputStream inStream = new BufferedInputStream(System.in);
//		byte[] bytes = new byte[200];
//		System.out.println("�������ַ�����");
//		inStream.read(bytes);
//		System.out.println("�û�������ַ����ǣ�" + new String(bytes));
		
		/*** ʹ�û����������ļ� **/
		long time = CopyFileByBufferedStream();
		System.out.println("������ʱ��" + time + "����");

//		//С��ҵ�����λС�������ʹ��FileInputStreamʵ���ļ��ĸ���
//		//ͨ���������õ�ʱ�䣬�Ա�ʹ�û���ĺô�
//		//ͨ�����ò�ͬ�Ļ����С�����Ч�ʵ�����
	}
	
	/**
	 * ʹ�û����������ļ�
	 * @return �������̵���ʱ�����룩
	 */
	private static long CopyFileByBufferedStream(){
		File file = new File(CopyFile);		//Ҫ���Ƶ��ļ�����
		if(!file.exists()){
			System.out.println("�ļ������ڣ�����ʧ�ܣ�");
			return 0;
		}
		long starTime = System.currentTimeMillis();
		InputStream inStream = null;
		BufferedInputStream buffInStream = null;
		OutputStream outStream = null;
		BufferedOutputStream buffOutStream = null;
		int theSizeOfBuffer = 1024; 	//�������޸Ļ���Ĵ�С�����������ʱ����
		try {
			inStream = new FileInputStream(file);
			buffInStream = new BufferedInputStream(inStream,theSizeOfBuffer);
			outStream = new FileOutputStream(PastePath);
			buffOutStream = new BufferedOutputStream(outStream);
			int i = -1;//��ȡ������ʱ����
			while((i = buffInStream.read()) != -1){	//д�뵽�˻�����
				buffOutStream.write(i);	//�����е�����д�뵽�ļ���
				//ע�⣺��ȡһ���ֽڣ���д�뵽�˻����У���Ҫ����󣬽������е�����д�뵽�ļ��У�.
				//������Ҫ��ջ���������������������д���ļ��� - flush()
			}
			System.out.println("�ļ����Ƴɹ���");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//bOutStream.flush();
				buffOutStream.close();//����ֱ�ӵ���close�������ڲ��Ѿ��������Զ�������flush����
				outStream.close();
				buffInStream.close();
				inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		return endTime - starTime;
	}
	
	
	
	
	
}
