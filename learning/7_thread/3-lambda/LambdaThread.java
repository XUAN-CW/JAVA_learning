package lambdaDemo;

/**
 * Lambda���ʽ ���߳�(��һ��)��ʹ��
 * �Ƶ����£�
 */
public class LambdaThread {
	
	
	// ��̬�ڲ��� - ��ʹ�ã������룬ʹ���˲ű���
	static class Test implements Runnable {
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println("��̬�ڲ���");
			}
		}
	}

	public static void main(String[] args) {
		
		
		/** һ����̬�ڲ��� */
		new Thread(new Test()).start();

		
		/** �����ֲ��ڲ��� */
		class Test2 implements Runnable {
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("�ֲ��ڲ���");
				}
			}
		}
		new Thread(new Test2()).start();

		
		/** ���������ڲ��� - ��������ӿڻ��߸��� */
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("�����ڲ���");
				}
			}
		}).start();

		
		/** �ġ� jdk8 �� lambda���ʽ */
		//() -> {}��������������������
		new Thread(() -> {
			for (int i = 0; i <5; i++) {
				System.out.println("lambda���ʽ");
			}
		}).start();

		
		
	}

}
