package tableDemo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;

public class ListDemo extends JFrame {
    
    public ListDemo(){ // ʵ�ֹ��췽��
        super("RecorderOfWorkers"); // ���ȵ��ø���JFrame�Ĺ��췽������һ������
        MyTableModel myModel = new MyTableModel();// myModel��ű�������
        JTable table = new JTable(myModel);// ������table��������Դ��myModel����
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));// ������ʾ�ߴ�     

        
        
           JScrollPane scrollpanel = new JScrollPane(table);     // ����һ���������������
           // �������������������봰����
        getContentPane().add(scrollpanel, BorderLayout.CENTER);     
        addWindowListener(new WindowAdapter() {// ע�ᴰ�ڼ�����
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
      class MyTableModel extends AbstractTableModel{
    	  
    	  JTextField textField1=new JTextField();		//�ı���
    	  //textField1.setColumns(10);
    	  //textField1.
    	  
          String[] TableHead = {"����","��ס��","����","��ѧ","�ܷ�","����","����"};    //������
          Object[][] TableDate = {
                {"һ��","����",new Integer(60),new Integer(80),new Integer(140),new Boolean(false),new Boolean(false)},
                {"����","����",new Integer(70),new Integer(80),new Integer(150),new Boolean(false),new Boolean(false)},
                };//�������
        String update = "�޸��ֶ�λ��Ϊ:";
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
        //���������Ϊ�ɱ༭״̬
        public boolean isCellEditable(int row, int column) {
             
            if (column < 0) {
                return false;
            } else {
                return true;
            }
        }
        //�ı�ĳ������
        public void setValueAt(Object value,int row ,int column) {
            boolean debug = true;
            if (debug) {
                System.out.println("Setting value at " + row + "," + column
                        + " to " + value + " (an instance of "
                        + value.getClass() + ")");
            }
            if (TableDate[0][column] instanceof Integer && !(value instanceof Integer)) {
                try {
                    TableDate[row][column] = new Integer(value.toString());
                    fireTableCellUpdated(row, column);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(ListDemo.this, "The \""
                            + getColumnName(column)
                            + "\" column accepts only integer values.");
                }
            } else{
                TableDate[row][column] = value;
                fireTableCellUpdated(row, column);
                }
            
            if (debug) {
                System.out.println("New value of data:");
                printDebugData();
            }
            
        }

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
        
      }
    public static void main(String[] args) {
        ListDemo frame = new ListDemo();
        frame.pack();
        frame.setVisible(true);
    }

}