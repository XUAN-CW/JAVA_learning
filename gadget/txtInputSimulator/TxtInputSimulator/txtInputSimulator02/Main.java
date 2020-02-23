package txtInputSimulator02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import txtInputSimulator02.MyFrame;
import txtInputSimulator02.TxtPanel;


/***
 * 增加了使用说明
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
		//开始输入
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
		//使用说明
		JMenuItem instruction = new JMenuItem("使用说明");
		instruction.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"可模拟输入字符如下：\n"
						+ "1234567890`~!@#$%^&*()_+[]\\;\',./{}|:\"<>?\n"
						+ "abcdefghijklnmopqrstuvwxyzABCDEFGHIJKLNMOPQRSTUVWXYZ\n"
						+ "空格、回车、tab\n"
						+ "除以上字符，其他字符不会模拟输入",
						"使用说明", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		bar.add(instruction);
		
		
		
		
		
		
		myFrame.setVisible(true);
		
		
	}
}
