package binary;

public class Binary
{
	public static void main(String[] args)
	{
		/*** 二进制表示，无限接近某一数字 **/
		System.out.println("二进制表示，无限接近某一数字:" + (1.0 - 0.9));
		
		/*** 位运算 **/
//		 * &  - 按 位 与：两操作数同时为1 			—> 1
//		 * |  - 按 位 或：两操作数有只要有一个为1		—> 1
//		 * ~  - 按 位 非：操作数为0					—> 1
//		 * ^  - 按位异或：两操作数不相同				—> 1
//		 * << - 左    移：左侧空位补0
//		 * >> - 右    移：右侧空位补符号位
//		 *	*** 以 6 & 3 == 2 为例 **
//		 		6 —> 110，1 —> 011
//		 		  110
//				& 011
//		  		------
//				  010
		int six_and_three = 6 & 3;
		System.out.println(" 按位与：  6 & 3 == " + six_and_three);
		
	}
}
