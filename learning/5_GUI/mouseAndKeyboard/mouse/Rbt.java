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
		/** ����Robot���� */
		 try {  
			 robot = new Robot();				//����Robot����  
         } catch (Exception e) {  
             e.printStackTrace();  
         }  
		 
		 
		 robot.mouseMove(200,200);
		 //˫�� <=> ��������
		 robot.mousePress(InputEvent.BUTTON1_MASK);
         robot.mouseRelease(InputEvent.BUTTON1_MASK);
         robot.mousePress(InputEvent.BUTTON1_MASK);
         robot.mouseRelease(InputEvent.BUTTON1_MASK);
         
         
	}
}
