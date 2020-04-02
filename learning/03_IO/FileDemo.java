package test;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

public class FileDemo_ 
{
	public static void main(String[] args)
	{
		//不要直接使用绝对文件名。绝对文件名在Windows上正常运行，但不能在其他平台上运行。应该使用与当前目录相关的文件名
		//File file = new File(".");//文件根目录
		File file = new File("src/fileDemo/a");//文件目录
		
		System.out.println("文件/文件夹是否存在：" + file.exists());
		System.out.println("是否是一个文件：" + file.isFile());
		System.out.println("是否是一个文件夹：" + file.isDirectory());
		System.out.println("文件/文件夹名称：" + file.getName());
		System.out.println("文件/文件夹的绝对路径：" + file.getAbsolutePath());
		System.out.println("文件/文件夹所占空间大小：" + file.length() / 1024 + "KB");
		System.out.println("是否可读：" + file.canRead());
		System.out.println("是否可写：" + file.canWrite());
		System.out.println("是否隐藏：" + file.isHidden());
		System.out.println("文件是否可以执行："+file.canExecute());//linux下有效
		System.out.println("文件/文件夹的最后修改时间：" + new Date(file.lastModified()).toLocaleString());
		
		//创建文件
		file = new File("src/test/filename.txt");	//file = new File(path+"/"+ filename);
		if(!file.exists())
			try {
				file.createNewFile();
				System.out.println("文件已创建");
			} catch (IOException e) {
				e.printStackTrace();
			}
		else {
			System.out.println("文件已存在");
		}
		
		//创建目录
		 File dir = new File("src/fileDemo/file");	//dir = new File(path+"/"+ dirname);
         if(!dir.exists())
             dir.mkdir();
		
//		//删除文件/文件夹
//         if(file.exists())
//         {
//        	 file.delete();
//         }
		
    }

	
}
