package singleModel_;

public class  SingleModel
{
	/** ��������Ψһ�ı����ʵ�� */
	private static SingleModel me = null;
	public int count = 0;
	
	private SingleModel(){
		count++;
	}
	
	/**
	 * ��ñ���Ψһ��һ��ʵ�� -- ����ģʽ�ĺ��ķ���
	 * @return
	 */
	public static SingleModel getInstance(){
		if(null == me) 
			me = new SingleModel();
		return me;
	}
}




