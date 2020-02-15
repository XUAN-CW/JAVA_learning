package map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapAndComparableDemo 
{
	public static void main(String[] args)
	{
		/** 初始化 */
		Map<Integer,String>  treemap = new TreeMap<>();
		treemap.put(20, "aa");
		treemap.put(3, "bb");
		treemap.put(6, "cc");
		
		// Displaying the TreeMap 
        System.out.println("Initial Mappings are: " + treemap); 
  
        // Using keySet() to get the set view of keys 
        System.out.println("The set is: " +  treemap.keySet()); 
		
		/** 按照key递增的方式排序 */
		//【treemap.keySet()】以升序返回一个具有TreeMap键的集合
		for(Integer  key:treemap.keySet()){
			System.out.println(key+"---"+treemap.get(key)); 
		}
		
		
		/** 使用【Comparable】接口进行排序 */
		Map<Employee,String>  treemapComparable = new TreeMap<>();
		treemapComparable.put(new Employee(100,5000,"张三"), "张3");
		treemapComparable.put(new Employee(200,5000,"李四"), "李4");
		treemapComparable.put(new Employee(200,4000,"王五"), "王5");
		treemapComparable.put(new Employee(500,6000,"赵六"), "赵6");
		
		//按照key递增的方式排序
		for(Employee  key:treemapComparable.keySet()){
			System.out.println(key+"---"+treemapComparable.get(key)); 
		}		
	}
}




class Employee  implements Comparable<Employee>  {
	int id;
	String name;
	double salary;
	
	public Employee(double salary,int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return  "salary:"+salary+"\t" + "id:"+id +"\t"+ "name:"+name ;
	}
	
	@Override
	
	public int compareTo(Employee o) {		//【负数—小于】【0—等于】【正数—大于】
		//重写【Comparable】接口，先排工资，工资一样排 id ,按照key递增的方式排序
//		if(this.salary>o.salary){
//			return 1;
//		}else if(this.salary<o.salary){
//			return -1;
//		}else{
//			if(this.id>o.id){
//				return 1;
//			}else if(this.id<o.id){
//				return -1;
//			}else{
//				return 0;
//			}
//		}
		
		//重写【Comparable】接口，先排工资，工资一样排 id ,按照key递减的方式排序
		//跟上面 仅大于小于号不同
		if(this.salary<o.salary){
			return 1;
		}else if(this.salary>o.salary){
			return -1;
		}else{
			if(this.id<o.id){
				return 1;
			}else if(this.id>o.id){
				return -1;
			}else{
				return 0;
			}
		}
		
	}
	
}