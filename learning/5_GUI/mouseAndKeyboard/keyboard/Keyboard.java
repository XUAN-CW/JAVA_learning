package keyboard;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *	rbt --> robot 
 */

public class Keyboard {
	private static Robot robot;  
	public static void main(String[] args)
	{
		/** 创建Robot对象 */
		 try {  
			 robot = new Robot();				//创建Robot对象  
         } catch (Exception e) {  
             e.printStackTrace();  
         }  
		 
//         /** 按下和释放alt键 - 调用菜单 */
//         robot.keyPress(KeyEvent.VK_ALT);		//按下alt键
//         robot.keyRelease(KeyEvent.VK_ALT);		//释放alt键 
//         robot.delay(500);						//延迟500ms 
//         
//         /** 按下和释放回车键 - 打开file选项 */
//         robot.keyPress(KeyEvent.VK_ENTER);  	//按下alt键
//         robot.keyRelease(KeyEvent.VK_ENTER);	//释放alt键
//         robot.delay(500);						//延迟500ms
		 
		 
		 robot.delay(1500);					//延迟500ms 
		 
		 for (int i = 0; i < 20; i++) {
			robot.keyPress('\n');  	//按下\n键
			robot.keyRelease('\n');	//释放\n键
			
			robot.delay(50);					//延迟500ms 
		}
		 robot.keyPress(KeyEvent.VK_ENTER);  		//按下alt键
		 robot.keyRelease(KeyEvent.VK_ENTER);	//释放alt键
		 
		 
		 
		 
		 
		 
         
         
	}
}
