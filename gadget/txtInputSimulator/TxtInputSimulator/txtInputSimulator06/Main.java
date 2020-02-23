package txtInputSimulator06;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import txtInputSimulator06.MyFrame;

/***
 * 将 robot 独立了出来
 */

public class Main {
	public static void main(String[] args)
	{
		/** 创建窗体 */
		MyFrame myFrame =new MyFrame();
		myFrame.setVisible(true);
	}
}
