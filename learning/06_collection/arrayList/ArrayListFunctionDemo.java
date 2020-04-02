package arrayList;

import java.awt.List;
import java.util.ArrayList;

/**
 * ArrayList底层还是数组
 * ArrayList用于存储对象。
 * 与数组不同，数组一旦创建，长度固定，但是ArrayList的长度是动态的，不受限制，可以存储任意多的对象
 * ArrayList只能存储对象，不能存储原生数据类型例，如int 
 * ArrayList括容原理：新建一个更大的数组B，把原来数组A的内容复制到新数组B中，从而达到扩容的目的
 */

public class ArrayListFunctionDemo {
	public static void main(String[] args)
	{
		/** 初始化 */
	ArrayList<String> list = new ArrayList<String>();
	list.add("A");
	list.add("B");
	list.add("A");
	list.add("查");
	list.add("B");
	
	System.out.println(list);
	
	/** 增 */
	list.add(2,"增");
	System.out.println(list);
	
	/** 移除 */
	list.remove(2);
	System.out.println(list);
	
	/** 改 */
	list.set(2, "改");
	System.out.println(list);
	
	/** 显示下标对应内容 */
	System.out.println(list.get(3)); 
	
	/** 查找，找不到返回【-1】 */
	System.out.println(list.indexOf("B"));
	
	/** 查所给的参数最后一次出现的下标 */
	System.out.println(list.lastIndexOf("B"));
	
	}
	
}
