package other;


public class Other 
{
	public static void main(String[] args)
	{
		
		/*** 对象数组中元素使用前要分配空间 **/
		Malloc[] test4 = new Malloc[3];
		test4[0] = new Malloc();	
		test4[0].temp3 = 4;
		System.out.println(test4[0].temp3);
		
		/*** 装箱 **/
		Integer[]  array = new Integer[3];
		array[0] = Integer.valueOf(100);
		System.out.println(array[0]);
		
		/*** 强制类型转换 */
		double num_double = 2.5;
		int num_int = (int)num_double;		//损失精度
		System.out.println("强制类型转换:" + num_int);
		int ch = 'A';
		System.out.println(ch);
		System.out.println((char)ch);
		
		/*** ? : */
		int result = 1 > 2 ? 1 : 0;
		System.out.println("? :运算：" + result);
		
		
		/*** switch-case **/
//		可以是整形、字符型、String型，但不建议使用String型
		String switch_String = "NULL";
		switch(switch_String)
		{
		case "NULL":
			System.out.println("NULL—>break ，没有break，仍在 switch-case 中");
			switch_String = "break";
		case "break":
			System.out.println (switch_String);
			break;
		}
		
		/*** 随机数生成 **/
		// [ 0.0 , 1 )
		int  randomNumber = (int)(Math.random() * 10000) % 11 + 5;
		System.out.println ("随机数:" + randomNumber);
		
		
		/*** 调试 **/
//		 * 设置断点：
//		 		方法一：左键双击蓝色区域
//		 		方法二：右键点击蓝色区域，选中 Toggle Breakpoint
//		 * 开启调试：
//		 		Debug (小虫子)
//		 * Variables：
//		 		Window—>Show View—>Other—>Debug—>Variables
		

		/*** sleep **/
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		/*** 使用占位构建一个字符串 **/
		String str = String.format("%-10d%d", 20, 25);
		//打印字符串变量
		System.out.println(str);
		
		
		/*** 音乐播放 **/
		
	}
	
	/*** 对象数组中元素使用前要分配空间 **/
	static class Malloc
	{
		int temp3 = 10;
		int temp4 = 50;
	}
	
	
	
	
	
	
	
	
	
	
	
}
