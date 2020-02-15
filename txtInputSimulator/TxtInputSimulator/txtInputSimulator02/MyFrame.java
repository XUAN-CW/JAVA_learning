package txtInputSimulator02;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;


public class MyFrame extends JFrame{
	public MyFrame() {
		super();
		setTitle("键盘输入模拟器2.0");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);	//窗体居中出现
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
//		setResizable(false);	//不可缩放 
	}
}
