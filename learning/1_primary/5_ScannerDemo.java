package scanner;

import java.util.Scanner;

public class ScannerDemo
{
	public static void main(String[] args)
	{
		
		/*** ɨ��ϵͳ���� */
//		Scanner input = new Scanner(System.in);		//�ڶ��ڴ��з����˿ռ�
//		double scannerDouble = input.nextDouble();
//		System.out.println("input.nextDouble():" + "input:"+scannerDouble);
		
		Scanner input = new Scanner(System.in);
		/*** �ո񡢻س��ض� **/
		String input_next = input.next();
		System.out.println("input.next():" + input_next);
		
		/*** ���нض� **/
//		Scanner input = new Scanner(System.in);
//		String input_nextLine = input.nextLine();		
//		System.out.println("input.nextLine():" + input_nextLine);
		
		/*** ¼��char����,����û������ַ����ĵ�һ���ַ�,һ�� char ռ�����ֽڣ��������Ŀ��������� **/
//		Scanner input = new Scanner(System.in);
//		System.out.print("�Ա�");
//		char sex = input.next().charAt(0);
//		System.out.println("�Ա�" + sex);
	
		/*** double���Ͷ�ȡ **/
//		System.out.print("������Բ�뾶��");
//		double radius = input.nextDouble();	//��ȡ�û��������һ��double�������ݣ���ֵ����ߵ�radius����
//		//   = ��ֵ����      int num = 90;  scanf();
//		double area = 3.14 * radius * radius;
//		System.out.printf("Բ���Ϊ��%.2f\n", area);
		
		
		
	}

}
