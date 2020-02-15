package array;

import java.util.Scanner;

public class Array 
{
	public static void main(String[] args)
	{
		/*** 数组自带长度 **/
		double[] scores = new double[10]; 
		System.out.println( scores.length);
		
		/*** 内存分配 **/
		int num;								//处理基本类型时：在栈内存中直接分配了空间（不需要手动分配空间）
		num = 9;
		int[] nums = new int[5];				//在堆内存中分配了5个int类型大小的空间
		System.out.println(nums);
		Scanner input = new Scanner(System.in); //new:在堆内存中分配了空间
		input.next();   
	}
}
