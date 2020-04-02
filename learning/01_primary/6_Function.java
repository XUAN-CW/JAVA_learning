package test;


public class Function 
{
	public static void main(String[] args)
	{
		/*** ���� **/
		int parameters = 0;
		int returnValue = MethodName(parameters);
		System.out.println("�������ã�" + returnValue);
		
		/*** ˽�з��� **/
		PrivatesMethod();
		
		/*** ���������� **/
		int[] test = {1,3,6};
		System.out.println("������������" + VariableParameter(1,2,3));
		System.out.println("������������" + VariableParameter(test));	//����ֱ�ӷ�һ�������ȥ
		
		/*** ���� **/
		System.out.println("���أ��޲�����"+Overloading()+"\n���أ�һ��������"+Overloading(1));
		

	}

	
	
	/*** �����˶����� **/
	public static int MethodName (int parameters)
	{
		return ++parameters;
	}
	
	/*** ֻ���ڱ�������ʹ�� **/
	private static void PrivatesMethod()
	{
		System.out.println("ֻ���ڱ�������ʹ�� ");
	}
	
	/** 
	 * ���������� 
	 * �������������ǲ��������һ��
	 * һ������ֻ����һ����������
	 * ���������������飬Ĭ�����鳤��Ϊ 0 
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
	
	/*** ����-��������ͬ **
	 * �����б�ͬ�������б���������ԣ�
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
	/** �٢ڲ����б���ͬ��>�������
	 * ���������Զ�����ת��
	 */
	//��
	public static int max(double num1,int num2)
	{
		return (int)(num1 > num2 ? num1 : num2);
	}	
	//��
	public static int max(int num2,double num1)
	{
		return (int)(num1 > num2 ? num1 : num2);
	}
	

}
