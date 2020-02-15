package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 必检异常 - 除了RunTimeExcetion和Error的其他类的子类
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年8月8日 上午10:36:40
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class CheckedException_ {
	public static void main(String[] args) {//arguments
		
		
		
		File file = new File("c:/test.txt");	//文件不存在
		try {
			FileWriter writer = new FileWriter(file);	//试图在不存在的文件中写入内容，必须检测异常
		} catch (IOException e) {
			e.printStackTrace();
		}//文件的写入器，用来将内容写入到文件中
		//判断这个文件是否存在
		System.out.println(file.exists());
	}
}
