package array;

import java.util.Scanner;

public class Array 
{
	public static void main(String[] args)
	{
		/*** �����Դ����� **/
		double[] scores = new double[10]; 
		System.out.println( scores.length);
		
		/*** �ڴ���� **/
		int num;								//�����������ʱ����ջ�ڴ���ֱ�ӷ����˿ռ䣨����Ҫ�ֶ�����ռ䣩
		num = 9;
		int[] nums = new int[5];				//�ڶ��ڴ��з�����5��int���ʹ�С�Ŀռ�
		System.out.println(nums);
		Scanner input = new Scanner(System.in); //new:�ڶ��ڴ��з����˿ռ�
		input.next();   
	}
}
