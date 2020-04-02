package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合运算
 */

public class SetOperation {
	public static void main(String[] args)
	{
		/** 初始化集合 */
		Collection<String> A = new ArrayList<String>();
		Collection<String> B = new ArrayList<String>();
		A.add("A");
		B.add("B");
		
		/** 取并集，并将交集赋给A */
		A.addAll(B);
		System.out.println(A);
		
		/** 取交集，并将交集从A中移除 */
		A.removeAll(B);
		System.out.println(A);
		
	}
}
