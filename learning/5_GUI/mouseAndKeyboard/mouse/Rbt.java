package mouse;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *	rbt --> robot 
 */

public class Rbt {
	private static Robot robot;  
	public static void main(String[] args)
	{
		/** 创建Robot对象 */
		 try {  
			 robot = new Robot();				//创建Robot对象  
         } catch (Exception e) {  
             e.printStackTrace();  
         }  
		 
		 
		 robot.mouseMove(200,200);
		 //双击 <=> 单击两下
		 robot.mousePress(InputEvent.BUTTON1_MASK);
         robot.mouseRelease(InputEvent.BUTTON1_MASK);
         robot.mousePress(InputEvent.BUTTON1_MASK);
         robot.mouseRelease(InputEvent.BUTTON1_MASK);
         
         
	}
}
