package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 使用字符流对文件进行基本的读写操作
 * 对于文本文件,使用BufferedReader,BufferedWriter进行读写效率更高
 * 高效原因：使用了缓存区
 * 工作流程:先把文本内容读写到缓存区,缓存区满了,自动把缓存区中的内容读写到文件(defaultCharBufferSize = 8192)
 */
public class BufferedReader_BufferedWriter {
	private static final String FilePath = "src/test/test.txt";
	
	public static void main(String[] args) {
		
		/*** 创建文件 **/
		File file = new File(FilePath);	//file = new File(path+"/"+ filename);
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
		
		/*** 要写入的字符串 **/
		String content = "package com.xuetang9.javabase.chapter13;\n";
		content += "//本类由代码自动生成\n";
		content += "public class FileDemo1{\n";
		content += "\tpublic static void main(String[] args){\n";
		content += "\t\tSystem.out.println(\"Hello World!\");\n\t}\n}";
		try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(FilePath))) {
			//使用了jdk7以后新增的自动关闭资源的写法
			//使用前提：资源类必须实现Closeable接口
			bWriter.write(content);	//将字符串写入到缓冲中
			System.out.println(content);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			//注意：由于bWriter.close会抛出IOException，这里的异常就被新结构抑制了
			//以下的代码用来查看被抑制的异常信息
//			if(e.getSuppressed() != null){
//				Throwable[] throwables = e.getSuppressed();
//				for(Throwable t : throwables){
//					System.err.println(t.getMessage() + "cased by " + t.getClass().getSimpleName());
//				}
//			}
		}
		
		/*** 读 - 逐行读取 **/
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(FilePath));
			//固定的读取格式：
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
