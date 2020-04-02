package a;

/**
 * ����HashMap��ʹ��
 * map - ӳ��
 * <K,V> - <key,value> - <����ֵ>
 */

import java.util.HashMap;
import java.util.Map;

public class MapFunctionDemo {
	public static void main(String[] args)
	{
		/** ����ӳ���ϵΪ <Integer,String> */
		Map<Integer,String>  map1 = new HashMap<>();
		
		/** �� */
		map1.put(1, "one");
		map1.put(2, "two");
		map1.put(3, "three");
		map1.put(31, "three");
		
		/** ͨ�����������ҡ�ֵ�� */
		System.out.println(map1.get(1)); 
		System.out.println(map1.get(3)); 
		System.out.println(map1.get(31)); 
		
		System.out.println(map1.size()); 				//��С
		System.out.println(map1.isEmpty());				//Ϊ��
		System.out.println(map1.containsKey(2));		//�Ƿ����ĳ��
		System.out.println(map1.containsValue("four"));	//�Ƿ����ĳֵ
		
		Map<Integer,String> map2 = new HashMap<>();
		map2.put(4, "��");
		map2.put(5, "��");
		
		
		/** map�ļ������� */
		map1.putAll(map2);
		System.out.println(map1);
		
		/** ����ͬ���µ�ֵ���Ǿɵ�ֵ */
		map1.put(3, "3");
		System.out.println(map1);
		
	}
}
