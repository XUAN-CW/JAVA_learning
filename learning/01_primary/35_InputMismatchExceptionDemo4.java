package test;

import java.util.Scanner;

/**
 * ���벻ƥ���쳣ʾ��
 * �û����������ֻ�����������֣�ʹ���쳣������Ʋ��񲢴����쳣���
 */
public class InputMismatchExceptionDemo_ {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("���������䣨�������������֣�:");
		int age = -1;
		try {
			age = input.nextInt();
			
			age = age / 0;
			
		} catch (ArithmeticException e) {	//�Ȳ��������쳣
			e.printStackTrace();
			
		} catch (Exception e) {		//�����쳣�����˾Ͳ������쳣
			
			//System.err.println(e.getMessage());
			
			/*** ��ջ��ʽ��ӡ�쳣��Ϣ **/
			//һ���ڿ�����ʱ��ʹ��
			e.printStackTrace();
			
		} 
		System.out.println("����������ǣ�" + age);
	}

}








