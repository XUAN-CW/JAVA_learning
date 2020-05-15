package idlerWheel;
import java.awt.Robot;
public class Rbt {
	public static void main(String[] args) {
		try {
			Robot robot = new Robot();//创建Robot对象
			for (int j = 0; j < 60; j++) {//滚动一分钟
				for (int i = 0; i < 30; i++) {//30 次，共计滚动 30 s
					robot.mouseWheel(1);//向下滚动 1 下
					robot.delay(1000);//延时 1000 毫秒
				}
				for (int i = 0; i < 30; i++) {//30 次，共计滚动 30 s
					robot.mouseWheel(-1);//向上滚动 1 下
					robot.delay(1000);//延时 1000 毫秒
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
