package arrayList;

import java.awt.List;
import java.util.ArrayList;

/**
 * ArrayList�ײ㻹������
 * ArrayList���ڴ洢����
 * �����鲻ͬ������һ�����������ȹ̶�������ArrayList�ĳ����Ƕ�̬�ģ��������ƣ����Դ洢�����Ķ���
 * ArrayListֻ�ܴ洢���󣬲��ܴ洢ԭ����������������int 
 * ArrayList����ԭ���½�һ�����������B����ԭ������A�����ݸ��Ƶ�������B�У��Ӷ��ﵽ���ݵ�Ŀ��
 */

public class ArrayListFunctionDemo {
	public static void main(String[] args)
	{
		/** ��ʼ�� */
	ArrayList<String> list = new ArrayList<String>();
	list.add("A");
	list.add("B");
	list.add("A");
	list.add("��");
	list.add("B");
	
	System.out.println(list);
	
	/** �� */
	list.add(2,"��");
	System.out.println(list);
	
	/** �Ƴ� */
	list.remove(2);
	System.out.println(list);
	
	/** �� */
	list.set(2, "��");
	System.out.println(list);
	
	/** ��ʾ�±��Ӧ���� */
	System.out.println(list.get(3)); 
	
	/** ���ң��Ҳ������ء�-1�� */
	System.out.println(list.indexOf("B"));
	
	/** �������Ĳ������һ�γ��ֵ��±� */
	System.out.println(list.lastIndexOf("B"));
	
	}
	
}
