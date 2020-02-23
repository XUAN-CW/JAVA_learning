package txtInputSimulator04;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import txtInputSimulator04.MyFrame;

/***
 * 增加了保存文本功能 - 监听窗口关闭，窗口关闭时保存文件
 */

public class Main {
	public static void main(String[] args)
	{
		/** 创建窗体 */
		MyFrame myFrame =new MyFrame();
		myFrame.setVisible(true);
	}
}
