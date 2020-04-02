package fileDemo;

import java.util.Scanner;

public class StringFuction 
{
	public static void main(String[] args)
	{	
		/*** equals **/
		System.out.println("a".contentEquals("a"));
		
		/*** compareTo **/
		//ǰ����
		System.out.println("a".compareTo("b"));
		
		/*** startsWith��endsWith **/
		System.out.println("abcd".startsWith("ab"));	//�ж��ַ����Ƿ�����һ�ַ�����ͷ
		System.out.println("abcd".endsWith("ab"));		//�ж��ַ����Ƿ�����һ�ַ�����β
		
		/*** contains **/
		System.out.println("abcd".contains("ab"));		//�ж��ַ����ǰ�����һ�ַ���
		
		/*** indexOf **/	
		System.out.println("ab123ab".indexOf("ab"));	//�ж��ַ�������һ�ַ����е�λ��
		System.out.println("ab123ab".indexOf("ab",2));	//�ж��ַ�������һ�ַ����еĵڶ��γ��ֵ�λ��

		/*** substring **/
		System.out.println("abcdef".substring(1, 3));	//substring(beginIndex,endIndex) ��> [beginIndex,endIndex)
		System.out.println("abcdef".substring(3));		//substring(Index) ��> [Index,endOfString]
		
		/*** trim **/
		Scanner input = new Scanner(System.in);
		//trim����:ȥ���ַ�����������Ŀո�
		//���飺���û������û�����ʹ��
		System.out.println("�������û�����");
		String uName = input.nextLine().trim();
		System.out.println("��" + uName + "��");
		
		
		
		
	
	}
	
	
	
	/*** �жϴ�����ַ����Ƿ���һ����ȷ��ʽ��С�� **/
	//�ַ���������ֻ��һ��С���� && С���㲻���ڵ�һλ && С���㲻�������һλ && С����С����������֮��������ַ�
	public static boolean isDecimal(String str)
	{
		boolean isDecimal = true;
		
		//�ַ���������ֻ��һ��С���� <==> ����С���� && ��ǰ�������±�ʹӺ���ǰ�������±�պ����
		if(!(str.contains(".") && str.indexOf(".") == str.lastIndexOf(".")))
		{
			return false;
		}
		
		//��֤С���㲻����λҲ����ĩλ
		if('.' == str.charAt(0) || '.'== str.charAt(str.length()-1))
		{
			return false;
		}
		
		//��֤С����С����������֮��������ַ�
		for (int i = 0; i < str.length(); i++) 
		{
			if(!Character.isDigit(str.charAt(i)))
			{
				return false;
			}
		}
		
		return isDecimal;
	}
}
