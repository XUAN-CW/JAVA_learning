package tableDemo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class MyListDemo2 extends JFrame {
	
    Object[] TableDate=new Object[100];
    public MyListDemo2(){ 			// 实现构造方法
        super("RecorderOfWorkers"); // 首先调用父类JFrame的构造方法生成一个窗口
        MyTableModel myModel = new MyTableModel();// myModel存放表格的数据
        
        
        
        JTable table = new JTable(myModel);// 表格对象table的数据来源是myModel对象
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));//表格的显示尺寸
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	System.out.println(table.getSelectedRow());
            }
        });
        
        JComboBox c = new JComboBox<String>();
        c.addItem("是");
        c.addItem("否");
        c.setEditable(true);
        table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(c));
//        
//        table.add
        
        
        setBounds(100, 100, 590, 200);
           JScrollPane scrollpanel = new JScrollPane(table);     // 产生一个带滚动条的面板
           // 将带滚动条的面板添加入窗口中
        getContentPane().add(scrollpanel, BorderLayout.CENTER);     
    }
    
    
    
    
      class MyTableModel extends AbstractTableModel{
//    	  JTextField textField1=new JTextField();		//文本域
          String[] TableHead = {"序号","延时","位置","操作"};    //表格标题
          
     	 String[] time = new String[]{"1", "2", "5","10","20","50","100","无限"};
	     JComboBox<String> repeat=new JComboBox<String>(time);	//重复次数复选框
          
          //表格数据
          Object[][] TableDate = {
                {"1","2000","125,158","右键单击"},
                {"2","1500","178,159","右键双击"},
                {"3","1500","178,159","右键双击"},
                {"4","1500","178,159","右键双击"},
                {"5","1500","178,159","右键双击"},
                {"6","1500","178,159","右键双击"},
                };
          
          
        //获得列的数目
        public int getColumnCount() {
            return TableHead.length;    
        }
        //获得行的数目
        public int getRowCount() {
            return TableDate.length;
        }
        //获得标题列的数据,并将数据存放在字符串tablehead数组里
        public String getColumnName(int column) {
            return TableHead[column]; 
        }
        //获取某行某列数据,并将数据存放在object类tabledate数组里
        @Override
        public Object getValueAt(int row, int column) {            
            return TableDate[row][column];
        }
        //判断单元格类型
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        //将表格声明为可编辑状态,第一列不可编辑 
        public boolean isCellEditable(int row, int column) {
            if (column < 1) {
                return false;
            } else {
                return true;
            }
        }
        
        //改变某个数据
        public void setValueAt(Object value,int row ,int column) {
        	
            System.out.println("之前选中："+ row);
            System.out.println("改动在第" + row+ "行，第" + column+ "列，值变为：" + value);
            TableDate[row][column]=value;
        }
      }
    public static void main(String[] args) {
        MyListDemo2 frame = new MyListDemo2();
        
        
        
        frame.setVisible(true);
    }

}