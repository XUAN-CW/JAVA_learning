package singleModel_;

public class SingleModelTest {

	public static void main(String[] args)
	{
		//SingleModel single = new singleModel();	//构造方法私有不可见，不可通过私有方法实例化，可以通过其他方法实例化
		
		SingleModel single1 = SingleModel.getInstance();
		System.out.println(single1.count);
		single1.count++;
		
		SingleModel single2 = SingleModel.getInstance();
		System.out.println(single2.count);
		
		System.out.println((single1 == single2)+"说明两个实例化的对象都是同一个对象");
		
	}

}
