package customException;

import java.util.Scanner;

public class From0To100Text {
private int[] a;
	
	public From0To100Text(){
		super();
	}
	
	public void inputNumber() throws Exception{
		a=new int[20];
		Scanner input = new Scanner(System.in);
		System.out.print( "运行到此处");	
		for (int i = 0;i<a.length; i++) {
			int temp=input.nextInt();
			if(temp<0||temp>100) {
				throw new From0To100();		//抛出自定义异常	
			}
			a[i]=temp;
			System.out.println(a[i]);
		}
	}
	
}
