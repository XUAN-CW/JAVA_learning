package test;

import java.util.Scanner;

public class StringConcatenation 
{
	public static void main(String[] args)
	{	
		
		
		/*** ��+��ƴ�� **/
		//�򵥷��㵫��Ч������������ʹ��
		String str1 = "a";
		String str2 = "b";
		String str3 = str1 + str2;
		System.out.println(str3);
		//�ײ�ʵ��:
		//�����ַ���ƴ�ӵ� + �ţ��ײ���ʵ��ʹ��StringBuffer ���� StringBuilder����ɵġ�
		StringBuffer str3_ = new StringBuffer(String.valueOf(str1)).append(str2);
		System.out.println(str3_);
		//���ԣ�ƴ�������
		final int N = 50000;	
		long startTime = System.currentTimeMillis();
		String str = "*";
		for(int i = 0; i < N; i++)
		{
			str += "*";
		}
		long endTime = System.currentTimeMillis();
		System.out.println("+=��ʱ��" + (endTime - startTime) + "����");

		
		/*** ��StringBuffer��ƴ�� **/
		startTime = System.currentTimeMillis();
		StringBuffer strBuff = new StringBuffer("*");
		for(int i = 0; i < N; i++)
		{
			strBuff.append("*");
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuffer��append��ʱ��" + (endTime - startTime) + "����");
		
		
		/*** ��StringBuilder��ƴ�� **/
		//����ȫ������ȫ��ԭ�����������Ժ���˵
		startTime = System.currentTimeMillis();
		StringBuilder strBui = new StringBuilder("*");
		for(int i = 0; i < N; i++)
		{
			strBui.append("*");
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuilder��append��ʱ��" + (endTime - startTime) + "����");
		
		
		
		
		
		
		
		
	}
	
	
}
