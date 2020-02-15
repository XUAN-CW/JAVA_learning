package test;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

public class FileDemo_ 
{
	public static void main(String[] args)
	{
		//��Ҫֱ��ʹ�þ����ļ����������ļ�����Windows���������У�������������ƽ̨�����С�Ӧ��ʹ���뵱ǰĿ¼��ص��ļ���
		//File file = new File(".");//�ļ���Ŀ¼
		File file = new File("src/fileDemo/a");//�ļ�Ŀ¼
		
		System.out.println("�ļ�/�ļ����Ƿ���ڣ�" + file.exists());
		System.out.println("�Ƿ���һ���ļ���" + file.isFile());
		System.out.println("�Ƿ���һ���ļ��У�" + file.isDirectory());
		System.out.println("�ļ�/�ļ������ƣ�" + file.getName());
		System.out.println("�ļ�/�ļ��еľ���·����" + file.getAbsolutePath());
		System.out.println("�ļ�/�ļ�����ռ�ռ��С��" + file.length() / 1024 + "KB");
		System.out.println("�Ƿ�ɶ���" + file.canRead());
		System.out.println("�Ƿ��д��" + file.canWrite());
		System.out.println("�Ƿ����أ�" + file.isHidden());
		System.out.println("�ļ��Ƿ����ִ�У�"+file.canExecute());//linux����Ч
		System.out.println("�ļ�/�ļ��е�����޸�ʱ�䣺" + new Date(file.lastModified()).toLocaleString());
		
		//�����ļ�
		file = new File("src/test/filename.txt");	//file = new File(path+"/"+ filename);
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
		
		//����Ŀ¼
		 File dir = new File("src/fileDemo/file");	//dir = new File(path+"/"+ dirname);
         if(!dir.exists())
             dir.mkdir();
		
//		//ɾ���ļ�/�ļ���
//         if(file.exists())
//         {
//        	 file.delete();
//         }
		
    }

	
}
