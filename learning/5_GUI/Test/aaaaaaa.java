package Test;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;

public class aaaaaaa extends JFrame {
private boolean DEBUG = true;

public aaaaaaa() { // ʵ�ֹ��췽��
super("RecorderOfWorkers"); // ���ȵ��ø���JFrame�Ĺ��췽������һ������
MyTableModel myModel = new MyTableModel();// myModel��ű�������
JTable table = new JTable(myModel);// ������table��������Դ��myModel����
table.setPreferredScrollableViewportSize(new Dimension(500, 70));// ������ʾ�ߴ�

// ����һ���������������
JScrollPane scrollPane = new JScrollPane(table);

// �������������������봰����
getContentPane().add(scrollPane, BorderLayout.CENTER);

addWindowListener(new WindowAdapter() {// ע�ᴰ�ڼ�����
public void windowClosing(WindowEvent e) {
System.exit(0);
}
});
}

// ��Ҫ��ʾ�ڱ���е����ݴ����ַ��������Object������
class MyTableModel extends AbstractTableModel {
// ����е�һ����Ҫ��ʾ�����ݴ�����ַ�������columnNames��
final String[] columnNames = { "First Name", "Position", "Telephone",
"MonthlyPay", "Married" };
// ����и��е����ݱ����ڶ�ά����data��
final Object[][] data = {
{ "Wangdong", "Executive", "01068790231", new Integer(5000),
new Boolean(false) },
{ "LiHong", "Secretary", "01069785321", new Integer(3500),
new Boolean(true) },
{ "LiRui", "Manager", "01065498732", new Integer(4500),
new Boolean(false) },
{ "ZhaoXin", "Safeguard", "01062796879", new Integer(2000),
new Boolean(true) },
{ "ChenLei", "Salesman", "01063541298", new Integer(4000),
new Boolean(false) } };

// ������������дAbstractTableModel�еķ���������Ҫ��;�Ǳ�JTable������ã��Ա��ڱ������ȷ����ʾ����������Ա������ݲ��õ��������ͼ���ǡ��ʵ�֡�

// ����е���Ŀ
public int getColumnCount() {
return columnNames.length;
}

// ����е���Ŀ
public int getRowCount() {
return data.length;
}

// ���ĳ�е����֣���Ŀǰ���е����ֱ������ַ�������columnNames��
public String getColumnName(int col) {
return columnNames[col];
}

// ���ĳ��ĳ�е����ݣ������ݱ����ڶ�������data��
public Object getValueAt(int row, int col) {
return data[row][col];
}

// �ж�ÿ����Ԫ�������
public Class getColumnClass(int c) {
return getValueAt(0, c).getClass();
}

// ���������Ϊ�ɱ༭��
public boolean isCellEditable(int row, int col) {

if (col < 2) {
return false;
} else {
return true;
}
}

// �ı�ĳ�����ݵ�ֵ
public void setValueAt(Object value, int row, int col) {
if (DEBUG) {
System.out.println("Setting value at " + row + "," + col
+ " to " + value + " (an instance of "
+ value.getClass() + ")");
}

if (data[0][col] instanceof Integer && !(value instanceof Integer)) {
try {
data[row][col] = new Integer(value.toString());
fireTableCellUpdated(row, col);
} catch (NumberFormatException e) {
JOptionPane.showMessageDialog(aaaaaaa.this, "The \""
+ getColumnName(col)
+ "\" column accepts only integer values.");
}
} else {
data[row][col] = value;
fireTableCellUpdated(row, col);
}

if (DEBUG) {
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
System.out.print(" " + data[i][j]);
}
System.out.println();
}
System.out.println("--------------------------");
}
}

public static void main(String[] args) {
aaaaaaa frame = new aaaaaaa();
frame.pack();
frame.setVisible(true);
}
}