package thread;
/**
 * 创建线程方式一:
 * 1、创建：继承Thread+重写run
 * 2、启动: 创建子类对象 + start
 */
public class StartThread extends Thread{
	/** 线程入口点 */
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.print("跳 ");
		}
	}
	
	
	public static void main(String[] args) {			
		/** 新建一条线 */
		//创建子类对象
		StartThread start =new StartThread();
		//调用【.start()】启动 
		start.start(); 	//不保证立即运行 cpu调用，开启新的线
		//st.run(); 	//普通方法调用，不开启新的线
		
		
		
		for(int i=0;i<10;i++) {
			System.out.print("唱 ");
			 
			
			
		}
	}

}
