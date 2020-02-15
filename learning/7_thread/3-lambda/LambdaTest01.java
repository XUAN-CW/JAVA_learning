package lambdaDemo;

/**
 * lambda�Ƶ�
 */


interface ILike {
	void lambda();
}

//�ⲿ��
class Like implements ILike {

	@Override
	public void lambda() {
		System.out.println("i like lambda ");
	}

}


public class LambdaTest01 {
	// �ڲ���
	static class Like2 implements ILike {
		public void lambda() {
			System.out.println("i like lambda2 ");
		}

	}

	public static void main(String[] args) {
		ILike like = new Like();
		like.lambda();

		like = new Like2();
		like.lambda();

		class Like3 implements ILike {
			public void lambda() {
				System.out.println("i like lambda3 ");
			}

		}

		like = new Like3();
		like.lambda();
		// �����ڲ���
		like = new ILike() {
			public void lambda() {
				System.out.println("i like lambda4 ");
			}
		};
		like.lambda();
		// lambda
		like = () -> {
			System.out.println("i like lambda5 ");
		};
		like.lambda();

		/*
		 * lambda�Ƶ������������ ()-> { System.out.println("i like lambda5 "); }.lambda();
		 */
	}
}
