package ticketGrabbing;
/**
 * ������Դ,����(�̰߳�ȫ)
 * ���ӣ���ţ��Ʊ
 */
public class TicketGrabbing implements Runnable{
	
	private int ticketNums = 100;	//Ʊ��
	
	@Override
	public void run() {
		while(true) {
			if(ticketNums<0) {
				break;
			}
			try {
				Thread.sleep(100);	//ģ��������ʱ�����ܳ��ָ��� - ��100��Ʊȴ��������101��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
		}
	}
	public static void main(String[] args) {
		//һ����Դ
		TicketGrabbing web =new TicketGrabbing();
		System.out.println(Thread.currentThread().getName());
		//�������
		new Thread(web,"��ţ���").start();
		new Thread(web,"��ţ����").start();
		new Thread(web,"��ţ����").start();;
	}
}
