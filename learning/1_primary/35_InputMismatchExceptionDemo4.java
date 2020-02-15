package test;

import java.util.Scanner;

/**
 * 输入不匹配异常示例
 * 用户输入的年龄只能是整型数字，使用异常处理机制捕获并处理异常情况
 */
public class InputMismatchExceptionDemo_ {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入年龄（必须是整型数字）:");
		int age = -1;
		try {
			age = input.nextInt();
			
			age = age / 0;
			
		} catch (ArithmeticException e) {	//先捕获子类异常
			e.printStackTrace();
			
		} catch (Exception e) {		//子类异常捕获不了就捕获父类异常
			
			//System.err.println(e.getMessage());
			
			/*** 堆栈方式打印异常信息 **/
			//一般在开发的时候使用
			e.printStackTrace();
			
		} 
		System.out.println("输入的年龄是：" + age);
	}

}








