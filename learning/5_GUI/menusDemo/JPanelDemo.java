package menusDemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JPanelDemo {
	
	public static void main(String[] args)
	{ 
		JPanel buttonJP=new JPanel();
		JRadioButton system;//ϵͳ����
        buttonJP.setBorder(BorderFactory.createTitledBorder("����������"));
        JPanel jp=new JPanel();//����һ����ѡ��ť�����
        jp.add(system=new JRadioButton("ϵͳ����",true));
	}
}
