package startRun;
/**
 * �����̷߳�ʽ��:
 * 1��������ʵ��Runnable+��дrun
 * 2������: ����ʵ������� +Thread����+ start
 * 
 * �Ƽ�: ���ⵥ�̳еľ����ԣ�����ʹ�ýӿ�
 * ���㹲����Դ
 *
 */

public class StartRun implements Runnable{
	/** �߳���ڵ� */
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.print("�� ");
		}
	}
	
	
	
	
	public static void main(String[] args) {			
//		//����ʵ�������
//		StartRun sr =new StartRun();
//		//�������������
//		Thread t =new Thread(sr);
//		//���� 
//		t.start(); //����֤�������� cpu����
		
		//����һ����Ч����������
		new Thread(new StartRun()).start();
		
		//st.run(); //��ͨ��������
		for(int i=0;i<10;i++) {
			System.out.print("�� ");
		}
	}

}
