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
		JRadioButton system;//系统界面
        buttonJP.setBorder(BorderFactory.createTitledBorder("公共操作区"));
        JPanel jp=new JPanel();//放置一个单选按钮的面板
        jp.add(system=new JRadioButton("系统界面",true));
	}
}
