package lambdaDemo;

/**
 * Lambda表达式 简化线程(用一次)的使用
 * 推导如下：
 */
public class LambdaThread {
	
	
	// 静态内部类 - 不使用，不编译，使用了才编译
	static class Test implements Runnable {
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println("静态内部类");
			}
		}
	}

	public static void main(String[] args) {
		
		
		/** 一、静态内部类 */
		new Thread(new Test()).start();

		
		/** 二、局部内部类 */
		class Test2 implements Runnable {
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("局部内部类");
				}
			}
		}
		new Thread(new Test2()).start();

		
		/** 三、匿名内部类 - 必须借助接口或者父类 */
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("匿名内部类");
				}
			}
		}).start();

		
		/** 四、 jdk8 简化 lambda表达式 */
		//() -> {}代码块替代了整个匿名类
		new Thread(() -> {
			for (int i = 0; i <5; i++) {
				System.out.println("lambda表达式");
			}
		}).start();

		
		
	}

}
