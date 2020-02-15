package theRaceBetweenHareAndTortoise;
/**
 * ģ���������
 * 
 * @author ���� QQ:3401997271
 *
 *//*** ��������� **/
public class TheRaceBetweenHareAndTortoise implements Runnable{
	private  String winner;			//ʤ����
	private int destination = 20;	//�յ�
	@Override
	public void run() {
		for(int steps =1;steps<=destination;steps++) {	
			//ģ����Ϣ
			if(Thread.currentThread().getName().equals("rabbit") && (int)(Math.random() * 10000) % 20 == 3) {
				steps++;	//���ӵ��ٶ����ڹ��������һ��ѭ��������������
				try {
					System.out.println(Thread.currentThread().getName()+"----------sleep");
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"-->"+steps);
			boolean flag = gameOver(steps);//�����Ƿ����
			if(flag) {
				break;
			}
		}
	}
	private boolean gameOver(int steps) {
		if(winner!=null) { //����ʤ����
			return true;
		}else {
			if(steps ==destination) {
				winner = Thread.currentThread().getName();
				System.out.println("winner==>"+winner);
				return true;
			}
		}
		return false;
	}
	
	
	
	
	public static void main(String[] args) {
		TheRaceBetweenHareAndTortoise racer = new TheRaceBetweenHareAndTortoise();
		new Thread(racer,"tortoise").start();
		new Thread(racer,"rabbit").start();
	}
}
