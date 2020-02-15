package collection;


/**
 * �����ǳ���Ĳ���
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
		/** ����Ϊ��String���������˺������ֻװ��String�� */
		MyCollection<String>  StringColletion = new MyCollection<String>();
		StringColletion.setObj("str", 0);
		String str = StringColletion.getObj(0);
		System.out.println(str);
		
		/** ����Ϊ��Integer���������˺������ֻװ��Integer�� */
		MyCollection<Integer>  IntegerColletion = new MyCollection<Integer>();
		IntegerColletion.setObj(Integer.valueOf(100), 1);
		int testInt = IntegerColletion.getObj(1).intValue();
		System.out.println(testInt);
		
	}
}


