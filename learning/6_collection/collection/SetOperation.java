package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ��������
 */

public class SetOperation {
	public static void main(String[] args)
	{
		/** ��ʼ������ */
		Collection<String> A = new ArrayList<String>();
		Collection<String> B = new ArrayList<String>();
		A.add("A");
		B.add("B");
		
		/** ȡ������������������A */
		A.addAll(B);
		System.out.println(A);
		
		/** ȡ����������������A���Ƴ� */
		A.removeAll(B);
		System.out.println(A);
		
	}
}
