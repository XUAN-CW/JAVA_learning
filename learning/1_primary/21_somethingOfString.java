package a;

public class somethingOfString
{
	public static void main(String[] args)
	{
		/*** ֱ��ƴ�� **/
		String test = "test";
		float float_add_f = 2.9f;	//Ҫfloat���;�Ҫ��f��java��С������Ĭ��Ϊdouble
		double defaultOftypeDecimalIs_double = 1.3;
		System.out.println("ֱ��ƴ��:" + "test" + float_add_f);
		
		/*** �ַ���ֱ�Ӹ�ֵ **/
		String string = null;
		System.out.println("�ַ���ֱ�Ӹ�ֵ����ֵǰ��" + string);
		string = "NULL";
		System.out.println("�ַ���ֱ�Ӹ�ֵ����ֵ��" + string);
		
		/*** �ַ����Ƚ� **/
		String string1 = "string";
		String string2 = "string";
		System.out.println("�ַ�����ͬ��string1.compareTo(string2) == " + (string1.compareTo(string2)));
		System.out.println(string1 == string2);
		
		/*** �ַ��������󲻿ɱ䣬�ַ���������ͬ����ָͬ��ָ��ͬһ�ַ��� **/
		String test7 = "test";	// test7 ָ�� "test"
		String test8 = "test_";	// test8 ָ�� "test_"
		String test9 = "test";	// test9 ָ�� "test"		�� test7 ָ����ͬ
		//�ַ�������Ѱ����ͬ�ַ��������ַ�����ͬ����ָ����ַ���
		System.out.println("�ַ���������ͬ��ָ��ͬ " + (test7 == test9));
		//�ַ�������Ѱ����ͬ�ַ��������ַ�����ͬ�������ַ������д����ַ���
		System.out.println("�ַ������ݲ�ͬ��ָ��ͬ " + (test7 == test8));	
		
		/*** �ַ��������󲻿ɱ䣬ָ���ַ�����ָ��ɱ� **/
		String variable = "a";
		variable = "variable";
		System.out.println(variable);
		
		/*** �ַ���ƴ�ӱ��� **/
		String test10 = test7;
		System.out.println("ƴ��ǰ��" + (test10 == test7));	
		//test10 += test8;
		//ԭ�����ַ���û�иı䣬�����½���һ���ַ���
		test10 = test10.concat(test8);	
		System.out.println("ƴ�Ӻ� ��" + (test10 == test7));
		
		/*** ��ʾ���õļ���String����Ĺ�����ʽ **/
		String str1 = "��ã����磡";//����ֵ��ַ���� str1 
		String str2 = new String();	//ʹ��Ĭ�Ϲ��졾String str2 = "";������һ�����ַ���
		String str3 = new String(str1);
		System.out.println(str1);
		System.out.println(str3);
		System.out.println("str1��str3����ͬһ��������ֻ��ֵ���:"+(str1 == str3));
		//
		char[] chArray = {'a', 'b', 'c'};	//java�У��ַ�������ַ�����������������һ��Ԫ���Ƿ���\0
		//���ַ�����ת����String����
		String str4 = new String(chArray);
		chArray = str4.toCharArray();
		//
		//�ֽ��������ַ�����ת��  byte�������ͣ�-128 �� 127֮��
		byte[] byteArray = {104, 101, 108, 108, 111};
		String str5 = new String(byteArray);
		System.out.println(str5);

		//�ַ���ת�룺
//		String str6 = new String(str1.getBytes(), "UTF-8");
//		System.out.println(str6);
	}
}
