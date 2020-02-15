package txtInputSimulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import txtInputSimulator01.TxtPanel;

public class View extends JFrame{
	public View() {
		super();
		initFrame();
	}
	
	private void initFrame() {
		setTitle("键盘输入模拟器-简化版");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);	//窗体居中出现
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);	//不可缩放 
	}
	
	public static void main(String[] args) {
		/** 创建窗体 */
		View myFrame =new View();
		myFrame.setVisible(true);
	}
}
