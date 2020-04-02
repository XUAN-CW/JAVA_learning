package menusDemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenus extends JFrame{

	public MyMenus() {
		super();
		
		setTitle("�����Ǳ���");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		/** �����˵��� */
		JMenuBar menuBar = new JMenuBar();	// JMenuBar�ǷŲ˵���ĸ��,�ֳ�Ϊ�˵���
		setJMenuBar(menuBar);				// ���˵���������ڴ���Ĳ˵�����
	

		/** ������һ���˵����� */
		JMenu menu1 = new JMenu("1");							//JMenu menu1
		menuBar.add(menu1);
	
		JMenuItem menuItem1_1 = new JMenuItem("1-->1");			//JMenuItem menuItem1_1		=> ����ĩ�ˣ�������Ҷ�ӽ��
		menuItem1_1.addActionListener(new ItemListener());
		menu1.add(menuItem1_1);
	
		JMenu menu1_2 = new JMenu("1-->2");						//JMenu Menu1_2
		menu1.add(menu1_2);

		JMenuItem menuItem1_2_1 = new JMenuItem("1-->2-->1");	//JMenuItem menuItem1_2_1	=> ����ĩ�ˣ�������Ҷ�ӽ��
		menuItem1_2_1.addActionListener(new ItemListener());
		menu1_2.add(menuItem1_2_1);

		/** �����ڶ����˵����� */
		JMenu menu2 = new JMenu("2");
		menuBar.add(menu2);
	
		JMenu menu2_1 = new JMenu("2-->1");
		menu2.add(menu2_1);
	
		JMenuItem menuItem2_2 = new JMenuItem("2-->2");
		menuItem2_2.addActionListener(new ItemListener());
		menu2.add(menuItem2_2);
	
		JMenuItem menuItem2_1_2 = new JMenuItem("2_1_2");
		menuItem2_1_2.addActionListener(new ItemListener());
		menu2_1.add(menuItem2_1_2);
	
		
		/** ��������Ϊ�ɼ� */
		setVisible(true);
	}

	/** ʵ�ֶ��������ӿ� */ 
	public class ItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JMenuItem menuItem = (JMenuItem) arg0.getSource();
			System.out.println("��������ǲ˵�� " + menuItem.getText());
		}
	}
		
	public static void main(String[] args)
	{
		new MyMenus();
	}
}
