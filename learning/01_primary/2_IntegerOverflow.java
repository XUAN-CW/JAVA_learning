package overflow;

import java.lang.Math;

public class IntegerOverflow 
{
	public static void main(String[] args)
	{
		/*** ��� **/
		int overflow = Integer.MIN_VALUE;
		Math.abs(overflow);
		System.out.println("������Сֵ�ľ���ֵ���:" + overflow);
		System.out.println("�������ֵ��" + Integer.MAX_VALUE);
	}

}
