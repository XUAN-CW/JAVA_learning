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
		/*** 创建测试文件 **/
		final String testFilePath = "src/test/test.txt";	//路径不对，修改这里
		File testFile = new File(testFilePath );	//file = new File(path+"/"+ filename);
		if(!testFile.exists())
			try {
				testFile.createNewFile();
				System.out.println("文件已创建");
			} catch (IOException e) {
				e.printStackTrace();
			}
		else {
			System.out.println("文件已存在\n");
		}
		
		/*** 增加缓存 - 写 **/
		BufferedOutputStream buffOutputStream = null;
		try {
			buffOutputStream = new BufferedOutputStream(new FileOutputStream(testFilePath),1024);	//不专业的写法，参考下面的【读】
			buffOutputStream.write("这里是写入的内容".getBytes());
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
	
		/*** 增加缓存 - 读 **/
		FileInputStream fInputStream = null;
		BufferedInputStream buffInputStream = null;	//防止无法关闭，放在try/catch外面
		try {
			fInputStream = new FileInputStream(testFilePath);
			buffInputStream = new BufferedInputStream(fInputStream,1024 * 10);	//不要太大，迅雷也就几十M
			byte[] bytes = new byte[buffInputStream.available()];
			buffInputStream.read(bytes);
			System.out.println(new String(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {	//先关缓存流，再关文件流
			try {
				buffInputStream.close();
				fInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
}
