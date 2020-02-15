package txtInputSimulator04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class SaveAndRead {
	
	public SaveAndRead(){
		super();
	}
	
	public void save(String path,String content) {
		File newFile = new File(path);//�ļ�Ŀ¼
		/** �����ļ�������ļ��Ѵ�������ո��ļ� */
		if(newFile.exists()) {
			try {
					FileWriter fileWriter =new FileWriter(newFile);
					fileWriter.write("");
					fileWriter.flush();
					fileWriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				newFile.createNewFile();
				System.out.println("�ļ��Ѵ���");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/*** ���ӻ��� - д **/
		FileOutputStream fOutputStream=null;
		BufferedOutputStream buffOutputStream = null;	//��ֹ�޷��رգ�����try/catch����
		try {
			fOutputStream=new FileOutputStream(path);
			buffOutputStream=new BufferedOutputStream(fOutputStream, 1024);//��Ҫ̫��Ѹ��Ҳ�ͼ�ʮM
			buffOutputStream.write(content.getBytes());
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
		
	}
	
	public String read(String path) {
		String content="";
		File file = new File(path);//�ļ�Ŀ¼
		/** �ļ�������ֱ�Ӷ�ȡ���ļ��������򴴽��ļ� */
		if(file.exists()) {//�ļ�����
			/*** ���ӻ��� - �� **/
			FileInputStream fInputStream = null;
			BufferedInputStream buffInputStream = null;	//��ֹ�޷��رգ�����try/catch����
			try {
				fInputStream = new FileInputStream(path);
				buffInputStream = new BufferedInputStream(fInputStream,1024);	//��Ҫ̫��Ѹ��Ҳ�ͼ�ʮM
				byte[] bytes = new byte[buffInputStream.available()];
				buffInputStream.read(bytes);
//				System.out.println(new String(bytes));
				content=new String(bytes);
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
		else {
				try {
					file.createNewFile();
//					System.out.println("�ļ��Ѵ���");
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return content;
	}
}
