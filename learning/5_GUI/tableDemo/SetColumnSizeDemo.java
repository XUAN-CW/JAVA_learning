package tableDemo;

import java.awt.BorderLayout;
 
import javax.swing.*;
import javax.swing.table.*;
/**
 * 教你如何设置表格的列宽
 * @author Administrator
 *
 */
public class SetColumnSizeDemo extends JFrame {
	Object[][] data = {{"王鹏","001","69","87"},
			{"李斯","002","69","87"},
			{"全脂","003","69","87"},
			{"陆远","004","69","87"}};
	Object[] head = {"姓名","学号","科目1","科目2"};
	JTable jt;
	JScrollPane jsp;
	TableColumn column;
	public SetColumnSizeDemo() {
		jt = new JTable(data,head);
//		设置列表头不可别用户重新拖动排列
		jt.getTableHeader().setReorderingAllowed(false);
		jsp = new JScrollPane(jt);
//      JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS  此为系统的默认值   当调整某列宽时，此字段后的所有列宽都会跟着一起变动
//		JTable.AUTO_RESIZE_ALL_COLUMNS   当调整某列宽时，所有的字段的所有列宽都会跟着一起变动
//		JTable.AUTO_RESIZE_NEXT_COLUMN    当调整某列宽时，此字段后的下一列列宽都会跟着一起变动，其他列不变
//		JTable.AUTO_RESIZE_LAST_COLUMN    当调整某列宽时，最后一个字段列的列宽都会跟着一起变动，其他列不变
//		JTable.AUTO_RESIZE_OFF             当调整某列宽时，所有列列宽都不变
		
		
		final JButton btn = new JButton("按钮1");
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
	 * 设置列表某一列的宽度
	 * @param i
	 * @param width
	 */
	public static void setColumnSize(JTable table, int i, int preferedWidth, int maxWidth, int minWidth){
		//表格的列模型
		TableColumnModel cm = table.getColumnModel();
		//得到第i个列对象 
		TableColumn column = cm.getColumn(i);  
		column.setPreferredWidth(preferedWidth);
		column.setMaxWidth(maxWidth);
		column.setMinWidth(minWidth);
		}
 
}