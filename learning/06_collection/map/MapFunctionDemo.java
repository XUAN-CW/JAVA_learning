package a;

/**
 * 测试HashMap的使用
 * map - 映射
 * <K,V> - <key,value> - <键，值>
 */

import java.util.HashMap;
import java.util.Map;

public class MapFunctionDemo {
	public static void main(String[] args)
	{
		/** 设置映射关系为 <Integer,String> */
		Map<Integer,String>  map1 = new HashMap<>();
		
		/** 增 */
		map1.put(1, "one");
		map1.put(2, "two");
		map1.put(3, "three");
		map1.put(31, "three");
		
		/** 通过【键】查找【值】 */
		System.out.println(map1.get(1)); 
		System.out.println(map1.get(3)); 
		System.out.println(map1.get(31)); 
		
		System.out.println(map1.size()); 				//大小
		System.out.println(map1.isEmpty());				//为空
		System.out.println(map1.containsKey(2));		//是否包含某键
		System.out.println(map1.containsValue("four"));	//是否包含某值
		
		Map<Integer,String> map2 = new HashMap<>();
		map2.put(4, "四");
		map2.put(5, "五");
		
		
		/** map的集合运算 */
		map1.putAll(map2);
		System.out.println(map1);
		
		/** 键相同，新的值覆盖旧的值 */
		map1.put(3, "3");
		System.out.println(map1);
		
	}
}
