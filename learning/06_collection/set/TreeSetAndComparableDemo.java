package set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 测试TreeSet的使用
 * 熟悉Comparable接口（参考TreeMap）
 */
public class TreeSetAndComparableDemo {
	public static void main(String[] args) {
		Set<Integer>  set = new TreeSet<>();
		set.add(300);
		set.add(200);
		set.add(600);
		
		System.out.println(set);
		//按照元素递增的方式排好序
		for(Integer m:set){
			System.out.println(m);
		}
		
		Set<Employee>  set2 = new TreeSet<>();
		set2.add(new Employee(100,"张三",3000));
		set2.add(new Employee(50,"李四",2000));
		set2.add(new Employee(150,"王五",8000));
		set2.add(new Employee(30,"赵六",20000));
		
		System.out.println(set2);
		
		for(Employee m:set2){
			System.out.println(m);
		}
		
	}
}

class Employee  implements Comparable<Employee>  {
	int id;
	String name;
	double salary;
	
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return  "id:"+id+"\t" +"name:"+name+"\t" +"salary:"+salary;
	}
	
	@Override
	public int compareTo(Employee o) {	
		
		if(this.salary>o.salary){
			return 1;
		}else if(this.salary<o.salary){
			return -1;
		}else{
			if(this.id>o.id){
				return 1;
			}else if(this.id<o.id){
				return -1;
			}else{
				return 0;
			}
		}
		
	}
	
}
