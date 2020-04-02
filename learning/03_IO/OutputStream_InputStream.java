package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * 演示文件输入、输出流的基本用法
 * 逐字节读取，低效
 * 注意：目前的讀寫方式還比較原始，建議在這裡熟悉InputStream/OutputStream的一些重用方法即可
 */
public class OutputStream_InputStream {
	public static void main(String[] args) throws IOException
	{
		/*** 创建测试文件 **/
		final String currentFilePath = "src/test/test.txt";	//路径不对，修改这里
		File testFile=new File(currentFilePath );	//file = new File(path+"/"+ filename);
		if(!testFile.exists())
			try {
				testFile.createNewFile();
				System.out.println("文件已创建");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else {
			System.out.println("文件已存在\n");
		}

		/*** 写入文件 **/
		// 输出流指向测试文件
		//子类实现父类 - 多态【FileOutputStream extends OutputStream】（在第70行）
		//OutputStream outStream = new FileOutputStream(currentFilePath,true);	//追加写入
		OutputStream outStream = new FileOutputStream(currentFilePath,false);	//覆盖写入
		String outString = "这里是写入的内容";
		outStream.write(outString.getBytes());
		outStream.close();	//关闭文件
		
		/*** 读取文件的基本操作 - 逐字节读取 **/
		//原始低效
		// 输入流指向测试文件
		//子类实现父类 - 多态
		InputStream inputStream = new FileInputStream(testFile);	//不用try-catch是因为下面要用到【inputStream】
		byte[] bytes = new byte[20000];		//只能读20000字节
		int count = 0;
		while ((bytes[count] = (byte)inputStream.read() ) != -1) {
			count++;
		}
		bytes[count] = 0;	//去掉问号，没有这句会多出来一个问号
		String content = new String(bytes);
		System.out.println(content);
		inputStream.close(); 	//关闭文件
	}

}







