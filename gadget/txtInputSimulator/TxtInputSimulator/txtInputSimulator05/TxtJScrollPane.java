package txtInputSimulator05;

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



public class TxtJScrollPane extends JScrollPane{
	JTextArea txtArea=null;
	private Robot robot=null;  
	
	public TxtJScrollPane() {
		super();
		initTxtArea();
	}
	
	private void initTxtArea() {
		/** 文本区面板 */
		txtArea = new JTextArea(""); 		// 创建一个 5 行 10 列的文本区域
		txtArea.setLineWrap(true);				// 设置自动换行
//		txtArea.setText("~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\"ZXCVBNM<>?");
//		add(txtArea);
		setViewportView(txtArea);
	}
	

	public JTextArea getTxtArea() {
		return txtArea;
	}

	public void setTxtArea(JTextArea txtArea) {
		this.txtArea = txtArea;
	}

	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}
	
	
	
	
}
