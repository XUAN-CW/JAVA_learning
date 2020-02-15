package theRaceBetweenHareAndTortoise;
/**
 * 模拟龟兔赛跑
 * 
 * @author 裴新 QQ:3401997271
 *
 *//*** 随机数生成 **/
public class TheRaceBetweenHareAndTortoise implements Runnable{
	private  String winner;			//胜利者
	private int destination = 20;	//终点
	@Override
	public void run() {
		for(int steps =1;steps<=destination;steps++) {	
			//模拟休息
			if(Thread.currentThread().getName().equals("rabbit") && (int)(Math.random() * 10000) % 20 == 3) {
				steps++;	//兔子的速度是乌龟的两倍，一次循环，兔子走两步
				try {
					System.out.println(Thread.currentThread().getName()+"----------sleep");
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"-->"+steps);
			boolean flag = gameOver(steps);//比赛是否结束
			if(flag) {
				break;
			}
		}
	}
	private boolean gameOver(int steps) {
		if(winner!=null) { //存在胜利者
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
