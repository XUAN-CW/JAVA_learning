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
		setTitle("��������ģ����-�򻯰�");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);	//������г���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);	//�������� 
	}
	
	public static void main(String[] args) {
		/** �������� */
		View myFrame =new View();
		myFrame.setVisible(true);
	}
}
