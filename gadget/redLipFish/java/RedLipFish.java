package redLipFish.java;
/** 
 * 
 * 功能：用来做洛克王国红唇鱼活动，该活动要在一堆红色中找出所需的红色
		 如果颜色是红唇鱼的颜色，则发生鼠标点击事件，选中要选的红色，完成颜色选择的目的
 */
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;

public class RedLipFish {
	public static void main(String[] args) {
		while (true) {
			Point mousePoint = MouseInfo.getPointerInfo().getLocation();
			Robot robot = null;
			try {
				robot = new Robot();
			} catch (AWTException e) {
				e.printStackTrace();
			}
			
			//取色 - 打印当前位置的颜色
			System.out.print(robot.getPixelColor(mousePoint.x, mousePoint.y).getRed() + "-");
			System.out.print(robot.getPixelColor(mousePoint.x, mousePoint.y).getGreen()+ "-");
			System.out.println(robot.getPixelColor(mousePoint.x, mousePoint.y).getBlue());
			
			//如果是红唇鱼的颜色，则右键单击
			if(Math.abs(robot.getPixelColor(mousePoint.x, mousePoint.y).getRed()-215)<2 &&
					Math.abs(robot.getPixelColor(mousePoint.x, mousePoint.y).getGreen()-0)<2 &&
					Math.abs(robot.getPixelColor(mousePoint.x, mousePoint.y).getBlue()-31)<2 
					)
			{
				//System.out.println("-------------------------------------------------------------");
		       robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		       robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			}
			//间隔50毫秒
			try {
				Thread.sleep(50L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
 
	}
 
	}
