package lambdaDemo;

/**
 * lambda�Ƶ�
 * 
 * @author ���� QQ:3401997271
 *
 */
public class LambdaTest04 {

	public static void main(String[] args) {
		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("һ��ѧϰlambda");
			}
		}).start();

		new Thread(() -> System.out.println("һ��ѧϰ����")).start();
	}
}