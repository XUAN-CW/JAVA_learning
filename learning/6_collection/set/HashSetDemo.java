package set;

import java.util.HashSet;
import java.util.Set;

/**
 * ����HashSet�Ļ����÷�
 * Set:û��˳�򣬲����ظ���
 * List����˳�򣬿��ظ���
 *
 */

public class HashSetDemo {
	public static void main(String[] args) {
		Set<String>  set1 = new HashSet<>();
		
		set1.add("aa");
		set1.add("bb");
		set1.add("aa");
		System.out.println(set1);	//�����ظ����ʧ��
		set1.remove("bb");
		System.out.println(set1);
		
	
		Set<String>  set2 = new HashSet<>();
		set2.add("11");
		set2.addAll(set1);
		System.out.println(set2);
		
		
		
	}
}
