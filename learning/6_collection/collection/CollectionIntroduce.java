package collection;


/**
 * 泛型是抽象的参数
 */

class MyCollection<E>
{
	Object[] objs = new Object[5];
	
	public void setObj(E e,int index) {
		objs[index] = e;
	}
	
	public E getObj(int index) {
		return (E)objs[index];
	}
}

public class CollectionIntroduce {
	public static void main(String[] args)
	{
		/** 设置为【String】容器，此后此容器只装【String】 */
		MyCollection<String>  StringColletion = new MyCollection<String>();
		StringColletion.setObj("str", 0);
		String str = StringColletion.getObj(0);
		System.out.println(str);
		
		/** 设置为【Integer】容器，此后此容器只装【Integer】 */
		MyCollection<Integer>  IntegerColletion = new MyCollection<Integer>();
		IntegerColletion.setObj(Integer.valueOf(100), 1);
		int testInt = IntegerColletion.getObj(1).intValue();
		System.out.println(testInt);
		
	}
}


