package a;

public class somethingOfString
{
	public static void main(String[] args)
	{
		/*** 直接拼接 **/
		String test = "test";
		float float_add_f = 2.9f;	//要float类型就要加f，java中小数类型默认为double
		double defaultOftypeDecimalIs_double = 1.3;
		System.out.println("直接拼接:" + "test" + float_add_f);
		
		/*** 字符串直接赋值 **/
		String string = null;
		System.out.println("字符串直接赋值，赋值前：" + string);
		string = "NULL";
		System.out.println("字符串直接赋值，赋值后：" + string);
		
		/*** 字符串比较 **/
		String string1 = "string";
		String string2 = "string";
		System.out.println("字符串相同：string1.compareTo(string2) == " + (string1.compareTo(string2)));
		System.out.println(string1 == string2);
		
		/*** 字符串创建后不可变，字符串内容相同，不同指针指向同一字符串 **/
		String test7 = "test";	// test7 指向 "test"
		String test8 = "test_";	// test8 指向 "test_"
		String test9 = "test";	// test9 指向 "test"		与 test7 指向相同
		//字符串池中寻找相同字符串，若字符串相同，则指向该字符串
		System.out.println("字符串内容相同则指向同 " + (test7 == test9));
		//字符串池中寻找相同字符串，若字符串不同，则在字符串池中创建字符串
		System.out.println("字符串内容不同则指不同 " + (test7 == test8));	
		
		/*** 字符串创建后不可变，指向字符串的指针可变 **/
		String variable = "a";
		variable = "variable";
		System.out.println(variable);
		
		/*** 字符串拼接本质 **/
		String test10 = test7;
		System.out.println("拼接前：" + (test10 == test7));	
		//test10 += test8;
		//原来的字符串没有改变，而是新建了一个字符串
		test10 = test10.concat(test8);	
		System.out.println("拼接后 ：" + (test10 == test7));
		
		/*** 演示常用的几种String对象的构建方式 **/
		String str1 = "你好，世界！";//常两值地址赋给 str1 
		String str2 = new String();	//使用默认构造【String str2 = "";】创造一个空字符串
		String str3 = new String(str1);
		System.out.println(str1);
		System.out.println(str3);
		System.out.println("str1、str3不是同一个东西，只是值相等:"+(str1 == str3));
		//
		char[] chArray = {'a', 'b', 'c'};	//java中：字符数组和字符串的区别就在于最后一个元素是否是\0
		//将字符数组转换成String对象
		String str4 = new String(chArray);
		chArray = str4.toCharArray();
		//
		//字节数组与字符串的转换  byte数据类型：-128 到 127之间
		byte[] byteArray = {104, 101, 108, 108, 111};
		String str5 = new String(byteArray);
		System.out.println(str5);

		//字符串转码：
//		String str6 = new String(str1.getBytes(), "UTF-8");
//		System.out.println(str6);
	}
}
