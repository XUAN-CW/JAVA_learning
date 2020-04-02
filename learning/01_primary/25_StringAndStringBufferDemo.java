package test;

/***
 * 通过toString方法，可以把StringBuffer，StringBuilder转成String
 * 通过构造方法可以把String转成StringBuffer，StringBuilder
 * 不能通过强制转换来操作这三个类，即使他们处于同一类继承层次下，否则会抛出java.lang.ClasscastException异常。
 */

/**
 * 如果你要求字符串不可变，那么应该选择String类
 * 如果你需要字符串可变并且是线程安全的，那么你应该选择StringBuffer类
 * 如果你要求字符串可变并且不存在线程安全问题，那么你应该选择StringBuilder类
 */

/*** 下面是我认为的字符串拼接 **/

public class StringAndStringBufferDemo {
	public static void main(String[] args) {
		String str = "123456";
		System.out.println(str.hashCode() + "\t" + str);
		
		/*** 【String】转【StringBuffer】 **/
		StringBuffer strBuff = new StringBuffer(str);
		
		/*** 拼接 **/
		strBuff.append("abc");
		System.out.print(strBuff.hashCode() + "\t");
		System.out.println(strBuff);
		
		/*** 返回字符串地址 **/
		String str2 = strBuff.toString();
		System.out.println(str2.hashCode() + "\t" + str2);
		
		
		
		
	}
	
}
