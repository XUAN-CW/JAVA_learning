package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 测试Collection接口中的方法 
 */

public class CollectionFunctionDemo {
	public static void main(String[] args)
	{
		Collection<String> strCollection = new ArrayList<String>();
		
		/** 集合中对象的数目 */
		System.out.println(strCollection.size());
		
		/** 判断集合是否为空 */
		System.out.println(strCollection.isEmpty());
		
		/** 向集合中添加内容 */
		strCollection.add("test1");
		strCollection.add("test2");
		strCollection.add("test3");
		
		/** 对象的指针从集合中移除，但对象并没有消失 - 不同于删除 */
		strCollection.remove("test2");
		System.out.println(strCollection);
		
		/** 判断是否包含某元素 */
		System.out.println(strCollection.contains("test2"));
		
		/** 转化为对象数组 */
		Object[] objs = strCollection.toArray();
		
		/** 清空集合 */
		strCollection.clear();
		

		
		
	}
}
