package liberalEducation;
/** 
 * 
 * ���ܣ���������������촽�����ûҪ��һ�Ѻ�ɫ���ҳ�����ĺ�ɫ
		 �����ɫ�Ǻ촽�����ɫ������������¼���ѡ��Ҫѡ�ĺ�ɫ�������ɫѡ���Ŀ��
 */
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;


public class RedLipFish {
	public static void main(String[] args) throws AWTException {
		
		for (int i = 0; i < 5*60*60*5; i++) {
			Point mousePoint = MouseInfo.getPointerInfo().getLocation();
			Robot robot = null;
			try {
				robot = new Robot();
			} catch (AWTException e) {
				e.printStackTrace();
			}
			
			//ȡɫ - ��ӡ��ǰλ�õ���ɫ
			System.out.print(robot.getPixelColor(mousePoint.x, mousePoint.y).getRed() + "-");
			System.out.print(robot.getPixelColor(mousePoint.x, mousePoint.y).getGreen()+ "-");
			System.out.println(robot.getPixelColor(mousePoint.x, mousePoint.y).getBlue());
			System.out.print(mousePoint.x+"-");
			System.out.println(mousePoint.y);
			
			
			//�����������
			if (robot.getPixelColor(600, 300).getRed()==255 &&
				robot.getPixelColor(600, 300).getGreen()==255 &&
				robot.getPixelColor(600, 300).getBlue()==255
				
//				&& robot.getPixelColor(500, 150).getRed()==38
//				&& robot.getPixelColor(500, 150).getGreen()==66
//				&& robot.getPixelColor(500, 150).getBlue()==128
				) {
				System.out.println("�����������");
				//���ѡ������
				for (int j = 0; j < 10; j++) {
					robot.mouseMove(563, 460+j*10);
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					robot.delay(1000);
				}
				//����ر�
				robot.mouseMove(1043, 236);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.delay(1000);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			}
			//������ϣ���һ��
			int check=0;
			//[100,1000] [200,700]
			for (int x = 2; x <= 9; x++) {
				for (int y = 3; y <= 6; y++) {
					if (	robot.getPixelColor(x*100, y*100).getRed()==231 &&
							robot.getPixelColor(x*100, y*100).getGreen()==231 &&
							robot.getPixelColor(x*100, y*100).getBlue()==231
							) {
						robot.delay(100);
						check++;
						System.out.println(check+":"+x*100+"-"+y*100);
					}else {
						break;
					}
					
				}
			}
			if (check>10) {
					robot.mouseMove(100, 750);
					robot.delay(500);
					robot.mouseMove(70, 765);
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					robot.delay(1000);
				}
			
			
			 check=0;
			//[100,1000] [200,700]
			for (int x = 1; x <= 10; x++) {
				for (int y = 2; y <= 7; y++) {
					if (	robot.getPixelColor(x*100, y*100).getRed()==0 &&
							robot.getPixelColor(x*100, y*100).getGreen()==0 &&
							robot.getPixelColor(x*100, y*100).getBlue()==0
							) {
						robot.delay(100);
						check++;
						System.out.println(check+":"+x*100+"-"+y*100);
					}else {
						break;
					}
					
				}
			}
			if (check>50) {
					robot.mouseMove(100, 750);
					robot.delay(500);
					robot.mouseMove(70, 750);
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					robot.delay(1000);
				}
			
			
			robot.delay(200);
		}
		
		
		
	}
 
}
