package tableDemo;

import java.awt.BorderLayout;
 
import javax.swing.*;
import javax.swing.table.*;
/**
 * ����������ñ����п�
 * @author Administrator
 *
 */
public class SetColumnSizeDemo extends JFrame {
	Object[][] data = {{"����","001","69","87"},
			{"��˹","002","69","87"},
			{"ȫ֬","003","69","87"},
			{"½Զ","004","69","87"}};
	Object[] head = {"����","ѧ��","��Ŀ1","��Ŀ2"};
	JTable jt;
	JScrollPane jsp;
	TableColumn column;
	public SetColumnSizeDemo() {
		jt = new JTable(data,head);
//		�����б�ͷ���ɱ��û������϶�����
		jt.getTableHeader().setReorderingAllowed(false);
		jsp = new JScrollPane(jt);
//      JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS  ��Ϊϵͳ��Ĭ��ֵ   ������ĳ�п�ʱ�����ֶκ�������п������һ��䶯
//		JTable.AUTO_RESIZE_ALL_COLUMNS   ������ĳ�п�ʱ�����е��ֶε������п������һ��䶯
//		JTable.AUTO_RESIZE_NEXT_COLUMN    ������ĳ�п�ʱ�����ֶκ����һ���п������һ��䶯�������в���
//		JTable.AUTO_RESIZE_LAST_COLUMN    ������ĳ�п�ʱ�����һ���ֶ��е��п������һ��䶯�������в���
//		JTable.AUTO_RESIZE_OFF             ������ĳ�п�ʱ���������п�����
		
		
		final JButton btn = new JButton("��ť1");
		jt.add(btn);
		setColumnSize(jt,1,30,30,30);
		
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		this.add(jt.getTableHeader(),BorderLayout.NORTH);
		
		
		this.add(jsp,BorderLayout.CENTER);
		this.setBounds(10, 100, 400, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new SetColumnSizeDemo();
	}
	
	/**
	 * �����б�ĳһ�еĿ��
	 * @param i
	 * @param width
	 */
	public static void setColumnSize(JTable table, int i, int preferedWidth, int maxWidth, int minWidth){
		//������ģ��
		TableColumnModel cm = table.getColumnModel();
		//�õ���i���ж��� 
		TableColumn column = cm.getColumn(i);  
		column.setPreferredWidth(preferedWidth);
		column.setMaxWidth(maxWidth);
		column.setMinWidth(minWidth);
		}
 
}