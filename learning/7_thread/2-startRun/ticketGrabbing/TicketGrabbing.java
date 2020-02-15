package ticketGrabbing;
/**
 * 共享资源,并发(线程安全)
 * 例子：黄牛抢票
 */
public class TicketGrabbing implements Runnable{
	
	private int ticketNums = 100;	//票数
	
	@Override
	public void run() {
		while(true) {
			if(ticketNums<0) {
				break;
			}
			try {
				Thread.sleep(100);	//模拟网络延时，可能出现负数 - 有100张票却被抢到了101此
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
		}
	}
	public static void main(String[] args) {
		//一份资源
		TicketGrabbing web =new TicketGrabbing();
		System.out.println(Thread.currentThread().getName());
		//多个代理
		new Thread(web,"黄牛大哥").start();
		new Thread(web,"黄牛二哥").start();
		new Thread(web,"黄牛三弟").start();;
	}
}
