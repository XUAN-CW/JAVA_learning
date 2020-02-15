package test;

import java.util.Scanner;

public class StringConcatenation 
{
	public static void main(String[] args)
	{	
		
		
		/*** 【+】拼接 **/
		//简单方便但低效，适用于少量使用
		String str1 = "a";
		String str2 = "b";
		String str3 = str1 + str2;
		System.out.println(str3);
		//底层实现:
		//对于字符串拼接的 + 号，底层其实是使用StringBuffer 或者 StringBuilder来完成的。
		StringBuffer str3_ = new StringBuffer(String.valueOf(str1)).append(str2);
		System.out.println(str3_);
		//测试：拼接五万次
		final int N = 50000;	
		long startTime = System.currentTimeMillis();
		String str = "*";
		for(int i = 0; i < N; i++)
		{
			str += "*";
		}
		long endTime = System.currentTimeMillis();
		System.out.println("+=用时：" + (endTime - startTime) + "毫秒");

		
		/*** 【StringBuffer】拼接 **/
		startTime = System.currentTimeMillis();
		StringBuffer strBuff = new StringBuffer("*");
		for(int i = 0; i < N; i++)
		{
			strBuff.append("*");
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuffer的append用时：" + (endTime - startTime) + "毫秒");
		
		
		/*** 【StringBuilder】拼接 **/
		//不安全，不安全的原因听不懂，以后再说
		startTime = System.currentTimeMillis();
		StringBuilder strBui = new StringBuilder("*");
		for(int i = 0; i < N; i++)
		{
			strBui.append("*");
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuilder的append用时：" + (endTime - startTime) + "毫秒");
		
		
		
		
		
		
		
		
	}
	
	
}
