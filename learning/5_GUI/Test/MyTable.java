/**
 * 
 */
package Test;
 
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
 
/**
 * @author duchao
 * 
 */
public class MyTable extends JTable {
	/**
	 * ���л�
	 */
	private static final long serialVersionUID = 1L;
	private int myRow = -1, myCol = -1;
	TableCellEditor myEditor;
 
	public void setComboCell(int r, int c, TableCellEditor ce) {
		this.myRow = r;
		this.myCol = c;
		this.myEditor = ce;
	}
 
	@Override
	public TableCellEditor getCellEditor(int row, int column) {
		System.out.println(row + "," + column + ";" + myRow + "," + myCol + "," + myEditor);
		if (row == myRow && column == myCol && myEditor != null)
			return myEditor;
		return super.getCellEditor(row, column);
	}
 
	public static void main(String[] args) {
		MyTable table = new MyTable();
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addColumn("A", new Object[] { "item1","item3" });
	    model.addColumn("B", new Object[] { "item2","item4" });
	    String[] values = new String[] { "1", "2", "3" };
	    MyComboBoxEditor iBoxEditor=new MyComboBoxEditor(values);
//	    JComboBox<String> repeat=new JComboBox<String>(values);	//�ظ�������ѡ��
	    table.setComboCell(1, 1, iBoxEditor);
	    
	    JScrollPane jp=new JScrollPane(table);
	    jp.setViewportView(table);
	    jp.setSize(400,300);
	    JFrame jf=new JFrame();
	    jf.getContentPane().add(jp);
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jf.setSize(400,300);
	    jf.setVisible(true);
	}
}