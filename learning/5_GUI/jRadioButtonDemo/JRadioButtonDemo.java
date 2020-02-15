package jRadioButtonDemo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JRadioButtonDemo {

	public static void main(String[] args)
	{
		JFrame jFrame=new JFrame();
		jFrame.setTitle("鼠标键盘模拟器");
		jFrame.setBounds(100, 100, 300, 500);
		jFrame.setLocationRelativeTo(null);	//窗体居中出现
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setResizable(false);	//不可缩放 
		JPanel jPanel = new JPanel();
		
		
		
		/** 核心代码 */
		//////////////////////////////////////////////////////////////////////////////////
		JRadioButton system;
		jPanel.add(system=new JRadioButton("系统界面",false));
		//////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		jFrame.add(jPanel);
		jFrame.setVisible(true);
		
		
		
		
		
	}
}
