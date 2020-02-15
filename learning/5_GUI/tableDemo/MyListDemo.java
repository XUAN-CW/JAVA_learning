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

public class MyListDemo extends JFrame {
    
    public MyListDemo(){ 			// ʵ�ֹ��췽��
        super("RecorderOfWorkers"); // ���ȵ��ø���JFrame�Ĺ��췽������һ������
        MyTableModel myModel = new MyTableModel();// myModel��ű�������
        JTable table = new JTable(myModel);// ������table��������Դ��myModel����
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));//������ʾ�ߴ�    
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	System.out.println(table.getSelectedRow());
            }
        });
        
        JComboBox c = new JComboBox();
        c.addItem("��");
        c.addItem("��");
        c.setEditable(true);
        table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(c));
        
        
        
        
        
        
        
        
        
        setBounds(100, 100, 590, 200);
           JScrollPane scrollpanel = new JScrollPane(table);     // ����һ���������������
           // �������������������봰����
        getContentPane().add(scrollpanel, BorderLayout.CENTER);     
//        addWindowListener(new WindowAdapter() {// ע�ᴰ�ڼ�����
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });
    }
    
    
    
    
    
    
    
    
    
    
      class MyTableModel extends AbstractTableModel{
    	  JTextField textField1=new JTextField();		//�ı���
          String[] TableHead = {"���","��ʱ","λ��","����"};    //������
          
     	 String[] time = new String[]{"1", "2", "5","10","20","50","100","����"};
	     JComboBox<String> repeat=new JComboBox<String>(time);	//�ظ�������ѡ��
          
          //�������
          Object[][] TableDate = {
                {"1","2000","125,158","�Ҽ�����"},
                {"2","1500","178,159","�Ҽ�˫��"},
                {"2","1500","178,159","�Ҽ�˫��"},
                {"2","1500","178,159","�Ҽ�˫��"},
                {"2","1500","178,159","�Ҽ�˫��"},
                {"1","2000","125,158","�Ҽ�����"},
                {"2","1500","178,159","�Ҽ�˫��"},
                {"2","1500","178,159","�Ҽ�˫��"},
                {"2","1500","178,159","�Ҽ�˫��"},
                {"2","1500","178,159","�Ҽ�˫��"},{"1","2000","125,158","�Ҽ�����"},
                {"2","1500","178,159","�Ҽ�˫��"},
                {"2","1500","178,159","�Ҽ�˫��"},
                {"2","1500","178,159","�Ҽ�˫��"},
                {"2","1500","178,159","�Ҽ�˫��"},{"1","2000","125,158","�Ҽ�����"},
                {"2","1500","178,159","�Ҽ�˫��"},
                {"2","1500","178,159","�Ҽ�˫��"},
                {"2","1500","178,159","�Ҽ�˫��"},
                {"2","1500","178,159","�Ҽ�˫��"},
                };
          
          
        //����е���Ŀ
        public int getColumnCount() {
            return TableHead.length;    
        }
        //����е���Ŀ
        public int getRowCount() {
            return TableDate.length;
        }
        //��ñ����е�����,�������ݴ�����ַ���tablehead������
        public String getColumnName(int column) {
            return TableHead[column]; 
        }
        //��ȡĳ��ĳ������,�������ݴ����object��tabledate������
        @Override
        public Object getValueAt(int row, int column) {            
            return TableDate[row][column];
        }
        //�жϵ�Ԫ������
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        //���������Ϊ�ɱ༭״̬,��һ�в��ɱ༭ 
        public boolean isCellEditable(int row, int column) {
            if (column < 1) {
                return false;
            } else {
                return true;
            }
        }
        
        
        
        //�ı�ĳ������
        public void setValueAt(Object value,int row ,int column) {
        	
            System.out.println("֮ǰѡ�У�"+ row);
            System.out.println("�Ķ��ڵ�" + row+ "�У���" + column+ "�У�ֵ��Ϊ��" + value );
            TableDate[row][column]=value;
            /** ��ӡ�µ�ֵ */
//            System.out.println("New value of data:");
//            printDebugData();
        }
        
        
        
        
        
        
        //��ӡ������ݡ�/////////////////////////////////////////////////////////////////////////////////////
        private void printDebugData() {
                int numRows = getRowCount();
                int numCols = getColumnCount();
     
                for (int i = 0; i < numRows; i++) {
                    System.out.print(" row " + i + ":");
                    for (int j = 0; j < numCols; j++) {
                        System.out.print(" " + TableDate[i][j]);
                    }
                    System.out.println();
                }
                System.out.println("--------------------------");
         }
        //��ӡ������ݡ�/////////////////////////////////////////////////////////////////////////////////////
      }
    
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
    public static void main(String[] args) {
        MyListDemo frame = new MyListDemo();
        /** f.pack()��������һ����
			f.setSize(f.getPreferredSize());
			����û��f.pack()֮ǰ��f����Ĵ�С��(0,0)
			��������Ժ�f�Ĵ�С�ᱻ����Ϊ��Ѵ�С��Ҳ����prefrredSize  */
//        frame.pack();
        frame.setVisible(true);
    }

}