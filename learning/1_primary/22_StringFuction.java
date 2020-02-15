package fileDemo;

import java.util.Scanner;

public class StringFuction 
{
	public static void main(String[] args)
	{	
		/*** equals **/
		System.out.println("a".contentEquals("a"));
		
		/*** compareTo **/
		//前减后
		System.out.println("a".compareTo("b"));
		
		/*** startsWith、endsWith **/
		System.out.println("abcd".startsWith("ab"));	//判断字符串是否以另一字符串开头
		System.out.println("abcd".endsWith("ab"));		//判断字符串是否以另一字符串结尾
		
		/*** contains **/
		System.out.println("abcd".contains("ab"));		//判断字符串是包含另一字符串
		
		/*** indexOf **/	
		System.out.println("ab123ab".indexOf("ab"));	//判断字符串在另一字符串中的位置
		System.out.println("ab123ab".indexOf("ab",2));	//判断字符串在另一字符串中的第二次出现的位置

		/*** substring **/
		System.out.println("abcdef".substring(1, 3));	//substring(beginIndex,endIndex) —> [beginIndex,endIndex)
		System.out.println("abcdef".substring(3));		//substring(Index) —> [Index,endOfString]
		
		/*** trim **/
		Scanner input = new Scanner(System.in);
		//trim方法:去掉字符串左右两侧的空格
		//建议：在用户输入用户名后使用
		System.out.println("请输入用户名：");
		String uName = input.nextLine().trim();
		System.out.println("【" + uName + "】");
		
		
		
		
	
	}
	
	
	
	/*** 判断传入的字符串是否是一个正确格式的小数 **/
	//字符串中有且只有一个小数点 && 小数点不能在第一位 && 小数点不能在最后一位 && 小数无小数点与数字之外的其他字符
	public static boolean isDecimal(String str)
	{
		boolean isDecimal = true;
		
		//字符串中有且只有一个小数点 <==> 存在小数点 && 从前搜索的下标和从后往前搜索的下标刚好相等
		if(!(str.contains(".") && str.indexOf(".") == str.lastIndexOf(".")))
		{
			return false;
		}
		
		//验证小数点不在首位也不在末位
		if('.' == str.charAt(0) || '.'== str.charAt(str.length()-1))
		{
			return false;
		}
		
		//验证小数无小数点与数字之外的其他字符
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
