package jRadioButtonDemo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JRadioButtonDemo {

	public static void main(String[] args)
	{
		JFrame jFrame=new JFrame();
		jFrame.setTitle("������ģ����");
		jFrame.setBounds(100, 100, 300, 500);
		jFrame.setLocationRelativeTo(null);	//������г���
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setResizable(false);	//�������� 
		JPanel jPanel = new JPanel();
		
		
		
		/** ���Ĵ��� */
		//////////////////////////////////////////////////////////////////////////////////
		JRadioButton system;
		jPanel.add(system=new JRadioButton("ϵͳ����",false));
		//////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		jFrame.add(jPanel);
		jFrame.setVisible(true);
		
		
		
		
		
	}
}
