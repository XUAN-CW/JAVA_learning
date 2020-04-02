package test;

/***
 * ͨ��toString���������԰�StringBuffer��StringBuilderת��String
 * ͨ�����췽�����԰�Stringת��StringBuffer��StringBuilder
 * ����ͨ��ǿ��ת���������������࣬��ʹ���Ǵ���ͬһ��̳в���£�������׳�java.lang.ClasscastException�쳣��
 */

/**
 * �����Ҫ���ַ������ɱ䣬��ôӦ��ѡ��String��
 * �������Ҫ�ַ����ɱ䲢�����̰߳�ȫ�ģ���ô��Ӧ��ѡ��StringBuffer��
 * �����Ҫ���ַ����ɱ䲢�Ҳ������̰߳�ȫ���⣬��ô��Ӧ��ѡ��StringBuilder��
 */

/*** ����������Ϊ���ַ���ƴ�� **/

public class StringAndStringBufferDemo {
	public static void main(String[] args) {
		String str = "123456";
		System.out.println(str.hashCode() + "\t" + str);
		
		/*** ��String��ת��StringBuffer�� **/
		StringBuffer strBuff = new StringBuffer(str);
		
		/*** ƴ�� **/
		strBuff.append("abc");
		System.out.print(strBuff.hashCode() + "\t");
		System.out.println(strBuff);
		
		/*** �����ַ�����ַ **/
		String str2 = strBuff.toString();
		System.out.println(str2.hashCode() + "\t" + str2);
		
		
		
		
	}
	
}
