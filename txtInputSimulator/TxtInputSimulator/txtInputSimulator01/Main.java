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
 * �ɼ���Ĺ��ܣ�
 * �ٱ༭���ĳ��ع��� - ��೷��20��
 * �����˵������Щ�ַ���������
 * �ܵ���˴�һ��������ı������ַ�->��⵽����ݼ�����ʼ����
 * 
 */

public class Main {
	public static void main(String[] args)
	{
		/** �������� */
		MyFrame myFrame =new MyFrame();
		
		/** �����ɻ������ı���� */
		TxtPanel txtPanel=new TxtPanel();
		myFrame.getContentPane().add(txtPanel.txtPanel);
		
		/** �˵��� */
		JMenuBar bar = new JMenuBar();	// JMenuBar�ǷŲ˵���ĸ��,�ֳ�Ϊ�˵���
		myFrame.setJMenuBar(bar);		// ���˵���������ڴ���Ĳ˵�����
		JMenuItem startInput = new JMenuItem("����˴�2��������ı������ַ�");
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
