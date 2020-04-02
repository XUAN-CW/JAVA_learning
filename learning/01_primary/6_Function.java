package test;


public class Function 
{
	public static void main(String[] args)
	{
		/*** 函数 **/
		int parameters = 0;
		int returnValue = MethodName(parameters);
		System.out.println("函数调用：" + returnValue);
		
		/*** 私有方法 **/
		PrivatesMethod();
		
		/*** 不定长参数 **/
		int[] test = {1,3,6};
		System.out.println("不定长参数：" + VariableParameter(1,2,3));
		System.out.println("不定长参数：" + VariableParameter(test));	//可以直接放一个数组进去
		
		/*** 重载 **/
		System.out.println("重载，无参数："+Overloading()+"\n重载，一个参数："+Overloading(1));
		

	}

	
	
	/*** 所有人都能用 **/
	public static int MethodName (int parameters)
	{
		return ++parameters;
	}
	
	/*** 只能在本函数内使用 **/
	private static void PrivatesMethod()
	{
		System.out.println("只能在本函数内使用 ");
	}
	
	/** 
	 * 不定长参数 
	 * 不定参数必须是参数的最后一个
	 * 一个方法只能有一个不定参数
	 * 不定参数看做数组，默认数组长度为 0 
	 */
	public static int VariableParameter(int... nums)
	{
		int sum = 0;
		for(int i = 0;i<nums.length;i++)
		{
			sum += nums[i];
		}
		return sum;
	}
	
	/*** 重载-方法名相同 **
	 * 参数列表不同（参数列表具有无序性）
	 **/
	public static int Overloading(int nums)
	{
		return 1;
	}
	public static int Overloading()
	{
		return 0;
	}
	//
	/** ①②参数列表相同—>歧义调用
	 * 编译器会自动类型转换
	 */
	//①
	public static int max(double num1,int num2)
	{
		return (int)(num1 > num2 ? num1 : num2);
	}	
	//②
	public static int max(int num2,double num1)
	{
		return (int)(num1 > num2 ? num1 : num2);
	}
	

}
