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
		/** ����Robot���� */
		 try {  
			 robot = new Robot();				//����Robot����  
         } catch (Exception e) {  
             e.printStackTrace();  
         }  
		 
//         /** ���º��ͷ�alt�� - ���ò˵� */
//         robot.keyPress(KeyEvent.VK_ALT);		//����alt��
//         robot.keyRelease(KeyEvent.VK_ALT);		//�ͷ�alt�� 
//         robot.delay(500);						//�ӳ�500ms 
//         
//         /** ���º��ͷŻس��� - ��fileѡ�� */
//         robot.keyPress(KeyEvent.VK_ENTER);  	//����alt��
//         robot.keyRelease(KeyEvent.VK_ENTER);	//�ͷ�alt��
//         robot.delay(500);						//�ӳ�500ms
		 
		 
		 robot.delay(1500);					//�ӳ�500ms 
		 
		 for (int i = 0; i < 20; i++) {
			robot.keyPress('\n');  	//����\n��
			robot.keyRelease('\n');	//�ͷ�\n��
			
			robot.delay(50);					//�ӳ�500ms 
		}
		 robot.keyPress(KeyEvent.VK_ENTER);  		//����alt��
		 robot.keyRelease(KeyEvent.VK_ENTER);	//�ͷ�alt��
		 
		 
		 
		 
		 
		 
         
         
	}
}
