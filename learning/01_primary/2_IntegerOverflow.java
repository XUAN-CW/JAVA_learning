package overflow;

import java.lang.Math;

public class IntegerOverflow 
{
	public static void main(String[] args)
	{
		/*** 溢出 **/
		int overflow = Integer.MIN_VALUE;
		Math.abs(overflow);
		System.out.println("整形最小值的绝对值溢出:" + overflow);
		System.out.println("整形最大值：" + Integer.MAX_VALUE);
	}

}
