package thread;
/**
 * �����̷߳�ʽһ:
 * 1���������̳�Thread+��дrun
 * 2������: ����������� + start
 */
public class StartThread extends Thread{
	/** �߳���ڵ� */
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.print("�� ");
		}
	}
	
	
	public static void main(String[] args) {			
		/** �½�һ���� */
		//�����������
		StartThread start =new StartThread();
		//���á�.start()������ 
		start.start(); 	//����֤�������� cpu���ã������µ���
		//st.run(); 	//��ͨ�������ã��������µ���
		
		
		
		for(int i=0;i<10;i++) {
			System.out.print("�� ");
			 
			
			
		}
	}

}
