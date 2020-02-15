import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *Iterator是一个接口，它是集合的迭代器。
 *集合可以通过Iterator去遍历集合中的元素。
 *Iterator提供的API接口，包括：是否存在下一个元素、获取下一个元素、删除当前元素。
 */

//迭代器遍历List、Set、Map
public class iteratorDemo {
	public static void main(String[] args) {
//		ListTraverseByIterator();
//		SetTraverseByIterator();
//		MapTraverseByIterator();
		
		testRemove();
	}
	
	/** 使用iterator遍历List */
	public static void ListTraverseByIterator(){
		List<String>  list = new ArrayList<>();
		list.add("1使用iterator遍历List");
		list.add("2使用iterator遍历List");
		list.add("3使用iterator遍历List");
		for(Iterator<String> iter=list.iterator();iter.hasNext();){
			String  temp = iter.next();
			System.out.println(temp);
		}
	}
	
	/** 使用iterator遍历Set */
	public static void SetTraverseByIterator(){
		Set<String>  set = new HashSet<>();
		set.add("a使用iterator遍历Set");
		set.add("b使用iterator遍历Set");
		set.add("c使用iterator遍历Set");
		for(Iterator<String> iter=set.iterator();iter.hasNext();){
			String  temp = iter.next();
			System.out.println(temp);
		}
	}
	
	/** 使用iterator遍历Map */
	public static void MapTraverseByIterator(){
		Map<Integer,String> map1 = new HashMap<>();
		map1.put(100, " 1使用iterator遍历Map");
		map1.put(200, " 2使用iterator遍历Map");
		map1.put(300, " 3使用iterator遍历Map");
		
		//第一种遍历Map的方式 - 转为【SetTraverseByIterator()】
		System.out.println("第一种遍历Map的方式");
		//【map1.entrySet()】返回【Entry】
		Set<Entry<Integer,String>>  ss =  map1.entrySet();	//entry - 进入，获得键值对的集合
		for(Iterator<Entry<Integer,String>> iter=ss.iterator();iter.hasNext();){
			Entry<Integer,String> temp = iter.next();
			System.out.println("第一种方式："+temp.getKey()+temp.getValue());
		}
		
		//第二种遍历Map的方式
		System.out.println("第二种遍历Map的方式");
		Set<Integer>  keySet = map1.keySet();	//获得键的集合
		for(Iterator<Integer> iter = keySet.iterator();iter.hasNext(); ){
			Integer tempKey = iter.next();
			System.out.println("第二种方式："+tempKey+map1.get(tempKey));
		}
	}
	
	
	/** 测试边遍历，边删除 */
	public static void testRemove(){
		List<String> list = new ArrayList<>();
		for(int i=0;i<20;i++){
			list.add("边遍历，边删除"+i);
		}
		
		for(int i=0;i<list.size();i++){
			String temp = list.get(i);
			if(temp.endsWith("2")){
				System.out.println("执行删除操作，删除了：" + temp);
				list.remove(i);
			}
			System.out.print("list.size()=="+list.size()+"\t"); 
			System.out.println(list.get(i));  
		}
		
		
	}
	
}
