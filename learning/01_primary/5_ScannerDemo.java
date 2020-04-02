package scanner;

import java.util.Scanner;

public class ScannerDemo
{
	public static void main(String[] args)
	{
		
		/*** 扫描系统输入 */
//		Scanner input = new Scanner(System.in);		//在堆内存中分配了空间
//		double scannerDouble = input.nextDouble();
//		System.out.println("input.nextDouble():" + "input:"+scannerDouble);
		
		Scanner input = new Scanner(System.in);
		/*** 空格、回车截断 **/
		String input_next = input.next();
		System.out.println("input.next():" + input_next);
		
		/*** 换行截断 **/
//		Scanner input = new Scanner(System.in);
//		String input_nextLine = input.nextLine();		
//		System.out.println("input.nextLine():" + input_nextLine);
		
		/*** 录入char类型,获得用户输入字符串的第一个字符,一个 char 占两个字节，读出来的可以是中文 **/
//		Scanner input = new Scanner(System.in);
//		System.out.print("性别：");
//		char sex = input.next().charAt(0);
//		System.out.println("性别：" + sex);
	
		/*** double类型读取 **/
//		System.out.print("请输入圆半径：");
//		double radius = input.nextDouble();	//读取用户输入的下一个double类型数据，赋值给左边的radius变量
//		//   = 赋值符号      int num = 90;  scanf();
//		double area = 3.14 * radius * radius;
//		System.out.printf("圆面积为：%.2f\n", area);
		
		
		
	}

}
