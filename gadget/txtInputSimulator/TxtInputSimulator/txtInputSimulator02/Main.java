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
 * ������ʹ��˵��
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
		//��ʼ����
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
		//ʹ��˵��
		JMenuItem instruction = new JMenuItem("ʹ��˵��");
		instruction.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"��ģ�������ַ����£�\n"
						+ "1234567890`~!@#$%^&*()_+[]\\;\',./{}|:\"<>?\n"
						+ "abcdefghijklnmopqrstuvwxyzABCDEFGHIJKLNMOPQRSTUVWXYZ\n"
						+ "�ո񡢻س���tab\n"
						+ "�������ַ��������ַ�����ģ������",
						"ʹ��˵��", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		bar.add(instruction);
		
		
		
		
		
		
		myFrame.setVisible(true);
		
		
	}
}
