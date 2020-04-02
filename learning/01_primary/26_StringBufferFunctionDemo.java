package test;

import java.util.Scanner;
/**
 * �����ַ��������޸ĵ�ʱ����Ҫʹ�� StringBuffer �� StringBuilder �ࡣ
 * �� String �಻ͬ���ǣ�StringBuffer �� StringBuilder ��Ķ����ܹ�����ε��޸ģ����Ҳ������µ�δʹ�ö���
 * StringBuilder ���� Java 5 �б���������� StringBuffer ֮������ͬ���� StringBuilder �ķ��������̰߳�ȫ�ģ�����ͬ�����ʣ���
 * ���� StringBuilder ����� StringBuffer ���ٶ����ƣ����Զ�������½���ʹ�� StringBuilder �ࡣ
 * Ȼ����Ӧ�ó���Ҫ���̰߳�ȫ������£������ʹ�� StringBuffer �ࡣ
 */
public class StringBufferDemo 
{
	public static void main(String[] args)
	{	
		
		/*** �������¿ռ䣬������ͬȴ����ͬһ������ **/
		StringBuffer strBuff1 = new StringBuffer("��ã��ɶ���");
		StringBuffer strBuff2 = new StringBuffer("��ã��ɶ���");
		StringBuffer strBuff3 = new StringBuffer("��ã��ɶ���");
		//�ȽϹ�ϣ��
		System.out.println(strBuff1.equals(strBuff2));
		//�Ƚ�����
		System.out.println(strBuff1.toString().equals(strBuff2.toString()));
		
		/*** ����ĳ��λ�õ��� **/
		strBuff1.setCharAt(3, '��');
		System.out.println(strBuff1);
		
		/*** ����ַ������� **/
		strBuff1.setLength(0);						
		
		/*** �ַ�����ȡ�����С **/
		System.out.println("�����С��" + strBuff1.capacity());
		
		/*** �ַ�����ת **/
		System.out.println(new StringBuffer("abcdef").reverse());
		
		/*** �ַ������� **/
		System.out.println(new StringBuffer("abcdef").insert(1, "88"));
		
		/*** ɾ�� **/
		System.out.println(new StringBuffer("abcdef").deleteCharAt(1));	//ɾ�������ַ�
		System.out.println(new StringBuffer("abcdef").delete(2, 4));	//ɾ������ַ�
		
		/*** ׷�� **/
		System.out.println(new StringBuffer("abcdef").append("123"));	//ɾ������ַ�
	}
	
	
}
