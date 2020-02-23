package txtInputSimulator01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import txtInputSimulator01.MyFrame;
import txtInputSimulator01.TxtPanel;


/***
 * 可加入的功能：
 * ①编辑区的撤回功能 - 最多撤回20条
 * ③软件说明：哪些字符可以输入
 * ④点击此处一秒后输入文本框中字符->检测到【快捷键】后开始输入
 * 
 */

public class Main {
	public static void main(String[] args)
	{
		/** 创建窗体 */
		MyFrame myFrame =new MyFrame();
		
		/** 创建可滑动的文本面板 */
		TxtPanel txtPanel=new TxtPanel();
		myFrame.getContentPane().add(txtPanel.txtPanel);
		
		/** 菜单栏 */
		JMenuBar bar = new JMenuBar();	// JMenuBar是放菜单的母版,又称为菜单栏
		myFrame.setJMenuBar(bar);		// 将菜单栏对象放在窗体的菜单栏中
		JMenuItem startInput = new JMenuItem("点击此处2秒后输入文本框中字符");
		startInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtPanel.input();
			}
		});
		bar.add(startInput);
		
		myFrame.setVisible(true);
		
		
	}
}
