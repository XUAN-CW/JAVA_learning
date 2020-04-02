import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *Iterator��һ���ӿڣ����Ǽ��ϵĵ�������
 *���Ͽ���ͨ��Iteratorȥ���������е�Ԫ�ء�
 *Iterator�ṩ��API�ӿڣ��������Ƿ������һ��Ԫ�ء���ȡ��һ��Ԫ�ء�ɾ����ǰԪ�ء�
 */

//����������List��Set��Map
public class iteratorDemo {
	public static void main(String[] args) {
//		ListTraverseByIterator();
//		SetTraverseByIterator();
//		MapTraverseByIterator();
		
		testRemove();
	}
	
	/** ʹ��iterator����List */
	public static void ListTraverseByIterator(){
		List<String>  list = new ArrayList<>();
		list.add("1ʹ��iterator����List");
		list.add("2ʹ��iterator����List");
		list.add("3ʹ��iterator����List");
		for(Iterator<String> iter=list.iterator();iter.hasNext();){
			String  temp = iter.next();
			System.out.println(temp);
		}
	}
	
	/** ʹ��iterator����Set */
	public static void SetTraverseByIterator(){
		Set<String>  set = new HashSet<>();
		set.add("aʹ��iterator����Set");
		set.add("bʹ��iterator����Set");
		set.add("cʹ��iterator����Set");
		for(Iterator<String> iter=set.iterator();iter.hasNext();){
			String  temp = iter.next();
			System.out.println(temp);
		}
	}
	
	/** ʹ��iterator����Map */
	public static void MapTraverseByIterator(){
		Map<Integer,String> map1 = new HashMap<>();
		map1.put(100, " 1ʹ��iterator����Map");
		map1.put(200, " 2ʹ��iterator����Map");
		map1.put(300, " 3ʹ��iterator����Map");
		
		//��һ�ֱ���Map�ķ�ʽ - תΪ��SetTraverseByIterator()��
		System.out.println("��һ�ֱ���Map�ķ�ʽ");
		//��map1.entrySet()�����ء�Entry��
		Set<Entry<Integer,String>>  ss =  map1.entrySet();	//entry - ���룬��ü�ֵ�Եļ���
		for(Iterator<Entry<Integer,String>> iter=ss.iterator();iter.hasNext();){
			Entry<Integer,String> temp = iter.next();
			System.out.println("��һ�ַ�ʽ��"+temp.getKey()+temp.getValue());
		}
		
		//�ڶ��ֱ���Map�ķ�ʽ
		System.out.println("�ڶ��ֱ���Map�ķ�ʽ");
		Set<Integer>  keySet = map1.keySet();	//��ü��ļ���
		for(Iterator<Integer> iter = keySet.iterator();iter.hasNext(); ){
			Integer tempKey = iter.next();
			System.out.println("�ڶ��ַ�ʽ��"+tempKey+map1.get(tempKey));
		}
	}
	
	
	/** ���Ա߱�������ɾ�� */
	public static void testRemove(){
		List<String> list = new ArrayList<>();
		for(int i=0;i<20;i++){
			list.add("�߱�������ɾ��"+i);
		}
		
		for(int i=0;i<list.size();i++){
			String temp = list.get(i);
			if(temp.endsWith("2")){
				System.out.println("ִ��ɾ��������ɾ���ˣ�" + temp);
				list.remove(i);
			}
			System.out.print("list.size()=="+list.size()+"\t"); 
			System.out.println(list.get(i));  
		}
		
		
	}
	
}
