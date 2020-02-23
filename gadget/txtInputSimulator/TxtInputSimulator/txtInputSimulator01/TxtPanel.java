package txtInputSimulator01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Robot;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;



public class TxtPanel {
	public JPanel txtPanel=null;
	JTextArea txtArea=null;
	private static Robot robot;  
	
	public TxtPanel() {
		super();
		MyPanel();
	}
	
	public void MyPanel() {
		
		/** 文本区面板 */
		 txtArea = new JTextArea(10, 15); 		// 创建一个 5 行 10 列的文本区域
		txtArea.setLineWrap(true);				// 设置自动换行
		String test1="`1234567890-=qwertyuiop[]\\asdfghjkl;\'zxcvbnm,./";
		String test2="~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\"ZXCVBNM<>?";
		txtArea.setText(test1+test2);
		
		JScrollPane txtSPanel=new JScrollPane();			
		txtSPanel.setViewportView(txtArea);
		
		this.txtPanel=new JPanel(new BorderLayout());
		this.txtPanel.add(txtSPanel);
	}
	
	public void input() {
		
		/** 创建Robot对象 */
		 try {  
			 robot = new Robot();				//创建Robot对象  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
		robot.delay(2000);
		char[] chArray=txtArea.getText().toCharArray();//获取每一个字符
		for (int i = 0;i < chArray.length; i++) {
			robot.delay(30);	//5毫秒敲击一个键
			int vk=charToVK(chArray[i]);
			if(vk!=-1) {	//先找只需要按一个键的，找到了就按下
				robot.keyPress(vk); 
				robot.keyRelease(vk);
			}
			else {			//找不到只需按一个键的，再到需要按 shift 的
				vk=charToVK2(chArray[i]);
				if (vk!=-1) {	//找到了就按下去找不到就什么也不做
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(vk); 
					robot.keyRelease(vk);
					robot.keyRelease(KeyEvent.VK_SHIFT);
				}
			}
			
			
		}
	}
	
	public int charToVK(char ch) {
		Integer vk=KeyEvent.VK_SPACE;
		Map<Character,Integer>  ch_VK = new HashMap<>();
		
		/** 空格、回车、tab */
		ch_VK.put(' ', KeyEvent.VK_SPACE);
		ch_VK.put('\t', KeyEvent.VK_TAB);
		ch_VK.put('\n', KeyEvent.VK_ENTER);

		
		ch_VK.put('0', KeyEvent.VK_0);
		ch_VK.put('1', KeyEvent.VK_1);
		ch_VK.put('2', KeyEvent.VK_2);
		ch_VK.put('3', KeyEvent.VK_3);
		ch_VK.put('4', KeyEvent.VK_4);
		ch_VK.put('5', KeyEvent.VK_5);
		ch_VK.put('6', KeyEvent.VK_6);
		ch_VK.put('7', KeyEvent.VK_7);
		ch_VK.put('8', KeyEvent.VK_8);
		ch_VK.put('9', KeyEvent.VK_9);

		ch_VK.put('a', KeyEvent.VK_A);
		ch_VK.put('b', KeyEvent.VK_B);
		ch_VK.put('c', KeyEvent.VK_C);
		ch_VK.put('d', KeyEvent.VK_D);
		ch_VK.put('e', KeyEvent.VK_E);
		ch_VK.put('f', KeyEvent.VK_F);
		ch_VK.put('g', KeyEvent.VK_G);
		ch_VK.put('h', KeyEvent.VK_H);
		ch_VK.put('i', KeyEvent.VK_I);
		ch_VK.put('j', KeyEvent.VK_J);
		ch_VK.put('k', KeyEvent.VK_K);
		ch_VK.put('l', KeyEvent.VK_L);
		ch_VK.put('m', KeyEvent.VK_M);
		ch_VK.put('n', KeyEvent.VK_N);
		ch_VK.put('o', KeyEvent.VK_O);
		ch_VK.put('p', KeyEvent.VK_P);
		ch_VK.put('q', KeyEvent.VK_Q);
		ch_VK.put('r', KeyEvent.VK_R);
		ch_VK.put('s', KeyEvent.VK_S);
		ch_VK.put('t', KeyEvent.VK_T);
		ch_VK.put('u', KeyEvent.VK_U);
		ch_VK.put('v', KeyEvent.VK_V);
		ch_VK.put('w', KeyEvent.VK_W);
		ch_VK.put('x', KeyEvent.VK_X);
		ch_VK.put('y', KeyEvent.VK_Y);
		ch_VK.put('z', KeyEvent.VK_Z);
		
		ch_VK.put('`', KeyEvent.VK_BACK_QUOTE);
		ch_VK.put('-', KeyEvent.VK_MINUS);
		ch_VK.put('=', KeyEvent.VK_EQUALS);
		ch_VK.put('[', KeyEvent.VK_OPEN_BRACKET);
		ch_VK.put(']', KeyEvent.VK_CLOSE_BRACKET);
		ch_VK.put('\\', KeyEvent.VK_BACK_SLASH);
		ch_VK.put(';', KeyEvent.VK_SEMICOLON);
		ch_VK.put('\'', KeyEvent.VK_QUOTE);
		ch_VK.put(',', KeyEvent.VK_COMMA);
		ch_VK.put('.', KeyEvent.VK_PERIOD);
		ch_VK.put('/', KeyEvent.VK_SLASH);
		
		return ch_VK.get(ch)==null? -1 :ch_VK.get(ch);
		
		
	}
	public int charToVK2(char ch) {
		Integer vk=KeyEvent.VK_SPACE;
		Map<Character,Integer>  ch_VK = new HashMap<>();
		
		ch_VK.put(')', KeyEvent.VK_0);
		ch_VK.put('!', KeyEvent.VK_1);
		ch_VK.put('@', KeyEvent.VK_2);
		ch_VK.put('#', KeyEvent.VK_3);
		ch_VK.put('$', KeyEvent.VK_4);
		ch_VK.put('%', KeyEvent.VK_5);
		ch_VK.put('^', KeyEvent.VK_6);
		ch_VK.put('&', KeyEvent.VK_7);
		ch_VK.put('*', KeyEvent.VK_8);
		ch_VK.put('(', KeyEvent.VK_9);

		ch_VK.put('A', KeyEvent.VK_A);
		ch_VK.put('B', KeyEvent.VK_B);
		ch_VK.put('C', KeyEvent.VK_C);
		ch_VK.put('D', KeyEvent.VK_D);
		ch_VK.put('E', KeyEvent.VK_E);
		ch_VK.put('F', KeyEvent.VK_F);
		ch_VK.put('G', KeyEvent.VK_G);
		ch_VK.put('H', KeyEvent.VK_H);
		ch_VK.put('I', KeyEvent.VK_I);
		ch_VK.put('J', KeyEvent.VK_J);
		ch_VK.put('K', KeyEvent.VK_K);
		ch_VK.put('L', KeyEvent.VK_L);
		ch_VK.put('M', KeyEvent.VK_M);
		ch_VK.put('N', KeyEvent.VK_N);
		ch_VK.put('O', KeyEvent.VK_O);
		ch_VK.put('P', KeyEvent.VK_P);
		ch_VK.put('Q', KeyEvent.VK_Q);
		ch_VK.put('R', KeyEvent.VK_R);
		ch_VK.put('S', KeyEvent.VK_S);
		ch_VK.put('T', KeyEvent.VK_T);
		ch_VK.put('U', KeyEvent.VK_U);
		ch_VK.put('V', KeyEvent.VK_V);
		ch_VK.put('W', KeyEvent.VK_W);
		ch_VK.put('X', KeyEvent.VK_X);
		ch_VK.put('Y', KeyEvent.VK_Y);
		ch_VK.put('Z', KeyEvent.VK_Z);
		
		ch_VK.put('~', KeyEvent.VK_BACK_QUOTE);
		ch_VK.put('_', KeyEvent.VK_MINUS);
		ch_VK.put('+', KeyEvent.VK_EQUALS);
		ch_VK.put('{', KeyEvent.VK_OPEN_BRACKET);
		ch_VK.put('}', KeyEvent.VK_CLOSE_BRACKET);
		ch_VK.put('|', KeyEvent.VK_BACK_SLASH);
		ch_VK.put(':', KeyEvent.VK_SEMICOLON);
		ch_VK.put('"', KeyEvent.VK_QUOTE);
		ch_VK.put('<', KeyEvent.VK_COMMA);
		ch_VK.put('>', KeyEvent.VK_PERIOD);
		ch_VK.put('?', KeyEvent.VK_SLASH);
		
		return ch_VK.get(ch)==null? -1 :ch_VK.get(ch);
		
		
	}
	
	
	
	
}
