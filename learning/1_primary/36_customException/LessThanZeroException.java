package customException;
/**
 * �Զ����쳣 - С����ʱ����
 */
public class LessThanZeroException extends Exception{
	//��д������������췽������
	
	private int value;
	
	public LessThanZeroException(){
		super("���ֲ���С���㣡");
	}
	
	public LessThanZeroException(int value){
		super("���������Ϊ��" + value + "������С���㣡");
	}

}
