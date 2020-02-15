package map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapAndComparableDemo 
{
	public static void main(String[] args)
	{
		/** ��ʼ�� */
		Map<Integer,String>  treemap = new TreeMap<>();
		treemap.put(20, "aa");
		treemap.put(3, "bb");
		treemap.put(6, "cc");
		
		// Displaying the TreeMap 
        System.out.println("Initial Mappings are: " + treemap); 
  
        // Using keySet() to get the set view of keys 
        System.out.println("The set is: " +  treemap.keySet()); 
		
		/** ����key�����ķ�ʽ���� */
		//��treemap.keySet()�������򷵻�һ������TreeMap���ļ���
		for(Integer  key:treemap.keySet()){
			System.out.println(key+"---"+treemap.get(key)); 
		}
		
		
		/** ʹ�á�Comparable���ӿڽ������� */
		Map<Employee,String>  treemapComparable = new TreeMap<>();
		treemapComparable.put(new Employee(100,5000,"����"), "��3");
		treemapComparable.put(new Employee(200,5000,"����"), "��4");
		treemapComparable.put(new Employee(200,4000,"����"), "��5");
		treemapComparable.put(new Employee(500,6000,"����"), "��6");
		
		//����key�����ķ�ʽ����
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
	
	public int compareTo(Employee o) {		//��������С�ڡ���0�����ڡ������������ڡ�
		//��д��Comparable���ӿڣ����Ź��ʣ�����һ���� id ,����key�����ķ�ʽ����
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
		
		//��д��Comparable���ӿڣ����Ź��ʣ�����һ���� id ,����key�ݼ��ķ�ʽ����
		//������ ������С�ںŲ�ͬ
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