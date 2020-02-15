package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ����Collection�ӿ��еķ��� 
 */

public class CollectionFunctionDemo {
	public static void main(String[] args)
	{
		Collection<String> strCollection = new ArrayList<String>();
		
		/** �����ж������Ŀ */
		System.out.println(strCollection.size());
		
		/** �жϼ����Ƿ�Ϊ�� */
		System.out.println(strCollection.isEmpty());
		
		/** �򼯺���������� */
		strCollection.add("test1");
		strCollection.add("test2");
		strCollection.add("test3");
		
		/** �����ָ��Ӽ������Ƴ���������û����ʧ - ��ͬ��ɾ�� */
		strCollection.remove("test2");
		System.out.println(strCollection);
		
		/** �ж��Ƿ����ĳԪ�� */
		System.out.println(strCollection.contains("test2"));
		
		/** ת��Ϊ�������� */
		Object[] objs = strCollection.toArray();
		
		/** ��ռ��� */
		strCollection.clear();
		

		
		
	}
}
