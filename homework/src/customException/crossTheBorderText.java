package customException;

import javax.swing.*;

import java.util.Scanner;


public class crossTheBorderText {

	private int[] a;
	
	public crossTheBorderText(){
		super();
	}
	
	public void inputNumber() throws Exception{
		a=new int[20];
		Scanner input = new Scanner(System.in);
		for (int i = 0;; i++) {
			if (i==a.length) {
				throw new crossTheBorder();		//�׳��Զ����쳣
			}
			a[i]=input.nextInt();
		}
	}
	

}
