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
		
		setTitle("这里是标题");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		/** 创建菜单栏 */
		JMenuBar menuBar = new JMenuBar();	// JMenuBar是放菜单的母版,又称为菜单栏
		setJMenuBar(menuBar);				// 将菜单栏对象放在窗体的菜单栏中
	

		/** 创建第一个菜单对象 */
		JMenu menu1 = new JMenu("1");							//JMenu menu1
		menuBar.add(menu1);
	
		JMenuItem menuItem1_1 = new JMenuItem("1-->1");			//JMenuItem menuItem1_1		=> 处于末端，类似于叶子结点
		menuItem1_1.addActionListener(new ItemListener());
		menu1.add(menuItem1_1);
	
		JMenu menu1_2 = new JMenu("1-->2");						//JMenu Menu1_2
		menu1.add(menu1_2);

		JMenuItem menuItem1_2_1 = new JMenuItem("1-->2-->1");	//JMenuItem menuItem1_2_1	=> 处于末端，类似于叶子结点
		menuItem1_2_1.addActionListener(new ItemListener());
		menu1_2.add(menuItem1_2_1);

		/** 创建第二个菜单对象 */
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
	
		
		/** 将窗体设为可见 */
		setVisible(true);
	}

	/** 实现动作监听接口 */ 
	public class ItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JMenuItem menuItem = (JMenuItem) arg0.getSource();
			System.out.println("您点击的是菜单项： " + menuItem.getText());
		}
	}
		
	public static void main(String[] args)
	{
		new MyMenus();
	}
}
