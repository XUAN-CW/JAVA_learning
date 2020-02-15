package click;

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
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		/** 创建Robot对象 */
		 try {  
			 robot = new Robot();				//创建Robot对象  
         } catch (Exception e) {  
             e.printStackTrace();  
         }  
		 
//         /** 按下和释放alt键 - 调用菜单 */
//         robot.keyPress(KeyEvent.VK_ALT);		//按下alt键a
//         robot.keyRelease(KeyEvent.VK_ALT);		//释放alt键 
//         robot.delay(500);						//延迟500ms 
//         
//         /** 按下和释放回车键 - 打开file选项 */
//         robot.keyPress(KeyEvent.VK_ENTER);  	//按下alt键
//         robot.keyRelease(KeyEvent.VK_ENTER);	//释放alt键
//         robot.delay(500);						//延迟500ms
		 
//       robot.mouseMove(20,30);
		 robot.mouseMove(200,200);
		 
         robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
         robot.keyPress(KeyEvent.VK_A);
         
         robot.keyRelease(KeyEvent.VK_A);	
         robot.mouseRelease(InputEvent.BUTTON3_MASK);
         
         
        	
         //robot.mousePress(InputEvent.BUTTON1_MASK);
        // robot.mouseRelease(InputEvent.BUTTON1_MASK);
         
         
	}
}
