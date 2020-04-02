package test;

import java.util.Scanner;
/**
 * 当对字符串进行修改的时候，需要使用 StringBuffer 和 StringBuilder 类。
 * 和 String 类不同的是，StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象。
 * StringBuilder 类在 Java 5 中被提出，它和 StringBuffer 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）。
 * 由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。
 * 然而在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类。
 */
public class StringBufferDemo 
{
	public static void main(String[] args)
	{	
		
		/*** 开辟了新空间，内容相同却不是同一个东西 **/
		StringBuffer strBuff1 = new StringBuffer("你好，成都！");
		StringBuffer strBuff2 = new StringBuffer("你好，成都！");
		StringBuffer strBuff3 = new StringBuffer("你好，成都！");
		//比较哈希码
		System.out.println(strBuff1.equals(strBuff2));
		//比较内容
		System.out.println(strBuff1.toString().equals(strBuff2.toString()));
		
		/*** 设置某个位置的字 **/
		strBuff1.setCharAt(3, '神');
		System.out.println(strBuff1);
		
		/*** 清空字符串对象 **/
		strBuff1.setLength(0);						
		
		/*** 字符串获取缓存大小 **/
		System.out.println("缓存大小：" + strBuff1.capacity());
		
		/*** 字符串反转 **/
		System.out.println(new StringBuffer("abcdef").reverse());
		
		/*** 字符串插入 **/
		System.out.println(new StringBuffer("abcdef").insert(1, "88"));
		
		/*** 删除 **/
		System.out.println(new StringBuffer("abcdef").deleteCharAt(1));	//删除单个字符
		System.out.println(new StringBuffer("abcdef").delete(2, 4));	//删除多个字符
		
		/*** 追加 **/
		System.out.println(new StringBuffer("abcdef").append("123"));	//删除多个字符
	}
	
	
}
